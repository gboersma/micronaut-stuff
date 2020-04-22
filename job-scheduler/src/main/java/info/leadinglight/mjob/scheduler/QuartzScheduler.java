package info.leadinglight.mjob.scheduler;

import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerKey;
import org.quartz.impl.StdSchedulerFactory;

import javax.inject.Singleton;
import java.util.Date;

/**
 * Provide a micronaut-friendly API to the Quartz Scheduler:
 * - Access it as a Micronaut bean.
 * - Convert checked exceptions into unchecked.
 */
@Singleton
public class QuartzScheduler {
    public Date scheduleJob(JobDetail jobDetail, Trigger trigger) {
        try {
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
            Date date = scheduler.scheduleJob(jobDetail, trigger);
            return date;
        } catch (SchedulerException e) {
            throw new JobException("could not schedule job", e);
        }
    }

    public boolean unscheduleJob(Trigger trigger) {
        try {
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
            boolean exists = scheduler.unscheduleJob(trigger.getKey());
            return exists;
        } catch (SchedulerException e) {
            throw new JobException("could not unschedule job", e);
        }
    }

    public Date rescheduleJob(Trigger trigger) {
        try {
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
            return scheduler.rescheduleJob(trigger.getKey(), trigger);
        } catch (SchedulerException e) {
            throw new JobException("could not reschedule job", e);
        }
    }

    public boolean checkExists(JobKey jobKey) {
        try {
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
            return scheduler.checkExists(jobKey);
        } catch (SchedulerException e) {
            throw new JobException("could not check if job exists", e);
        }
    }

    public boolean checkExists(TriggerKey triggerKey) {
        try {
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
            return scheduler.checkExists(triggerKey);
        } catch (SchedulerException e) {
            throw new JobException("could not check if trigger exists", e);
        }
    }
}
