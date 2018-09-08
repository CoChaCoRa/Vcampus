package vCampus.server.dao;

import java.sql.SQLException;
import java.sql.Date;
import vCampus.vo.BookBorrow;
import vCampus.vo.BookInformation;
import vCampus.server.exception.*;
import vCampus.server.dao.DBConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * @author YangHangyuan
 *
 */
public class LibraryDaoImpl implements LibraryDao{

	private DBConnection DBC=new DBConnection();
	private PreparedStatement stmt=null;
	private ResultSet rs=null;
	
	private BookInformation ResultSetToBookInformation() {
		try {
			BookInformation book=new BookInformation();
			book.setBookAddress(rs.getString("bookAddress"));
			book.setBookID(rs.getString("bookID"));
			book.setBookName(rs.getString("bookName"));
			book.setBookPress(rs.getString("bookPress"));
			book.setBookWriter(rs.getString("bookWriter"));
			book.setBorrowedAmount(rs.getInt("borrowedAmount"));
			book.setTotalAmount(rs.getInt("totalAmount"));
    		return book;
    	}catch(Exception e) {
			// TODO: handle exception
            System.out.println(e.getMessage());
			e.printStackTrace();
    	}
		return null;
	}
	
	private ArrayList<BookBorrow> ResultSetToBookBorrowArrayList(){
		try {
			ArrayList<BookBorrow> list=new ArrayList<BookBorrow>();
			do {
				BookBorrow bookborrow;
				bookborrow=new BookBorrow();
				bookborrow.setBookID(rs.getString("bookID"));
				bookborrow.setBorrowNumber(rs.getInt("borrowNumber"));
				bookborrow.setBorrowTime(rs.getDate("borrowTime"));
				bookborrow.setUserName(rs.getString("userName"));
				list.add(bookborrow);
			}while(rs.next());
			return list;
		}catch(Exception e) {
			// TODO: handle exception
            System.out.println(e.getMessage());
			e.printStackTrace();
    	}
		return null;
	}
	
	private ArrayList<BookInformation> ResultSetToBookInformationArrayList(){
		try {
			ArrayList<BookInformation> list=new ArrayList<BookInformation>();
			do {
				BookInformation book;
				book=new BookInformation();
				book.setBookID(rs.getString("bookID"));
				book.setBookAddress(rs.getString("bookAddress"));
				book.setBookName(rs.getString("bookName"));
				book.setBookPress(rs.getString("bookPress"));
				book.setBookWriter(rs.getString("bookWriter"));
				book.setBorrowedAmount(rs.getInt("borrowedAmount"));
				book.setTotalAmount(rs.getInt("totalAmount"));
				
				list.add(book);
			}while(rs.next());
			return list;
		}catch(Exception e) {
			// TODO: handle exception
            System.out.println(e.getMessage());
			e.printStackTrace();
    	}
		return null;
	}
	
	
	
