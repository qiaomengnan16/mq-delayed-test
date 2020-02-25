package com.mengnan.mqtest;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author qiaomengnan
 * @ClassName: DelayProducer
 * @Description:
 * @date 2020-02-25
 */
@Component
public class DelayProducer {

    @Autowired RabbitTemplate rabbitTemplate;

    public void sendMsg(){

        String msg = "测试延时de消息|"+ LocalDateTime.now();

        rabbitTemplate.convertAndSend(RabbitMQConfig.exchangeName, RabbitMQConfig.routingKey, msg, (message) ->{
            message.getMessageProperties().setHeader("x-delay", 9000); //延迟9秒
            return message;
        });


        rabbitTemplate.convertAndSend(RabbitMQConfig.exchangeName, RabbitMQConfig.routingKey, msg, (message) ->{
            message.getMessageProperties().setHeader("x-delay", 9000 * 2); //延迟9秒
            return message;
        });

        rabbitTemplate.convertAndSend(RabbitMQConfig.exchangeName, RabbitMQConfig.routingKey, msg, (message) ->{
            message.getMessageProperties().setHeader("x-delay", 9000 * 3); //延迟9秒
            return message;
        });

        rabbitTemplate.convertAndSend(RabbitMQConfig.exchangeName, RabbitMQConfig.routingKey, msg, (message) ->{
            message.getMessageProperties().setHeader("x-delay", 9000 * 4); //延迟9秒
            return message;
        });

    }

}
