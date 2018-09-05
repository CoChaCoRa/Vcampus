package vCampus.biz.clent;

import vCampus.client.biz.TeacherService;
import vCampus.client.biz.TeacherServiceImpl;

public class TestTeacherService {
	
	//test teacherService
	
	public static void main(String[] args) {
		
		TeacherService teacherService = new TeacherServiceImpl();
		
		
		

		//test register when no account exists,(ATTENTION!!!! the userID has to be changed every time when running the test )
		if(teacherService.register("120160821", "teach123", "teach123") ) {
		System.out.println(teacherService.getCacheTeacher().getUserName());
		}
		
		//test register when password fails to match
		if(teacherService.register("213160233", "123456", "12345") == false) {
			System.out.println(teacherService.getExceptionCode());
		}
		
		//test register when the account has already existed
		if(teacherService.register("120160821", "123", "123") == false) {
			System.out.println(teacherService.getExceptionCode());
		}
		
		
		
		
		
		//test login successfully
		if(teacherService.login("120160821", "teach123")) 
		{
			System.out.println("test login");
			System.out.println(teacherService.getCacheTeacher().getUserName()+",ok!");
		}
		
		//test login when no such account exists
		if(teacherService.login("213160822", "szx123") == false) {
		System.out.println("test exception");
		System.out.println(teacherService.getExceptionCode());
		}
		
		//test login when the password is wrong
		if(teacherService.login("120160821", "szx124") == false) {
		System.out.println("test exception");
		System.out.println(teacherService.getExceptionCode());
		}
		
		
		
		
		
		
		//test change password 
		if(teacherService.login("120160821", "teach123")) {
			//test when change the password successfully
			if(teacherService.updatePassword("teach123", "teach1234", "teach1234")) {
				System.out.println("change the password successfully");
			}
			//test when wrong password
			if(teacherService.updatePassword("szx1234", "szx", "szx") == false ) {
				System.out.println(teacherService.getExceptionCode());
			}
			//test when password fails to match
			if(teacherService.updatePassword("teach1234", "szx123", "szx1234") == false ) {
				System.out.println(teacherService.getExceptionCode());
			}
		}
		
		
		
		
		
		
		//test update info
		if(teacherService.login("120160821", "teach1234")) {
			teacherService.getCacheTeacher().setEmailAddress("teachertest@gmail.com");
			if(teacherService.updateInfo(teacherService.getCacheTeacher())) {
				teacherService.login("120160821", "teach1234");
				System.out.println(teacherService.getCacheTeacher().getEmailAddress());
				System.out.println("change successfully");
			}
		}
		
		
		
		//test destroy account
		if(teacherService.login("120160821", "teach1234")) {
			if(teacherService.deleteTeacherAccount("120160821")) {
				System.out.println("Delete the teacher account!");
			}
		}
	}
}
