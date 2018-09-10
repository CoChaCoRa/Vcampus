package vCampus.client.Shop;

import java.awt.CardLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


/**
 * @author Yanhao Shen
 *
 */
public class Winchange_shop extends JPanel {
	
	public Winchange_shop(int identify){
		super();
//		int identify=2;
	    CardLayout card=new CardLayout();
		JPanel cardpanel=new JPanel();
		StuAccountCheck w1=new StuAccountCheck();
		Stubuy w2=new Stubuy();
		
		
		AdmCheck w3=new AdmCheck();
		AdmAdd w4=new AdmAdd();
		AdmDelete w5=new AdmDelete();
		
		
		Font font=new Font("苹方 常规",Font.CENTER_BASELINE,28);
		this.setLayout(null);
		
		JButton jb1=new JButton();
		JButton jb2=new JButton();
		JButton jb3=new JButton();
		JButton jb4=new JButton();
		JButton jb5=new JButton();
		
		
		//identify:1 学生 查看账户/购买
		//identify:2 教师 
		//identify:3 查询销售/添加商品/删除修改
		
		
		//this.add(jb1);
	    jb1.setBounds(0, 0, 270, 80);
	    jb1.setFont(font);
	    jb1.setIcon(new ImageIcon("img\\账户余额点击.png"));
	       	
	    //this.add(jb2);
	    jb2.setBounds(0, 80, 270, 80);
	    jb2.setFont(font);
	    jb2.setIcon(new ImageIcon("img\\购买商品.png"));

	    //this.add(jb3);
	    jb3.setBounds(0, 00, 270, 80);
	    jb3.setFont(font);
	    jb3.setIcon(new ImageIcon("img\\销售查询点击.png"));


	    jb4.setBounds(0, 80, 270, 80);
	    jb4.setFont(font);
	    jb4.setIcon(new ImageIcon("img\\添加商品.png"));
	    
	   
	    jb5.setBounds(0, 160, 270, 80);
	    jb5.setFont(font);
	    jb5.setIcon(new ImageIcon("img\\查询修改.png"));
	
	    
	    jb1.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	      
	        	card.show(cardpanel,"w1");
	        	 jb1.setIcon(new ImageIcon("img\\账户余额点击.png"));
	        	 jb2.setIcon(new ImageIcon("img\\购买商品.png"));
	      	   
	        	
	        }
	    });
	    
	    jb2.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	      
	        	card.show(cardpanel,"w2");

	        	 jb1.setIcon(new ImageIcon("img\\账户余额.png"));
	        	 jb2.setIcon(new ImageIcon("img\\购买商品点击.png"));
	        	
	        }
	    });
	  
	    jb3.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	      
	        	card.show(cardpanel,"w3");
	        	jb3.setIcon(new ImageIcon("img\\销售查询点击.png"));
	        	jb4.setIcon(new ImageIcon("img\\添加商品.png"));
	        	jb5.setIcon(new ImageIcon("img\\查询修改.png"));
	        	
	        }
	    });
	    
	    jb4.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	      
	        	card.show(cardpanel,"w4");
	          	jb3.setIcon(new ImageIcon("img\\销售查询.png"));
	        	jb4.setIcon(new ImageIcon("img\\添加商品点击.png"));
	        	jb5.setIcon(new ImageIcon("img\\查询修改.png"));
	        }
	    });
	    
	    
	    jb5.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	      
	        	card.show(cardpanel,"w5");
	          	jb3.setIcon(new ImageIcon("img\\销售查询.png"));
	        	jb4.setIcon(new ImageIcon("img\\添加商品.png"));
	        	jb5.setIcon(new ImageIcon("img\\查询修改点击.png"));
	        }
	    });
	  
		//Winchange2 w2=new Winchange2();
		cardpanel.setLayout(card);
		cardpanel.setBounds(270, 0, 1920-270, 1000);

		if(identify==1||identify==2)
		{
			cardpanel.add("w1",w1);
			cardpanel.add("w2",w2);
			this.add(jb1);
			this.add(jb2);
			
		}
		
		if(identify==3)
		{
			cardpanel.add("w3",w3);
			cardpanel.add("w4",w4);
			cardpanel.add("w5",w5);
			this.add(jb3);
			this.add(jb4);
			this.add(jb5);
		}
	
		
		
		this.add(cardpanel);
		
	}
	
	
}
