package vCampus.client.JWC;

import java.awt.CardLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
 
import javax.swing.ImageIcon;

/**
 * @author Yanhao Shen
 *
 */
public class Winchange_JWC extends JPanel {
	
	public Winchange_JWC(int identify){
		super();
//		int identify=3;
	

	    CardLayout card=new CardLayout();
		JPanel cardpanel=new JPanel();
		
		StuClassCheck w1=new StuClassCheck();
		StuScoreCheck w2=new StuScoreCheck();
		StuCLassChange w3=new StuCLassChange();
	
		TeaClassCheck w4=new TeaClassCheck();
		TeaScoreAdd w5=new TeaScoreAdd();
		
		AdmClassAdd w6=new AdmClassAdd();
		AdmScoreCheck w7=new AdmScoreCheck();
		AdmClassAdd w8=new AdmClassAdd();
		
		
		
		
		Font font=new Font("苹方 常规",Font.CENTER_BASELINE,28);
		this.setLayout(null);
	    


		JButton jb1=new JButton();
		JButton jb2=new JButton();
		JButton jb3=new JButton();
		JButton jb4=new JButton();
		JButton jb5=new JButton();
		JButton jb6=new JButton();
		JButton jb7=new JButton();
		JButton jb8=new JButton();
		
		//identify:1 学生 查看课表/查成绩/退选课
		//identify:2 教师 查看课表/录入成绩
		//identify:3 添加课/查成绩/修改课程（学分）
		
		
		//this.add(jb1);
	    jb1.setBounds(0, 0, 270, 80);
	    jb1.setFont(font);
	    jb1.setIcon(new ImageIcon("img\\查看课表.png"));
	       	
	    //this.add(jb2);
	    jb2.setBounds(0, 80, 270, 80);
	    jb2.setFont(font);
	    jb2.setIcon(new ImageIcon("img\\查询成绩.png"));

	    //this.add(jb3);
	    jb3.setBounds(0, 160, 270, 80);
	    jb3.setFont(font);
	    jb3.setIcon(new ImageIcon("img\\退选课程.png"));

	    	    
		//this.add(jb4);
	    jb4.setBounds(0, 0, 270, 80);
	    jb4.setFont(font);
	    jb4.setIcon(new ImageIcon("img\\查看课表.png"));
	    
	    jb5.setBounds(0, 80, 270, 80);
	    jb5.setFont(font);
	    jb5.setIcon(new ImageIcon("img\\录入成绩.png"));
	    
	
	    jb6.setBounds(0, 0, 270, 80);
	    jb6.setFont(font);
	    jb6.setIcon(new ImageIcon("img\\添加课程.png"));

	    
	    jb7.setBounds(0, 80, 270, 80);
	    jb7.setFont(font);
	    jb7.setIcon(new ImageIcon("img\\查询成绩.png"));
	       	
	    jb8.setBounds(0, 160, 270, 80);
	    jb8.setFont(font);
	    jb8.setIcon(new ImageIcon("img\\修改课程.png"));

	   
	    
	    
	    jb1.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	      
	        	card.show(cardpanel,"w1");
	        }
	    });
	    
	    jb2.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	      
	        	card.show(cardpanel,"w2");
	        }
	    });
	  
	    jb3.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	      
	        	card.show(cardpanel,"w3");
	        }
	    });
	  
	    
	    jb4.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	      
	        	card.show(cardpanel,"w4");
	        }
	    });

	    
		//Winchange2 w2=new Winchange2();
		cardpanel.setLayout(card);
		cardpanel.setBounds(270, 0, 1920-270, 1000);

		if(identify==1)
		{
			cardpanel.add("w1",w1);
			cardpanel.add("w2",w2);
			cardpanel.add("w3",w3);
			this.add(jb1);
			this.add(jb2);
			this.add(jb3);
		}
		
		if(identify==2)
		{
			cardpanel.add("w3",w3);
			cardpanel.add("w4",w4);
			this.add(jb4);
			this.add(jb5);
		}
	
		if(identify==3)
		{
			cardpanel.add("w6",w6);
			cardpanel.add("w7",w7);
			cardpanel.add("w8",w8);
			this.add(jb6);
			this.add(jb7);
			this.add(jb8);
		}
		
		this.add(cardpanel);
		
		
		this.setBackground(null);
		this.setOpaque(false);
	}
	
	
}
