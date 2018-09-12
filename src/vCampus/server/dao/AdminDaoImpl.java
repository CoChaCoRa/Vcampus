package vCampus.server.dao;
import java.sql.ResultSet;


import java.sql.SQLException;
import vCampus.vo.*;
import java.sql.PreparedStatement;
import vCampus.server.exception.*;

/**
 * @author YangHangyuan
 *
 */
public class AdminDaoImpl implements AdminDao{
	
	private DBConnection DBC=new DBConnection();
	private PreparedStatement stmt=null;
	private ResultSet rs=null;

	@Override
	public double queryAccountByUserName(String userName) {
		StudentDao aDao=new StudentDaoImpl();
		Student std=aDao.findByName(userName);
		if(std==null) {
			TeacherDao tDao=new TeacherDaoImpl();
			Teacher tea=tDao.findByName(userName);
			if(tea!=null)tea.getAccount();
		}else return std.getAccount();
		return -1;
	}
	
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
	
	@Override
	public boolean insertAdmin(String adminID,String password)
			throws RecordAlreadyExistException{		
		try {
			Admin admin=selectAdmin(adminID);
			if(admin!=null)throw new RecordAlreadyExistException();
			//UPDATE tbl_admin
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
	
	@Override
	public boolean updatePassword(String adminID,String password)
			throws RecordNotFoundException{
		try{
			Admin admin=selectAdmin(adminID);
			if(admin==null)throw new RecordNotFoundException();
			//UPDATE tbl_admin
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
			//UPDATE tbl_admin
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
