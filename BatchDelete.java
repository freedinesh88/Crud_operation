package adv_java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.cj.jdbc.Driver;

public class BatchDelete {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		// 1. load or register
		Driver d = new Driver();
		DriverManager.registerDriver(d);
		// 2. establish the connection
		Connection con = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/jdbc_project?user=root&password=15feb1998");
		// creation of statement
		PreparedStatement ps=con.prepareStatement("delete from student_data where id=?");
		do {
			System.out.println("Enter the ID that you want to delete: ");
			int id1 = sc.nextInt();
			ps.setInt(1, id1);
			ps.addBatch();
			System.out.println("Do you want to Delete?\n1.Delete 0.Exit");
			int opt=sc.nextInt();
			if(opt==0) {
				break;
			}
		} while (true);
		ps.executeBatch();
		System.out.println("Deletion successfully");
	}

}
