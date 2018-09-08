package vCampus.client.biz;

import java.util.ArrayList;

import vCampus.vo.CourseChoose;
import vCampus.vo.CourseInformation;

/**
 * @author SongZixing
 *
 * @version 0.0
 * 
 */
public interface AcademicAffairsService {

	/**
	 * 得到所有异常的代码提示，浅显易懂
	 * @param 
	 * @return String
	 */
	public String getExceptionCode();
	
	
	
	
	/**
	 * 根据courseID得到具体的课程详细信息（具体见CourseInformation类）
	 * 若没有这门课的信息，返回异常状态码RecordNotFoundException
	 * @param courseID
	 * @return CourseInformation
	 */
	public CourseInformation findCourseInformation(String courseID);

	//academic affairs service for student
	
	
	//以下开始为学生的教务处提供的方法
	/**
	 * 得到缓存中学生所有选的课程的简单信息列表（具体见CourseChoose类）
	 * 
	 * @return ArrayList<CourseChoose>
	 */
	public ArrayList<CourseChoose> getCacheStudentCourse();
	
	
	
	
	/**
	 * 
	 * 访问服务器得到最新的学生所有选的课程的简单信息列表
	 * 
	 * @return ArrayList<CourseChoose>
	 */
	public ArrayList<CourseChoose> studentGetAllCourses();
	
	
	
	
	/**
	 * 得到学生所有选的课程详细信息，方便制作课程表
	 * 
	 * @return ArrayList<CourseInformation>
	 */
	public ArrayList<CourseInformation> studentGetTimeTable();
	
	
	
	
	/**
	 * 
	 * 判断学生是否选择这门课
	 * 若没有这门课的信息，返回异常状态码RecordNotFoundException
	 * @param courseID
	 * @return boolean
	 */
	public boolean isStudentChosenCourse(String courseID);
	
	
	
	
	
	/**
	 * 
	 * 根据courseID返回该生有关这门课的简单课程信息
	 * 若没有这门课的信息，返回异常状态码RecordNotFoundException
	 * @param courseID
	 * @return CourseChoose
	 */
	public CourseChoose studentGetCourse(String courseID);
	
	
	
	
	
	/**
	 * 返回这门课该生的成绩
	 * 若没有这门课的信息，返回异常状态码RecordNotFoundException
	 * @param courseID
	 * @return double
	 */
	public double studentGetCourseGrade(String courseID);
	
	
	
	/**
	 * 返回该学生所有的课程成绩
	 * @return ArrayList<CourseChoose>
	 */
	public ArrayList<CourseChoose> studentGetAllCourseGrades();
	
	
	
	/**
	 * 返回该生的GPA，针对所有有成绩的课程
	 * @return double
	 */
	public double studentGetGPA();
	
	
	
	
	/**
	 * 
	 * 学生选CourseID课,成功选择返回true，失败返回false
	 * 如果已经选择了，返回RecordAlreadyExistException异常状态码
	 * 如果人数已经满了，返回OutOfLimitException异常状态码
	 * 如果没有这门课，返回RecordNotFoundException异常状态码
	 * @param CourseID
	 * @return boolean
	 */
	public boolean studentAddCourse(String CourseID);
	
	
	
	
	/**
	 * 学生退课根据CourseID，成功返回true，失败返回false
	 * 如果已经退选了，返回异常状态码RecordNotFoundException
	 * 如果还没有人选择这门课，返回状态异常码OutOfLimitException
	 * @param CourseID
	 * @return boolean
	 */
	public boolean studentDeleteCourse(String CourseID);
	
	
	
	
	//下面开始教师的教务处提供的方法
	
	//academic affairs service for teacher
	/**
	 * 给出教师所有的授课信息，返回的每一个所教的课程的所有学生的信息，不建议直接调用该方法
	 * 用下面的
	 * @return ArrayList<CourseChoose>
	 */
	public ArrayList<CourseChoose> teacherGetAllCourses();
	
	
	
	
	
	/**
	 * 
	 * 更新学生的成绩，成功返回true，失败返回false
	 * 具体参数要参见一下 <CourseChoose>类
	 * @param ArrayList<CourseChoose> gradesSheet
	 * @return boolean
	 */
	public boolean updateStudentGrades(ArrayList<CourseChoose> gradesSheet);
	
	
	
	
	/**
	 * 返回教师所有教的课程名列表
	 * @return ArrayList<String>
	 */
	public ArrayList<String> getTeacherCourse();
	
	
	
	/**
	 * 
	 * 返回课程courseID的所有学生信息（主要是成绩），当做查看这门courseID的全班成绩单
	 * 如果教师没有教授courseID这门课，返回异常状态码RecordNotFoundException
	 * @param courseID
	 * @return ArrayList<CourseChoose>
	 */
	public ArrayList<CourseChoose> getStudentSheetForCourse(String courseID);
	
	
	
	
	/**
	 * 修改添加学生成绩，针对courseID这门课
	 * 如果教师没有教授courseID这门课，返回异常状态码RecordNotFoundException
	 * @param courseID
	 * @param gradesSheet
	 * @return boolean
	 */
	public boolean updateStudentGradesForCourse(String courseID,ArrayList<CourseChoose> gradesSheet);
	
	
	
	//academic affairs service for admin
	
	//下面开始是管理员调用的教务处方法
	
	
	/**
	 * 查看这门课courseID的选课情况
	 * @param courseID
	 * @return ArrayList<CourseChoose>
	 */
	public ArrayList<CourseChoose> adminGetAllCourses(String courseID);
	
	
	
	/**
	 * 添加课程，成功返回true，失败返回false
	 * 如果课程已经存在，异常状态码为RecordAlreadyExistException
	 * 若包含的老师信息不存在，异常状态码为RecordNotFoundException
	 * @param newCourse
	 * @return
	 */
	public boolean addCourseByAdmin(CourseInformation newCourse);
	
	
	
	
	
	
	/**
	 * 修改课程基本信息
	 * 若课程id信息或者包含的老师信息不存在，异常状态码为RecordNotFoundException
	 * 
	 * @param updatedCourse
	 * @return
	 */
	public boolean updateCourseByAdmin(CourseInformation updatedCourse);
	
	
	
	
	/**
	 * 修改课程基本信息
	 * 若课程不存在，异常状态码为RecordNotFoundException
	 * @param courseID
	 * @return
	 */
	public boolean deleteCourseByAdmin(String courseID);
	
	
}
