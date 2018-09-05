package vCampus.server.biz;

import java.sql.SQLException;

import vCampus.server.dao.AdminDao;
import vCampus.server.dao.AdminDaoImpl;
import vCampus.server.exception.RecordExistedException;
import vCampus.vo.Admin;

public class AdminServiceDaoImpl implements AdminServiceDao{

	private AdminDao ad = new AdminDaoImpl();
	
	@Override
	public Admin register(String ID, String password) throws RecordExistedException,SQLException {
		// TODO Auto-generated method stub
		 if(ad.selectAdmin(ID).getAdminID().equals(ID)) {
			 throw new RecordExistedException();
		 }
		 
		
	}
	
	@Override
	public Admin login(String ID, String password) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Admin update(Admin updatedAdmin) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
