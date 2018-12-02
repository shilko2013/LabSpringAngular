package com.shilko.ru.labspringangular.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * The type Application config controller for getting ApplicationContext.
 */
public class ApplicationConfigController {

    private final static ApplicationContext applicationContext;

    static {
        applicationContext = new ClassPathXmlApplicationContext("src/main/WEB-INF/ApplicationConfigMain.xml");
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
