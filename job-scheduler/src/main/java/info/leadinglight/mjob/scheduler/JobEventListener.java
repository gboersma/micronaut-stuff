package info.leadinglight.mjob.scheduler;

import io.micronaut.context.event.ShutdownEvent;
import io.micronaut.context.event.StartupEvent;
import io.micronaut.runtime.event.annotation.EventListener;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JobEventListener {
    @EventListener
    public void onStartupEvent(StartupEvent event) {
        try {
            // Startup Quartz when the app starts up.
            // Grab the Scheduler instance from the Factory
            logger.info("Starting up Quartz scheduler...");
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
            scheduler.start();
        } catch (SchedulerException e) {
            throw new JobException("could not start the scheduler", e);
        }
    }

    @EventListener
    public void onShutdownEvent(ShutdownEvent event) {
        try {
            // Shutdown Quartz when the app shuts down.
            // Grab the Scheduler instance from the Factory
            logger.info("Shutting up Quartz scheduler...");
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
            scheduler.shutdown();
        } catch (SchedulerException e) {
            throw new JobException("could not shutdown the scheduler", e);
        }
    }

    Logger logger = LoggerFactory.getLogger(JobEventListener.class);
}
