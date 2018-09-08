package vCampus.vo;

import java.io.Serializable;
import java.sql.Date;

/**
 * @author YangHangyuan
 *
 */
public class Recharge implements Serializable{
	private String userName;
	private Date rechargeTime;
	private double amount;
	
	public void setUserName(String userName) {
		this.userName=userName;
	}
	public void setRechargeTime(Date rechargeTime) {
		this.rechargeTime=rechargeTime;
	}
	public void setAmount(double amount) {
		this.amount=amount;
	}
	
	public String getUserName() {
		return userName;
	}
	public Date getRechargeTime() {
		return rechargeTime;
	}
	public double getAmount() {
		return amount;
	}
	
}
