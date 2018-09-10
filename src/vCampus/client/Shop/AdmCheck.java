package vCampus.client.Shop;
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

import vCampus.client.register.RegisterView;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;

public class AdmCheck extends JPanel{


	JLabel lb1 = new JLabel("余额");
	JTextField tf1 = new JTextField("");
	
	
	DefaultTableModel dtm = null;

	
	public AdmCheck() {
		
	super();


	
	this.setLayout(null);
	this.setSize(1650,1000);         
    
    Font font=new Font("苹方 常规",Font.CENTER_BASELINE,28);//设置字体格式和大小

    

    
    this.add(lb1);
    lb1.setBounds(456-270, 196-80, 151, 47);
    lb1.setFont(font);
    this.add(tf1);
    tf1.setBackground(Color.WHITE);
    tf1.setBounds(660-270, 196-80, 352, 47);
    tf1.setFont(font);
    tf1.setEditable(false);
    tf1.setBorder(null);    

	/*
	 * 设置JTable的列名
	 */
	String[] columnNames =
	{ "产品号","产品名", "购买数量","购买者","购买时间","消费金额","账户余额"};

	int num_borrow=2;
	Object[][] obj = new Object[num_borrow][7];
	for (int i = 0; i < num_borrow; i++)
	{
		for (int j = 0; j < 7; j++)
		{
			switch (j)
			{
			case 0:
				obj[i][j] = "1";
				break;
			case 1:
				obj[i][j] = "吴云建";
				break;
			case 2:
				obj[i][j] = "3";
				break;
			case 3:
				obj[i][j] = "1993";
				break;
			case 4:
				obj[i][j] = "2";
				break;
			case 5:
				obj[i][j] = "3";
				break;
			case 6:
				obj[i][j] = "3";
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
 

	JTable table = new JTable(dtm); 
	;
    table.setRowHeight(30);// 设置表格行宽
    
    JTableHeader head = table.getTableHeader(); // 创建表格标题对象
    head.setPreferredSize(new Dimension(head.getWidth(), 35));// 设置表头大小
    head.setFont(font);// 设置表格字体
   
	TableColumn column = null;
	int colunms = table.getColumnCount();
	for(int i = 0; i < colunms; i++)
	{
		column = table.getColumnModel().getColumn(i);
		column.setPreferredWidth(300);
	}
	

	table.setBounds(400, 365, 600, 800);
	table.setFont(font);
	
	/*用JScrollPane装载JTable，这样超出范围的列就可以通过滚动条来查看*/
	JScrollPane scroll = new JScrollPane(table);
	scroll.setLocation(186, 223);
	scroll.setSize(1022, 528);
	table.setSize(600, 800);
	
	add(scroll);

    
    
	}
}
