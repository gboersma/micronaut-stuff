package info.leadinglight.micronaut.jobs.server.job;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class JobManager {
    public Jobs getAllJobs() {
        Jobs jobs = new Jobs();
        // TODO Limit the number of jobs returned.
        Iterable<Job> it = jobRepository.findAll();
        for (Job job: it) {
            jobs.add(job);
        }
        return jobs;
    }

    @Inject
    private JobRepository jobRepository;
}
