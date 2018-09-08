package vCampus.client.JWC;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

//import org.component.circleprogressbar.CircleProgressBar;

public class CircleProgressBarTest extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel panel1;
	private JPanel panel2;

	private JButton testButton1;
	private JButton testButton2;

	private CircleProgressBar circleProgressBar1;
	private CircleProgressBar circleProgressBar2;

	public CircleProgressBarTest() {
		super("11");

		panel1 = new JPanel(new BorderLayout());
		panel1.setSize(new Dimension(300, 400));
		testButton1 = new JButton("run");
		circleProgressBar1 = new CircleProgressBar();
		circleProgressBar1.setSize(new Dimension(300, 300));
		panel1.add(testButton1, BorderLayout.SOUTH);
		panel1.add(circleProgressBar1, BorderLayout.CENTER);

		panel2 = new JPanel(new BorderLayout());
		panel2.setSize(new Dimension(300, 400));
		testButton2 = new JButton("run");
		circleProgressBar2 = new CircleProgressBar();
		circleProgressBar2.setSize(new Dimension(300, 300));
		panel2.add(testButton2, BorderLayout.SOUTH);
		panel2.add(circleProgressBar2, BorderLayout.CENTER);

		setLayout(new GridLayout(1, 2));
		add(panel1);
		add(panel2);

		testButton1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				testButton1.setEnabled(false);
				new Thread() {

					int index = 0;

					@Override
					public void run() {
						while (index <= 100) {
							try {
								Thread.sleep(100);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							circleProgressBar1.setProgress(index++);
						}
						testButton1.setEnabled(true);
					};

				}.start();
			}
		});

	//	testButton2.addActionListener(new ActionListener() {

//			@Override
//			//public void actionPerformed(ActionEvent e) {
			//	testButton2.setEnabled(false);
				new Thread() {

					int index = 0;
					int r = 255;
					int g = 0;
					int b = 0;

					@Override
					public void run() {
						while (index <= 80) {
							try {
								Thread.sleep(25);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							if (g != 255) {
								g += 5;
							} else {
								r -= 5;
							}
							Color color = new Color(r, g, b);
							circleProgressBar2.setForegroundColor(color);
							circleProgressBar2.setDigitalColor(color);
							circleProgressBar2.setProgress(index++);
						}
						testButton2.setEnabled(true);
					};

				}.start();
	//		}
	//	});

		setVisible(true);
		setSize(new Dimension(600, 350));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new CircleProgressBarTest();
	}

}
