package vCampus.server.biz;

import java.util.ArrayList;

import vCampus.server.dao.LibraryDao;
import vCampus.server.dao.LibraryDaoImpl;
import vCampus.server.exception.OutOfLimitException;
import vCampus.server.exception.RecordAlreadyExistException;
import vCampus.server.exception.RecordNotFoundException;
import vCampus.vo.BookBorrow;
import vCampus.vo.BookInformation;

public class LibraryServiceDaoImpl implements LibraryServiceDao{

	private LibraryDao ld = new LibraryDaoImpl();
	
	@Override
	public BookInformation queryBookInformation(String bookID) {
		// TODO Auto-generated method stub
		if(ld.queryBookInformation(bookID) != null) {
			return ld.queryBookInformation(bookID);
		}
		return null;
	}
	
	
	
	@Override
	public ArrayList<BookInformation> queryBook(String bookName) {
		// TODO Auto-generated method stub
		if(ld.queryBook(bookName) != null) {
			return ld.queryBook(bookName);
		}
		return null;
	}
	
	
	@Override
	public ArrayList<BookBorrow> queryBookBorrow(String userName) {
		// TODO Auto-generated method stub
		if(ld.queryBookBorrow(userName) != null) {
			return ld.queryBookBorrow(userName);
		}
		return null;
	}
	
	
	@Override
	public boolean borrowBook(BookBorrow borrow) throws RecordNotFoundException, OutOfLimitException {
		// TODO Auto-generated method stub
		try {
			if(ld.borrowBook(borrow)) {
				return true;
			}
		} catch (RecordNotFoundException e) {
			// TODO: handle exception
			throw new RecordNotFoundException();
		}
		catch (OutOfLimitException e) {
			// TODO: handle exception
			throw new OutOfLimitException();
		}
		return false;
	}
	
	
	
	@Override
	public boolean returnBook(BookBorrow borrow) throws RecordNotFoundException, OutOfLimitException {
		// TODO Auto-generated method stub
		try {
			if(ld.returnBook(borrow)) {
				return true;
			}
			
		} catch (RecordNotFoundException e) {
			// TODO: handle exception
			
			throw new RecordNotFoundException();
		}
		
		catch (OutOfLimitException e) {
			// TODO: handle exception
			throw new OutOfLimitException();
		}
		return false;
	}
	
	
	@Override
	public boolean addBookByAdmin(BookInformation book) throws RecordAlreadyExistException {
		// TODO Auto-generated method stub
		try {
			if(ld.addBookByAdmin(book)) {
				return true;
			}
		} catch (RecordAlreadyExistException e) {
			// TODO: handle exception
			throw new RecordAlreadyExistException();
		}
		return false;
	}
	
	
	
	@Override
	public boolean updateBookByAdmin(BookInformation book) throws RecordNotFoundException {
		// TODO Auto-generated method stub
		try {
			if(ld.updateBookByAdmin(book)) {
				return true;
			}
		} catch (RecordNotFoundException e) {
			// TODO: handle exception
			throw new RecordNotFoundException();
		}
		return false;
	}
	
	
	
	@Override
	public boolean deleteBookByAdmin(String bookID) throws RecordNotFoundException {
		// TODO Auto-generated method stub
		try {
			if(ld.deleteBookByAdmin(bookID)) {
				return true;
			}
		} catch (RecordNotFoundException e) {
			// TODO: handle exception
			throw new RecordNotFoundException();
		}
		return false;
	}
	
	
	
	
}
