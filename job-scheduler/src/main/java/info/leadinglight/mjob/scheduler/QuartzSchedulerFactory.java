package info.leadinglight.mjob.scheduler;

import io.micronaut.core.naming.NameUtils;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdScheduler;
import org.quartz.impl.StdSchedulerFactory;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.PropertyPermission;

@Singleton
public class QuartzSchedulerFactory {
    public Scheduler getScheduler() {
        try {
            Map<String,Object> quartzConfig = jobConfig.getQuartz();
            PropertiesConverter propertiesConverter = new PropertiesConverter();
            Properties properties = propertiesConverter.getPropertiesFromConfigMap(quartzConfig);
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
