package vCampus.server.biz;

import java.sql.SQLException;
import java.util.ArrayList;

import vCampus.server.exception.OutOfLimitException;
import vCampus.server.exception.RecordAlreadyExistException;
import vCampus.server.exception.RecordNotFoundException;
import vCampus.server.exception.WrongPasswordException;
import vCampus.vo.CourseChoose;
import vCampus.vo.CourseInformation;
import vCampus.vo.Student;

/**
 * @author SongZixing
 *
 * @version 0.0
 * 
 */
public interface StudentServiceDao {
	Student register(String userName, String studentPassword) throws  RecordAlreadyExistException; 
	Student login(String userName, String studentPassword) throws RecordNotFoundException, WrongPasswordException;
	Student updatePassword(String userName, String newStudentPassword) throws RecordNotFoundException;
	Student updateStudentInfo(Student updatedStudent) throws  RecordNotFoundException;
	boolean destroyStudent(String userName) throws RecordNotFoundException;
	
	CourseInformation findCourseInformation(String courseID);
	ArrayList<CourseChoose> findAllChosenCourses(String userName);
	boolean addCourse(String userName,String courseID) throws RecordNotFoundException, RecordAlreadyExistException, OutOfLimitException;
	boolean deleteCourse(String userName,String courseID) throws OutOfLimitException, RecordNotFoundException;

}
