package vCampus.vo;

import java.io.Serializable;
import java.sql.Timestamp;

public class CourseInformation implements Serializable {
	private String courseID;
	private String courseName;
	private String deptName;
	private String teacherEcardNumber;
	private String teacherName;
	private int courseHour;
	private double credit;
	private Timestamp courseDate;
	private int weekIndex;
	private String coursePlace;
	private Timestamp examTime;
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
	public void setCourseDate(Timestamp courseDate) {
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
	public void setExamTime(Timestamp examTime) {
		this.examTime = examTime;
	}
	public void setExamPlace(String examPlace) {
		this.examPlace=examPlace;
	}
	public void setCurrentAmount(int currentAmount){
		this.currentAmount=currentAmount;
	}
	public void setTeacherEcardNumber(String teacherEcardNumber){
		this.teacherEcardNumber=teacherEcardNumber;
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
	public Timestamp getCourseDate() {
		return (Timestamp) courseDate;
	}
	public String getCoursePlace() {
		return coursePlace;
	}
	public double getCredit() {
		return (double) credit;
	}
	public int getPersonLimit() {
		return personLimit;
	}
	public Timestamp getExamTime() {
		return (Timestamp) examTime;
	}
	public String getExamPlace() {
		return examPlace;
	}	
	public int getCurrentAmount(){
		return currentAmount;
	}
	public String getTeacherEcardNumber(){
		return teacherEcardNumber;
	}
	public String getTeacherName(){
		return teacherName;
	}
}
