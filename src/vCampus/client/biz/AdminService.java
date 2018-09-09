package vCampus.client.biz;

import vCampus.vo.Admin;
import vCampus.vo.Student;

/**
 * @author SongZixing
 *
 */
public interface AdminService {

	public Admin getCacheAdmin();
	public String getExceptionCode();
	public boolean register(String userName,String password,String confirmedPassword);
	public boolean login(String userName,String password);
	public boolean updatePassword(String password);
	public boolean destoryAccount(String userType,String userName);
	
	public boolean addStudentAccount(Student newStudent);
	public Student queryStudentInformation(String studentUserName);
	public boolean updateStudentInformation(Student updatedStudent);

	
}
