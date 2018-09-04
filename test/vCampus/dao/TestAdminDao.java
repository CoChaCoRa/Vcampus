package vCampus.dao;

import vCampus.server.dao.AdminDao;
import vCampus.server.dao.AdminDaoImpl;
import vCampus.server.exception.*;
import vCampus.vo.*;

/**
 * @author YangHangyuan
 *
 */
public class TestAdminDao {
	private static AdminDao adminImpl=new AdminDaoImpl();

	private static void selectAdmin(String adminID)throws Exception {
		Admin admin=adminImpl.selectAdmin(adminID);
		if(admin==null)throw new RecordNotFoundException();
		System.out.println(admin.getAdminID()+"  "+admin.getPassword());
	}

	private static boolean insertAdmin(String adminID,String password)throws Exception {
		return adminImpl.insertAdmin(adminID,password);
		
	}
	
	private static boolean updatePassword(String adminID,String password)throws Exception {
		return adminImpl.updatePassword(adminID,password);
	}
	
	private static boolean deleteAdmin(String adminID)throws Exception{
		return adminImpl.deleteAdmin(adminID);
	}
	
	public static void main(String args[]) {
		try {
			selectAdmin("1");
			if(insertAdmin("2","QWQ")) {
				selectAdmin("2");
			}else System.out.println("Error!");
			if(updatePassword("2","QAQ")) {
				selectAdmin("2");
			}else System.out.println("Error!");
			if(deleteAdmin("2")) {
				selectAdmin("2");
			}else System.out.println("Error!");
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
