package vCampus.server.dao;

import vCampus.vo.Admin;
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
	public Admin selectAdmin(String adminID);
	public boolean insertAdmin(String adminID,String password)throws RecordAlreadyExistException;
	public boolean deleteAdmin(String adminID)throws RecordNotFoundException;
	public boolean updatePassword(String adminID,String password)throws RecordNotFoundException;

}

