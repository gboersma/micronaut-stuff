package info.leadinglight.micronaut.jobs.server.job;

import java.util.ArrayList;
import java.util.List;

public class Jobs {
    public List<Job> getAll() {
        return jobs;
    }

    public void setAll(List<Job> jobs) {
        this.jobs = jobs;
    }

    public void add(Job job) {
        this.jobs.add(job);
    }

    private List<Job> jobs = new ArrayList<>();
}
