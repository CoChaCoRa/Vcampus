package vCampus.biz.clent;

import java.util.ArrayList;

import com.hxtt.c.l;

import vCampus.client.biz.AcademicAffairsService;
import vCampus.client.biz.AcademicAffairsServiceImpl;
import vCampus.server.biz.StudentServiceDao;
import vCampus.server.biz.StudentServiceDaoImpl;
import vCampus.server.dao.CourseChooseDao;
import vCampus.server.dao.CourseChooseDaoImpl;
import vCampus.server.dao.StudentDao;
import vCampus.server.dao.StudentDaoImpl;
import vCampus.server.exception.OutOfLimitException;
import vCampus.server.exception.RecordAlreadyExistException;
import vCampus.server.exception.RecordNotFoundException;
import vCampus.vo.CourseChoose;
import vCampus.vo.CourseInformation;

public class TestAcademicService {
	public static void main(String[] args) throws RecordNotFoundException, RecordAlreadyExistException, OutOfLimitException {
		
		AcademicAffairsService academicAffairsService = new AcademicAffairsServiceImpl(1,"213160821");
		
		//test findCourseInformation
		
		System.out.println("test findCourseInformation:");
		System.out.println(academicAffairsService.findCourseInformation("3").getCourseName());
		
		//test findAllcourse
		
		//StudentServiceDao studentServiceDao = new StudentServiceDaoImpl();
		//System.out.println(studentServiceDao.findAllChosenCourses("yhy").get(0).getCourseName());
		//System.out.println(academicAffairsService.studentGetAllCourses("yhy").get(0).getCourseName());
		//ArrayList<CourseChoose> result = academicAffairsService.studentGetAllCourses();
		System.out.println("test getCacheStudentCourse");
		ArrayList<CourseChoose> result = academicAffairsService.getCacheStudentCourse();
		for(int i = 0;i < result.size();i++) {
			System.out.println(result.get(i).getCourseName());
		}
		
		//test timetable
		System.out.println("test timetable");
		ArrayList<CourseInformation> timetable = academicAffairsService.studentGetTimeTable();
		for(int i = 0; i < result.size();i++) {
			System.out.println(timetable.get(i).getCourseName());
		}
		
		//test studentGetCourseGrade
		System.out.println("studentGetCourseGrade");
		System.out.println(academicAffairsService.studentGetCourseGrade("4"));
		
		
		//test studentGetAllCourseGrades
		System.out.println("studentGetAllCourseGrades");
		ArrayList<CourseChoose> Allgrades = academicAffairsService.studentGetAllCourseGrades();
		for(int i = 0;i < Allgrades.size(); i++) {
			System.out.println(Allgrades.get(i).getCourseName()+" : "+Allgrades.get(i).getScore());
		}
		
		//test student add course
		System.out.println("test student add course : ");
		System.out.println(academicAffairsService.studentAddCourse("5"));
		System.out.println(academicAffairsService.getExceptionCode());

		System.out.println("after adding the new course: ");
		ArrayList<CourseChoose> newCourses = academicAffairsService.getCacheStudentCourse();
		for(int i = 0;i < newCourses.size();i++) {
			System.out.println(newCourses.get(i).getCourseName());
		}
		
		/*CourseChooseDao courseChooseDao = new CourseChooseDaoImpl();
		if(courseChooseDao.deleteCourseByStudent("213160821", "5")) {
			System.out.println("success");
		}*/
		
		
		/*StudentServiceDao studentServiceDao = new StudentServiceDaoImpl();
		if(studentServiceDao.deleteCourse("213160821", "5")) {
			System.out.println("Success!");
		}*/
		
		//test student delete course
		System.out.println("test student delete course : ");
		System.out.println(academicAffairsService.studentDeleteCourse("5"));
		System.out.println(academicAffairsService.getExceptionCode());

		System.out.println("after deleting the new course: ");
		ArrayList<CourseChoose> UpdatedCourses = academicAffairsService.getCacheStudentCourse();
		for(int i = 0;i < UpdatedCourses.size();i++) {
			System.out.println(UpdatedCourses.get(i).getCourseName());
		}
		
		//test GPA
		System.out.println(academicAffairsService.studentGetGPA());
		
		//test getTimetable
/*		ArrayList<CourseInformation> result2 = academicAffairsService.studentGetTimeTable("yhy");
		for(int i = 0; i < result2.size(); i++) {
			System.out.println("Course "+i+" : "+result2.get(0).getCoursePlace());
		}
		
		//test studentGetCourse
		System.out.println(academicAffairsService.studentGetCourse("yhy", "1").getScore());
		
		//test GPA
		 * 
		 * 
*/		
	}
}
