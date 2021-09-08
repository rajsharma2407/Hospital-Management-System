package doctor;
import java.awt.*;
import javax.swing.*;

import mainPackage.Backend;
import mainPackage.Frontend;

import java.awt.event.*;

public class RegisterDoctor implements ActionListener{
	JFrame frame;
	JButton btn1, backBtn;
	JTextField tx1, tx2, tx3, tx4, tx5;
	JLabel l1, l2, l3, l4, l5, hd, et1;
	public RegisterDoctor(){
		frame = new JFrame("Register Doctor");
		hd = new JLabel("Register Doctor");
		l1 = new JLabel("Doctor Name");
		l2 = new JLabel("Specialization");
		l3 = new JLabel("Contact Number");
		l4 = new JLabel("Is Available");
		l5 = new JLabel("Consultancy fees");
		Font f1 = new Font(Font.SANS_SERIF,Font.BOLD, 34);
		Font f2= new Font(Font.SANS_SERIF,Font.PLAIN, 20);
		
		hd.setBounds(580, 100, 400, 50);
		hd.setFont(f1);
		
		int left = 500;
		int top = 200;
		int w = 200;
		int h = 30;

		l1.setBounds(left, top+=50, w, h);
		l1.setFont(f2);

		l2.setBounds(left, top+=50, w, h);
		l2.setFont(f2);

		l3.setBounds(left, top+=50, w, h);
		l3.setFont(f2);

		l4.setBounds(left, top+=50, w, h);
		l4.setFont(f2);

		l5.setBounds(left, top+=50, w, h);
		l5.setFont(f2);
		
//		Textareas
		tx1 = new JTextField();
		tx2 = new JTextField();
		tx3 = new JTextField();
		tx4 = new JTextField();
		tx5 = new JTextField();
		
		left += 250;
		top = 200;

		tx1.setBounds(left, top+=50, w, h);
		tx1.setFont(f2);
		
		tx2.setBounds(left, top+=50, w, h);
		tx2.setFont(f2);
		
		tx3.setBounds(left, top+=50, w, h);
		tx3.setFont(f2);
		
		tx4.setBounds(left, top+=50, w, h);
		tx4.setFont(f2);
		
		tx5.setBounds(left, top+=50, w, h);
		tx5.setFont(f2);
		
		btn1 = new JButton("Register Doctor");
		btn1.setBounds(left-=250, top+=50, 200, 50);
		btn1.setFont(f2);
		btn1.addActionListener(this);
		
		frame.add(btn1);
		frame.add(hd);
		frame.add(l1);
		frame.add(l2);
		frame.add(l3);
		frame.add(l4);
		frame.add(l5);
		frame.add(tx1);
		frame.add(tx2);
		frame.add(tx3);
		frame.add(tx4);
		frame.add(tx5);
//		Errors
		et1 = new JLabel("");
		et1.setBounds(300, 100, 200, 40);
		frame.add(et1);
		
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setSize(Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height);
		backButton();
	}
	public void actionPerformed(ActionEvent ae) {

		if(ae.getSource() == backBtn) {
			new Frontend();
			frame.dispose();
			return;
		}
		String t1, t2, t3, t4, t5;
		t1 = tx1.getText();
		t2 = tx2.getText();
		t3 = tx3.getText();
		t4 = tx4.getText();
		t5 = tx5.getText();
		
		Backend obj = new Backend();
		if(t1.length() > 1) {
			try {
				obj.registerDoctor(t1, t2, Long.valueOf(t3), t4.toLowerCase().charAt(0) == 'y'?true:false, Integer.valueOf(t5));
				new Frontend();
				frame.dispose();
			}catch(Exception err) {
				et1.setText("Invalid form details");
			}
		}
	}
	public void backButton() {
		backBtn = new JButton("<-- Back  ");
		backBtn.setBounds(50, 30, 100, 30);
		backBtn.addActionListener(this);
		frame.add(backBtn);
	}
	public static void main(String args[]) {
		new RegisterDoctor();
	}
}
