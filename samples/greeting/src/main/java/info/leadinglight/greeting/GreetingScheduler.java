package info.leadinglight.greeting;

import info.leadinglight.mquartz.JobManager;
import info.leadinglight.mquartz.QuartzBuilder;
import io.micronaut.context.event.ApplicationEventListener;
import io.micronaut.discovery.event.ServiceStartedEvent;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerKey;

import javax.inject.Inject;

public class GreetingScheduler implements ApplicationEventListener<ServiceStartedEvent> {
    @Override
    public void onApplicationEvent(ServiceStartedEvent event) {
        // Validate that the Greeting Job is a valid micronaut beans.
        jobManager.validateJobClass(GreetingJob.class);
        // Schedule the job.
        JobKey jobKey = new JobKey("job1", "group1");
        TriggerKey triggerKey = new TriggerKey("trigger1", "group1");
        // Only schedule the job if it is not yet scheduled.
        if (!jobManager.isJobScheduled(jobKey, triggerKey)) {
            JobDetail job = QuartzBuilder.jobBuilder(GreetingJob.class, jobKey)
                .usingJobData("name", "Harry")
                .build();
            Trigger trigger = QuartzBuilder.triggerBuilder(triggerKey,
                SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(5).repeatForever())
                .build();
            jobManager.getQuartzScheduler().scheduleJob(job, trigger);
        }
    }

    @Inject
    private JobManager jobManager;
}
