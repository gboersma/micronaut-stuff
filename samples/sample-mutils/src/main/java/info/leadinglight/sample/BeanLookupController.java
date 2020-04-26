package info.leadinglight.sample;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

import javax.inject.Inject;

@Controller("/bean-lookup")
public class BeanLookupController {
    @Get("/bean")
    public String getBeanGreeting() {
        return bean.greeting();
    }

    @Get("/non-bean")
    public String getNonBeanGreeting() {
        NonBean nonBean = new NonBean();
        return nonBean.greeting();
    }

    @Inject
    private Bean bean;
}
