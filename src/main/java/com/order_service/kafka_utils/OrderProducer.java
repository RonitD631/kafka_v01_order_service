package com.order_service.kafka_utils;

import com.order_service.payload.OrderPayload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class OrderProducer {

    private static final Logger LOGGER= LoggerFactory.getLogger(OrderProducer.class);

    private KafkaTemplate<String, OrderPayload> kafkaTemplate;

    public OrderProducer(KafkaTemplate<String, OrderPayload> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendOrderMessage(OrderPayload orderPayload){

        LOGGER.info(String.format("Order sent:"+orderPayload.toString()));

        Message<OrderPayload> message = MessageBuilder
                .withPayload(orderPayload)
                .setHeader(KafkaHeaders.TOPIC,"ordertopic")
                .build();

        kafkaTemplate.send(message);
    }
}
