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
import vCampus.vo.Admin;
import vCampus.vo.BookInformation;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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
	
	public AdmBookChange(AdminService admin) {
		
	super();

	JButton bt0=new JButton("");
	JButton bt1=new JButton("");
	JButton bt2=new JButton("");
	
	this.setLayout(null);
	this.setSize(1650,1000);         
    
    Font font=new Font("苹方 常规",Font.CENTER_BASELINE,28);//设置字体格式和大小
   
    LibraryService LS = new LibraryServiceImpl(3,admin.getCacheAdmin().getAdminID());
    
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
			if(LS.updateBookByAdmin(BooktoUpdate)==true) {
				JOptionPane.showMessageDialog(null, "修改成功");
			}
			else {
				if(!LS.getExceptionCode().equals("")) {
					JOptionPane.showMessageDialog(null, LS.getExceptionCode());
				}
			} 
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
    lb1.setBounds(456-270, 196-80+111, 101, 47);
    lb1.setFont(font);
    this.add(tf1);
    tf1.setBackground(Color.WHITE);
    tf1.setBounds(660-270, 196-80+111, 402, 47);
    tf1.setFont(font);
    tf1.setEditable(false);
    tf1.setBorder(null);

    this.add(lb2);
    lb2.setBounds(1156-270, 196-80+111, 101, 47);
    lb2.setFont(font);
    this.add(tf2);
    tf2.setBackground(Color.WHITE);
    tf2.setBounds(1360-270, 196-80+111, 402, 47);
    tf2.setFont(font);
 //   tf2.setEditable(false);
    tf2.setBorder(null);
    
    this.add(lb3);
    lb3.setBounds(456-270, 307-80+111, 201, 47);
    lb3.setFont(font);
    this.add(tf3);
    tf3.setBackground(Color.WHITE);
    tf3.setBounds(660-270, 307-80+111, 402, 47);
    tf3.setFont(font);
    tf3.setEditable(false);
    tf3.setBorder(null);
    
    this.add(lb4);
    lb4.setBounds(1156-270, 307-80+111, 250, 47);
    lb4.setFont(font);
    this.add(tf4);
    tf4.setBackground(Color.WHITE);
    tf4.setBounds(1360-270, 307-80+111, 402, 47);
    tf4.setFont(font);
    tf4.setEditable(false);
    tf4.setBorder(null);
    
    this.add(lb5);
    lb5.setBounds(456-270, 418-80+111, 201, 47);
    lb5.setFont(font);
    this.add(tf5);
    tf5.setBackground(Color.WHITE);
    tf5.setBounds(660-270, 418-80+111, 402, 47);
    tf5.setFont(font);
    tf5.setEditable(false);
    tf5.setBorder(null);
    
	}
}
