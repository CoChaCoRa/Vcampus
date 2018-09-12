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
			double result=adminImpl.queryAccountByUserName("1");
			System.out.println(result);
			selectAdmin("admin1");
			if(insertAdmin("admin12","QWQ")) {
				selectAdmin("admin12");
			}else System.out.println("Error!");
			if(updatePassword("admin12","QAQ")) {
				selectAdmin("admin12");
			}else System.out.println("Error!");
			if(deleteAdmin("admin12")) {
				selectAdmin("admin12");
			}else System.out.println("Error!");
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
