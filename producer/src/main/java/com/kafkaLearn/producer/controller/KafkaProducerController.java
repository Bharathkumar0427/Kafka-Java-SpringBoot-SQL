package com.kafkaLearn.producer.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.kafka.models.MessageDto;
import com.kafkaLearn.producer.dto.ResponseDto;
import com.kafkaLearn.producer.service.KafkaProducerService;

@RestController
@RequestMapping("/kproducer/")
public class KafkaProducerController {

	KafkaProducerController(KafkaProducerService kafkaProducerService) {
		this.kafkaProducerService = kafkaProducerService;
	}

	private KafkaProducerService kafkaProducerService;

	@PostMapping("uploaddata")
	public ResponseEntity<ResponseDto> triggerKafkaproducer(@RequestBody MessageDto messageDto) {
		ResponseDto responseDto = null;
		try {
			responseDto = kafkaProducerService.sendMessage("Example", messageDto);
		} catch (Exception e) {
			System.err.println(e);
		}

		return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
	}

}
