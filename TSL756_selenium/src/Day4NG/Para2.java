package Day4NG;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import util.StartBrowser;

public class Para2 
{
	WebDriver driver;
	Connection c;
	PreparedStatement pStatement;

	
  @Test(dataProvider = "dp")
  public void Login(String UN, String PWD) throws SQLException
  {
	  driver.get("http://127.0.0.1:8080/htmldb");
	  driver.findElement(By.xpath("//*[@type='text']")).sendKeys(UN);
	  driver.findElement(By.xpath("//*[@type='password']")).sendKeys(PWD);	  
	  driver.findElement(By.xpath("//*[@value='Login']")).click();
	  pStatement = c.prepareStatement("update login set status=? where userid=? and password=?");
	  pStatement.setString(2, UN);
	  pStatement.setString(3, PWD);
	  driver.findElement(By.linkText("Logout")).click();
	  driver.findElement(By.partialLinkText("Log")).click();
	  
  }

  @DataProvider
  public Object[][] dp() throws Exception
    {
	  	DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
		c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Newuser123");
		ResultSet r =c.createStatement().executeQuery("select count(*) from login");
		r.next();
		
		   	Object data[][]=new Object[r.getInt(1)][2];
		   	int i=0;
		   	ResultSet rs =c.createStatement().executeQuery("select * from login"); 
		   	while(rs.next())
		   	{
		   		data [i][0]=rs.getString(1);
		   		data [i][1]=rs.getString(2);
		   		i++;
		   	}
		
		   	return data;
		
    }
     
  @org.testng.annotations.AfterMethod
  public void AfterMethod(ITestResult result)
  {
	 try { 
	  if (result.getStatus()==ITestResult.FAILURE)
	  {
		  System.out.println("Taking Screenshots");
		  StartBrowser.getScreenShot(result.getName());
		
			pStatement.setString(1, "Fail");
		} 
	  else
	  {
		  pStatement.setString(1, "Pass");
		
	  }
	  pStatement.executeUpdate();
	  }
	  catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	 
  }
  
  @BeforeTest
  public void beforeTest() {
  driver= StartBrowser.startBrowser("chrome");
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
