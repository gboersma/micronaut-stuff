package info.leadinglight.micronaut.jobs.server.util;

import io.micronaut.context.ApplicationContext;

/**
 * Wraps access to the ApplicationContext for situations where it cannot be injected.
 * Must be manually provided when the application starts up.
 */
public class ApplicationContextLocator {
    private static ApplicationContext applicationContext;

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public static void setApplicationContext(ApplicationContext applicationContext) {
        ApplicationContextLocator.applicationContext = applicationContext;
    }
}
