package info.leadinglight.greeting;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class GreetingJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext)
        throws JobExecutionException {
        JobDataMap args = jobExecutionContext.getJobDetail().getJobDataMap();
        String name = args.getString("name") != null ? args.getString("name") : "world";
        greetingBean.greet(name);

        // Save some entities to the database.
        GreetingEntity greet1 = new GreetingEntity();
        greet1.setGreeting("Fred");
        greetingRepository.save(greet1);
        GreetingEntity greet2 = new GreetingEntity();
        greet2.setGreeting("George");
        greetingRepository.save(greet2);
        GreetingEntity greet3 = new GreetingEntity();
        greet3.setGreeting("John");
        greetingRepository.save(greet3);

        // Greet them all.
        for (GreetingEntity g: greetingRepository.findAll()) {
            greetingBean.greet(g.getGreeting());
        }

        // Delete them all.
        greetingRepository.deleteAll();
    }

    @Inject
    private GreetingBean greetingBean;

    @Inject
    private GreetingRepository greetingRepository;
}
