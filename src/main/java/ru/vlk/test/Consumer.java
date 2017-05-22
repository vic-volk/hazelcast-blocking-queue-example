package ru.vlk.test;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.BlockingQueue;

@Component
public class Consumer {

    private BlockingQueue<DeviceHandleTask> queue;

    @Autowired
    private TaskExecutor taskExecutor;

    @PostConstruct
    public void init() {
        HazelcastInstance hazelcastInstance = Hazelcast.newHazelcastInstance();
        queue = hazelcastInstance.getQueue("tasks");
    }

    public void consumeAndExecuteTasks() throws InterruptedException {
        DeviceHandleTask task = queue.take();
        taskExecutor.execute(task);
    }
}
