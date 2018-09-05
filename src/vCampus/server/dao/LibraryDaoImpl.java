package vCampus.server.dao;

import java.sql.SQLException;
import java.sql.Timestamp;

import vCampus.vo.BookBorrow;
import vCampus.vo.BookInformation;
import vCampus.server.exception.*;
import vCampus.server.dao.DBConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


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
				bookborrow.setBorrowTime(rs.getTimestamp("borrowTime"));
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
			String sql="SELECT * FROM tbl_bookborrow WHERE bookID='"+userName+"'";
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
			    Timestamp ts = new Timestamp(System.currentTimeMillis());
				if(rs.next()) {
					borrowNumber+=rs.getInt("borrowNumber");
				    
				    //UPDATE tbl_bookborrow
				    String sql="UPDATE tbl_bookborrow SET borrowTime=?,borrowNumber=? WHERE bookID='"
				    		+borrow.getBookID()+"' AND userName='"+borrow.getUserName()+"'";
				    stmt=DBC.con.prepareStatement(sql);
					stmt.executeUpdate();
				}else {
					//INSERT NEW borrow record
					String sql="INSERT INTO tbl_bookborrow (userName,bookID,borrowTime,borrowNumber)"
							+" VALUES (?,?,?,?)";
				    stmt=DBC.con.prepareStatement(sql);
					stmt.executeUpdate();
				}
				//UPDATE tbl_bookinformation
			    String sqll="UPDATE tbl_bookinformation SET borrowedAmount=? WHERE bookID='"
			    		+borrow.getBookID()+"'";
			    stmt=DBC.con.prepareStatement(sqll);
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
		// TODO Auto-generated method stub
		try {
			String sql1="SELECT * FROM tbl_bookinformation WHERE bookID='"+borrow.getBookID()+"'";
			stmt=DBC.con.prepareStatement(sql1);
			rs = stmt.executeQuery();
			if(rs.next()) {
				String sql2="SELECT * FROM tbl_bookborrow WHERE bookID='"+borrow.getBookID()
						+"' AND userName='"+borrow.getUserName()+"'";
				stmt=DBC.con.prepareStatement(sql2);
				
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
		// TODO Auto-generated method stu
		try {
			String sql1="SELECT * FROM tbl_bookinformation WHERE bookID='"+borrow.getBookID()+"'";
			stmt=DBC.con.prepareStatement(sql1);
			rs = stmt.executeQuery();
			if(rs.next()) {
				String sql2="SELECT * FROM tbl_bookborrow WHERE bookID='"+borrow.getBookID()
						+"' AND userName='"+borrow.getUserName()+"'";
				stmt=DBC.con.prepareStatement(sql2);
				
			}else throw new RecordNotFoundException();
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
		// TODO Auto-generated method stub
		try {
			String sql1="SELECT * FROM tbl_bookinformation WHERE bookID='"+borrow.getBookID()+"'";
			stmt=DBC.con.prepareStatement(sql1);
			rs = stmt.executeQuery();
			if(rs.next()) {
				String sql2="SELECT * FROM tbl_bookborrow WHERE bookID='"+borrow.getBookID()
						+"' AND userName='"+borrow.getUserName()+"'";
				stmt=DBC.con.prepareStatement(sql2);
				
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
		// TODO Auto-generated method stub
		try {
			String sql1="SELECT * FROM tbl_bookinformation WHERE bookID='"+borrow.getBookID()+"'";
			stmt=DBC.con.prepareStatement(sql1);
			rs = stmt.executeQuery();
			if(rs.next()) {
				String sql2="SELECT * FROM tbl_bookborrow WHERE bookID='"+borrow.getBookID()
						+"' AND userName='"+borrow.getUserName()+"'";
				stmt=DBC.con.prepareStatement(sql2);
				
			}else throw new RecordNotFoundException();
		}catch(SQLException e) {
    		System.out.println(e.getMessage());
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
