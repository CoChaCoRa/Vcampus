package vCampus.client.biz;

import java.util.ArrayList;

import vCampus.client.socket.Client;
import vCampus.server.biz.AdminServiceDao;
import vCampus.server.biz.StudentServiceDao;
import vCampus.util.Message;
import vCampus.util.MessageTypeCodes;
import vCampus.vo.Admin;
import vCampus.vo.Student;

/**
 * @author SongZixing
 *
 */
public class AdminServiceImpl implements AdminService{
	private Client client;
	private String exceptionCode;
	private Admin cacheAdmin;
	
	public AdminServiceImpl() {
		// TODO Auto-generated constructor stub
		client = new Client();
		exceptionCode = "";
		cacheAdmin = null;
	}

	public String getExceptionCode() {
		return exceptionCode;
	}

	public Admin getCacheAdmin() {
		return cacheAdmin;
	}
	
	@Override
	public boolean register(String userName, String password, String confirmedPassword) {
		// TODO Auto-generated method stub
		if(!password.equals(confirmedPassword)) {
			exceptionCode = "UnmachedPassword";
			return false;
		}
		
		Message message =new Message();
		message.setUserType("ADMIN");
		ArrayList<Object> data =new ArrayList<Object>();
		data.add(userName);
		data.add(password);
		message.setData(data);
		message.setMessageType(MessageTypeCodes.adminRegister);
		Message serverResponse = client.sendRequestToServer(message);
		ArrayList<Object> paras = (ArrayList<Object>) serverResponse.getData();
		
		if(paras != null) {
		
		Admin newAdmin = (Admin) paras.get(0);
		
		if(newAdmin != null) {
			cacheAdmin = newAdmin;
			return true;
		}
		
		}
		if(!serverResponse.getExceptionCode().equals("")) {
			exceptionCode = serverResponse.getExceptionCode();
		}
		return false;
	}
	
	
	@Override
	public boolean login(String userName, String password) {
		// TODO Auto-generated method stub
		
		Message message = new Message();
		message.setUserType("ADMIN");
		ArrayList<Object> data = new ArrayList<Object>();
		data.add(userName);
		data.add(password);
		message.setData(data);
		message.setMessageType(MessageTypeCodes.adminLogin);
		Message serverResponse = client.sendRequestToServer(message);
		ArrayList<Object> paras = (ArrayList<Object>) serverResponse.getData();
		
		if(paras != null) {
		Admin admin = (Admin) paras.get(0);
		
		if(admin != null) {
			cacheAdmin = admin;
			return true;
		}
		}
		if(!serverResponse.getExceptionCode().equals("")) {
			exceptionCode = serverResponse.getExceptionCode();
		}
		return false;
	}
	
