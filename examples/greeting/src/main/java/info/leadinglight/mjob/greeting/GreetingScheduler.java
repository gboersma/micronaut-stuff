package info.leadinglight.mjob.greeting;

import info.leadinglight.mjob.scheduler.JobArguments;
import info.leadinglight.mjob.scheduler.JobScheduler;
import info.leadinglight.mjob.scheduler.ScheduledJob;
import io.micronaut.context.event.ApplicationEventListener;
import io.micronaut.discovery.event.ServiceStartedEvent;

import javax.inject.Inject;

public class GreetingScheduler implements ApplicationEventListener<ServiceStartedEvent> {
    @Override
    public void onApplicationEvent(ServiceStartedEvent event) {
        jobScheduler.executeJob(GreetingJob.class);
        JobArguments args = new JobArguments();
        args.put("name", "Harry");
        jobScheduler.executeJob(GreetingJob.class, args);
        jobScheduler.executeJob(GreetingJob.class.getName(), args);

        ScheduledJob scheduledJob = jobScheduler.scheduleJob("bleah", GreetingJob.class, args);
        System.out.println(scheduledJob);
        ScheduledJob scheduledJob2 = jobScheduler.getScheduledJob(scheduledJob.getId());
        System.out.println(scheduledJob2);
        jobScheduler.executeJobs();
    }

    @Inject
    private JobScheduler jobScheduler;
}
