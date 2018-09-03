package vCampus.client.socket;

import java.io.BufferedInputStream;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import vCampus.util.Message;

/**
 * @author SongZixing
 * 
 * @version 0.1
 * 
 * Establish socket for client
 *
 */
public class Client {
	
	/**
	 * @param clientRequest
	 * @return ServerResponse
	 */
	public Message sendRequestToServer (Message clientRequest ) {
		try {
			
			//client request connection to local host at port 18888
			Socket socket = new Socket("localhost", 18888);
			//set the connection timeout
			socket.setSoTimeout(10000);
			//create request to be sent to server as ObjectOutputStream
			ObjectOutputStream request = new ObjectOutputStream(socket.getOutputStream());
			request.writeObject(clientRequest);
			request.flush();
			//shut down the output stream
			socket.shutdownOutput();
			
			
			//get the input stream response from server
			ObjectInputStream response = new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));
			Message object = (Message)response.readObject();
			//shut down the output stream
			response.close();
			//shut down socket;
			socket.close();
			
			if (object != null) {
				return object;
			}
		}
		
		catch (UnknownHostException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		} 
		catch (ClassNotFoundException e) {
			 //TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
