package vCampus.server.dao;

import java.sql.SQLException;

import java.util.ArrayList;

import vCampus.server.exception.RecordNotFoundException;
import vCampus.server.exception.WrongPasswordException;
import vCampus.vo.CourseChoose;
import vCampus.vo.CourseInformation;


public interface CourseChooseDao {
	/**
	 * @param username
	 * @param password
	 * @return
	 * @throws RecordNotFoundException
	 * @throws WrongPasswordException
	 */

	ArrayList<CourseChoose> courseQueryByStudent(String studentName)throws RecordNotFoundException,SQLException;
	ArrayList<CourseChoose> courseQueryByTeacher(String teacherName)throws RecordNotFoundException,SQLException;
	ArrayList<CourseChoose> courseQueryByCourse(String courseID)throws RecordNotFoundException,SQLException;
	boolean addCourseByStudent(String studentName,String courseID)throws RecordNotFoundException,SQLException;
	boolean deleteCourseByStudent(String studentName,String courseID)throws RecordNotFoundException,SQLException;
	boolean updateScoreByTeacher(ArrayList<CourseChoose> scoreList)throws RecordNotFoundException,SQLException;
	boolean addCourseByAdmin(CourseInformation course)throws RecordNotFoundException,SQLException;
	boolean updateCourseByAdmin(CourseInformation course)throws RecordNotFoundException,SQLException;;
}
