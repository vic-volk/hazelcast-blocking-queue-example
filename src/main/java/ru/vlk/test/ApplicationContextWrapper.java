package ru.vlk.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.Serializable;

public class ApplicationContextWrapper implements Serializable {

    AnnotationConfigApplicationContext applicationContext;

    public ApplicationContextWrapper(AnnotationConfigApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }
}