	@Override
	public BookInformation queryBookInformation(String bookID) {
		try {
			String sql="SELECT * FROM tbl_bookinformation WHERE bookID='"+bookID+"'";
			stmt=DBC.con.prepareStatement(sql);
			rs = stmt.executeQuery();

			if(rs.next()) {
				return ResultSetToBookInformation();
			}
		}catch(SQLException e) {
    		System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<BookBorrow> queryBookBorrow(String userName) {
		try {
			String sql="SELECT * FROM tbl_bookborrow WHERE userName='"+userName+"'";
			stmt=DBC.con.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				return ResultSetToBookBorrowArrayList();
			}
		}catch(SQLException e) {
    		System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public ArrayList<BookInformation> queryBook(String bookName) {
		try {
			String sql="SELECT * FROM tbl_bookinformation WHERE bookName='"+bookName+"'";
			stmt=DBC.con.prepareStatement(sql);
			rs = stmt.executeQuery();

			if(rs.next()) {
				return ResultSetToBookInformationArrayList();
			}
		}catch(SQLException e) {
    		System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public boolean borrowBook(BookBorrow borrow) 
			throws RecordNotFoundException,OutOfLimitException {
		try {
			String sql1="SELECT * FROM tbl_bookinformation WHERE bookID='"+borrow.getBookID()+"'";
			stmt=DBC.con.prepareStatement(sql1);
			rs = stmt.executeQuery();
			if(rs.next()) {
			    int currentNumber=rs.getInt("borrowedAmount");
			    int maxNumber=rs.getInt("totalAmount");
				if(currentNumber+borrow.getBorrowNumber()>maxNumber)throw new OutOfLimitException();
			    currentNumber+=borrow.getBorrowNumber();
				
				String sql2="SELECT * FROM tbl_bookborrow WHERE bookID='"+borrow.getBookID()
						+"' AND userName='"+borrow.getUserName()+"'";
				stmt=DBC.con.prepareStatement(sql2);
				rs = stmt.executeQuery();
				int borrowNumber=borrow.getBorrowNumber();
				//UPDATE borrow time
			    Date ts = new Date(System.currentTimeMillis());
				if(rs.next()) {
					borrowNumber+=rs.getInt("borrowNumber");
				    
				    //UPDATE tbl_bookborrow  //not to update the borrowTime
				    String sql="UPDATE tbl_bookborrow SET borrowNumber=? WHERE bookID='"
				    		+borrow.getBookID()+"' AND userName='"+borrow.getUserName()+"'";
				    stmt=DBC.con.prepareStatement(sql);
				    stmt.setInt(1,borrowNumber);
				    
					stmt.executeUpdate();
				}else {
					//INSERT NEW borrow record
					String sql="INSERT INTO tbl_bookborrow (userName,bookID,borrowTime,borrowNumber)"
							+" VALUES (?,?,?,?)";
				    stmt=DBC.con.prepareStatement(sql);
					stmt.setString(1,borrow.getUserName());
					stmt.setString(2,borrow.getBookID());
					stmt.setDate(3,ts);//record the time of modification
					stmt.setInt(4,borrow.getBorrowNumber());
					stmt.executeUpdate();
				}
				//UPDATE tbl_bookinformation
			    String sqll="UPDATE tbl_bookinformation SET borrowedAmount=? WHERE bookID='"
			    		+borrow.getBookID()+"'";
			    stmt=DBC.con.prepareStatement(sqll);
			    stmt.setInt(1,currentNumber);
			    
				stmt.executeUpdate();
					
			}else throw new RecordNotFoundException();
		}catch(SQLException e) {
    		System.out.println(e.getMessage());
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@Override
	public boolean returnBook(BookBorrow borrow) throws RecordNotFoundException, OutOfLimitException {
		try {
			String sql1="SELECT * FROM tbl_bookinformation WHERE bookID='"+borrow.getBookID()+"'";
			stmt=DBC.con.prepareStatement(sql1);
			rs = stmt.executeQuery();
			if(rs.next()) {
				int borrowedAmount=rs.getInt("borrowedAmount");
				if(borrowedAmount<borrow.getBorrowNumber())throw new OutOfLimitException();
				borrowedAmount-=borrow.getBorrowNumber();
				
				String sql2="SELECT * FROM tbl_bookborrow WHERE bookID='"+borrow.getBookID()
						+"' AND userName='"+borrow.getUserName()+"'";
				stmt=DBC.con.prepareStatement(sql2);
				rs = stmt.executeQuery();
				if(rs.next()) {
					int borrowNumber=rs.getInt("borrowNumber");
					if(borrowNumber<borrow.getBorrowNumber())throw new OutOfLimitException();
					borrowNumber-=borrow.getBorrowNumber();
					
					if(borrowNumber==0) {
						String sql="DELETE FROM tbl_bookborrow WHERE bookID='"
							+borrow.getBookID()+"' AND userName='"+borrow.getUserName()+"'";
						stmt=DBC.con.prepareStatement(sql);
					
						stmt.executeUpdate();
					}else {
						String sql="UPDATE tbl_bookborrow SET borrowNumber=? WHERE bookID='"
							+borrow.getBookID()+"' AND userName='"+borrow.getUserName()+"'";
						stmt=DBC.con.prepareStatement(sql);
						stmt.setInt(1, borrowNumber);
						
						stmt.executeUpdate();
					}
					
					String sqll="UPDATE tbl_bookinformation SET borrowedAmount=? "
							+"WHERE bookID='"+borrow.getBookID()+"'";
					stmt=DBC.con.prepareStatement(sqll);
					stmt.setInt(1,borrowedAmount);
					
					stmt.executeUpdate();
				}else throw new RecordNotFoundException();
			}else throw new RecordNotFoundException();
		}catch(SQLException e) {
    		System.out.println(e.getMessage());
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@Override
	public boolean addBookByAdmin(BookInformation book) 
			throws RecordAlreadyExistException {
		try {
			String sql1="SELECT * FROM tbl_bookinformation WHERE bookID='"+book.getBookID()+"'";
			stmt=DBC.con.prepareStatement(sql1);
			rs = stmt.executeQuery();
			if(rs.next()) throw new RecordAlreadyExistException();
				
			String sql2="INSERT INTO tbl_bookinformation (bookID,bookName,bookPress,"
					+"bookAddress,bookWriter,totalAmount,borrowedAmount) "
					+"VALUES (?,?,?,?,?,?,?)";
			stmt=DBC.con.prepareStatement(sql2);
			stmt.setString(1,book.getBookID());
			stmt.setString(2,book.getBookName());
			stmt.setString(3,book.getBookPress());
			stmt.setString(4,book.getBookAddress());
			stmt.setString(5,book.getBookWriter());
			stmt.setInt(6,book.getTotalAmount());
			stmt.setInt(7, book.getBorrowedAmount());
			
			stmt.executeUpdate();
		}catch(SQLException e) {
    		System.out.println(e.getMessage());
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean updateBookByAdmin(BookInformation book) 
			throws RecordNotFoundException {
		try {
			String sql1="SELECT * FROM tbl_bookinformation WHERE bookID='"+book.getBookID()+"'";
			stmt=DBC.con.prepareStatement(sql1);
			rs = stmt.executeQuery();
			if(rs.next()) {
				String sql="UPDATE tbl_bookinformation SET bookName=?,bookPress=?,bookAddress=?,bookWriter=?,"
						+"totalAmount=?,borrowedAmount=? WHERE bookID='"+book.getBookID()+"'";
				stmt=DBC.con.prepareStatement(sql);
				stmt.setString(1,book.getBookName());
				stmt.setString(2,book.getBookPress());
				stmt.setString(3,book.getBookAddress());
				stmt.setString(4,book.getBookWriter());
				stmt.setInt(5,book.getTotalAmount());
				stmt.setInt(6, book.getBorrowedAmount());
				
				stmt.executeUpdate();
			}else throw new RecordNotFoundException();
		}catch(SQLException e) {
    		System.out.println(e.getMessage());
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean deleteBookByAdmin(String bookID) 
			throws RecordNotFoundException {
		try {
			String sql1="SELECT * FROM tbl_bookinformation WHERE bookID='"+bookID+"'";
			stmt=DBC.con.prepareStatement(sql1);
			rs = stmt.executeQuery();
			if(rs.next()) {
				String sql="DELETE FROM tbl_bookinformation WHERE bookID='"+bookID+"'";
				stmt=DBC.con.prepareStatement(sql);
				stmt.executeUpdate();
			}else throw new RecordNotFoundException();
		}catch(SQLException e) {
    		System.out.println(e.getMessage());
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
