package vCampus.biz.clent;

import java.sql.Date;

import vCampus.client.biz.LibraryService;
import vCampus.client.biz.LibraryServiceImpl;
import vCampus.server.biz.LibraryServiceDaoImpl;
import vCampus.server.dao.LibraryDao;
import vCampus.server.dao.LibraryDaoImpl;
import vCampus.vo.BookBorrow;
import vCampus.vo.BookInformation;

public class TestLibraryService {

	public static void main(String[] args) {
		LibraryService libraryService = new LibraryServiceImpl(1,"213161269");
		
		//test for library service
		
		
		
		//test library service for student
		
		//test query book info
		System.out.println("test query book info: ");
		System.out.println(libraryService.queryBookInformation("1").getBookName());
		//test query all borrowed books
		System.out.println("test query all borrowed books: ");
		System.out.println(libraryService.queryBookBorrow("213161269").size());
		//test query all books with the same name
		System.out.println("test query all books with the same name: ");
		System.out.println(libraryService.queryBook("Spring").size());
		

		//test borrow book
		System.out.println("test borrow book: ");
		BookBorrow bookborrow=new BookBorrow();
		bookborrow.setBookID("5");
		bookborrow.setBorrowNumber(2);
		Date ts = new Date(System.currentTimeMillis()); 
		bookborrow.setBorrowTime(ts);
		bookborrow.setUserName("213161269");
		if(libraryService.borrowBook(bookborrow)) {
			System.out.println("borrow success!");
		}
		
		//test return book
		System.out.println("test return book");
		
		BookBorrow returnBook = new BookBorrow();
		returnBook.setBookID("5");
		returnBook.setBorrowNumber(1);
		returnBook.setUserName("213161269");
		if(libraryService.returnBook(returnBook)) {
			System.out.println("return success~");
		}
		
		
		//test admin add book info
		BookInformation newbook = new BookInformation();
		newbook.setBookID("6");
		newbook.setBookName("Introduction to Algorithm");
		System.out.println("test admin add book info :");
		System.out.println(libraryService.addBookByAdmin(newbook));
		System.out.println(libraryService.getExceptionCode());
		
		
		//test admin update book info
		BookInformation updatedBook = new BookInformation();
		updatedBook.setBookID("6");
		updatedBook.setBookName("Introduction to Algorithm");
		updatedBook.setBookPress("MIT");
		System.out.println("test admin update book info :");
		System.out.println(libraryService.updateBookByAdmin(updatedBook));
		System.out.println(libraryService.getExceptionCode());
		
		//test admin delete book info
		System.out.println("test admin delete book info");
		System.out.println(libraryService.deleteBookByAdmin("6"));
		System.out.println(libraryService.getExceptionCode());
	}
}
