package vCampus.client.TSG;
/**
 * @author SYH
 * 
 * @date 9.3
 *
 */
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

import vCampus.client.biz.AdminService;
import vCampus.client.biz.LibraryService;
import vCampus.client.biz.LibraryServiceImpl;
import vCampus.client.register.RegisterView;
import vCampus.vo.Admin;
import vCampus.vo.BookInformation;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class AdmBookChange extends JPanel{

	JLabel lb0 = new JLabel("书号");
	JTextField tf0 = new JTextField(20);
	JLabel lb1 = new JLabel("书名");
	JTextField tf1 = new JTextField(20);
	JLabel lb2 = new JLabel("出版社");
	JTextField tf2 = new JTextField(20);
	JLabel lb3 = new JLabel("书架位置");
	JTextField tf3 = new JTextField(20);
	JLabel lb4 = new JLabel("作者");
	JTextField tf4 = new JTextField(20);
	JLabel lb5 = new JLabel("库存总量");
	JTextField tf5 = new JTextField(20);
	DefaultTableModel dtm = null;
	
	
	
	public AdmBookChange(AdminService admin) {
		
	super();

	JButton bt0=new JButton("");
	JButton bt1=new JButton("");
	JButton bt2=new JButton("");
	
	this.setLayout(null);
	this.setSize(1650,1000);         
    
    Font font=new Font("苹方 常规",Font.CENTER_BASELINE,28);//设置字体格式和大小
   
    LibraryService LS = new LibraryServiceImpl(3,admin.getCacheAdmin().getAdminID());

    
    //syh
    
    
  	/*
  	 * 设置JTable的列名
  	 */
  	String[] columnNames =
  	{ "书号", "书名", "出版社","书架位置","作者","库存总量","已出借" };

  	/*
  	 * 初始化JTable里面各项的值
  	 */
  	
  	ArrayList<BookInformation> allbooks = new ArrayList<BookInformation>();
	allbooks = LS.queryAllBook();
  	int book_num=5;
  	if(allbooks!=null) book_num = allbooks.size();
  	
  	Object[][] obj = new Object[book_num][7];
  	for (int i = 0; i < book_num; i++){
  		for (int j = 0; j < 7; j++){
  			switch (j){
  			case 0:
  				obj[i][j] = allbooks.get(i).getBookID();
  				break;
  			case 1:
  				obj[i][j] = allbooks.get(i).getBookName();
  				break;
  			case 2:
  				obj[i][j] = allbooks.get(i).getBookPress();
  				break;
  			case 3:
  				obj[i][j] = allbooks.get(i).getBookAddress();
  				break;
  			case 4:
  				obj[i][j] = allbooks.get(i).getBookWriter();
  				break;
  			case 5:
  				obj[i][j] = String.valueOf(allbooks.get(i).getTotalAmount());
  				break;
  			case 6:
  				obj[i][j] = String.valueOf(allbooks.get(i).getBorrowedAmount());
  				break;	
  			}
  		}
  	}
  	

  	/*
  	 * JTable的其中一种构造方法
  	 */
  	
  	

  	
  	 dtm=new DefaultTableModel(obj,columnNames){
 		public boolean isCellEditable(int row, int column)
 	    {
 	               return false;}//表格不允许被编辑
 	    };
    //用模型建立表;
 	    

 	JTable table = new JTable(dtm); 
      table.setRowHeight(30);// 设置表格行宽
      
      JTableHeader head = table.getTableHeader(); // 创建表格标题对象
      head.setPreferredSize(new Dimension(head.getWidth(), 35));// 设置表头大小
      head.setFont(font);// 设置表格字体
     
  	TableColumn column = null;
  	int colunms = table.getColumnCount();
  	for(int i = 0; i < colunms; i++){
  		column = table.getColumnModel().getColumn(i);
  		/*将每一列的默认宽度设置为100*/
  		column.setPreferredWidth(300);	
  	}
  	/*
  	 * 设置JTable自动调整列表的状态，此处设置为关闭
  	 */
//  	table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
  	table.setBounds(400, 365, 600, 800);
  	table.setFont(font);	
  	/*用JScrollPane装载JTable，这样超出范围的列就可以通过滚动条来查看*/
  	JScrollPane scroll = new JScrollPane(table);
  	scroll.setLocation(181, 215);
  	scroll.setSize(1058, 290);
  	table.setSize(600, 800);	
  	add(scroll);
    
    
    
    
    
    
    
    
    
    
    this.add(bt0);
    bt0.setBounds(880,196-90,60,60);
    bt0.setFont(font);
    // 设置按钮的默认图片
    bt0.setIcon(new ImageIcon("img\\查询UI.png"));
    bt0.setBorder(null);
    bt0.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			// to search for info of one book
			BookInformation book = LS.queryBookInformation(tf0.getText());
			if(book != null) {
				tf1.setText(book.getBookName());
				tf2.setText(book.getBookPress());
				tf3.setText(book.getBookAddress());
				tf4.setText(book.getBookWriter());
				tf5.setText(String.valueOf(book.getTotalAmount()));
			}
		}
    	
    });
    
    this.add(bt1);
    bt1.setBounds(910-270, 910-80, 160, 80);
    bt1.setFont(font);
    // 设置按钮的默认图片
    bt1.setIcon(new ImageIcon("img\\确认.png"));
    bt1.setBorder(null);
  
    bt1.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		// to confirm changes to info of one book
    		BookInformation BooktoUpdate = new BookInformation();
			BooktoUpdate.setBookID(tf0.getText());
			BooktoUpdate.setBookName(tf1.getText());
			BooktoUpdate.setBookPress(tf2.getText());
			BooktoUpdate.setBookAddress(tf3.getText());
			BooktoUpdate.setBookWriter(tf4.getText());
			BooktoUpdate.setTotalAmount(Integer.parseInt(tf5.getText()));
			BooktoUpdate.setBorrowedAmount(LS.queryBookInformation(tf0.getText()).getBorrowedAmount());
			if(LS.updateBookByAdmin(BooktoUpdate)==true) {
				JOptionPane.showMessageDialog(null, "修改成功");
			}
			else {
				if(!LS.getExceptionCode().equals("")) {
					JOptionPane.showMessageDialog(null, LS.getExceptionCode());
				}
			}
			
			ArrayList<BookInformation> allbooks = new ArrayList<BookInformation>();
			allbooks = LS.queryAllBook();
			int books_num = 0;
			if(allbooks!=null) books_num = allbooks.size();
			
		  	Object[][] obj = new Object[books_num][7];
		  	for (int i = 0; i < books_num; i++){
		  		for (int j = 0; j < 7; j++){
		  			switch (j){
		  			case 0:
		  				obj[i][j] = allbooks.get(i).getBookID();
		  				break;
		  			case 1:
		  				obj[i][j] = allbooks.get(i).getBookName();
		  				break;
		  			case 2:
		  				obj[i][j] = allbooks.get(i).getBookPress();
		  				break;
		  			case 3:
		  				obj[i][j] = allbooks.get(i).getBookAddress();
		  				break;
		  			case 4:
		  				obj[i][j] = allbooks.get(i).getBookWriter();
		  				break;
		  			case 5:
		  				obj[i][j] = String.valueOf(allbooks.get(i).getTotalAmount());
		  				break;
		  			case 6:
		  				obj[i][j] = String.valueOf(allbooks.get(i).getBorrowedAmount());
		  				break;	
		  			}
		  		}
		  	}
		  	
			
			
			dtm.setDataVector(obj,columnNames);//设置新内容
			dtm.fireTableStructureChanged();//更新显示


    	}
    });

    bt1.setAutoscrolls(false);
    bt1.addMouseListener(new MouseListener() {
		@Override
		public void mouseEntered(MouseEvent e) {
			bt1.setIcon(new ImageIcon("img\\确认点击.png"));
		}

		@Override
		public void mouseExited(MouseEvent e) {
			bt1.setIcon(new ImageIcon("img\\确认.png"));
		}

		public void mouseClicked(MouseEvent e) {
		
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub				
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub				
		}
    });
	

    this.add(bt2);
    bt2.setBounds(1001, 910-80, 160, 80);
    bt2.setFont(font);
    // 设置按钮的默认图片
    bt2.setIcon(new ImageIcon("img\\删除.png"));
    bt2.setBorder(null);
    bt2.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		// to delete info of one book
			if(LS.deleteBookByAdmin(tf0.getText())==true) {
				JOptionPane.showMessageDialog(null, "删除成功");
			}
			else {
				if(!LS.getExceptionCode().equals("")) {
					JOptionPane.showMessageDialog(null, LS.getExceptionCode());
				}
			}
			
			
			
			dtm.setDataVector(obj,columnNames);//设置新内容
			dtm.fireTableStructureChanged();//更新显示		
    	}
    });
    

    bt2.setAutoscrolls(false);
    bt2.addMouseListener(new MouseListener() {
		@Override
		public void mouseEntered(MouseEvent e) {
			bt2.setIcon(new ImageIcon("img\\删除点击.png"));
		}

		@Override
		public void mouseExited(MouseEvent e) {
			bt2.setIcon(new ImageIcon("img\\删除.png"));
		}

		public void mouseClicked(MouseEvent e) {
		
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub				
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub				
		}
    });
    
    bt1.setContentAreaFilled(false);
    bt2.setContentAreaFilled(false);
    
    this.add(lb0);
    lb0.setBounds(456-270, 196-80, 101, 47);
    lb0.setFont(font);
    this.add(tf0);
    tf0.setBackground(Color.WHITE);
    tf0.setBounds(660-270, 196-80, 402, 47);
    tf0.setFont(font);
  //  tf0.setEditable(false);
    tf0.setBorder(null);
    
    this.add(lb1);
    lb1.setBounds(185, 549, 101, 47);
    lb1.setFont(font);
    this.add(tf1);
    tf1.setBackground(Color.WHITE);
    tf1.setBounds(389, 549, 402, 47);
    tf1.setFont(font);
