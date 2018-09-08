package vCampus.server.dao;

import vCampus.server.exception.*;
import vCampus.vo.Recharge;

import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BankDaoImpl implements BankDao{

	private DBConnection DBC=new DBConnection();
	private PreparedStatement stmt=null;
	private ResultSet rs=null;
	
	@Override
	public boolean rechargeByBankAccount(Recharge recharge)
			throws OutOfLimitException, RecordNotFoundException {
		try {
			String sql1="SELECT * FROM tbl_student WHERE userName='"+recharge.getUserName()+"'";
			stmt=DBC.con.prepareStatement(sql1);
			rs=stmt.executeQuery();
			if(!rs.next())throw new RecordNotFoundException();
			
			double account=rs.getDouble("account");
			double money=rs.getDouble("money");
			if(account<recharge.getAmount())throw new OutOfLimitException();
			account-=recharge.getAmount();
			money+=recharge.getAmount();
			
			//UPDATE tbl_student
			String sql="UPDATE tbl_student SET account=?,money=? WHERE userName=?";
			stmt=DBC.con.prepareStatement(sql);
			stmt.setDouble(1,account);
			stmt.setDouble(2,money);
			stmt.setString(3,recharge.getUserName());
			stmt.executeUpdate();
			
			//UPDATE tbl_recharge
			String sqll="INSERT INTO tbl_recharge (userName,rechargeTime,amount) "
					+ " VALUES (?,?,?)";
			stmt=DBC.con.prepareStatement(sqll);
			stmt.setString(1,recharge.getUserName());
			stmt.setDate(2, recharge.getRechargeTime());
			stmt.setDouble(3, recharge.getAmount());
			stmt.executeUpdate();
			
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
