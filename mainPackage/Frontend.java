package mainPackage;
import java.awt.*;
import javax.swing.*;

import billing.*;
import doctor.*;
import patient.Registeration;
import patient.ShowPatients;
import patient.UpdatePatient;
import room.AvailableRooms;
import tests.*;

import java.awt.event.*;
import java.util.EventObject;
public class Frontend implements ActionListener{
	JFrame frame;
	JMenuBar mb;
	JMenu menu;
	JMenuItem i1, i2, i3, i4, i5, i6, i7;
	JTextArea tx1, tx2;
	JLabel l1;
	Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
	
	JPanel panel1, panel2;
	JSplitPane splitPane;
	JButton btnRegisterPatient, btnShowPatient, btnUpdatePatient, btnRegisterDoctor, btnShowDoctor, btnBilling, btnRoomsAvailable, btnShowTests, btnUpdateDoctor, btnInsertTests;
	JScrollBar sbar = new JScrollBar();
	JLabel heading1;
	
	public Frontend(){
		frame = new JFrame("Medicaps Hospital");
		mb = new JMenuBar();
		menu = new JMenu("Dashboard");
		i1 = new JMenuItem("Register");
		i2 = new JMenuItem("Update records");
		i3 = new JMenuItem("Tests");
		i4 = new JMenuItem("Billing");
		i5 = new JMenuItem("Patient details");

		i1.addActionListener(this);
		i2.addActionListener(this);
		i3.addActionListener(this);
		i4.addActionListener(this);
		i5.addActionListener(this);
		menu.add(i1);
		menu.add(i2);
		menu.add(i3);
		menu.add(i4);
		menu.add(i5);
		mb.add(menu);
		frame.setJMenuBar(mb);

		panel1 = new JPanel(new FlowLayout(FlowLayout.LEADING, 50, 100));
		panel2 = new JPanel();
		panel2.setBorder(BorderFactory.createEmptyBorder(50, 300, 50, 300));

		Color c1 = new Color(240, 240, 255);
		Color c2 = new Color(210, 210, 255);
		panel1.setBackground(c1);
		panel2.setBackground(c2);

		((FlowLayout)panel2.getLayout()).setHgap(30);
		((FlowLayout)panel2.getLayout()).setVgap(30);
		
		Dimension dm1 = new Dimension(160, 100);
		btnRegisterPatient = new JButton("New Patient");
		btnShowPatient = new JButton("Show Patients");
		btnShowDoctor = new JButton("Show Doctors");
		btnUpdatePatient = new JButton("Update Patient");
		btnRegisterDoctor = new JButton("Register Doctor");
		btnBilling = new JButton("Billing");
		btnShowTests = new JButton("Show Tests");
		btnRoomsAvailable = new JButton("Available Rooms");
		btnInsertTests = new JButton("Add Test");
		btnUpdateDoctor = new JButton("Update Doctor");
		
		
		btnRegisterPatient.setPreferredSize(dm1);
		btnShowPatient.setPreferredSize(dm1);
		btnShowDoctor.setPreferredSize(dm1);
		btnRegisterDoctor.setPreferredSize(dm1);
		btnUpdatePatient.setPreferredSize(dm1);
		btnBilling.setPreferredSize(dm1);
		btnShowTests.setPreferredSize(dm1);
		btnRoomsAvailable.setPreferredSize(dm1);
		btnInsertTests.setPreferredSize(dm1);
		btnUpdateDoctor.setPreferredSize(dm1);
		
		
		Font f1 = new Font(Font.SANS_SERIF , Font.BOLD, 15);
		
//		Fonts
		btnRegisterPatient.setFont(f1);
		btnShowPatient.setFont(f1);
		btnShowDoctor.setFont(f1);
		btnRegisterDoctor.setFont(f1);
		btnUpdatePatient.setFont(f1);
		btnBilling.setFont(f1);
		btnShowTests.setFont(f1);
		btnRoomsAvailable.setFont(f1);
		btnInsertTests.setFont(f1);
		btnUpdateDoctor.setFont(f1);
		
//		Background color
		Color bg1 = new Color(155, 105, 255);
		btnRegisterPatient.setBackground(bg1);
		btnShowPatient.setBackground(bg1);
		btnShowDoctor.setBackground(bg1);
		btnRegisterDoctor.setBackground(bg1);
		btnUpdatePatient.setBackground(bg1);
		btnBilling.setBackground(bg1);
		btnShowTests.setBackground(bg1);
		btnRoomsAvailable.setBackground(bg1);
		btnInsertTests.setBackground(bg1);
		btnUpdateDoctor.setBackground(bg1);
//		Foreground color
		Color fg1 = new Color(255, 255, 255);
		btnRegisterPatient.setForeground(fg1);
		btnShowPatient.setForeground(fg1);
		btnShowDoctor.setForeground(fg1);
		btnRegisterDoctor.setForeground(fg1);
		btnUpdatePatient.setForeground(fg1);
		btnBilling.setForeground(fg1);
		btnShowTests.setForeground(fg1);
		btnRoomsAvailable.setForeground(fg1);
		btnInsertTests.setForeground(fg1);
		btnUpdateDoctor.setForeground(fg1);
//		action listener

		btnRegisterPatient.addActionListener(this);
		btnShowPatient.addActionListener(this);
		btnShowDoctor.addActionListener(this);
		btnRegisterDoctor.addActionListener(this);
		btnUpdatePatient.addActionListener(this);
		btnBilling.addActionListener(this);
		btnShowTests.addActionListener(this);
		btnRoomsAvailable.addActionListener(this);
		btnInsertTests.addActionListener(this);
		btnUpdateDoctor.addActionListener(this);
		
		heading1 = new JLabel("Admin Dashboard");
		heading1.setBounds(100,30, 400, 30);
		heading1.setFont(new Font(Font.SANS_SERIF , Font.PLAIN, 35));
		heading1.setForeground(Color.BLUE);
		
		panel1.add(heading1);
		panel2.add(btnRegisterPatient);
		panel2.add(btnShowPatient);
		panel2.add(btnRegisterDoctor);
		panel2.add(btnShowDoctor);
		panel2.add(btnUpdatePatient);
		panel2.add(btnBilling);
		panel2.add(btnShowTests);
		panel2.add(btnRoomsAvailable);
		panel2.add(btnInsertTests);
		panel2.add(btnUpdateDoctor);
		
		panel1.setLayout(null);
		splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, panel1, panel2);
		splitPane.setDividerLocation(100);
		splitPane.setDividerSize(0);
		
