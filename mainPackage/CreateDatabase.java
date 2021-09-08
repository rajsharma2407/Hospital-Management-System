package mainPackage;
import java.sql.*;

public class CreateDatabase {
	public static void main(String args[]) {
		String connectionString = "jdbc:mysql://localhost:3308/";
		String db = "xyz";
		String databaseQuery = "CREATE DATABASE " + db;
		String user = "root";
		String pass = "";
//		CREATE DATABASE
		try {
			Connection conn = DriverManager.getConnection(connectionString, user, pass);
			Statement smt = conn.createStatement();
			smt.executeUpdate(databaseQuery);
			System.out.println("database created");
		}catch(Exception err) {
			System.out.println("database not created "+err);
		}
		connectionString += db;
//		CREATE PATIENT TABLE
		String patientQuery = "CREATE TABLE PATIENT("
				+ "patient_id INT PRIMARY KEY AUTO_INCREMENT,"
				+ "patient_name VARCHAR(255) NOT NULL,"
				+ "blood_group VARCHAR(10),"
				+ "gender varchar(30),"
				+ "dob varchar(20),"
				+ "contact_no int(11),"
				+ "address VARCHAR(255),"
				+ "current_treatment VARCHAR(100),"
				+ "doctor_id int(11),"
				+ "FOREIGN KEY(DOCTOR_ID) REFERENCES DOCTOR(DOCTOR_ID)"
				+ ");";
		try {
			Connection conn = DriverManager.getConnection(connectionString,user,pass);
			Statement smt = conn.createStatement();
			smt.executeUpdate(patientQuery);
		}catch(Exception err) {
			System.out.println("patient table not created" + err);
		}
//		CREATE DOCTOR TABLE
		String doctorQuery = "CREATE TABLE DOCTOR("
				+ "doctor_id INT(11) PRIMARY KEY AUTO_INCREMENT,"
				+ "doctor_name VARCHAR(50),"
				+ "specialization VARCHAR(100),"
				+ "doctor_contact BIGINT,"
				+ "isAvailable tinyint(1),"
				+ "consultancy_fee int(11)"
				+ ");";
		try {
			Connection conn = DriverManager.getConnection(connectionString,user,pass);
			Statement smt = conn.createStatement();
			smt.executeUpdate(doctorQuery);
		}catch(Exception err) {
			System.out.println("doctor table not created" + err);
		}
//		CREATE PAYMENT TABLE
		String paymentQuery = "CREATE TABLE PAYMENT("
				+ "payment_id INT PRIMARY KEY AUTO_INCREMENT,"
				+ "payment_date date,"
				+ "total_amount int,"
				+ "patient_id int,"
				+ "FOREIGN KEY(PATIENT_ID) REFERENCES PATIENT(PATIENT_ID)"
				+ ");";
		try {
			Connection conn = DriverManager.getConnection(connectionString,user,pass);
			Statement smt = conn.createStatement();
			smt.executeUpdate(paymentQuery);
		}catch(Exception err) {
			System.out.println("payment table not created" + err);
		}
//		CREATE ROOM TABLE
		String roomQuery = "CREATE TABLE ROOM("
				+ "room_id int primary key auto_increment,"
				+ "isAvailable tinyint default 1,"
				+ "rooms_available int,"
				+ "room_no int not NULL,"
				+ "room_charge int default 0,"
				+ "patient_id int,"
				+ "FOREIGN KEY(PATIENT_ID) REFERENCES PATIENT(PATIENT_ID)"
				+ ");";
		try {
			Connection conn = DriverManager.getConnection(connectionString,user,pass);
			Statement smt = conn.createStatement();
			smt.executeUpdate(roomQuery);
		}catch(Exception err) {
			System.out.println("room table not created" + err);
		}
//		CREATE TESTS TABLE
		String testsQuery = "CREATE TABLE TESTS("
				+ "test_id int primary key auto_increment,"
				+ "test_date datetime,"
				+ "test_name varchar(255),"
				+ "test_result varchar(255),"
				+ "test_fee int,"
				+ "patient_id int,"
				+ "FOREIGN KEY(PATIENT_ID) REFERENCES PATIENT(PATIENT_ID)"
				+ ");";
		try {
			Connection conn = DriverManager.getConnection(connectionString,user,pass);
			Statement smt = conn.createStatement();
			smt.executeUpdate(testsQuery);
		}catch(Exception err) {
			System.out.println("tests table not created" + err);
		}
	}
}
