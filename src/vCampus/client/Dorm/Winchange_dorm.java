package vCampus.client.Dorm;

import java.awt.CardLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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
	
	JButton jb1=new JButton("查询信息");
	JButton jb2=new JButton("扣除费用");
	JButton jb3=new JButton("登记分数");
	
	public Winchange_dorm(int identify,Student stu){
		super();
//		int identify=3;
	    CardLayout card=new CardLayout();
		JPanel cardpanel=new JPanel();
		
		StuCheck w1=new StuCheck(stu);
		
		
		Font font=new Font("苹方 常规",Font.CENTER_BASELINE,28);
		this.setLayout(null);
		
		
		//identify:1 学生 查询
		//identify:2 教师 
		//identify:3 管理员 费用扣除/登记分数
		
		
		//this.add(jb1);
	    jb1.setBounds(0, 0, 270, 80);
	    jb1.setFont(font);
	    jb1.setIcon(new ImageIcon("img\\查询信息点击.png"));	   	    	    
	    jb1.addMouseListener(new WinchangeButtonPerformed());
	    
	    jb1.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	      
	        	card.show(cardpanel,"w1");
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
		
		
		//identify:1 学生 查询
		//identify:2 教师 
		//identify:3 管理员 费用扣除/登记分数
		
	       	
	    //this.add(jb2);
	    jb2.setBounds(0, 0, 270, 80);
	    jb2.setFont(font);
	    jb2.setIcon(new ImageIcon("img\\扣除费用点击.png"));
	    jb2.addMouseListener(new WinchangeButtonPerformed());

	    //this.add(jb3);
	    jb3.setBounds(0, 80, 270, 80);
	    jb3.setFont(font);
	    jb3.setIcon(new ImageIcon("img\\登记分数.png"));
	    jb3.addMouseListener(new WinchangeButtonPerformed());
	    	    
	
	    
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

	public void refresh() {
		jb1.setIcon(new ImageIcon("img\\查询信息.png"));
		jb2.setIcon(new ImageIcon("img\\扣除费用.png"));
		jb3.setIcon(new ImageIcon("img\\登记分数.png"));
	}

	public class WinchangeButtonPerformed implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource()==jb1) {
				refresh();
				jb1.setIcon(new ImageIcon("img\\查询信息点击.png"));
			}
			if(e.getSource()==jb2) {
				refresh();
				jb2.setIcon(new ImageIcon("img\\扣除费用点击.png"));
			}
			if(e.getSource()==jb3) {
				refresh();
				jb3.setIcon(new ImageIcon("img\\登记分数点击.png"));
			}
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	} 
	
}
