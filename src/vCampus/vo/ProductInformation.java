package vCampus.vo;

import java.io.Serializable;

public class ProductInformation implements Serializable{

	private String productID;
	private String productName;
	private double productPrice;
	private int amount;
	
	public void setProductID(String productID) {
		this.productID = productID;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public String getProductID() {
		return productID;
	}
	public String getProductName() {
		return productName;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public int getAmount() {
		return amount;
	}
	
	@Override
	public String toString() {
		return "\nProductInformation"
				+"\nProductID\t"+productID
				+"\nProductName\t"+productName
				+"\nProductPrice\t"+productPrice
				+"\nAmount\t"+amount;
	}
}