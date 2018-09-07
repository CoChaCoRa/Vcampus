package vCampus.client.TSG;
/**
 * @author Yanhao Shen
 * 
 * @date 9.3
 *
 */
import javax.swing.*;

import vCampus.client.register.RegisterView;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*; 

public class StuBookCheck extends JPanel{


	
	public StuBookCheck() {
		
	super();
	JList jlist;    //列表框  
	JComboBox jcb;  //下拉框  
	  
	JLabel jlb2;  
	JScrollPane jsp;    //滚动控件 
	
	JLabel lb1 = new JLabel("查询");
	JTextField tf1 = new JTextField(20);
	JLabel lb2 = new JLabel("heeee");
	
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
    bt1.setBounds(910-270, 910-80, 160, 80);
    bt1.setFont(font);
    // 设置按钮的默认图片
    bt1.setIcon(new ImageIcon("img\\确认.png"));
    bt1.setBorder(null);

    this.add(lb1); 
    lb1.setBounds(456-270, 196-80, 151, 47);
    lb1.setFont(font);
    this.add(tf1);
    tf1.setBackground(Color.WHITE);
    tf1.setBounds(710-270, 196-80, 352, 47);
    tf1.setFont(font);
   // tf1.setEditable(false);
    tf1.setBorder(null);

    lb2 = new JLabel("选择英雄：");  

    this.add(lb2);
    lb2.setBounds(456-270, 307-80, 101, 47);
    lb2.setFont(font);

  
    String str2[] = {"盖仑", "艾希", "提莫", "赵信", "李青", "安妮"};  
    jlist = new JList(str2);  
    jlist.setFont(font);
    jlist.setBounds(400, 400, 100, 100);
    
    jlist.setVisibleRowCount(5);//默认显示行数  
    this.add(jlist);
    jsp = new JScrollPane(jlist);  
      
    
      
      
    this.add(jsp);  
    
    JList list = new JList(str2);
    list.setBounds(104, 365, 400, 400);
    
    list.setFont(font);
    add(list);
    
    JScrollBar scrollBar = new JScrollBar();
    scrollBar.setBounds(104, 365, 400, 48);
    scrollBar.setBackground(getBackground());
    add(scrollBar);
    
    
    
    }
}
