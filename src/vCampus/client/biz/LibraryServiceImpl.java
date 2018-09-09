package vCampus.client.biz;

import java.util.ArrayList;

import vCampus.client.socket.Client;
import vCampus.util.Message;
import vCampus.util.MessageTypeCodes;
import vCampus.vo.BookBorrow;
import vCampus.vo.BookInformation;

/**
 * @author Administrator
 *
 */
public class LibraryServiceImpl implements LibraryService {

	
	private Client client;
	private String exceptionCode;
	private String studentUserName;
	private String teacherUserName;
	private String adminUserName;
	private ArrayList<BookBorrow> cacheBorrowedBooks;
	
	public LibraryServiceImpl(int UserType, String userName) {
		// TODO Auto-generated constructor stub
		client = new Client();
		exceptionCode = "";
		studentUserName = "";
		teacherUserName = "";
		adminUserName = "";
		if(UserType == 1) {
			studentUserName = userName;
			cacheBorrowedBooks = queryBookBorrow(studentUserName);
		}
		
		if(UserType == 2) {
			teacherUserName = userName;
			cacheBorrowedBooks = queryBookBorrow(teacherUserName);
		}
		
		if(UserType == 3) {
			adminUserName = userName;
		}
	}
	
	
	
	@Override
	public String getExceptionCode() {
		// TODO Auto-generated method stub
		return exceptionCode;
	}
	
	@Override
	public BookInformation queryBookInformation(String bookID) {
		// TODO Auto-generated method stub
		exceptionCode = "";
		
		Message message = new Message();
		message.setUserType("User");
		ArrayList<Object> data = new ArrayList<Object>();
		data.add(bookID);
		message.setData(data);
		message.setMessageType(MessageTypeCodes.userQueryBookInformation);
		
		Message serverResponse = client.sendRequestToServer(message);
		ArrayList<Object> paras = (ArrayList<Object>) serverResponse.getData();
		
		if(paras != null) {
			return (BookInformation) paras.get(0);
		}
		if(!serverResponse.getExceptionCode().equals("")) {
			exceptionCode = serverResponse.getExceptionCode();
		}
		
		return null;
	}
	
	@Override
	public ArrayList<BookInformation> queryBook(String bookName) {
		// TODO Auto-generated method stub
		exceptionCode = "";
		
		Message message = new Message();
		message.setMessageType("User");
		ArrayList<Object> data = new ArrayList<Object>();
		data.add(bookName);
		message.setData(data);
		message.setMessageType(MessageTypeCodes.userQueryBookByBookname);
		
		Message serverResponse = client.sendRequestToServer(message);
		ArrayList<Object> paras = (ArrayList<Object>) serverResponse.getData();
		
		if(paras != null) {
			return (ArrayList<BookInformation>) paras.get(0);
		}
		if(!serverResponse.getExceptionCode().equals("")) {
			exceptionCode = serverResponse.getExceptionCode();
		}
		
		return null;
	}
	
	@Override
	public ArrayList<BookBorrow> queryBookBorrow(String userName) {
		// TODO Auto-generated method stub
		exceptionCode = "";
		
		Message message = new Message();
		message.setUserType("User");
		ArrayList<Object> data = new ArrayList<Object>();
		data.add(userName);
		message.setData(data);
		message.setMessageType(MessageTypeCodes.userQueryBookBorrow);
		
		Message serverResponse = client.sendRequestToServer(message);
		ArrayList<Object> paras = (ArrayList<Object>) serverResponse.getData();
		
		if(paras != null) {
			if(!studentUserName.equals("")) {
				cacheBorrowedBooks = (ArrayList<BookBorrow>) paras.get(0);
			}
			if(!teacherUserName.equals("")) {
				cacheBorrowedBooks = (ArrayList<BookBorrow>) paras.get(0);
			}
			return (ArrayList<BookBorrow>) paras.get(0);
		}
		if(!serverResponse.getExceptionCode().equals("")) {
			exceptionCode = serverResponse.getExceptionCode();
		}
		return null;
	}
	
