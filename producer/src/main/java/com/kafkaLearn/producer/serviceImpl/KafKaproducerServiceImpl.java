package com.kafkaLearn.producer.serviceImpl;

import java.util.concurrent.CompletableFuture;

import org.apache.kafka.common.internals.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import com.kafka.models.MessageDto;
import com.kafka.models.constants.ResoponseStatus;
import com.kafkaLearn.producer.dto.ResponseDto;
import com.kafkaLearn.producer.service.KafkaProducerService;

@Service
public class KafKaproducerServiceImpl implements KafkaProducerService{
	
	public KafKaproducerServiceImpl(KafkaTemplate<String, MessageDto> kafkaTemplate) {
		this.kafkaTemplate=kafkaTemplate;
		
	}
	
	 private KafkaTemplate<String,MessageDto> kafkaTemplate;
	 
	 

	@Override
	public ResponseDto sendMessage(String topic, MessageDto messageDto) {
		ResponseDto responseDto=new ResponseDto();
		
		try {
		CompletableFuture<SendResult<String, MessageDto>> future=kafkaTemplate.send(topic, messageDto);
		future.whenComplete((result,stack)->{
			if(stack ==null) {
				
				result.getRecordMetadata().offset();
				responseDto.setStatus(ResoponseStatus.SUCCESS.getvalue());
			//	responseDto.setObj1(result.getProducerRecord());
				
			}else {
				responseDto.setStatus(ResoponseStatus.FAILED.getvalue());
				responseDto.setStatus(stack.getMessage());
			}
			
			
		});
		}catch(Exception e) {
			System.out.println(e);
		}
		 return responseDto;
	}

}
