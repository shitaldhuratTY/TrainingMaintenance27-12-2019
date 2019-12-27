package com.tyss.trainingmaintenance.dto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.br.TituloEleitoral;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Entity
@Table(name="Calendar_Event")
@Data
public class CalendarEvent {


	@Id	
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Event_Id")
	private int eventId;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name="EStart_Date")
    private LocalDate eStartDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name="EEnd_Date")
	/*
	 * @JsonFormat(pattern="dd-MM-yyyy")
	 */	private LocalDate eEndDate;
	
	 @Column(name="From_Time")
		@DateTimeFormat(pattern = "HH-mm")

	/*
	 * @JsonFormat(pattern="hh:mm")
	 */	private LocalTime fromTime;
	 
	 @Column(name="To_Time")
	/*
	 * @JsonFormat(pattern="hh:mm")
	 * 
	 */
		@DateTimeFormat(pattern = "HH-mm")
       
	 private LocalTime toTime;
	 
	 
	 public LocalDate geteStartDate() {
		return eStartDate;
	}

	public void seteStartDate(LocalDate eStartDate) {
		this.eStartDate = eStartDate;
	}

	public LocalDate geteEndDate() {
		return eEndDate;
	}

	public void seteEndDate(LocalDate eEndDate) {
		this.eEndDate = eEndDate;
	}

	public LocalTime getFromTime() {
		return fromTime;
	}

	public void setFromTime(LocalTime fromTime) {
		this.fromTime = fromTime;
	}

	public LocalTime getToTime() {
		return toTime;
	}

	public void setToTime(LocalTime toTime) {
		this.toTime = toTime;
	}

	@Column(name="ETechnology")
	 private String eTechnology;
	 
	 @Column(name="ETrainer")
	 private String eTrainer;

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}



	public String geteTechnology() {
		return eTechnology;
	}

	public void seteTechnology(String eTechnology) {
		this.eTechnology = eTechnology;
	}

	public String geteTrainer() {
		return eTrainer;
	}

	public void seteTrainer(String eTrainer) {
		this.eTrainer = eTrainer;
	}
	 
	 
}
