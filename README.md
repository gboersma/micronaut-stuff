# micronaut-components

Libraries for helpful things in Micronaut.

## mquartz

Library that integrates Micronaut and Quartz:
* Implement Quartz jobs as Micronaut beans that support Micronaut injection.
* Quartz properties as standard Micronaut properties.

Why use Quartz? Micronaut provides support for managing tasks, but it is limited to a single server with no 
co-ordination across multiple servers. Quartz provides this. 
It is also solid, easily extensible, and everyone knows how to use it.

To run the sample:
* Create the database using the scripts in `etc` folder and start up the application.
You will see a job running every 10 seconds that accesses the database via JPA, to demonstrate
integration with Micronaut beans.

Future:
* Mapping between Quartz and Micronaut properties, e.g. database connection properties.
* Serialize job arguments in the database using JSON, not Java serialization.
* Replace Quartz's use of reflection for better GraalVM support.
* Better management of the schedule, e.g. scheduling / rescheduling jobs, version of jobs, etc.

## bean-lookup

Library to get access to Micronaut beans from non-Micronaut classes. 
Usually required when integrating with third-party libraries.

A reference to the `ApplicationContext` is given to a Java (not Micronaut) singleton 
when the application starts up. That can then be used to gain access to Micronaut beans, i.e. `getBean`
method calls.

To run the sample:
* Start the application, and do `curl http://localhost:8080/bean-lookup/bean` to have a bean
display a message using the standard `@Inject` mechanism. Do a 
`curl http://localhost:8080/bean-lookup/non-bean` to have a bean display the same message
using the `ApplicationContextLocator`.  
