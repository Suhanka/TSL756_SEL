package Day4NG;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {
		static Connection connRef; // just a reference , default value is null
		
		private MyConnection() { 
			System.out.println("MyConnection ctor...");
		}
		public static Connection getMyConnection() {
			if(connRef == null) {
				try {
		        	DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
					connRef  = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "Newuser123");
				} catch (SQLException e) {
		
					e.printStackTrace();
				}
			}
			return connRef;
		}
	}

