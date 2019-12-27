package com.tyss.trainingmaintenance.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.tyss.trainingmaintenance.dto.BatchIdGenerator;
import com.tyss.trainingmaintenance.dto.BatchInfo;
import com.tyss.trainingmaintenance.dto.CalendarEvent;
import com.tyss.trainingmaintenance.dto.Insert;
import com.tyss.trainingmaintenance.dto.ReadFile;
import com.tyss.trainingmaintenance.dto.Response;
import com.tyss.trainingmaintenance.service.ServiceDAO;

@RestController
@RequestMapping("/trainingmaintenance")
@CrossOrigin(origins="*",allowedHeaders="*",allowCredentials="true")
public class BatchController {
	
	@Autowired
	private ServiceDAO service;
	
	@Autowired
	private BatchIdGenerator generator;
	
//	@Autowired
//	private Insert insert;
	
	@Autowired
	private Response response;
	
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		CustomDateEditor editor = new CustomDateEditor(format, true);
		binder.registerCustomEditor(Date.class, editor);
	}


	
	
//	@PostMapping(path="/batch",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
//	public Response registerBatch(@RequestBody BatchInfo batch) {
//		Response response = new Response();
//		
//		if(generator.generate(batch)) {
//			BatchInfo info = service.addBatch(batch);
//			response.setStatusCode(200);
//			response.setMessage("Batch has been registered successfully");
//			response.setBatchCode(info.getBatchCode());
//		}
//		else{
//			response.setStatusCode(400);
//			response.setMessage("Batch registration failed");
//		}
//		
//		return response;
//	}
	
	
	@PostMapping(path="/batch",consumes=MediaType.MULTIPART_FORM_DATA_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public Response registerBatch(@RequestBody BatchInfo batch, @RequestHeader MultipartFile file) throws Exception {
		Response response = new Response();
		
		if(generator.generate(batch)) {
			BatchInfo info = service.addBatch(batch, file);
			response.setStatusCode(200);
			response.setMessage("Batch has been registered successfully");
			response.setBatchCode(info.getBatchCode());
		}
		else{
			response.setStatusCode(400);
			response.setMessage("Batch registration failed");
		}
		
		return response;
	}
	
//	@PostMapping(path="/uploadFileExcel",produces=MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.MULTIPART_FORM_DATA_VALUE)
//	public boolean uploadInDb(@RequestHeader MultipartFile file) throws Exception {
//		
//		if(service.uploadFile(file)) {
//		return true;
//	}	
//		return false;
//	}
	
	@PostMapping(path="/addEvent",produces=MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE)
	public Response addEvent(@RequestBody CalendarEvent eventDto,HttpServletRequest request) {
		if(service.addEvent(eventDto)!=null) {
			 response.setStatusCode(200);
				response.setMessage("Success");
				response.setDescription("Book Added");
				return response;
			}else {
				response.setStatusCode(400);
				response.setMessage("Failure");
				response.setDescription("Book Not Added");
				return response;
			}
		
	}
	
	
	@GetMapping(path="/getEvent",produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
//	public List<CalendarEvent> getAllUsers(HttpServletRequest request){
		public List<CalendarEvent> getAllEvent(){
		List<CalendarEvent> eventList= service.getAllEvent();
		if(eventList!=null) {
			response.setStatusCode(200);
			response.setMessage("Success");
			response.setDescription("All  Event List");
			response.setEvent(eventList);
			return eventList;
		}else {
			response.setStatusCode(400);
			response.setMessage("Failure");
			response.setDescription("Event is not present");
			return eventList;
		}
		 
		}
	
	

	
	
	
	
	
	@GetMapping(path="/getAllStudents",produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
//	public List<CalendarEvent> getAllUsers(HttpServletRequest request){
	 public List<ReadFile> getAllStudent(){
	    List<ReadFile> studentLis=service.getAllStudent();
		if(studentLis!=null) {
			response.setStatusCode(200);
			response.setMessage("Success");
			response.setDescription("All  Event List");
			response.setSfile(studentLis);
			return studentLis;
		}else {
			response.setStatusCode(400);
			response.setMessage("Failure");
			response.setDescription("Event is not present");
			return studentLis;
		}
		 
		}
	
	

}
