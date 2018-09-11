package vCampus.client.biz;

import java.util.ArrayList;
import java.util.Collection;

import vCampus.client.socket.Client;
import vCampus.server.exception.WrongPasswordException;
import vCampus.util.Message;
import vCampus.util.MessageTypeCodes;
import vCampus.vo.Student;

/**
 * @author SongZixing
 * 
 * @version 0.0
 * 
 * This is the implement for StudentService
 *
 */
public class StudentServiceImpl implements StudentService{
	
	private Client client;
	private String exceptionCode;
	private Student cacheStudent;
	
	
	/**
	 * @param
	 * 
	 */
	public StudentServiceImpl() {
		// TODO Auto-generated constructor stub
		client = new Client();
		exceptionCode = "";
		cacheStudent = null;
	}
	

	public String getExceptionCode() {
		return exceptionCode;
	}


	public Student getCacheStudent() {
		return cacheStudent;
	}

	
	public Student getUpdatedStudent() {
		if(login(cacheStudent.getUserName(),cacheStudent.getPassword())) {
			return cacheStudent;
		}
		return cacheStudent;
	}

	/* (non-Javadoc)
	 * @see vCampus.client.biz.StudentService#login(int, java.lang.String)
	 */
	@Override
	public boolean login(String studentID, String studentPassword) {
		// TODO Auto-generated method stub
		Message message = new Message();
		message.setUserType("STUDENT");
		ArrayList<Object> data = new ArrayList<Object>();
		data.add(studentID);
		data.add(studentPassword);
		message.setData(data);
		message.setMessageType(MessageTypeCodes.studentLogin);
		Message serverResponse = client.sendRequestToServer(message);
		ArrayList<Object> paras = (ArrayList<Object>) serverResponse.getData();
		
		if(paras != null) {
			Student newStudent = (Student) paras.get(0);
			
			if(newStudent != null)
			{
				cacheStudent = newStudent;
				return true;
			}
		}
		
		if(serverResponse.getExceptionCode()!=null) {
			exceptionCode = serverResponse.getExceptionCode();
		}
		return false;
	}
	
	@Override
	public boolean register(String studentID, String studentPassword, String studentConfirmedPassword) {
		// TODO Auto-generated method stub
		if(!studentConfirmedPassword.equals(studentPassword)) {
			exceptionCode = "UnmachedPassword";
			return false;
		}
		Message message = new Message();
		message.setUserType("STUDENT");
		ArrayList<Object> data =new ArrayList<Object>();
		data.add(studentID);
		data.add(studentPassword);
		message.setData(data);
		message.setMessageType(MessageTypeCodes.studentRegister);
		Message serverResponse = client.sendRequestToServer(message);
		ArrayList<Object> paras = (ArrayList<Object>) serverResponse.getData();
		
		if(paras != null) {
		Student newStudent = (Student) paras.get(0);
		
		if(newStudent != null) {
			cacheStudent = newStudent;
			return true;
		}
		}
	
		if(serverResponse.getExceptionCode()!=null) {
			exceptionCode = serverResponse.getExceptionCode();
		}
		return false;
	} 
	
	@Override
	public boolean updatePassword(String originalPassword, String newPassword, String newConfirmedPassword) {
		// TODO Auto-generated method stub
		if(!originalPassword.equals(cacheStudent.getPassword())) {
			exceptionCode = "WrongPasswordException";
			return false;
		}
		
		
		if(!newPassword.equals(newConfirmedPassword)) {
			exceptionCode = "UnmachedPassword";
			return false;
		}
		
		Message message = new Message();
		message.setUserType("STUDENT");
		ArrayList<Object> data = new ArrayList<Object>();
		data.add(cacheStudent.getUserName());
		data.add(newPassword);
		message.setData(data);
		message.setMessageType(MessageTypeCodes.studentChangePassword);
		Message serverResponse = client.sendRequestToServer(message);
		ArrayList<Object> paras = (ArrayList<Object>) serverResponse.getData();
		
		if(paras != null) {
			Student updatedStudent = (Student) paras.get(0);
			
			if(updatedStudent != null) {
				cacheStudent = updatedStudent;
				return true;
			}
		}
		
		
		if(!serverResponse.getExceptionCode().equals("")) {
			exceptionCode = serverResponse.getExceptionCode();
		}
	
		return false;
	}
	
	@Override
	public boolean updateInfo(Student updatedStudent) {
		// TODO Auto-generated method stub
		
		Message message = new Message();
		message.setUserType("STUDENT");
		ArrayList<Object> data = new ArrayList<Object>();
		data.add(updatedStudent);
		message.setData(data);
		message.setMessageType(MessageTypeCodes.studentUpdateInfomation);
		Message serveReponse = client.sendRequestToServer(message);
		ArrayList<Object> para = (ArrayList<Object>) serveReponse.getData();
		Student updateStudent = (Student) para.get(0);
		
		if(updateStudent != null) {
			cacheStudent = updatedStudent;
			return true;
		}
		
		if(!serveReponse.getExceptionCode().equals("")) {
			exceptionCode = serveReponse.getExceptionCode();
		}
		return false;
	}
	
	
	@Override
	public boolean deleteStudentAccount(String userName) {
		// TODO Auto-generated method stub
		Message message = new Message();
		message.setUserType("STUDENT");
		ArrayList<Object> data = new ArrayList<Object>();
		data.add(userName);
		message.setData(data);
		message.setMessageType(MessageTypeCodes.studentDestroyAccount);
		Message serverResponse = client.sendRequestToServer(message);
		ArrayList<Object> para = (ArrayList<Object>) serverResponse.getData();
		boolean isDestroy = (boolean) para.get(0);
		
		if(isDestroy) return true;
		
		if(!serverResponse.getExceptionCode().equals("")) {
			exceptionCode = serverResponse.getExceptionCode();
		}
		return false;
	}
	
}
