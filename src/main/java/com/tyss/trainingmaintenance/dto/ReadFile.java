package com.tyss.trainingmaintenance.dto;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Students_Details")
public class ReadFile {
	



	@Id	
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Student_Id")
	private int studentId;
	
	@Column(name="Batch_Name")
	private String batchName;
	
	@Column(name="First_Name ")
	private String sFirstName;
	
	@Column(name="Last_Name")
	private String sLastName;
	
	@Column(name="User_Id")
	private int userId;
	
	@Column(name="User_Type")
	private String userType;
	
	
	@Column(name="Password")
	private String password;
	
	@Column(name="Email_ID")
	private String emailId;
	
	@Column(name="Mobile")
	private int mobile;
	
	@Column(name="Gender")
	private String gender;
       
	@Column(name="Hometown")
	private String hometown;
	 
	@Column(name="State")
	private String state; 
	
	@Column(name="10th_Aggregate")
	private int tenthAggregate;
	
	@Column(name="12th_Aggregate")
	private int twelthAggregate;
	
	@Column(name="Degree_Aggregate")
	private int degreeAggregate; 
	
	@Column(name="Degree")
	private String degree; 
	
	@Column(name="Degree_Stream")
	private String degreeStream;
	
	@Column(name=" Degree_YOP")
	private int  degreeYOP;  
	
	@Column(name="College_Name")
	private String collegeName; 
	
	@Column(name="College_Location")
	private String collegeLocation;
	
	@ManyToOne
	@JoinColumn(name = "Batch_Code")
	private BatchInfo info;

	public int getStudentId() {
		return studentId;
	}


	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}


	public String getsFirstName() {
		return sFirstName;
	}


	public void setsFirstName(String sFirstName) {
		this.sFirstName = sFirstName;
	}


	public String getsLastName() {
		return sLastName;
	}


	public void setsLastName(String sLastName) {
		this.sLastName = sLastName;
	}


	public String getBatchName() {
		return batchName;
	}


	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}


	public String getUserType() {
		return userType;
	}


	public void setUserType(String userType) {
		this.userType = userType;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getEmailId() {
		return emailId;
	}


	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}


	public int getMobile() {
		return mobile;
	}


	public void setMobile(int mobile) {
		this.mobile = mobile;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getHometown() {
		return hometown;
	}


	public void setHometown(String hometown) {
		this.hometown = hometown;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public int getTenthAggregate() {
		return tenthAggregate;
	}


	public void setTenthAggregate(int tenthAggregate) {
		this.tenthAggregate = tenthAggregate;
	}


	public int getTwelthAggregate() {
		return twelthAggregate;
	}


	public void setTwelthAggregate(int twelthAggregate) {
		this.twelthAggregate = twelthAggregate;
	}


	public int getDegreeAggregate() {
		return degreeAggregate;
	}


	public void setDegreeAggregate(int degreeAggregate) {
		this.degreeAggregate = degreeAggregate;
	}


	


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getDegree() {
		return degree;
	}


	public void setDegree(String degree) {
		this.degree = degree;
	}


	public String getDegreeStream() {
		return degreeStream;
	}


	public void setDegreeStream(String degreeStream) {
		this.degreeStream = degreeStream;
	}


	public int getDegreeYOP() {
		return degreeYOP;
	}


	public void setDegreeYOP(int degreeYOP) {
		this.degreeYOP = degreeYOP;
	}


	public String getCollegeName() {
		return collegeName;
	}


	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}


	public String getCollegeLocation() {
		return collegeLocation;
	}


	public void setCollegeLocation(String collegeLocation) {
		this.collegeLocation = collegeLocation;
	}



	
	
}
