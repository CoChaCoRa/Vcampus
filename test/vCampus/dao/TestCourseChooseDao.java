package vCampus.dao;

import java.util.ArrayList;

import vCampus.server.dao.CourseChooseDao;
import vCampus.server.dao.CourseChooseDaoImpl;
import vCampus.server.exception.*;
import vCampus.vo.*;
/**
 * @author YangHangyuan
 *
 * 
 */
public class TestCourseChooseDao {

	private static CourseChooseDao ccImpl=new CourseChooseDaoImpl();
	
	/*
	public CourseInformation findCourse(String courseID);
    public ArrayList<CourseChoose> courseQueryByStudent(String studentName)throws RecordNotFoundException;
    public ArrayList<CourseChoose> courseQueryByTeacher(String teacherName)throws RecordNotFoundException;
    public ArrayList<CourseChoose> courseQueryByCourse(String courseID)throws RecordNotFoundException;
    public boolean addCourseByStudent(String studentName,String courseID)throws RecordNotFoundException,RecordAlreadyExistException,OutOfLimitException;
    public boolean deleteCourseByStudent(String studentName,String courseID)throws RecordNotFoundException,OutOfLimitException;
    public boolean updateScoreByTeacher(ArrayList<CourseChoose> scoreList)throws RecordNotFoundException;
    public boolean addCourseByAdmin(CourseInformation course)throws RecordAlreadyExistException;
    public boolean updateCourseByAdmin(CourseInformation course)throws RecordNotFoundException;
    public boolean deleteCourseByAdmin(String courseID)throws RecordNotFoundException; 
	 * */
	
	private static CourseInformation findCourse(String courseID)throws Exception {
		return ccImpl.findCourse(courseID);
	}
	private static ArrayList<CourseChoose> courseQueryByStudent(String studentName)throws Exception {
		return ccImpl.courseQueryByStudent(studentName);
	}
	private static ArrayList<CourseChoose> courseQueryByTeacher(String teacherName)throws Exception {
		return ccImpl.courseQueryByStudent(teacherName);
	}
	private static ArrayList<CourseChoose> courseQueryByCourse(String courseID)throws Exception {
		return ccImpl.courseQueryByStudent(courseID);
	}
	
	
	
	public static void main(String[] args) {
		try {
			findByName("szxdl");
			if(insertByUserNameAndPassword("213161268","gg")) {
				findByName("213161268");
			}else System.out.println("Error!");
			if(updatePassword("213161268","gga")) {
				findByName("213161268");
			}else System.out.println("Error!");
			Teacher std=new Teacher();
			std.setAccount(123.4);
			std.setBankAccount("cc");
			std.setDeptName("CSDN");
			std.setEmailAddress("cc@seu.edu.cn");
			std.setIdCard("89461236472189374");
			std.setMoney(41.3);
			std.setPassword("102938094");
			std.setPhoneNumber("1239048901");
			std.setSex("male");
			std.setTeacherEcardNumber("213147914");
			std.setProfessionalTitle("Ph.DD");
			std.setUserName("cczuiqiang");
			if(updateSelfInformation("213161268",std)) {
				findByName("cczuiqiang");
			}else System.out.println("Error!");
			if(deleteTeacher("cczuiqiang")) {
				findByName("cczuiqiang");
			}else System.out.println("Error!");
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
