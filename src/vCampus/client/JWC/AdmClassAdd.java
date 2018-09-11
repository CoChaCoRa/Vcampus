package vCampus.client.JWC;
/**
 * @author SYH
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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class AdmClassAdd extends JPanel{
	
	JLabel lb1 = new JLabel("课程号");
	JTextField tf1 = new JTextField(20);
	JLabel lb2 = new JLabel("课程名");
	JTextField tf2 = new JTextField(20);
	JLabel lb3 = new JLabel("所属院系");
	JTextField tf3 = new JTextField(20);
	JLabel lb4 = new JLabel("教师号");
	JTextField tf4 = new JTextField(20);
	JLabel lb5 = new JLabel("教师名");
	JTextField tf5 = new JTextField(20);
	JLabel lb6 = new JLabel("学时");
	JTextField tf6 = new JTextField(20);
	JLabel lb7 = new JLabel("学分");
	JTextField tf7 = new JTextField(20);
	JLabel lb8 = new JLabel("开始时间");
	JTextField tf8 = new JTextField(20);
	JLabel lb9 = new JLabel("上课教室");
	JTextField tf9 = new JTextField(20);
	JLabel lb10 = new JLabel("考试时间");
	JTextField tf10 = new JTextField(20);
	JLabel lb11 = new JLabel("考试教室");
	JTextField tf11 = new JTextField(20);
	
	JLabel lb12 = new JLabel("上限人数");
	JTextField tf12 = new JTextField(20);
	JLabel lb13 = new JLabel("课程时间");
	JTextField tf13 = new JTextField(20);
	
	
	
	JButton bt1=new JButton("");

	
	public AdmClassAdd() {
		
	super();

	this.setLayout(null);
	this.setSize(1650,1000);         
    
    Font font=new Font("苹方 常规",Font.CENTER_BASELINE,28);//设置字体格式和大小
   
    this.add(bt1);
    bt1.setBounds(870, 772, 160, 80);
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
//    tf1.setEditable(false);
    tf1.setBorder(null);

    this.add(lb2);
    lb2.setBounds(1156-270, 196-80, 201, 47);
    lb2.setFont(font);
    this.add(tf2);
    tf2.setBackground(Color.WHITE);
  //  tf2.setText("11022");
    tf2.setBounds(1360-270, 196-80, 352, 47);
    tf2.setFont(font);
 //   tf2.setEditable(false);
    tf2.setBorder(null);
    
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
  //  tf4.setEditable(false);
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
   
    this.add(lb9);
    lb9.setBounds(456-270, 640-80, 201, 47);
    lb9.setFont(font);
    this.add(tf9);
    tf9.setBackground(Color.WHITE);
    tf9.setBounds(660-270, 640-80, 352, 47);
    tf9.setFont(font);
    tf9.setEditable(false);
    tf9.setBorder(null);
    
    this.add(lb10);
    lb10.setBounds(1156-270, 640-80, 201, 47);
    lb10.setFont(font);
    this.add(tf10);
    tf10.setBackground(Color.WHITE);
    tf10.setBounds(1360-270, 640-80, 352, 47);
    tf10.setFont(font);
    tf10.setEditable(false);
    tf10.setBorder(null);
  

    this.add(lb11);
    lb11.setBounds(456-270, 640-80+111, 201, 47);
    lb11.setFont(font);
    this.add(tf11);
    tf11.setBackground(Color.WHITE);
    tf11.setBounds(660-270, 640-80+111, 352, 47);
    tf11.setFont(font);
    tf11.setEditable(false);
    tf11.setBorder(null);
    
    this.add(lb12);
    lb12.setBounds(1156-270, 640-80+111, 201, 47);
    lb12.setFont(font);
    this.add(tf12);
    tf12.setBackground(Color.WHITE);
    tf12.setBounds(1360-270, 640-80+111, 352, 47);
    tf12.setFont(font);
    tf12.setEditable(false);
    tf12.setBorder(null);
  

    this.add(lb13);
    lb13.setBounds(456-270, 640-80+111*2, 201, 47);
    lb13.setFont(font);
    this.add(tf13);
    tf13.setBackground(Color.WHITE);
    tf13.setBounds(660-270, 640-80+111*2, 352, 47);
    tf13.setFont(font);
    tf13.setEditable(false);
    tf13.setBorder(null);
    
    bt1.addMouseListener(new MouseListener() {
		@Override
		public void mouseEntered(MouseEvent e) {
			bt1.setIcon(new ImageIcon("img\\确认点击.png"));
		}

		@Override
		public void mouseExited(MouseEvent e) {
			bt1.setIcon(new ImageIcon("img\\确认.png"));
		}

		@Override
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


    this.setLayout(null);
	this.setSize(1650,1000);         
	

	}
	
}
