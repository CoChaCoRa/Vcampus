package vCampus.biz.clent;

import com.hxtt.global.s;

import vCampus.client.biz.AdminService;
import vCampus.client.biz.AdminServiceImpl;
import vCampus.server.biz.AdminServiceDaoImpl;
import vCampus.server.biz.StudentServiceDao;
import vCampus.server.biz.StudentServiceDaoImpl;
import vCampus.vo.Student;

/**
 * @author SongZixing
 *
 */
public class TestAdminService {

	//test Admin Service
	
	public static void main(String[] args) {
		AdminService adminService = new AdminServiceImpl();
		
		//test register
		
		//test register when no account exists,(ATTENTION!!!! the userID has to be changed every time when running the test )
				if(adminService.register("100160221", "12345", "12345") ) {
				System.out.println(adminService.getCacheAdmin().getAdminID());
				}
				
				//test register when password fails to match
				if(adminService.register("213160233", "123456", "12345") == false) {
					System.out.println(adminService.getExceptionCode());
				}
				
				//test register when the account has already existed
				if(adminService.register("100160221", "123", "123") == false) {
					System.out.println(adminService.getExceptionCode());
				}
				
				
		//test login
				
				//test login successfully
				if(adminService.login("100160221", "12345")) {
					System.out.println(adminService.getCacheAdmin().getAdminID());
				}
				//test when the password is wrong
				if(adminService.login("100160221", "12344") == false) {
					System.out.println(adminService.getExceptionCode());
				}
				//test when the account does not exist
				if(adminService.login("100160222", "md") == false) {
					System.out.println(adminService.getExceptionCode());
				}
		
				//test change the password
				if(adminService.login("100160221", "12345")) {
					if(adminService.updatePassword("123")) {
						System.out.println("change the password!");
					}
				}
				
				//test delete account
				if(adminService.login("100160221", "123")) {
					if(adminService.destoryAccount("ADMIN", "100160221")) {
						System.out.println("delete the account!");
					}
				}
				
			//test add student
				Student addStudent = new Student();
				addStudent.setUserName("213170821");
				adminService.addStudentAccount(addStudent);
				
			//test query student
				if(adminService.queryStudentInformation("213160821") != null) {
					System.out.println("ok!");
				}
				
			//test change student info
				Student screwedStudent = new Student();
				screwedStudent.setUserName("213160821");
				screwedStudent.setEmailAddress("2746661349@qq.com");
				if(adminService.updateStudentInformation(screwedStudent)) {
					System.out.println("change success!");
				}
				
				
				System.out.println(adminService.queryAccountByUserName("213164189"));
				
	}
}
