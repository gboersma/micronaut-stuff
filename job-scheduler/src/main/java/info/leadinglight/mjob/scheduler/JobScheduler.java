package info.leadinglight.mjob.scheduler;

import io.micronaut.context.ApplicationContext;
import io.micronaut.inject.BeanDefinition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Collection;

@Singleton
public class JobScheduler {
    public void scheduleJob(String cron, Class<? extends Job> jobBeanType) {
        logger.info("I am scheduling a Job...");
    }

    public void executeJob(Class<? extends Job> jobBeanType) {
        JobArguments args = new JobArguments();
        executeJob(jobBeanType, args);
    }

    public void executeJob(Class<? extends Job> jobBeanType, JobArguments args) {
        Job jobBean = applicationContext.getBean(jobBeanType);
        logger.info("I am executing a job...");
        jobBean.execute(args);
    }

    public void executeJob(String className, JobArguments args) {
        Class<? extends Job> jobBeanType = getJobBeanTypeByClassName(className);
        if (jobBeanType == null) {
            throw new JobException("Job for class " + className + " not defined");
        }
        executeJob(jobBeanType, args);
    }

    public Class<? extends Job> getJobBeanTypeByClassName(String className) {
        Collection<BeanDefinition<Job>> jobBeanDefs = applicationContext.getBeanDefinitions(Job.class);
        for (BeanDefinition jobBeanDef: jobBeanDefs) {
            if (jobBeanDef.getName() != null && jobBeanDef.getName().equals(className)) {
                return jobBeanDef.getBeanType();
            }
        }
        return null;
    }

    @Inject
    private ApplicationContext applicationContext;

    private Logger logger = LoggerFactory.getLogger(JobScheduler.class);
}
