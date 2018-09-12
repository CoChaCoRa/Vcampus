package vCampus.server.biz;

import vCampus.server.dao.BankDao;
import vCampus.server.dao.BankDaoImpl;
import vCampus.server.exception.OutOfLimitException;
import vCampus.server.exception.RecordNotFoundException;
import vCampus.vo.Recharge;

public class BankServiceDaoImpl implements BankServiceDao{

	private BankDao bd = new BankDaoImpl();
	@Override
	public boolean rechargeByBankAccount(Recharge recharge) throws OutOfLimitException, RecordNotFoundException {
		// TODO Auto-generated method stub
		try {
			if(bd.rechargeByBankAccount(recharge)) {
				return true;
			}
			
		} catch (OutOfLimitException e) {
			// TODO: handle exception
			throw new OutOfLimitException();
		}
		catch (RecordNotFoundException e) {
			// TODO: handle exception
			throw new RecordNotFoundException();
		}
		return false;
	}
}
