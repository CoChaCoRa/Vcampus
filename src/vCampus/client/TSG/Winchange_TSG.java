package vCampus.client.TSG;

import java.awt.CardLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.*;

import vCampus.client.biz.AdminService;
import vCampus.client.biz.LibraryService;
import vCampus.client.biz.LibraryServiceImpl;
import vCampus.client.biz.StudentService;
import vCampus.client.biz.TeacherService;
import vCampus.vo.BookBorrow;
import vCampus.vo.BookInformation;


/**
 * @author Yanhao Shen
 *
 */
public class Winchange_TSG extends JPanel {
	
	JButton jb1=new JButton();
	JButton jb2=new JButton();
	JButton jb3=new JButton();
	JButton jb4=new JButton();
	
	public Winchange_TSG(int identify,StudentService ss){
		super();
//		int identify=3;
	    CardLayout card=new CardLayout();
		JPanel cardpanel=new JPanel();
		StuBookChange w1=new StuBookChange(ss);
		StuBookCheck w2=new StuBookCheck(ss);
		
		
		Font font=new Font("苹方 常规",Font.CENTER_BASELINE,28);
		this.setLayout(null);

		
		//identify:1 学生 查询图书(借)/还
		//identify:2 教师 
		//identify:3 管理员 添加/删除修改
		
		
		//this.add(jb1);
	    jb1.setBounds(0, 0, 270, 80);
	    jb1.setFont(font);
	    jb1.setIcon(new ImageIcon("img\\查询图书点击.png"));
	    jb1.addMouseListener(new ButtonClicked());
	       	
	    //this.add(jb2);
	    jb2.setBounds(0, 80, 270, 80);
	    jb2.setFont(font);
	    jb2.setIcon(new ImageIcon("img\\归还图书.png"));
	    jb2.addMouseListener(new ButtonClicked());
	    
	
	    
	    jb1.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	      
	        	card.show(cardpanel,"w1");
	        	 jb1.setIcon(new ImageIcon("img\\查询图书点击.png"));
	        	 jb2.setIcon(new ImageIcon("img\\归还图书.png"));
	        }
	    });
	    
	    jb2.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	      
	        	card.show(cardpanel,"w2");
	        	 jb1.setIcon(new ImageIcon("img\\查询图书.png"));
	        	 jb2.setIcon(new ImageIcon("img\\归还图书点击.png"));
	        	 
	        	//syh
	        	 
	        		String[] columnNames =
	        			{ "书号","书名", "作者", "出版社" };

	        			/*
	        			 * 初始化JTable里面各项的值
	        			 */
	        			String username= ss.getCacheStudent().getUserName();
	        			LibraryService LS = new LibraryServiceImpl(1,ss.getCacheStudent().getUserName());
	        			int num_borrow = 3;
	        			Object[][] obj = new Object[num_borrow][4];
	        			if(LS.queryBookBorrow(username)!= null) {
	        				//num_borrow = LS.queryBookBorrow(username).size();
	        				ArrayList<BookBorrow> borrowbooks = LS.queryBookBorrow(username);
	        				num_borrow = LS.queryBookBorrow(username).size();
	        				obj = new Object[num_borrow][4];
	        				ArrayList<BookInformation> bbsinfo = new ArrayList<BookInformation>();
	        				if(borrowbooks!=null) {
	        					for(int i=0;i<num_borrow;i++) {
	        						bbsinfo.add(LS.queryBookInformation(borrowbooks.get(i).getBookID()));
	        					}
	        				}
	        				for (int i = 0; i < num_borrow; i++)
	        				{
	        					for (int j = 0; j < 4; j++)
	        					{
	        						String borrowedbookID = borrowbooks.get(i).getBookID();
	        						switch (j)
	        						{
	        						case 0:
	        							obj[i][j] = borrowedbookID;
	        						case 1:
	        							obj[i][j] = bbsinfo.get(i).getBookName();
	        							break;
	        						case 2:
	        							obj[i][j] = bbsinfo.get(i).getBookWriter();
	        							break;
	        						case 3:
	        							obj[i][j] = bbsinfo.get(i).getBookPress();
	        							break;
	        				
	        						}
	        					}
	        				}
	        				
	        				
	        				System.out.println(1);
	        			}
	        			else {
	        				for (int i = 0; i < num_borrow; i++)
	        				{
	        					for (int j = 0; j < 4; j++)
	        					{
	        						//String borrowedbookID = LS.queryBookBorrow(username).get(i).getBookID();
	        						switch (j)
	        						{
	        						case 0:
	        							obj[i][j] = "";
	        							break;
	        						case 1:
	        							obj[i][j] = "";
	        							break;
	        						case 2:
	        							obj[i][j] = "";
	        							break;
	        				
	        						}
	        					}
	        				}
	        				
	        				System.out.println(2);
	        			}

	        			w2.dtm.setDataVector(obj,columnNames);//设置新内容

	        			w2.dtm.fireTableStructureChanged();//更新显示
 
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

	
	public Winchange_TSG(int identify, AdminService admin) {
		super();
//		int identify=3;
	    CardLayout card=new CardLayout();
		JPanel cardpanel=new JPanel();
		AdmBookAdd w3=new AdmBookAdd(admin);
		AdmBookChange w4=new AdmBookChange(admin);
		
		
		Font font=new Font("苹方 常规",Font.CENTER_BASELINE,28);
		this.setLayout(null);
		
		JButton jb3=new JButton();
		JButton jb4=new JButton();
		
		//identify:1 学生 查询图书(借)/还
		//identify:2 教师 
		//identify:3 管理员 添加/删除修改
		
		

	    //this.add(jb3);
	    jb3.setBounds(0, 0, 270, 80);
	    jb3.setFont(font);
	    jb3.setIcon(new ImageIcon("img\\添加图书点击.png"));
	    jb3.addMouseListener(new ButtonClicked());

	    jb4.setBounds(0, 80, 270, 80);
	    jb4.setFont(font);
	    jb4.setIcon(new ImageIcon("img\\查询修改.png"));
	    jb4.addMouseListener(new ButtonClicked());

	  
	    jb3.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	      
	        	card.show(cardpanel,"w3");
	        	 jb3.setIcon(new ImageIcon("img\\添加图书点击.png"));
	        	 jb4.setIcon(new ImageIcon("img\\查询修改.png"));
	        }
	    });
	  
	    
	    jb4.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	      
	        	card.show(cardpanel,"w4");
	        	 jb3.setIcon(new ImageIcon("img\\添加图书.png"));
	        	 jb4.setIcon(new ImageIcon("img\\查询修改点击.png"));
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

	
	
	public Winchange_TSG(int identify, TeacherService tc) {
		super();
//		int identify=3;
	    CardLayout card=new CardLayout();
		JPanel cardpanel=new JPanel();
		StuBookChange w1=new StuBookChange(tc);
		StuBookCheck w2=new StuBookCheck(tc);
		
		
		Font font=new Font("苹方 常规",Font.CENTER_BASELINE,28);
		this.setLayout(null);

		
		//identify:1 学生 查询图书(借)/还
		//identify:2 教师 
		//identify:3 管理员 添加/删除修改
		
		
		//this.add(jb1);
	    jb1.setBounds(0, 0, 270, 80);
	    jb1.setFont(font);
	    jb1.setIcon(new ImageIcon("img\\查询图书点击.png"));
	    jb1.addMouseListener(new ButtonClicked());
	       	
	    //this.add(jb2);
	    jb2.setBounds(0, 80, 270, 80);
	    jb2.setFont(font);
	    jb2.setIcon(new ImageIcon("img\\归还图书.png"));
	    jb2.addMouseListener(new ButtonClicked());
	    
	
	    
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
	        	
	        	 
        		String[] columnNames =
        			{ "书号","书名", "作者", "出版社" };

        			/*
        			 * 初始化JTable里面各项的值
        			 */
        			String username= tc.getCacheTeacher().getUserName();
        			LibraryService LS = new LibraryServiceImpl(1,tc.getCacheTeacher().getUserName());
        			int num_borrow = 3;
        			Object[][] obj = new Object[num_borrow][4];
        			if(LS.queryBookBorrow(username)!= null) {
        				//num_borrow = LS.queryBookBorrow(username).size();
        				ArrayList<BookBorrow> borrowbooks = LS.queryBookBorrow(username);
        				num_borrow = LS.queryBookBorrow(username).size();
        				obj = new Object[num_borrow][4];
        				ArrayList<BookInformation> bbsinfo = new ArrayList<BookInformation>();
        				if(borrowbooks!=null) {
        					for(int i=0;i<num_borrow;i++) {
        						bbsinfo.add(LS.queryBookInformation(borrowbooks.get(i).getBookID()));
        					}
        				}
        				for (int i = 0; i < num_borrow; i++)
        				{
        					for (int j = 0; j < 4; j++)
        					{
        						String borrowedbookID = borrowbooks.get(i).getBookID();
        						switch (j)
        						{
        						case 0:
        							obj[i][j] = borrowedbookID;
        						case 1:
        							obj[i][j] = bbsinfo.get(i).getBookName();
        							break;
        						case 2:
        							obj[i][j] = bbsinfo.get(i).getBookWriter();
        							break;
        						case 3:
        							obj[i][j] = bbsinfo.get(i).getBookPress();
        							break;
        				
        						}
        					}
        				}
        				
        				
        				System.out.println(1);
        			}
        			else {
        				for (int i = 0; i < num_borrow; i++)
        				{
        					for (int j = 0; j < 4; j++)
        					{
        						//String borrowedbookID = LS.queryBookBorrow(username).get(i).getBookID();
        						switch (j)
        						{
        						case 0:
        							obj[i][j] = "";
        							break;
        						case 1:
        							obj[i][j] = "";
        							break;
        						case 2:
        							obj[i][j] = "";
        							break;
        				
        						}
        					}
        				}
        				
        				System.out.println(2);
        			}

        			w2.dtm.setDataVector(obj,columnNames);//设置新内容

        			w2.dtm.fireTableStructureChanged();//更新显示

	        	
	        	
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
	
	
	public void refresh() {
		jb1.setIcon(new ImageIcon("img\\查询图书.png"));
		jb2.setIcon(new ImageIcon("img\\归还图书.png"));
		jb3.setIcon(new ImageIcon("img\\添加图书.png"));
		jb4.setIcon(new ImageIcon("img\\查询修改.png"));
	}
	
	public class ButtonClicked implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource()==jb1) {
				refresh();
				jb1.setIcon(new ImageIcon("img\\查询图书点击.png"));
			}
			if(e.getSource()==jb2) {
				refresh();
				jb2.setIcon(new ImageIcon("img\\归还图书点击.png"));
			}
			if(e.getSource()==jb3) {
				refresh();
				jb3.setIcon(new ImageIcon("img\\添加图书点击.png"));
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
	
}
