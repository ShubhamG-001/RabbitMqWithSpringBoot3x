package com.example.producer;

import com.example.config.RabbitMQConfig;
import com.example.entity.Order;
import com.example.entity.OrderDTO;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RMQProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostMapping("/order")
    public OrderDTO placeOrder(@RequestBody Order order){
        OrderDTO orderDTO = new OrderDTO(order,"Order Placed","Hi Producer your order is placed");

        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE, RabbitMQConfig.ROUTING_KEY, orderDTO);

        return orderDTO;
    }

}
