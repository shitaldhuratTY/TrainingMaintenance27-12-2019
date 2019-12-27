package com.tyss.trainingmaintenance.dao;

import java.util.List;

import com.tyss.trainingmaintenance.dto.BatchInfo;
import com.tyss.trainingmaintenance.dto.CalendarEvent;

public interface CalendarEventDAO {
	

	public CalendarEvent addEvent(CalendarEvent event);
	public List<CalendarEvent> getAllEvent();

}
