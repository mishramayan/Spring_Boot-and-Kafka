package net.java.springboot.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * Service that listens for and processes incoming Kafka messages.
 */
@Service
public class KafkaConsumer {
    // ... logger ...
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

    /**
     * Subscriber method that triggers whenever a message is published to 'javatopic'.
     * * @param message The raw string message received from the broker.
     */
    @KafkaListener(topics = "javatopic", groupId = "myGroup")
    public void consume(String message){
        LOGGER.info(String.format("Message received -> %s", message));
    }
}
