package vCampus.client.JWC;
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
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;

public class AdmClassChange extends JPanel{

	JLabel lb0 = new JLabel("查询");
	JTextField tf0 = new JTextField(20);
	JButton bt0=new JButton("");
	JButton bt1=new JButton("");
	
	JLabel lb1 = new JLabel("课程号");
	JTextField tf1 = new JTextField(20);
	//JLabel lb2 = new JLabel("课程名");
	//JTextField tf2 = new JTextField(20);
	JLabel lb3 = new JLabel("教师号");
	JTextField tf3 = new JTextField(20);
	JLabel lb4 = new JLabel("所属院系");
	JTextField tf4 = new JTextField(20);
	JLabel lb5 = new JLabel("学分");
	JTextField tf5 = new JTextField(20);
	JLabel lb6 = new JLabel("上限人数");
	JTextField tf6 = new JTextField(20);
	JLabel lb7 = new JLabel("上课教室");
	JTextField tf7 = new JTextField(20);
	JLabel lb8 = new JLabel("课程时间");
	JTextField tf8 = new JTextField(20);
	
	
	
	
	public AdmClassChange() {
		
	super();

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
    bt1.setContentAreaFilled(false);
    
    this.add(lb1);
    lb1.setBounds(456-270, 196-80, 201, 47);
    lb1.setFont(font);
    this.add(tf1);
    tf1.setBackground(Color.WHITE);
    tf1.setBounds(660-270, 196-80, 352, 47);
    tf1.setFont(font);
  //  tf1.setEditable(false);
    tf1.setBorder(null);

    this.add(lb3);
    lb3.setBounds(456-270, 307-80, 201, 47);
    lb3.setFont(font);
    this.add(tf3);
    tf3.setBackground(Color.WHITE);
    tf3.setBounds(660-270, 307-80, 352, 47);
    tf3.setFont(font);
 //   tf3.setEditable(false);
    tf3.setBorder(null);
    
    this.add(lb4);
    lb4.setBounds(1156-270, 307-80, 250, 47);
    lb4.setFont(font);
    this.add(tf4);
    tf4.setBackground(Color.WHITE);
    tf4.setBounds(1360-270, 307-80, 352, 47);
    tf4.setFont(font);
    tf4.setEditable(false);
    tf4.setBorder(null);
    
    this.add(lb5);
    lb5.setBounds(456-270, 418-80, 201, 47);
    lb5.setFont(font);
    this.add(tf5);
    tf5.setBackground(Color.WHITE);
    tf5.setBounds(660-270, 418-80, 352, 47);
    tf5.setFont(font);
  //  tf5.setEditable(false);
    tf5.setBorder(null);
    
    this.add(lb6);
    tf6.setBackground(Color.WHITE);
    lb6.setBounds(1156-270, 418-80, 201, 47);
    lb6.setFont(font);
    this.add(tf6);
    tf6.setBounds(1360-270, 418-80, 352, 47);
    tf6.setFont(font);
  //  tf6.setEditable(false);
    tf6.setBorder(null);
    
    this.add(lb7);
    tf7.setBackground(Color.WHITE);
    lb7.setBounds(456-270, 529-80, 201, 47);
    lb7.setFont(font);
    this.add(tf7);
    tf7.setBounds(660-270, 529-80, 352, 47);
    tf7.setFont(font);
 //   tf7.setEditable(false);
    tf7.setBorder(null);
    
    this.add(lb8);
    lb8.setBounds(1156-270, 529-80, 201, 47);
    lb8.setFont(font);
    this.add(tf8);
    tf8.setBackground(Color.WHITE);
    tf8.setBounds(1360-270, 529-80, 352, 47);
    tf8.setFont(font);
 //   tf8.setEditable(false);
    tf8.setBorder(null);
 	
	}
	
	
}
