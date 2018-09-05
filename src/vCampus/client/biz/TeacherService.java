package vCampus.client.biz;

import vCampus.vo.Teacher;

public interface TeacherService {

	public Teacher getCacheTeacher();
	public String getExceptionCode();
	public boolean register(String teacherID,String teacherPassword,String teacherConfirmedPassword);
	public boolean login(String teacherID, String teacherPassword);
	public boolean updatePassword(String originalPassword, String newPassword, String newConfirmedPassword);
	public boolean updateInfo(Teacher updatedTeacher);
	
}
