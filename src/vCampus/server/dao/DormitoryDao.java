package vCampus.server.dao;

import vCampus.vo.Dormitory;
import vCampus.server.exception.*;
import java.util.ArrayList;

public interface DormitoryDao {	

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

