package info.leadinglight.mjob.scheduler;

import org.quartz.JobKey;
import org.quartz.TriggerKey;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Provide access to Quartz scheduler and additional helper methods for managing jobs.
 */
@Singleton
public class JobManager {
    public QuartzScheduler getScheduler() {
        return quartzScheduler;
    }

    public boolean isJobScheduled(JobKey jobKey, TriggerKey triggerKey) {
        return quartzScheduler.checkExists(jobKey) && quartzScheduler.checkExists(triggerKey);
    }

    @Inject
    private QuartzScheduler quartzScheduler;
}
