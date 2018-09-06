package vCampus.dao;


import vCampus.server.dao.TeacherDao;
import vCampus.server.dao.TeacherDaoImpl;
import vCampus.server.exception.*;
import vCampus.vo.*;
/**
 * @author YangHangyuan
 *
 * 
 */
public class TestTeacherDao {
	private static TeacherDao teacherImpl=new TeacherDaoImpl();
	
	private static void findByName(String userName)throws Exception {
		Teacher std=teacherImpl.findByName(userName);
		if(std==null)throw new RecordNotFoundException();
		System.out.println(std.getUserName()+" "+std.getPassword());
	}
	
	private static boolean insertByUserNameAndPassword(String userName,String password)throws Exception {
		return teacherImpl.insertByUserNameAndPassword(userName,password);
	}
	
	private static boolean updatePassword(String userName,String password)throws Exception {
		return teacherImpl.updatePassword(userName, password);
	}
	
	private static boolean updateSelfInformation(Teacher std)throws Exception {
		return teacherImpl.updateSelfInformation(std);
	}
	
	private static boolean deleteTeacher(String userName)throws Exception {
		return teacherImpl.deleteTeacher(userName);
	}
	
	public static void main(String[] args) {
		try {
			findByName("szxdl");
			if(insertByUserNameAndPassword("213161268","gg")) {
				findByName("213161268");
			}else System.out.println("Error!");
			if(updatePassword("213161268","gga")) {
				findByName("213161268");
			}else System.out.println("Error!");
			Teacher std=new Teacher();
			std.setAccount(123.4);
			std.setBankAccount("cc");
			std.setDeptName("CSDN");
			std.setEmailAddress("cc@seu.edu.cn");
			std.setIdCard("89461236472189374");
			std.setMoney(41.3);
			std.setPassword("102938094");
			std.setPhoneNumber("1239048901");
			std.setSex("male");
			std.setTeacherEcardNumber("213147914");
			std.setProfessionalTitle("Ph.DD");
			std.setUserName("213161268");
			if(updateSelfInformation(std)) {
				findByName("213161268");
			}else System.out.println("Error!");
			if(deleteTeacher("213161268")) {
				findByName("cczuiqiang");
			}else System.out.println("Error!");
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	
}
