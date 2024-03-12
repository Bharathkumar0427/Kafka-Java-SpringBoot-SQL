package com.kafka.models.constants;

public enum ResoponseStatus {
	
	SUCCESS("SUCCESS"),FAILED("FAILED");
	
	private String status;
	ResoponseStatus(String val){
		this.status=val;
	}
	
	
	public String getvalue() {
		return this.status;
	}

}