//    tf1.setEditable(false);
    tf1.setBorder(null);

    this.add(lb2);
    lb2.setBounds(885, 549, 101, 47);
    lb2.setFont(font);
    this.add(tf2);
    tf2.setBackground(Color.WHITE);
    tf2.setBounds(1089, 549, 402, 47);
    tf2.setFont(font);
 //   tf2.setEditable(false);
    tf2.setBorder(null);
    
    this.add(lb3);
    lb3.setBounds(185, 660, 201, 47);
    lb3.setFont(font);
    this.add(tf3);
    tf3.setBackground(Color.WHITE);
    tf3.setBounds(389, 660, 402, 47);
    tf3.setFont(font);
//    tf3.setEditable(false);
    tf3.setBorder(null);
    
    this.add(lb4);
    lb4.setBounds(885, 660, 250, 47);
    lb4.setFont(font);
    this.add(tf4);
    tf4.setBackground(Color.WHITE);
    tf4.setBounds(1089, 660, 402, 47);
    tf4.setFont(font);
//    tf4.setEditable(false);
    tf4.setBorder(null);
    
    this.add(lb5);
    lb5.setBounds(185, 771, 201, 47);
    lb5.setFont(font);
    this.add(tf5);
    tf5.setBackground(Color.WHITE);
    tf5.setBounds(389, 771, 402, 47);
    tf5.setFont(font);
//    tf5.setEditable(false);
    tf5.setBorder(null);
    
	}
}
