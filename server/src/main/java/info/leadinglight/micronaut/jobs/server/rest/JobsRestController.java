package info.leadinglight.micronaut.jobs.server.rest;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller("/jobs")
public class JobsRestController {
    @Get("/info")
    public Info getInfo() {
        Info info = new Info();
        info.setName("micronaut-jobs");
        return info;
    }
}
