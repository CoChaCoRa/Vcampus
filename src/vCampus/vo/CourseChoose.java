package vCampus.vo;

import java.io.Serializable;

public class CourseChoose implements Serializable {
	
	private String courseID;
	private String courseName;
	private String studentUserName;
	private String teacherUserName;
	private double score;
	
	public void setCourseID(String courseID) {
		this.courseID=courseID;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public void setStudentUserName(String studentUserName) {
		this.studentUserName = studentUserName;
	}
	public void setTeacherUserName(String teacherUserName) {
		this.teacherUserName = teacherUserName;
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
	public String getStudentUserName() {
		return studentUserName;
	}
	public String getTeacherUserName() {
		return teacherUserName;
	}
	public double getScore() {
		return score;
	}
}
