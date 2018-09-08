package vCampus.server.biz;

import java.util.ArrayList;

import vCampus.server.exception.RecordAlreadyExistException;
import vCampus.server.exception.RecordNotFoundException;
import vCampus.server.exception.WrongPasswordException;
import vCampus.vo.CourseChoose;
import vCampus.vo.Teacher;

public interface TeacherServiceDao {

	Teacher login(String userName, String password) throws RecordNotFoundException,WrongPasswordException;
	Teacher register(String userName, String password) throws RecordAlreadyExistException;
	Teacher updatePassword(String userName, String newPassword) throws RecordNotFoundException;
	Teacher updateTeacherInfo(Teacher updatedTeacher) throws RecordNotFoundException;
	boolean destoryTeacher(String userName) throws RecordNotFoundException;
	
	boolean updateStudentGrades(ArrayList<CourseChoose> gradesSheet) throws RecordNotFoundException;
	ArrayList<CourseChoose> findAllTeachCourses(String teacherName);
}
