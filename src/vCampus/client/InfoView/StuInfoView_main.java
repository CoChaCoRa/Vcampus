package vCampus.client.InfoView;
/**
 * @author SYH
 * 
 * @date 9.3
 *
 */

import javax.swing.*;

import vCampus.client.register.RegisterView;

import java.awt.CardLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;

public class StuInfoView_main extends JPanel{
	JFrame frame = new JFrame("教师信息");
	BackgroundPanel bgp;
	
	
	JButton jb3 = new JButton();
	JButton jb4 = new JButton();
	JButton jb5 = new JButton();
	JButton jb6 = new JButton();
	JButton jb7 = new JButton();
	JButton jb8 = new JButton();
	
	public StuInfoView_main() {
	this.setLayout(null);
	this.setSize(1920,1080);         
    this.setLocation(0, 0);
    Font font=new Font("苹方 常规",Font.CENTER_BASELINE,28);//设置字体格式和大小

 //*******************************
 //此为一级容器
    
    CardLayout card=new CardLayout();
 	JPanel pn1=new JPanel();
 	
 	Winchange_test w1=new Winchange_test();
 	//Winchange2 w2=new Winchange2();
 	pn1.setLayout(card);
 	pn1.setBounds(0, 80, 1920, 1000);
 	pn1.add("w1",w1);
 //	pn1.add("w2",w2);
 	frame.add(pn1);
    
    
    frame.add(jb3);
    jb3.setBounds(270, 0, 250, 78);
    jb3.setFont(font);
    // 设置按钮的默认图片
    //jb3.setIcon(new ImageIcon("img\\个人常规.png"));
    jb3.setIcon(new ImageIcon("img\\个人常规.png"));
    jb3.setBorder(null);
    // 添加按钮点击事件监听器
    jb3.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        	refresh();
        	jb3.setIcon(new ImageIcon("img\\个人点击.png"));
        	card.show(pn1,"w1");
        }
    });
    
    frame.add(jb4);
    jb4.setBounds(520, 0, 250, 78);
    jb4.setFont(font);
    // 设置按钮的默认图片
    jb4.setIcon(new ImageIcon("img\\银行常规.png"));
    jb4.setBorder(null);
    // 添加按钮点击事件监听器
    jb4.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        	refresh();
        	jb4.setIcon(new ImageIcon("img\\银行点击.png"));
        	card.show(pn1,"w2");
        }
    });
    
    frame.add(jb5);
    jb5.setBounds(770, 0, 250, 78);
    jb5.setFont(font);
    // 设置按钮的默认图片
    jb5.setIcon(new ImageIcon("img\\图书常规.png"));
    jb5.setBorder(null);
    // 添加按钮点击事件监听器
    jb5.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        	refresh();
        	jb5.setIcon(new ImageIcon("img\\图书点击.png"));
        	card.show(pn1,"w2");
        }
    });
    
    frame.add(jb6);
    jb6.setBounds(1020, 0, 250, 78);
    jb6.setFont(font);
    // 设置按钮的默认图片
    jb6.setIcon(new ImageIcon("img\\商店常规.png"));
    jb6.setBorder(null);
    // 添加按钮点击事件监听器
    jb6.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        	refresh();
        	jb6.setIcon(new ImageIcon("img\\商店点击.png"));
        	card.show(pn1,"w1");
        }
        
    });
    
    frame.add(jb7);
    jb7.setBounds(1270, 0, 250, 78);
    jb7.setFont(font);
    // 设置按钮的默认图片
    jb7.setIcon(new ImageIcon("img\\教务常规.png"));
    jb7.setBorder(null);
    // 添加按钮点击事件监听器
    jb7.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        	refresh();
        	jb7.setIcon(new ImageIcon("img\\教务点击.png"));
        }
    });
    
    frame.add(jb8);
    jb8.setBounds(1520, 0, 250, 78);
    jb8.setFont(font);
    // 设置按钮的默认图片
    jb8.setIcon(new ImageIcon("img\\医院常规.png"));
    jb8.setBorder(null);
    // 添加按钮点击事件监听器
    jb8.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        	refresh();
        	jb8.setIcon(new ImageIcon("img\\医院点击.png"));
        }
    });
    
	bgp=new BackgroundPanel((new ImageIcon("img\\bgp.png")).getImage());
	bgp.setBounds(0,0,1920,1080);
	frame.add(bgp);
	
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	frame.setSize(1920,1080);
	frame.setVisible(true);  
	frame.setResizable(true);
	}
	
	public void refresh() {
		jb3.setIcon(new ImageIcon("img\\个人常规.png"));
		jb4.setIcon(new ImageIcon("img\\银行常规.png"));
		jb5.setIcon(new ImageIcon("img\\图书常规.png"));
		jb6.setIcon(new ImageIcon("img\\商店常规.png"));
		jb7.setIcon(new ImageIcon("img\\教务常规.png"));
		jb8.setIcon(new ImageIcon("img\\医院常规.png"));
	}
	

	public static void main(String[] args) {  
		StuInfoView_main SIV=new StuInfoView_main();  
    }
}
class BackgroundPanel extends JPanel{
	Image im;
	public BackgroundPanel(Image im)
	{
		this.im=im;
		this.setOpaque(true);
	}
	//Draw the back ground.
	public void paintComponent(Graphics g)
	{
		super.paintComponents(g);
		g.drawImage(im,0,0,this.getWidth(),this.getHeight(),this);
	}
}