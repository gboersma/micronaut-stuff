package info.leadinglight.mjob.greeting;

import info.leadinglight.mjob.scheduler.JobManager;
import io.micronaut.context.event.ApplicationEventListener;
import io.micronaut.discovery.event.ServiceStartedEvent;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Trigger;
import org.quartz.TriggerKey;

import static org.quartz.JobBuilder.*;
import static org.quartz.TriggerBuilder.*;
import static org.quartz.SimpleScheduleBuilder.*;

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
            JobDetail job = newJob(GreetingJob.class)
                .withIdentity(jobKey)
                .usingJobData("name", "Harry")
                .build();
            Trigger trigger = newTrigger()
                .withIdentity(triggerKey)
                .startNow()
                .withSchedule(simpleSchedule()
                    .withIntervalInSeconds(5)
                    .repeatForever())
                .build();
            jobManager.getQuartzScheduler().scheduleJob(job, trigger);
        }
    }

    @Inject
    private JobManager jobManager;
}
