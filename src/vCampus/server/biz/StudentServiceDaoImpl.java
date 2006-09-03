package vCampus.server.biz;


import vCampus.server.dao.StudentDao;
import vCampus.server.dao.StudentDaoImpl;
import vCampus.server.exception.RecordAlreadyExistException;
import vCampus.server.exception.RecordNotFoundException;
import vCampus.server.exception.WrongPasswordException;
import vCampus.vo.Student;

/**
 * @author SongZixing
 *
 * @version 0.0
 * 
 */
public class StudentServiceDaoImpl implements StudentServiceDao{
	
private StudentDao sd = new StudentDaoImpl();
	
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
		
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return null;

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
}
