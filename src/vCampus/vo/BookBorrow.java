package vCampus.vo;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * @author YangHangyuan
 *
 */
public class BookBorrow implements Serializable {
	
	private String userName;
	private String bookID;
	private Timestamp borrowTime;
	private int borrowNumber;
	
	public void setUserName(String userName){
		this.userName=userName;
	}
	public void setBookID(String bookID){
		this.bookID=bookID;
	}
	public void setBorrowTime(Timestamp borrowTime){
		this.borrowTime=borrowTime;
	}
	public void setBorrowNumber(int borrowNumber){
		this.borrowNumber=borrowNumber;
	}
	
	public String getUserName(){
		return userName;
	}
	public String getBookID(){
		return bookID;
	}
	public Timestamp getBorrowTime(){
		return borrowTime;
	}
	public int getBorrowNumber(){
		return borrowNumber;
	}
	
	@Override
	public String toString() {
		 DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 String str = df.format(borrowTime);
		return "\nBookBorrow\t"
			+"\nuserName\t"+userName
			+"\nbookID\t"+bookID
			+"\nborrowTime\t"+str
			+"\nborrowNumber\t"+Integer.toString(borrowNumber);
	}
	
}