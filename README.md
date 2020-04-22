# micronaut-job

Components for managing background jobs in Micronaut.

## job-scheduler

Takes care of scheduling and executing jobs across multiple servers using Quartz. 

Micronaut provides support for managing tasks, but it is limited to a single server with no 
co-ordination across multiple servers.

Extends Quartz with improvements for Micronaut:
* Quartz properties as standard Micronaut properties.
* Define jobs using Micronaut beans; no reflection for instantiating jobs.
* Serialize job arguments in the database using JSON, not Java serialization.

## job-history

Provides support for viewing details of jobs currently executing or have completed
execution.

## job-logging

Provides a logging mechanism for jobs.

## job-rest

Provides rest controllers.

## job-ui

Provides a static UI for managing jobs and the schedule.

## Background and Status

Currently a work-in-progress. Any comments welcome.

Although this was written to demonstrate Micronaut and the RESTful server / static 
client pattern, it is intended to be a complete service that is suitable for 
production. It is written based on my experience with Spring Boot / Cloud in a 
production deployment.
