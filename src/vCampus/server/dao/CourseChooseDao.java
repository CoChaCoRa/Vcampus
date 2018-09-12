package vCampus.server.dao;

import java.util.ArrayList;

import vCampus.server.exception.*;
import vCampus.vo.CourseChoose;
import vCampus.vo.CourseInformation;


public interface CourseChooseDao {
	/**
	 * 传入courseID参数,返回CourseInformation对象,未查询成功将返回null
	 * @param String
	 * @return courseInformation
	 */
    public CourseInformation findCourse(String courseID);
    
	/**
	 * 获取所有课程信息,返回ArrayList<CourseInformation>,未查询成功将返回null
	 * @param null
	 * @return ArrayList<courseInformation>
	 */
    public ArrayList<CourseInformation> allCourses();
    
    /**
	 * 传入studentUserName参数,返回ArrayList<CourseChoose>,未查询成功将返回null
	 * @param String
	 * @return ArrayList<CourseChoose>
	 */
    public ArrayList<CourseChoose> courseQueryByStudent(String studentUserName);
    
    /**
	 * 传入teacherUserName参数,返回ArrayList<CourseChoose>,未查询成功将返回null
	 * @param String
	 * @return ArrayList<CourseChoose>
	 */
    public ArrayList<CourseChoose> courseQueryByTeacher(String teacherUserName);
    
    /**
	 * 传入courseID参数,返回ArrayList<CourseChoose>,未查询成功将返回null
	 * @param String
	 * @return ArrayList<CourseChoose>
	 */
    public ArrayList<CourseChoose> courseQueryByCourse(String courseID);
    
    /**
	 * 传入studentUserName,courseID,若courseID不存在/该课程学生已选/人数达到上限则抛出异常,SQL异常返回false
	 * @param String
	 * @return boolean
	 * @throws RecordNotFoundException
	 * @throws RecordAlreadyExistException
	 * @throws OutOfLimitException
	 */
    public boolean addCourseByStudent(String studentUserName,String courseID)throws RecordNotFoundException,RecordAlreadyExistException,OutOfLimitException;
    
    /**
	 * 传入studentUserName,courseID,若学生未选该课程/课程人数为0则抛出异常,SQL异常返回false
	 * @param String
	 * @return boolean
	 * @throws RecordNotFoundException
	 * @throws OutOfLimitException
	 */
    public boolean deleteCourseByStudent(String studentUserName,String courseID)throws RecordNotFoundException,OutOfLimitException;
    
    /**
	 * 传入ArrayList<CourseChoose>包含学生选课以及对应的分数信息,若学生未选该课程则抛出异常,SQL异常返回false
	 * @param String
	 * @return boolean
	 * @throws RecordNotFoundException
	 */
    public boolean updateScoreByTeacher(ArrayList<CourseChoose> scoreList)throws RecordNotFoundException;
    
    /**
	 * 传入CourseInformation,若包含的老师信息不存在或者课程信息已经存在则抛出异常,SQL异常返回false
	 * @param String
	 * @return boolean
	 * @throws RecordNotFoundException
	 * @throws RecordAlreadyExistException
	 */
    public boolean addCourseByAdmin(CourseInformation course)throws RecordAlreadyExistException,RecordNotFoundException;
    
    /**
	 * 传入CourseInformation,若包含的老师信息不存在或者课程不存在则抛出异常(在uMsg中区分),SQL异常返回false
	 * @param String
	 * @return boolean
	 * @throws RecordNotFoundException
	 */
    public boolean updateCourseByAdmin(CourseInformation course)throws RecordNotFoundException;
    
    /**
	 * 传入CourseInformation,若课程信息不存在则抛出异常,SQL异常返回false
	 * @param String
	 * @return boolean
	 * @throws RecordNotFoundException
	 */
    public boolean deleteCourseByAdmin(String courseID)throws RecordNotFoundException;
}
