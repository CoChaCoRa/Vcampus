package vCampus.server.biz;


import java.util.ArrayList;

import vCampus.server.exception.RecordAlreadyExistException;
import vCampus.server.exception.RecordNotFoundException;
import vCampus.server.exception.WrongPasswordException;
import vCampus.vo.Admin;
import vCampus.vo.CourseChoose;
import vCampus.vo.CourseInformation;

public interface AdminServiceDao {
	Admin register(String ID,String password) throws RecordAlreadyExistException;
	Admin login(String ID,String password) throws RecordNotFoundException,WrongPasswordException;
	Admin updatePassword(String ID, String password) throws RecordNotFoundException;
	boolean destroy(String ID) throws RecordNotFoundException;
	
	ArrayList<CourseChoose> courseQueryAdmin(String courseID);
	boolean addCoursebyAdmin(CourseInformation newCourse) throws RecordNotFoundException,RecordAlreadyExistException;
	boolean updateCoursebyAdmin(CourseInformation updatedCourse) throws RecordNotFoundException;
	boolean deleteCoursebyAdmin(String courseID) throws RecordNotFoundException;
	
}
