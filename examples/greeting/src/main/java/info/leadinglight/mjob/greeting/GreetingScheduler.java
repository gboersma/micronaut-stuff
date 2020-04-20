package info.leadinglight.mjob.greeting;

import info.leadinglight.mjob.scheduler.JobScheduler;
import io.micronaut.context.event.ApplicationEventListener;
import io.micronaut.discovery.event.ServiceStartedEvent;

import javax.inject.Inject;

public class GreetingScheduler implements ApplicationEventListener<ServiceStartedEvent> {
    @Override
    public void onApplicationEvent(ServiceStartedEvent event) {
        jobScheduler.scheduleJob();
    }

    @Inject
    private JobScheduler jobScheduler;
}
