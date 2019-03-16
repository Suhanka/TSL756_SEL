package Day4NG;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import org.testng.annotations.Test;

public class Oracle 
{
	@Test
	public void f() throws Exception 
	{	
		DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
		Connection c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Newuser123");
		ResultSet rs =c.createStatement().executeQuery("select * from login");

		while(rs.next()) 
		{	
			//String username =	rs.getString(1);
			//String Password = rs.getString(2);
			//int status =rs.getInt(3);
			System.out.println(rs.getString(1));
			System.out.println(rs.getString(2));
			//System.out.println("username is "+username+"with password "+Password+"and status "+status);
		}
	}
}
