package info.leadinglight.mquartz.scheduler;

import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.spi.JobFactory;
import org.quartz.spi.TriggerFiredBundle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MicronautJobFactory implements JobFactory {
    public Job newJob(TriggerFiredBundle bundle, Scheduler Scheduler) throws SchedulerException {
        // We create the new job by getting the bean for the job from Micronaut.
        // TODO This avoids the reflection required for creating jobs, but there is still
        //  reflection for creating the factories and other Quartz components.
        //  Need to provide own implementation of SchedulerFactory for that.
        JobDetail jobDetail = bundle.getJobDetail();
        Class<? extends Job> jobClass = jobDetail.getJobClass();
        Job jobBean = MicronautLocator.getJobBean(jobClass);
        return jobBean;
    }

    private Logger logger = LoggerFactory.getLogger(MicronautJobFactory.class);
}
