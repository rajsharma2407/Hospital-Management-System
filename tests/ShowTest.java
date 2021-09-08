package tests;
import java.awt.*;
import java.sql.*;
import java.sql.DriverManager;
import java.awt.event.*;
import javax.swing.*;

import mainPackage.Frontend;

public class ShowTest implements ActionListener{
	JFrame frame;
	JLabel l1, l2, l3, l4, l5;
	Dimension ss = Toolkit.getDefaultToolkit().getScreenSize();
	JButton btn1;
	JButton backBtn;
	public ShowTest(){
		frame = new JFrame("Test details");
		l1 = new JLabel("Test id");
		l2 = new JLabel("Test Name");
		l3 = new JLabel("Test Result");
		l4 = new JLabel("Test Fee");
		l5 = new JLabel("Patient id");
		int left = 300/2, top = 100, w = 300, h=30;
		Font f = new Font(Font.SANS_SERIF, Font.PLAIN, 24);
		l1.setBounds(left, top, w, h);
		l2.setBounds(left+=300, top, w, h);
		l3.setBounds(left+=300, top, w, h);
		l4.setBounds(left+=300, top, w, h);
		l5.setBounds(left+=300, top, w, h);
		
		l1.setFont(f);
		l2.setFont(f);
		l3.setFont(f);
		l4.setFont(f);
		l5.setFont(f);
		frame.add(l1);
		frame.add(l2);
		frame.add(l3);
		frame.add(l4);
		frame.add(l5);
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3308/hpms", "root", "");
			Statement smt = conn.createStatement();
			ResultSet rs = smt.executeQuery("select * from tests");
			
			while(rs.next()) {
				int testId = rs.getInt(1);
				String testName = rs.getString(3);
				String testResult = rs.getString(4);
				int testFee = rs.getInt(5);
				int patientId = rs.getInt(6);
				
				l1 = new JLabel(String.valueOf(testId));
				l2 = new JLabel(testName);
				l3 = new JLabel(testResult);
				l4 = new JLabel(String.valueOf(testFee));
				l5 = new JLabel(String.valueOf(patientId));
				btn1 = new JButton("Update");
				left = 150;
				top += 40;
				l1.setBounds(left, top, w, h);
				l2.setBounds(left+=300, top, w, h);
				l3.setBounds(left+=300, top, w, h);
				l4.setBounds(left+=300, top, w, h);
				l5.setBounds(left+=300, top, w, h);
				btn1.setBounds(left+=200, top, 100, h);
				
				l1.setFont(f);
				l2.setFont(f);
				l3.setFont(f);
				l4.setFont(f);
				l5.setFont(f);
				frame.add(l1);
				frame.add(l2);
				frame.add(l3);
				frame.add(l5);
				frame.add(l4);
				frame.add(btn1);
			}
		}catch(Exception err) {
			
		}
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setSize(ss.width, ss.height);
		backButton();
	}
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == backBtn) {
			frame.dispose();
			new Frontend();
		}
	}
	public void backButton() {
		backBtn = new JButton("<-- Back  ");
		backBtn.setBounds(50, 30, 100, 30);
		backBtn.addActionListener(this);
		frame.add(backBtn);
	}
	public static void main(String args[]) {
		ShowTest obj = new ShowTest();
		
	}
}
