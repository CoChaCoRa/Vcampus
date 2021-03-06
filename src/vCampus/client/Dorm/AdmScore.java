package vCampus.client.Dorm;
/**
 * @author Yanhao Shen
 * 
 * @date 9.3
 *
 */
import javax.swing.*;

import vCampus.client.biz.DormitoryService;
import vCampus.client.biz.DormitoryServiceImpl;
import vCampus.client.register.RegisterView;
import vCampus.vo.Dormitory;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class AdmScore extends JPanel{


	
	public AdmScore() {
		
	super();
	JLabel lb1 = new JLabel("宿舍号");
	JTextField tf1 = new JTextField(20);
	JLabel lb2 = new JLabel("分数");
	JTextField tf2 = new JTextField(20);
	JTextField tf3 = new JTextField(20);

	JButton bt1=new JButton("");
	
	this.setLayout(null);
	this.setSize(1650,1000);         
    
    Font font=new Font("苹方 常规",Font.CENTER_BASELINE,28);//设置字体格式和大小
   
    this.add(tf3);
    tf3.setBounds(810-170, 600-80, 352, 47);
    tf3.setFont(font);
    tf3.setEditable(false);
    tf3.setBorder(null);
    
    this.add(bt1);
    bt1.setBounds(910-270, 910-80, 160, 80);
    bt1.setFont(font);
    // 设置按钮的默认图片
    bt1.setIcon(new ImageIcon("img\\确认.png"));
    bt1.setBorder(null);
    bt1.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
    			double score = Double.parseDouble(tf2.getText());
    			if(score<0) throw new ArithmeticException();
    			DormitoryService DS = new DormitoryServiceImpl();
    			Dormitory newdorm = new Dormitory();
    			newdorm.setScore(score);
    			if(DS.addDormitoryInfo(newdorm)) {
    				tf3.setText("打分成功！");
    				tf1.setText("");
    				tf2.setText("");
    			}
    			else tf3.setText(DS.getExceptionCode());
    		}catch(NumberFormatException e1) {
    			tf3.setText("输入不能含有字符");
    			tf1.setText("");
    			tf2.setText("");
    		}
    		catch(ArithmeticException e2) {
    			tf3.setText("请输入0-100的整数");
    			tf1.setText("");
    			tf2.setText("");
    		}
		}
    	
    });
    
    bt1.setContentAreaFilled(false);
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
    
  
    }
    
}
