package adv_java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.cj.jdbc.Driver;

public class BatchUpdate {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		// 1. load or register
		Driver d = new Driver();
		DriverManager.registerDriver(d);
		// 2. establish the connection
		Connection con = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/jdbc_project?user=root&password=15feb1998");
		// creation of statement
		PreparedStatement ps=con.prepareStatement("update student_data set name=? where id=?");
		do {
			System.out.println("Enter the id that u want to update: ");
			int id2 = sc.nextInt();
			System.out.println("Enter the new name: ");
			String name1 = sc.next();
			ps.setString(1, name1);
			ps.setInt(2, id2);
			ps.addBatch();
			System.out.println("Do you want to update?\n1.Update 0.Exit");
			int opt=sc.nextInt();
			if(opt==0) {
				break;
			}
		} while (true);
		ps.executeBatch();
		System.out.println("Updation successfully");
	}

}
