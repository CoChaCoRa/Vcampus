package vCampus.client.biz;

import java.security.Policy.Parameters;
import java.util.ArrayList;

import vCampus.client.socket.Client;
import vCampus.util.Message;
import vCampus.util.MessageTypeCodes;
import vCampus.vo.ProductInformation;
import vCampus.vo.ProductPurchase;

public class ShopServiceImpl implements ShopService{
	
	private Client client;
	private String exceptionCode;
	private String studentUserName;
	private String teacherUserName;
	private String adminUserName;
	
	public ShopServiceImpl(int userType, String userName) {
		// TODO Auto-generated constructor stub
		client = new Client();
		exceptionCode = "";
		if(userType == 1) {
			studentUserName = userName;
			
		}
		if(userType == 2) {
			teacherUserName = userName;
			
		}
		if(userType == 3) {
			adminUserName = userName;
			
		}
		
	}
	
	
	@Override
	public String getExceptionCodes() {
		// TODO Auto-generated method stub
		return exceptionCode;

	}
	
	@Override
	public ArrayList<ProductPurchase> queryAccountCurrentByProductID(String productID) {
		// TODO Auto-generated method stub
		exceptionCode = "";
		Message message = new Message();
		
		message.setUserType("User");
		ArrayList<Object> data = new ArrayList<Object>();
		data.add(productID);
		message.setData(data);
		message.setMessageType(MessageTypeCodes.userQueryAccountCurrentByProductID);
		
		Message serverResponse = client.sendRequestToServer(message);
		ArrayList<Object> paras = (ArrayList<Object>) serverResponse.getData();
		
		if(paras != null) {
			ArrayList<ProductPurchase> purchases = (ArrayList<ProductPurchase>) paras.get(0);
			return purchases;
		}
		
		if(!serverResponse.getExceptionCode().equals("")) {
			exceptionCode = serverResponse.getExceptionCode();
		}
		return null;
	}
	
	
	@Override
	public ArrayList<ProductPurchase> queryAccountCurrentByUserName(String userName) {
		// TODO Auto-generated method stub
		exceptionCode = "";
		Message message = new Message();
		message.setUserType("USER");
		ArrayList<Object> data = new ArrayList<Object>();
		data.add(userName);
		message.setData(data);
		message.setMessageType(MessageTypeCodes.userQueryAccountCurrentByUserName);
		
		Message serverResponse = client.sendRequestToServer(message);
		ArrayList<Object> paras = (ArrayList<Object>) serverResponse.getData();
		
		if(paras != null) {
			ArrayList<ProductPurchase> purchases = (ArrayList<ProductPurchase>) paras.get(0);
			return purchases;
		}
		
		if(!serverResponse.getExceptionCode().equals("")) {
			exceptionCode = serverResponse.getExceptionCode();
			
		}
		return null;
	}
	
	
	
	@Override
	public ArrayList<ProductInformation> queryAllProduct() {
		// TODO Auto-generated method stub
		exceptionCode = "";
		Message message = new Message();
		message.setUserType("USER");
		message.setMessageType(MessageTypeCodes.userQueryAllProduct);

		Message serverResponse = client.sendRequestToServer(message);
		ArrayList<Object> paras = (ArrayList<Object>) serverResponse.getData();
		
		if(paras != null) {
				ArrayList<ProductInformation> allProducts = (ArrayList<ProductInformation>) paras.get(0);
				return allProducts;
		}
		if(!serverResponse.getExceptionCode().equals("")) {
			exceptionCode = serverResponse.getExceptionCode();
			
		}
		return null;
	}
	
	
	
