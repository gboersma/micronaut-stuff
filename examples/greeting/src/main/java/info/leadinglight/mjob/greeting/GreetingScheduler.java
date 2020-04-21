package info.leadinglight.mjob.greeting;

import info.leadinglight.mjob.scheduler.JobArguments;
import info.leadinglight.mjob.scheduler.JobScheduler;
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
    }

    @Inject
    private JobScheduler jobScheduler;
}
