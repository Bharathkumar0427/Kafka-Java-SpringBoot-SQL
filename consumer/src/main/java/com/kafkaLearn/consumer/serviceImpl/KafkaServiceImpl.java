package com.kafkaLearn.consumer.serviceImpl;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.RetryableTopic;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import com.kafka.models.MessageDto;
import com.kafkaLearn.consumer.entity.KafkaInfo;
import com.kafkaLearn.consumer.entity.service.KafkaService;
import com.kafkaLearn.consumer.repository.KafkaInfoRepository;

@Service
public class KafkaServiceImpl implements KafkaService {

	private final Logger logger = LoggerFactory.getLogger(KafkaServiceImpl.class);

	KafkaServiceImpl(KafkaInfoRepository kafkaInfoRepository) {
		this.kafkaInfoRepository = kafkaInfoRepository;

	}

	private KafkaInfoRepository kafkaInfoRepository;

	@Override
	@RetryableTopic(attempts = "4")
	@KafkaListener(topics = "Example", groupId = "my-group-id", containerFactory = "kafkaListenerContainerFactory")
	public void listen(@Payload MessageDto message) {
		logger.info("STARTED CONSUMER listen");
		try {
			KafkaInfo kfkaInfo = new KafkaInfo();
			kfkaInfo.setAge(StringUtils.isNoneBlank(message.getAge()) ? message.getAge() : null);
			kfkaInfo.setName(StringUtils.isNoneBlank(message.getName()) ? message.getName() : null);
			kfkaInfo.setStatus(StringUtils.isNoneBlank(message.getStatus()) ? message.getStatus() : null);

			KafkaInfo kfkaInfo1 = kafkaInfoRepository.save(kfkaInfo);

			if (StringUtils.isNotBlank(Integer.toString(kfkaInfo1.getId()))) {
				logger.info("SUCCESFULLY STORED DATA WITH ID {}", kfkaInfo1.getId());
			} else {
				logger.info("FAILED DATA {}", message);
			}

		} catch (Exception e) {
			logger.error("EXCEPTION IN listen", e);
		}

	}

}
