package vCampus.vo;

import java.io.Serializable;

public class CourseChoose implements Serializable {
	
	private String courseID;
	private String courseName;
	private String studentName;
	private String teacherName;
	private double score;
	
	public void setCourseID(String courseID) {
		this.courseID=courseID;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public void setScore(double score) {
		this.score= score;
	}
	
	public String getCourseID() {
		return courseID;
	}
	public String getCourseName() {
		return courseName;
	}
	public String getStudentName() {
		return studentName;
	}
	public String gettTeacherName() {
		return teacherName;
	}
	public double getScore() {
		return score;
	}
}
