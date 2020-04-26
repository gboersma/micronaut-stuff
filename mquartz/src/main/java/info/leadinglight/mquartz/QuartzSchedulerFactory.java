package info.leadinglight.mquartz;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Map;
import java.util.Properties;

@Singleton
public class QuartzSchedulerFactory {
    public Scheduler getScheduler() {
        try {
            Properties properties = quartzPropertiesConverter.getPropertiesFromConfig();
            SchedulerFactory factory = new StdSchedulerFactory(properties);
            Scheduler scheduler = factory.getScheduler();
            return scheduler;
        } catch (SchedulerException e) {
            throw new JobException("could not get scheduler", e);
        }
    }

    @Inject
    private QuartzPropertiesConverter quartzPropertiesConverter;
}
