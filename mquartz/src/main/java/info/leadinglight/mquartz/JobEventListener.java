package info.leadinglight.mquartz;

import io.micronaut.context.ApplicationContext;
import io.micronaut.context.event.ShutdownEvent;
import io.micronaut.context.event.StartupEvent;
import io.micronaut.runtime.event.annotation.EventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;

public class JobEventListener {
    @EventListener
    public void onStartupEvent(StartupEvent event) {
        // We need to access the application context outside of micronaut beans.
        // Initialize the locator.
        MicronautLocator.setApplicationContext(applicationContext);

        // Start Quartz scheduler.
        if (jobManager.isEnabled()) {
            logger.info("Starting the Quartz scheduler...");
            jobManager.getQuartzScheduler().start();
        }
    }

    @EventListener
    public void onShutdownEvent(ShutdownEvent event) {
        if (jobManager.isEnabled()) {
            logger.info("Shutting down the Quartz scheduler...");
            jobManager.getQuartzScheduler().shutdown();
        }
    }

    @Inject
    private JobManager jobManager;

    @Inject
    private ApplicationContext applicationContext;

    Logger logger = LoggerFactory.getLogger(JobEventListener.class);
}
