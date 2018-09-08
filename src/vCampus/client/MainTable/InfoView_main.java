package vCampus.client.MainTable;

/**
 * @author SYH
 * @author2 CC
 * 
 * @v1.0 date 9.3
 * @v1.1 date 9/7
 *  add front-end monitor
 *
 */

import javax.swing.*;

import vCampus.vo.Admin;
import vCampus.vo.Student;
import vCampus.vo.Teacher;
import vCampus.client.InfoView.*;
import vCampus.client.JWC.*;
import vCampus.client.TSG.*;
import vCampus.client.Shop.*;
import vCampus.client.Bank.*;
import vCampus.client.Dorm.*;



import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.CardLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class InfoView_main extends JPanel{
	JFrame frame = new JFrame("信息");
	BackgroundPanel bgp;
	
	JButton jb_close = new JButton();
	JButton jb3 = new JButton();
	JButton jb4 = new JButton();
	JButton jb5 = new JButton();
	JButton jb6 = new JButton();
	JButton jb7 = new JButton();
	JButton jb8 = new JButton();
	
	public InfoView_main(int id,Student ss) {
	this.setLayout(null);
	this.setSize(1920,1080);         
    this.setLocation(0, 0);

    Font font=new Font("苹方 常规",Font.CENTER_BASELINE,28);//设置字体格式和大小

 //*******************************
 //此为一级容器
    
    CardLayout card=new CardLayout();
 	JPanel pn1=new JPanel();
 	
 	Student stu = new Student();
 	stu=ss;
 	
 	Winchange_test w1=new Winchange_test(id,ss);
 	Winchange_JWC w2=new Winchange_JWC(id);
 	Winchange_TSG w3=new Winchange_TSG(id);
 	Winchange_shop w4=new Winchange_shop(id);
 	Winchange_dorm w5=new Winchange_dorm(id,ss);
 	Winchange_bank w6=new Winchange_bank(id,ss);
 	
 	w1.setBackground(null);
	w1.setOpaque(false);
 	
 	w2.setBackground(null);
	w2.setOpaque(false);
 	
 	w3.setBackground(null);
	w3.setOpaque(false);
	
	w4.setBackground(null);
	w4.setOpaque(false);
	
	w5.setBackground(null);
	w5.setOpaque(false);
 	
	w6.setBackground(null);
	w6.setOpaque(false);
 	
	
 	pn1.setLayout(card);
 	pn1.setBounds(0, 80, 1920, 1000);
    pn1.setBackground(null);
    pn1.setOpaque(false);

 	pn1.add("w1",w1);
	pn1.add("w2",w2);
	pn1.add("w3",w3);
	pn1.add("w4",w4);
	pn1.add("w5",w5);
	pn1.add("w6",w6);
	
	frame.add(pn1);
    
	frame.add(jb_close);
	jb_close.setBounds(1920-50, 20, 50, 50);
	jb_close.setIcon(new ImageIcon("img\\exit_idle.png"));
    jb_close.setBorder(null);
    jb_close.setContentAreaFilled(false);
    jb_close.setPressedIcon(new ImageIcon("img\\exit_ready.png"));
    jb_close.addMouseListener(new MouseListener() {
		@Override
		public void mouseEntered(MouseEvent e) {
			jb_close.setIcon(new ImageIcon("img\\exit_ready.png"));
		}

		@Override
		public void mouseExited(MouseEvent e) {
			jb_close.setIcon(new ImageIcon("img\\exit_idle.png"));
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			System.exit(0);
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
	
    frame.add(jb3);
    jb3.setBounds(270, 0, 250, 78);
    jb3.setFont(font);
    // 设置按钮的默认图片
    jb3.setIcon(new ImageIcon("img\\个人点击.png"));
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
        	card.show(pn1,"w6");
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
        	card.show(pn1,"w3");
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
        	card.show(pn1,"w2");
        	
        }
    });
    
    frame.add(jb8);
    jb8.setBounds(1520, 0, 250, 78);
    jb8.setFont(font);
    // 设置按钮的默认图片
    jb8.setIcon(new ImageIcon("img\\宿舍.png"));
    jb8.setBorder(null);
    // 添加按钮点击事件监听器
    jb8.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        	refresh();
        	jb8.setIcon(new ImageIcon("img\\宿舍点击.png"));
        	card.show(pn1,"w5");
        }
    });
    
	bgp=new BackgroundPanel((new ImageIcon("img\\bg2.png")).getImage());
	bgp.setBounds(0,0,1920,1080);
	frame.add(bgp);
	
	Toolkit kit = Toolkit.getDefaultToolkit();
  //Dimension dimension = kit.getScreenSize();
  //  frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
  //  frame.setBounds(0, 0, dimension.width, dimension.height);
   
    frame.setUndecorated(true);
 
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	frame.setSize(1920,1080);
	frame.setVisible(true);  
	frame.setResizable(true);
	}
	
	
	public InfoView_main(int id, Admin admin) {
		this.setLayout(null);
		this.setSize(1920,1080);         
	    this.setLocation(0, 0);

	    Font font=new Font("苹方 常规",Font.CENTER_BASELINE,28);//设置字体格式和大小

	 //*******************************
	 //此为一级容器
	    
	    CardLayout card=new CardLayout();
	 	JPanel pn1=new JPanel();
	 	
	 	Admin ad=new Admin();
	 	ad=admin;
	 	Winchange_test w1=new Winchange_test(id,ad);
	 	Winchange_JWC w2=new Winchange_JWC(id);
	 	Winchange_TSG w3=new Winchange_TSG(id);
	 	Winchange_shop w4=new Winchange_shop(id);
	 	Winchange_dorm w5=new Winchange_dorm(id,admin);
	 	Winchange_bank w6=new Winchange_bank(id,ad);
	 	
	 	w1.setBackground(null);
		w1.setOpaque(false);
	 	
	 	w2.setBackground(null);
		w2.setOpaque(false);
	 	
	 	w3.setBackground(null);
		w3.setOpaque(false);
		
		w4.setBackground(null);
		w4.setOpaque(false);
		
		w5.setBackground(null);
		w5.setOpaque(false);
	 	
		w6.setBackground(null);
		w6.setOpaque(false);
	 	
		
	 	pn1.setLayout(card);
	 	pn1.setBounds(0, 80, 1920, 1000);
	    pn1.setBackground(null);
	    pn1.setOpaque(false);

	 	pn1.add("w1",w1);
		pn1.add("w2",w2);
		pn1.add("w3",w3);
		pn1.add("w4",w4);
		pn1.add("w5",w5);
		pn1.add("w6",w6);
		
		frame.add(pn1);
	    
		frame.add(jb_close);
		jb_close.setBounds(1920-50, 20, 50, 50);
		jb_close.setIcon(new ImageIcon("img\\exit_idle.png"));
	    jb_close.setBorder(null);
	    jb_close.setContentAreaFilled(false);
	    jb_close.setPressedIcon(new ImageIcon("img\\exit_ready.png"));
	    jb_close.addMouseListener(new MouseListener() {
			@Override
			public void mouseEntered(MouseEvent e) {
				jb_close.setIcon(new ImageIcon("img\\exit_ready.png"));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				jb_close.setIcon(new ImageIcon("img\\exit_idle.png"));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
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
	    
	    frame.add(jb3);
	    jb3.setBounds(270, 0, 250, 78);
	    jb3.setFont(font);
	    // 设置按钮的默认图片
	    jb3.setIcon(new ImageIcon("img\\个人点击.png"));
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
	        	card.show(pn1,"w6");
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
	        	card.show(pn1,"w3");
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
	        	card.show(pn1,"w2");
	        	
	        }
	    });
	    
	    frame.add(jb8);
	    jb8.setBounds(1520, 0, 250, 78);
	    jb8.setFont(font);
	    // 设置按钮的默认图片
	    jb8.setIcon(new ImageIcon("img\\宿舍.png"));
	    jb8.setBorder(null);
	    // 添加按钮点击事件监听器
	    jb8.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	refresh();
	        	jb8.setIcon(new ImageIcon("img\\宿舍点击.png"));
	        	card.show(pn1,"w5");
	        }
	    });
	    
		bgp=new BackgroundPanel((new ImageIcon("img\\bg2.png")).getImage());
		bgp.setBounds(0,0,1920,1080);
		frame.add(bgp);
		
		Toolkit kit = Toolkit.getDefaultToolkit();
	  //Dimension dimension = kit.getScreenSize();
	  //  frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
	  //  frame.setBounds(0, 0, dimension.width, dimension.height);
	   
	    frame.setUndecorated(true);
	 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		frame.setSize(1920,1080);
		frame.setVisible(true);  
		frame.setResizable(true);
	}

	
	public InfoView_main(int id, Teacher cacheTeacher) {
		this.setLayout(null);
		this.setSize(1920,1080);         
	    this.setLocation(0, 0);

	    Font font=new Font("苹方 常规",Font.CENTER_BASELINE,28);//设置字体格式和大小

	 //*******************************
	 //此为一级容器
	    
	    CardLayout card=new CardLayout();
	 	JPanel pn1=new JPanel();
	 	
	 	Teacher tc = cacheTeacher;
	 	
	 	Winchange_test w1=new Winchange_test(id,tc);
	 	Winchange_JWC w2=new Winchange_JWC(id);
	 	Winchange_TSG w3=new Winchange_TSG(id);
	 	Winchange_shop w4=new Winchange_shop(id);
	 	//Winchange_dorm w5=new Winchange_dorm(id,tc);
	 	Winchange_bank w6=new Winchange_bank(id,tc);
	 	
	 	w1.setBackground(null);
		w1.setOpaque(false);
	 	
	 	w2.setBackground(null);
		w2.setOpaque(false);
	 	
	 	w3.setBackground(null);
		w3.setOpaque(false);
		
		w4.setBackground(null);
		w4.setOpaque(false);
		
		//w5.setBackground(null);
		//w5.setOpaque(false);
	 	
		w6.setBackground(null);
		w6.setOpaque(false);
	 	
		
	 	pn1.setLayout(card);
	 	pn1.setBounds(0, 80, 1920, 1000);
	    pn1.setBackground(null);
	    pn1.setOpaque(false);

	 	pn1.add("w1",w1);
		pn1.add("w2",w2);
		pn1.add("w3",w3);
		pn1.add("w4",w4);
		//pn1.add("w5",w5);
		pn1.add("w6",w6);
		
		frame.add(pn1);
	    
		frame.add(jb_close);
		jb_close.setBounds(1920-50, 20, 50, 50);
		jb_close.setIcon(new ImageIcon("img\\exit_idle.png"));
	    jb_close.setBorder(null);
	    jb_close.setContentAreaFilled(false);
	    jb_close.setPressedIcon(new ImageIcon("img\\exit_ready.png"));
	    jb_close.addMouseListener(new MouseListener() {
			@Override
			public void mouseEntered(MouseEvent e) {
				jb_close.setIcon(new ImageIcon("img\\exit_ready.png"));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				jb_close.setIcon(new ImageIcon("img\\exit_idle.png"));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
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
	    
	    frame.add(jb3);
	    jb3.setBounds(270, 0, 250, 78);
	    jb3.setFont(font);
	    // 设置按钮的默认图片
	    jb3.setIcon(new ImageIcon("img\\个人点击.png"));
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
	        	card.show(pn1,"w6");
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
	        	card.show(pn1,"w3");
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
	        	card.show(pn1,"w2");
	        	
	        }
	    });
	    
	    frame.add(jb8);
	    jb8.setBounds(1520, 0, 250, 78);
	    jb8.setFont(font);
	    // 设置按钮的默认图片
	    jb8.setIcon(new ImageIcon("img\\宿舍.png"));
	    jb8.setBorder(null);
	    // 添加按钮点击事件监听器
	    jb8.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	JOptionPane.showMessageDialog(null, "您没有入住校园宿舍");
	        	/*refresh();
	        	jb8.setIcon(new ImageIcon("img\\宿舍点击.png"));
	        	card.show(pn1,"w5");*/
	        }
	    });
	    
		bgp=new BackgroundPanel((new ImageIcon("img\\bg2.png")).getImage());
		bgp.setBounds(0,0,1920,1080);
		frame.add(bgp);
		
		Toolkit kit = Toolkit.getDefaultToolkit();
	  //Dimension dimension = kit.getScreenSize();
	  //  frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
	  //  frame.setBounds(0, 0, dimension.width, dimension.height);
	   
	    frame.setUndecorated(true);
	 
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
		jb8.setIcon(new ImageIcon("img\\宿舍.png"));
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