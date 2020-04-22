package info.leadinglight.mjob.greeting;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import javax.inject.Singleton;

@Singleton
public class GreetingJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext)
        throws JobExecutionException {
        JobDataMap args = jobExecutionContext.getJobDetail().getJobDataMap();
        String name = args.getString("name") != null ? args.getString("name") : "world";
        System.out.println("Hello " + name + ", from the greeting job!");
    }
}
