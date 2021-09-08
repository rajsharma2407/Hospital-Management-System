package doctor;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.*;

import mainPackage.Frontend;

public class ShowDoctor implements ActionListener{
	JFrame frame;
	JLabel l1, l2, l3, l4, l5;
	Dimension ss = Toolkit.getDefaultToolkit().getScreenSize();
	JButton btn1;
	JButton  backBtn;
	public ShowDoctor(){
		frame = new JFrame("Doctro details");
		l1 = new JLabel("Doctor id");
		l2 = new JLabel("Doctor Name");
		l3 = new JLabel("Specialization");
		l4 = new JLabel("Available");
		l5 = new JLabel("Consultancy Fees");
		int left = 300/2, top = 100, w = 300, h=30;
		Font f = new Font(Font.SANS_SERIF, Font.PLAIN, 24);
		l1.setBounds(left, top, w, h);
		l2.setBounds(left+=300, top, w, h);
		l3.setBounds(left+=300, top, w, h);
		l4.setBounds(left+=300, top, w, h);
		l5.setBounds(left+=240, top, w, h);
		
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
			ResultSet rs = smt.executeQuery("select * from doctor ORDER By isavailable Desc");
			while(rs.next()) {
				int doctorId = rs.getInt(1);
				String doctorName = rs.getString(2);
				String specialization = rs.getString(3);
				boolean isAvailable = rs.getBoolean(5);
				int consultancyFee = rs.getInt(6);

				l1 = new JLabel(String.valueOf(doctorId));
				l2 = new JLabel(doctorName);
				l3 = new JLabel(specialization);
				l4 = new JLabel(isAvailable?"YES":"NO");
				l5 = new JLabel(String.valueOf(consultancyFee));
				left = 150;
				top += 40;
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
	}
	public void backButton() {
		backBtn = new JButton("<-- Back  ");
		backBtn.setBounds(50, 30, 100, 30);
		backBtn.addActionListener(this);
		frame.add(backBtn);
	}
	public static void main(String args[]) {
		ShowDoctor obj = new ShowDoctor();
		
	}
}
