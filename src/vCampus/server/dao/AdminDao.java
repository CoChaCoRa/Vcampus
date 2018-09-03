package vCampus.server.dao;

import java.sql.ResultSet;

import java.sql.SQLException;
import vCampus.vo.Admin;
import java.sql.PreparedStatement;
import vCampus.server.exception.*;

public interface AdminDao {	
	/**
	 * @param adminID
	 * @param password
	 * @return
	 * @throws RecordNotFoundException
	 * @throws RecordAlreadyExistException
	 * @throws WrongPasswordException
	 */
	public Admin selectAdmin(String adminID)throws SQLException;
	public boolean insertAdmin(String ID,String password)throws RecordAlreadyExistException,SQLException;
	public boolean updatePassword(String adminID,String password)throws RecordNotFoundException,SQLException;

}

