package vCampus.server.dao;

import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import vCampus.server.exception.*;
import vCampus.vo.Student;

/**
 * @author YangHangyuan, SongZixing
 *
 */
public class StudentDaoImpl implements StudentDao{
	
	private DBConnection DBC=new DBConnection();
	private PreparedStatement stmt=null;
	private ResultSet rs=null;
	
	public Student ResultSetToStudent(){
		try {
			Student std=new Student();
			std.setUserName(rs.getString("userName"));
			std.setPassword(rs.getString("password"));
			std.setSex(rs.getString("sex"));
			std.setIdCard(rs.getString("idCard"));
			std.setDeptName(rs.getString("deptName"));
			std.setEmailAddress(rs.getString("emailAddress"));
			std.setPhoneNumber(rs.getString("phoneNumber"));
			std.setBankAccount(rs.getString("bankAccount"));
			std.setAccount(rs.getDouble("account"));
			std.setStudentEcardNumber(rs.getString("studentEcardNumber"));
			std.setMoney(rs.getDouble("money"));
			std.setStudentID(rs.getString("studentID"));
			std.setMajor(rs.getString("major"));
			std.setClassNumber(rs.getString("classNumber"));
			std.setDormNumber(rs.getString("dormNumber"));
			return std;
		}
		catch (Exception e) {
			// TODO: handle exception
            System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return null;
	}
    
	@Override
	public Student findByName(String userName) {
		try {
			String sql= "select * from tbl_student where userName ="+ "'"+ userName+"'";
			stmt=DBC.con.prepareStatement(sql);
			rs = stmt.executeQuery();

			if(rs.next()) {
				return ResultSetToStudent();
			}
		}
		catch (SQLException e) {
            System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public boolean insertByUserNameAndPassword(String userName,String password)
			throws RecordAlreadyExistException{
		try {
			Student std1=findByName(userName);
			if(std1!=null)throw new RecordAlreadyExistException();
			String sql = "INSERT INTO tbl_student (userName, password) VALUES ( '"+userName+"' , '"+password+"' )";
			stmt=DBC.con.prepareStatement(sql);
			stmt.executeUpdate();
		}
		catch (SQLException e) {
            System.out.println(e.getMessage());
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@Override
	public boolean updateSelfInformation(Student std)
			throws RecordNotFoundException {
		try {
			Student std1=findByName(std.getUserName());
			if(std1==null)throw new RecordNotFoundException();
			
			String sql="UPDATE tbl_student SET sex=?,idCard=?,deptName=?,emailAddress=?,"
					+ "phoneNumber=?,bankAccount=?,account=?,money=?,studentEcardNumber=?,"
					+ "studentID=?,major=?,classNumber=?,dormNumber=? "
					+ "WHERE userName=?";
			
			stmt=DBC.con.prepareStatement(sql);
			stmt.setString(1, std.getSex());
			stmt.setString(2, std.getIdCard());
			stmt.setString(3, std.getDeptName());
			stmt.setString(4, std.getEmailAddress());
			stmt.setString(5, std.getPhoneNumber());
			stmt.setString(6, std.getBankAccount());
			stmt.setDouble(7, std.getAccount());
			stmt.setDouble(8, std.getMoney());
			stmt.setString(9, std.getStudentEcardNumber());
			stmt.setString(10, std.getStudentID());
			stmt.setString(11, std.getMajor());
			stmt.setString(12, std.getClassNumber());
			stmt.setString(13, std.getDormNumber());
			stmt.setString(14, std.getUserName());
			stmt.executeUpdate();
		}
		catch (SQLException e) {
            System.out.println(e.getMessage());
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@Override
	public boolean updatePassword(String userName,String password)
			throws RecordNotFoundException{
		try {
			Student std1=findByName(userName);
			if(std1==null)throw new RecordNotFoundException();
			String sql="UPDATE tbl_student SET password=? WHERE userName=?";
			stmt=DBC.con.prepareStatement(sql);
			stmt.setString(1, password);
			stmt.setString(2, userName);
			stmt.executeUpdate();
		}
		catch (SQLException e) {
            System.out.println(e.getMessage());
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean deleteStudent(String userName)
			throws RecordNotFoundException{
		try {
			Student std1=findByName(userName);
			if(std1==null)throw new RecordNotFoundException();
			String sql = "DELETE FROM tbl_student WHERE userName=?";
			stmt=DBC.con.prepareStatement(sql);
			stmt.setString(1,userName);
			stmt.executeUpdate();
			
			//TODO : erase any self-information in other tables
			
		}
		catch (SQLException e) {
            System.out.println(e.getMessage());
			e.printStackTrace();
			return false;
		}
		return true;
	}
}

