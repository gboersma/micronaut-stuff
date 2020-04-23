package info.leadinglight.mjob.scheduler;

import io.micronaut.core.naming.NameUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class QuartzPropertiesConverter {
    public Properties getPropertiesFromConfigMap(Map<String,Object> configMap) {
        Map<String,String> flattenedConfigMap = new HashMap<>();
        flattenConfigMap(flattenedConfigMap, null, configMap);
        Properties properties = convertPropertyNames(flattenedConfigMap);
        addDefaultProperties(properties);
        mapOtherProperties(properties);
        return properties;
    }

    private void flattenConfigMap(Map<String,String> flattenedMap, String prefix, Map<String,Object> map) {
        for (String key: map.keySet()) {
            Object value = map.get(key);
            String keyPrefix = prefix != null ? prefix + "." + key : key;
            if (value instanceof Map) {
                // Recursively traverse the sub-map
                flattenConfigMap(flattenedMap, keyPrefix, (Map)value);
            } else {
                flattenedMap.put(keyPrefix, value.toString());
            }
        }
    }

    private Properties convertPropertyNames(Map<String,String> map) {
        Properties properties = new Properties();
        for (String key: map.keySet()) {
            String value = map.get(key);
            String correctKey = fixKey(key);
            properties.setProperty(correctKey, value);
        }
        return properties;
    }

    private String fixKey(String key) {
        // TODO Need to check for other Quartz properties that are not in standard form.
        String correctKey = NameUtils.camelCase(key);
        if (correctKey.equals("org.quartz.dataSource.quartzDataSource.url")) {
            return "org.quartz.dataSource.quartzDataSource.URL";
        } else {
            return correctKey;
        }
    }

    private void addDefaultProperties(Properties properties) {
        // TODO Other defaults.
        Set<String> names = properties.stringPropertyNames();
        // Default value for jobFactory class must be the Micronaut Job Factory.
        String name = "org.quartz.scheduler.jobFactory.class";
        if (!names.contains(name)) {
            properties.setProperty(name, "info.leadinglight.mjob.scheduler.MicronautJobFactory");
        }
    }

    private void mapOtherProperties(Properties properties) {
        // TODO Automatically map the datasource properties from a datasource with the same name.
        //  Pick up the name of the jobStore.dataSource property.
    }
}
