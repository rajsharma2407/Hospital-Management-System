package mainPackage;
import java.sql.*;
public class Backend {
	private String connectionString = "jdbc:mysql://localhost:3308/hpms";
	private String username = "root";
	private String password = "";
//	Register patient
	public Backend() {
		
	}
	public void registerPatient(String t1, String t2, String t3, String t4, Long t5, String t6, String t7) {
		try {
			Connection conn = DriverManager.getConnection(connectionString,username,password);
			PreparedStatement smt = conn.prepareStatement("insert into patient values(NULL, ?, ?, ?, ?, ?, ?, ?)");
			smt.setString(1, t1);
			smt.setString(2, t2);
			smt.setString(3, t3);
			smt.setString(4, t4);
			smt.setLong(5, t5);
			smt.setString(6, t6);
			smt.setString(7, t7);
			int i = smt.executeUpdate();
			System.out.println(i+" records inserted");
			conn.close();
		}catch(Exception err) {
			System.out.println(err);
		}
	}
	
//	Register Doctor
	public void registerDoctor(String name, String specialization, long no, boolean abl, int fee) {
		try {
			Connection conn = DriverManager.getConnection(connectionString, username, password);
			PreparedStatement smt = conn.prepareStatement("insert into doctor values(NULL,?,?,?,?,?)");
			smt.setString(1, name);
			smt.setString(2, specialization);
			smt.setLong(3, no);
			smt.setBoolean(4, abl);
			smt.setInt(5, fee);
			int i = smt.executeUpdate();
			System.out.println(i+" records inserted");
			conn.close();
		}catch(Exception err) {
			System.out.println(err);
		}
	}
	
//	Register More Rooms
	public void registerRoom() {
		try {
			Connection conn = DriverManager.getConnection(connectionString,username,password);
			PreparedStatement smt = conn.prepareStatement("insert into room values(NULL, ?, ?, ?)");
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select count(*) from room");
			rs.next();
			int totalRooms = rs.getInt(1);
			smt.setBoolean(1, false);
			smt.setInt(2, totalRooms);
			smt.setInt(3, totalRooms+1);
			smt.executeUpdate();
			System.out.println("records inserted");
			conn.close();
		}catch(Exception err) {
			System.out.println("register rooms error " + err);
		}
	}
	
//	Insert Test
	public void insertTest(String name, String result, int fee, int patientId) {
		try {
			Connection conn = DriverManager.getConnection(connectionString,username,password);
			PreparedStatement smt = conn.prepareStatement("INSERT INTO TESTS VALUES(NULL, NOW(), ?, ?, ?, ?)");
			smt.setString(1, name);
			smt.setString(2, result);
			smt.setInt(3, fee);
			smt.setInt(4, patientId);
			int i =smt.executeUpdate();
			System.out.println(i+" Tests updated");
			conn.close();
		}catch(Exception err) {
			System.out.println("Tests error "+err);
		}
	}
	
//	UPDATE PATIENT
	public void updatePatient(String treatment, int patientId) {
		try {
			Connection conn = DriverManager.getConnection(connectionString, username, password);
			PreparedStatement smt = conn.prepareStatement("update patient set current_treatment = ? where patient_id = ?");
			smt.setString(1, treatment);
			smt.setInt(2, patientId);
			int i = smt.executeUpdate();
			System.out.println(i + " record updated successfully");
			conn.close();
		}catch(Exception err) {
			System.out.println("Update error "+err);
		}
	}
	
//	UPDATE DOCTOR
	public void updateDoctor() {
		try {
			Connection conn = DriverManager.getConnection(connectionString, username,password);
			PreparedStatement smt = conn.prepareStatement("update doctor set isAvailable = ? where doctor_id = ?");
			smt.setBoolean(1, true);
			smt.setInt(2, 2);
			smt.executeUpdate();
			System.out.println("updated availability");
			conn.close();
		}catch(Exception err) {
			System.out.println("doctor update error "+err);
		}
	}
	
//	UPDATE ROOMS
	public void updateRoom() {
		try {
			Connection conn = DriverManager.getConnection(connectionString, username, password);
			String query = "UPDATE ROOM SET isAvailable = ? where room_id = ?";
			PreparedStatement smt = conn.prepareStatement(query);
			smt.setBoolean(1, true);
			smt.setInt(2, 2);
			smt.executeUpdate();
			Statement newStmt = conn.createStatement();
			ResultSet newRs = newStmt.executeQuery("select count(*) from room where isAvailable = true");
			newRs.next();
			PreparedStatement stmt = conn.prepareStatement("Update Room set rooms_available = ?");
			stmt.setInt(1, newRs.getInt(1));
			stmt.executeUpdate();
			conn.close();
			System.out.println("Updated rooms");
		}catch(Exception err) {
			System.out.println("Room exception "+ err);
		}
	}
//	Discharge methods
//	billing
	String patientId = "1";
	public void setter(String x) {
		patientId = x;
	}
	public String getter() {
		return patientId;
	}
	public String[] patientBilling() {
		String arr[] = new String[4];
		try {
			Connection conn = DriverManager.getConnection(connectionString, username, password);
			String query = "SELECT Distinct patient.patient_id, patient.patient_name, room.room_charge, tests.test_fee, doctor.consultancy_fee from patient"
					+ " inner join room on patient.patient_id = room.patient_id "
					+ "inner join tests on patient.patient_id = tests.patient_id "
					+ "inner join doctor on patient.doctor_id = doctor.doctor_id ";
			Statement smt = conn.createStatement();
			ResultSet rs = smt.executeQuery(query);
			int patient_id, room_charge=10, test_fee=20, consultancy_fee=30;
			String patient_name = "Balbir singh";
			while(rs.next()) {
				if(getter() == String.valueOf(rs.getInt(1))) {		
					patient_name = rs.getString("patient_name");
					room_charge = rs.getInt("room_charge");
					test_fee = rs.getInt("test_fee");
					consultancy_fee = rs.getInt("consultancy_fee");
				}
			}
			arr[0] = patient_name;
			arr[1] = String.valueOf(room_charge);
			arr[2] = String.valueOf(test_fee);
			arr[3] = String.valueOf(consultancy_fee);
//			System.out.println("patient name " +patient_name +"\nroom charge "+room_charge + "\nTest fees "+test_fee+"\nconsultancy fees "+ consultancy_fee + "\nTotal Amount = " + (test_fee+consultancy_fee+room_charge));
			conn.close();
		}catch(Exception err) {
			System.out.println("Billing error "+ err);
		}
		return arr;
	}
	
	
//	Main method
	public static void main(String[] args) {
		Backend obj = new Backend();
		obj.updateRoom();
	}
}

