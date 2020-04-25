package info.leadinglight.mquartz.greeting;

import javax.inject.Singleton;

@Singleton
public class GreetingBean {
    public void greet(String name) {
        System.out.println("Hello " + name + ", from the greeting bean!");
    }
}
