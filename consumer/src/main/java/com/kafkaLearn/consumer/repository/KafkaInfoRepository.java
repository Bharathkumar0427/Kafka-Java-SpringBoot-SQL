package com.kafkaLearn.consumer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kafkaLearn.consumer.entity.KafkaInfo;

@Repository
public interface KafkaInfoRepository extends JpaRepository<KafkaInfo, Integer>{

}
