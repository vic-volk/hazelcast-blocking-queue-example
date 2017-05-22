package ru.vlk.test;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.BlockingQueue;

@Component
public class Producer {

    private BlockingQueue<DeviceHandleTask> queue;

    @PostConstruct
    public void init() {
        HazelcastInstance hazelcastInstance = Hazelcast.newHazelcastInstance();
        queue = hazelcastInstance.getQueue("tasks");
    }

    public void produceAndPutTasksToQueue() throws InterruptedException {
        DeviceHandleTask task = new DeviceHandleTask();
        queue.put(task);
    }
}
