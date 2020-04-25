package info.leadinglight.beanlookup;

import io.micronaut.context.ApplicationContext;

/**
 * Wraps access to the ApplicationContext for situations where it cannot be injected.
 * Must be manually provided when the application starts up.
 */
public class BeanLookup {
    private static ApplicationContext applicationContext;

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public static void setApplicationContext(ApplicationContext applicationContext) {
        BeanLookup.applicationContext = applicationContext;
    }
}
