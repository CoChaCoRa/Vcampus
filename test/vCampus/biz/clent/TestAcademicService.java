package vCampus.biz.clent;

import java.sql.Date;
import java.util.ArrayList;

import com.hxtt.c.l;
import com.hxtt.c.o;

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
		
		System.out.println(academicAffairsService.studentGetAllAvailableCourses().size());
		
		
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
		
		AcademicAffairsService academicAffairsService2 = new AcademicAffairsServiceImpl(2, "120160821");
		
		
		System.out.println("test academic affairs for teacher: ");
		
		System.out.println("test for query teaching courses");
		System.out.println(academicAffairsService2.teacherGetAllCourses().size());
		System.out.println(academicAffairsService2.teacherGetAllCourses().get(0).getCourseName());
		
		System.out.println("test for update student grades");
		ArrayList<CourseChoose> gradesSheet = new ArrayList<CourseChoose>();
		
		CourseChoose grade1 = new CourseChoose();
		grade1.setCourseID("3");
		grade1.setScore(96);
		grade1.setStudentUserName("213160821");
		grade1.setTeacherUserName("120160821");

		
		CourseChoose grade2 = new CourseChoose();
		grade2.setCourseID("3");
		grade2.setScore(97);
		grade2.setStudentUserName("211160821");
		grade2.setTeacherUserName("120160821");
		
		
		CourseChoose grade3 = new CourseChoose();
		grade3.setCourseID("3");
		grade3.setScore(98);
		grade3.setStudentUserName("214160821");
		grade3.setTeacherUserName("120160821");

		
		gradesSheet.add(grade1);
		gradesSheet.add(grade2);
		gradesSheet.add(grade3);
		
		System.out.println(academicAffairsService2.updateStudentGrades(gradesSheet));
		
		
		//test for get all teachers' courses names
		System.out.println(academicAffairsService2.getTeacherCourse());
		
		//test for get all students sheet for certain course for teacher
		System.out.println(academicAffairsService2.getStudentSheetForCourse("4").size());
		
		//test for update certain course grades for teacher 
		ArrayList<CourseChoose> gradesSheet2 = new ArrayList<CourseChoose>();
		
		CourseChoose grade4 = new CourseChoose();
		grade4.setScore(96);
		grade4.setStudentUserName("213160821");
		grade4.setTeacherUserName("120160821");

		
		CourseChoose grade5 = new CourseChoose();
		grade5.setScore(97);
		grade5.setStudentUserName("211160821");
		grade5.setTeacherUserName("120160821");

		gradesSheet2.add(grade5);
		gradesSheet2.add(grade4);
		
		System.out.println(academicAffairsService2.updateStudentGradesForCourse("4", gradesSheet2));
		
		
		
		//test admin academic service
		AcademicAffairsService academicAffairsService3 = new AcademicAffairsServiceImpl(3, "1");
		
		System.out.println("test academic affairs for admin: ");
		System.out.println("admin query");
		System.out.println(academicAffairsService3.adminGetAllCourses("3").size());
		
		//test add course
		System.out.println("test admin add course ");
		CourseInformation course=new CourseInformation();
	    Date ts = new Date(System.currentTimeMillis());   
	    course.setCourseDate(ts);
	    course.setExamTime(ts);
        course.setCourseHour(100);
        course.setCourseID("5");
        course.setCourseName("Boxing");
        course.setCoursePlace("darkplayground");
        course.setCredit(3.8);
        course.setCurrentAmount(0);
        course.setDeptName("CS");
        course.setExamPlace("3B613");
        course.setPersonLimit(1000);
        course.setTeacherUserName("110160821");
        course.setTeacherName("ShanFeng");
        course.setWeekIndex(3);
		System.out.println(academicAffairsService3.addCourseByAdmin(course));
		System.out.println(academicAffairsService3.getExceptionCode());
		
		
		//test update course
		System.out.println("test admin update course : ");
		
		course.setWeekIndex(2);
		
		if(academicAffairsService3.updateCourseByAdmin(course)) {
			System.out.println("ok");
		}
		else {
			System.out.println(academicAffairsService3.getExceptionCode());
		}
		
		System.out.println("test admin delete course : ");
		if(academicAffairsService3.deleteCourseByAdmin("5")) {
			System.out.println("delete!");
		}
		System.out.println(academicAffairsService3.getExceptionCode());
	}
}
