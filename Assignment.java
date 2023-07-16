package assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.cj.jdbc.Driver;

public class Assignment {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		// 1. load or register
		Driver d = new Driver();
		DriverManager.registerDriver(d);
		// 2. establish the connection
		Connection con = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/jdbc_project?user=root&password=15feb1998");
		// creation of statement
		Statement st = con.createStatement();
		System.out.println("1. Insert \n2. Update \n3. Delete");
		System.out.println("Enter your choice: ");
		int choice = sc.nextInt();
		switch (choice) {
		case 1: {
			System.out.println("Enter id");
			int id = sc.nextInt();
			System.out.println("Enter name");
			String name = sc.next();
			System.out.println("Enter batch code");
			String batch = sc.next();
			st.execute("insert into student_data values(" + id + "," + "'" + name + "'" + ",'" + batch + "')");
			System.out.println("Data saved successfuly");
			break;

		}
		case 3: {
			System.out.println("Enter the ID that you want to delete: ");
			int id1 = sc.nextInt();
			st.execute("delete from student_data where id=" + id1);
			System.out.println("Deletion successfully");
			break;
		}
		case 2: {
			System.out.println("Enter the id that u want to update: ");
			int id2 = sc.nextInt();
			System.out.println("choose what you want to update: \n1.name \n2.batch code");
			int upt = sc.nextInt();
			String name1, batch1;
			if (upt == 1) {
				System.out.println("Enter the new name: ");
				name1 = sc.next();
				st.execute("update student_data set name='" + name1 + "' where id=" + id2);
				System.out.println("Updation successfully");
			} else if (upt == 2) {
				System.out.println("Enter the new batch code: ");
				batch1 = sc.next();
				st.execute("update student_data set batch_code='" + batch1 + "' where id=" + id2);
				System.out.println("Updation successfully");

			} else {
				System.out.println("Enter the right choice");
			}
			break;
		}
		default: {
			System.out.println("Enter the right choice");
		}

		}

	}
}
