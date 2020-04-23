package info.leadinglight.mjob.scheduler;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.StdSchedulerFactory;

import javax.inject.Singleton;

@Singleton
public class QuartzSchedulerFactory {
    public Scheduler getScheduler() {
        try {
            // TODO Instead of creating a default scheduler that loads its properties from
            //  from a properties file, build the properties from the Micronaut config and pass it in.
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
            return scheduler;
        } catch (SchedulerException e) {
            throw new JobException("could not get scheduler", e);
        }
    }
}
