package vCampus.client.JWC;
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
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;

public class AdmScoreCheck extends JPanel{

	JLabel lb0 = new JLabel("查询一卡通号");
	JTextField tf0 = new JTextField(20);
	JButton bt0=new JButton("");
	
	int num_class;

	
	public AdmScoreCheck() {
		
	super();
	
	num_class=9;
		
	JFrame frame=new JFrame("");
	
	this.setLayout(null);
	this.setSize(1650,1000);         
    
    Font font=new Font("苹方 常规",Font.CENTER_BASELINE,28);//设置字体格式和大小
   
   
    
    this.add(bt0);
    bt0.setBounds(880,196-90,60,60);
    bt0.setFont(font);
    // 设置按钮的默认图片
    bt0.setIcon(new ImageIcon("img\\查询UI.png"));
    bt0.setBorder(null);
    
    this.add(lb0);
    lb0.setBounds(456-270, 196-80, 101, 47);
    lb0.setFont(font);
    this.add(tf0);
    tf0.setBackground(Color.WHITE);
    tf0.setBounds(660-270, 196-80, 402, 47);
    tf0.setFont(font);
  //  tf0.setEditable(false);
    tf0.setBorder(null);
    
    
    
    
  	for(int i=0;i<num_class;i++)
      {
  		
  		JLabel lb1 = new JLabel("XXX");	//CC：课程名
  		JTextField tf1 = new JTextField(20);
  		
  		lb1.setFont(font); 
  		lb1.setBounds(456-270, 196-80+111*(i+1), 101, 47);
  	    lb1.setFont(font);
  	    this.add(lb1);
  	    tf1.setBackground(Color.WHITE);
  	    tf1.setBounds(660-270, 196-80+111*(i+1), 352, 47);
  		this.add(tf1);
  		
  		if(i>4)
  		{
  	  	lb1.setBounds(1156-270, 196-80+111*(i-4), 101, 47);
  	  	tf1.setBounds(1360-270, 196-80+111*(i-4), 352, 47);
  	  	this.add(tf1);
  	  		
  		}
  		
      }
  	
  	
	}
	
	
	
}