	@Override
	public ProductInformation queryProductInformation(String productID) {
		// TODO Auto-generated method stub
		exceptionCode = "";
		Message message = new Message();
		message.setUserType("USER");
		ArrayList<Object> data = new ArrayList<Object>();
		data.add(productID);
		message.setData(data);
		message.setMessageType(MessageTypeCodes.userQueryProductInformation);
		
		Message serverResponse = client.sendRequestToServer(message);
		
		ArrayList<Object> paras = (ArrayList<Object>) serverResponse.getData();
		
		if(paras != null) {
			ProductInformation res = (ProductInformation)paras.get(0);
			return res;
		}
		
		if(!serverResponse.getExceptionCode().equals("")) {
			exceptionCode = serverResponse.getExceptionCode();
			
		}
		return null;
	}
	
	@Override
	public boolean buyProduct(ProductPurchase buyProduct, int type) {
		// TODO Auto-generated method stub
		exceptionCode = "";
		Message message = new Message();
		message.setUserType("USER");
		ArrayList<Object> data = new ArrayList<Object>();
		
		data.add(buyProduct);
		data.add(type);
		message.setData(data);
		message.setMessageType(MessageTypeCodes.userBuyProduct);
		Message serverResponse = client.sendRequestToServer(message);
		
		ArrayList<Object> paras = (ArrayList<Object>) serverResponse.getData();
		
		if(paras != null) {
			boolean isBuyProduct = (boolean) paras.get(0);
			if(isBuyProduct) return true;
		}
		if(!serverResponse.getExceptionCode().equals("")) {
			exceptionCode = serverResponse.getExceptionCode();
			
		}
		return false;
	}
	
	
	@Override
	public boolean addProductByAdmin(ProductInformation product) {
		// TODO Auto-generated method stub
		exceptionCode = "";
		Message message = new Message();
		message.setUserType("ADMIN");
		ArrayList<Object> data = new ArrayList<Object>();
		data.add(product);
		message.setData(data);
		message.setMessageType(MessageTypeCodes.adminAddProduct);
		
	Message serverResponse = client.sendRequestToServer(message);
		
		ArrayList<Object> paras = (ArrayList<Object>) serverResponse.getData();
		
		if(paras != null) {
			boolean isAddProduct = (boolean) paras.get(0);
			if(isAddProduct) return true;
		}
		if(!serverResponse.getExceptionCode().equals("")) {
			exceptionCode = serverResponse.getExceptionCode();
		}
		return false;
	}
	
	
	
	@Override
	public boolean updateProductByAdmin(ProductInformation product) {
		// TODO Auto-generated method stub
		exceptionCode = "";
		Message message = new Message();
		message.setUserType("Admin");
		ArrayList<Object> data = new ArrayList<Object>();
		data.add(product);
		message.setData(data);
		message.setMessageType(MessageTypeCodes.adminUpdateProduct);
		Message serverResponse = client.sendRequestToServer(message);
		
		ArrayList<Object> paras = (ArrayList<Object>) serverResponse.getData();
		
		if(paras != null) {
			boolean isUpdateProduct = (boolean) paras.get(0);
			if(isUpdateProduct) return true;
		}
		if(!serverResponse.getExceptionCode().equals("")) {
			exceptionCode = serverResponse.getExceptionCode();
		}
		return false;
	}
	
	
	
	@Override
	public boolean deleteProductByAdmin(String productID) {
		// TODO Auto-generated method stub
		exceptionCode = "";
		Message message = new Message();
		message.setUserType("ADMIN");
		ArrayList<Object> data = new ArrayList<Object>();
		data.add(productID);
		message.setData(data);
		message.setMessageType(MessageTypeCodes.adminDeleteProduct);
		Message serverResponse = client.sendRequestToServer(message);
		
		ArrayList<Object> paras = (ArrayList<Object>) serverResponse.getData();
		
		if(paras != null) {
			boolean isDeleteProduct = (boolean) paras.get(0);
			if(isDeleteProduct) return true;
		}
		if(!serverResponse.getExceptionCode().equals("")) {
			exceptionCode = serverResponse.getExceptionCode();
		}
		return false;

	}
	
	
	
}
