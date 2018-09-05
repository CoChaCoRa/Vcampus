package vCampus.server.dao;

import java.sql.SQLException;
import vCampus.vo.BookBorrow;
import vCampus.vo.BookInformation;
import vCampus.server.exception.*;

public interface LibraryDao {	
	/**
	 * @param 
	 * @param 
	 * @return
	 * @throws RecordNotFoundException
	 * @throws RecordAlreadyExistException
	 * @throws WrongPasswordException
	 */
	public boolean borrowBookByTeacher(BookBorrow borrow)throw RecordNotFoundException,OutOfLimitException;
	
}

