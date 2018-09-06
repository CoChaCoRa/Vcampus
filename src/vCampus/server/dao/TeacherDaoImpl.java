package vCampus.server.dao;

import java.sql.Connection;



import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import vCampus.server.exception.*;
import vCampus.vo.Student;
import vCampus.vo.Teacher;

/**
 * @author YangHangyuan
 *
 */
public class TeacherDaoImpl implements TeacherDao{
	
	private DBConnection DBC=new DBConnection();
	private PreparedStatement stmt=null;
	private ResultSet rs=null;
	
	public Teacher ResultSetToTeacher(){
		Teacher std=new Teacher();
		try {
			std.setUserName(rs.getString("userName"));
			std.setPassword(rs.getString("password"));
			std.setSex(rs.getString("sex"));
			std.setIdCard(rs.getString("idCard"));
			std.setDeptName(rs.getString("deptName"));
			std.setEmailAddress(rs.getString("emailAddress"));
			std.setPhoneNumber(rs.getString("phoneNumber"));
			std.setBankAccount(rs.getString("bankAccount"));
			std.setAccount(rs.getDouble("account"));
			std.setProfessionalTitle(rs.getString("professionalTitle"));
			std.setMoney(rs.getDouble("money"));
			std.setTeacherEcardNumber(rs.getString("teacherEcardNumber"));
		}
		catch (Exception e) {
			// TODO: handle exception
            System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return std;
	}
	
	@Override
	public Teacher findByName(String userName){
		// TODO Auto-generated method stub
		try {
			//create SQL string
			String sql= "SELECT * FROM tbl_teacher WHERE userName ="+ "'"+ userName+"'";
			stmt=DBC.con.prepareStatement(sql);
			rs = stmt.executeQuery();

			if(rs.next()) {
				return ResultSetToTeacher();
			}
		}
		catch (SQLException e) {
			// TODO: handle exception
            System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public boolean insertByUserNameAndPassword(String userName,String password)
			throws RecordAlreadyExistException{
		
		try {
			Teacher std1=findByName(userName);
			if(std1!=null)throw new RecordAlreadyExistException();
			String sql = "INSERT INTO tbl_teacher (userName, password) VALUES ( '"+userName+"' , '"+password+"' )";
			stmt=DBC.con.prepareStatement(sql);
			stmt.executeUpdate();
		}
		catch (SQLException e) {
			// TODO: handle exception
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
			Teacher std1=findByName(userName);
			if(std1==null)throw new RecordNotFoundException();
			//create SQL string
			String sql="UPDATE tbl_teacher SET password=? WHERE userName=?";
			stmt=DBC.con.prepareStatement(sql);
			stmt.setString(1, password);
			stmt.setString(2, userName);
			stmt.executeUpdate();
		}
		catch (SQLException e) {
			// TODO: handle exception
            System.out.println(e.getMessage());
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean updateSelfInformation(Teacher std)
			throws RecordNotFoundException {
		try {
			Teacher std1=findByName(std.getUserName());
			if(std1==null)throw new RecordNotFoundException();
			
			String sql="UPDATE tbl_teacher SET sex=?,idCard=?,deptName=?,emailAddress=?,"
					+ "phoneNumber=?,bankAccount=?,account=?,money=?,teacherEcardNumber=?,"
					+"professionalTitle=? "
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
			stmt.setString(9, std.getTeacherEcardNumber());
			stmt.setString(10, std.getProfessionalTitle());
			stmt.setString(11, std.getUserName());
			stmt.executeUpdate();
		}
		catch (SQLException e) {
			// TODO: handle exception
            System.out.println(e.getMessage());
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean deleteTeacher(String userName)
			throws RecordNotFoundException {
		try {
			Teacher std1=findByName(userName);
			if(std1==null)throw new RecordNotFoundException();
			String sql = "DELETE FROM tbl_teacher WHERE userName=?";
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

