package com.kafkaLearn.consumer.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Id;

@Entity
@Table(name= "KAFKAINFO")
public class KafkaInfo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private  int Id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "age")
	private String age;
	
	
	
	@Column(name = "status")
	private String status;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
