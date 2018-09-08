package vCampus.client.register;
/**
 * @author CC
 * 
 * @date 8.27
 * @v2.0 data 9/8
 */

import javax.swing.*;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import vCampus.client.socket.Client;
import vCampus.client.biz.StudentService;
import vCampus.client.biz.StudentServiceImpl;

public class RegisterView extends JFrame{
	/**
	 *v2.0 
	 */
	private static final long serialVersionUID = 1L;
	JFrame frame = new JFrame("用户注册");
	BackgroundPanel bgp;
	Font font=new Font("苹方 常规",Font.CENTER_BASELINE,28);
	public JTextField nameText = new JTextField(15);;
	public JPasswordField pwdText1 = new JPasswordField(15);
	public JPasswordField pwdText2 = new JPasswordField(15);
	public JButton registerButton = new JButton();
	public JButton jb_close = new JButton();
	public JPanel buttonPan = new JPanel();
	String uID = null;
	String uPassword = null;
	
	/*public RegisterView() {
		
		//设置监听
		registerButton.addActionListener(new registerActionPerformed());
		//加入JFrame中
		this.add(nameLab);
		this.add(nameText);
		this.add(passLab1);
		this.add(pwdText1);
		this.add(passLab2);
		this.add(pwdText2);
		buttonPan.add(registerButton);
		this.add(buttonPan);
		//布局管理         
        this.setSize(400,300);         
        this.setLocation(600, 300);
        nameLab.setBounds(40, 20, 60, 30);
        nameText.setBounds(120, 20, 180, 30);
        passLab1.setBounds(40, 80, 60, 30);
        pwdText1.setBounds(120, 80, 180, 30);
        passLab2.setBounds(40,140,60,30);
        pwdText2.setBounds(120, 140, 180, 30);
        buttonPan.setBounds(150, 200, 100, 50);
        this.setLayout(null);
        this.setDefaultCloseOperation(2);//DISPOSE_ON_CLOSE,隐藏并释放窗体，dispose()，当最后一个窗口被释放后，则程序也随之运行结束。 
        this.setVisible(true);  
        this.setResizable(true);
	}*/

	public RegisterView() {
		this.setFocusable(true);
		//设置注册按钮监听
		registerButton.addActionListener(new registerActionPerformed());
		//加入JFrame中
		this.add(nameText);
		this.add(pwdText1);
		this.add(pwdText2);
		this.add(registerButton);
		this.add(jb_close);
		//布局管理         
		this.setSize(800,600);         
		this.setLocation(600, 300);
		nameText.setBounds(285, 200, 250, 48);
		nameText.setBorder(null);
		nameText.setFont(font);
		nameText.setOpaque(false);
		nameText.addFocusListener(new JTextFieldHintListener(nameText, "用户ID"));
		pwdText1.setBounds(285, 275, 250, 48);
		pwdText1.setBorder(null);
		pwdText1.setFont(font);
		pwdText1.setOpaque(false);
		pwdText2.setBounds(285, 355, 250, 48);
		pwdText2.setBorder(null);
		pwdText2.setFont(font);
		pwdText2.setOpaque(false);
		
		jb_close.setBounds(800-50, 0, 50, 50);
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
				RVoff();
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
		
	    registerButton.setBounds(341,466,130,40);
	    registerButton.setIcon(new ImageIcon("img\\确认注册.png"));
	    registerButton.setPressedIcon(new ImageIcon("img\\确认注册点击.png"));
	    
		bgp=new BackgroundPanel((new ImageIcon("img\\注册背景.png")).getImage());
		bgp.setBounds(0,0,800,600);
		this.add(bgp);
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		  //Dimension dimension = kit.getScreenSize();
		  //  frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		  //  frame.setBounds(0, 0, dimension.width, dimension.height);
		   
		this.setUndecorated(true); 
		this.setVisible(true);  
		this.setResizable(true);
	}
	
	public void RVoff() {
		this.dispose();
		this.setVisible(false);
	}
	
	public class registerActionPerformed implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(pwdText1.getText().trim().equals(pwdText2.getText().trim())) {
				uID = nameText.getText();
				uPassword = pwdText1.getText();
				StudentService SS = new StudentServiceImpl();
				if(SS.register(uID, uPassword, pwdText2.getText()) == true) {
					ImageIcon icon = new ImageIcon("img\\frisk.jpg");
					JOptionPane.showMessageDialog(null, "注册成功","注册成功",1,icon);
				}
			}else {
				ImageIcon icon = new ImageIcon("img\\frisk.jpg");
				JOptionPane.showMessageDialog(null, "密码不一致","注册失败",1,icon);
			}
		}
	}
	
}

