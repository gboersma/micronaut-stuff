package info.leadinglight.mjob.scheduler;

import io.micronaut.core.naming.NameUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertiesConverter {
    // TODO Need to check for other Quartz properties that are not in standard form.
    // TODO Specify defaults.
    // TODO Automatically map the datasource properties.
    public Properties getPropertiesFromConfigMap(Map<String,Object> configMap) {
        Map<String,String> flattenedConfigMap = new HashMap<>();
        flattenConfigMap(flattenedConfigMap, null, configMap);
        Properties properties = convertPropertyNames(flattenedConfigMap);
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
        String correctKey = NameUtils.camelCase(key);
        if (correctKey.equals("org.quartz.dataSource.quartzDataSource.url")) {
            return "org.quartz.dataSource.quartzDataSource.URL";
        } else {
            return correctKey;
        }
    }
}
