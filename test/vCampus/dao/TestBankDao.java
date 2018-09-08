package vCampus.dao;

import java.sql.Date;

import vCampus.server.dao.BankDao;
import vCampus.server.dao.BankDaoImpl;
import vCampus.server.exception.*;
import vCampus.vo.*;

/**
 * @author YangHangyuan
 *
 */
public class TestBankDao {
	private static BankDao bankImpl=new BankDaoImpl();

	public static void main(String args[]) {
		try {
			Recharge recharge=new Recharge();
			recharge.setAmount(200.0);
			Date ts = new Date(System.currentTimeMillis()); 
			recharge.setRechargeTime(ts);
			recharge.setUserName("213161269");
			if(!bankImpl.rechargeByBankAccount(recharge))
				System.out.println("Error!");
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
