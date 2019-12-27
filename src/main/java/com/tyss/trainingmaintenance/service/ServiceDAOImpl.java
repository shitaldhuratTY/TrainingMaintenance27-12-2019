package com.tyss.trainingmaintenance.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.tyss.trainingmaintenance.dao.BatchInfoDAO;
import com.tyss.trainingmaintenance.dao.CalendarEventDAO;
import com.tyss.trainingmaintenance.dto.BatchInfo;
import com.tyss.trainingmaintenance.dto.CalendarEvent;
import com.tyss.trainingmaintenance.dto.ReadFile;

@Service
public class ServiceDAOImpl implements ServiceDAO {
	
	@Autowired
	BatchInfoDAO dao;
	
	@Autowired
	CalendarEventDAO cdao;
	
//	@Override
//	public BatchInfo addBatch(BatchInfo batch) {
//		return dao.addBatch(batch);
//	}

	@Override
	public CalendarEvent addEvent(CalendarEvent event) {
		return cdao.addEvent(event);
	}

	@Override
	public List<CalendarEvent> getAllEvent() {
		return cdao.getAllEvent();
	}

//	@Override
//	public boolean uploadFile(MultipartFile file) throws IOException {
//		
//		return dao.uploadFile(file);
//	}

	@Override
	public List<ReadFile> getAllStudent() {
		
		return dao.getAllStudent();
	}

	@Override
	public BatchInfo addBatch(BatchInfo batch, MultipartFile file) throws IOException {
		
		return dao.addBatch(batch, file);
	}

	
	


}
