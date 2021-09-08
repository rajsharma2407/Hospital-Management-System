package patient;

import java.awt.*;
import javax.swing.*;

import mainPackage.Backend;
import mainPackage.Frontend;

import java.awt.event.*;
import java.sql.*;

public class UpdatePatient implements ActionListener{
	JFrame frame;
	JTextField tf;
	JButton btn, backBtn;
	JLabel label;
	Dimension ss = Toolkit.getDefaultToolkit().getScreenSize();
	int id;
	public UpdatePatient(){
		frame = new JFrame("Update Patient");
		tf = new JTextField();
		label = new JLabel("Current treatment");
		tf.setPreferredSize(new Dimension(200, 30));
		label.setPreferredSize(new Dimension(200, 30));
		label.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));
		tf.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));
		btn = new JButton("Update");
		label.setBounds(500, 300, 200, 30);
		tf.setBounds(750, 300, 200, 30);
		btn.setBounds(750, 350, 100, 30);
		
		btn.addActionListener(this);
		frame.add(btn);
		frame.add(label);
		frame.add(tf);
		frame.setLayout(null);
		frame.setSize(ss.width, ss.height);
		frame.setVisible(true);
		backButton();
	}
	void setId(int id) {
		this.id = id;
	}
	UpdatePatient(int id){
		this.id = id; 
	}
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == backBtn) {
			new Frontend();
			frame.dispose();
			return;
		}
		Backend obj = new Backend();
		obj.updatePatient(tf.getText(), id);
		frame.dispose();
		new ShowPatients();
	}
	public void backButton() {
		backBtn = new JButton("<-- Back  ");
		backBtn.setBounds(50, 30, 100, 30);
		backBtn.addActionListener(this);
		frame.add(backBtn);
	}
	public static void main(String args[]) {
		new UpdatePatient();
	}
}
