package vCampus.client.InfoView;

import java.awt.CardLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
//import vCampus.client.InfoView.StuMessageChange;
import java.awt.event.MouseListener;

import javax.swing.*;

import vCampus.client.biz.AdminService;
import vCampus.client.biz.StudentService;
import vCampus.client.biz.TeacherService;
import vCampus.vo.Admin;
import vCampus.vo.Student;
import vCampus.vo.Teacher;


/**
 * @author Yanhao Shen,CC
 * 
 * @last edited in 9/8
 *
 */
public class Winchange_test extends JPanel {
	
	JButton jb1=new JButton("查询信息");
	JButton jb2=new JButton("修改信息");
	JButton jb3=new JButton("添加信息");
	JButton jb4=new JButton("查询修改");
	
	public Winchange_test(int identify,StudentService ss){
		super();
//		int identify=1;
	    CardLayout card=new CardLayout();
		JPanel cardpanel=new JPanel();
		StuMessageCheck w1=new StuMessageCheck(ss.getCacheStudent());
		StuMessageChange w2=new StuMessageChange(ss);
		
		Font font=new Font("苹方 常规",Font.CENTER_BASELINE,28);
		this.setLayout(null);
		
		//this.add(jb1);
	    jb1.setBounds(0, 0, 270, 80);
	    jb1.setFont(font);
	    jb1.setIcon(new ImageIcon("img\\查询信息点击.png"));
	    jb1.addMouseListener(new WinchangeButtonPerformed());
	       	
	    //this.add(jb2);
	    jb2.setBounds(0, 80, 270, 80);
	    jb2.setFont(font);
	    jb2.setIcon(new ImageIcon("img\\修改信息.png"));
	    jb2.addMouseListener(new WinchangeButtonPerformed());
	    
	    
	    jb1.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	card.show(cardpanel,"w1");
	        	w1.tf9.setText(ss.getCacheStudent().getPhoneNumber());
	        	w1.tf10.setText(ss.getCacheStudent().getEmailAddress());
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


	public Winchange_test(int identify, AdminService adm) {
		// TODO Auto-generated constructor stub
		super();
	    CardLayout card=new CardLayout();
		JPanel cardpanel=new JPanel();
		AdmAddCheck w4=new AdmAddCheck(adm);
		AdmMessageChange w3=new AdmMessageChange(adm);
		
		Font font=new Font("苹方 常规",Font.CENTER_BASELINE,28);
		this.setLayout(null);

		//this.add(jb3);
	    jb3.setBounds(0, 0, 270, 80);
	    jb3.setFont(font);
	    jb3.setIcon(new ImageIcon("img\\添加信息点击.png"));
	    jb3.addMouseListener(new WinchangeButtonPerformed());
	    
	    jb4.setBounds(0, 80, 270, 80);
	    jb4.setFont(font);
	    jb4.setIcon(new ImageIcon("img\\查询修改.png"));
	    jb4.addMouseListener(new WinchangeButtonPerformed());
	    
	    
	  
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

	
	public Winchange_test(int identify, TeacherService tc) {
		super();
//		int identify=1;
	    CardLayout card=new CardLayout();
		JPanel cardpanel=new JPanel();
		StuMessageCheck w1=new StuMessageCheck(tc);
		StuMessageChange w2=new StuMessageChange(tc);
		
		Font font=new Font("苹方 常规",Font.CENTER_BASELINE,28);
		this.setLayout(null);
		
		//this.add(jb1);
	    jb1.setBounds(0, 0, 270, 80);
	    jb1.setFont(font);
	    jb1.setIcon(new ImageIcon("img\\查询信息点击.png"));
	    jb1.addMouseListener(new WinchangeButtonPerformed());
	       	
	    //this.add(jb2);
	    jb2.setBounds(0, 80, 270, 80);
	    jb2.setFont(font);
	    jb2.setIcon(new ImageIcon("img\\修改信息.png"));
	    jb2.addMouseListener(new WinchangeButtonPerformed());
	    
	    
	    jb1.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	      
	        	card.show(cardpanel,"w1");
	        	w1.tf9.setText(tc.getCacheTeacher().getPhoneNumber());
	        	w1.tf10.setText(tc.getCacheTeacher().getEmailAddress());
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
				jb2.setIcon(new ImageIcon("img\\修改信息点击.png"));
			}
			if(e.getSource()==jb3) {
				refresh();
				jb3.setIcon(new ImageIcon("img\\添加信息点击.png"));
			}
			if(e.getSource()==jb4) {
				refresh();
				jb4.setIcon(new ImageIcon("img\\查询修改点击.png"));
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

	public void refresh() {
		jb1.setIcon(new ImageIcon("img\\查询信息.png"));
		jb2.setIcon(new ImageIcon("img\\修改信息.png"));
		jb3.setIcon(new ImageIcon("img\\添加信息.png"));
		jb4.setIcon(new ImageIcon("img\\查询修改.png"));
	}
}
