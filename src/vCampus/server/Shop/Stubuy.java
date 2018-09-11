package vCampus.server.Shop;
/**
 * @author Yanhao Shen
 * 
 * @date 9.3
 *
 */
import javax.swing.*;

import vCampus.client.biz.ShopService;
import vCampus.client.biz.ShopServiceImpl;
import vCampus.client.biz.StudentService;
import vCampus.client.biz.TeacherService;
import vCampus.vo.ProductInformation;
import vCampus.vo.ProductPurchase;

//import vCampus.client.register.RegisterView;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.*;

public class Stubuy extends JPanel{

		JButton bt1=new JButton("");
		JButton bt100 = new JButton("");
		
		Boolean new_drink;
		//CC；有新增 为1显示7个  否则显示6个
		
		public Stubuy(StudentService ss) {
			
		super();
		
		new_drink=false;
		
		String username = ss.getCacheStudent().getUserName();
		ShopService SPS = new ShopServiceImpl(1,username);
		ArrayList<ProductPurchase> PurchaseList = new ArrayList<ProductPurchase>();
		ArrayList<ProductInformation> ProductInfo = SPS.queryAllProduct();
		int NumberofProducts = SPS.queryAllProduct().size();
		for(int i= 0;i<NumberofProducts;i++) {
			ProductPurchase temp = new ProductPurchase();
			temp.setProductID(ProductInfo.get(i).getProductID());
			temp.setProductName(ProductInfo.get(i).getProductName());
			temp.setCurrentAccount(ProductInfo.get(i).getAmount());
			PurchaseList.add(temp);
		}
		
		
		this.setLayout(null);
		this.setSize(1650,1000);         
	    

		Font font=new Font("苹方 常规",Font.CENTER_BASELINE,28);//设置字体格式和大小
		Font font1=new Font("苹方 常规",Font.BOLD,32);//设置字体格式和大小
	    
		
	    bt1.setBounds(940, 829, 160, 80);
	    bt1.setFont(font);

	    bt1.setIcon(new ImageIcon("img\\确认.png"));
	    bt1.setBorder(null);
	    bt1.setBorderPainted(false);
	    bt1.setContentAreaFilled(false);
	    this.add(bt1);
	    
	    
	    //设置单价
	    JTextField tfp1=new JTextField("2.8");
	    tfp1.setBounds(330,271,100,100);
	    add(tfp1);
	    tfp1.setBorder(null);
	    tfp1.setEditable(false);
	    tfp1.setFont(font);
	    
	    JTextField tfp2=new JTextField("4.8");
	    tfp2.setBounds(330+420,271,100,100);
	    add(tfp2);
	    tfp2.setBorder(null);
	    tfp2.setEditable(false);
	    tfp2.setFont(font);
	    
	    JTextField tfp3=new JTextField("4");
	    tfp3.setBounds(330+420*2,271,100,100);
	    add(tfp3);
	    tfp3.setBorder(null);
	    tfp3.setEditable(false);
	    tfp3.setFont(font);
	    
	    JTextField tfp4=new JTextField("4");
	    tfp4.setBounds(330+420*3,271,100,100);
	    add(tfp4);
	    tfp4.setBorder(null);
	    tfp4.setEditable(false);
	    tfp4.setFont(font);
	    
	    
	    JTextField tfp5=new JTextField("3");
	    tfp5.setBounds(330,271+400,100,100);
	    add(tfp5);
	    tfp5.setBorder(null);
	    tfp5.setEditable(false);
	    tfp5.setFont(font);
	    
	    JTextField tfp6=new JTextField("3.5");
	    tfp6.setBounds(330+420,271+400,100,100);
	    add(tfp6);
	    tfp6.setBorder(null);
	    tfp6.setEditable(false);
	    tfp6.setFont(font);
	    
	    
		String s1;
		JLabel lb1 = null;
		s1="怡宝";
		lb1 = new JLabel(new ImageIcon("img\\怡宝.png")); //创建一个带图片的 JLabel
		
		
	    lb1.setBounds(80, 30, 240, 300); //设置 图片的横坐标、纵坐标、宽、高
	    this.add(lb1);
	   
	    
	   
	    
	    JButton bt11 = new JButton(""); 
	    bt11.setBounds(90, 351, 50, 40);
	   
	    bt11.setIcon(new ImageIcon("img\\-.png"));
	    bt11.setBorder(null);
	    bt11.setFocusPainted(false);
	    
	    bt11.addMouseListener(new MouseListener() {
			@Override
			public void mouseEntered(MouseEvent e) {
				bt11.setIcon(new ImageIcon("img\\-点击.png"));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				bt11.setIcon(new ImageIcon("img\\-.png"));
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

	   
	    add(bt11);
	    
	    JButton bt12 = new JButton("");
	    bt12.setBounds(263, 351,45,40);
	    bt12.setIcon(new ImageIcon("img\\+.png"));
	    bt12.setBorder(null);
	    bt12.setFocusPainted(false);
	    
	    bt12.addMouseListener(new MouseListener() {
			@Override
			public void mouseEntered(MouseEvent e) {
				bt12.setIcon(new ImageIcon("img\\+点击.png"));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				bt12.setIcon(new ImageIcon("img\\+.png"));
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
	    
	   
	    add(bt12);
	   
	    bt11.setContentAreaFilled(false);
	    bt12.setContentAreaFilled(false);
	    
	    bt100.setIcon(new ImageIcon("img\\结算.png"));
	    bt100.setBounds(736, 829,160,80);
	    add(bt100);
	    bt100.setContentAreaFilled(false);
	    bt100.setBorder(null);
	    bt100.setBorderPainted(false);
	    
	    
	    JTextField tf1=new JTextField("0");
	    tf1.setBounds(168,351,70,40);
	    add(tf1);
	    tf1.setFont(font);
	    
	   
	    

	    
	    bt11.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent arg0) {
	    		String s=tf1.getText();
	    		int i=Integer.parseInt(s);
	    		if(i==0)
	    			i=0;
	    		else
	    			i=i-1;
	    		s=i+"";
	    		tf1.setText(s);

	    		if(Integer.parseInt(tf1.getText()) == 0) {
	    			//PurchaseList.remove(0);
	    		}
	    		else {
	    			PurchaseList.get(0).setPurchaseAmount(Integer.parseInt(tf1.getText()));
	    		}

	    	}
	    });

	    bt12.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent arg0) {
	    		String s=tf1.getText();
	    		int i=Integer.parseInt(s)+1;
	    		s=i+"";
	    		tf1.setText(s);
	    		
	    		if(Integer.parseInt(tf1.getText())>PurchaseList.get(0).getCurrentAccount()) {
	    			tf1.setText("0");
	    			JOptionPane.showMessageDialog(null, "超出库存");
	    		}
	    		else {
	    			PurchaseList.get(0).setPurchaseAmount(Integer.parseInt(tf1.getText()));
	    		}
	    	}
	    	
	    });
	    
	    

	    

	    
	    
	    
	    
	    String s2;
		JLabel lb2 = null;
		s2="雀巢咖啡";
		lb2 = new JLabel(new ImageIcon("img\\雀巢咖啡.png")); //创建一个带图片的 JLabel
	    lb2.setBounds(80+420, 30, 240, 300); //设置 图片的横坐标、纵坐标、宽、高
	    this.add(lb2);
	   
	    JButton bt21 = new JButton("");
	   
	    
	    bt21.setBounds(90+420, 351, 45, 40);
	    
	    
	    bt21.setIcon(new ImageIcon("img\\-.png"));
	    bt21.setBorder(null);
	    bt21.setFocusPainted(false);
	    
	    bt21.addMouseListener(new MouseListener() {
			@Override
			public void mouseEntered(MouseEvent e) {
				bt21.setIcon(new ImageIcon("img\\-点击.png"));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				bt21.setIcon(new ImageIcon("img\\-.png"));
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
	   
	    
	    add(bt21);
	    
	    JButton bt22 = new JButton("");
	    bt22.setBounds(263+420, 351,45,40);
	    bt22.setIcon(new ImageIcon("img\\+.png"));
	    bt22.setBorder(null);
	    bt22.setFocusPainted(false);
	    
	    bt22.addMouseListener(new MouseListener() {
			@Override
			public void mouseEntered(MouseEvent e) {
				bt22.setIcon(new ImageIcon("img\\+点击.png"));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				bt22.setIcon(new ImageIcon("img\\+.png"));
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
	    add(bt22);
	   
	    bt21.setContentAreaFilled(false);
	    bt22.setContentAreaFilled(false);
	    
	    JTextField tf2=new JTextField("0");
	    tf2.setBounds(168+420,351,70,40);
	    add(tf2);
	    	    
	    bt21.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent arg0) {
	    		/*String s=tf2.getText();
	    		int i=Integer.parseInt(s);
	    		{if(i==0)
	    			i=0;
	    		else
	    			i=i-1;
	    		s=i+"";}
	    		tf2.setText(s);*/
	    		
	    		String s=tf2.getText();
	    		int i=Integer.parseInt(s);
	    		if(i==0)
	    			i=0;
	    		else
	    			i=i-1;
	    		s=i+"";
	    		tf2.setText(s);

	    		if(Integer.parseInt(tf2.getText()) == 0) {
	    			//PurchaseList.remove(1);
	    		}
	    		else {
	    			PurchaseList.get(1).setPurchaseAmount(Integer.parseInt(tf2.getText()));
	    		}

	    	}
	    });

	    bt22.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent arg0) {
	    		/*String s=tf2.getText();
	    		int i=Integer.parseInt(s)+1;
	    		s=i+"";
	    		tf2.setText(s);
	    		*/
	    		
	    		String s=tf2.getText();
	    		int i=Integer.parseInt(s)+1;
	    		s=i+"";
	    		tf2.setText(s);
	    		
	    		if(Integer.parseInt(tf2.getText())>PurchaseList.get(1).getCurrentAccount()) {
	    			tf2.setText("0");
	    			JOptionPane.showMessageDialog(null, "超出库存");
	    		}
	    		else {
	    			PurchaseList.get(1).setPurchaseAmount(Integer.parseInt(tf2.getText()));
	    		}
	    	}
	    });
	    
	    
	    
	    String s3;
		JLabel lb3 = null;
		s3="尖叫";
		lb3 = new JLabel(new ImageIcon("img\\尖叫.png")); //创建一个带图片的 JLabel
	    lb3.setBounds(80+420+420, 30, 240, 300); //设置 图片的横坐标、纵坐标、宽、高
	    this.add(lb3);
	   
	 
	    JButton bt31 = new JButton("");
	    bt31.setBounds(90+420+420, 351, 45, 40);
	    bt31.setIcon(new ImageIcon("img\\-.png"));
	    bt31.setBorder(null);
	    bt31.setFocusPainted(false);
	    
	    bt31.addMouseListener(new MouseListener() {
			@Override
			public void mouseEntered(MouseEvent e) {
				bt31.setIcon(new ImageIcon("img\\-点击.png"));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				bt31.setIcon(new ImageIcon("img\\-.png"));
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
	    //System.out.println("444");
	    add(bt31);
	    
	    JButton bt32 = new JButton("");
	    bt32.setBounds(263+420+420, 351,45,40);
	    bt32.setIcon(new ImageIcon("img\\+.png"));
	    bt32.setBorder(null);
	    bt32.setFocusPainted(false);
	    
	    bt32.addMouseListener(new MouseListener() {
			@Override
			public void mouseEntered(MouseEvent e) {
				bt32.setIcon(new ImageIcon("img\\+点击.png"));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				bt32.setIcon(new ImageIcon("img\\+.png"));
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
	    add(bt32);
	   
	    bt31.setContentAreaFilled(false);
	    bt32.setContentAreaFilled(false);
	    
	    JTextField tf3=new JTextField("0");
	    tf3.setBounds(168+420+420,351,70,40);
	    add(tf3);
	    
	    bt31.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent arg0) {
	    		/*String s=tf3.getText();
	    		int i=Integer.parseInt(s);
	    		if(i==0)
	    			i=0;
	    		else
	    			i=i-1;
	    		s=i+"";
	    		tf3.setText(s);*/
	    		String s=tf3.getText();
	    		int i=Integer.parseInt(s);
	    		if(i==0)
	    			i=0;
	    		else
	    			i=i-1;
	    		s=i+"";
	    		tf3.setText(s);

	    		if(Integer.parseInt(tf3.getText()) == 0) {
	    			//PurchaseList.remove(2);
	    		}
	    		else {
	    			PurchaseList.get(2).setPurchaseAmount(Integer.parseInt(tf3.getText()));
	    		}
	    	}
	    });

	    bt32.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent arg0) {
	    		/*String s=tf3.getText();
	    		int i=Integer.parseInt(s)+1;
	    		s=i+"";
	    		tf3.setText(s);*/
	    		String s=tf3.getText();
	    		int i=Integer.parseInt(s)+1;
	    		s=i+"";
	    		tf3.setText(s);
	    		
	    		if(Integer.parseInt(tf3.getText())>PurchaseList.get(2).getCurrentAccount()) {
	    			tf3.setText("0");
	    			JOptionPane.showMessageDialog(null, "超出库存");
	    		}
	    		else {
	    			PurchaseList.get(2).setPurchaseAmount(Integer.parseInt(tf3.getText()));
	    		}
	    	}
	    });
	    
	    
	    
	    
	    String s4;
		JLabel lb4 = null;
		s4="红牛";
		lb4 = new JLabel(new ImageIcon("img\\红牛.png")); //创建一个带图片的 JLabel
	    lb4.setBounds(80+420*3, 30, 240, 300); //设置 图片的横坐标、纵坐标、宽、高
	    this.add(lb4);
	   
	 
	    JButton bt41 = new JButton("");
	    bt41.setBounds(90+420*3, 351, 45, 40);
	    bt41.setIcon(new ImageIcon("img\\-.png"));
	    bt41.setBorder(null);
	    bt41.setFocusPainted(false);
	    
	    bt41.addMouseListener(new MouseListener() {
			@Override
			public void mouseEntered(MouseEvent e) {
				bt41.setIcon(new ImageIcon("img\\-点击.png"));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				bt41.setIcon(new ImageIcon("img\\-.png"));
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
	    //System.out.println("444");
	    add(bt41);
	    
	    JButton bt42 = new JButton("");
	    bt42.setBounds(263+420*3, 351,45,40);
	    bt42.setIcon(new ImageIcon("img\\+.png"));
	    bt42.setBorder(null);
	    bt42.setFocusPainted(false);
	    
	    bt42.addMouseListener(new MouseListener() {
			@Override
			public void mouseEntered(MouseEvent e) {
				bt42.setIcon(new ImageIcon("img\\+点击.png"));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				bt42.setIcon(new ImageIcon("img\\+.png"));
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
	    add(bt42);
	   
	    bt41.setContentAreaFilled(false);
	    bt42.setContentAreaFilled(false);
	    
	    JTextField tf4=new JTextField("0");
	    tf4.setBounds(168+420*3,351,70,40);
	    add(tf4);
	    
	    bt41.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent arg0) {
	    		/*String s=tf4.getText();
	    		int i=Integer.parseInt(s);
	    		if(i==0)
	    			i=0;
	    		else
	    			i=i-1;
	    		s=i+"";
	    		tf4.setText(s);*/
	    		String s=tf4.getText();
	    		int i=Integer.parseInt(s);
	    		if(i==0)
	    			i=0;
	    		else
	    			i=i-1;
	    		s=i+"";
	    		tf4.setText(s);

	    		if(Integer.parseInt(tf4.getText()) == 0) {
	    			//PurchaseList.remove(3);
	    		}
	    		else {
	    			PurchaseList.get(3).setPurchaseAmount(Integer.parseInt(tf4.getText()));
	    		}
	    	}
	    });

	    bt42.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent arg0) {
	    		/*String s=tf4.getText();
	    		int i=Integer.parseInt(s)+1;
	    		s=i+"";
	    		tf4.setText(s);*/
	    		String s=tf4.getText();
	    		int i=Integer.parseInt(s)+1;
	    		s=i+"";
	    		tf4.setText(s);
	    		
	    		if(Integer.parseInt(tf4.getText())>PurchaseList.get(3).getCurrentAccount()) {
	    			tf4.setText("0");
	    			JOptionPane.showMessageDialog(null, "超出库存");
	    		}
	    		else {
	    			PurchaseList.get(3).setPurchaseAmount(Integer.parseInt(tf4.getText()));
	    		}
	    	}
	    });
	    
	    
	    String s5;
		JLabel lb5 = null;
		s5="冰红茶";
		lb5 = new JLabel(new ImageIcon("img\\冰红茶.png")); //创建一个带图片的 JLabel
	    lb5.setBounds(80, 30+400, 240, 300); //设置 图片的横坐标、纵坐标、宽、高
	    this.add(lb5);
	   
	 
	    JButton bt51 = new JButton("");
	    bt51.setBounds(90, 351+400, 45, 40);
	    bt51.setIcon(new ImageIcon("img\\-.png"));
	    bt51.setBorder(null);
	    bt51.setFocusPainted(false);
	    
	    bt51.addMouseListener(new MouseListener() {
			@Override
			public void mouseEntered(MouseEvent e) {
				bt51.setIcon(new ImageIcon("img\\-点击.png"));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				bt51.setIcon(new ImageIcon("img\\-.png"));
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
	    //System.out.println("444");
	    add(bt51);
	    
	    JButton bt52 = new JButton("");
	    bt52.setBounds(263, 351+400,45,40);
	    bt52.setIcon(new ImageIcon("img\\+.png"));
	    bt52.setBorder(null);
	    bt52.setFocusPainted(false);
	    
	    bt52.addMouseListener(new MouseListener() {
			@Override
			public void mouseEntered(MouseEvent e) {
				bt52.setIcon(new ImageIcon("img\\+点击.png"));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				bt52.setIcon(new ImageIcon("img\\+.png"));
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
	    add(bt52);
	   
	    bt51.setContentAreaFilled(false);
	    bt52.setContentAreaFilled(false);
	    
	    JTextField tf5=new JTextField("0");
	    tf5.setBounds(168,351+400,70,40);
	    add(tf5);
	    
	    bt51.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent arg0) {
	    		/*String s=tf5.getText();
	    		int i=Integer.parseInt(s);
	    		if(i==0)
	    			i=0;
	    		else
	    			i=i-1;
	    		s=i+"";
	    		tf5.setText(s);*/
	    		String s=tf5.getText();
	    		int i=Integer.parseInt(s);
	    		if(i==0)
	    			i=0;
	    		else
	    			i=i-1;
	    		s=i+"";
	    		tf5.setText(s);

	    		if(Integer.parseInt(tf5.getText()) == 0) {
	    			//PurchaseList.remove(4);
	    		}
	    		else {
	    			PurchaseList.get(4).setPurchaseAmount(Integer.parseInt(tf5.getText()));
	    		}
	    	}
	    });

	    bt52.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent arg0) {
	    		/*String s=tf5.getText();
	    		int i=Integer.parseInt(s)+1;
	    		s=i+"";
	    		tf5.setText(s);*/
	    		String s=tf5.getText();
	    		int i=Integer.parseInt(s)+1;
	    		s=i+"";
	    		tf5.setText(s);
	    		
	    		if(Integer.parseInt(tf5.getText())>PurchaseList.get(4).getCurrentAccount()) {
	    			tf5.setText("0");
	    			JOptionPane.showMessageDialog(null, "超出库存");
	    		}
	    		else {
	    			PurchaseList.get(4).setPurchaseAmount(Integer.parseInt(tf5.getText()));
	    		}
	    	}
	    });
	    
	    
	    String s6;
		JLabel lb6 = null;
		s6="可口可乐";
		lb6 = new JLabel(new ImageIcon("img\\可口可乐.png")); //创建一个带图片的 JLabel
	    lb6.setBounds(80+420, 30+400, 240, 300); //设置 图片的横坐标、纵坐标、宽、高
	    this.add(lb6);
	   
	    JButton bt61 = new JButton("");
	    bt61.setBounds(90+420, 351+400, 45, 40);
	    bt61.setIcon(new ImageIcon("img\\-.png"));
	    bt61.setBorder(null);
	    bt61.setFocusPainted(false);
	    
	    bt61.addMouseListener(new MouseListener() {
			@Override
			public void mouseEntered(MouseEvent e) {
				bt61.setIcon(new ImageIcon("img\\-点击.png"));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				bt61.setIcon(new ImageIcon("img\\-.png"));
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
	    //System.out.println("444");
	    add(bt61);
	    
	    JButton bt62 = new JButton("");
	    bt62.setBounds(263+420, 351+400,45,40);
	    bt62.setIcon(new ImageIcon("img\\+.png"));
	    bt62.setBorder(null);
	    bt62.setFocusPainted(false);
	    
	    bt62.addMouseListener(new MouseListener() {
			@Override
			public void mouseEntered(MouseEvent e) {
				bt62.setIcon(new ImageIcon("img\\+点击.png"));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				bt62.setIcon(new ImageIcon("img\\+.png"));
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
	    add(bt62);
	   
	    bt61.setContentAreaFilled(false);
	    bt62.setContentAreaFilled(false);
	    
	    JTextField tf6=new JTextField("0");
	    tf6.setBounds(168+420,351+400,70,40);
	    add(tf6);
	    
	    //算钱
	    JTextField tf100=new JTextField("0");
	    add(tf100);
	    tf100.setBounds(589,835,126,68);
	    tf100.setFont(font);
	   
	    bt61.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent arg0) {
	    		/*String s=tf6.getText();
	    		int i=Integer.parseInt(s);
	    		if(i==0)
	    			i=0;
	    		else
	    			i=i-1;
	    		s=i+"";
	    		tf6.setText(s);*/
	    		String s=tf6.getText();
	    		int i=Integer.parseInt(s);
	    		if(i==0)
	    			i=0;
	    		else
	    			i=i-1;
	    		s=i+"";
	    		tf6.setText(s);

	    		if(Integer.parseInt(tf6.getText()) == 0) {
	    			//PurchaseList.remove(5);
	    		}
	    		else {
	    			PurchaseList.get(4).setPurchaseAmount(Integer.parseInt(tf5.getText()));
	    		}
	    	}
	    });

	    bt62.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent arg0) {
	    		/*String s=tf6.getText();
	    		int i=Integer.parseInt(s)+1;
	    		s=i+"";
	    		tf6.setText(s);*/
	    		String s=tf6.getText();
	    		int i=Integer.parseInt(s)+1;
	    		s=i+"";
	    		tf6.setText(s);
	    		
	    		if(Integer.parseInt(tf6.getText())>PurchaseList.get(5).getCurrentAccount()) {
	    			tf6.setText("0");
	    			JOptionPane.showMessageDialog(null, "超出库存");
	    		}
	    		else {
	    			PurchaseList.get(5).setPurchaseAmount(Integer.parseInt(tf6.getText()));
	    		}
	    	}
	    });
	    


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
				 int numberofProducts = PurchaseList.size();
				 int i= 0;
				 for(;i<numberofProducts;i++) {
					 PurchaseList.get(i).setUserName(username);
					 if(SPS.buyProduct(PurchaseList.get(i), 0)==false) {
						 JOptionPane.showMessageDialog(null, SPS.getExceptionCodes());
						 break;
					 }
				 }
				 if(i==numberofProducts) {
					 JOptionPane.showMessageDialog(null, "购买成功");
					 //ss.updateInfo(ss.getCacheStudent());
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
	   
	  

	    bt100.addMouseListener(new MouseListener() {
			@Override
			public void mouseEntered(MouseEvent e) {
				bt100.setIcon(new ImageIcon("img\\结算点击.png"));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				bt100.setIcon(new ImageIcon("img\\结算.png"));
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
	   
	  
	    

	    
/*	    
	    String s7;
		JLabel lb7 = null;
		s5="新增";
		lb7 = new JLabel(new ImageIcon("img\\冰红茶.png")); //创建一个带图片的 JLabel
	    lb7.setBounds(80+420*2, 30+400, 240, 300); //设置 图片的横坐标、纵坐标、宽、高
	   
	   
	    
	    JTextField tfp7=new JTextField("4");
	    tfp7.setBounds(330+420*2,400+271,100,100);
	    
	    tfp7.setBorder(null);
	    tfp7.setEditable(false);
	    tfp7.setFont(font);
	 
	    JButton bt71 = new JButton("");
	    bt71.setBounds(90+420*2, 400+351, 45, 40);
	    bt71.setIcon(new ImageIcon("img\\-.png"));
	    bt71.setBorder(null);
	    bt71.setFocusPainted(false);
	    
	    bt41.addMouseListener(new MouseListener() {
			@Override
			public void mouseEntered(MouseEvent e) {
				bt71.setIcon(new ImageIcon("img\\-点击.png"));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				bt71.setIcon(new ImageIcon("img\\-.png"));
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
	    
	    JButton bt72 = new JButton("");
	    bt72.setBounds(263+420*2, 400+351,45,40);
	    bt72.setIcon(new ImageIcon("img\\+.png"));
	    bt72.setBorder(null);
	    bt72.setFocusPainted(false);
	    
	    bt72.addMouseListener(new MouseListener() {
			@Override
			public void mouseEntered(MouseEvent e) {
				bt72.setIcon(new ImageIcon("img\\+点击.png"));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				bt72.setIcon(new ImageIcon("img\\+.png"));
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


	    
	    bt71.setContentAreaFilled(false);
	    bt72.setContentAreaFilled(false);
	    
	    
	   
	    JTextField tf7=new JTextField("0");
	    tf7.setBounds(168+420*2,400+351,70,40);
	   
	    bt71.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent arg0) {
	    		String s=tf7.getText();
	    		int i=Integer.parseInt(s);
	    		if(i==0)
	    			i=0;
	    		else
	    			i=i-1;
	    		s=i+"";
	    		tf7.setText(s);
	    	}
	    });

	    bt72.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent arg0) {
	    		String s=tf7.getText();
	    		int i=Integer.parseInt(s)+1;
	    		s=i+"";
	    		tf7.setText(s);
	    	}
	    });
	    
	    
	    //cc:新增饮料
	    if(new_drink) {
	    	this.add(lb7);
		    add(lb7);
		    add(bt71);
		    add(bt72);
		    add(tfp7);
		    add(tf7);
		    add(tfp7);
		    add(tf7);	
	    } 
*/	    
	    tf2.setFont(font);
	    tf3.setFont(font);
	    tf4.setFont(font);
	    tf5.setFont(font);
	    tf6.setFont(font);
	    //tf7.setFont(font);
	  
	    bt100.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent arg0) {
	    		
	    		String result=tf100.getText();
	    		double i100=Double.parseDouble(result);
	    	    int i1 = Integer.parseInt(tf1.getText());
	    	    int i2 = Integer.parseInt(tf2.getText());
	    	    int i3 = Integer.parseInt(tf3.getText());
	    	    int i4 = Integer.parseInt(tf4.getText());
	    	    int i5 = Integer.parseInt(tf5.getText());
	    	    int i6 = Integer.parseInt(tf6.getText());
	    	    //int i7 = Integer.parseInt(tf7.getText());

	    	    Double p1 = Double.parseDouble(tfp1.getText());
	    	    Double p2 = Double.parseDouble(tfp2.getText());
	    	    Double p3 = Double.parseDouble(tfp3.getText());
	    	    Double p4 = Double.parseDouble(tfp4.getText());
	    	    Double p5 = Double.parseDouble(tfp5.getText());
	    	    Double p6 = Double.parseDouble(tfp6.getText());
	    	    //Double p7 = Double.parseDouble(tfp7.getText());
	    	    
	    	    PurchaseList.get(0).setOneConsumption(i1*p1);
	    	    PurchaseList.get(1).setOneConsumption(i2*p2);
	    	    PurchaseList.get(2).setOneConsumption(i3*p3);
	    	    PurchaseList.get(3).setOneConsumption(i4*p4);
	    	    PurchaseList.get(4).setOneConsumption(i5*p5);
	    	    PurchaseList.get(5).setOneConsumption(i6*p6); 
	    	    
	    		i100=i1*p1+i2*p2+i3*p3+i4*p4+i5*p5+i6*p6;
	    		i100 = (double)Math.round(i100*100)/100;
	    		if(i100>ss.getCacheStudent().getMoney()) {
	    			result=i100+"";
		    		tf100.setText(result);
	    			JOptionPane.showMessageDialog(null, "超出您的余额");
	    			bt1.setEnabled(false);
	    		}
	    		else {
	    			result=i100+"";
		    		tf100.setText(result);
	    		}
	    		
	    		
	    		if(i6==0) PurchaseList.remove(5);
	    		else PurchaseList.get(5).setOneConsumption(i6);
	    		if(i5==0) PurchaseList.remove(4);
	    		else PurchaseList.get(4).setOneConsumption(i5);
	    		if(i4==0) PurchaseList.remove(3);
	    		else PurchaseList.get(3).setOneConsumption(i4);
	    		if(i3==0) PurchaseList.remove(2);
	    		else PurchaseList.get(2).setOneConsumption(i3);
	    		if(i2==0) PurchaseList.remove(1);
	    		else PurchaseList.get(1).setOneConsumption(i2);
	    		if(i1==0) PurchaseList.remove(0);
	    		else PurchaseList.get(0).setOneConsumption(i1);
	    		
	    		
	    		
	    		
	    		
	    	}
	    	
	    });
	    
	    
	   }


		public Stubuy(TeacherService tc) {
			// TODO Auto-generated constructor stub
			
			super();
			
			new_drink=false;
			
			String username = tc.getCacheTeacher().getUserName();
			ShopService SPS = new ShopServiceImpl(2,username);
			ArrayList<ProductPurchase> PurchaseList = new ArrayList<ProductPurchase>();
			ArrayList<ProductInformation> ProductInfo = SPS.queryAllProduct();
			int NumberofProducts = SPS.queryAllProduct().size();
			for(int i= 0;i<NumberofProducts;i++) {
				ProductPurchase temp = new ProductPurchase();
				temp.setProductID(ProductInfo.get(i).getProductID());
				temp.setProductName(ProductInfo.get(i).getProductName());
				temp.setCurrentAccount(ProductInfo.get(i).getAmount());
				PurchaseList.add(temp);
			}
			
			JButton bt1=new JButton("");
			bt1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				}
			});
			
			this.setLayout(null);
			this.setSize(1650,1000);         
		    

			Font font=new Font("苹方 常规",Font.CENTER_BASELINE,28);//设置字体格式和大小
			Font font1=new Font("苹方 常规",Font.BOLD,32);//设置字体格式和大小
		    
			
		    bt1.setBounds(940, 829, 160, 80);
		    bt1.setFont(font);

		    bt1.setIcon(new ImageIcon("img\\确认.png"));
		    bt1.setBorder(null);
		    bt1.setBorderPainted(false);
		    bt1.setContentAreaFilled(false);
		    this.add(bt1);
		    bt1.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
				}
		    	
		    });
		    
		    
		    //设置单价
		    JTextField tfp1=new JTextField("2.8");
		    tfp1.setBounds(330,271,100,100);
		    add(tfp1);
		    tfp1.setBorder(null);
		    tfp1.setEditable(false);
		    tfp1.setFont(font);
		    
		    JTextField tfp2=new JTextField("4.8");
		    tfp2.setBounds(330+420,271,100,100);
		    add(tfp2);
		    tfp2.setBorder(null);
		    tfp2.setEditable(false);
		    tfp2.setFont(font);
		    
		    JTextField tfp3=new JTextField("4");
		    tfp3.setBounds(330+420*2,271,100,100);
		    add(tfp3);
		    tfp3.setBorder(null);
		    tfp3.setEditable(false);
		    tfp3.setFont(font);
		    
		    JTextField tfp4=new JTextField("4");
		    tfp4.setBounds(330+420*3,271,100,100);
		    add(tfp4);
		    tfp4.setBorder(null);
		    tfp4.setEditable(false);
		    tfp4.setFont(font);
		    
		    
		    JTextField tfp5=new JTextField("3");
		    tfp5.setBounds(330,271+400,100,100);
		    add(tfp5);
		    tfp5.setBorder(null);
		    tfp5.setEditable(false);
		    tfp5.setFont(font);
		    
		    JTextField tfp6=new JTextField("3.5");
		    tfp6.setBounds(330+420,271+400,100,100);
		    add(tfp6);
		    tfp6.setBorder(null);
		    tfp6.setEditable(false);
		    tfp6.setFont(font);
		    
		    
			String s1;
			JLabel lb1 = null;
			s1="怡宝";
			lb1 = new JLabel(new ImageIcon("img\\怡宝.png")); //创建一个带图片的 JLabel
			
			
		    lb1.setBounds(80, 30, 240, 300); //设置 图片的横坐标、纵坐标、宽、高
		    this.add(lb1);
		   
		    
		   
		    
		    JButton bt11 = new JButton(""); 
		    bt11.setBounds(90, 351, 50, 40);
		   
		    bt11.setIcon(new ImageIcon("img\\-.png"));
		    bt11.setBorder(null);
		    bt11.setFocusPainted(false);
		    
		    bt11.addMouseListener(new MouseListener() {
				@Override
				public void mouseEntered(MouseEvent e) {
					bt11.setIcon(new ImageIcon("img\\-点击.png"));
				}

				@Override
				public void mouseExited(MouseEvent e) {
					bt11.setIcon(new ImageIcon("img\\-.png"));
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

		   
		    add(bt11);
		    
		    JButton bt12 = new JButton("");
		    bt12.setBounds(263, 351,45,40);
		    bt12.setIcon(new ImageIcon("img\\+.png"));
		    bt12.setBorder(null);
		    bt12.setFocusPainted(false);
		    
		    bt12.addMouseListener(new MouseListener() {
				@Override
				public void mouseEntered(MouseEvent e) {
					bt12.setIcon(new ImageIcon("img\\+点击.png"));
				}

				@Override
				public void mouseExited(MouseEvent e) {
					bt12.setIcon(new ImageIcon("img\\+.png"));
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
		    
		   
		    add(bt12);
		   
		    bt11.setContentAreaFilled(false);
		    bt12.setContentAreaFilled(false);
		    
		    bt100.setIcon(new ImageIcon("img\\结算.png"));
		    bt100.setBounds(736, 829,160,80);
		    add(bt100);
		    bt100.setContentAreaFilled(false);
		    bt100.setBorder(null);
		    bt100.setBorderPainted(false);
		    
		    
		    JTextField tf1=new JTextField("0");
		    tf1.setBounds(168,351,70,40);
		    add(tf1);
		    tf1.setFont(font);
		    
		   
		    

		    
		    bt11.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent arg0) {
		    		String s=tf1.getText();
		    		int i=Integer.parseInt(s);
		    		if(i==0)
		    			i=0;
		    		else
		    			i=i-1;
		    		s=i+"";
		    		tf1.setText(s);

		    		if(Integer.parseInt(tf1.getText()) == 0) {
		    			//PurchaseList.remove(0);
		    		}
		    		else {
		    			PurchaseList.get(0).setPurchaseAmount(Integer.parseInt(tf1.getText()));
		    		}

		    	}
		    });

		    bt12.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent arg0) {
		    		String s=tf1.getText();
		    		int i=Integer.parseInt(s)+1;
		    		s=i+"";
		    		tf1.setText(s);
		    		
		    		if(Integer.parseInt(tf1.getText())>PurchaseList.get(0).getCurrentAccount()) {
		    			tf1.setText("0");
		    			JOptionPane.showMessageDialog(null, "超出库存");
		    		}
		    		else {
		    			PurchaseList.get(0).setPurchaseAmount(Integer.parseInt(tf1.getText()));
		    		}
		    	}
		    	
		    });
		    
		    

		    

		    
		    
		    
		    
		    String s2;
			JLabel lb2 = null;
			s2="雀巢咖啡";
			lb2 = new JLabel(new ImageIcon("img\\雀巢咖啡.png")); //创建一个带图片的 JLabel
		    lb2.setBounds(80+420, 30, 240, 300); //设置 图片的横坐标、纵坐标、宽、高
		    this.add(lb2);
		   
		    JButton bt21 = new JButton("");
		   
		    
		    bt21.setBounds(90+420, 351, 45, 40);
		    
		    
		    bt21.setIcon(new ImageIcon("img\\-.png"));
		    bt21.setBorder(null);
		    bt21.setFocusPainted(false);
		    
		    bt21.addMouseListener(new MouseListener() {
				@Override
				public void mouseEntered(MouseEvent e) {
					bt21.setIcon(new ImageIcon("img\\-点击.png"));
				}

				@Override
				public void mouseExited(MouseEvent e) {
					bt21.setIcon(new ImageIcon("img\\-.png"));
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
		   
		    
		    add(bt21);
		    
		    JButton bt22 = new JButton("");
		    bt22.setBounds(263+420, 351,45,40);
		    bt22.setIcon(new ImageIcon("img\\+.png"));
		    bt22.setBorder(null);
		    bt22.setFocusPainted(false);
		    
		    bt22.addMouseListener(new MouseListener() {
				@Override
				public void mouseEntered(MouseEvent e) {
					bt22.setIcon(new ImageIcon("img\\+点击.png"));
				}

				@Override
				public void mouseExited(MouseEvent e) {
					bt22.setIcon(new ImageIcon("img\\+.png"));
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
		    add(bt22);
		   
		    bt21.setContentAreaFilled(false);
		    bt22.setContentAreaFilled(false);
		    
		    JTextField tf2=new JTextField("0");
		    tf2.setBounds(168+420,351,70,40);
		    add(tf2);
		    	    
		    bt21.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent arg0) {
		    		/*String s=tf2.getText();
		    		int i=Integer.parseInt(s);
		    		{if(i==0)
		    			i=0;
		    		else
		    			i=i-1;
		    		s=i+"";}
		    		tf2.setText(s);*/
		    		
		    		String s=tf2.getText();
		    		int i=Integer.parseInt(s);
		    		if(i==0)
		    			i=0;
		    		else
		    			i=i-1;
		    		s=i+"";
		    		tf2.setText(s);

		    		if(Integer.parseInt(tf2.getText()) == 0) {
		    			//PurchaseList.remove(1);
		    		}
		    		else {
		    			PurchaseList.get(1).setPurchaseAmount(Integer.parseInt(tf2.getText()));
		    		}

		    	}
		    });

		    bt22.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent arg0) {
		    		/*String s=tf2.getText();
		    		int i=Integer.parseInt(s)+1;
		    		s=i+"";
		    		tf2.setText(s);
		    		*/
		    		
		    		String s=tf2.getText();
		    		int i=Integer.parseInt(s)+1;
		    		s=i+"";
		    		tf2.setText(s);
		    		
		    		if(Integer.parseInt(tf2.getText())>PurchaseList.get(1).getCurrentAccount()) {
		    			tf2.setText("0");
		    			JOptionPane.showMessageDialog(null, "超出库存");
		    		}
		    		else {
		    			PurchaseList.get(1).setPurchaseAmount(Integer.parseInt(tf2.getText()));
		    		}
		    	}
		    });
		    
		    
		    
		    String s3;
			JLabel lb3 = null;
			s3="尖叫";
			lb3 = new JLabel(new ImageIcon("img\\尖叫.png")); //创建一个带图片的 JLabel
		    lb3.setBounds(80+420+420, 30, 240, 300); //设置 图片的横坐标、纵坐标、宽、高
		    this.add(lb3);
		   
		 
		    JButton bt31 = new JButton("");
		    bt31.setBounds(90+420+420, 351, 45, 40);
		    bt31.setIcon(new ImageIcon("img\\-.png"));
		    bt31.setBorder(null);
		    bt31.setFocusPainted(false);
		    
		    bt31.addMouseListener(new MouseListener() {
				@Override
				public void mouseEntered(MouseEvent e) {
					bt31.setIcon(new ImageIcon("img\\-点击.png"));
				}

				@Override
				public void mouseExited(MouseEvent e) {
					bt31.setIcon(new ImageIcon("img\\-.png"));
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
		    //System.out.println("444");
		    add(bt31);
		    
		    JButton bt32 = new JButton("");
		    bt32.setBounds(263+420+420, 351,45,40);
		    bt32.setIcon(new ImageIcon("img\\+.png"));
		    bt32.setBorder(null);
		    bt32.setFocusPainted(false);
		    
		    bt32.addMouseListener(new MouseListener() {
				@Override
				public void mouseEntered(MouseEvent e) {
					bt32.setIcon(new ImageIcon("img\\+点击.png"));
				}

				@Override
				public void mouseExited(MouseEvent e) {
					bt32.setIcon(new ImageIcon("img\\+.png"));
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
		    add(bt32);
		   
		    bt31.setContentAreaFilled(false);
		    bt32.setContentAreaFilled(false);
		    
		    JTextField tf3=new JTextField("0");
		    tf3.setBounds(168+420+420,351,70,40);
		    add(tf3);
		    
		    bt31.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent arg0) {
		    		/*String s=tf3.getText();
		    		int i=Integer.parseInt(s);
		    		if(i==0)
		    			i=0;
		    		else
		    			i=i-1;
		    		s=i+"";
		    		tf3.setText(s);*/
		    		String s=tf3.getText();
		    		int i=Integer.parseInt(s);
		    		if(i==0)
		    			i=0;
		    		else
		    			i=i-1;
		    		s=i+"";
		    		tf3.setText(s);

		    		if(Integer.parseInt(tf3.getText()) == 0) {
		    			//PurchaseList.remove(2);
		    		}
		    		else {
		    			PurchaseList.get(2).setPurchaseAmount(Integer.parseInt(tf3.getText()));
		    		}
		    	}
		    });

		    bt32.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent arg0) {
		    		/*String s=tf3.getText();
		    		int i=Integer.parseInt(s)+1;
		    		s=i+"";
		    		tf3.setText(s);*/
		    		String s=tf3.getText();
		    		int i=Integer.parseInt(s)+1;
		    		s=i+"";
		    		tf3.setText(s);
		    		
		    		if(Integer.parseInt(tf3.getText())>PurchaseList.get(2).getCurrentAccount()) {
		    			tf3.setText("0");
		    			JOptionPane.showMessageDialog(null, "超出库存");
		    		}
		    		else {
		    			PurchaseList.get(2).setPurchaseAmount(Integer.parseInt(tf3.getText()));
		    		}
		    	}
		    });
		    
		    
		    
		    
		    String s4;
			JLabel lb4 = null;
			s4="红牛";
			lb4 = new JLabel(new ImageIcon("img\\红牛.png")); //创建一个带图片的 JLabel
		    lb4.setBounds(80+420*3, 30, 240, 300); //设置 图片的横坐标、纵坐标、宽、高
		    this.add(lb4);
		   
		 
		    JButton bt41 = new JButton("");
		    bt41.setBounds(90+420*3, 351, 45, 40);
		    bt41.setIcon(new ImageIcon("img\\-.png"));
		    bt41.setBorder(null);
		    bt41.setFocusPainted(false);
		    
		    bt41.addMouseListener(new MouseListener() {
				@Override
				public void mouseEntered(MouseEvent e) {
					bt41.setIcon(new ImageIcon("img\\-点击.png"));
				}

				@Override
				public void mouseExited(MouseEvent e) {
					bt41.setIcon(new ImageIcon("img\\-.png"));
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
		    //System.out.println("444");
		    add(bt41);
		    
		    JButton bt42 = new JButton("");
		    bt42.setBounds(263+420*3, 351,45,40);
		    bt42.setIcon(new ImageIcon("img\\+.png"));
		    bt42.setBorder(null);
		    bt42.setFocusPainted(false);
		    
		    bt42.addMouseListener(new MouseListener() {
				@Override
				public void mouseEntered(MouseEvent e) {
					bt42.setIcon(new ImageIcon("img\\+点击.png"));
				}

				@Override
				public void mouseExited(MouseEvent e) {
					bt42.setIcon(new ImageIcon("img\\+.png"));
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
		    add(bt42);
		   
		    bt41.setContentAreaFilled(false);
		    bt42.setContentAreaFilled(false);
		    
		    JTextField tf4=new JTextField("0");
		    tf4.setBounds(168+420*3,351,70,40);
		    add(tf4);
		    
		    bt41.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent arg0) {
		    		/*String s=tf4.getText();
		    		int i=Integer.parseInt(s);
		    		if(i==0)
		    			i=0;
		    		else
		    			i=i-1;
		    		s=i+"";
		    		tf4.setText(s);*/
		    		String s=tf4.getText();
		    		int i=Integer.parseInt(s);
		    		if(i==0)
		    			i=0;
		    		else
		    			i=i-1;
		    		s=i+"";
		    		tf4.setText(s);

		    		if(Integer.parseInt(tf4.getText()) == 0) {
		    			//PurchaseList.remove(3);
		    		}
		    		else {
		    			PurchaseList.get(3).setPurchaseAmount(Integer.parseInt(tf4.getText()));
		    		}
		    	}
		    });

		    bt42.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent arg0) {
		    		/*String s=tf4.getText();
		    		int i=Integer.parseInt(s)+1;
		    		s=i+"";
		    		tf4.setText(s);*/
		    		String s=tf4.getText();
		    		int i=Integer.parseInt(s)+1;
		    		s=i+"";
		    		tf4.setText(s);
		    		
		    		if(Integer.parseInt(tf4.getText())>PurchaseList.get(3).getCurrentAccount()) {
		    			tf4.setText("0");
		    			JOptionPane.showMessageDialog(null, "超出库存");
		    		}
		    		else {
		    			PurchaseList.get(3).setPurchaseAmount(Integer.parseInt(tf4.getText()));
		    		}
		    	}
		    });
		    
		    
		    String s5;
			JLabel lb5 = null;
			s5="冰红茶";
			lb5 = new JLabel(new ImageIcon("img\\冰红茶.png")); //创建一个带图片的 JLabel
		    lb5.setBounds(80, 30+400, 240, 300); //设置 图片的横坐标、纵坐标、宽、高
		    this.add(lb5);
		   
		 
		    JButton bt51 = new JButton("");
		    bt51.setBounds(90, 351+400, 45, 40);
		    bt51.setIcon(new ImageIcon("img\\-.png"));
		    bt51.setBorder(null);
		    bt51.setFocusPainted(false);
		    
		    bt51.addMouseListener(new MouseListener() {
				@Override
				public void mouseEntered(MouseEvent e) {
					bt51.setIcon(new ImageIcon("img\\-点击.png"));
				}

				@Override
				public void mouseExited(MouseEvent e) {
					bt51.setIcon(new ImageIcon("img\\-.png"));
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
		    //System.out.println("444");
		    add(bt51);
		    
		    JButton bt52 = new JButton("");
		    bt52.setBounds(263, 351+400,45,40);
		    bt52.setIcon(new ImageIcon("img\\+.png"));
		    bt52.setBorder(null);
		    bt52.setFocusPainted(false);
		    
		    bt52.addMouseListener(new MouseListener() {
				@Override
				public void mouseEntered(MouseEvent e) {
					bt52.setIcon(new ImageIcon("img\\+点击.png"));
				}

				@Override
				public void mouseExited(MouseEvent e) {
					bt52.setIcon(new ImageIcon("img\\+.png"));
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
		    add(bt52);
		   
		    bt51.setContentAreaFilled(false);
		    bt52.setContentAreaFilled(false);
		    
		    JTextField tf5=new JTextField("0");
		    tf5.setBounds(168,351+400,70,40);
		    add(tf5);
		    
		    bt51.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent arg0) {
		    		/*String s=tf5.getText();
		    		int i=Integer.parseInt(s);
		    		if(i==0)
		    			i=0;
		    		else
		    			i=i-1;
		    		s=i+"";
		    		tf5.setText(s);*/
		    		String s=tf5.getText();
		    		int i=Integer.parseInt(s);
		    		if(i==0)
		    			i=0;
		    		else
		    			i=i-1;
		    		s=i+"";
		    		tf5.setText(s);

		    		if(Integer.parseInt(tf5.getText()) == 0) {
		    			//PurchaseList.remove(4);
		    		}
		    		else {
		    			PurchaseList.get(4).setPurchaseAmount(Integer.parseInt(tf5.getText()));
		    		}
		    	}
		    });

		    bt52.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent arg0) {
		    		/*String s=tf5.getText();
		    		int i=Integer.parseInt(s)+1;
		    		s=i+"";
		    		tf5.setText(s);*/
		    		String s=tf5.getText();
		    		int i=Integer.parseInt(s)+1;
		    		s=i+"";
		    		tf5.setText(s);
		    		
		    		if(Integer.parseInt(tf5.getText())>PurchaseList.get(4).getCurrentAccount()) {
		    			tf5.setText("0");
		    			JOptionPane.showMessageDialog(null, "超出库存");
		    		}
		    		else {
		    			PurchaseList.get(4).setPurchaseAmount(Integer.parseInt(tf5.getText()));
		    		}
		    	}
		    });
		    
		    
		    String s6;
			JLabel lb6 = null;
			s6="可口可乐";
			lb6 = new JLabel(new ImageIcon("img\\可口可乐.png")); //创建一个带图片的 JLabel
		    lb6.setBounds(80+420, 30+400, 240, 300); //设置 图片的横坐标、纵坐标、宽、高
		    this.add(lb6);
		   
		    JButton bt61 = new JButton("");
		    bt61.setBounds(90+420, 351+400, 45, 40);
		    bt61.setIcon(new ImageIcon("img\\-.png"));
		    bt61.setBorder(null);
		    bt61.setFocusPainted(false);
		    
		    bt61.addMouseListener(new MouseListener() {
				@Override
				public void mouseEntered(MouseEvent e) {
					bt61.setIcon(new ImageIcon("img\\-点击.png"));
				}

				@Override
				public void mouseExited(MouseEvent e) {
					bt61.setIcon(new ImageIcon("img\\-.png"));
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
		    //System.out.println("444");
		    add(bt61);
		    
		    JButton bt62 = new JButton("");
		    bt62.setBounds(263+420, 351+400,45,40);
		    bt62.setIcon(new ImageIcon("img\\+.png"));
		    bt62.setBorder(null);
		    bt62.setFocusPainted(false);
		    
		    bt62.addMouseListener(new MouseListener() {
				@Override
				public void mouseEntered(MouseEvent e) {
					bt62.setIcon(new ImageIcon("img\\+点击.png"));
				}

				@Override
				public void mouseExited(MouseEvent e) {
					bt62.setIcon(new ImageIcon("img\\+.png"));
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
		    add(bt62);
		   
		    bt61.setContentAreaFilled(false);
		    bt62.setContentAreaFilled(false);
		    
		    JTextField tf6=new JTextField("0");
		    tf6.setBounds(168+420,351+400,70,40);
		    add(tf6);
		    
		    //算钱
		    JTextField tf100=new JTextField("0");
		    add(tf100);
		    tf100.setBounds(589,835,126,68);
		    tf100.setFont(font);
		   
		    bt61.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent arg0) {
		    		/*String s=tf6.getText();
		    		int i=Integer.parseInt(s);
		    		if(i==0)
		    			i=0;
		    		else
		    			i=i-1;
		    		s=i+"";
		    		tf6.setText(s);*/
		    		String s=tf6.getText();
		    		int i=Integer.parseInt(s);
		    		if(i==0)
		    			i=0;
		    		else
		    			i=i-1;
		    		s=i+"";
		    		tf6.setText(s);

		    		if(Integer.parseInt(tf6.getText()) == 0) {
		    			//PurchaseList.remove(5);
		    		}
		    		else {
		    			PurchaseList.get(4).setPurchaseAmount(Integer.parseInt(tf5.getText()));
		    		}
		    	}
		    });

		    bt62.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent arg0) {
		    		/*String s=tf6.getText();
		    		int i=Integer.parseInt(s)+1;
		    		s=i+"";
		    		tf6.setText(s);*/
		    		String s=tf6.getText();
		    		int i=Integer.parseInt(s)+1;
		    		s=i+"";
		    		tf6.setText(s);
		    		
		    		if(Integer.parseInt(tf6.getText())>PurchaseList.get(5).getCurrentAccount()) {
		    			tf6.setText("0");
		    			JOptionPane.showMessageDialog(null, "超出库存");
		    		}
		    		else {
		    			PurchaseList.get(5).setPurchaseAmount(Integer.parseInt(tf6.getText()));
		    		}
		    	}
		    });
		    


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
					 int numberofProducts = PurchaseList.size();
					 int i= 0;
					 for(;i<numberofProducts;i++) {
						 PurchaseList.get(i).setUserName(username);
						 if(SPS.buyProduct(PurchaseList.get(i), 1)==false) {
							 JOptionPane.showMessageDialog(null, SPS.getExceptionCodes());
							 break;
						 }
					 }
					 if(i==numberofProducts) {
						 JOptionPane.showMessageDialog(null, "购买成功");
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
		   
		  

		    bt100.addMouseListener(new MouseListener() {
				@Override
				public void mouseEntered(MouseEvent e) {
					bt100.setIcon(new ImageIcon("img\\结算点击.png"));
				}

				@Override
				public void mouseExited(MouseEvent e) {
					bt100.setIcon(new ImageIcon("img\\结算.png"));
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
		   
		  
		    

		    
	/*	    
		    String s7;
			JLabel lb7 = null;
			s5="新增";
			lb7 = new JLabel(new ImageIcon("img\\冰红茶.png")); //创建一个带图片的 JLabel
		    lb7.setBounds(80+420*2, 30+400, 240, 300); //设置 图片的横坐标、纵坐标、宽、高
		   
		   
		    
		    JTextField tfp7=new JTextField("4");
		    tfp7.setBounds(330+420*2,400+271,100,100);
		    
		    tfp7.setBorder(null);
		    tfp7.setEditable(false);
		    tfp7.setFont(font);
		 
		    JButton bt71 = new JButton("");
		    bt71.setBounds(90+420*2, 400+351, 45, 40);
		    bt71.setIcon(new ImageIcon("img\\-.png"));
		    bt71.setBorder(null);
		    bt71.setFocusPainted(false);
		    
		    bt41.addMouseListener(new MouseListener() {
				@Override
				public void mouseEntered(MouseEvent e) {
					bt71.setIcon(new ImageIcon("img\\-点击.png"));
				}

				@Override
				public void mouseExited(MouseEvent e) {
					bt71.setIcon(new ImageIcon("img\\-.png"));
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
		    
		    JButton bt72 = new JButton("");
		    bt72.setBounds(263+420*2, 400+351,45,40);
		    bt72.setIcon(new ImageIcon("img\\+.png"));
		    bt72.setBorder(null);
		    bt72.setFocusPainted(false);
		    
		    bt72.addMouseListener(new MouseListener() {
				@Override
				public void mouseEntered(MouseEvent e) {
					bt72.setIcon(new ImageIcon("img\\+点击.png"));
				}

				@Override
				public void mouseExited(MouseEvent e) {
					bt72.setIcon(new ImageIcon("img\\+.png"));
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


		    
		    bt71.setContentAreaFilled(false);
		    bt72.setContentAreaFilled(false);
		    
		    
		   
		    JTextField tf7=new JTextField("0");
		    tf7.setBounds(168+420*2,400+351,70,40);
		   
		    bt71.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent arg0) {
		    		String s=tf7.getText();
		    		int i=Integer.parseInt(s);
		    		if(i==0)
		    			i=0;
		    		else
		    			i=i-1;
		    		s=i+"";
		    		tf7.setText(s);
		    	}
		    });

		    bt72.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent arg0) {
		    		String s=tf7.getText();
		    		int i=Integer.parseInt(s)+1;
		    		s=i+"";
		    		tf7.setText(s);
		    	}
		    });
		    
		    
		    //cc:新增饮料
		    if(new_drink) {
		    	this.add(lb7);
			    add(lb7);
			    add(bt71);
			    add(bt72);
			    add(tfp7);
			    add(tf7);
			    add(tfp7);
			    add(tf7);	
		    } 
	*/	    
		    tf2.setFont(font);
		    tf3.setFont(font);
		    tf4.setFont(font);
		    tf5.setFont(font);
		    tf6.setFont(font);
		    //tf7.setFont(font);
		  
		    bt100.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent arg0) {
		    		
		    		String result=tf100.getText();
		    		double i100=Double.parseDouble(result);
		    	    int i1 = Integer.parseInt(tf1.getText());
		    	    int i2 = Integer.parseInt(tf2.getText());
		    	    int i3 = Integer.parseInt(tf3.getText());
		    	    int i4 = Integer.parseInt(tf4.getText());
		    	    int i5 = Integer.parseInt(tf5.getText());
		    	    int i6 = Integer.parseInt(tf6.getText());
		    	    //int i7 = Integer.parseInt(tf7.getText());

		    	    Double p1 = Double.parseDouble(tfp1.getText());
		    	    Double p2 = Double.parseDouble(tfp2.getText());
		    	    Double p3 = Double.parseDouble(tfp3.getText());
		    	    Double p4 = Double.parseDouble(tfp4.getText());
		    	    Double p5 = Double.parseDouble(tfp5.getText());
		    	    Double p6 = Double.parseDouble(tfp6.getText());
		    	    //Double p7 = Double.parseDouble(tfp7.getText());
		    	    
		    	    PurchaseList.get(0).setOneConsumption(i1*p1);
		    	    PurchaseList.get(1).setOneConsumption(i2*p2);
		    	    PurchaseList.get(2).setOneConsumption(i3*p3);
		    	    PurchaseList.get(3).setOneConsumption(i4*p4);
		    	    PurchaseList.get(4).setOneConsumption(i5*p5);
		    	    PurchaseList.get(5).setOneConsumption(i6*p6); 
		    	    
		    		i100=i1*p1+i2*p2+i3*p3+i4*p4+i5*p5+i6*p6;
		    		i100 = (double)Math.round(i100*100)/100;
		    		if(i100>tc.getCacheTeacher().getMoney()) {
		    			result=i100+"";
			    		tf100.setText(result);
		    			JOptionPane.showMessageDialog(null, "超出您的余额");
		    			bt1.setEnabled(false);
		    		}
		    		else {
		    			result=i100+"";
			    		tf100.setText(result);
		    		}
		    		
		    		
		    		if(i6==0) PurchaseList.remove(5);
		    		else PurchaseList.get(5).setOneConsumption(i6);
		    		if(i5==0) PurchaseList.remove(4);
		    		else PurchaseList.get(4).setOneConsumption(i5);
		    		if(i4==0) PurchaseList.remove(3);
		    		else PurchaseList.get(3).setOneConsumption(i4);
		    		if(i3==0) PurchaseList.remove(2);
		    		else PurchaseList.get(2).setOneConsumption(i3);
		    		if(i2==0) PurchaseList.remove(1);
		    		else PurchaseList.get(1).setOneConsumption(i2);
		    		if(i1==0) PurchaseList.remove(0);
		    		else PurchaseList.get(0).setOneConsumption(i1);
		    	}
		    	
		    });
		}
		
    
}
