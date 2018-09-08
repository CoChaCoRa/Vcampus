package vCampus.client.JWC;
/**
* @author Yanhao Shen
* @version 创建时间：2018年9月8日 下午5:16:17
* 类说明
*/
/*
 * 
 * 可用以显示流水显示
 * 
 * 
 * 功能：使用JTextArea 和 JTextField 制作聊天界面
 * 关于：JTextArea 类
 * JTextArea 类是一个能显示纯文本的多行区域。
 * 构造方法：   JTextArea();
 * 内部成员方法：   void  append(String str); // 将给定文本追加得到文档的结尾。
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * */


import java.awt.Color;
import java.awt.Dimension;
import java.awt.*;

import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JViewport;

 

public class JT_area extends JFrame 
{
JScrollPane jsp=null;
JTextArea   jta=null;
JTextField  jtf=null;



JButton jb=null;
JPanel   jp=null;
JViewport vp=null;

JButton jb2=new JButton("按钮");
public JProgressBar progressbar; 
public JProgressBar progressbar2;

public JT_area()
{
// 定义按钮

jp=new JPanel();
 
 // 定义三个组件
jta=new JTextArea();

jtf=new JTextField(20);



progressbar = new JProgressBar();
// 显示当前进度值信息
progressbar.setStringPainted(true);
// 设置进度条边框不显示
//progressbar.setBorderPainted(false);
// 设置进度条的前景色
//progressbar.setForeground(new Color(0, 210, 40));
progressbar.setForeground(new Color(0, 0, 0));
// 设置进度条的背景色
progressbar.setBackground(new Color(188, 190, 194));
progressbar.setBounds(0,  100, 200, 15);
// 添加组件


progressbar2 = new JProgressBar();
// 显示当前进度值信息
progressbar2.setStringPainted(true);
// 设置进度条边框不显示
//progressbar.setBorderPainted(false);
// 设置进度条的前景色
progressbar2.setForeground(new Color(0, 210, 40));
// 设置进度条的背景色
progressbar2.setBackground(new Color(188, 190, 194));
progressbar2.setBounds(0,  200, 200, 15);
// 添加组件

jta.add(progressbar);
jta.add(progressbar2);


jta.add(jb2);
jb2.setBounds(20, 20, 40, 40);

jta.setPreferredSize(new Dimension(400,400)); // 使用了这一句后，就可以显示滚动条了。
/*
* 之所以不显示，滚动条的原因：
* 主要是这句代码，设置panel的首选大小，同时保证宽高大于JScrollPane的宽高，这样下面的JScrollPane才会出现滚动条
*即：只有当处于：JScrollPane 之中的组件，其显示的宽和高大于JScrollPane 的宽和高时，才会显示滚动条。 
* 
* 
* */

jsp=new JScrollPane(jta);

jsp.validate();
 
jp.add(jtf);
 


this.add(jsp,"Center");
this.add(jp,"South");


Thread t1 = new Thread(){
	

	int r = 255;
	int g = 0;
	int b = 0;

	
 	public void run() {
    	int goal=80;

		for (int i = 0; i <=goal; i++) {
			try {
				Thread.sleep(1200/goal);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (g != 255) {
				g += 5;
			} else {
				r -= 5;
			}
			
			Color color = new Color(r, g, b);
			progressbar.setBackground(color);
		//	jtar.progressbar.setDigitalColor(color);
			
			
			progressbar.setValue(i);
		}
    }
};

Thread t2 = new Thread(){
 	public void run() {
    	int goal=60;
		
		for (int i = 0; i <=goal; i++) {
			try {
				Thread.sleep(1200/goal);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			progressbar2.setValue(i);
		}
    }
};

t1.start();
t2.start();

// 设置框架

this.setLocation(300, 300);
this.setSize(800,800);

this.setTitle("聊天对话框");
this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
this.setVisible(true);


}

	public static void main(String[] args)
	{
		JT_area jtar=new JT_area();
	 
	}

}