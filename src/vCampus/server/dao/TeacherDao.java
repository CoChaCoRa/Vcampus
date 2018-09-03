package vCampus.server.dao;

import java.sql.SQLException;


import vCampus.server.exception.RecordNotFoundException;
import vCampus.vo.Teacher;

public interface TeacherDao {
	/**
	 * @param userName
	 * @param password
	 * @param Teacher
	 * @return
	 * @throws RecordNotFoundException
	 * @throws WrongPasswordException
	 */
	Teacher findByName(String userName) throws SQLException;
	boolean insertByUserNameAndPassword(String userName,String password)throws SQLException;
	boolean updatePassword(String userName,String password)throws RecordNotFoundException,SQLException;
	boolean updateSelfInformation(Teacher std)throws RecordNotFoundException,SQLException;
}
