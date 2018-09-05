package vCampus.client.biz;

import java.util.ArrayList;

import vCampus.client.socket.Client;
import vCampus.util.Message;
import vCampus.util.MessageTypeCodes;
import vCampus.vo.Admin;
import vCampus.vo.Student;

/**
 * @author Administrator
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
		Message serverRespose = client.sendRequestToServer(message);
		ArrayList<Object> paras = (ArrayList<Object>) serverRespose.getData();
		Admin newAdmin = (Admin) paras.get(0);
		
		if(newAdmin != null) {
			cacheAdmin = newAdmin;
			return true;
		}
		else exceptionCode = serverRespose.getExceptionCode();
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
		Admin admin = (Admin) paras.get(0);
		
		if(admin != null) {
			cacheAdmin = admin;
			return true;
		}
		if(!serverResponse.getExceptionCode().equals("")) {
			
		}
		return false;
	}
	
	
}
