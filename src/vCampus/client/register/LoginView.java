package vCampus.client.register;
/**
 * @author CC
 * 
 * @date 9/7
 *
 */

import javax.swing.*;

import vCampus.client.MainTable.StuInfoView_main;
import vCampus.client.InfoView.*;
import vCampus.client.JWC.*;
import vCampus.client.TSG.*;
import vCampus.client.Shop.*;
import vCampus.client.Dorm.*;
import vCampus.client.Bank.*;

import vCampus.client.biz.StudentService;
import vCampus.client.biz.StudentServiceImpl;
import vCampus.client.biz.TeacherService;
import vCampus.client.biz.TeacherServiceImpl;
import vCampus.client.biz.AdminService;
import vCampus.client.biz.AdminServiceImpl;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class LoginView extends JFrame{
	JFrame frame = new JFrame("µÇÂ¼½çÃæ");
	BackgroundPanel bgp;
	public JTextField usernameText = new JTextField(15);
	public JTextField pwdhintText = new JTextField(15);
	public JPasswordField pwdText = new JPasswordField(15);
	public JButton jb1 = new JButton();
	public JButton jb2 = new JButton();
	public JLabel stuLab = new JLabel("Ñ§Éú");
	public JLabel teaLab = new JLabel("½ÌÊ¦");
	public JLabel admLab = new JLabel("¹ÜÀíÔ±");
	public JRadioButton jrb1 = new JRadioButton();
	public JRadioButton jrb2 = new JRadioButton();
	public JRadioButton jrb3 = new JRadioButton();
	public ButtonGroup bg=new ButtonGroup();
	private String uID = null;
	private String uPassword = null;
	private int identity = 0;
	
	public LoginView() {
		this.setLayout(null);
		this.setSize(1920,1080);         
	    this.setLocation(0, 0);
	    Font font=new Font("Æ»·½ ³£¹æ",Font.CENTER_BASELINE,28);
	    this.add(usernameText);
	    this.add(pwdText);
	    this.setFocusable(true);
	    this.add(jb1);
	    this.add(jb2);
	    this.add(stuLab);
	    this.add(teaLab);
	    this.add(admLab);
	    this.add(jrb1);
	    this.add(jrb2);
	    this.add(jrb3);
	    bg.add(jrb1);
	    bg.add(jrb2);
	    bg.add(jrb3);
	    
	    usernameText.setBounds(750, 560, 425, 48);
	    usernameText.setFont(font);
	    usernameText.setBorder(null);
	    usernameText.addFocusListener(new JTextFieldHintListener(usernameText, "ÓÃ»§ID"));
 
	    pwdText.setBounds(750, 655, 425, 48);
	    pwdText.setFont(font);
	    pwdText.setBorder(null);
	    pwdText.addFocusListener(new JTextFieldHintListener(pwdText, "******"));
	    
	    stuLab.setBounds(753, 718, 80, 30);
	    jrb1.setBounds(800, 718, 30, 30);
	    jrb1.setSelected(true);
	    jrb1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				identity = 0;
			}
	    	
	    });
	    teaLab.setBounds(850, 718, 80, 30);
	    jrb2.setBounds(900, 718, 30, 30);
	    jrb2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				identity = 1;
			}
	    	
	    });
	    admLab.setBounds(950,718,80,30);
	    jrb3.setBounds(1000, 718, 30, 30);
	    jrb3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				identity = 2;
			}
	    	
	    });
	    
	    jb1.setBounds(747, 781, 150, 56);
	    jb1.setIcon(new ImageIcon("img\\×¢²á.png"));
	    jb1.setContentAreaFilled(false);
	    jb1.setBorder(null);
	    jb1.setPressedIcon(new ImageIcon("img\\\\×¢²áµã»÷.png"));
	    jb1.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	RegisterView RV=new RegisterView();
	        }
	    });
	    
	    jb2.setBounds(1029, 781, 150, 56);
	    jb2.setIcon(new ImageIcon("img\\µÇÂ½1.png"));
	    jb2.setContentAreaFilled(false);
	    jb2.setBorder(null);
	    jb2.setPressedIcon(new ImageIcon("img\\µÇÂ½1µã»÷.png"));
	    jb2.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	uID = usernameText.getText();
	        	uPassword = pwdText.getText();
	        	switch(identity) {
	        	case 0://Ñ§ÉúµÇÂ¼
	        		StudentService SS = new StudentServiceImpl();
	        		if(SS.login(uID,uPassword)) {
	        			LToff();
	        			StuInfoView_main SIV=new StuInfoView_main(1,SS.getCacheStudent());
	        			JOptionPane.showMessageDialog(null,"µÇÂ¼³É¹¦£¡");
	        		}
	        		else if(!SS.login(uID,uPassword)) {
	        			JOptionPane.showMessageDialog(null, "ÕËºÅ»òÃÜÂë´íÎó ", "µÇÂ¼Ê§°Ü ", JOptionPane.ERROR_MESSAGE);
	        		}
	        		break;
	        	case 1://½ÌÊ¦µÇÂ¼
	        		TeacherService TS = new TeacherServiceImpl();
	        		if(TS.login(uID,uPassword)) {
	        			LToff();
	        			//StuInfoView_main TIV=new StuInfoView_main(2);
	        			JOptionPane.showMessageDialog(null,"µÇÂ¼³É¹¦£¡");
	        		}
	        		else if(!TS.login(uID,uPassword)) JOptionPane.showMessageDialog(null, "ÕËºÅ»òÃÜÂë´íÎó ", "µÇÂ¼Ê§°Ü ", JOptionPane.ERROR_MESSAGE);
	        		break;
	        	case 2://¹ÜÀíÔ±µÇÂ½
	        		AdminService AS = new AdminServiceImpl();
	        		AS.register("1", "1234", "1234");
	        		if(AS.login("1","1234")/*AS.login(uID,uPassword)*/) {
	        			LToff();
	        			StuInfoView_main AIV=new StuInfoView_main(3,AS.getCacheAdmin());
	        			JOptionPane.showMessageDialog(null,"µÇÂ¼³É¹¦£¡");
	        		}
	        		else if(!AS.login(uID,uPassword)) JOptionPane.showMessageDialog(null, "ÕËºÅ»òÃÜÂë´íÎó ", "µÇÂ¼Ê§°Ü ", JOptionPane.ERROR_MESSAGE);
	        		break;
	        	}
	        }
	    });
        
	    bgp=new BackgroundPanel((new ImageIcon("img\\µÇÂ¼±³¾°.png")).getImage());
		bgp.setBounds(0,0,1920,1080);
		this.add(bgp);
		
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
	    this.setVisible(true);  
	    this.setResizable(true);
	}
	
	public void LToff() {
		this.setVisible(false);
	}
	
	public static void main(String[] args) {  
		LoginView demo=new LoginView();  
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