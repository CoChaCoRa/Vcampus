package vCampus.server.dao;

import java.sql.SQLException;


import vCampus.server.exception.RecordNotFoundException;
import vCampus.vo.Student;

public interface StudentDao {
	/**
	 * @param userName
	 * @param password
	 * @param Student
	 * @return
	 * @throws RecordNotFoundException
	 * @throws WrongPasswordException
	 */
	Student findByName(String userName) throws SQLException;
	boolean insertByUserNameAndPassword(String userName,String password)throws RecordNotFoundException,SQLException;
	boolean updatePassword(String userName,String password)throws RecordNotFoundException,SQLException;
	boolean updateSelfInformation(Student std)throws RecordNotFoundException,SQLException;
}
