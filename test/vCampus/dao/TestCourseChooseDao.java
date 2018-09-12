package vCampus.dao;

import java.sql.Date;
import java.util.ArrayList;


import vCampus.server.dao.CourseChooseDao;
import vCampus.server.dao.CourseChooseDaoImpl;
import vCampus.server.exception.*;
import vCampus.vo.*;
/**
 * @author YangHangyuan
 *
 * 
 */
public class TestCourseChooseDao {

	private static CourseChooseDao ccImpl=new CourseChooseDaoImpl();
	
	/*
	public CourseInformation findCourse(String courseID);
    public ArrayList<CourseInformation> allCourses();
    public ArrayList<CourseChoose> courseQueryByStudent(String studentName)throws RecordNotFoundException;
    public ArrayList<CourseChoose> courseQueryByTeacher(String teacherName)throws RecordNotFoundException;
    public ArrayList<CourseChoose> courseQueryByCourse(String courseID)throws RecordNotFoundException;
    public boolean addCourseByStudent(String studentName,String courseID)throws RecordNotFoundException,RecordAlreadyExistException,OutOfLimitException;
    public boolean deleteCourseByStudent(String studentName,String courseID)throws RecordNotFoundException,OutOfLimitException;
    public boolean updateScoreByTeacher(ArrayList<CourseChoose> scoreList)throws RecordNotFoundException;
    public boolean addCourseByAdmin(CourseInformation course)throws RecordAlreadyExistException;
    public boolean updateCourseByAdmin(CourseInformation course)throws RecordNotFoundException;
    public boolean deleteCourseByAdmin(String courseID)throws RecordNotFoundException; 
	 * */
	
	private static CourseInformation findCourse(String courseID)throws Exception {
		return ccImpl.findCourse(courseID);
	}
	private static void allCourses() {
		ArrayList<CourseInformation> list=ccImpl.allCourses();
		for(int i=0;i<list.size();i++)
			System.out.println(i+" : "+list.get(i));
	}
	private static ArrayList<CourseChoose> courseQueryByStudent(String studentUserName)throws Exception {
		return ccImpl.courseQueryByStudent(studentUserName);
	}
	private static ArrayList<CourseChoose> courseQueryByTeacher(String teacherUserName)throws Exception {
		return ccImpl.courseQueryByTeacher(teacherUserName);
	}
	private static ArrayList<CourseChoose> courseQueryByCourse(String courseID)throws Exception {
		return ccImpl.courseQueryByCourse(courseID);
	}
    private static boolean addCourseByStudent(String studentName,String courseID)throws Exception{
    	return ccImpl.addCourseByStudent(studentName,courseID);
    }
    private static boolean deleteCourseByStudent(String studentName,String courseID)throws Exception{
    	return ccImpl.deleteCourseByStudent(studentName, courseID);
    }
    private static boolean updateScoreByTeacher(ArrayList<CourseChoose> scoreList)throws Exception{
    	return ccImpl.updateScoreByTeacher(scoreList);
    }
    private static boolean addCourseByAdmin(CourseInformation course)throws Exception{
    	return ccImpl.addCourseByAdmin(course);
    }
    private static boolean updateCourseByAdmin(CourseInformation course)throws Exception{
    	return ccImpl.updateCourseByAdmin(course);
    }
    private static boolean deleteCourseByAdmin(String courseID)throws Exception{
    	return ccImpl.deleteCourseByAdmin(courseID);
    }
    
