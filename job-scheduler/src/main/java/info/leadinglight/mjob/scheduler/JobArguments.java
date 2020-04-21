package info.leadinglight.mjob.scheduler;

import java.util.HashMap;
import java.util.Map;

public class JobArguments {
    public Object get(String name) {
        return args.get(name);
    }

    public Object get(String name, Object defaultValue) {
        return args.containsKey(name) ? args.get(name) : defaultValue;
    }

    public void put(String name, Object value) {
        args.put(name, value);
    }

    private Map<String,Object> args = new HashMap<>();
}
