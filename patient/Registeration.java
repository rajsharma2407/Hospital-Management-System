package patient;
import java.awt.*;
import javax.swing.*;

import mainPackage.Backend;
import mainPackage.Frontend;

import java.awt.event.*;

public class Registeration implements ActionListener{
	JFrame frame;
	JLabel l1, l2, l3, l4, l5, l6, l7, l8, hd;
	JTextArea tx1, tx2, tx3, tx4, tx5, tx6, tx7, tx8;
	JButton btn1, backBtn;
	Dimension ss = Toolkit.getDefaultToolkit().getScreenSize();
	public Registeration(){
		frame = new JFrame("Registeration");
		hd = new JLabel("Registeration Form");
		l1 = new JLabel("Patient name");
		l2 = new JLabel("Blood Group");
		l3 = new JLabel("Gender");
		l4 = new JLabel("Date of birth");
		l5 = new JLabel("contact");
		l6 = new JLabel("Address");
		l7 = new JLabel("Current treatment");
		
		hd.setBounds(550, 100, 400, 50);
		hd.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 34));

		tx1 = new JTextArea();
		tx2 = new JTextArea();
		tx3 = new JTextArea();
		tx4 = new JTextArea();
		tx5 = new JTextArea();
		tx6 = new JTextArea();
		tx7 = new JTextArea();
		
		int x = 200;	
		int left =500;
		Font f1 = new Font(Font.SANS_SERIF, Font.PLAIN, 20);
		l1.setBounds(left, x+=50, 200, 30);
		l1.setFont(f1);

		l2.setBounds(left, x+=50, 200, 30);
		l2.setFont(f1);

		l3.setBounds(left, x+=50, 200, 30);
		l3.setFont(f1);

		l4.setBounds(left, x+=50, 200, 30);
		l4.setFont(f1);

		l5.setBounds(left, x+=50, 200, 30);
		l5.setFont(f1);

		l6.setBounds(left, x+=50, 200, 30);
		l6.setFont(f1);

		l7.setBounds(left, x+=50, 200, 30);
		l7.setFont(f1);

		left += 250;
		x = 200;

		tx1.setBounds(left, x+=50, 200, 30);
		tx1.setFont(f1);

		tx2.setBounds(left, x+=50, 200, 30);
		tx2.setFont(f1);

		tx3.setBounds(left, x+=50, 200, 30);
		tx3.setFont(f1);

		tx4.setBounds(left, x+=50, 200, 30);
		tx4.setFont(f1);

		tx5.setBounds(left, x+=50, 200, 30);
		tx5.setFont(f1);

		tx6.setBounds(left, x+=50, 200, 30);
		tx6.setFont(f1);

		tx7.setBounds(left, x+=50, 200, 30);
		tx7.setFont(f1);

		
		btn1 = new JButton("REGISTER");
		btn1.setBounds(left+50, x+=80, 150, 30);
		btn1.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 16));
		btn1.addActionListener(this);
		
		frame.add(hd);
		frame.add(l1);
		frame.add(l2);
		frame.add(l3);
		frame.add(l4);
		frame.add(l5);
		frame.add(l6);
		frame.add(l7);
		frame.add(tx1);
		frame.add(tx2);
		frame.add(tx3);
		frame.add(tx4);
		frame.add(tx5);
		frame.add(tx6);
		frame.add(tx7);
		frame.add(btn1);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setSize(ss.width, ss.height);

		backButton();
	}
	
	public void actionPerformed(ActionEvent ae) {

		if(ae.getSource() == backBtn) {
			new Frontend();
			frame.dispose();
			return;
		}
		String t1, t2, t3, t4, t5, t6, t7;
		t1 = tx1.getText();
		t2 = tx2.getText();
		t3 = tx3.getText();
		t4 = tx4.getText();
		t5 = tx5.getText();
		t6 = tx6.getText();
		t7 = tx7.getText();
		
		Backend obj = new Backend();
		try {
			obj.registerPatient(t1, t2, t3, t4, Long.parseLong(t5), t6, t7);
			new Frontend();
		}catch(Exception err) {
			System.out.println("error "+err);
			JOptionPane.showMessageDialog(frame, "column must not be empty", "warning",JOptionPane.WARNING_MESSAGE);
			new Registeration();
		}
		frame.dispose();
	}

	public void backButton() {
		backBtn = new JButton("<-- Back  ");
		backBtn.setBounds(50, 30, 100, 30);
		backBtn.addActionListener(this);
		frame.add(backBtn);
	}
	public static void main(String args[]) {
		Registeration obj = new Registeration();
	}
}
