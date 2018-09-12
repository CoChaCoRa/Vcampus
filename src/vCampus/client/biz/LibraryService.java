package vCampus.client.biz;

import java.util.ArrayList;

import vCampus.server.exception.OutOfLimitException;
import vCampus.server.exception.RecordAlreadyExistException;
import vCampus.server.exception.RecordNotFoundException;
import vCampus.vo.BookBorrow;
import vCampus.vo.BookInformation;

/**
 * @author SongZixing
 * @version 0.0
 *
 */
public interface LibraryService {
	
	
	/**
	 * get exception codes if there exists any exception or error
	 * @return String
	 */
	public String getExceptionCode();
	

	/**
	 * 传入bookID参数,返回BookInformation对象,未查询成功将返回null
	 * @param String
	 * @return courseInformation
	 */
	public BookInformation queryBookInformation(String bookID);
	
	/**
	 * 传入bookName参数,返回ArrayList<BookInformation>对象,未查询成功将返回null
	 * @param String
	 * @return ArrayList<BookInformation>
	 */
	public ArrayList<BookInformation> queryBook(String bookName);
	
	/**
	 * 传入userName参数,返回ArrayList<BookBorrow>对象,未查询成功将返回null
	 * @param String
	 * @return ArrayList<BookBorrow>
	 */
	public ArrayList<BookBorrow> queryBookBorrow(String userName);
	
    /**
	 * 传入BookBorrow,时间设为写入数据库的时间(时间属性无需传入),
	 * 若书不存在/书的剩余数量不足则抛出异常,SQL异常返回false
	 * @param String
	 * @return boolean
	 * @throws RecordNotFoundException
	 * @throws OutOfLimitException
	 */
	public boolean borrowBook(BookBorrow borrow);
	
	/**
	 * 传入BookBorrow,时间设为写入数据库的时间(时间属性无需传入),若之前有借相同ID的书则刷新借阅时间和数量
	 * 若书目不存在或者该学生并未借书/已经借出的数量比还书的数量少则抛出异常,SQL异常返回false
	 * @param String
	 * @return boolean
	 * @throws RecordNotFoundException
	 * @throws OutOfLimitException
	 */
	public boolean returnBook(BookBorrow borrow);
	
	
	/**
	 * 获取所有书目,返回ArrayList<BookInformation>对象,未查询成功将返回null
	 * @param String
	 * @return ArrayList<BookInformation>
	 */
	public ArrayList<BookInformation> queryAllBook();
	
	/**
	 * 传入BookInformation,若bookID已经存在则抛出异常,SQL异常返回false
	 * @param String
	 * @return boolean
	 * @throws RecordAlreadyExistException
	 */
	public boolean addBookByAdmin(BookInformation book);
	/**
	 * 传入BookInformation,若bookID不存在则抛出异常,SQL异常返回false
	 * @param String
	 * @return boolean
	 * @throws RecordAlreadyExistException
	 */
	public boolean updateBookByAdmin(BookInformation book);
	/**
	 * 传入bookID,若bookID不存在则抛出异常,SQL异常返回false
	 * @param String
	 * @return boolean
	 * @throws RecordAlreadyExistException
	 */
	public boolean deleteBookByAdmin(String bookID);
	
}