	public static void main(String[] args) {
		try {
			allCourses();
			CourseInformation queryResult1=new CourseInformation();
			ArrayList<CourseChoose> queryResult2=new ArrayList<CourseChoose>();

			queryResult1=findCourse("1");
			if(queryResult1==null)throw new RecordNotFoundException();
			System.out.println(queryResult1.getCourseID()+" "+queryResult1.getCourseName());

			queryResult2=courseQueryByStudent("213161269");
			if(queryResult2==null)throw new RecordNotFoundException();
			for(int i=0;i<queryResult2.size();i++) {
				System.out.println(queryResult2.get(i).getCourseID()+" "
						+queryResult2.get(i).getCourseName());
			}
			queryResult2=courseQueryByTeacher("213161269");
			if(queryResult2==null)throw new RecordNotFoundException();
			for(int i=0;i<queryResult2.size();i++) {
				System.out.println(queryResult2.get(i).getCourseID()+" "
						+queryResult2.get(i).getCourseName());
			}
			
			queryResult2=courseQueryByCourse("2");
			if(queryResult2==null)throw new RecordNotFoundException();
			for(int i=0;i<queryResult2.size();i++) {
				System.out.println(queryResult2.get(i).getCourseID()+" "
						+queryResult2.get(i).getCourseName());
			}

			if(addCourseByStudent("213161269","2")) {
				queryResult2=courseQueryByStudent("213161269");
				if(queryResult2==null)throw new RecordNotFoundException();
				for(int i=0;i<queryResult2.size();i++) {
					System.out.println(queryResult2.get(i).getCourseID()+" "
							+queryResult2.get(i).getCourseName());
				}
			}else System.out.println("Error!");

			if(deleteCourseByStudent("213161269","2")) {
				queryResult2=courseQueryByStudent("213161269");
				if(queryResult2==null)System.out.println("213161269 doesn't wrestle!");
				else for(int i=0;i<queryResult2.size();i++) {
					System.out.println(queryResult2.get(i).getCourseID()+" "
							+queryResult2.get(i).getCourseName());
				}
			}else System.out.println("Error!");

			ArrayList<CourseChoose> scoreList=new ArrayList<CourseChoose>();
			CourseChoose cc1=new CourseChoose(),cc2=new CourseChoose();
			cc1.setCourseID("1");
			cc1.setScore(90);
			cc1.setStudentUserName("213161269");
			scoreList.add(cc1);
			cc2.setCourseID("2");
			cc2.setScore(91);
			cc2.setStudentUserName("213160821");
			scoreList.add(cc2);
		    if(updateScoreByTeacher(scoreList)){
		    	queryResult2=courseQueryByStudent("213161269");
				if(queryResult2==null)System.out.println("213161269 doesn't study!");
		    	for(int i=0;i<queryResult2.size();i++) {
					System.out.println(queryResult2.get(i).getCourseID()+" "
							+queryResult2.get(i).getStudentUserName()+" "
							+queryResult2.get(i).getScore());
				}
		    	
		    	queryResult2=courseQueryByStudent("213160821");
				if(queryResult2==null)System.out.println("213160821 doesn't study!");
		    	for(int i=0;i<queryResult2.size();i++) {
					System.out.println(queryResult2.get(i).getCourseID()+" "
							+queryResult2.get(i).getStudentUserName()+" "
							+queryResult2.get(i).getScore());
				}
		    }else System.out.println("Error!");

		    CourseInformation course=new CourseInformation();
		    Date ts = new Date(System.currentTimeMillis());   
		    course.setCourseDate(ts);
		    course.setExamTime(ts);
	        course.setCourseHour(100);
	        course.setCourseID("3");
	        course.setCourseName("Boxing");
	        course.setCoursePlace("darkplayground");
	        course.setCredit(3.8);
	        course.setCurrentAmount(0);
	        course.setDeptName("CS");
	        course.setExamPlace("3B613");
	        course.setPersonLimit(1000);
	        course.setTeacherUserName("szxdl");
	        course.setTeacherName("yhy");
	        course.setWeekIndex(3);
	        
		    if(addCourseByAdmin(course)){
		    	queryResult1=findCourse("3");
				if(queryResult1==null)throw new RecordNotFoundException();
				System.out.println(queryResult1.getCourseID()+" "+queryResult1.getTeacherName());
		    }else System.out.println("Error!");

		    course.setTeacherName("syh");
		    course.setTeacherUserName("szxdl");
	        course.setExamPlace("3B614");
	        if(updateCourseByAdmin(course)){
		    	queryResult1=findCourse("3");
				if(queryResult1==null)throw new RecordNotFoundException();
				System.out.println(queryResult1.getCourseID()+" "+queryResult1.getTeacherName());
		    }else System.out.println("Error!");

		    if(deleteCourseByAdmin("3")){
		    	queryResult1=findCourse("3");
				if(queryResult1==null)throw new RecordNotFoundException();
				System.out.println(queryResult1.getCourseID()+" "+queryResult1.getCourseName());
		    }else System.out.println("Error!");
		    
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
