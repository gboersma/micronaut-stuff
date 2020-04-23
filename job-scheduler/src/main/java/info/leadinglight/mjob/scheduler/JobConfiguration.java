package info.leadinglight.mjob.scheduler;

import io.micronaut.context.annotation.ConfigurationProperties;
import io.micronaut.core.convert.format.MapFormat;

import java.util.Map;

@ConfigurationProperties("job")
public class JobConfiguration {
    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Map<String, Object> getQuartz() {
        return quartz;
    }

    public void setQuartz(Map<String, Object> quartz) {
        this.quartz = quartz;
    }

    private boolean enabled = Boolean.TRUE;
    private Map<String,Object> quartz;
}
