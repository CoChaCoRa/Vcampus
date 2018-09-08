package vCampus.client.JWC;
/**
 * @author Yanhao Shen
 * 
 * @date 9.3
 *
 */
import javax.swing.*;
import java.awt.*;
import java.awt.Dimension;
import vCampus.client.register.RegisterView;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;

public class StuCLassChange extends JPanel{	
	
	public StuCLassChange() {
		
	super();

	this.setLayout(null);
	this.setSize(1650,1000);         
	
	//JPanel jp=new JPanel();
	JTextArea ta=new JTextArea(400,600);
	ScrollPane sp=new ScrollPane();
	//this.add(jp);
	this.add(sp);
	sp.add(ta);
	ta.setSize(1650,1000);
	//ta.setBounds(0, 0, 1650, 1080);
	//jp.setLayout(null);
	//jp.setSize(1650,1000);         
   
	//ta.setPreferredSize(new Dimension(1000,1000)); // 使用了这一句后，就可以显示滚动条了。

	JLabel lb1 = new JLabel("一卡通");
	ta.add(lb1);

 
    }
    
}
