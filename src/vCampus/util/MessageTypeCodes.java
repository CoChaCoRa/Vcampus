package vCampus.util;


/**
 * @author SongZixing
 *
 * @version 0.0
 * 
 */
public interface MessageTypeCodes {
	
	String studentRegister = "STUDENT_REGISTER";
	String studentLogin = "STUDENT_LOGIN";
	String studentChangePassword = "STUDENT_CHANGE_PASSWORD";
	String studentUpdateInfomation = "STUDENT_UPDATE_INFORMATION";
	String studentDestroyAccount = "STUDENT_DESTROY_ACCOUNT";
	String adminRegister = "ADMIN_REGISTER";
	String adminLogin = "ADMIN_LOGIN";
	String adminUpdatePassword = "ADMIN_UPDATE_PASSWORD";
	String adminDestroyAccount = "ADMIN_DESTROY_ACCOUNT";
	String teacherLogin = "TEACHER_LOGIN";
	String teacherRegister = "TEACHER_REGISTER";
	String teacherChangePassword = "TEACHER_CHANGE_PASSWORD";
	String teacherUpdateInformation = "TEACHER_UPDATE_INFORMATION";
	String teacherDestroyAccount = "TEACHER_DESTROY_ACCOUNT";
	String UserQueryCourseInformation = "USER_QUERY_COURSE_INFORMATION";
	String studentQueryCourses = "STUDENT_QUERY_COURSES";
	String studentAddCourse = "STUDENT_ADD_COURSE";
	String studentDeleteCourse = "STUDENT_DELETE_COURSE";
	String teacherUpdateCourseGrades = "TEACHER_UPDATE_COURSE_GRADES";
	String teacherQueryCourses = "TEACHER_QUERT_COURSES";
	String adminQueryCourses = "ADMIN_QUERY_COURSES";
	String adminAddCourse = "ADMIN_ADD_COURSE";
	String adminDeleteCourse = "ADMIN_DELETE_COURSE";
	String adminUpdateCourse = "ADMIN_UPDATE_COURSE";
	String userQueryBookInformation = "USER_QUERY_BOOK_INFROMARION";
	String userQueryBookByBookname = "USER_QUERY_BOOK_BY_BOOKNAME";
	String userQueryBookBorrow = "USER_QUERY_BOOK_BORROW";
	String userBorrowBook = "USER_BORROW_BOOK";
	String userReturnBook = "USER_RETURN_BOOK";
	String adminAddBook = "ADMIN_ADD_BOOK";
	String adminUpdateBook = "ADMIN_UPDATE_BOOK";
	String adminDeleteBook = "ADMIN_DELETE_BOOK";
	
	
	
}
