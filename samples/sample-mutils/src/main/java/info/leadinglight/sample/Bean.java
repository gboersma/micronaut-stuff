package info.leadinglight.sample;

import javax.inject.Singleton;

@Singleton
public class Bean {
    public String greeting() {
        return "Hello from Mr. Bean!";
    }
}
