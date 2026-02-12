package net.java.springboot.kafka;

import net.java.springboot.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

/**
 * Service responsible for publishing JSON messages to Kafka.
 * It uses KafkaTemplate to send complex User objects as payload.
 */
@Service
public class JsonKafkaProducer {

    // ... logger and constructor ...
    private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaProducer.class);

    private KafkaTemplate<String, User> kafkaTemplate;

    public JsonKafkaProducer(KafkaTemplate<String, User> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    /**
     * Publishes a User object to the 'json-java-topic'.
     * The payload is wrapped in a Spring Message to include custom headers.
     * * @param data The User object to be sent.
     */
    public void sendMessage(User data){
        LOGGER.info(String.format("Message sent -> %s", data.toString()));

        Message<User> message = MessageBuilder
                .withPayload(data)
                .setHeader(KafkaHeaders.TOPIC, "json-java-topic")
                .build();

        kafkaTemplate.send(message);
    }
}
