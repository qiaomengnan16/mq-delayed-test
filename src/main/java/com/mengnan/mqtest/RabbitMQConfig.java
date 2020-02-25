package com.mengnan.mqtest;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author qiaomengnan
 * @ClassName: RabbitMQConfig
 * @Description:
 * @date 2020-02-25
 */
@Configuration
public class RabbitMQConfig {


    static final String exchangeName = "test_exchange";
    static final String queueName = "test_queue";
    static final String routingKey = "test_queue";
    /**
     * 创建延迟队列
     */
    @Bean
    public Queue createQueue(){
        return QueueBuilder.durable(queueName).build();
    }

    /**
     * 创建路由
     */
    @Bean
    public CustomExchange createExchange(){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("x-delayed-type", "direct");
        return new CustomExchange(
                exchangeName, "x-delayed-message", true, false, map);
    }

    /**
     * 绑定路由与队列
     */
    @Bean
    public Binding exchangeBindingQueue(){
        return BindingBuilder.bind(createQueue()).
                to(createExchange()).with(routingKey).noargs();
    }

}
