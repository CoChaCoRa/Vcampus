package vCampus.server.socket;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import vCampus.util.Query;
public class ServerMainView {
	
	public static Server server = new Server();
	public ServerMainView() {
		// TODO Auto-generated constructor stub
		super();
		server.run();
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("Server");
		frame.setSize(350, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel(new BorderLayout());
		frame.add(panel);
		
		
		
		panel.setLayout(null);
		
		JButton runServerButton = new JButton("Show");
		runServerButton.setBounds(50,120,80,25);
		
		
		JTextArea messageField = new JTextArea();
		runServerButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			//	server = new Server();
			//	server.run();
			//	messageField.setText("123\n445");
				messageField.setWrapStyleWord(true);
				messageField.setLineWrap(true);
				messageField.setEditable(false);
				messageField.setBackground(Color.YELLOW);
				
				
				//messageField.append("\n234");
			
				//System.out.println("Server is running!");
				//System.out.println(Query.getAllQueries().size());
				for(int i = 0;i<Query.getAllQueries().size();i++) {
					if(i==0) messageField.append((i+1)+" : "+Query.getAllQueries().get(i));
					else messageField.append("\n"+(i+1)+" : "+Query.getAllQueries().get(i));
				}
				/*JOptionPane.showMessageDialog(
                        panel,
                        "Server begins running!",
                        "Server is running!",
                        JOptionPane.INFORMATION_MESSAGE
                );*/
				runServerButton.setEnabled(true);
				
			}
		});
		
		panel.add(runServerButton);
		
		JButton stopServerButton = new JButton("Run");
		stopServerButton.setBounds(220, 120, 80, 25);
		panel.add(stopServerButton);
		
		stopServerButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(
                panel,
                "Server begins running!",
                "Server is running!",
                JOptionPane.INFORMATION_MESSAGE
        );
			}
		});
		
		
		
		
		messageField.setBounds(50, 30, 250, 80);
		
		JScrollPane jscrollPane = new JScrollPane(messageField);
		jscrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		jscrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		jscrollPane.setBounds(50, 30, 250, 80);
		jscrollPane.setViewportView(messageField);
		
		panel.add(jscrollPane,BorderLayout.CENTER);
		frame.setVisible(true);
		
		
		ServerMainView serverMainView = new ServerMainView();
	
		
	}
	
	
}
