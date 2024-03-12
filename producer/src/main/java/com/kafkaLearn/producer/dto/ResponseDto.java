package com.kafkaLearn.producer.dto;

import java.io.Serializable;
import java.util.List;

public class ResponseDto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2194926500025669026L;

	private String status;
	
	private List<Object> obj;
	
	private Object obj1;
	
	private Object error;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Object> getObj() {
		return obj;
	}

	public void setObj(List<Object> obj) {
		this.obj = obj;
	}

	public Object getObj1() {
		return obj1;
	}

	public void setObj1(Object obj1) {
		this.obj1 = obj1;
	}

	public Object getError() {
		return error;
	}

	public void setError(Object error) {
		this.error = error;
	}
	
	
	

}
