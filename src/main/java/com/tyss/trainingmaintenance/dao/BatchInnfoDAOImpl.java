package com.tyss.trainingmaintenance.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.tyss.trainingmaintenance.dto.BatchInfo;
import com.tyss.trainingmaintenance.dto.CalendarEvent;
import com.tyss.trainingmaintenance.dto.ReadFile;

@Repository
public class BatchInnfoDAOImpl implements  BatchInfoDAO {

	@PersistenceUnit
	private EntityManagerFactory factory;
	
//	@Override
//	public BatchInfo addBatch(BatchInfo batch) {
//		EntityManager manager = factory.createEntityManager();
//		EntityTransaction transaction = manager.getTransaction();
//		try {
//			transaction.begin();
//			manager.persist(batch);
//			transaction.commit();
//			return batch;
//		} catch (Exception e) {
//			manager.close();
//			e.printStackTrace();
//			return null;
//		}
//	}
	
	
	@Override
	public BatchInfo addBatch(BatchInfo batch, MultipartFile file) throws IOException {
		
		XSSFWorkbook workbook = new XSSFWorkbook(file.getInputStream());
		
		XSSFSheet firstSheet = workbook.getSheetAt(0);
		 
		 ReadFile readfile = new ReadFile();
		 
		 for (int i = 1; i <firstSheet.getPhysicalNumberOfRows() ; i++) {
			 XSSFRow row= (XSSFRow) firstSheet.getRow(i);
			 
			 readfile.setStudentId((int)row.getCell(0).getNumericCellValue());
			 readfile.setBatchName((row.getCell(1).getStringCellValue()));
			 readfile.setsFirstName((row.getCell(2).getStringCellValue()));
			 readfile.setsLastName((row.getCell(3).getStringCellValue()));
			 readfile.setUserId((int)row.getCell(4).getNumericCellValue());
			 readfile.setUserType((row.getCell(5).getStringCellValue()));
			 readfile.setPassword((row.getCell(6).getStringCellValue()));
			 readfile.setEmailId((row.getCell(7).getStringCellValue()));
			 readfile.setMobile((int)row.getCell(8).getNumericCellValue());
			 readfile.setGender((row.getCell(9).getStringCellValue()));
			 readfile.setHometown((row.getCell(10).getStringCellValue()));
			 readfile.setState((row.getCell(11).getStringCellValue()));
			 readfile.setTenthAggregate((int)row.getCell(12).getNumericCellValue());
			 readfile.setTwelthAggregate((int)row.getCell(13).getNumericCellValue());
			 readfile.setDegreeAggregate((int)row.getCell(14).getNumericCellValue());
			 readfile.setDegree((row.getCell(15).getStringCellValue()));
			 readfile.setDegreeStream((row.getCell(16).getStringCellValue()));
			 readfile.setDegreeYOP((int)row.getCell(17).getNumericCellValue());
			 readfile.setCollegeName((row.getCell(18).getStringCellValue()));
			 readfile.setCollegeLocation((row.getCell(19).getStringCellValue()));
			 
			 EntityManager manager = factory.createEntityManager();
			EntityTransaction transaction = manager.getTransaction();
		  
				 transaction.begin();
				 manager.persist(batch);
				 Query query= manager.createNativeQuery("INSERT INTO Students_Details(Student_Id,Batch_Name,First_Name, Last_Name, User_Id, User_Type,Password,Email_ID, Mobile, Gender,Hometown,State,10th_Aggregate,12th_Aggregate,Degree_Aggregate,Degree,Degree_Stream,Degree_YOP,College_Name,College_Location) VALUES (?,?, ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			

				 query.setParameter(1, readfile.getStudentId());
				 query.setParameter(2, readfile.getBatchName());
				 query.setParameter(3, readfile.getsFirstName());
				 query.setParameter(4, readfile.getsLastName());
				 query.setParameter(5, readfile.getUserId());
				 query.setParameter(6, readfile.getUserType());
				
				 query.setParameter(7, readfile.getPassword());
				 query.setParameter(8, readfile.getEmailId());
				
				 query.setParameter(9, readfile.getMobile());
				 query.setParameter(10, readfile.getGender());
				 query.setParameter(11, readfile.getHometown());
				 query.setParameter(12, readfile.getState());
				 query.setParameter(13, readfile.getTenthAggregate());
				 query.setParameter(14, readfile.getTwelthAggregate());
				 query.setParameter(15, readfile.getDegreeAggregate());
				 query.setParameter(16, readfile.getDegree());
				 query.setParameter(17, readfile.getDegreeStream());
				 query.setParameter(18, readfile.getDegreeYOP());
				 query.setParameter(19, readfile.getCollegeName());
				 query.setParameter(20, readfile.getCollegeLocation());
				
				 int count=query.executeUpdate();
				 System.out.println("Count update"+count);
		 			transaction.commit();
		 			 return batch;
		 			//System.out.println(readfile.getsFirstName()+" "+readfile.getsLastName()+" "+readfile.getsLocation());
		}

		
         System.out.println(readfile);
         System.out.println("File read");
        
		
		
		return null;
	}

//	@Override
//	public boolean uploadFile(MultipartFile file) throws IOException{
//		
//	
//	}

	@Override
	public List<ReadFile> getAllStudent() {
		EntityManager em = factory.createEntityManager();
		String queryStr2="from ReadFile";
		Query query=em.createQuery(queryStr2);
		return query.getResultList();
	}

	
	
	

		
}

