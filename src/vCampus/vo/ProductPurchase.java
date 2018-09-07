package vCampus.vo;

import java.io.Serializable;
import java.sql.Date;

public class ProductPurchase implements Serializable{
	private String productID;
	private String productName;
	private int purchaseAmount;
	private String userName;
	private Date purchaseTime;
	private double oneConsumption;
	private double currentAccount;
	
	public void setProductID(String productID){
		this.productID = productID;
	}
	public void setProductName(String productName){
		this.productName = productName;
	}
	public void setPurchaseAmount(int purchaseAmount) {
		this.purchaseAmount = purchaseAmount;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setPurchaseTime(Date purchaseTime) {
		this.purchaseTime = purchaseTime;
	}
	public void setOneConsumption(double consumption){
		this.oneConsumption=consumption;
	}
	public void setCurrentAccount(double currentAccount){
		this.currentAccount=currentAccount;
	}

	public String getProductID(){
		return productID;
	}
	public String getProductName() {
		return productName;
	}
	public int getPurchaseAmount() {
		return purchaseAmount;
	}
	public String getUserName() {
		return userName;
	}
	public Date getPurchaseTime() {
		return purchaseTime;
	}
	public double getOneConsumption(){
		return oneConsumption;
	}
	public double getCurrentAccount(){
		return currentAccount;
	}
	
	@Override
	public String toString() {
		return "\nProductPurchase\t"
			+"\nProductID\t"+productID
			+"\nProductName\t"+productName
			+"\nPurchaseAmount\t"+purchaseAmount
			+"\nUserName\t"+userName
			+"\nPurchaseTime\t"+purchaseTime
			+"\nOneConsumption\t"+oneConsumption
			+"\nCurrentAccount\t"+currentAccount;
	}
}