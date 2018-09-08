package vCampus.server.biz;

import java.util.ArrayList;

import vCampus.server.dao.CourseChooseDao;
import vCampus.server.dao.CourseChooseDaoImpl;
import vCampus.server.dao.TeacherDao;
import vCampus.server.dao.TeacherDaoImpl;
import vCampus.server.exception.RecordAlreadyExistException;
import vCampus.server.exception.RecordNotFoundException;
import vCampus.server.exception.WrongPasswordException;
import vCampus.vo.CourseChoose;
import vCampus.vo.Teacher;

public class TeacherServiceDaoImpl implements TeacherServiceDao {

	private TeacherDao td = new TeacherDaoImpl();
	private CourseChooseDao ccd = new CourseChooseDaoImpl();
	
	@Override
	public Teacher login(String userName, String password) throws RecordNotFoundException, WrongPasswordException {
		// TODO Auto-generated method stub
		try {
			Teacher teacher1 = td.findByName(userName);
			if(teacher1 == null) throw new RecordNotFoundException();
			if(teacher1.getPassword().equals(password)) {
				return teacher1;
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
	
	
	@Override
	public Teacher register(String userName, String password) throws RecordAlreadyExistException {
		// TODO Auto-generated method stub
		
		try {
			if(td.insertByUserNameAndPassword(userName, password)) {
				Teacher newTeacher = td.findByName(userName);
				return newTeacher;
			}
			
		} catch (RecordAlreadyExistException e) {
			// TODO: handle exception
			throw new RecordAlreadyExistException();
		}
		
		
		return null;
	}
	
	
	
	@Override
	public Teacher updatePassword(String userName, String newPassword) throws RecordNotFoundException {
		// TODO Auto-generated method stub
		try {
			if(td.updatePassword(userName, newPassword)) {
				Teacher teacher = td.findByName(userName);
				return teacher;
			}
			
		} catch (RecordNotFoundException e) {
			// TODO: handle exception
			throw new RecordNotFoundException();
		}
		
		return null;
	}
	 
	
	@Override
	public Teacher updateTeacherInfo(Teacher updatedTeacher) throws RecordNotFoundException {
		// TODO Auto-generated method stub
		try {
			if(td.updateSelfInformation(updatedTeacher)) {
				Teacher updatedTeacher1 = td.findByName(updatedTeacher.getUserName());
				return updatedTeacher1;
			}
			
		} catch (RecordNotFoundException e) {
			// TODO: handle exception
			throw new RecordNotFoundException();
		}
		
		return null;
	}
	
	@Override
	public boolean destoryTeacher(String userName) throws RecordNotFoundException {
		// TODO Auto-generated method stub
		try {
			if(td.deleteTeacher(userName)) return true;
		} catch (RecordNotFoundException e) {
			// TODO: handle exception
			throw new RecordNotFoundException();
		}
		return false;
	}
	
	
	@Override
	public boolean updateStudentGrades(ArrayList<CourseChoose> gradesSheet) throws RecordNotFoundException {
		// TODO Auto-generated method stub
		try {
			if(ccd.updateScoreByTeacher(gradesSheet)) {
				return true;
			}
		} catch (RecordNotFoundException e) {
			// TODO: handle exception
			throw new RecordNotFoundException();
		}
		
		return false;
	}
	
	
	@Override
	public ArrayList<CourseChoose> findAllTeachCourses(String teacherName) {
		// TODO Auto-generated method stub
		if(ccd.courseQueryByTeacher(teacherName) != null){
			return ccd.courseQueryByTeacher(teacherName);
		}
		return null;
	}
	
}
