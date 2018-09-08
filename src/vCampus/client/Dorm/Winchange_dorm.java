package vCampus.client.Dorm;

import java.awt.CardLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import vCampus.vo.Admin;
import vCampus.vo.Student;
import vCampus.vo.Teacher;


/**
 * @author Yanhao Shen,CC
 * 
 * @v1.1 date 9/8
 * 	add front-end monitor
 *
 */
public class Winchange_dorm extends JPanel {
	
	public Winchange_dorm(int identify,Student stu){
		super();
//		int identify=3;
	    CardLayout card=new CardLayout();
		JPanel cardpanel=new JPanel();
		
		StuCheck w1=new StuCheck(stu);
		AdmFee w2=new AdmFee();
		AdmScore w3=new AdmScore();
		
		
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
		
		//identify:1 学生 查询
		//identify:2 教师 
		//identify:3 管理员 费用扣除/登记分数
		
		
		//this.add(jb1);
	    jb1.setBounds(0, 0, 270, 80);
	    jb1.setFont(font);
	    jb1.setIcon(new ImageIcon("img\\查询信息.png"));
	       	
	    //this.add(jb2);
	    jb2.setBounds(0, 0, 270, 80);
	    jb2.setFont(font);
	    jb2.setIcon(new ImageIcon("img\\扣除费用.png"));

	    //this.add(jb3);
	    jb3.setBounds(0, 80, 270, 80);
	    jb3.setFont(font);
	    jb3.setIcon(new ImageIcon("img\\登记分数.png"));

	    	    
	
	    
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
	  
		//Winchange2 w2=new Winchange2();
		cardpanel.setLayout(card);
		cardpanel.setBounds(270, 0, 1920-270, 1000);

		if(identify==1||identify==2)
		{
			cardpanel.add("w1",w1);
		
			this.add(jb1);
		
			
		}
		
		if(identify==3)
		{
			cardpanel.add("w2",w2);
			cardpanel.add("w3",w3);
			this.add(jb2);
			this.add(jb3);
		}
	
		
		
		this.add(cardpanel);
		
	}
	

	public Winchange_dorm(int identify,Admin adm) {
		super();
//		int identify=3;
	    CardLayout card=new CardLayout();
		JPanel cardpanel=new JPanel();
		
		AdmFee w2=new AdmFee();
		AdmScore w3=new AdmScore();
		
		
		Font font=new Font("苹方 常规",Font.CENTER_BASELINE,28);
		this.setLayout(null);
		
		JButton jb2=new JButton();
		JButton jb3=new JButton();
		
		
		//identify:1 学生 查询
		//identify:2 教师 
		//identify:3 管理员 费用扣除/登记分数
		
		
	       	
	    //this.add(jb2);
	    jb2.setBounds(0, 0, 270, 80);
	    jb2.setFont(font);
	    jb2.setIcon(new ImageIcon("img\\扣除费用.png"));

	    //this.add(jb3);
	    jb3.setBounds(0, 80, 270, 80);
	    jb3.setFont(font);
	    jb3.setIcon(new ImageIcon("img\\登记分数.png"));

	    	    
	
	    
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
	  
		//Winchange2 w2=new Winchange2();
		cardpanel.setLayout(card);
		cardpanel.setBounds(270, 0, 1920-270, 1000);


		
		if(identify==3)
		{
			cardpanel.add("w2",w2);
			cardpanel.add("w3",w3);
			this.add(jb2);
			this.add(jb3);
		}
	
		
		
		this.add(cardpanel);
	
	}

}
