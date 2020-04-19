package info.leadinglight.micronaut.jobs.server;

import info.leadinglight.micronaut.jobs.server.util.ApplicationContextLocator;
import io.micronaut.context.ApplicationContext;
import io.micronaut.context.event.ApplicationEventListener;
import io.micronaut.runtime.Micronaut;
import io.micronaut.runtime.server.event.ServerStartupEvent;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class Application implements ApplicationEventListener<ServerStartupEvent> {
    public static void main(String[] args) {
        Micronaut.run(Application.class, args);
    }

    @Override
    public void onApplicationEvent(ServerStartupEvent event) {
        // When we start up the application, we give the ApplicationContext to the BeanLocator.
        // This is the only way to get a handle to the ApplicationContext for non-bean classes.
        ApplicationContextLocator.setApplicationContext(applicationContext);
    }

    @Inject
    private ApplicationContext applicationContext;
}
