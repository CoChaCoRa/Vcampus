package vCampus.client.biz;

import java.util.ArrayList;

import vCampus.client.socket.Client;
import vCampus.server.dao.CourseChooseDao;
import vCampus.util.Message;
import vCampus.util.MessageTypeCodes;
import vCampus.vo.CourseChoose;
import vCampus.vo.CourseInformation;

public class AcademicAffairsServiceImpl implements AcademicAffairsService{
	
	private Client client;
	private String exceptionCode;
	private String studentUserName;
	private ArrayList<CourseChoose> cacheStudentCourse;
	private String teacherUserName;
	private String adminUserName;
	
	public AcademicAffairsServiceImpl(int UserType, String userName) {
		// TODO Auto-generated constructor stub
		client = new Client();
		exceptionCode = "";
		cacheStudentCourse = null;
		if(UserType == 1) {
			studentUserName = userName;
			cacheStudentCourse = studentGetAllCourses();
		}
		if(UserType == 2) {
			teacherUserName = userName;
		}
		if(UserType == 3) {
			adminUserName = userName;
		}
	}
	
	public String getAdminUserName() {
		return adminUserName;
	}
	
	
	public String getStudentUserName() {
		return studentUserName;
	}
	
	public String getTeacherUserName() {
		return teacherUserName;
	}
	
	public String getExceptionCode() {
		return exceptionCode;
	}
	
	public ArrayList<CourseChoose> getCacheStudentCourse() {
		return cacheStudentCourse;
	}
	
	@Override
	public CourseInformation findCourseInformation(String courseID) {
		// TODO Auto-generated method stub
		
		exceptionCode = "";
		
		Message message = new Message();
		message.setMessageType("User");
		ArrayList<Object> data = new ArrayList<Object>();
		data.add(courseID);
		message.setData(data);
		message.setMessageType(MessageTypeCodes.UserQueryCourseInformation);
		Message serverResponse = client.sendRequestToServer(message);
		ArrayList<Object> paras = (ArrayList<Object>) serverResponse.getData();
		
		if(paras != null) {
			return (CourseInformation) paras.get(0);
		}
		
		if(!serverResponse.getExceptionCode().equals("")) {
			exceptionCode = serverResponse.getExceptionCode();
		}
		return null;
	}
	
	
	@Override
	public ArrayList<CourseChoose> studentGetAllCourses() {
		// TODO Auto-generated method stub
		exceptionCode = "";
		
		if(studentUserName != null) {
		Message message = new Message();
		message.setUserType("STUDENT");
		ArrayList<Object> data = new ArrayList<Object>();
		data.add(studentUserName);
		message.setData(data);
		message.setMessageType(MessageTypeCodes.studentQueryCourses);
		
		Message serverResponse = client.sendRequestToServer(message);
		ArrayList<Object> paras = (ArrayList<Object>) serverResponse.getData();
		
		if(paras != null) {
			//ArrayList<CourseChoose> result = new ArrayList<CourseChoose>(paras.size());
			//for(int i = 0 ; i < paras.size(); i++) {
			//	result.add(i, (CourseChoose)paras.get(i)); 
			//}
			ArrayList<CourseChoose> result = (ArrayList<CourseChoose>) paras.get(0);
			cacheStudentCourse = result;
			return result;
			}
		
		if( !serverResponse.getExceptionCode().equals("")) {
			exceptionCode = serverResponse.getExceptionCode();
		}
		
		return null;
		}
		else {
			exceptionCode = "NoStudentAccountFound";
			return null;
		}
	}
	
	
	@Override
	public ArrayList<CourseInformation> studentGetTimeTable() {
		// TODO Auto-generated method stub
		exceptionCode = "";
		
	if(studentUserName != null) {
		if(cacheStudentCourse != null) {
			ArrayList<CourseInformation> TimeTable = new ArrayList<CourseInformation>();
			for(int i = 0;i < cacheStudentCourse.size();i++) {
				TimeTable.add(findCourseInformation(cacheStudentCourse.get(i).getCourseID()));
			}
			return TimeTable;
		}
		else {
			exceptionCode = "NoStudentCourse";
			return null;
		}
	}
	else {
		exceptionCode = "NoStudentAccountFound";
		return null;
	}
	}
	
	
	
