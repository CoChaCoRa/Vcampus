package vCampus.server.dao;
import java.sql.ResultSet;

import java.sql.SQLException;
import vCampus.vo.Admin;
import vCampus.vo.Student;

import java.sql.PreparedStatement;
import vCampus.server.exception.RecordNotFoundException;

public class AdminDaoImpl implements AdminDao{
	
	private DBConnection DBC=new DBConnection();
	private PreparedStatement stmt=null;
	private ResultSet rs=null;
	
	/**
	 * @param adminID
	 * 
	 * @return admin
	 */
	@Override
	public Admin selectAdmin(String adminID)throws SQLException{
		String sql="SELECT * FROM tbl_admin WHERE adminID=?";
		try {
			stmt=DBC.con.prepareStatement(sql);
			stmt.setString(1,adminID);
			rs = stmt.executeQuery();
			if(rs.next()){
				Admin admin=new Admin();
				admin.setAdminID(rs.getString("adminID"));
				admin.setPassword(rs.getString("password"));
				return admin;
			}
		} 
		catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return null;
	} 	
	
	/**
	 * @param adminID
	 * @param password
	 * @return NONE
	 */
	@Override
	public boolean insertAdmin(String adminID,String password)throws SQLException{		
		try {
			Admin admin=selectAdmin(adminID);
			if(admin!=null)return false;
			String sql="INSERT INTO tbl_admin (adminID,password) VALUES (?,?)";
			stmt=DBC.con.prepareStatement(sql);
			stmt.setString(1,adminID);
			stmt.setString(2,password);
			stmt.executeUpdate();
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return false;
		}
		return true;
	}	 	
	
	/**
	 * @param adminID
	 * @param password
	 * 
	 * @return NONE
	 */
	@Override
	public boolean updatePassword(String adminID,String password)throws RecordNotFoundException,SQLException{
		try{
			Admin admin=selectAdmin(adminID);
			if(admin==null)throw new RecordNotFoundException();
			String sql="UPDATE tbl_admin SET password=? WHERE adminID=?";
			stmt=DBC.con.prepareStatement(sql);
			stmt.setString(1, password);
			stmt.setString(2, adminID);
			stmt.executeUpdate();
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
