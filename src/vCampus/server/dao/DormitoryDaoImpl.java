package vCampus.server.dao;

import java.sql.SQLException;
import java.sql.Date;
import vCampus.server.exception.*;
import vCampus.server.dao.DBConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import vCampus.vo.Dormitory;

public class DormitoryDaoImpl implements DormitoryDao{
	
	private DBConnection DBC=new DBConnection();
	private PreparedStatement stmt=null;
	private ResultSet rs=null;
	
	private ArrayList<Dormitory> ResultSetToArrayList(){
		try {
			ArrayList<Dormitory> list=new ArrayList<Dormitory>();
			do {
				Dormitory dorm;
				dorm=new Dormitory();
				dorm.setChargeTime(rs.getDate("chargeTime"));
				dorm.setDormBill(rs.getDouble("dormBill"));
				dorm.setDormNumber(rs.getString("dormNumber"));
				dorm.setScore(rs.getDouble("score"));
				dorm.setUserName(rs.getString("userName"));
				list.add(dorm);
			}while(rs.next());
			
			return list;
		}catch(Exception e) {
			//TODO: handle exception
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public ArrayList<Dormitory> queryDormitoryByUserName(String userName) {
		try {
			String sql="SELECT * FROM tbl_dormitory WHERE userName='"+userName+"'";
			stmt=DBC.con.prepareStatement(sql);
			rs=stmt.executeQuery();
			if(rs.next()) {
				return ResultSetToArrayList();
			}
		}catch(SQLException e){
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<Dormitory> queryDormitoryByDormNumber(String dormNumber) {
		try {
			String sql="SELECT * FROM tbl_dormitory WHERE dormNumber='"+dormNumber+"'";
			stmt=DBC.con.prepareStatement(sql);
			rs=stmt.executeQuery();
			if(rs.next()) {
				return ResultSetToArrayList();
			}
		}catch(SQLException e){
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean addDormitoryInfo(Dormitory dorm)throws RecordNotFoundException,OutOfLimitException{
		try {
			String sql1="SELECT * FROM tbl_student WHERE userName='"+dorm.getUserName()
				+"' AND dormNumber='"+dorm.getDormNumber()+"'";
			stmt=DBC.con.prepareStatement(sql1);
			rs=stmt.executeQuery();
			if(!rs.next())throw new RecordNotFoundException();
			double money=rs.getDouble("money");
			if(money<dorm.getDormBill())throw new OutOfLimitException();
			money-=dorm.getDormBill();
			
			//UPDATE tbl_dormitory
			String sql="INSERT INTO tbl_dormitory (userName,chargeTime,dormNumber,dormBill,score) "
					+"VALUES (?,?,?,?,?)";
			stmt=DBC.con.prepareStatement(sql);
			stmt.setString(1, dorm.getUserName());
			stmt.setDate(2, dorm.getChargeTime());
			stmt.setString(3, dorm.getDormNumber());
			stmt.setDouble(4,dorm.getDormBill());
			stmt.setDouble(5,dorm.getScore());
			stmt.executeUpdate();
			

			//UPDATE tbl_student
			String sqll="UPDATE tbl_student	SET money=? WHERE userName=? AND dormNumber=?";
			stmt=DBC.con.prepareStatement(sqll);
			stmt.setDouble(1, money);
			stmt.setString(2, dorm.getUserName());
			stmt.setString(3, dorm.getDormNumber());
			stmt.executeUpdate();
		}catch(SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
