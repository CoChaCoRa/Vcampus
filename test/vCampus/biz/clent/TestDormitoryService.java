package vCampus.biz.clent;

import java.sql.Date;

import vCampus.client.biz.DormitoryService;
import vCampus.client.biz.DormitoryServiceImpl;
import vCampus.vo.Dormitory;

public class TestDormitoryService {

	// test TestDormitoryService
	
	
	public static void main(String[] args) {
		//test queryDormitoryByUserName
		
		DormitoryService dormitoryService = new DormitoryServiceImpl();
		
		System.out.println("test on queryDormitoryByUserName");
		if(dormitoryService.queryDormitoryByUserName("213161269") != null) {
			System.out.println(dormitoryService.queryDormitoryByUserName("213161269"));
		}
		
		
		
		// test on queryDormitoryByUserName
		
		if(dormitoryService.queryDormitoryByDormNumber("613") != null) {
			System.out.println(dormitoryService.queryDormitoryByDormNumber("613").size());
		}
		
		
		//test add dormitory info
		
		Dormitory dorm;
		dorm=new Dormitory();

		Date ts = new Date(System.currentTimeMillis()); 
		dorm.setChargeTime(ts);
		dorm.setDormBill(1.2);
		dorm.setDormNumber("613");
		dorm.setUserName("213161269");
		dorm.setScore(99.1);
		
		if(dormitoryService.addDormitoryInfo(dorm)) {
			System.out.println("ok!yeah~~");
		}
	}
}