		frame.add(sbar);
		frame.add(splitPane);
		frame.setSize(screensize.width, screensize.height);
		frame.setVisible(true);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
	}
	
	public void actionPerformed(ActionEvent ae) {
		String cmd = ae.getActionCommand();

		if(cmd.equals("Register") || ae.getSource() == btnRegisterPatient) {
			new Registeration();
			frame.dispose();
		}else if(cmd.equals("Register Doctor") || ae.getSource() == btnRegisterDoctor) {
			new RegisterDoctor();
			frame.dispose();
		}else if(cmd.equals("Billing")) {
			new SelectPatientForBilling();
			frame.dispose();
		}else if(ae.getSource() == i3 || cmd.equals("Show Tests")) {
			new ShowTest();
			frame.dispose();
		}else if(ae.getSource() == i5 || ae.getSource() == btnShowPatient) {
			new ShowPatients();
			frame.dispose();
		}else if(cmd.equals("Show Doctors")) {
			new ShowDoctor();
			frame.dispose();
		}else if(ae.getSource() == btnUpdatePatient || cmd.equals("Update records")) {
			new UpdatePatient();
			frame.dispose();
		}else if(cmd.equals("Available Rooms")) {
			new AvailableRooms();
			frame.dispose();
		}else if(cmd.equals("Update Doctor")) {
			new UpdateDoctor();
			frame.dispose();
		}else if(cmd.equals("Add Test")) {
			new InsertTest();
			frame.dispose();
		}
	}
	
	public static void main(String[] args) {
		Frontend obj = new Frontend();
	}
}
