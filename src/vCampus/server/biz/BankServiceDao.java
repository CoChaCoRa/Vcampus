package vCampus.server.biz;

import vCampus.server.exception.OutOfLimitException;
import vCampus.server.exception.RecordNotFoundException;
import vCampus.vo.Recharge;

public interface BankServiceDao {

	/**
	 * 传入Recharge, 其中rechargeTime在写入数据库时计算(无需传入)
	 * 在未找到当前学生和银行账号余额不足时分别抛出异常,SQL异常返回false
	 * @param recharge
	 * @return boolean
	 * @throws RecordNotFoundException
	 * @throws OutOfLimitException
	 */
	public boolean rechargeByBankAccount(Recharge recharge)throws OutOfLimitException,RecordNotFoundException;
	
}
