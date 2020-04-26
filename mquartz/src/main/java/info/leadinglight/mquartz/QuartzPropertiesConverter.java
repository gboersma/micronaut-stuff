package info.leadinglight.mquartz;

import info.leadinglight.mutils.PropertiesUtil;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

@Singleton
public class QuartzPropertiesConverter {
    public Properties getPropertiesFromConfig() {
        Map<String,Object> quartzConfig = jobConfig.getQuartz();
        Properties properties = PropertiesUtil.getPropertiesFromConfigMap(quartzConfig, true);
        fixPropertyNames(properties);
        addDefaultProperties(properties);
        mapOtherProperties(properties);
        return properties;
    }

    private void fixPropertyNames(Properties properties) {
        PropertiesUtil.renameKey(properties,
            "org.quartz.dataSource.quartzDataSource.url",
            "org.quartz.dataSource.quartzDataSource.URL");
    }

    private void addDefaultProperties(Properties properties) {
        // TODO Other defaults.
        // Default value for jobFactory class must be the Micronaut Job Factory.
        PropertiesUtil.setPropertyIfNotDefined(properties,
            "org.quartz.scheduler.jobFactory.class",
            "info.leadinglight.mquartz.MicronautJobFactory");
    }

    private void mapOtherProperties(Properties properties) {
        // TODO Automatically map the datasource properties from a datasource with the same name.
        //  Pick up the name of the jobStore.dataSource property.
    }

    @Inject
    private JobConfiguration jobConfig;
}
