package info.leadinglight.micronaut.jobs.server.rest;

import info.leadinglight.micronaut.jobs.server.job.Job;
import info.leadinglight.micronaut.jobs.server.job.JobManager;
import info.leadinglight.micronaut.jobs.server.job.Jobs;
import info.leadinglight.micronaut.jobs.server.util.NotImplementedException;

import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.Post;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller("/jobs")
public class JobsRestController {
    // TODO Document with Swagger.

    // TODO Query the jobs: by status (active, completed, aborted), timestamp, type (i.e. it's definition).
    @Get
    public List<JobDTO> queryJobs() {
        Jobs jobs = jobManager.getAllJobs();

        // Convert to DTOs
        List<JobDTO> dtos = new ArrayList<>();
        for (Job job: jobs.getAll()) {
            JobDTO dto = new JobDTO();
            dto.setId(job.getId());
            dto.setName(job.getName());
            dtos.add(dto);
        }
        return dtos;
    }

    // TODO See the detail for a job.
    @Get("/{jobId}")
    public void getJobDetails(@PathVariable("jobId") String jobId) {
        // TODO Query the database for the specified job.
        //  Separate table from Quartz tables.
        //  Queries any Quartz related stuff directly from Quartz as part of this service.
        throw new NotImplementedException("get detail for job " + jobId);
    }

    // TODO Get the log for a job.
    @Get("/{jobId}/log")
    public void getJobLog(@PathVariable("jobId") String jobId) {
        // TODO Query the database for the specified job.
        //  Get the log file. Return it as plain-text content.
        throw new NotImplementedException("get log for job " + jobId);
    }

    // TODO Stop a job.
    @Post("/stop/{jobId}")
    public String stopJob(@PathVariable("jobId") String jobId) {
        throw new NotImplementedException("stop job " + jobId);
    }

    // TODO Kick off a Job immediately.
    @Post("/launch/{jobConfigId}")
    public String launchJob(@PathVariable("jobConfigId") String jobConfigId, @Body Map<String,Object> variables) {
        throw new NotImplementedException("launch job " + jobConfigId + " with variables " + variables);
    }

    @Inject
    private JobManager jobManager;
}
