package com.kafkaLearn.producer.service;

import com.kafka.models.MessageDto;
import com.kafkaLearn.producer.dto.ResponseDto;

public interface KafkaProducerService {
	
	ResponseDto sendMessage(String topic,MessageDto messageDto); 

}
