package main.lab.config;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * The type Application config controller for getting ApplicationContext.
 */
public class ApplicationConfigController {

    private final static ApplicationContext applicationContext;

    static {
        applicationContext = new ClassPathXmlApplicationContext("WEB-INF/ApplicationConfigMain.xml");
    }

    /**
     * Gets application context.
     *
     * @return the application context
     */
    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }
}