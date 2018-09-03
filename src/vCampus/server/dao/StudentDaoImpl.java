package vCampus.server.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import vCampus.server.exception.RecordNotFoundException;
import vCampus.server.exception.WrongPasswordException;
import vCampus.vo.Student;

/**
 * @author YangHangyuan, SongZixing
 *
 */
public class StudentDaoImpl implements StudentDao{
	
	private DBConnection DBC=new DBConnection();
	private PreparedStatement stmt=null;
	private ResultSet rs=null;
    ResultSetMetaData resultSetMetaData;
    int iNumCols;
	
	public Student ResultSetToStudent(ResultSet rs1){
		Student std=new Student();
		try {
			std.setUserName(rs1.getString("userName"));
			std.setPassword(rs1.getString("password"));
			std.setSex(rs1.getString("sex"));
			std.setIdCard(rs1.getString("idCard"));
			std.setDeptName(rs1.getString("deptName"));
			std.setEmailAddress(rs1.getString("emailAddress"));
			std.setPhoneNumber(rs1.getString("phoneNumber"));
			std.setBankAccount(rs1.getString("bankAccount"));
			std.setAccount(rs1.getDouble("account"));
			std.setStudentEcardNumber(rs1.getString("studentEcardNumber"));
			std.setMoney(rs1.getDouble("money"));
			std.setStudentID(rs1.getString("studentID"));
			std.setMajor(rs1.getString("major"));
			std.setClassNumber(rs1.getString("classNumber"));
			std.setDormNumber(rs1.getString("dormNumber"));
		}
		catch (Exception e) {
			// TODO: handle exception
            System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return std;
	}
    
	@Override
	public Student findByName(String userName) {
		// TODO Auto-generated method stub
		try {
			//create SQL string
			String sql= "select * from tbl_student where userName ="+ "'"+ userName+"'";
			stmt=DBC.con.prepareStatement(sql);
			rs = stmt.executeQuery();

			resultSetMetaData = rs.getMetaData();
			iNumCols= resultSetMetaData.getColumnCount();
			if(rs.next()) {
				Student std=ResultSetToStudent(rs);
				System.out.println("Find!");
				return std;
			}
		}
		catch (Exception e) {
			// TODO: handle exception
            System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public boolean insertByUserNameAndPassword(String userName,String password)throws SQLException{
		Student std1=findByName(userName);
		if(std1!=null)return false;
		
		try {
			//create SQL string
			String sql = "INSERT INTO tbl_student (userName, password) VALUES ( '"+userName+"' , '"+password+"' )";
			stmt=DBC.con.prepareStatement(sql);
			int rs = stmt.executeUpdate();
		}
		catch (Exception e) {
			// TODO: handle exception
            System.out.println(e.getMessage());
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@Override
	public boolean updateSelfInformation(Student std)throws SQLException {
		try {
			//create SQL string
			String sql="UPDATE tbl_student SET sex=?, SET idCard=?, SET deptName=?, SET emailAddress=?, "
					+ "SET phoneNumber=?, SET bankAccount=?, SET account=?, SET money=?, SET studentEcardNumber=?, "
					+ "SET studentID=?, SET major=?, SET classNumber=?, SET dormNumber=? "
					+ "WHERE userName=?";
			stmt=DBC.con.prepareStatement(sql);
			stmt.setString(1, std.getSex());
			stmt.setString(2, std.getIdCard());
			stmt.setString(3, std.getDeptName());
			stmt.setString(4, std.getEmailAddress());
			stmt.setString(5, std.getPhoneNumber());
			stmt.setString(6, std.getBankAccount());
			stmt.setString(7, Double.toString(std.getAccount()));
			stmt.setString(8, Double.toString(std.getMoney()));
			stmt.setString(9, std.getStudentEcardNumber());
			stmt.setString(10, std.getStudentID());
			stmt.setString(11, std.getMajor());
			stmt.setString(12, std.getClassNumber());
			stmt.setString(13, std.getDormNumber());
			stmt.setString(14, std.getUserName());
			stmt.executeUpdate();
		}
		catch (Exception e) {
			// TODO: handle exception
            System.out.println(e.getMessage());
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@Override
	public boolean updatePassword(String userName,String password)throws SQLException{
		try {
			//create SQL string
			String sql="UPDATE tbl_student SET password=? WHERE userName=?";
			stmt=DBC.con.prepareStatement(sql);
			stmt.setString(1, password);
			stmt.setString(2, userName);
			stmt.executeUpdate();
		}
		catch (Exception e) {
			// TODO: handle exception
            System.out.println(e.getMessage());
			e.printStackTrace();
			return false;
		}
		return true;
	}


}

