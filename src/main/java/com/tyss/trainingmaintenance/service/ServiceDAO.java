package com.tyss.trainingmaintenance.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.tyss.trainingmaintenance.dto.BatchInfo;
import com.tyss.trainingmaintenance.dto.CalendarEvent;
import com.tyss.trainingmaintenance.dto.ReadFile;

public interface ServiceDAO {
	public BatchInfo addBatch(BatchInfo batch,MultipartFile file) throws IOException;
	public CalendarEvent addEvent(CalendarEvent event);
	public List<CalendarEvent> getAllEvent();
//	 public boolean uploadFile(MultipartFile file) throws IOException;
	 public List<ReadFile> getAllStudent();
}
