package vCampus.client.biz;

import java.util.ArrayList;

import net.ucanaccess.util.Logger.Messages;
import vCampus.client.socket.Client;
import vCampus.util.Message;
import vCampus.util.MessageTypeCodes;
import vCampus.vo.Dormitory;

/**
 * @author Administrator
 *
 */
public class DormitoryServiceImpl implements DormitoryService{

	
	private Client client;
	private String exceptionCode;
	
	
	public DormitoryServiceImpl() {
		// TODO Auto-generated constructor stub
		client = new Client();
		exceptionCode = "";
	}
	
	public String getExceptionCode() {
		return exceptionCode;
	}
	
	@Override
	public ArrayList<Dormitory> queryDormitoryByDormNumber(String dormNumber) {
		// TODO Auto-generated method stub
		exceptionCode = "";
		Message message = new Message();
		
		message.setUserType("User");
		ArrayList<Object> data = new ArrayList<Object>();
		data.add(dormNumber);
		message.setData(data);
		message.setMessageType(MessageTypeCodes.userQueryDormitoryByDormNumber);
		
		Message serverResponse = client.sendRequestToServer(message);
		ArrayList<Object> paras = (ArrayList<Object>) serverResponse.getData();
		
		if(paras != null) {
			return (ArrayList<Dormitory>) paras.get(0);
		}
		return null;
	}
	
	@Override
	public ArrayList<Dormitory> queryDormitoryByUserName(String userName) {
		// TODO Auto-generated method stub
		exceptionCode = "";
		Message message = new Message();
		
		message.setUserType("User");
		ArrayList<Object> data = new ArrayList<Object>();
		data.add(userName);
		message.setData(data);
		message.setMessageType(MessageTypeCodes.userQueryAccountCurrentByUserName);
		
		Message serverResponse = client.sendRequestToServer(message);
		ArrayList<Object> paras = (ArrayList<Object>) serverResponse.getData();
		
		if(paras != null) {
			return (ArrayList<Dormitory>) paras.get(0);
		}
		return null;
	}
	
	@Override
	public boolean addDormitoryInfo(Dormitory dorm) {
		// TODO Auto-generated method stub
		exceptionCode = "";
		
		Message message = new Message();
		
		message.setUserType("User");
		ArrayList<Object> data = new ArrayList<Object>();
		data.add(dorm);
		message.setData(data);
		message.setMessageType(MessageTypeCodes.userAddDormitoryInfo);
		
		Message serverResponse = client.sendRequestToServer(message);
		ArrayList<Object> paras = (ArrayList<Object>) serverResponse.getData();
		
		if(paras != null) {
			 boolean isAddDormitory = (boolean) paras.get(0);
			 if(isAddDormitory) return true;
		}
		return false;
	}
	
	
}
