package vCampus.client.TSG;
/**
 * @author Yanhao Shen
 * 
 * @date 9.3
 *
 */
import javax.swing.*;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

import vCampus.client.register.RegisterView;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.print.Book;
import java.util.ArrayList;
import java.awt.*;
import javax.swing.*; 

public class StuBookChange extends JPanel{

	JTextArea jtf=new JTextArea(20,1);
	
	public StuBookChange() {
		
	super();
	
	JLabel lb1 = new JLabel("查询");
	JTextField tf1 = new JTextField(20);
	
	JButton bt0=new JButton("");
	JButton bt1=new JButton("");
	
	this.setLayout(null);
	this.setSize(1650,1000);         
    
    Font font=new Font("苹方 常规",Font.CENTER_BASELINE,28);//设置字体格式和大小
   
    
    this.add(bt0);
    bt0.setBounds(880,196-90,60,60);
    bt0.setFont(font);
    // 设置按钮的默认图片
    bt0.setIcon(new ImageIcon("img\\查询UI.png"));
    bt0.setBorder(null);
    
    this.add(bt1);
    bt1.setBounds(910-270, 910-80, 120, 60);
    bt1.setFont(font);
    // 设置按钮的默认图片
    bt1.setIcon(new ImageIcon("img\\确认.png"));
    bt1.setBorder(null);

    this.add(lb1); 
    lb1.setBounds(456-270, 196-80, 151, 47);
    lb1.setFont(font);
    this.add(tf1);
   // tf1.setBackground(Color.WHITE);
    tf1.setBounds(710-270, 196-80, 352, 47);
    tf1.setFont(font);
   // tf1.setEditable(false);
    tf1.setBorder(null);

    
    this.add(bt1);
    bt1.setBounds(910-270, 910-80, 120, 60);
    bt1.setFont(font);
    // 设置按钮的默认图片
   
    bt1.setContentAreaFilled(false);
    bt1.setIcon(new ImageIcon("img\\借阅.png"));
    bt1.setBorder(null);
    
    
    
    
    
	/*
	 * 设置JTable的列名
	 */
	String[] columnNames =
	{ "书号", "书名", "出版社","书架位置","作者","库存总量","已出借" };

	/*
	 * 初始化JTable里面各项的值，设置两个一模一样的实体"赵匡义"学生。
	 */
	
	
	
	int book_num=5;//此处修改已经借阅书籍数
	
	
	Object[][] obj = new Object[book_num][7];
	for (int i = 0; i < book_num; i++)
	{
		for (int j = 0; j < 7; j++)
		{
			switch (j)
			{
			case 0:
				obj[i][j] = "1";
				break;
			case 1:
				obj[i][j] = "QAQ";
				break;
			case 2:
				obj[i][j] = "";
				break;
			case 3:
				obj[i][j] = "3A21";
				break;
			case 4:
				obj[i][j] = "吴建";
				break;
			case 5:
				obj[i][j] = "3";
				break;
			case 6:
				obj[i][j] = "2";
				break;	
			}
		}
		
		if (i % 2 == 0)
               setForeground(Color.pink);
        else if (i % 2 == 1)
        	  setForeground(Color.WHITE);;
		
	}
	
	
	/*
	 * JTable的其中一种构造方法
	 */
	JTable table = new JTable(obj, columnNames) {
	public boolean isCellEditable(int row, int column)
    {
               return false;}//表格不允许被编辑
    };
    table.setRowHeight(30);// 设置表格行宽
    
    JTableHeader head = table.getTableHeader(); // 创建表格标题对象
    head.setPreferredSize(new Dimension(head.getWidth(), 35));// 设置表头大小
    head.setFont(font);// 设置表格字体
   
	TableColumn column = null;
	int colunms = table.getColumnCount();
	for(int i = 0; i < colunms; i++)
	{
		column = table.getColumnModel().getColumn(i);
		/*将每一列的默认宽度设置为100*/
		column.setPreferredWidth(300);
	}
	/*
	 * 设置JTable自动调整列表的状态，此处设置为关闭
	 */
//	table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	table.setBounds(400, 365, 600, 800);
	table.setFont(font);
	
	/*用JScrollPane装载JTable，这样超出范围的列就可以通过滚动条来查看*/
	JScrollPane scroll = new JScrollPane(table);
	scroll.setLocation(186, 223);
	scroll.setSize(1058, 528);
	table.setSize(600, 800);
	
	add(scroll);
	
	

    bt1.addMouseListener(new MouseListener() {
		@Override
		public void mouseEntered(MouseEvent e) {
			bt1.setIcon(new ImageIcon("img\\借阅点击.png"));
		}

		@Override
		public void mouseExited(MouseEvent e) {
			bt1.setIcon(new ImageIcon("img\\借阅.png"));
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			 int index = table.getSelectedRow();
			
			System.out.println(table.getValueAt(index,1));
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
	
    
	
   
    
    }
}
