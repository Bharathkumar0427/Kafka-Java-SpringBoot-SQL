package com.kafkaLearn.consumer.entity.service;

import org.springframework.messaging.handler.annotation.Payload;

import com.kafka.models.MessageDto;

public interface KafkaService {
	
	void listen(@Payload MessageDto message);

}
