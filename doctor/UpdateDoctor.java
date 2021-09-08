package doctor;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import mainPackage.*;

public class UpdateDoctor implements ActionListener{
	JFrame frame;
	JLabel label1, label2;
	JRadioButton rb1, rb2;
	ButtonGroup bg1;
	JButton btn, backBtn;
	JTextField tf1;
	Dimension ss = Toolkit.getDefaultToolkit().getScreenSize();
	
	public UpdateDoctor() {
		frame = new JFrame("Update Doctor");
		rb1 = new JRadioButton("Available");
		rb2 = new JRadioButton("Not Available");
		bg1 = new ButtonGroup();
		label1 = new JLabel("Doctor Id");
		tf1 = new JTextField();
		label1.setBounds(550, 150, 200, 30);
		Font f2 = new Font(Font.SANS_SERIF, Font.PLAIN, 20);
		label1.setFont(f2);
		tf1.setBounds(700, 150, 200, 30);
		tf1.setFont(f2);
		frame.add(tf1);
		frame.add(label1);
		bg1.add(rb1);
		bg1.add(rb2);
		Font f1 = new Font(Font.SANS_SERIF, Font.PLAIN, 30);
		rb1.setBounds(450, 300, 300, 50);
		rb2.setBounds(780, 300, 300, 50);
		rb1.setFont(f1);
		rb2.setFont(f1);
		btn = new JButton("Update");
		btn.setBounds((780+450)/2+30, 500, 100, 30);
		btn.addActionListener(this);
		
		frame.add(btn);
		frame.add(rb1);
		frame.add(rb2);
		frame.setSize(ss.width, ss.height);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
	}
	
	public void actionPerformed(ActionEvent ae) {
		boolean poss = false;
		if(rb1.isSelected())
			poss = true;
		if(ae.getSource() == btn) {
			try {
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3308/hpms","root","");
				PreparedStatement smt = conn.prepareStatement("update doctor set isavailable = ? where doctor_id = ?");
				smt.setBoolean(1, poss);
				smt.setInt(2, Integer.parseInt(tf1.getText()));
				smt.executeUpdate();
			}catch(Exception err) {
				System.out.println(err);
			}
			new Frontend();
			frame.dispose();
		}
	}
	public static void main(String args[]) {
		new UpdateDoctor();
	}
}
