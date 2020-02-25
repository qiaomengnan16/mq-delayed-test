package com.mengnan.mqtest;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author qiaomengnan
 * @ClassName: DelayConsumer
 * @Description:
 * @date 2020-02-25
 */
@Component
public class DelayConsumer {

    @RabbitListener(queues = "test_queue")
    public void receive(String msg) {
        System.out.println("接收到的消息:"+msg +"||"+ LocalDateTime.now());
    }

}
