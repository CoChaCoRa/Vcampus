package vCampus.dao;

import java.util.ArrayList;

import vCampus.server.dao.DormitoryDao;
import vCampus.server.dao.DormitoryDaoImpl;
import java.sql.Date;
import vCampus.server.exception.*;
import vCampus.vo.*;

public class TestDormitoryDao {
	private static DormitoryDao dormImpl=new DormitoryDaoImpl();
	
	/*
	public ArrayList<Dormitory> queryDormitoryByUserName(String userName);
	public ArrayList<Dormitory> queryDormitoryByDormNumber(String dormNumber);
	public boolean addDormitoryInfo(Dormitory dorm)throws RecordNotFoundException;
	 * */
	
	
	private static void queryDormitoryByUserName(String userName){
		ArrayList<Dormitory> list=new ArrayList<Dormitory>();
		list=dormImpl.queryDormitoryByUserName(userName);
		if(list==null) {
			System.out.println("NULL!\n");
			return;
		}
		for(int i=0;i<list.size();i++)
			System.out.println(Integer.toString(i)+":  "+list.get(i));
	}
	private static void queryDormitoryByDormNumber(String dorm){
		ArrayList<Dormitory> list=new ArrayList<Dormitory>();
		list=dormImpl.queryDormitoryByDormNumber(dorm);
		if(list==null) {
			System.out.println("NULL!\n");
			return;
		}
		for(int i=0;i<list.size();i++)
			System.out.println(Integer.toString(i)+":  "+list.get(i));
	}
	
	private static boolean addDormitoryInfo(Dormitory dorm)throws Exception{
		return dormImpl.addDormitoryInfo(dorm);
	}
	
	
	public static void main(String[] args) {
		try {
			queryDormitoryByUserName("213161269");
			queryDormitoryByDormNumber("613");
			
			Dormitory dorm;
			dorm=new Dormitory();

			Date ts = new Date(System.currentTimeMillis()); 
			dorm.setChargeTime(ts);
			dorm.setDormBill(1.2);
			dorm.setDormNumber("613");
			dorm.setUserName("213161269");
			dorm.setScore(90.1);
			addDormitoryInfo(dorm);
			
			queryDormitoryByUserName("213161269");
		}catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
