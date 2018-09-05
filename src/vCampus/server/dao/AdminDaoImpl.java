package vCampus.server.dao;
import java.sql.ResultSet;

import java.sql.SQLException;
import vCampus.vo.Admin;
import java.sql.PreparedStatement;
import vCampus.server.exception.*;

public class AdminDaoImpl implements AdminDao{
	
	private DBConnection DBC=new DBConnection();
	private PreparedStatement stmt=null;
	private ResultSet rs=null;
	
	/**
	 * @param adminID
	 * 
	 * @return object
	 */
	@Override
	public Admin selectAdmin(String adminID){
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
	 * @return boolean
	 */
	@Override
	public boolean insertAdmin(String adminID,String password)
			throws RecordAlreadyExistException{		
		try {
			Admin admin=selectAdmin(adminID);
			if(admin!=null)throw new RecordAlreadyExistException();
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
	 * @return boolean
	 */
	@Override
	public boolean updatePassword(String adminID,String password)
			throws RecordNotFoundException{
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

	@Override
	public boolean deleteAdmin(String adminID)
			throws RecordNotFoundException {
		try{
			Admin admin=selectAdmin(adminID);
			if(admin==null)throw new RecordNotFoundException();
			String sql="DELETE FROM tbl_admin WHERE adminID=?";
			stmt=DBC.con.prepareStatement(sql);
			stmt.setString(1, adminID);
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
