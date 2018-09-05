package vCampus.biz.clent;

import vCampus.client.biz.StudentService;
import vCampus.client.biz.StudentServiceImpl;
import vCampus.vo.Student;

/**
 * @author SongZixing
 *
 * @version 0.0
 * 
 * Test the StudentService.java
 */
public class TestStudentService {
	//public StudentService studentService;
	
	public static void main(String[] args) {
		//StudentServiceImpl testStudentService = new StudentServiceImpl();
		StudentService studentService = new StudentServiceImpl();
		
		
		
		
		
		//test login successfully
		if(studentService.login("213160821", "szx123")) 
		{
			System.out.println("test login");
			System.out.println(studentService.getCacheStudent().getUserName()+",ok!");
		}
		
		//test login when no such account exists
		if(studentService.login("213160822", "szx123") == false) {
		System.out.println("test exception");
		System.out.println(studentService.getExceptionCode());
		}
		
		//test login when the password is wrong
		if(studentService.login("213160821", "szx124") == false) {
		System.out.println("test exception");
		System.out.println(studentService.getExceptionCode());
		}
		
		
		
		
		
		
		
		//test register when no account exists,(ATTENTION!!!! the userID has to be changed every time when running the test )
		if(studentService.register("213160231", "12345", "12345") ) {
		System.out.println(studentService.getCacheStudent().getUserName());
		}
		
		//test register when password fails to match
		if(studentService.register("213160233", "123456", "12345") == false) {
			System.out.println(studentService.getExceptionCode());
		}
		
		//test register when the account has already existed
		if(studentService.register("213160821", "123", "123") == false) {
			System.out.println(studentService.getExceptionCode());
		}
		
		
		
		
		
		
		//test change password 
		if(studentService.login("213160821", "szx123")) {
			//test when change the password successfully
			if(studentService.updatePassword("szx123", "szx123", "szx123")) {
				System.out.println("change the password successfully");
			}
			//test when wrong password
			if(studentService.updatePassword("szx1234", "szx", "szx") == false ) {
				System.out.println(studentService.getExceptionCode());
			}
			//test when password fails to match
			if(studentService.updatePassword("szx123", "szx123", "szx1234") == false ) {
				System.out.println(studentService.getExceptionCode());
			}
		}
		
		
		
		
		
		
		//test update info
		if(studentService.login("213160821", "szx123")) {
			studentService.getCacheStudent().setEmailAddress("songzixing98@gmail.com");
			if(studentService.updateInfo(studentService.getCacheStudent())) {
				studentService.login("213160821", "szx123");
				System.out.println(studentService.getCacheStudent().getEmailAddress());
				System.out.println("change successfully");
			}
		}
	}
}
