package info.leadinglight.mjob.greeting;

import info.leadinglight.mjob.scheduler.Job;
import info.leadinglight.mjob.scheduler.JobArguments;
import io.micronaut.context.annotation.Prototype;

@Prototype
public class GreetingJob implements Job {
    @Override
    public void execute(JobArguments args) {
        Object name = args.get("name", "world");
        System.out.println("Hello " + name + ", from the greeting job!");
    }
}
