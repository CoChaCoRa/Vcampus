package vCampus.server.dao;

import vCampus.server.exception.*;
import vCampus.vo.Student;

public interface StudentDao {
	/**
	 * @param userName
	 * @param password
	 * @param Student
	 * @return
	 * @throws RecordNotFoundException
	 * @throws RecordAlreadyExistException
	 * @throws WrongPasswordException
	 */
	public Student findByName(String userName);
	public boolean insertByUserNameAndPassword(String userName,String password)throws RecordAlreadyExistException;
	public boolean updatePassword(String userName,String password)throws RecordNotFoundException;
	public boolean updateSelfInformation(Student std)throws RecordNotFoundException;
	public boolean deleteStudent(String userName)throws RecordNotFoundException;
}
