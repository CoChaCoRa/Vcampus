package vCampus.client.JWC;
/**
 * @author Yanhao Shen
 * 
 * @date 9.3
 *
 */
import javax.swing.*;

import vCampus.client.register.RegisterView;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class StuScoreCheck extends JPanel{

	public CircleProgressBar circleProgressBar2;

	public ArrayList<JProgressBar> BarVector = new ArrayList<JProgressBar>(10);
	public ArrayList<Integer> ScoreVector = new ArrayList<Integer>(10);
	
	public StuScoreCheck(int num) {
		
	
	super();
	

	this.setLayout(null);
	this.setSize(1650,1000);         
    
    Font font=new Font("苹方 常规",Font.CENTER_BASELINE,28);//设置字体格式和大�?
    
  
    circleProgressBar2 = new CircleProgressBar();
	circleProgressBar2.setSize(new Dimension(300, 300));
	
	this.add(circleProgressBar2);
	circleProgressBar2.setBounds(700, 200, 400, 400);
    
    
	for(int i=0;i<num;i++)
    {
		JProgressBar progressbar; 

		progressbar = new JProgressBar();
		// 显示当前进度值信�?
		progressbar.setStringPainted(true);
	
		// 设置进度条边框不显示
		progressbar.setBorderPainted(false);
		// 设置进度条的前景�?
		//progressbar.setForeground(new Color(0, 210, 40));
		progressbar.setForeground(new Color(0, 0, 0));
		// 设置进度条的背景�?
		//progressbar.setBackground(new Color(188, 190, 194));
		progressbar.setBounds(100,120*i+100, 400, 30);
		// 添加组件
		BarVector.add(progressbar);
		this.add(progressbar);
    }
	

    
    }
    
}
