package billing;
import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import mainPackage.*;

public class SelectPatientForBilling implements ItemListener{
	JFrame frame;
	JLabel label;
	JComboBox cb;
	String patientId;
	Dimension ss = Toolkit.getDefaultToolkit().getScreenSize();
	public SelectPatientForBilling() {
		frame = new JFrame("Select Patient");
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3308/hpms", "root", "");
			Statement smt = conn.createStatement();String query = "SELECT distinct patient.patient_id, patient.patient_name, room.room_charge, tests.test_fee, doctor.consultancy_fee from patient"
					+ " inner join room on patient.patient_id = room.patient_id "
					+ "inner join tests on patient.patient_id = tests.patient_id "
					+ "inner join doctor on patient.doctor_id = doctor.doctor_id ";
			ResultSet rs = smt.executeQuery(query);
			rs.next();
			Vector<String> v = new Vector<String>();
			v.add("Select Patient");
			while(rs.next()) {
				v.add(String.valueOf(rs.getInt(1)));
			}
			cb = new JComboBox(v);
			cb.addItemListener(this);
			cb.setBounds(600, 350, 200, 30);
			frame.add(cb);
		}catch(Exception err) {
			System.out.println(err);
		}
		frame.setSize(ss.width, ss.height);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
	}
	public void itemStateChanged(ItemEvent ie) {
		if(ie.getStateChange() == ItemEvent.SELECTED) {
			Backend myObj = new Backend();
			myObj.setter(cb.getSelectedItem().toString());
			frame.dispose();
			Billing obj = new Billing();
		}
	}
	
	public static void main(String args[]) {
		new SelectPatientForBilling();
	}
}
