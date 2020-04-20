package info.leadinglight.micronaut.jobs.server.rest;

import info.leadinglight.micronaut.jobs.server.util.NotImplementedException;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller("/schedule")
public class ScheduleRestController {
    // TODO Query the job schedule.
    @Get
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
