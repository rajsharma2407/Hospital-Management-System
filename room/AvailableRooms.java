package room;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;

import mainPackage.Frontend;

public class AvailableRooms implements ActionListener{
	JFrame frame;
	JButton btns[], backBtn;
	Dimension ss = Toolkit.getDefaultToolkit().getScreenSize();
	int rooms = 0;
	JPanel panel;
	public AvailableRooms() {
		frame = new JFrame("Available Rooms");
		frame.setLayout(new FlowLayout());
		Font f = new Font(Font.SANS_SERIF, Font.PLAIN, 25);
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3308/hpms", "root", "");
			Statement smt = conn.createStatement();
			ResultSet rs = smt.executeQuery("SELECT * FROM ROOM");
			Statement stmt = conn.createStatement();
			ResultSet newRs = stmt.executeQuery("Select count(*) from room");
			newRs.next();
			rooms = newRs.getInt(1);
			btns = new JButton[rooms];
			panel = new JPanel(new GridLayout(rooms/5, 5));
			int i=0;
			while(rs.next()) {
				btns[i] = new JButton("Room  "+ rs.getString("room_no"));
				btns[i].setPreferredSize(new Dimension(200, 50));
				btns[i].setFont(f);
				if(rs.getBoolean(2) == true) {
					btns[i].setBackground(Color.GREEN);
				}else {
					btns[i].setBackground(Color.RED);
				}
				btns[i].setForeground(Color.white);
				btns[i].addActionListener(this);
				panel.add(btns[i]);
				i++;
			}

	
		}catch(Exception err) {
			System.out.println("Error available rooms");
		}
		panel.setBorder(BorderFactory.createEmptyBorder(50, 300, 50, 300));
		((GridLayout)panel.getLayout()).setHgap(30);
		((GridLayout)panel.getLayout()).setVgap(30);
		frame.add(panel);
		frame.setVisible(true);
		frame.setSize(ss.width, ss.height);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		backButton();
	}
	public void backButton() {
		backBtn = new JButton("<-- Back  ");
		backBtn.setBounds(50, 30, 100, 30);
		backBtn.addActionListener(this);
		frame.add(backBtn);
	}
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == backBtn) {
			new Frontend();
			frame.dispose();
		}else {
			for(int i=0;i<rooms;i++) {
				if(ae.getSource() == btns[i]) {
					try {
						System.out.println(i+1);
						Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3308/hpms", "root", "");
						System.out.println(i+1);
						PreparedStatement smt = conn.prepareStatement("UPDATE ROOM SET isavailable = ?, patient_id = ? where room_id = "+String.valueOf(i+1));
						Statement stmt = conn.createStatement();
						ResultSet rs = stmt.executeQuery("SELECT * FROM ROOM WHERE ROOM_id = "+String.valueOf(i+1));
						rs.next();
						boolean poss = rs.getBoolean(2);
						if(poss == true) {
							smt.setBoolean(1, false);
							String patientId = (String)JOptionPane.showInputDialog(frame, "Enter patient Id","Room Entry", JOptionPane.PLAIN_MESSAGE);
							smt.setInt(2, Integer.parseInt(patientId));
							btns[i].setBackground(Color.RED);
						}else {
							smt.setBoolean(1, true);
							smt.setInt(2, -1);
							btns[i].setBackground(Color.GREEN);
						}
						smt.executeUpdate();
						conn.close();
					}catch(Exception err) {
						System.out.println("Error "+ err);
					}
					
							
				}
			}
		}
	}
	public static void main(String[] args) {
		new AvailableRooms();
	}
}
