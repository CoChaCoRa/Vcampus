package vCampus.client.Shop;
/**
 * @author Yanhao Shen
 * 
 * @date 9.3
 *
 */
import javax.swing.*;

import vCampus.client.register.RegisterView;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;

public class StuAccountCheck extends JPanel{


	JLabel lb1 = new JLabel("一卡通号");
	JTextField tf1 = new JTextField("");
	
	
	JLabel lb3 = new JLabel("余额");
	JTextField tf2 = new JTextField("");
	

	
	public StuAccountCheck() {
	super();
	
//	this.setBackground(Color.BLUE);
	
	
	this.setLayout(null);
	this.setSize(1650,1000);         
    
    Font font=new Font("苹方 常规",Font.CENTER_BASELINE,28);//设置字体格式和大小

    

    
    this.add(lb1);
    lb1.setBounds(456-270, 196-80, 151, 47);
    lb1.setFont(font);
    this.add(tf1);
    tf1.setBackground(Color.WHITE);
    tf1.setBounds(660-270, 196-80, 352, 47);
    tf1.setFont(font);
    tf1.setEditable(false);
    tf1.setBorder(null);

    
    this.add(lb3);
    lb3.setBounds(456-270, 307-80, 101, 47);
    lb3.setFont(font);
    this.add(tf2);
    tf2.setBackground(Color.WHITE);
    tf2.setBounds(660-270, 307-80, 352, 47);
    tf2.setFont(font);
    tf2.setEditable(false);
    tf2.setBorder(null);
    
    }
    	


    

}
