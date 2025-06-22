package com.order_service.kafka_utils;

import com.order_service.payload.OrderPayload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderConsumer {

    private static final Logger LOGGER= LoggerFactory.getLogger(OrderConsumer.class);

    @KafkaListener(topics = "ordertopic",groupId = "order_group")
    public void consumeOrderMessage(OrderPayload orderPayload){
        LOGGER.info("message received:" +orderPayload.toString());
    }
}
