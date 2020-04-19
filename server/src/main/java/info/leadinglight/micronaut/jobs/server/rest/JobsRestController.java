package info.leadinglight.micronaut.jobs.server.rest;

import info.leadinglight.micronaut.jobs.server.util.NotImplementedException;

import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.Post;

import java.util.Map;

@Controller("/jobs")
public class JobsRestController {
    // TODO Document with Swagger.

    @Get
    public String root() {
        return "\"micronaut-jobs\"";
    }

    // TODO Query the jobs: by status (active, completed, aborted), timestamp, type (i.e. it's definition).
    @Get("/query")
    public void queryJobs() {
        // TODO Query the database for all jobs.
        //  Separate table from Quartz tables.
        //  Queries any Quartz related stuff directly from Quartz as part of this service.
        throw new NotImplementedException("query all jobs");
    }

    // TODO See the detail for a job.
    @Get("/detail/{jobId}")
    public void getJobDetails(@PathVariable("jobId") String jobId) {
        // TODO Query the database for the specified job.
        //  Separate table from Quartz tables.
        //  Queries any Quartz related stuff directly from Quartz as part of this service.
        throw new NotImplementedException("get detail for job " + jobId);
    }

    // TODO Get the log for a job.
    @Get("/log/{jobId}")
    public void getJobLog(@PathVariable("jobId") String jobId) {
        // TODO Query the database for the specified job.
        //  Get the log file. Return it as plain-text content.
        throw new NotImplementedException("get log for job " + jobId);
    }

    // TODO Kick off a Job immediately.
    @Post("/launch/{jobConfigId}")
    public String launchJob(@PathVariable("jobConfigId") String jobConfigId, @Body Map<String,Object> variables) {
        throw new NotImplementedException("launch job " + jobConfigId + " with variables " + variables);
    }

    // TODO Stop a job.
    @Post("/stop/{jobId}")
    public String stopJob(@PathVariable("jobId") String jobId) {
        throw new NotImplementedException("stop job " + jobId);
    }

    // TODO Query the job schedule.
    @Get("/schedule")
    public void querySchedule() {
        throw new NotImplementedException("query the job schedule");
    }

    // TODO Get the details for a scheduled job, including stats.


    // TODO Schedule a job.
    // TODO Modify the schedule for a job.
    // TODO Remove a job from the schedule.
    // TODO Disable a scheduled job.
    // TODO Query the audit log: by job id.
    // TODO Clear out completed jobs, i.e. no longer see them in the list; including the log files.

    // TODO All queries support paging through the results.
    //  Return a maximum number of results.
}
