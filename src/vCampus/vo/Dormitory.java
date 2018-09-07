package vCampus.vo;

import java.io.Serializable;
import java.sql.Date;

public class Dormitory implements Serializable {
    private String studentEcardNumber;
	private Date monthtime;
    private String dormNumber;
	private double dormBill;
	private double score;
	
	public void setStudentEcardNumber(String studentEcardNumber) {
		this.studentEcardNumber=studentEcardNumber;
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
	public void setMonthtime(Date monthtime){
		this.monthtime=monthtime;
	}

	public String getStudentEcardNumber() {
		return studentEcardNumber;
	}
	public Date getMonthtime(){
		return monthtime;
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
}
