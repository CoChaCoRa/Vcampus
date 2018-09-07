package vCampus.server.dao;

import vCampus.vo.BookBorrow;
import vCampus.vo.BookInformation;
import vCampus.server.exception.*;
import java.util.ArrayList;

public interface LibraryDao {	
	/**
	 * @param String
	 * @param BookInformation
	 * @param BookBorrow
	 * @return
	 * @throws RecordNotFoundException
	 * @throws RecordAlreadyExistException
	 * @throws WrongPasswordException
	 */
	public BookInformation queryBookInformation(String bookID);
	public ArrayList<BookInformation> queryBook(String bookName);
	public ArrayList<BookBorrow> queryBookBorrow(String userName);
	public boolean borrowBook(BookBorrow borrow)throws RecordNotFoundException,OutOfLimitException;
	public boolean returnBook(BookBorrow borrow)throws RecordNotFoundException,OutOfLimitException;
	public boolean addBookByAdmin(BookInformation book)throws RecordAlreadyExistException;
	public boolean updateBookByAdmin(BookInformation book)throws RecordNotFoundException;
	public boolean deleteBookByAdmin(String bookID)throws RecordNotFoundException;
}

