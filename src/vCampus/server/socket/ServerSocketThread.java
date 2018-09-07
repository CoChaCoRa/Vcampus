package vCampus.server.socket;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.security.Policy.Parameters;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import javax.xml.crypto.Data;

import com.hxtt.c.o;

import vCampus.client.biz.StudentService;
import vCampus.client.biz.StudentServiceImpl;
import vCampus.server.biz.AdminServiceDao;
import vCampus.server.biz.AdminServiceDaoImpl;
import vCampus.server.biz.StudentServiceDao;
import vCampus.server.biz.StudentServiceDaoImpl;
import vCampus.server.biz.TeacherServiceDao;
import vCampus.server.biz.TeacherServiceDaoImpl;
import vCampus.server.exception.OutOfLimitException;
import vCampus.server.exception.RecordAlreadyExistException;
import vCampus.server.exception.RecordNotFoundException;
import vCampus.server.exception.WrongPasswordException;
import vCampus.util.Message;
import vCampus.util.MessageTypeCodes;
import vCampus.vo.Admin;
import vCampus.vo.CourseChoose;
import vCampus.vo.CourseInformation;
import vCampus.vo.Student;
import vCampus.vo.Teacher;

/**
 * @author SongZixing
 *
 * @version 0.0
 * 
 */
public class ServerSocketThread extends Thread{

	private Socket clientSocket;
	
	public ServerSocketThread(Socket socket) {
		// TODO Auto-generated constructor stub
		this.clientSocket = socket;
	}
	
