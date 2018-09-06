package vCampus.vo;

import java.io.Serializable;

/**
 * @author YangHangyuan
 *
 */
public class BookInformation implements Serializable {
	private String bookID;
	private String bookName;
	private String bookWriter;
	private String bookPress;
	private String bookAddress;
	private int totalAmount;
	private int borrowedAmount;
	
	public void setBookID(String bookID){
		this.bookID=bookID;
	}
	public void setBookName(String bookName){
		this.bookName=bookName;
	}
	public void setBookWriter(String bookWriter){
		this.bookWriter=bookWriter;
	}
	public void setBookPress(String bookPress){
		this.bookPress=bookPress;
	}
	public void setBookAddress(String bookAddress){
		this.bookAddress=bookAddress;
	}
	public void setTotalAmount(int totalAmount){
		this.totalAmount=totalAmount;
	}
	public void setBorrowedAmount(int borrowedAmount){
		this.borrowedAmount=borrowedAmount;
	}
	
	public String getBookID(){
		return bookID;
	}
	public String getBookName(){
		return bookName;
	}
	public String getBookWriter(){
		return bookWriter;
	}
	public String getBookPress(){
		return bookPress;
	}
	public String getBookAddress(){
		return bookAddress;
	}
	public int getTotalAmount(){
		return totalAmount;
	}
	public int getBorrowedAmount(){
		return borrowedAmount;
	}
	
	@Override
    public String toString() {
        return "\nBookInformaiton\t"
        		+"\nbookID\t" + bookID
                +"\nbookName\t" + bookName 
                +"\nbookWriter\t" + bookWriter
                +"\nbookPress\t" + bookPress
                +"\nbookAddress\t" + bookAddress
                +"\ntotalAmount\t"+ Integer.toString(totalAmount)
                +"\nborrowedAmount\t"+ Integer.toString(borrowedAmount);
    }
}