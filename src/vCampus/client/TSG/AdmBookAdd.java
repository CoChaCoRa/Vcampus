package vCampus.client.TSG;
/**
 * @author SYH
 * 
 * @date 9.3
 *
 */
import javax.swing.*;

import vCampus.client.biz.AdminService;
import vCampus.client.biz.LibraryService;
import vCampus.client.biz.LibraryServiceImpl;
import vCampus.client.register.RegisterView;
import vCampus.server.exception.RecordAlreadyExistException;
import vCampus.vo.BookInformation;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;

public class AdmBookAdd extends JPanel{

	JLabel lb1 = new JLabel("书号");
	JTextField tf1 = new JTextField(20);
	JLabel lb2 = new JLabel("书名");
	JTextField tf2 = new JTextField(20);
	JLabel lb3 = new JLabel("出版社");
	JTextField tf3 = new JTextField(20);
	JLabel lb4 = new JLabel("书架位置");
	JTextField tf4 = new JTextField(20);
	JLabel lb5 = new JLabel("作者");
	JTextField tf5 = new JTextField(20);
	JLabel lb6 = new JLabel("库存量");
	JTextField tf6 = new JTextField(20);
	
	
	public AdmBookAdd(AdminService admin) {
		
	super();
	
	
	JButton bt1=new JButton("");
	
	this.setLayout(null);
	this.setSize(1650,1000);         
    
    Font font=new Font("苹方 常规",Font.CENTER_BASELINE,28);//设置字体格式和大小
   
    this.add(bt1);
    bt1.setBounds(910-270, 910-80, 160, 80);
    bt1.setFont(font);
    // 设置按钮的默认图片
    bt1.setIcon(new ImageIcon("img\\确认.png"));
    bt1.setPressedIcon(new ImageIcon("img\\确认点击.png"));
    bt1.setBorder(null);
    bt1.addActionListener(new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			LibraryService LS = new LibraryServiceImpl(3,admin.getCacheAdmin().getAdminID());
			BookInformation BooktoAdd = new BookInformation();
			BooktoAdd.setBookID(tf1.getText());
			BooktoAdd.setBookName(tf2.getText());
			BooktoAdd.setBookPress(tf3.getText());
			BooktoAdd.setBookAddress(tf4.getText());
			BooktoAdd.setBookWriter(tf5.getText());
			BooktoAdd.setTotalAmount(Integer.parseInt(tf6.getText()));
			if(LS.addBookByAdmin(BooktoAdd)==true) {
					JOptionPane.showMessageDialog(null, "添加成功");
			}
			else {
				if(!LS.getExceptionCode().equals("")) {
					JOptionPane.showMessageDialog(null, LS.getExceptionCode());
				}
			}

		}
    	
    });
    
    this.add(lb1);
    lb1.setBounds(456-270, 196-80, 101, 47);
    lb1.setFont(font);
    this.add(tf1);
    tf1.setBackground(Color.WHITE);
    tf1.setBounds(660-270, 196-80, 352, 47);
    tf1.setFont(font);
//    tf1.setEditable(false);
    tf1.setBorder(null);

    this.add(lb2);
    lb2.setBounds(1156-270, 196-80, 101, 47);
    lb2.setFont(font);
    this.add(tf2);
    tf2.setBackground(Color.WHITE);
  //  tf2.setText("11022");
    tf2.setBounds(1360-270, 196-80, 352, 47);
    tf2.setFont(font);
 //   tf2.setEditable(false);
    tf2.setBorder(null);
    
    this.add(lb3);
    lb3.setBounds(456-270, 307-80, 101, 47);
    lb3.setFont(font);
    this.add(tf3);
    tf3.setBackground(Color.WHITE);
    tf3.setBounds(660-270, 307-80, 352, 47);
    tf3.setFont(font);
 //   tf3.setEditable(false);
    tf3.setBorder(null);
    
    this.add(lb4);
    lb4.setBounds(1156-270, 307-80, 150, 47);
    lb4.setFont(font);
    this.add(tf4);
    tf4.setBackground(Color.WHITE);
    tf4.setBounds(1360-270, 307-80, 352, 47);
    tf4.setFont(font);
  //  tf4.setEditable(false);
    tf4.setBorder(null);
    
    this.add(lb5);
    lb5.setBounds(456-270, 418-80, 101, 47);
    lb5.setFont(font);
    this.add(tf5);
    tf5.setBackground(Color.WHITE);
    tf5.setBounds(660-270, 418-80, 352, 47);
    tf5.setFont(font);
  //  tf5.setEditable(false);
    tf5.setBorder(null);
    
    this.add(lb6);
    tf6.setBackground(Color.WHITE);
    lb6.setBounds(1156-270, 418-80, 101, 47);
    lb6.setFont(font);
    this.add(tf6);
    tf6.setBounds(1360-270, 418-80, 352, 47);
    tf6.setFont(font);
  //  tf6.setEditable(false);
    tf6.setBorder(null);
  
	this.setLayout(null);
	this.setSize(1650,1000);         
    
  
	}
	

}
