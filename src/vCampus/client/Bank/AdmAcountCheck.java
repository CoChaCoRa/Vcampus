package vCampus.client.Bank;
/**
 * @author Yanhao Shen
 * 
 * @date 9.3
 *
 */
import javax.swing.*;

import vCampus.client.biz.AdminService;
import vCampus.client.biz.StudentService;
import vCampus.client.biz.StudentServiceImpl;
import vCampus.client.biz.TeacherService;
import vCampus.client.biz.TeacherServiceImpl;
import vCampus.client.register.RegisterView;
import vCampus.vo.Admin;
import vCampus.vo.BookInformation;
import vCampus.vo.Student;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AdmAcountCheck extends JPanel{


	
	public AdmAcountCheck(AdminService adm) {
		
	super();
	JLabel lb1 = new JLabel("一卡通号");
	JTextField tf1 = new JTextField(20);
	JLabel lb2 = new JLabel("余额");
	JTextField tf2 = new JTextField(20);

	JButton bt1=new JButton("");
	JButton bt0=new JButton("");
	JLabel lb0 = new JLabel("查询");
	JTextField tf0 = new JTextField(20);
	
	this.setLayout(null);
	this.setSize(1650,1000);         
    
    Font font=new Font("苹方 常规",Font.CENTER_BASELINE,28);//设置字体格式和大小
    
    
    this.add(bt0);
    bt0.setBounds(880,196-90,60,60);
    bt0.setFont(font);
    // 设置按钮的默认图片
    bt0.setIcon(new ImageIcon("img\\查询UI.png"));
    bt0.setBorder(null);
    bt0.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			//JOptionPane.showMessageDialog(null, "to check money of one stu");
			if(adm.queryAccountByUserName(tf1.getText())!=-1) {
				String money = String.valueOf(adm.queryAccountByUserName(tf1.getText()));
				tf2.setText(money);
			}
		}
    	
    });
    
    this.add(lb1); 
    lb1.setBounds(456-270, 196-80, 151, 47);
    lb1.setFont(font);
    this.add(tf1);
    tf1.setBackground(Color.WHITE);
    tf1.setBounds(710-270, 196-80, 352, 47);
    tf1.setFont(font);
   // tf1.setEditable(false);
    tf1.setBorder(null);

    this.add(lb2);
    lb2.setBounds(456-270, 307-80, 101, 47);
    lb2.setFont(font);
    this.add(tf2);
    tf2.setBackground(Color.WHITE);
  //  tf2.setText("11022");
    tf2.setBounds(710-270, 307-80, 352, 47);
    tf2.setFont(font);
    tf2.setEditable(false);
    tf2.setBorder(null);
    
  
    }

    
}
