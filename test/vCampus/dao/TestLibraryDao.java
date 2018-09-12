package vCampus.dao;

import java.util.ArrayList;

import vCampus.server.dao.LibraryDao;
import vCampus.server.dao.LibraryDaoImpl;
import java.sql.Date;
import vCampus.server.exception.*;
import vCampus.vo.*;

public class TestLibraryDao {
	private static LibraryDao libImpl=new LibraryDaoImpl();
	
	/*
	public BookInformation queryBookInformation(String bookID);
	public ArrayList<BookInformation> queryBook(String bookName);
	public ArrayList<BookBorrow> queryBookBorrow(String userName);
	public boolean borrowBook(BookBorrow borrow)throws RecordNotFoundException,OutOfLimitException;
	public boolean returnBook(BookBorrow borrow)throws RecordNotFoundException,OutOfLimitException;
	public boolean addBookByAdmin(BookInformation book)throws RecordAlreadyExistException;
	public boolean updateBookByAdmin(BookInformation book)throws RecordNotFoundException;
	public boolean deleteBookByAdmin(String bookID)throws RecordNotFoundException;
	*/

	private static void queryBookInformation(String bookID) {
		BookInformation book=libImpl.queryBookInformation(bookID);
		if(book==null) {
			System.out.println("NULL!\n");
			return;
		}
		System.out.println(book);
	}
	private static void queryBook(String bookName) {
		ArrayList<BookInformation> list=new ArrayList<BookInformation>();
		list=libImpl.queryBook(bookName);
		if(list==null) {
			System.out.println("NULL!\n");
			return;
		}
		for(int i=0;i<list.size();i++)
			System.out.println(Integer.toString(i)+":  "+list.get(i));
	}
	private static void queryBookBorrow(String userName){
		ArrayList<BookBorrow> list=new ArrayList<BookBorrow>();
		list=libImpl.queryBookBorrow(userName);
		if(list==null) {
			System.out.println("NULL!\n");
			return;
		}
		for(int i=0;i<list.size();i++)
			System.out.println(Integer.toString(i)+":  "+list.get(i));
	}
	private static boolean borrowBook(BookBorrow borrow)throws Exception{
		return libImpl.borrowBook(borrow);
	}
	private static boolean returnBook(BookBorrow borrow)throws Exception{
		return libImpl.returnBook(borrow);
	}
	private static boolean addBookByAdmin(BookInformation book)throws Exception{
		return libImpl.addBookByAdmin(book);
	}
	private static boolean updateBookByAdmin(BookInformation book)throws Exception{
		return libImpl.updateBookByAdmin(book);
	}
	private static boolean deleteBookByAdmin(String bookID)throws Exception{
		return libImpl.deleteBookByAdmin(bookID);
	}
	
	public static void main(String[] args) {
		try {
			queryBook("Ëã·¨");
			queryBookInformation("1");
			queryBookBorrow("213161269");
			
			BookBorrow bookborrow=new BookBorrow();
			bookborrow.setBookID("1");
			bookborrow.setBorrowNumber(1);
			Date ts = new Date(System.currentTimeMillis()); 
			bookborrow.setBorrowTime(ts);
			bookborrow.setUserName("213161269");
			if(returnBook(bookborrow)) {
				queryBookBorrow("213161269");
			}else System.out.println("Error!");
			if(borrowBook(bookborrow)) {
				queryBookBorrow("213161269");
			}else System.out.println("Error!");
			
			BookInformation book=new BookInformation();
			book.setBookAddress("3C112");
			book.setBookID("100");
			book.setBookName("SONGZIXING");
			book.setBookPress("SEU");
			book.setBookWriter("CC");
			book.setTotalAmount(5);
			book.setBorrowedAmount(0);
			if(addBookByAdmin(book)) {
				queryBookInformation("100");
			}else System.out.println("Error!");
			
			book.setBookWriter("yhy");
			if(updateBookByAdmin(book)) {
				queryBookInformation("100");
			}else System.out.println("Error!");
			
			if(deleteBookByAdmin("100")) {
				queryBookInformation("100");
			}else System.out.println("Error!");
		}catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
