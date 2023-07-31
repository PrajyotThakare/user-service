package com.prajyot.user.serviceImpl;

import java.util.Random;
import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import com.prajyot.user.model.JsonObject;

@Service
public class KafkaMessagePublisherServiceImpl {

	public static final String KAFKA_TOPIC_NAME = "NewTopic";
	public static final String KAFKA_TOPIC_NAME2 = "NewJsonTopic";

	@Autowired
	private KafkaTemplate<String, Object> kafkaTemplate;

	Logger logger = LoggerFactory.getLogger(KafkaMessagePublisherServiceImpl.class);

	public void sendMessageToTopic(final String message) {
		
		int id = new Random().nextInt();
 		JsonObject obj = new JsonObject(id, message);
		CompletableFuture<SendResult<String, Object>> future = kafkaTemplate.send(KAFKA_TOPIC_NAME2, obj);

		future.whenComplete((result, ex) -> {
			if (ex == null) {
				logger.info("Sent messege [ " + message + " ] with offset =["
						+ String.valueOf(result.getRecordMetadata().offset()) + "]");
			} else {
				logger.info("Unable to send messege " + message + " due to : " + ex.getMessage());
			}
		});
		// There will be nothing to return in this case as this async operation and
		// execution will proceed without waiting for response
		System.out.println("Method Execution done");
	}

	public void sendStringToTopic(final String message) {
		CompletableFuture<SendResult<String, Object>> future = kafkaTemplate.send(KAFKA_TOPIC_NAME, message);

		future.whenComplete((result, ex) -> {
			if (ex == null) {
				logger.info("Sent messege [ " + message + " ] with offset =["
						+ String.valueOf(result.getRecordMetadata().offset()) + "]");
			} else {
				logger.info("Unable to send messege " + message + " due to : " + ex.getMessage());
			}
		});
		// There will be nothing to return in this case as this async operation and
		// execution will proceed without waiting for response
		System.out.println("Method Execution done");
	}

}
