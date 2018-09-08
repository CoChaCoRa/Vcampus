package vCampus.vo;

import java.io.Serializable;
import java.sql.Date;

public class Dormitory implements Serializable {
    private String userName;
	private Date chargeTime;
    private String dormNumber;
	private double dormBill;
	private double score;
	
	public void setUserName(String userName) {
		this.userName=userName;
	}
	public void setScore(double score) {
		this.score=score;
	}
	public void setDormNumber(String dormNumber) {
		this.dormNumber=dormNumber;
	}
	public void setDormBill(double dormBill){
		this.dormBill=dormBill;
	}
	public void setChargeTime(Date chargeTime){
		this.chargeTime=chargeTime;
	}

	public String getUserName() {
		return userName;
	}
	public Date getChargeTime(){
		return chargeTime;
	}
	public String getDormNumber() {
		return dormNumber;
	}
	public double getDormBill(){
		return dormBill;
	}
	public double getScore(){
		return score;
	}
	
	@Override
	public String toString() {
		return "\nDormitory\t"
			+"\nstudentName\t"+userName
			+"\nchargeTime\t"+chargeTime
			+"\ndormNumber\t"+dormNumber
			+"\ndormBill\t"+dormBill
			+"\nscore\t"+score;
	}
}
