package billing;
import javax.swing.*;

import mainPackage.Backend;
import mainPackage.Frontend;

import java.awt.*;
import java.awt.event.*;

public class Billing implements ActionListener{
	JFrame frame;
	JLabel l1, l2, l3, l4, l5, l6, l7, l8, hd, l9, l10, l11, l12, l13, l14, l15, l16;
	JButton btn, backBtn;
	Dimension ss = Toolkit.getDefaultToolkit().getScreenSize();
	public Billing(){
		frame = new JFrame("Billing");
//		labels
		Font f1 = new Font(Font.SANS_SERIF, Font.PLAIN, 35);
		hd = new JLabel("INVOICE");
		int left = 400, right=900, top=200, w=200, h=30;
		hd.setBounds(left, 100, w, h);
		hd.setFont(f1);
		hd.setForeground(Color.BLUE);
		Font f2 = new Font(Font.SANS_SERIF, Font.PLAIN, 24);
		Font f3 = new Font(Font.SANS_SERIF, Font.PLAIN, 17);

//		Backend work
		Backend obj = new Backend();
		String arr[] = obj.patientBilling();
		
//		
		l1 = new JLabel("Name");
		l1.setBounds(left, top, w, h);
		l1.setFont(f2);
		l1.setForeground(Color.BLUE);
		
		l2 = new JLabel(arr[0]);
		l2.setBounds(left, top+=30, w, h);
		l2.setFont(f3);
		
		l3 = new JLabel("Address");
		l3.setBounds(left, top+=50, w, h);
		l3.setFont(f2);
		l3.setForeground(Color.blue);
		
		l4 = new JLabel("18 zaran colony");
		l4.setBounds(left, top+=30, w, h);
		l4.setFont(f3);
		
		l5 = new JLabel("Billing Id");
		l5.setBounds(right, 200, w, h);
		l5.setFont(f2);
		l5.setForeground(Color.BLUE);
		
		l6 = new JLabel("0123421");
		l6.setBounds(right, 230, w, h);
		l6.setFont(f3);
		
		
		l7 = new JLabel("Total Amount");
		l7.setBounds(right, 280, w, h);
		l7.setForeground(Color.BLUE);
		l7.setFont(f2);
		
		l8 = new JLabel("1200 Rs");
		l8.setBounds(right, 310, w, h);
		l8.setFont(f3);
		
		l9 = new JLabel("Consultancy Fees");
		l9.setBounds(left, top+=100, w, h);
		l9.setFont(f2);
		
		l10 = new JLabel("Test charges");
		l10.setBounds(left, top+=60, w, h);
		l10.setFont(f2);
		
		l11 = new JLabel("Bed charges");
		l11.setBounds(left, top+=60, w, h);
		l11.setFont(f2);
		
		l12 = new JLabel("Total Amount");
		l12.setBounds(left, top+=100, w, h);
		l12.setFont(f2);
		
		top = 310;
		l13 = new JLabel(arr[3]);
		l13.setBounds(right, top+=100, w, h);
		l13.setFont(f2);
		
		l14 = new JLabel(arr[2]);
		l14.setBounds(right, top+=60, w, h);
		l14.setFont(f2);
		
		l15 = new JLabel(arr[1]);
		l15.setBounds(right, top+=60, w, h);
		l15.setFont(f2);
		int totalSum = Integer.parseInt(arr[1])+Integer.parseInt(arr[2])+Integer.parseInt(arr[3]);
		l16 = new JLabel(String.valueOf(totalSum)+" Rs");
		l16.setBounds(right, top+=100, w, h);
		l16.setFont(f2);
		
		btn= new JButton("Pay");
		btn.setBounds(right, top+=60, w-100, h+10);
		btn.setFont(f2);
		btn.setForeground(Color.WHITE);
		btn.setBackground(new Color(100, 100, 200));
		frame.add(l1);
		frame.add(l2);
		frame.add(l3);
		frame.add(l4);
		frame.add(l5);
		frame.add(l6);
		frame.add(l7);
		frame.add(l8);
		frame.add(l9);
		frame.add(l10);
		frame.add(l11);
		frame.add(l12);
		frame.add(l13);
		frame.add(l14);
		frame.add(l15);
		frame.add(l16);
		frame.add(hd);
		frame.add(btn);
		frame.setLayout(null);
		frame.setSize(ss.width, ss.height);
		frame.setVisible(true);
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
		}
	}
	public static void main(String args[]) {
		new Billing();
	}
}
