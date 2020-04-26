package info.leadinglight.mutils;

import io.micronaut.core.naming.NameUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Utility class for working with Micronaut properties.
 */
public class PropertiesUtil {
    /**
     * Convert the config map into Java properties.
     * Micronaut stores the name of all config settings in kebab-case.
     * Specify the camel-case flag to convert to camel case.
     */
    public static Properties getPropertiesFromConfigMap(Map<String,Object> configMap, boolean camelCase) {
        Map<String,String> flattenedConfigMap = flattenConfigMap(configMap);
        Properties properties = getPropertiesFromFlattenedConfigMap(flattenedConfigMap, camelCase);
        return properties;
    }

    public static void renameKey(Properties properties, String oldKey, String newKey) {
        properties.setProperty(newKey, properties.getProperty(oldKey));
        properties.remove(oldKey);
    }

    public static boolean setPropertyIfNotDefined(Properties properties, String key, String value) {
        if (!properties.containsKey(key)) {
            properties.setProperty(key, value);
            return true;
        } else {
            return false;
        }
    }

    /**
     * When getting properties from Micronaut as a generic map, the properties
     * are returned as a map of Name --> Property value OR embedded map.
     * This converts the config map to a map of name --> value, where the
     * name follows the . notation and the value is the string representation.
     */
    public static Map<String,String> flattenConfigMap(Map<String,Object> configMap) {
        Map<String,String> flattenedConfigMap = new HashMap<>();
        flattenConfigMap(flattenedConfigMap, null, configMap);
        return flattenedConfigMap;
    }

    private static void flattenConfigMap(Map<String,String> flattenedMap, String prefix, Map<String,Object> map) {
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

    public static Properties getPropertiesFromFlattenedConfigMap(Map<String,String> flattenedConfigMap, boolean camelCase) {
        Properties properties = new Properties();
        for (String key: flattenedConfigMap.keySet()) {
            String value = flattenedConfigMap.get(key);
            String correctKey = camelCase ? NameUtils.camelCase(key): key;
            properties.setProperty(correctKey, value);
        }
        return properties;
    }
}
