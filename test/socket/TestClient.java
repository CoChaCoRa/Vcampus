package socket;

import java.util.ArrayList;
import java.util.Collection;

import com.hxtt.c.r;

import vCampus.client.biz.StudentService;
import vCampus.client.biz.StudentServiceImpl;
import vCampus.client.socket.Client;
import vCampus.server.biz.StudentServiceDao;
import vCampus.server.biz.StudentServiceDaoImpl;
import vCampus.util.Message;
import vCampus.util.MessageTypeCodes;
import vCampus.vo.Student;

/**
 * @author SongZixing
 *
 * @version 0.0
 * 
 */
public class TestClient {
	
	public static void main(String[] args) {
//		Message test0 = new Message();
//		Client client = new Client();
//		test0.setUserType("STUDENT");
//		test0.setLoginAccount("213160821");
//		test0.setLoginPassword("szx123");
////
//		test0.setMessageType(MessageTypeCodes.studentLogin);
//		client.sendRequestToServer(test0);
		
		StudentServiceDao studentServiceDao = new StudentServiceDaoImpl();
		try {
			Student foundStudent = studentServiceDao.login("213160821", "szx123");
			//System.out.println(foundStudent.getStudentName());
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	
//		StudentService test0 = new StudentServiceImpl();
//		test0.login("213160821", "szx123");
	}
}
