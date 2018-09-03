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

import vCampus.client.biz.StudentService;
import vCampus.client.biz.StudentServiceImpl;
import vCampus.server.biz.StudentServiceDao;
import vCampus.server.biz.StudentServiceDaoImpl;
import vCampus.server.exception.RecordNotFoundException;
import vCampus.server.exception.WrongPasswordException;
import vCampus.util.Message;
import vCampus.util.MessageTypeCodes;
import vCampus.vo.Student;

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
            	catch (SQLException e) {
					// TODO: handle exception
            		serverResponse.setExceptionCode("SQLException");
				}
            	catch (RecordNotFoundException e) {
					// TODO: handle exception
            		serverResponse.setExceptionCode("RecordNotFoundException");
				}
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
				} catch (SQLException e) {
					// TODO: handle exception
					serverResponse.setExceptionCode("SQLException");
				}
            	catch (RecordNotFoundException e) {
					// TODO: handle exception
            		serverResponse.setExceptionCode("RecordNotFoundException");
				}
            }
          
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	
	}
}
