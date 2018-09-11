package vCampus.server.biz;

import java.util.ArrayList;

import vCampus.server.dao.DormitoryDao;
import vCampus.server.dao.DormitoryDaoImpl;
import vCampus.server.exception.OutOfLimitException;
import vCampus.server.exception.RecordNotFoundException;
import vCampus.vo.Dormitory;

public class DormitoryServiceDaoImpl implements DormitoryServiceDao{
	
	private DormitoryDao dd = new DormitoryDaoImpl();
	
	@Override
	public ArrayList<Dormitory> queryDormitoryByDormNumber(String dormNumber) {
		// TODO Auto-generated method stub
		ArrayList<Dormitory> dormitories = dd.queryDormitoryByDormNumber(dormNumber);
		if(dormitories != null) {
			return dormitories;
		}
		return null;
	}
	
	@Override
	public ArrayList<Dormitory> queryDormitoryByUserName(String userName) {
		// TODO Auto-generated method stub
		ArrayList<Dormitory> dormitories = dd.queryDormitoryByUserName(userName);
		if(dormitories != null) {
			return dormitories;
		}
		return null;
	}
	
	
	@Override
	public boolean addDormitoryInfo(Dormitory dorm) throws RecordNotFoundException, OutOfLimitException {
		// TODO Auto-generated method stub
		try {
			boolean isAddDormitoryInfo = dd.addDormitoryInfo(dorm);
			if(isAddDormitoryInfo) 
				return true;
		} catch (RecordNotFoundException e) {
			// TODO: handle exception
			throw new RecordNotFoundException();
		}
		catch (OutOfLimitException e) {
			// TODO: handle exception
			throw new OutOfLimitException();
		}
		return false;
	}
	
	
}
