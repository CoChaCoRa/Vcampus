package vCampus.server.dao;

import vCampus.vo.Admin;
import vCampus.server.exception.*;

public interface AdminDao {	
	/**
	 * 传入admin参数，返回Admin对象，未查询成功将返回null
	 * @param String
	 * @return admin
	 */
	public Admin selectAdmin(String adminID);
	
	/**
	 * 传入adminID,password,若userName已经存在抛出异常,SQL异常返回false
	 * @param String
	 * @return boolean
	 * @throws RecordAlreadyExistException
	 */
	public boolean insertAdmin(String adminID,String password)throws RecordAlreadyExistException;
	
	/**
	 * 传入adminID,password,若userName不存在抛出异常,SQL异常返回false
	 * @param String
	 * @return boolean
	 * @throws RecordNotFoundException
	 */
	public boolean updatePassword(String adminID,String password)throws RecordNotFoundException;
	
	/**
	 * 传入adminID,若userName不存在抛出异常,SQL异常返回false
	 * @param String
	 * @return boolean
	 * @throws RecordNotFoundException
	 */
	public boolean deleteAdmin(String adminID)throws RecordNotFoundException;
}

