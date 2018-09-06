package vCampus.client.biz;

import java.util.ArrayList;

import vCampus.client.socket.Client;
import vCampus.util.Message;
import vCampus.util.MessageTypeCodes;
import vCampus.vo.Teacher;

public class TeacherServiceImpl implements TeacherService{

	private Client client;
	private String exceptionCode;
	private Teacher cacheTeacher;
	
	public TeacherServiceImpl() {
		// TODO Auto-generated constructor stub
		client = new Client();
		exceptionCode = "";
		cacheTeacher = null;
	}

	public String getExceptionCode() {
		return exceptionCode;
	}

	public Teacher getCacheTeacher() {
		return cacheTeacher;
	}

	
	@Override
	public boolean register(String teacherID, String teacherPassword, String teacherConfirmedPassword) {
		// TODO Auto-generated method stub
		if(!teacherConfirmedPassword.equals(teacherPassword)) {
			exceptionCode = "UnmachedPassword";
			return false;
		}
		Message message = new Message();
		message.setUserType("TEACHER");
		ArrayList<Object> data =new ArrayList<Object>();
		data.add(teacherID);
		data.add(teacherPassword);
		message.setData(data);
		message.setMessageType(MessageTypeCodes.teacherRegister);
		Message serverResponse = client.sendRequestToServer(message);
		ArrayList<Object> paras = (ArrayList<Object>) serverResponse.getData();
		
		if(paras != null) {
		Teacher newTeacher = (Teacher) paras.get(0);
		
		if(newTeacher != null) {
			cacheTeacher = newTeacher;
			return true;
		}
		}
	
		if(serverResponse.getExceptionCode()!=null) {
			exceptionCode = serverResponse.getExceptionCode();
		}
		return false;
	}
	
	
	@Override
	public boolean login(String teacherID, String teacherPassword) {
		// TODO Auto-generated method stub
		Message message = new Message();
		message.setUserType("TEACHER");
		ArrayList<Object> data = new ArrayList<Object>();
		data.add(teacherID);
		data.add(teacherPassword);
		message.setData(data);
		message.setMessageType(MessageTypeCodes.teacherLogin);
		Message serverResponse = client.sendRequestToServer(message);
		ArrayList<Object> paras = (ArrayList<Object>) serverResponse.getData();
		
		if(paras != null) {
			Teacher newTeacher = (Teacher) paras.get(0);
			
			if(newTeacher != null)
			{
				cacheTeacher = newTeacher;
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
		if(!originalPassword.equals(cacheTeacher.getPassword())) {
			exceptionCode = "WrongPasswordException";
			return false;
		}
		
		
		if(!newPassword.equals(newConfirmedPassword)) {
			exceptionCode = "UnmachedPassword";
			return false;
		}
		
		Message message = new Message();
		message.setUserType("TEACHER");
		ArrayList<Object> data = new ArrayList<Object>();
		data.add(cacheTeacher.getUserName());
		data.add(newPassword);
		message.setData(data);
		message.setMessageType(MessageTypeCodes.teacherChangePassword);
		Message serverResponse = client.sendRequestToServer(message);
		ArrayList<Object> paras = (ArrayList<Object>) serverResponse.getData();
		
		if(paras != null) {
			Teacher updatedTeacher = (Teacher) paras.get(0);
			
			if(updatedTeacher != null) {
				cacheTeacher = updatedTeacher;
				return true;
			}
		}
		
		
		if(!serverResponse.getExceptionCode().equals("")) {
			exceptionCode = serverResponse.getExceptionCode();
		}
	
		return false;
	}
	

	
	@Override
	public boolean updateInfo(Teacher updatedTeacher) {
		// TODO Auto-generated method stub
		Message message = new Message();
		message.setUserType("TEACHER");
		ArrayList<Object> data = new ArrayList<Object>();
		data.add(updatedTeacher);
		message.setData(data);
		message.setMessageType(MessageTypeCodes.teacherUpdateInformation);
		Message serveReponse = client.sendRequestToServer(message);
		ArrayList<Object> para = (ArrayList<Object>) serveReponse.getData();
		Teacher updateTeacher = (Teacher) para.get(0);
		
		if(updateTeacher != null) {
			cacheTeacher = updateTeacher;
			return true;
		}
		
		if(!serveReponse.getExceptionCode().equals("")) {
			exceptionCode = serveReponse.getExceptionCode();
		}
		return false;
	}
	
	
	@Override
	public boolean deleteTeacherAccount(String userName) {
		// TODO Auto-generated method stub
		Message message = new Message();
		message.setMessageType("TEACHER");
		ArrayList<Object> data = new ArrayList<Object>();
		data.add(userName);
		message.setData(data);
		message.setMessageType(MessageTypeCodes.teacherDestroyAccount);
		Message serverResponse = client.sendRequestToServer(message);
		ArrayList<Object> paras = (ArrayList<Object>) serverResponse.getData();
		boolean isDestroy = (boolean) paras.get(0);
		
		if(isDestroy) return true;
		
		if(!serverResponse.getExceptionCode().equals("")) {
			exceptionCode = serverResponse.getExceptionCode();
		}
		return false;
	}
}
