package vCampus.server.dao;

import java.sql.SQLException;


import vCampus.server.exception.*;
import vCampus.vo.Teacher;

public interface TeacherDao {
	/**
	 * @param userName
	 * @param password
	 * @param Teacher
	 * @return
	 * @throws RecordNotFoundException
	 * @throws RecordAlreadyExistException
	 * @throws WrongPasswordException
	 */
	public Teacher findByName(String userName);
	public boolean insertByUserNameAndPassword(String userName,String password)throws RecordAlreadyExistException;
	public boolean updatePassword(String userName,String password)throws RecordNotFoundException;
	public boolean updateSelfInformation(Teacher std)throws RecordNotFoundException;
}
