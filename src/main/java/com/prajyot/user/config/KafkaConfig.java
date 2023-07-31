package com.prajyot.user.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import com.prajyot.user.serviceImpl.KafkaMessagePublisherServiceImpl;

@Configuration
public class KafkaConfig {

	@Bean
	public NewTopic newTopic() {
		return new NewTopic(KafkaMessagePublisherServiceImpl.KAFKA_TOPIC_NAME, 2 ,(short) 1);
	}
	
	@Bean
	public NewTopic newJsonTopic() {
		return new NewTopic(KafkaMessagePublisherServiceImpl.KAFKA_TOPIC_NAME2, 2 ,(short) 1);
	}
	
	@Bean
	public ProducerFactory<String, Object> producerFactory(){
		Map<String, Object> config = new HashMap<>();
		config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        return new DefaultKafkaProducerFactory<>(config);
	}
	
	 @Bean
	    public KafkaTemplate<String, Object> kafkaTemplate(){
	        return new KafkaTemplate<String, Object>(producerFactory());
	    }
}
