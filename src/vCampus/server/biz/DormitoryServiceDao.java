package vCampus.server.biz;

import java.util.ArrayList;

import vCampus.server.exception.OutOfLimitException;
import vCampus.server.exception.RecordNotFoundException;
import vCampus.vo.Dormitory;

public interface DormitoryServiceDao {

	/**
	 * 传入userName参数,返回ArrayList<Dormitory>,未查询成功将返回null
	 * @param String
	 * @return ArrayList<Dormitory>
	 */
	public ArrayList<Dormitory> queryDormitoryByUserName(String userName);
	
	/**
	 * 传入dormNumber参数,返回ArrayList<Dormitory>,未查询成功将返回null
	 * @param String
	 * @return ArrayList<Dormitory>
	 */
	public ArrayList<Dormitory> queryDormitoryByDormNumber(String dormNumber);
	
    /**
	 * 传入Dormitory,若学生-宿舍信息不合法或者不存在/一卡通余额不足则抛出异常,SQL异常返回false
	 * @param String
	 * @return boolean
	 * @throws RecordNotFoundException
	 * @throws OutOfLimitException
	 */
	public boolean addDormitoryInfo(Dormitory dorm)throws RecordNotFoundException,OutOfLimitException;
}
