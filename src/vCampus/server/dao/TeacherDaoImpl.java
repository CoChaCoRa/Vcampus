package vCampus.server.dao;

import java.sql.Connection;


import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import vCampus.server.exception.*;
import vCampus.vo.Teacher;

/**
 * @author YangHangyuan
 *
 */
public class TeacherDaoImpl implements TeacherDao{
	
	private DBConnection DBC=new DBConnection();
	private PreparedStatement stmt=null;
	private ResultSet rs=null;
	
	public Teacher ResultSetToTeacher(ResultSet rs1){
		Teacher std=new Teacher();
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
			std.setProfessionalTitle(rs1.getString("professionalTitle"));
			std.setMoney(rs1.getDouble("money"));
			std.setTeacherEcardNumber(rs1.getString("teacherEcardNumber"));
		}
		catch (Exception e) {
			// TODO: handle exception
            System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return std;
	}
	
	@Override
	public Teacher findByName(String userName) throws SQLException{
		// TODO Auto-generated method stub
		try {
			//create SQL string
			String sql= "select * from tbl_teacher where userName ="+ "'"+ userName+"'";
			stmt=DBC.con.prepareStatement(sql);
			rs = stmt.executeQuery();

			if(rs.next()) {
				return ResultSetToTeacher(rs);
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
	public boolean insertByUserNameAndPassword(String userName,String password)throws RecordAlreadyExistException,SQLException{
		
		try {
			Teacher std1=findByName(userName);
			if(std1!=null)throw new RecordAlreadyExistException();
			String sql = "INSERT INTO tbl_teacher (userName, password) VALUES ( '"+userName+"' , '"+password+"' )";
			stmt=DBC.con.prepareStatement(sql);
			int rs = stmt.executeUpdate();
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
	public boolean updateSelfInformation(Teacher std)throws RecordNotFoundException,SQLException {
		try {
			Teacher std1=findByName(std.getUserName());
			if(std1==null)throw new RecordNotFoundException();
			//create SQL string
			String sql="UPDATE tbl_teacher SET sex=?, SET idCard=?, SET deptName=?, SET emailAddress=?, "
					+ "SET phoneNumber=?, SET bankAccount=?, SET account=?, SET money=?, SET teacherEcardNumber=?, "
					+ "SET professionalTitle=?, WHERE userName=?";
			stmt=DBC.con.prepareStatement(sql);
			stmt.setString(1, std.getSex());
			stmt.setString(2, std.getIdCard());
			stmt.setString(3, std.getDeptName());
			stmt.setString(4, std.getEmailAddress());
			stmt.setString(5, std.getPhoneNumber());
			stmt.setString(6, std.getBankAccount());
			stmt.setString(7, Double.toString(std.getAccount()));
			stmt.setString(8, Double.toString(std.getMoney()));
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
	public boolean updatePassword(String userName,String password)throws RecordNotFoundException,SQLException{
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
}

