package net.java.springboot.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

/**
 * Configuration class to programmatically define Kafka topics.
 * These beans trigger the KafkaAdmin to create the topics if they do not exist.
 */
@Configuration
public class KafkaTopicConfig {

    /**
     * Topic for standard string-based messages.
     */
    @Bean
    public NewTopic javaTopic(){
        return TopicBuilder.name("javatopic")
                .build();
    }

    /**
     * Topic dedicated to JSON-serialized User objects.
     */
    @Bean
    public NewTopic jsonJavaTopic(){
        return TopicBuilder.name("json-java-topic")
                .build();
    }
}
