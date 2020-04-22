package info.leadinglight.mjob.scheduler;

import io.micronaut.context.annotation.ConfigurationProperties;

@ConfigurationProperties("job")
public class JobConfiguration {
    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    private boolean enabled = Boolean.TRUE;
}
