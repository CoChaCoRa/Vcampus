package vCampus.client.register;
/**
 * @author CC
 * 
 * @date 8.27
 *
 */

import javax.swing.*;
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;
import vCampus.client.socket.Client;
import vCampus.client.biz.StudentService;
import vCampus.client.biz.StudentServiceImpl;

public class RegisterView extends JFrame{
	/**
	 *v1.0 
	 */
	private static final long serialVersionUID = 1L;
	JFrame frame = new JFrame("用户注册");
	public JLabel nameLab = new JLabel("用户名");
	public JLabel passLab1 = new JLabel("密码");
	public JLabel passLab2 = new JLabel("确认密码");
	public JTextField nameText = new JTextField(15);;
	public JPasswordField pwdText1 = new JPasswordField(15);
	public JPasswordField pwdText2 = new JPasswordField(15);
	public JButton registerButton = new JButton("确认注册");
	public JPanel buttonPan = new JPanel();
	String uID = null;
	String uPassword = null;
	
	public RegisterView() {
		
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
	}
	
	public class registerActionPerformed implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(pwdText1.getText().trim().equals(pwdText2.getText().trim())) {
				uID = nameText.getText();
				uPassword = pwdText1.getText();
				StudentService SS = new StudentServiceImpl();
				if(SS.register(uID, uPassword, pwdText2.getText()) == true) {
					ImageIcon icon = new ImageIcon("img/frisk.jpg");
					JOptionPane.showMessageDialog(null, "注册成功","注册成功",1,icon);
				}
			}else {
				ImageIcon icon = new ImageIcon("img/frisk.jpg");
				JOptionPane.showMessageDialog(null, "密码不一致","注册失败",1,icon);
			}
		}
	}
	
}