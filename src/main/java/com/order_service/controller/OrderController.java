package com.order_service.controller;

import com.order_service.kafka_utils.OrderProducer;
import com.order_service.payload.OrderPayload;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v3/order")
public class OrderController {

   private OrderProducer orderProducer;

    public OrderController(OrderProducer orderProducer) {
        this.orderProducer = orderProducer;
    }

    //http:localhost:8080/api/v3/order/publish
    @PostMapping("/publish")
    public ResponseEntity<OrderPayload> publish(@RequestBody OrderPayload orderPayload){
      orderProducer.sendOrderMessage(orderPayload);
        return new ResponseEntity<>(orderPayload, HttpStatus.OK);
    }
}
