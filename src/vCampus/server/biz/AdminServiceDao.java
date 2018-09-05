package vCampus.server.biz;


import vCampus.server.exception.RecordAlreadyExistException;
import vCampus.server.exception.RecordNotFoundException;
import vCampus.server.exception.WrongPasswordException;
import vCampus.vo.Admin;

public interface AdminServiceDao {
	Admin register(String ID,String password) throws RecordAlreadyExistException;
	Admin login(String ID,String password) throws RecordNotFoundException,WrongPasswordException;
	Admin updatePassword(String ID, String password) throws RecordNotFoundException;
	boolean destroy(String ID) throws RecordNotFoundException;
	
}
