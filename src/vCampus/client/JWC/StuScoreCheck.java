package vCampus.client.JWC;
/**
 * @author Yanhao Shen
 * 
 * @date 9.3
 *
 */
import javax.swing.*;

import vCampus.client.biz.AcademicAffairsService;
import vCampus.client.register.RegisterView;
import vCampus.vo.CourseChoose;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;
import java.util.ArrayList;
import java.awt.Graphics;

public class StuScoreCheck extends JPanel{

	public CircleProgressBar circleProgressBar2;

	public ArrayList<JProgressBar> BarVector = new ArrayList<JProgressBar>(10);
	public ArrayList<Integer> ScoreVector = new ArrayList<Integer>(10);
	
	
	public StuScoreCheck(AcademicAffairsService AAS) {
		
	super();
	
	Graphics g=new Graphics() {
		
		@Override
		public void translate(int x, int y) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void setXORMode(Color c1) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void setPaintMode() {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void setFont(Font font) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void setColor(Color c) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void setClip(int x, int y, int width, int height) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void setClip(Shape clip) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public FontMetrics getFontMetrics(Font f) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public Font getFont() {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public Color getColor() {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public Rectangle getClipBounds() {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public Shape getClip() {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public void fillRoundRect(int x, int y, int width, int height, int arcWidth, int arcHeight) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void fillRect(int x, int y, int width, int height) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void fillPolygon(int[] xPoints, int[] yPoints, int nPoints) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void fillOval(int x, int y, int width, int height) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void fillArc(int x, int y, int width, int height, int startAngle, int arcAngle) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void drawString(AttributedCharacterIterator iterator, int x, int y) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void drawString(String str, int x, int y) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void drawRoundRect(int x, int y, int width, int height, int arcWidth, int arcHeight) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void drawPolyline(int[] xPoints, int[] yPoints, int nPoints) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void drawPolygon(int[] xPoints, int[] yPoints, int nPoints) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void drawOval(int x, int y, int width, int height) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void drawLine(int x1, int y1, int x2, int y2) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public boolean drawImage(Image img, int dx1, int dy1, int dx2, int dy2, int sx1, int sy1, int sx2, int sy2,
				Color bgcolor, ImageObserver observer) {
			// TODO Auto-generated method stub
			return false;
		}
		
		@Override
		public boolean drawImage(Image img, int dx1, int dy1, int dx2, int dy2, int sx1, int sy1, int sx2, int sy2,
				ImageObserver observer) {
			// TODO Auto-generated method stub
			return false;
		}
		
		@Override
		public boolean drawImage(Image img, int x, int y, int width, int height, Color bgcolor, ImageObserver observer) {
			// TODO Auto-generated method stub
			return false;
		}
		
		@Override
		public boolean drawImage(Image img, int x, int y, int width, int height, ImageObserver observer) {
			// TODO Auto-generated method stub
			return false;
		}
		
		@Override
		public boolean drawImage(Image img, int x, int y, Color bgcolor, ImageObserver observer) {
			// TODO Auto-generated method stub
			return false;
		}
		
		@Override
		public boolean drawImage(Image img, int x, int y, ImageObserver observer) {
			// TODO Auto-generated method stub
			return false;
		}
		
		@Override
		public void drawArc(int x, int y, int width, int height, int startAngle, int arcAngle) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void dispose() {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public Graphics create() {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public void copyArea(int x, int y, int width, int height, int dx, int dy) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void clipRect(int x, int y, int width, int height) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void clearRect(int x, int y, int width, int height) {
			// TODO Auto-generated method stub
			
		}
	};
	
	//此处修改课程名
	ArrayList<CourseChoose> class_name=AAS.studentGetAllCourses();
	//String class_name[]= {"语文","高等数学","计算机组成原理","英语"};
	//此处修改成绩
	ArrayList<CourseChoose> goal= AAS.studentGetAllCourseGrades();
	
	this.setLayout(null);
	this.setSize(1650,1000);         
    
	 Font font=new Font("苹方 常规",Font.CENTER_BASELINE,28);//设置字体格式和大小
    
  
    circleProgressBar2 = new CircleProgressBar();
	circleProgressBar2.setSize(new Dimension(300, 300));
	
	this.add(circleProgressBar2);
	circleProgressBar2.setBounds(1100, 100, 400, 400);
    
    int num = 0;
    if(AAS.studentGetAllCourses()!=null) {
    	num = AAS.studentGetAllCourses().size();
    }
	
	for(int i=0;i<num;i++)
    {
		JProgressBar progressbar; 
		progressbar = new JProgressBar();
		progressbar.setStringPainted(true);
		progressbar.setBorderPainted(false);
		//progressbar.setForeground(new Color(0, 210, 40));
		progressbar.setForeground(new Color(0, 0, 0));
		//progressbar.setBackground(new Color(188, 190, 194));
		progressbar.setBounds(100,120*i+100, 400, 30);
		BarVector.add(progressbar);
		this.add(progressbar);
		
		JLabel lb1=new JLabel(class_name.get(i).getCourseName());
		lb1.setFont(font);
		lb1.setBounds(600, 120*i+100, 300, 47);
		this.add(lb1);
		
		JTextField jt=new JTextField();
		String s = String.valueOf(goal.get(i).getScore());
		jt.setText(s);
		jt.setFont(font);
		jt.setBounds(850, 120*i+100, 100, 47);
		jt.setEditable(false);
		jt.setBackground(Color.WHITE);
		g.drawLine(850,120*i+100, 900, 120*i+147);
		;
		this.add(jt);
		
    }
	

    
    }
    
}
