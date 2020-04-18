package info.leadinglight.micronaut.jobs.custom;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller("/custom")
public class CustomController {
    @Get
    public String getInfo() {
        return "\"custom-server\"";
    }
}
