package info.leadinglight.mjob.scheduler;

import io.micronaut.context.ApplicationContext;
import io.micronaut.inject.BeanDefinition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Collection;
import java.util.List;

@Singleton
public class JobScheduler {
    public ScheduledJob scheduleJob(String cron, Class<? extends JobDefinition> jobBeanType, JobArguments args) {
        JobDefinition jobDefinitionBean = applicationContext.getBean(jobBeanType);
        BeanDefinition<? extends JobDefinition> beanDef = applicationContext.getBeanDefinition(jobBeanType);
        ScheduledJob scheduledJob = new ScheduledJob();
        scheduledJob.setName(jobDefinitionBean.getName());
        scheduledJob.setDefinition(beanDef.getName());
        scheduledJob.setArgs(args);
        return jobScheduleManager.create(scheduledJob);
    }

    public ScheduledJob getScheduledJob(String id) {
        return jobScheduleManager.get(id);
    }

    public void executeJob(Class<? extends JobDefinition> jobBeanType) {
        JobArguments args = new JobArguments();
        executeJob(jobBeanType, args);
    }

    public void executeJob(Class<? extends JobDefinition> jobBeanType, JobArguments args) {
        JobDefinition jobDefinitionBean = applicationContext.getBean(jobBeanType);
        logger.info("I am executing a job...");
        jobDefinitionBean.execute(args);
    }

    public void executeJob(String className, JobArguments args) {
        Class<? extends JobDefinition> jobBeanType = getJobBeanTypeByClassName(className);
        if (jobBeanType == null) {
            throw new JobException("Job for class " + className + " not defined");
        }
        executeJob(jobBeanType, args);
    }

    public Class<? extends JobDefinition> getJobBeanTypeByClassName(String className) {
        Collection<BeanDefinition<JobDefinition>> jobBeanDefs = applicationContext.getBeanDefinitions(JobDefinition.class);
        for (BeanDefinition jobBeanDef: jobBeanDefs) {
            if (jobBeanDef.getName() != null && jobBeanDef.getName().equals(className)) {
                return jobBeanDef.getBeanType();
            }
        }
        return null;
    }

    public void executeJobs() {
        List<ScheduledJob> scheduledJobs = jobScheduleManager.getAll();
        for (ScheduledJob scheduledJob: scheduledJobs) {
            executeJob(scheduledJob.getDefinition(), scheduledJob.getArgs());
        }
    }

    @Inject
    private ApplicationContext applicationContext;

    @Inject
    private JobScheduleManager jobScheduleManager;

    private Logger logger = LoggerFactory.getLogger(JobScheduler.class);
}