	@Override
	public boolean isStudentChosenCourse(String courseID) {
		// TODO Auto-generated method stub
		exceptionCode = "";
		
		ArrayList<CourseChoose> studentAllChosenCourses = cacheStudentCourse;
		for(int i = 0; i < studentAllChosenCourses.size(); i++) {
			if(courseID .equals(studentAllChosenCourses.get(i).getCourseID()) ) return true;
		}
		return false;
	}
	
	
	@Override
	public CourseChoose studentGetCourse(String courseID) {
		// TODO Auto-generated method stub
		exceptionCode = "";
		
		ArrayList<CourseChoose> studentAllChosenCourses = cacheStudentCourse;
		for(int i = 0; i < studentAllChosenCourses.size(); i++) {
			if(courseID.equals(studentAllChosenCourses.get(i).getCourseID())  ) {
				return studentAllChosenCourses.get(i);
			}
		}
		
		exceptionCode = "RecordNotFoundException";
		return null;
	}
	
	@Override
	public double studentGetCourseGrade(String courseID) {
		// TODO Auto-generated method stub
		exceptionCode = "";
		
		if(isStudentChosenCourse(courseID)) {
			CourseChoose res = studentGetCourse(courseID);
			if(res != null) {
				return res.getScore();
			}
			
		}
		return 0;
	}
	
	
	@Override
	public ArrayList<CourseChoose> studentGetAllCourseGrades() {
		// TODO Auto-generated method stub
		if(cacheStudentCourse != null) return cacheStudentCourse;
		return null;
	}
	
	@Override
	public boolean studentAddCourse(String CourseID) {
		// TODO Auto-generated method stub
		exceptionCode = "";
		
		Message message = new Message();
		message.setMessageType("STUDENT");
		ArrayList<Object> data = new ArrayList<Object>();
		data.add(studentUserName);
		data.add(CourseID);
		message.setData(data);
		message.setMessageType(MessageTypeCodes.studentAddCourse);
		
		Message serverResponse = client.sendRequestToServer(message);
		ArrayList<Object> paras = (ArrayList<Object>) serverResponse.getData();
		if(paras != null) {
			boolean isAddCourse = (boolean) paras.get(0);
			if(isAddCourse) {
				cacheStudentCourse = studentGetAllCourses();
				return true;
				}
		}
		
		if(!serverResponse.getExceptionCode().equals("")) {
			exceptionCode = serverResponse.getExceptionCode();
			return false;
		}
		return false;
	}
	
	
	@Override
	public boolean studentDeleteCourse(String CourseID) {
		// TODO Auto-generated method stub
		exceptionCode = "";
		
		Message message = new Message();
		message.setMessageType("STUDENT");
		ArrayList<Object> data = new ArrayList<Object>();
		data.add(studentUserName);
		data.add(CourseID);
		message.setData(data);
		message.setMessageType(MessageTypeCodes.studentDeleteCourse);
		
		Message serverResponse = client.sendRequestToServer(message);
		ArrayList<Object> paras = (ArrayList<Object>) serverResponse.getData();
		if(paras != null) {
			boolean isDeleteCourse = (boolean) paras.get(0);
			if(isDeleteCourse) {
				cacheStudentCourse = studentGetAllCourses();
				return true;
			}
		}
		
		if(!serverResponse.getExceptionCode().equals("")) {
			exceptionCode = serverResponse.getExceptionCode();
			return false;
		}
		return false;
	}
	
	
	
	@Override
	public double studentGetGPA() {
		// TODO Auto-generated method stub
		ArrayList<Double> allCourseGrades = new ArrayList<Double>();
		ArrayList<Double> allCourseCredits = new ArrayList<Double>();
		
		double sumCredits = 0;
		for(int i = 0; i < cacheStudentCourse.size(); i++) {
			if(cacheStudentCourse.get(i).getScore() != 0) {
				allCourseGrades.add(cacheStudentCourse.get(i).getScore());
				double tempCredits = findCourseInformation(cacheStudentCourse.get(i).getCourseID()).getCredit();
				allCourseCredits.add(tempCredits);
				sumCredits += tempCredits;
			}
		}
		double GPA = 0;
		
		for(int i = 0;i < allCourseGrades.size(); i++) {
			GPA += allCourseGrades.get(i)*allCourseCredits.get(i)/sumCredits;
		}
		
		return GPA;
	}
	
	
	
}
