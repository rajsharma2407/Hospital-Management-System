package room;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import mainPackage.Backend;
import mainPackage.Frontend;

public class RegisterRoom implements ActionListener{
	JFrame frame;
	JTextField tf1, tf2, tf3, tf4, tf5;
	JLabel l1, l2, l3, l4, l5;
	JButton btn, backBtn;
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	public RegisterRoom(){
		frame = new JFrame("Register rooms");
		l1 = new JLabel("Room Number");
		l2 = new JLabel("Available");
		l3 = new JLabel("Total rooms available");
		l4 = new JLabel("Room charge");
		l5 = new JLabel("Patient id");
		
		Font f1 = new Font(Font.SANS_SERIF, Font.PLAIN, 24);
		int left = 500, top = 200, w = 200, h=30;

		l1.setBounds(left, top += 50, w, h);
		l1.setFont(f1);
		
		l2.setBounds(left, top += 50, w, h);
		l2.setFont(f1);
		
		l3.setBounds(left, top += 50, w, h);
		l3.setFont(f1);
		
		l4.setBounds(left, top += 50, w, h);
		l4.setFont(f1);
		
		l5.setBounds(left, top += 50, w, h);
		l5.setFont(f1);
		
		left = 750;
		top = 200;

		tf1 = new JTextField();
		tf2 = new JTextField();
		tf3 = new JTextField();
		tf4 = new JTextField();
		tf5 = new JTextField();
		
		tf1.setBounds(left, top += 50, w, h);
		tf1.setFont(f1);
		
		tf2.setBounds(left, top += 50, w, h);
		tf2.setFont(f1);
		
		tf3.setBounds(left, top += 50, w, h);
		tf3.setFont(f1);
		
		tf4.setBounds(left, top += 50, w, h);
		tf4.setFont(f1);
		
		tf5.setBounds(left, top += 50, w, h);
		tf5.setFont(f1);
		
		btn = new JButton("Add");
		btn.setBounds(left, top += 50, w, h);
		btn.setFont(f1);
		btn.addActionListener(this);
		
		frame.add(l1);frame.add(l2);frame.add(l3);frame.add(l4);frame.add(l5);
		frame.add(tf1);frame.add(tf2);frame.add(tf3);frame.add(tf4);frame.add(tf5);
		frame.add(btn);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setSize(screenSize.width, screenSize.height);
		backButton();
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == backBtn) {
			new Frontend();
			frame.dispose();
			return;
		}
		try {
			String s1, s2, s3, s4, s5;
			s1 = tf1.getText();
			s2 = tf2.getText();
			s3 = tf3.getText();
			s4 = tf4.getText();
			s5 = tf5.getText();
			
			Backend obj = new Backend();
			obj.registerRoom();
		}catch(Exception err) {
			
		}
	}
	public void backButton() {
		backBtn = new JButton("<-- Back  ");
		backBtn.setBounds(50, 30, 100, 30);
		backBtn.addActionListener(this);
		frame.add(backBtn);
	}
	
	public static void main(String[] args) {
		new RegisterRoom();
	}
}
