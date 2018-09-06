package vCampus.server.biz;



import vCampus.server.dao.AdminDao;
import vCampus.server.dao.AdminDaoImpl;
import vCampus.server.exception.RecordAlreadyExistException;
import vCampus.server.exception.RecordNotFoundException;
import vCampus.server.exception.WrongPasswordException;
import vCampus.vo.Admin;


public class AdminServiceDaoImpl implements AdminServiceDao{

	private AdminDao ad = new AdminDaoImpl();
	
	
	
	@Override
	public Admin register(String ID, String password) throws RecordAlreadyExistException {
		// TODO Auto-generated method stub
		try {
			if(ad.insertAdmin(ID, password)) {
				Admin newAdmin = ad.selectAdmin(ID);
				return newAdmin;
			}
			
		} catch (RecordAlreadyExistException e) {
			// TODO: handle exception
			throw new RecordAlreadyExistException();
		}
		return null;
	}
	
	
	
	
	@Override
	public Admin login(String ID, String password) throws RecordNotFoundException, WrongPasswordException {
		// TODO Auto-generated method stub
		try {
			Admin admin = ad.selectAdmin(ID);
			if(admin == null) throw new RecordNotFoundException();
			
			if(admin.getPassword().equals(password)) {
				return admin;
			}
			
			else throw new WrongPasswordException();
			
		} 
		catch (RecordNotFoundException e) {
			// TODO: handle exception
			throw new RecordNotFoundException();
		}
		
		catch (WrongPasswordException e) {
			// TODO: handle exception
			throw new WrongPasswordException();
		}
		
	}
	
	
	
	
	@Override
	public Admin updatePassword(String ID, String password) throws RecordNotFoundException {
		// TODO Auto-generated method stub
		try {
			if(ad.updatePassword(ID, password)) {
				return ad.selectAdmin(ID);
			}
			
		} catch (RecordNotFoundException e) {
			// TODO: handle exception
			throw new RecordNotFoundException();
		}
		
		return null;
	}
	
	
	
	
	@Override
	public boolean destroy(String ID) throws RecordNotFoundException {
		// TODO Auto-generated method stub
		try {
			if(ad.deleteAdmin(ID)) return true;
		} catch (RecordNotFoundException e) {
			// TODO: handle exception
			throw new RecordNotFoundException();
		}
		return false;
	}
	
	
}
