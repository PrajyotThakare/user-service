package com.prajyot.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prajyot.user.serviceImpl.KafkaMessagePublisherServiceImpl;

@RestController
@RequestMapping("/kafka")
public class kafkaPublisherController {

	@Autowired
	private KafkaMessagePublisherServiceImpl kakfaService;

	@GetMapping("send/{message}")
	public ResponseEntity<?> status(@PathVariable String message) {

		try {
			kakfaService.sendStringToTopic(message);
			return ResponseEntity.ok("message published Successfully..");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

	}

	@GetMapping("/publish/{message}")
	public ResponseEntity<?> publishMessage(@PathVariable String message) {
		try {
			kakfaService.sendMessageToTopic(message);
			return ResponseEntity.ok("message published Successfully..");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
}
