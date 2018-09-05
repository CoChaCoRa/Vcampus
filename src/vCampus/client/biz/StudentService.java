package vCampus.client.biz;

import vCampus.vo.Student;

/**
 * @author SongZixing
 * 
 * @version 0.0
 *
 * This is an interface for service for student
 */
public interface StudentService {

	public Student getCacheStudent();
	public String getExceptionCode();
	public boolean register(String studentID,String studentPassword,String studentConfirmedPassword);
	public boolean login(String studentID, String studentPassword);
	public boolean updatePassword(String originalPassword, String newPassword, String newConfirmedPassword);
	public boolean updateInfo(Student updatedStudent);
	public boolean deleteStudentAccount(String userName);
}
