package info.leadinglight.sample;

import info.leadinglight.beanlookup.BeanLookup;

public class NonBean {
    public String greeting() {
        // Get a reference to the bean and get the greeting from it.
        Bean bean = BeanLookup.getApplicationContext().getBean(Bean.class);
        return bean.greeting() + " Provided to you courtesy of NonBean.";
    }
}
