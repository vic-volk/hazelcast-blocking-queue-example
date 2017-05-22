package ru.vlk.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

    private static ApplicationContext applicationContext;

    public static void main(String[] args) throws InterruptedException {
        applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        Producer producer = applicationContext.getBean(Producer.class);
        Consumer consumer = applicationContext.getBean(Consumer.class);

        producer.produceAndPutTasksToQueue();
        System.out.println("task in queue");
        Thread.sleep(4000);
        System.out.println("extracting...");
        consumer.consumeAndExecuteTasks();
    }

    public static ApplicationContext applicationContext() {
        return applicationContext;
    }
}
