package vCampus.server.dao;

import java.sql.SQLException;

import java.util.ArrayList;

import vCampus.server.exception.*;
import vCampus.vo.CourseChoose;
import vCampus.vo.CourseInformation;


public interface CourseChooseDao {
	/**
	 * @param courseID
	 * @param studentName
	 * @param teacherName
	 * @param ArrayList<CourseChoose>
	 * @return
	 * @throws RecordNotFoundException
	 * @throws RecordAlreadyExistException
	 * @throws WrongPasswordException
	 */

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
}