	@Override
	public void run() {
		try {
			ObjectInputStream message = new ObjectInputStream(new BufferedInputStream(clientSocket.getInputStream()));
			Message object = (Message)message.readObject();
            System.out.println("已接收到客户端连接"+ ",当前客户端ip为："
                    + clientSocket.getInetAddress().getHostAddress());
            System.out.println(object.getMessageType());
          
            
            if(object.getMessageType().equals(MessageTypeCodes.studentLogin) ) {
            	Message serverResponse = new Message();
            	try {
            		StudentServiceDao studentServiceDao = new StudentServiceDaoImpl();
            		ArrayList<Object> paras = (ArrayList<Object>) object.getData();
            		Student foundStudent = studentServiceDao.login((String)paras.get(0), (String)paras.get(1));
            		ArrayList<Object> data = new ArrayList<Object>();
            		data.add(foundStudent);
            		serverResponse.setData(data);
            	}
            	catch (RecordNotFoundException e) {
					// TODO: handle exception
            		serverResponse.setExceptionCode("RecordNotFoundException");
				}
            	catch (WrongPasswordException e) {
					// TODO: handle exception
            		serverResponse.setExceptionCode("WrongPasswordException");
				}
            	ObjectOutputStream response = new ObjectOutputStream(clientSocket.getOutputStream());
            	response.writeObject(serverResponse);
            	
            }
            
            if(object.getMessageType().equals(MessageTypeCodes.studentRegister)) {
            	Message serverResponse = new Message();
            	try {
            		StudentServiceDao studentServiceDao = new StudentServiceDaoImpl();
            		ArrayList<Object> Parameters = (ArrayList<Object>) object.getData();
            		Student newStudent = studentServiceDao.register((String)Parameters.get(0), (String)Parameters.get(1));
            		ArrayList<Object> data = new ArrayList<Object>();
            		data.add(newStudent);
            		serverResponse.setData(data);
            	}
            	
            	catch (RecordAlreadyExistException e) {
					// TODO: handle exception
            		serverResponse.setExceptionCode("RecordAlreadyExistException");
				}
            	ObjectOutputStream response = new ObjectOutputStream(clientSocket.getOutputStream());
            	response.writeObject(serverResponse);
            }
            
            if(object.getMessageType().equals(MessageTypeCodes.studentChangePassword)) {
            	Message serverResponse = new Message();
            	try {
					StudentServiceDao studentServiceDao = new StudentServiceDaoImpl();
					ArrayList<Object> paras = (ArrayList<Object>) object.getData();
					Student updatedStudent = studentServiceDao.updatePassword((String) paras.get(0), (String)paras.get(1));
					ArrayList<Object> data = new ArrayList<Object>();
					data.add(updatedStudent);
					serverResponse.setData(data);
				} 
            	catch (RecordNotFoundException e) {
					// TODO: handle exception
            		serverResponse.setExceptionCode("RecordNotFoundException");
				}
            	ObjectOutputStream response = new ObjectOutputStream(clientSocket.getOutputStream());
            	response.writeObject(serverResponse);
            }
            
            if(object.getMessageType().equals(MessageTypeCodes.studentUpdateInfomation)) {
            	Message serverResponse = new Message();
            	try {
            		StudentServiceDao studentServiceDao = new StudentServiceDaoImpl();
            		ArrayList<Object> paras = (ArrayList<Object>) object.getData();
            		Student updatedStudent = studentServiceDao.updateStudentInfo((Student) paras.get(0));
            		ArrayList<Object> data = new ArrayList<Object>();
            		data.add(updatedStudent);
            		serverResponse.setData(data);
				} 
            	catch (RecordNotFoundException e) {
					// TODO: handle exception
            		serverResponse.setExceptionCode("RecordAlreadyExistException");
				}
            	ObjectOutputStream response = new ObjectOutputStream(clientSocket.getOutputStream());
            	response.writeObject(serverResponse);
            }
            
            if(object.getMessageType().equals(MessageTypeCodes.studentDestroyAccount)) {
            	Message serverResponse = new Message();
            	try {
					StudentServiceDao studentServiceDao =new StudentServiceDaoImpl();
					ArrayList<Object> paras = (ArrayList<Object>) object.getData();
					boolean isDestroy = studentServiceDao.destroyStudent((String) paras.get(0));
					ArrayList<Object> data = new ArrayList<Object>();
					data.add(isDestroy);
					serverResponse.setData(data);
				} catch (RecordNotFoundException e) {
					// TODO: handle exception
					serverResponse.setExceptionCode("RecordNotFoundException");
				}
            	ObjectOutputStream response = new ObjectOutputStream(clientSocket.getOutputStream());
            	response.writeObject(serverResponse);
            }
            
            
            if(object.getMessageType().equals(MessageTypeCodes.teacherLogin)) {
            	Message serverResponse = new Message();
            	try {
            		TeacherServiceDao teacherServiceDao = new TeacherServiceDaoImpl();
            		ArrayList<Object> paras = (ArrayList<Object>) object.getData();
            		Teacher foundTeacher = teacherServiceDao.login((String)paras.get(0), (String)paras.get(1));
            		ArrayList<Object> data = new ArrayList<Object>();
            		data.add(foundTeacher);
            		serverResponse.setData(data);
            	}
            	catch (RecordNotFoundException e) {
					// TODO: handle exception
            		serverResponse.setExceptionCode("RecordNotFoundException");
				}
            	catch (WrongPasswordException e) {
					// TODO: handle exception
            		serverResponse.setExceptionCode("WrongPasswordException");
				}
            	ObjectOutputStream response = new ObjectOutputStream(clientSocket.getOutputStream());
            	response.writeObject(serverResponse);
            }
            
            if(object.getMessageType().equals(MessageTypeCodes.teacherRegister)) {
            	Message serverResponse = new Message();
            	try {
            		TeacherServiceDao teacherServiceDao = new TeacherServiceDaoImpl();
            		ArrayList<Object> Parameters = (ArrayList<Object>) object.getData();
            		Teacher newTeacher = teacherServiceDao.register((String)Parameters.get(0), (String)Parameters.get(1));
            		ArrayList<Object> data = new ArrayList<Object>();
            		data.add(newTeacher);
            		serverResponse.setData(data);
            	}
            	
            	catch (RecordAlreadyExistException e) {
					// TODO: handle exception
            		serverResponse.setExceptionCode("RecordAlreadyExistException");
				}
            	ObjectOutputStream response = new ObjectOutputStream(clientSocket.getOutputStream());
            	response.writeObject(serverResponse);
            }
            
            if(object.getMessageType().equals(MessageTypeCodes.teacherChangePassword)) {
            	Message serverResponse = new Message();
            	try {
					TeacherServiceDao teacherServiceDao = new TeacherServiceDaoImpl();
					ArrayList<Object> paras = (ArrayList<Object>) object.getData();
					Teacher updatedTeacher = teacherServiceDao.updatePassword((String) paras.get(0), (String)paras.get(1));
					ArrayList<Object> data = new ArrayList<Object>();
					data.add(updatedTeacher);
					serverResponse.setData(data);
				} 
            	catch (RecordNotFoundException e) {
					// TODO: handle exception
            		serverResponse.setExceptionCode("RecordNotFoundException");
				}
            	ObjectOutputStream response = new ObjectOutputStream(clientSocket.getOutputStream());
            	response.writeObject(serverResponse);
            }
            
            if(object.getMessageType().equals(MessageTypeCodes.teacherUpdateInformation)) {
            	Message serverResponse = new Message();
            	try {
            		TeacherServiceDao teacherServiceDao = new TeacherServiceDaoImpl();
            		ArrayList<Object> paras = (ArrayList<Object>) object.getData();
            		Teacher updatedTeacher = teacherServiceDao.updateTeacherInfo((Teacher) paras.get(0));
            		ArrayList<Object> data = new ArrayList<Object>();
            		data.add(updatedTeacher);
            		serverResponse.setData(data);
				} 
            	catch (RecordNotFoundException e) {
					// TODO: handle exception
            		serverResponse.setExceptionCode("RecordNotFoundException");
				}
            	ObjectOutputStream response = new ObjectOutputStream(clientSocket.getOutputStream());
            	response.writeObject(serverResponse);
            }
          
            
            if(object.getMessageType().equals(MessageTypeCodes.teacherDestroyAccount)) {
            	Message serverResponse = new Message();
            	try {
					TeacherServiceDao teacherServiceDao = new TeacherServiceDaoImpl();
					ArrayList<Object> paras = (ArrayList<Object>) object.getData();
					boolean isDestroy = teacherServiceDao.destoryTeacher((String) paras.get(0));
					ArrayList<Object> data = new ArrayList<Object>();
					data.add(isDestroy);
					serverResponse.setData(data);
				} catch (RecordNotFoundException e) {
					// TODO: handle exception
					serverResponse.setExceptionCode("RecordNotFoundException");
				}
            	ObjectOutputStream response = new ObjectOutputStream(clientSocket.getOutputStream());
            	response.writeObject(serverResponse);
            }
            
            
            if(object.getMessageType().equals(MessageTypeCodes.adminRegister)) {
            	Message serverResponse = new Message();
            	try {
					AdminServiceDao adminServiceDao =new AdminServiceDaoImpl();
					ArrayList<Object> paras = (ArrayList<Object>) object.getData();
					Admin admin = adminServiceDao.register((String)paras.get(0), (String) paras.get(1));
					ArrayList<Object> data = new ArrayList<Object>();
					data.add(admin);
					serverResponse.setData(data);
				} catch (RecordAlreadyExistException e) {
					// TODO: handle exception
					serverResponse.setExceptionCode("RecordAlreadyExistException");
				}
            	ObjectOutputStream response = new ObjectOutputStream(clientSocket.getOutputStream());
            	response.writeObject(serverResponse);
            }
            
            if(object.getMessageType().equals(MessageTypeCodes.adminLogin)) {
            	Message serverResponse = new Message();
            	try {
					AdminServiceDao adminServiceDao = new AdminServiceDaoImpl();
					ArrayList<Object> paras = (ArrayList<Object>) object.getData();
					Admin admin = adminServiceDao.login((String) paras.get(0),(String) paras.get(1));
					ArrayList<Object> data = new ArrayList<Object>();
					data.add(admin);
					serverResponse.setData(data);
				} catch (WrongPasswordException e) {
					// TODO: handle exception
					serverResponse.setExceptionCode("WrongPasswordException");
				}
            	catch (RecordNotFoundException e) {
					// TODO: handle exception
            		serverResponse.setExceptionCode("RecordNotFoundException");
				}
            	ObjectOutputStream response = new ObjectOutputStream(clientSocket.getOutputStream());
            	response.writeObject(serverResponse);
            }
            
            if(object.getMessageType().equals(MessageTypeCodes.adminUpdatePassword)) {
            	Message serverResponse = new Message();
            	try {
					AdminServiceDao adminServiceDao = new AdminServiceDaoImpl();
					ArrayList<Object> paras = (ArrayList<Object>) object.getData();
					Admin admin = adminServiceDao.updatePassword((String)paras.get(0),(String) paras.get(1));
					ArrayList<Object> data = new ArrayList<Object>();
					data.add(admin);
					serverResponse.setData(data);
				} catch (RecordNotFoundException e) {
					// TODO: handle exception
					serverResponse.setExceptionCode("RecordNotFoundException");
				}
            	ObjectOutputStream response = new ObjectOutputStream(clientSocket.getOutputStream());
            	response.writeObject(serverResponse);
            }
            
            
            if(object.getMessageType().equals(MessageTypeCodes.adminDestroyAccount)) {
            	Message serverResponse = new Message();
            	try {
					AdminServiceDao adminServiceDao =new AdminServiceDaoImpl();
					ArrayList<Object> paras = (ArrayList<Object>) object.getData();
					boolean isDestroy = adminServiceDao.destroy((String) paras.get(0));
					ArrayList<Object> data = new ArrayList<Object>();
					data.add(isDestroy);
					serverResponse.setData(data);
				} catch (RecordNotFoundException e) {
					// TODO: handle exception
					serverResponse.setExceptionCode("RecordNotFoundException");
				}
            	ObjectOutputStream response = new ObjectOutputStream(clientSocket.getOutputStream());
            	response.writeObject(serverResponse);
            }
            
            if(object.getMessageType().equals(MessageTypeCodes.studentQueryCourses)) {
            	Message serverResponse = new Message();
            	
					StudentServiceDao studentServiceDao = new StudentServiceDaoImpl();
					ArrayList<Object> paras = (ArrayList<Object>) object.getData();
					ArrayList<CourseChoose> allCourses = studentServiceDao.findAllChosenCourses((String) paras.get(0));
					ArrayList<Object> data = new ArrayList<Object>();
					data.add(allCourses);
					serverResponse.setData(data);
					ObjectOutputStream response = new ObjectOutputStream(clientSocket.getOutputStream());
	            	response.writeObject(serverResponse);
            }
            
            if(object.getMessageType().equals(MessageTypeCodes.studentAddCourse)) {
            	Message serverResponse = new Message();
            	
            	try {
					StudentServiceDao studentServiceDao = new StudentServiceDaoImpl();
					ArrayList<Object> paras = (ArrayList<Object>) object.getData();
					boolean isAddCourse = studentServiceDao.addCourse((String) paras.get(0), (String) paras.get(1));
					ArrayList<Object> data = new ArrayList<Object>();
					data.add(isAddCourse);
					serverResponse.setData(data);
				} catch (RecordAlreadyExistException e) {
					// TODO: handle exception
					serverResponse.setExceptionCode("RecordAlreadyExistException");
				}
            	catch (RecordNotFoundException e) {
					// TODO: handle exception
            		serverResponse.setExceptionCode("RecordNotFoundException");
				}
            	
            	catch (OutOfLimitException e) {
					// TODO: handle exception
            		serverResponse.setExceptionCode("OutOfLimitException");
				}
            	
            	ObjectOutputStream response = new ObjectOutputStream(clientSocket.getOutputStream());
            	response.writeObject(serverResponse);
            }
            
            if(object.getMessageType().equals(MessageTypeCodes.studentDeleteCourse)) {
            	Message serverResponse = new Message();
            	
            	try {
					StudentServiceDao studentServiceDao = new StudentServiceDaoImpl();
					ArrayList<Object> paras = (ArrayList<Object>) object.getData();
					boolean isDeleteCourse = studentServiceDao.deleteCourse((String) paras.get(0),(String) paras.get(1));
					ArrayList<Object> data = new ArrayList<Object>();
					data.add(isDeleteCourse);
					serverResponse.setData(data);
				} catch (RecordNotFoundException e) {
					// TODO: handle exception
					serverResponse.setExceptionCode("RecordNotFoundException");
				}
            	
            	catch (OutOfLimitException e) {
					// TODO: handle exception
            		serverResponse.equals("OutOfLimitException");
				}
            	
            	ObjectOutputStream response = new ObjectOutputStream(clientSocket.getOutputStream());
            	response.writeObject(serverResponse);
            	
            }
            
            if(object.getMessageType().equals(MessageTypeCodes.UserQueryCourseInformation)) {
            	Message serverResponse = new Message();
            	
            	StudentServiceDao studentServiceDao = new StudentServiceDaoImpl();
            	ArrayList<Object> paras = (ArrayList<Object>) object.getData();
            	CourseInformation courseInformation = studentServiceDao.findCourseInformation((String) paras.get(0));
            	ArrayList<Object> data = new ArrayList<Object>();
            	data.add(courseInformation);
            	serverResponse.setData(data);
            	
            	ObjectOutputStream response = new ObjectOutputStream(clientSocket.getOutputStream());
            	response.writeObject(serverResponse);
            	
            }
            
            if(object.getMessageType().equals(MessageTypeCodes.studentQueryCourses)) {
            	Message serverResponse = new Message();
            	
            	
					StudentServiceDao studentServiceDao = new StudentServiceDaoImpl();
					ArrayList<Object> paras = (ArrayList<Object>) object.getData();
					ArrayList<CourseChoose> allChosenCourses = studentServiceDao.findAllChosenCourses((String) paras.get(0));
					ArrayList<Object> data = new ArrayList<Object>();
					//System.out.println(allChosenCourses.get(0).getCourseName());
					//for(int i = 0; i < allChosenCourses.size(); i++) {
					//	data.add(allChosenCourses.get(i));
					//}
					data.add(allChosenCourses);
					serverResponse.setData(data);
					ObjectOutputStream response = new ObjectOutputStream(clientSocket.getOutputStream());
	            	response.writeObject(serverResponse);
            }
            
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	
	}
}