	@Override
	public boolean borrowBook(BookBorrow borrow) {
		// TODO Auto-generated method stub
		exceptionCode = "";
		
		Message message = new Message();
		message.setUserType("USER");
		ArrayList<Object> data = new ArrayList<Object>();
		data.add(borrow);
		message.setData(data);
		message.setMessageType(MessageTypeCodes.userBorrowBook);
		
		Message serverResponse = client.sendRequestToServer(message);
		ArrayList<Object> paras = (ArrayList<Object>) serverResponse.getData();
		
		if(paras != null) {
			boolean isBorrowBook = (boolean) paras.get(0);
			if(isBorrowBook) {
				return true;
			}
		}
		
		if(!serverResponse.getExceptionCode().equals("")) {
			exceptionCode = message.getExceptionCode();
		}
		return false;
	}
	
	
	@Override
	public boolean returnBook(BookBorrow borrow) {
		// TODO Auto-generated method stub
		exceptionCode = "";
		Message message = new Message();
		message.setUserType("USER");
		ArrayList<Object> data = new ArrayList<Object>();
		data.add(borrow);
		message.setData(data);
		message.setMessageType(MessageTypeCodes.userReturnBook);
		
		Message serverResponse = client.sendRequestToServer(message);
		ArrayList<Object> paras = (ArrayList<Object>) serverResponse.getData();
		
		if(paras != null) {
			boolean isReturnBook = (boolean) paras.get(0);
			if(isReturnBook) {
				return true;
			}
		}
		
		if(!serverResponse.getExceptionCode().equals("")) {
			exceptionCode = message.getExceptionCode();
		}
		return false;
	}
	
	@Override
	public boolean addBookByAdmin(BookInformation book) {
		// TODO Auto-generated method stub
		exceptionCode = "";
		Message message = new Message();
		message.setUserType("ADMIN");
		ArrayList<Object> data = new ArrayList<Object>();
		data.add(book);
		message.setData(data);
		message.setMessageType(MessageTypeCodes.adminAddBook);
		
		Message serverResponse = client.sendRequestToServer(message);
		ArrayList<Object> paras = (ArrayList<Object>) serverResponse.getData();
		
		if(paras != null) {
			boolean isAddBookByAdmin = (boolean) paras.get(0);
			if(isAddBookByAdmin) {
				return true;
			}
		}
		if(!serverResponse.getExceptionCode().equals("")) {
			exceptionCode = message.getExceptionCode();
		}
		return false;
	}
	
	
	@Override
	public boolean deleteBookByAdmin(String bookID) {
		// TODO Auto-generated method stub
		exceptionCode = "";
		Message message = new Message();
		message.setUserType("ADMIN");
		ArrayList<Object> data = new ArrayList<Object>();
		data.add(bookID);
		message.setData(data);
		message.setMessageType(MessageTypeCodes.adminDeleteBook);
		
		Message serverResponse = client.sendRequestToServer(message);
		ArrayList<Object> paras = (ArrayList<Object>) serverResponse.getData();
		
		if(paras != null) {
			boolean idDeleteBookByAdmin = (boolean) paras.get(0);
			if(idDeleteBookByAdmin) {
				return true;
			}
		}
		if(!serverResponse.getExceptionCode().equals("")) {
			exceptionCode = message.getExceptionCode();
		}
		return false;
	}
	
	
	
	@Override
	public boolean updateBookByAdmin(BookInformation book) {
		exceptionCode = "";
		
		Message message = new Message();
		message.setUserType("ADMIN");
		ArrayList<Object> data = new ArrayList<Object>();
		data.add(book);
		message.setData(data);
		message.setMessageType(MessageTypeCodes.adminUpdateBook);
		
		Message serverResponse = client.sendRequestToServer(message);
		ArrayList<Object> paras = (ArrayList<Object>) serverResponse.getData();
		
		if(paras != null) {
			boolean isUpdateBookByAdmin = (boolean) paras.get(0);
			if(isUpdateBookByAdmin) {
				return true;
			}
		}
		
		if(!serverResponse.getExceptionCode().equals(""))
		{
			// TODO Auto-generated method stub
			exceptionCode = serverResponse.getExceptionCode();
		}
		return false;
	}
	
	
}
