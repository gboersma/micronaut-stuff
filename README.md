# micronaut-jobs

A service for managing background jobs for a micronaut application.
Can be deployed as a stand-alone REST service or combined with another micronaut
application through an API. Provides a UI that calls the service through the REST api.

## server

Stand-alone Micronaut application. Provides a REST api as well as a Java API.
Can also be included in another Micronaut application as a JAR file, and accessed
directly through the Java API.

If combined with another application, the main application class needs to follow
the same pattern for managing the ApplicationContext.

## client

Client UI as SPA implemented in Angular + material. 

## Background and Status

Currently a work-in-progress. Any comments welcome.

Although this was written to demonstrate Micronaut and the RESTful server / static 
client pattern, it is intended to be a complete service that is suitable for 
production. It is written based on my experience with Spring Boot / Cloud in a 
production deployment.
