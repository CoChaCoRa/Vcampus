package vCampus.server.biz;


import java.util.ArrayList;

import vCampus.server.dao.CourseChooseDao;
import vCampus.server.dao.CourseChooseDaoImpl;
import vCampus.server.dao.StudentDao;
import vCampus.server.dao.StudentDaoImpl;
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
public class StudentServiceDaoImpl implements StudentServiceDao{
	
private StudentDao sd = new StudentDaoImpl();
private CourseChooseDao ccd = new CourseChooseDaoImpl();
	
	/* (non-Javadoc)
	 * @see vCampus.server.biz.StudentServiceDao#login(java.lang.String, java.lang.String)
	 */
	@Override
	public Student login(String userName, String studentPassword) throws RecordNotFoundException, WrongPasswordException {
		// TODO Auto-generated method stub
		try {
			Student student1 = sd.findByName(userName);
			if(student1 == null) throw new RecordNotFoundException();
			if(student1.getPassword().equals(studentPassword)) {
				return student1;
			}
			else {
				throw new WrongPasswordException();
			}
		}
		
		catch (RecordNotFoundException e) {
			// TODO: handle exception
			throw new RecordNotFoundException();
		}
		
		catch (WrongPasswordException e) {
			throw new WrongPasswordException();
		}
		
		

	}
	
	/* (non-Javadoc)
	 * @see vCampus.server.biz.StudentServiceDao#register(java.lang.String, java.lang.String)
	 */
	@Override
	public Student register(String userName, String studentPassword) throws  RecordAlreadyExistException {
		// TODO Auto-generated method stub
		try {
			if(sd.insertByUserNameAndPassword(userName, studentPassword)) {
				Student newStudent = sd.findByName(userName);
				return newStudent;
			}
			
		} catch (RecordAlreadyExistException e) {
			// TODO: handle exception
			throw new RecordAlreadyExistException();
		}
		
		return null;
	}
	
	/* (non-Javadoc)
	 * @see vCampus.server.biz.StudentServiceDao#updatePassword(java.lang.String, java.lang.String)
	 */
	@Override
	public Student updatePassword(String userName, String newStudentPassword) throws  RecordNotFoundException {
		// TODO Auto-generated method stub
		try {
			if(sd.updatePassword(userName, newStudentPassword)) {
				Student student = sd.findByName(userName);
				return student;
			}
			
		} catch (RecordNotFoundException e) {
			// TODO: handle exception
			throw new RecordNotFoundException();
		}
		
		return null;
	}
	
	@Override
		public Student updateStudentInfo(Student updatedStudent) throws RecordNotFoundException {
			// TODO Auto-generated method stub
		
		try {
			if(sd.updateSelfInformation(updatedStudent)) {
				Student updatedStudent1 = sd.findByName(updatedStudent.getUserName());
				return updatedStudent1;
			}
			
		} catch (RecordNotFoundException e) {
			// TODO: handle exception
			throw new RecordNotFoundException();
		}
		
			return null;
		}
	
	
	@Override
		public boolean destroyStudent(String userName) throws RecordNotFoundException {
			// TODO Auto-generated method stub
		try {
			if(sd.deleteStudent(userName)) return true;
		} catch (RecordNotFoundException e) {
			// TODO: handle exception
			throw new RecordNotFoundException();
		}
			return false;
		}
	
	
	
	@Override
		public CourseInformation findCourseInformation(String courseID) {
			// TODO Auto-generated method stub
		
			CourseInformation courseInformation = ccd.findCourse(courseID);
			if(courseInformation != null) return courseInformation;
		
			return null;
		}
	
	
	/* (non-Javadoc)
	 * @see vCampus.server.biz.StudentServiceDao#findAllChosenCourses(java.lang.String)
	 */
	@Override
		public ArrayList<CourseChoose> findAllChosenCourses(String userName) {
			// TODO Auto-generated method stub
			if(ccd.courseQueryByStudent(userName) != null) {
				return ccd.courseQueryByStudent(userName);
			}
			return null;
		}
	
	@Override
		public boolean addCourse(String userName, String courseID) throws RecordNotFoundException, RecordAlreadyExistException, OutOfLimitException {
			// TODO Auto-generated method stub
		try {
			if(ccd.addCourseByStudent(userName, courseID)) {
				return true;
			}
				return false;
		} catch (RecordNotFoundException e) {
			// TODO: handle exception
			throw new RecordNotFoundException();
		}
		
		catch (RecordAlreadyExistException e) {
			// TODO: handle exception
			throw new RecordAlreadyExistException();
		}
		
		catch (OutOfLimitException e) {
			// TODO: handle exception
			throw new OutOfLimitException();
		}
		}
	
	@Override
		public boolean deleteCourse(String userName, String courseID) throws OutOfLimitException, RecordNotFoundException {
			// TODO Auto-generated method stub
		try {
			if(ccd.deleteCourseByStudent(userName, courseID)) {
				return true;
			}
			return false;
		} 
		catch (RecordNotFoundException e) {
			// TODO: handle exception
			
			throw new RecordNotFoundException();
			
		}
		catch (OutOfLimitException e) {
			// TODO: handle exception
			throw new OutOfLimitException();
		}
			
		}
	
	@Override
		public Student findByName(String userName) throws RecordNotFoundException {
			// TODO Auto-generated method stub
		if(sd.findByName(userName) != null) {
			return sd.findByName(userName);
		}
			return null;
		}
	
	
}
