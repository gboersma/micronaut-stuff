# micronaut-quartz-scheduler

Library that integrates Micronaut and Quartz:
* Implement Quartz jobs as Micronaut beans that support Micronaut injection.
* Quartz properties as standard Micronaut properties.

Micronaut provides support for managing tasks, but it is limited to a single server with no 
co-ordination across multiple servers.

Why use Quartz? Because it is solid, easily extensible, and everyone knows how to use it.

Use the following dependency:

        <dependency>
            <groupId>info.leadinglight.micronaut-quartz-scheduler</groupId>
            <artifactId>mquartz</artifactId>
            <version>1.0-SNAPSHOT</version>
        </dependency>

Check `samples` folder for examples of how to use.

Future:
* Mapping between Quartz and Micronaut properties, e.g. database connection properties.
* Serialize job arguments in the database using JSON, not Java serialization.
* Replace Quartz's use of reflection for better GraalVM support.
* Better management of the schedule, e.g. scheduling / rescheduling jobs, version of jobs, etc.
