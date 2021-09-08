package tests;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import javax.swing.JFrame;

import mainPackage.Backend;
import mainPackage.Frontend;

public class InsertTest implements ActionListener{
	JFrame frame;
	JTextField tx1, tx2, tx3, tx4;
	JButton btn1;
	JLabel l1, l2, l3, l4;
	
	public InsertTest(){
		frame = new JFrame("Insert Test");
		Font f1 = new Font(Font.SANS_SERIF, Font.PLAIN, 20);
		l1 = new JLabel("Test Name");
		l2 = new JLabel("Result");
		l3 = new JLabel("Fees");
		l4 = new JLabel("Patient id");

		tx1 = new JTextField();
		tx2= new JTextField();
		tx3 = new JTextField();
		tx4 = new JTextField();
		int left = 500, top = 200, w=200, h=30;

		l1.setFont(f1);
		l1.setBounds(left, top += 50, w, h);

		l2.setFont(f1);
		l2.setBounds(left, top += 50, w, h);

		l3.setFont(f1);
		l3.setBounds(left, top += 50, w, h);

		l4.setFont(f1);
		l4.setBounds(left, top += 50, w, h);
		
		left += 250;
		top = 200;

		tx1.setFont(f1);
		tx1.setBounds(left, top += 50, w, h);

		tx2.setFont(f1);
		tx2.setBounds(left, top += 50, w, h);

		tx3.setFont(f1);
		tx3.setBounds(left, top += 50, w, h);

		tx4.setFont(f1);
		tx4.setBounds(left, top += 50, w, h);
				
//		Button
		btn1 = new JButton("Insert");
		btn1.setBounds(left, top+=50, w, h);
		btn1.setFont(f1);
		btn1.addActionListener(this);
		
		frame.add(btn1);
		frame.add(l1);
		frame.add(l2);
		frame.add(l3);
		frame.add(l4);
		frame.add(tx1);
		frame.add(tx2);
		frame.add(tx3);
		frame.add(tx4);
		frame.setLayout(null);
		frame.setSize(Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height);
		frame.setVisible(true);
	}
	public void actionPerformed(ActionEvent ae) {
		String t1, t2;
		int t3, t4;
		t1 = tx1.getText();
		t2 = tx2.getText();
		t3 = Integer.parseInt(tx3.getText());
		t4 = Integer.parseInt(tx4.getText());
		Backend obj = new Backend();
		obj.insertTest(t1, t2, t3, t4);
		frame.dispose();
		new Frontend();
	}
	
	public static void main(String[] args) {
		new InsertTest();
	}
}
