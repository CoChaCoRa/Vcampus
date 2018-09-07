package vCampus.client.biz;

import java.util.ArrayList;

import vCampus.vo.CourseChoose;
import vCampus.vo.CourseInformation;

public interface AcademicAffairsService {

	public String getExceptionCode();
	public CourseInformation findCourseInformation(String courseID);

	//academic affairs service for student
	public ArrayList<CourseChoose> getCacheStudentCourse();
	public ArrayList<CourseChoose> studentGetAllCourses();
	public ArrayList<CourseInformation> studentGetTimeTable();
	public boolean isStudentChosenCourse(String courseID);
	public CourseChoose studentGetCourse(String courseID);
	public double studentGetCourseGrade(String courseID);
	public ArrayList<CourseChoose> studentGetAllCourseGrades();
	public double studentGetGPA();
	public boolean studentAddCourse(String CourseID);
	public boolean studentDeleteCourse(String CourseID);
	
	//academic affairs service for teacher
	
	
	
	
	//academic affairs service for admin
	
	
	
}
