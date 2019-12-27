package com.tyss.trainingmaintenance.dto;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Response {
	

	@Override
	public String toString() {
		return "Response [statusCode=" + statusCode + ", message=" + message + ", batchCode=" + batchCode
				+ ", description=" + description + ", event=" + event + ", getDescription()=" + getDescription()
				+ ", getBatchCode()=" + getBatchCode() + ", getStatusCode()=" + getStatusCode() + ", getMessage()="
				+ getMessage() + ", getEvent()=" + getEvent() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
	private int statusCode;
	private String message;
	private String batchCode;
	private String description;
	private List<CalendarEvent> event;
	private List<ReadFile> sfile;
	
	
	public List<ReadFile> getSfile() {
		return sfile;
	}
	public void setSfile(List<ReadFile> sfile) {
		this.sfile = sfile;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getBatchCode() {
		return batchCode;
	}
	public void setBatchCode(String batchCode) {
		this.batchCode = batchCode;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<CalendarEvent> getEvent() {
		return event;
	}
	public void setEvent(List<CalendarEvent> event) {
		this.event = event;
	}
	
	
	
}
