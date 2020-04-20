package info.leadinglight.mjob.scheduler;

import javax.inject.Singleton;

@Singleton
public class JobScheduler {
    public void scheduleJob() {
        System.out.println("I am scheduling a Job...");
    }
}
