package info.leadinglight.mutils;

import io.micronaut.context.ApplicationContext;
import io.micronaut.runtime.event.annotation.EventListener;
import io.micronaut.runtime.server.event.ServerStartupEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class EventHandler {
    @EventListener
    public void onStartup(ServerStartupEvent event) {
        // When we start up the application, we give the ApplicationContext to the BeanLocator.
        // This is the only way to get a handle to the ApplicationContext for non-bean classes.
        logger.info("Setting the application context on the ApplicationContextLocator...");
        ApplicationContextLocator.setApplicationContext(applicationContext);
    }

    @Inject
    private ApplicationContext applicationContext;

    Logger logger = LoggerFactory.getLogger(EventHandler.class);
}