	@Override
	public boolean updatePassword(String password) {
		// TODO Auto-generated method stub
		
		Message message = new Message();
		message.setUserType("ADMIN");
		ArrayList<Object> data = new ArrayList<Object>();
		data.add(cacheAdmin.getAdminID());
		data.add(password);
		message.setData(data);
		message.setMessageType(MessageTypeCodes.adminUpdatePassword);
		Message serverResponse = client.sendRequestToServer(message);
		ArrayList<Object> paras = (ArrayList<Object>) serverResponse.getData();
		
		if(paras != null)
		{
		Admin admin = (Admin) paras.get(0);
		
		if(admin != null) {
			cacheAdmin =admin;
			return true;
		}
		}
		
		if(!serverResponse.getExceptionCode().equals("")) {
			exceptionCode = serverResponse.getExceptionCode();
		}
		return false;
	}
	
	
	@Override
	public boolean destoryAccount(String userType, String userName) {
		// TODO Auto-generated method stub
		if(userType.equals("STUDENT")) {
			StudentService studentService =new StudentServiceImpl();
			boolean isDestroy = studentService.deleteStudentAccount(userName);
			if(isDestroy) return true;
			if(!studentService.getExceptionCode().equals("")) {
				exceptionCode = studentService.getExceptionCode();
				return false;
			}
		}
		
		if(userType.equals("TEACHER")) {
			TeacherService teacherService = new TeacherServiceImpl();
			boolean isDestroy = teacherService.deleteTeacherAccount(userName);
			if(isDestroy) return true;
			if(!teacherService.getExceptionCode().equals("")) {
				exceptionCode = teacherService.getExceptionCode();
				return false;
			}
		}
		
		
		if(userType.equals("ADMIN")) {
			Message message = new Message();
			message.setUserType("ADMIN");
			ArrayList<Object> data = new ArrayList<Object>();
			data.add(userName);
			message.setData(data);
			message.setMessageType(MessageTypeCodes.adminDestroyAccount);
			Message serverResponse = client.sendRequestToServer(message);
			ArrayList<Object> paras = (ArrayList<Object>) serverResponse.getData();
			
			if(!paras.isEmpty())
			{
			boolean isDestroy = (boolean) paras.get(0);
			
			if(isDestroy) return true;
			}
			if(!serverResponse.getExceptionCode().equals("")) {
				exceptionCode = serverResponse.getExceptionCode();
				return false;
			}
		}
		return false;
	}
	
	
	@Override
	public boolean addStudentAccount(Student newStudent) {
		// TODO Auto-generated method stub
		StudentService studentService = new StudentServiceImpl();
		if(studentService.register(newStudent.getUserName(), "password", "password")) {
			
			if(studentService.updateInfo(newStudent)) {
				return true;
			}
			else {
				exceptionCode = studentService.getExceptionCode();
				return false;
			}
		}
		exceptionCode = studentService.getExceptionCode();
		return false;
	}
	
	
	
	
	
	@Override
	public Student queryStudentInformation(String studentUserName) {
		// TODO Auto-generated method stub
		exceptionCode = "";
		Message message = new Message();
		message.setUserType("ADMIN");
		ArrayList<Object> data = new ArrayList<Object>();
		data.add(studentUserName);
		message.setData(data);
		message.setMessageType(MessageTypeCodes.adminFindStudent);
		Message serverResponse = client.sendRequestToServer(message);
		ArrayList<Object> paras = (ArrayList<Object>) serverResponse.getData();
		
		if(paras != null) {
		Student foundStudent = (Student) paras.get(0);
		
		if(foundStudent != null) {
			
			return foundStudent;
		}
		}
		if(!serverResponse.getExceptionCode().equals("")) {
			exceptionCode = serverResponse.getExceptionCode();
		}
		return null;
	}
	
	
	
	@Override
	public boolean updateStudentInformation(Student updatedStudent) {
		// TODO Auto-generated method stub
		if(queryStudentInformation(updatedStudent.getUserName()) != null) {
			Student foundStudent = queryStudentInformation(updatedStudent.getUserName());
			StudentService studentService = new StudentServiceImpl();
			if(studentService.login(foundStudent.getUserName(), foundStudent.getPassword())) {
				if(studentService.updateInfo(updatedStudent)) {
					return true;
				}
			}
			exceptionCode = studentService.getExceptionCode();
			return false;
		}
		else {
			return false;
		}

	}
	
	
	/* (non-Javadoc)
	 * @see vCampus.client.biz.AdminService#queryAccountByUserName(java.lang.String)
	 */
	@Override
	public double queryAccountByUserName(String userName) {
		// TODO Auto-generated method stub
		exceptionCode = "";
		Message message = new Message();
		message.setUserType("ADMIN");
		ArrayList<Object> data = new ArrayList<Object>();
		data.add(userName);
		message.setData(data);
		message.setMessageType(MessageTypeCodes.adminQueryAccountByUserName);
		Message serverResponse = client.sendRequestToServer(message);
		ArrayList<Object> paras = (ArrayList<Object>) serverResponse.getData();
		
		if(paras != null) {
			return (double) paras.get(0);
		}
		
		return -1;
	}

	
}
