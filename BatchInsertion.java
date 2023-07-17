package adv_java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.cj.jdbc.Driver;

public class BatchInsertion {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		// 1. load or register
		Driver d = new Driver();
		DriverManager.registerDriver(d);
		// 2. establish the connection
		Connection con = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/jdbc_project?user=root&password=15feb1998");
		// creation of statement
		PreparedStatement ps=con.prepareStatement("insert into student_data values(?,?,?)");
		do {
			System.out.println("Enter id");
			int id = sc.nextInt();
			System.out.println("Enter name");
			String name = sc.next();
			System.out.println("Enter batch code");
			String batch = sc.next();
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setString(3, batch);
			ps.addBatch();
			System.out.println("Do you want to insert?\n1.Insert 0.Exit");
			int opt=sc.nextInt();
			if(opt==0) {
				break;
			}
		} while (true);
		ps.executeBatch();
		System.out.println("insertion successfully");

	}

}
