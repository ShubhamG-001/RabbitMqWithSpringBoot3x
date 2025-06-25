package com.example.consumer;

import com.example.config.RabbitMQConfig;
import com.example.entity.OrderDTO;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQConsumer {

    @RabbitListener(queues = RabbitMQConfig.QUEUE)
    public void consume(OrderDTO orderDTO){
        System.out.println("Consumer is able to consume message from queues "+orderDTO);
    }
}
