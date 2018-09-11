package vCampus.server.Shop;
/**
 * @author SYH
 * 
 * @date 9.3
 *
 */
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

import vCampus.client.biz.AdminService;
import vCampus.client.biz.ShopService;
import vCampus.client.biz.ShopServiceImpl;
import vCampus.client.register.RegisterView;
import vCampus.vo.ProductInformation;
import vCampus.vo.ProductPurchase;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AdmCheck extends JPanel{


	
	
	DefaultTableModel dtm = null;

	
	public AdmCheck(AdminService admin) {
		
	super();


	
	this.setLayout(null);
	this.setSize(1650,1000);         
    
    Font font=new Font("苹方 常规",Font.CENTER_BASELINE,28);//设置字体格式和大小

    ShopService SPS = new ShopServiceImpl(3,admin.getCacheAdmin().getAdminID());
    ArrayList<ProductInformation> allProducts = SPS.queryAllProduct();
    
	/*
	 * 设置JTable的列名
	 */
	String[] columnNames =
	{ "产品号","产品名", "购买数量","购买者","购买时间","消费金额","商品单价"};

	int typenum = allProducts.size();
	int[] num_eachtype= {0,0,0,0,0,0};
	int totalnum = 0;
	ArrayList<ProductPurchase> PurchaseRecords = new ArrayList<ProductPurchase>();
	for(int i=0;i<typenum;i++) {
		if(SPS.queryAccountCurrentByProductID(allProducts.get(i).getProductID())!=null) {
			//num_eachtype[i] = SPS.queryAccountCurrentByProductID(allProducts.get(i).getProductID()).size();
			totalnum += SPS.queryAccountCurrentByProductID(allProducts.get(i).getProductID()).size();
			PurchaseRecords.addAll(SPS.queryAccountCurrentByProductID(allProducts.get(i).getProductID()));
		}
	}
	//int num_borrow=2;
	Object[][] obj = new Object[totalnum][7];
	for (int i = 0; i < totalnum; i++)
	{
		//String ProductID = allProducts.get(i).getProductID();
		for (int j = 0; j < 7; j++)
		{
			if(PurchaseRecords.get(i)==null) break;
			switch (j)
			{
			case 0:
				obj[i][j] = PurchaseRecords.get(i).getProductID();
				break;
			case 1:
				obj[i][j] = PurchaseRecords.get(i).getProductName();
				break;
			case 2:
				obj[i][j] = PurchaseRecords.get(i).getPurchaseAmount();
				break;
			case 3:
				obj[i][j] = PurchaseRecords.get(i).getUserName();
				break;
			case 4:
				obj[i][j] = PurchaseRecords.get(i).getPurchaseTime();
				break;
			case 5:
				obj[i][j] = PurchaseRecords.get(i).getOneConsumption()*PurchaseRecords.get(i).getPurchaseAmount();
				break;
			case 6:
				obj[i][j] = PurchaseRecords.get(i).getOneConsumption();
				break;
				
			}
		}
		
	}
	
	/*
	 * JTable的其中一种构造方法
	 */
    dtm=new DefaultTableModel(obj,columnNames){
		public boolean isCellEditable(int row, int column)
	    {
	               return false;}//表格不允许被编辑
	    };
 

	JTable table = new JTable(dtm); 
	;
    table.setRowHeight(30);// 设置表格行宽
    
    JTableHeader head = table.getTableHeader(); // 创建表格标题对象
    head.setPreferredSize(new Dimension(head.getWidth(), 35));// 设置表头大小
    head.setFont(font);// 设置表格字体
   
	TableColumn column = null;
	int colunms = table.getColumnCount();
	for(int i = 0; i < colunms; i++)
	{
		column = table.getColumnModel().getColumn(i);
		column.setPreferredWidth(300);
	}
	

	table.setBounds(400, 365, 600, 800);
	table.setFont(font);
	
	/*用JScrollPane装载JTable，这样超出范围的列就可以通过滚动条来查看*/
	JScrollPane scroll = new JScrollPane(table);
	scroll.setLocation(186, 223);
	scroll.setSize(1022, 528);
	table.setSize(600, 800);
	
	add(scroll);

    
    
	}
}
