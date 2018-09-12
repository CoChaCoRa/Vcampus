package vCampus.vo;

import java.io.Serializable;

import java.sql.Date;

public class CourseInformation implements Serializable {
	private String courseID;
	private String courseName;
	private String deptName;
	private String teacherUserName;
	private String teacherName;
	private int courseHour;
	private double credit;
	private Date courseDate;
	private int weekIndex;
	private String coursePlace;
	private Date examTime;
	private String examPlace;
	private int personLimit;
	private int currentAmount;
	
	public void setWeekIndex(int weekIndex) {
		this.weekIndex=weekIndex;
	}
	public void setDeptName(String deptName){
		this.deptName=deptName;
	}
	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}	
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}	
	public void setCourseHour(int courseHour) {
		this.courseHour = courseHour;
	}	
	public void setCourseDate(Date courseDate) {
		this.courseDate = courseDate;
	}	
	public void setCoursePlace(String coursePlace) {
		this.coursePlace= coursePlace;
	}	
	public void setCredit(double credit) {
		this.credit = credit;
	}	
	public void setPersonLimit(int personLimit) {
		this.personLimit = personLimit;
	}	
	public void setExamTime(Date examTime) {
		this.examTime = examTime;
	}
	public void setExamPlace(String examPlace) {
		this.examPlace=examPlace;
	}
	public void setCurrentAmount(int currentAmount){
		this.currentAmount=currentAmount;
	}
	public void setTeacherUserName(String teacherUserName){
		this.teacherUserName=teacherUserName;
	}
	public void setTeacherName(String teacherName){
		this.teacherName=teacherName;
	}
	
	public int getWeekIndex() {
		return weekIndex;
	}
	public String getDeptName(){
		return deptName;
	}
	public String getCourseID() {
		return courseID;
	}
	public String getCourseName() {
		return courseName;
	}
	public int getCourseHour() {
		return courseHour;
	}
	public Date getCourseDate() {
		return courseDate;
	}
	public String getCoursePlace() {
		return coursePlace;
	}
	
	public double getCredit() {
		return credit;
	}
	public int getPersonLimit() {
		return personLimit;
	}
	public Date getExamTime() {
		return examTime;
	}
	public String getExamPlace() {
		return examPlace;
	}	
	public int getCurrentAmount(){
		return currentAmount;
	}
	public String getTeacherUserName(){
		return teacherUserName;
	}
	public String getTeacherName(){
		return teacherName;
	}
	
	@Override
	public String toString() {
		return "\n\tCourseInformation"
			+"\ncourseID\t"+courseID
			+"\ncourseName\t"+courseName
			+"\ndeptName\t"+deptName
			+"\nteacherUserName\t"+teacherUserName
			+"\nteacherName\t"+teacherName
			+"\ncourseHour\t"+courseHour
			+"\ncredit\t"+credit
			+"\ncourseDate\t"+courseDate
			+"\nweekIndex\t"+weekIndex
			+"\ncoursePlace\t"+coursePlace
			+"\nexamTime\t"+examTime
			+"\nexamPlace\t"+examPlace
			+"\npersonLimit\t"+personLimit
			+"\ncurrentAmount\t"+currentAmount;
	}
}
