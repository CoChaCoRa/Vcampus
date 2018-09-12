package vCampus.client.biz;

import java.util.ArrayList;

import vCampus.client.socket.Client;
import vCampus.server.exception.OutOfLimitException;
import vCampus.server.exception.RecordNotFoundException;
import vCampus.util.Message;
import vCampus.util.MessageTypeCodes;
import vCampus.vo.Recharge;

public class BankServiceImpl implements BankService{

	private Client client;
	private String exceptionCode;
	
	public BankServiceImpl() {
		// TODO Auto-generated constructor stub
		client = new Client();
		exceptionCode = "";
	}
	
	
	@Override
	public boolean rechargeByBankAccount(Recharge recharge) {
		// TODO Auto-generated method stub
		
			Message message =new Message();
			message.setUserType("USER");
			ArrayList<Object> data =new ArrayList<Object>();
			data.add(recharge);
			message.setData(data);
			
			message.setMessageType(MessageTypeCodes.userRechargeByBankAccount);
			Message serverResponse = client.sendRequestToServer(message);
			ArrayList<Object> paras = (ArrayList<Object>) serverResponse.getData();
			
			if(paras != null) {
				boolean isRechargeByBankAccount = (boolean) paras.get(0);
				if(isRechargeByBankAccount) return true;
			}
			
			
			if(!serverResponse.getExceptionCode().equals("")) {
				exceptionCode = serverResponse.getExceptionCode();
			}
			
	
		return false;
	}
}
