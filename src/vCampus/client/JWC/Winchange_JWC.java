package vCampus.client.JWC;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.*;

import org.omg.CORBA.TCKind;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;

import vCampus.client.JWC.*;
import vCampus.client.biz.AcademicAffairsService;
import vCampus.client.biz.AcademicAffairsServiceImpl;
import vCampus.client.biz.AdminService;
import vCampus.client.biz.StudentService;
import vCampus.client.biz.StudentServiceImpl;
import vCampus.client.biz.TeacherService;
import vCampus.vo.Admin;
import vCampus.vo.CourseChoose;
import vCampus.vo.Student;
import vCampus.vo.Teacher;
/**
 * @author Yanhao Shen
 *
 */
public class Winchange_JWC extends JPanel {
	
	private int index;
	JButton jb1=new JButton("学生查看课表");
	JButton jb2=new JButton("学生查询成绩");	
	JButton jb3=new JButton("退选课程");
	
	JButton jb4=new JButton("教师查看课表");	
	JButton jb5=new JButton("录入成绩");
	
	JButton jb6=new JButton("添加课程");
	JButton jb7=new JButton("管理员查询成绩");
	JButton jb8=new JButton("修改课程");
	
	int num = 0;
	
	public Winchange_JWC(int identify,StudentService stu){
		super();
		
		JFrame frame=new JFrame("");
		
		AcademicAffairsService AAS= new AcademicAffairsServiceImpl(1, stu.getCacheStudent().getUserName());
		index=AAS.studentGetAllCourses().size();
		
	    CardLayout card=new CardLayout();
		JPanel cardpanel=new JPanel();
		
		StuClassCheck w1=new StuClassCheck(stu.getCacheStudent().getUserName());
		StuScoreCheck w2=new StuScoreCheck(AAS);
		StuCLassChange w3=new StuCLassChange(stu.getCacheStudent().getUserName());		
		
		
		
		Font font=new Font("苹方 常规",Font.CENTER_BASELINE,28);
		this.setLayout(null);
	    
		
        
    	if(AAS.studentGetAllCourses()==null) {
    		num = AAS.studentGetAllCourses().size();
    	}
    	ArrayList<Thread> tv = new ArrayList<Thread>(num); 	
    	ArrayList<CourseChoose> goal= AAS.studentGetAllCourseGrades();
    	//学生成绩 需要外部调用
    	   
    //	int index;
    	
    	
    	
    	System.out.println(1);
    
    	
		//identify:1 学生 查看课表/查成绩/退选课
		//identify:2 教师 查看课表/录入成绩
		//identify:3 添加课/查成绩/修改课程（学分）
		
		
		//this.add(jb1);
	    jb1.setBounds(0, 0, 270, 80);
	    jb1.setFont(font);
	    jb1.setIcon(new ImageIcon("img\\查看课表点击.png"));
	    jb1.addMouseListener(new ButtonClicked());
	       	
	    //this.add(jb2);
	    jb2.setBounds(0, 80, 270, 80);
	    jb2.setFont(font);
	    jb2.setIcon(new ImageIcon("img\\查询成绩.png"));
	    jb2.addMouseListener(new ButtonClicked());

	    //this.add(jb3);
	    jb3.setBounds(0, 160, 270, 80);
	    jb3.setFont(font);
	    jb3.setIcon(new ImageIcon("img\\退选课程.png"));
	    jb3.addMouseListener(new ButtonClicked());


	   
	    
	    
	    jb1.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	w1.run();
	        	card.show(cardpanel,"w1");
	        }
	    });
	    
	    jb2.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	      
	        	card.show(cardpanel,"w2");
	        	for(int j=0;j<index;j++) {
	        	
	        	int score=(int) goal.get(j).getScore();	
	        	JProgressBar progress=w2.BarVector.get(j);
	        	
	        	//System.out.println(score);
	        	//int score=100;
	        	
	        	Thread t2 = new Thread(){

	        		int r = 255;
	        		int g = 0;
	        		int b = 0;	
	        		
	        	 	public void run() {
	        	 		
	        	    	//System.out.println(j);
	        			for (int i = 0; i <=score; i++) {
	        				try {
	        					Thread.sleep(1200/score);
	        				} catch (InterruptedException e) {
	        					e.printStackTrace();
	        				}
	        				if (g != 255) {
	        					g += 5;
	        				} else {
	        					r -= 5;
	        				}
	        				
	        				Color color = new Color(r, g, b);
	        			
	        				progress.setForeground(color);
	        			//	jtar.progressbar.setDigitalColor(color);
	        					
	        				progress.setValue(i);
	        			
	        			}
	        	    }
	        	};
	        	
	        	tv.add(t2);
	        	System.out.println("add scuuess");
	        	
	        	}

	        	Thread t2 =new Thread() {

					int index2 = 0;
					int r = 255;
	        		int g = 0;
	        		int b = 0;	
	        		
	        		//GPA 为平均分
	        		//double GPA= AAS.studentGetGPA();	
	        		//double GPA=100;
	        		double GPA=92;
					@Override
					public void run() {
						while (index2 <= GPA) {
							try {
								Thread.sleep(25);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							if (g != 255) {
								g += 5;
							} else {
								r -= 5;
							}
							Color color = new Color(r, g, b);
							w2.circleProgressBar2.setForegroundColor(color);
							w2.circleProgressBar2.setDigitalColor(color);
							w2.circleProgressBar2.setProgress(index2++);
						}
						
					};

				};
	        	
				System.out.println("run begin");
	        	
			
				   
				t2.start();
				
				
				tv.get(0).start();
				tv.get(1).start();
				tv.get(2).start();
				tv.get(3).start();	
				tv.get(4).start();
				
					
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

		if(identify==1)
		{
			cardpanel.add("w1",w1);
			cardpanel.add("w2",w2);
			cardpanel.add("w3",w3);
			this.add(jb1);
			this.add(jb2);
			this.add(jb3);
		}
		
		frame.add(this);
		
		frame.setVisible(true);
		frame.setSize(1650, 1000);
		
		
		this.add(cardpanel);
		
		this.setBackground(null);
		this.setOpaque(false);
	}
	
	
	public Winchange_JWC(int identify,TeacherService tc) {
		super();
//		int identify=3;
		
		AcademicAffairsService AAS= new AcademicAffairsServiceImpl(2, tc.getCacheTeacher().getUserName());
		//index=AAS.studentGetAllCourses().size();
		
	    CardLayout card=new CardLayout();
		JPanel cardpanel=new JPanel();
	
		String username = tc.getCacheTeacher().getUserName();
		TeaClassCheck w4=new TeaClassCheck(username);	//cc 需要修改接口
		TeaScoreAdd w5=new TeaScoreAdd(username);
		
		
		
		
		Font font=new Font("苹方 常规",Font.CENTER_BASELINE,28);
		this.setLayout(null);
	    
		
		//identify:1 学生 查看课表/查成绩/退选课
		//identify:2 教师 查看课表/录入成绩
		//identify:3 添加课/查成绩/修改课程（学分）

	    	    
		//this.add(jb4);
	    jb4.setBounds(0, 0, 270, 80);
	    jb4.setFont(font);
	    jb4.setIcon(new ImageIcon("img\\查看课表点击.png"));
	    jb4.addMouseListener(new ButtonClicked());
	    
	    jb5.setBounds(0, 80, 270, 80);
	    jb5.setFont(font);
	    jb5.setIcon(new ImageIcon("img\\录入成绩.png"));
	    jb5.addMouseListener(new ButtonClicked());
	    

	   
	    
	    
	    
	  
	    
	    jb4.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	      
	        	card.show(cardpanel,"w4");
	        }
	    });

	    jb5.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	      
	        	card.show(cardpanel,"w5");
	        }
	    });

	    
		//Winchange2 w2=new Winchange2();
		cardpanel.setLayout(card);
		cardpanel.setBounds(270, 0, 1920-270, 1000);

		
		
		if(identify==2)
		{
			cardpanel.add("w4",w4);
			cardpanel.add("w5",w5);
			this.add(jb4);
			this.add(jb5);
		}
	

		
		this.add(cardpanel);
		
		this.setBackground(null);
		this.setOpaque(false);
		

	}

	
	public Winchange_JWC(int identify,AdminService adm) {
		super();
//		int identify=3;
		
		//AcademicAffairsService AAS= new AcademicAffairsServiceImpl(1, adm.getUserName());
		//index=AAS.studentGetAllCourses().size();
		
	    CardLayout card=new CardLayout();
		JPanel cardpanel=new JPanel();
		
		String username = adm.getCacheAdmin().getAdminID();
		AdmClassAdd w6=new AdmClassAdd(username);
		AdmScoreCheck w7=new AdmScoreCheck(username);
		AdmClassAdd w8=new AdmClassAdd(username);
		
		
		
		
		Font font=new Font("苹方 常规",Font.CENTER_BASELINE,28);
		this.setLayout(null);
	    
		
		//identify:1 学生 查看课表/查成绩/退选课
		//identify:2 教师 查看课表/录入成绩
		//identify:3 添加课/查成绩/修改课程（学分）
		
		
	
	    jb6.setBounds(0, 0, 270, 80);
	    jb6.setFont(font);
	    jb6.setIcon(new ImageIcon("img\\添加课程点击.png"));
	    jb6.addMouseListener(new ButtonClicked());

	    
	    jb7.setBounds(0, 80, 270, 80);
	    jb7.setFont(font);
	    jb7.setIcon(new ImageIcon("img\\查询成绩.png"));
	    jb7.addMouseListener(new ButtonClicked());
	       	
	    jb8.setBounds(0, 160, 270, 80);
	    jb8.setFont(font);
	    jb8.setIcon(new ImageIcon("img\\修改课程.png"));
	    jb8.addMouseListener(new ButtonClicked());

	   
	    
	    
	    jb6.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	      
	        	card.show(cardpanel,"w6");
	        }
	    });
	    
	    
	  
	    jb7.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	      
	        	card.show(cardpanel,"w7");
	        }
	    });
	  
	    
	    jb8.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	      
	        	card.show(cardpanel,"w8");
	        }
	    });

	    
		//Winchange2 w2=new Winchange2();
		cardpanel.setLayout(card);
		cardpanel.setBounds(270, 0, 1920-270, 1000);

	
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

	
	public void refresh() {
		jb1.setIcon(new ImageIcon("img\\查看课表.png"));
		jb2.setIcon(new ImageIcon("img\\查询成绩.png"));
		jb3.setIcon(new ImageIcon("img\\退选课程.png"));
		jb4.setIcon(new ImageIcon("img\\查看课表.png"));
		jb5.setIcon(new ImageIcon("img\\录入成绩.png"));
		jb6.setIcon(new ImageIcon("img\\添加课程.png"));
		jb7.setIcon(new ImageIcon("img\\查询成绩.png"));
		jb8.setIcon(new ImageIcon("img\\修改课程.png"));
	}
	
	public class ButtonClicked implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource()==jb1) {
				refresh();
				jb1.setIcon(new ImageIcon("img\\查看课表点击.png"));
			}
			if(e.getSource()==jb2) {
				refresh();
				jb2.setIcon(new ImageIcon("img\\查询成绩点击.png"));
			}
			if(e.getSource()==jb3) {
				refresh();
				jb3.setIcon(new ImageIcon("img\\退选课程点击.png"));
			}
			if(e.getSource()==jb4) {
				refresh();
				jb4.setIcon(new ImageIcon("img\\查看课表点击.png"));
			}
			if(e.getSource()==jb5) {
				refresh();
				jb5.setIcon(new ImageIcon("img\\录入成绩点击.png"));
			}
			if(e.getSource()==jb6) {
				refresh();
				jb6.setIcon(new ImageIcon("img\\添加课程点击.png"));
			}
			if(e.getSource()==jb7) {
				refresh();
				jb7.setIcon(new ImageIcon("img\\查询成绩点击.png"));
			}
			if(e.getSource()==jb8) {
				refresh();
				jb8.setIcon(new ImageIcon("img\\修改课程点击.png"));
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
