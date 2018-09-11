package vCampus.server.Shop;
/**
 * @author SYH
 * 
 * @date 9.3
 *
 */
import javax.swing.*;

import vCampus.client.biz.AdminService;
import vCampus.client.biz.ShopService;
import vCampus.client.biz.ShopServiceImpl;
import vCampus.client.register.RegisterView;
import vCampus.vo.ProductInformation;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class AdmAdd extends JPanel{


	
	public AdmAdd(AdminService admin) {
		
	super();
	

	JLabel lb1 = new JLabel("商品号");
	JTextField tf1 = new JTextField(20);
	JLabel lb2 = new JLabel("商品名");
	JTextField tf2 = new JTextField(20);
	JLabel lb3 = new JLabel("销售单价");
	JTextField tf3 = new JTextField(20);
	JLabel lb4 = new JLabel("库存数量");
	JTextField tf4 = new JTextField(20);

	
	JButton bt1=new JButton("");
	
	this.setLayout(null);
	this.setSize(1650,1000);         
    
    Font font=new Font("苹方 常规",Font.CENTER_BASELINE,28);//设置字体格式和大小
   
    
    this.add(bt1);
    bt1.setBounds(910-270, 910-80, 160, 80);
    bt1.setFont(font);
    // 设置按钮的默认图片
    bt1.setIcon(new ImageIcon("img\\确认.png"));
    bt1.setBorder(null);
    bt1.setContentAreaFilled(false);

	//如果商品种类==8种不能添加！
    //如果商品种类==0种不能减少！
    
    
    this.add(lb1);
    lb1.setBounds(456-270, 196-80+111, 101, 47);
    lb1.setFont(font);
    this.add(tf1);
    tf1.setBackground(Color.WHITE);
    tf1.setBounds(660-270, 196-80+111, 352, 47);
    tf1.setFont(font);
//    tf1.setEditable(false);
    tf1.setBorder(null);

    this.add(lb2);
    lb2.setBounds(1156-270, 196-80+111, 101, 47);
    lb2.setFont(font);
    this.add(tf2);
    tf2.setBackground(Color.WHITE);
    tf2.setBounds(1360-270, 196-80+111, 352, 47);
    tf2.setFont(font);
 //   tf2.setEditable(false);
    tf2.setBorder(null);
    
    this.add(lb3);
    lb3.setBounds(456-270, 307-80+111, 151, 47);
    lb3.setFont(font);
    this.add(tf3);
    tf3.setBackground(Color.WHITE);
    tf3.setBounds(660-270, 307-80+111, 352, 47);
    tf3.setFont(font);
//    tf3.setEditable(false);
    tf3.setBorder(null);
    
    this.add(lb4);
    lb4.setBounds(1156-270, 307-80+111, 150, 47);
    lb4.setFont(font);
    this.add(tf4);
    tf4.setBackground(Color.WHITE);
    tf4.setBounds(1360-270, 307-80+111, 352, 47);
    tf4.setFont(font);
//    tf4.setEditable(false);
    tf4.setBorder(null);
   
    
    

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
			ShopService SPS = new ShopServiceImpl(3,admin.getCacheAdmin().getAdminID());
			ProductInformation product = new ProductInformation();
			product.setProductID(tf1.getText());
			product.setProductName(tf2.getText());
			product.setProductPrice(Integer.parseInt(tf3.getText()));
			product.setAmount(Integer.parseInt(tf4.getText()));
			if(SPS.addProductByAdmin(product)==true) {
				JOptionPane.showMessageDialog(null, "添加成功");
			}
			else {
				JOptionPane.showMessageDialog(null, SPS.getExceptionCodes());
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
    });
	


	}
	
	
	
}
