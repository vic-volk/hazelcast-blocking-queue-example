package ru.vlk.test;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@Scope("prototype")
public class DeviceHandleTask implements Serializable, Runnable {

    public void run() {
        System.out.println("test-" + Thread.currentThread().getName());
        System.out.println(App.applicationContext().getBean(AppConfig.class));
    }
}
