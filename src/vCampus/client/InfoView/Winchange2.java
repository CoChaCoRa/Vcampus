package vCampus.client.InfoView;
import javax.swing.*;
import java.awt.Font;


public class Winchange2 extends JPanel {
		
		Winchange2(){
			super();
			Font font=new Font("苹方 常规",Font.CENTER_BASELINE,28);
			this.setLayout(null);
			JButton jb1=new JButton();
			JButton jb2=new JButton();
			this.add(jb1);
		    jb1.setBounds(0, 0, 270, 80);
		    jb1.setFont(font);
		    jb1.setIcon(new ImageIcon("img\\修改信息.png"));
		   // this.add(jb2);
		    jb2.setBounds(0, 80, 270, 80);
		    jb2.setFont(font);
		    jb2.setIcon(new ImageIcon("img\\查询信息.png"));
		    
		       			
		}
		
		
	}

