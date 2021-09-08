package patient;
import java.awt.*;
import java.sql.*;
import java.sql.DriverManager;
import java.awt.event.*;
import javax.swing.*;

import mainPackage.Frontend;

public class ShowPatients implements ActionListener{
	JFrame frame;
	JLabel l1, l2, l3, l4, l5;
	Dimension ss = Toolkit.getDefaultToolkit().getScreenSize();
	JButton btn1;
	int dp[], rsLength = 0;
	JButton btns[], backBtn;
	public ShowPatients(){
		frame = new JFrame("Patient details");
		l1 = new JLabel("Patient id");
		l2 = new JLabel("Patient Name");
		l3 = new JLabel("Contact Number");
		l4 = new JLabel("Current treatment");
		int left = 300/2, top = 100, w = 300, h=30;
		Font f = new Font(Font.SANS_SERIF, Font.PLAIN, 24);
		l1.setBounds(left, top, w, h);
		l2.setBounds(left+=300, top, w, h);
		l3.setBounds(left+=300, top, w, h);
		l4.setBounds(left+=300, top, w, h);
		
		l1.setFont(f);
		l2.setFont(f);
		l3.setFont(f);
		l4.setFont(f);
		frame.add(l1);
		frame.add(l2);
		frame.add(l3);
		frame.add(l4);
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3308/hpms", "root", "");
			Statement smt = conn.createStatement();
			ResultSet rs = smt.executeQuery("select * from patient");
			Statement stmt = conn.createStatement();
			ResultSet tempRs = stmt.executeQuery("select Count(*) from patient");
			tempRs.next();
			rsLength = tempRs.getInt(1);
			dp= new int[rsLength];
			btns= new JButton[rsLength];
			int i=0;
			while(rs.next()) {
				int patientId = rs.getInt(1);
				String patientName = rs.getString(2);
				Long contactNo = rs.getLong(6);
				String treatment = rs.getString("current_treatment");
				
				l1 = new JLabel(String.valueOf(patientId));
				l2 = new JLabel(patientName);
				l3 = new JLabel(String.valueOf(contactNo));
				l4 = new JLabel(treatment);
				btn1 = new JButton("Update");
				left = 150;
				top += 40;
				l1.setBounds(left, top, w, h);
				l2.setBounds(left+=300, top, w, h);
				l3.setBounds(left+=300, top, w, h);
				l4.setBounds(left+=300, top, w, h);
				btn1.setBounds(left+=200, top, 100, h);
				
				l1.setFont(f);
				l2.setFont(f);
				l3.setFont(f);
				l4.setFont(f);
				btns[i] = btn1;
				btns[i].addActionListener(this);
				dp[i] = patientId;
				i++;
				frame.add(l1);
				frame.add(l2);
				frame.add(l3);
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
			new Frontend();
			frame.dispose();
		}
		for(int i=0;i<rsLength; i++) {
			if(ae.getSource() == btns[i]) {
				frame.dispose();
				UpdatePatient obj = new UpdatePatient();
				obj.setId(dp[i]);
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
		ShowPatients obj = new ShowPatients();
		
	}
}
