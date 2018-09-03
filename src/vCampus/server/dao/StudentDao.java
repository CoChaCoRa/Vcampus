package vCampus.server.dao;

import java.sql.SQLException;



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
	public Student findByName(String userName) throws SQLException;
	public boolean insertByUserNameAndPassword(String userName,String password)throws RecordAlreadyExistException,SQLException;
	public boolean updatePassword(String userName,String password)throws RecordNotFoundException,SQLException;
	public boolean updateSelfInformation(Student std)throws RecordNotFoundException,SQLException;
}
