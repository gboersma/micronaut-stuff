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
            Map<String,Object> quartzConfig = jobConfig.getQuartz();
            QuartzPropertiesConverter quartzPropertiesConverter = new QuartzPropertiesConverter();
            Properties properties = quartzPropertiesConverter.getPropertiesFromConfigMap(quartzConfig);
            SchedulerFactory factory = new StdSchedulerFactory(properties);
            Scheduler scheduler = factory.getScheduler();
            return scheduler;
        } catch (SchedulerException e) {
            throw new JobException("could not get scheduler", e);
        }
    }

    @Inject
    private JobConfiguration jobConfig;
}
