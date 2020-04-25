package info.leadinglight.mquartz.scheduler;

import io.micronaut.context.ApplicationContext;
import io.micronaut.context.exceptions.NoSuchBeanException;
import org.quartz.Job;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Wraps access to Micronaut beans for situations where it cannot be injected.
 * ApplicationContext must be manually provided when the application starts up.
 */
public class MicronautLocator {
    public static Job getJobBean(Class<? extends Job> jobClass) {
        try {
            Job jobBean = applicationContext.getBean(jobClass);
            return jobBean;
        } catch (NoSuchBeanException e) {
            String msg = "Could not instantiate Micronaut bean for job class "
                + jobClass.getName()
                + ". Did you declare your JobClass as a Bean?";
            logger.error(msg, e);
            throw new JobException(msg, e);
        }
    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public static void setApplicationContext(ApplicationContext applicationContext) {
        MicronautLocator.applicationContext = applicationContext;
    }

    private static ApplicationContext applicationContext;

    private static Logger logger = LoggerFactory.getLogger(MicronautLocator.class);
}
