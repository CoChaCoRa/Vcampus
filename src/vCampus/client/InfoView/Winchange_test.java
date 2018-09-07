package vCampus.client.InfoView;

import java.awt.CardLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import vCampus.client.InfoView.StuMessageChange;

import javax.swing.*;

import vCampus.vo.Admin;
import vCampus.vo.Student;


/**
 * @author Yanhao Shen
 *
 */
public class Winchange_test extends JPanel {
	
	public Winchange_test(int identify,Student ss){
		super();
//		int identify=1;
	    CardLayout card=new CardLayout();
		JPanel cardpanel=new JPanel();
		StuMessageCheck w1=new StuMessageCheck(ss);
		StuMessageChange w2=new StuMessageChange(ss);
		
		Font font=new Font("苹方 常规",Font.CENTER_BASELINE,28);
		this.setLayout(null);
		
		JButton jb1=new JButton();
		JButton jb2=new JButton();
		JButton jb3=new JButton();
		JButton jb4=new JButton();
		
		//this.add(jb1);
	    jb1.setBounds(0, 0, 270, 80);
	    jb1.setFont(font);
	    jb1.setIcon(new ImageIcon("img\\查询信息.png"));
	       	
	    //this.add(jb2);
	    jb2.setBounds(0, 80, 270, 80);
	    jb2.setFont(font);
	    jb2.setIcon(new ImageIcon("img\\修改信息.png"));
	    
	    
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
	  

	    
		//Winchange2 w2=new Winchange2();
		cardpanel.setLayout(card);
		cardpanel.setBounds(270, 0, 1920-270, 1000);

		if(identify==1||identify==2)
		{
			cardpanel.add("w1",w1);
			cardpanel.add("w2",w2);
			this.add(jb1);
			this.add(jb2);
			
		}
	
		this.add(cardpanel);
		
	}

	public Winchange_test(int identify, Admin ad) {
		// TODO Auto-generated constructor stub
		super();
	    CardLayout card=new CardLayout();
		JPanel cardpanel=new JPanel();
		AdmAddCheck w4=new AdmAddCheck(ad);
		AdmMessageChange w3=new AdmMessageChange(ad);
		
		Font font=new Font("苹方 常规",Font.CENTER_BASELINE,28);
		this.setLayout(null);
		

		JButton jb3=new JButton();
		JButton jb4=new JButton();
		

		//this.add(jb3);
	    jb3.setBounds(0, 0, 270, 80);
	    jb3.setFont(font);
	    jb3.setIcon(new ImageIcon("img\\添加信息.png"));
	    
	    jb4.setBounds(0, 80, 270, 80);
	    jb4.setFont(font);
	    jb4.setIcon(new ImageIcon("img\\查询修改.png"));
	    
	    
	  
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

		
		if(identify==3)
		{
			cardpanel.add("w3",w3);
			cardpanel.add("w4",w4);
			this.add(jb3);
			this.add(jb4);

		}
	
		this.add(cardpanel);
	
	}
	
	
}
