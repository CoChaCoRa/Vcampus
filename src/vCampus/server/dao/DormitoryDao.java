package vCampus.server.dao;

import vCampus.vo.Dormitory;
import vCampus.server.exception.*;
import java.util.ArrayList;

public interface DormitoryDao {	
	/**
	 * @param String
	 * @param Dormitory
	 * @return
	 * @throws RecordNotFoundException
	 * @throws OutOfLimitException
	 */
	public ArrayList<Dormitory> queryDormitoryByUserName(String userName);
	public ArrayList<Dormitory> queryDormitoryByDormNumber(String dormNumber);
	public boolean addDormitoryInfo(Dormitory dorm)throws RecordNotFoundException,OutOfLimitException;
}

