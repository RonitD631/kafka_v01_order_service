👨‍💻 Author
Ronit Dhal

# Kafka Order Producer Service

This is a Spring Boot project that acts as a Kafka producer. It exposes a REST API that accepts order details and publishes them to a Kafka topic (`ordertopic`).

## 🚀 Features

- REST API to publish order messages
- Kafka producer integration
- JSON serialization of `OrderPayload`
- Can be used in microservice architecture as a producer service

## 🔧 Technologies

- Java 17+
- Spring Boot 3.x
- Spring Kafka
- Kafka
- Postman

## 📦 Endpoint

### POST `/api/v3/order/publish`

**Request Body**:

```json
{
  "orderId": "ORD123456",
  "customerName": "Ronit Dhal",
  "product": "Apple MacBook Pro",
  "quantity": 2,
  "price": 2399.99,
  "orderDate": "2025-06-22T14:30:00"
}


Here both the Kafka producer & consumer are configured in the single project .
Message can be published by hitting the Rest API endpoint and giving a order payload from the Postman UI & in the terminal we can execute kafka command to verify the message published within the TOPIC
"ordertopic" .

✅ Step 1: Start Zookeeper and Kafka Server

🟢 Zookeeper:
bin/zookeeper-server-start.bat config/zookeeper.properties

🟢 Kafka Server:
bin/kafka-server-start.bat config/server.properties

✅ Step 2: Use Kafka Console Consumer to View Messages

bin/kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic ordertopic --from-beginning
