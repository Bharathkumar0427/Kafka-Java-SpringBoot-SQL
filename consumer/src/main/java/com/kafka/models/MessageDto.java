package com.kafka.models;

import java.util.Date;

import org.springframework.core.serializer.support.DeserializingConverter;

public class MessageDto  {
private String name;
	
	private String age;
	
	private String status;
	
	private Date date;

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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
}
