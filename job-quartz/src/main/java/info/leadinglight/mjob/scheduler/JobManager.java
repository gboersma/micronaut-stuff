package info.leadinglight.mjob.scheduler;

import org.quartz.Job;
import org.quartz.JobKey;
import org.quartz.TriggerKey;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Provide access to Quartz scheduler and additional helper methods for managing jobs.
 */
@Singleton
public class JobManager {
    public boolean isEnabled() {
        return jobConfig.isEnabled();
    }

    public boolean isJobScheduled(JobKey jobKey, TriggerKey triggerKey) {
        return quartzScheduler.checkExists(jobKey) && quartzScheduler.checkExists(triggerKey);
    }

    public QuartzScheduler getQuartzScheduler() {
        return quartzScheduler;
    }

    public void validateJobClass(Class<? extends Job> jobClass) {
        MicronautLocator.getJobBean(jobClass);
    }

    @Inject
    private QuartzScheduler quartzScheduler;

    @Inject
    private JobConfiguration jobConfig;
}
