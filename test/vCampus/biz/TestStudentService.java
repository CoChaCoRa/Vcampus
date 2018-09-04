package vCampus.biz;

import vCampus.client.biz.StudentService;
import vCampus.client.biz.StudentServiceImpl;

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
		
		
		//test login
		if(studentService.login("213160821", "szx123"))
		{
			System.out.println(studentService.getCacheStudent().getUserName()+",hello!");
		}
	}
}
