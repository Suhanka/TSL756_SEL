package Day4NG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import util.Excel;
import util.StartBrowser;

public class Para 
{
	WebDriver driver;
	

	
  @Test(dataProvider = "dp")
  public void Login(String UN, String PWD)
  {
	  driver.get("http://127.0.0.1:8080/htmldb");
	  driver.findElement(By.xpath("//*[@type='text']")).sendKeys(UN);
	  driver.findElement(By.xpath("//*[@type='password']")).sendKeys(PWD);	  
	  driver.findElement(By.xpath("//*[@value='Login']")).click();
	  driver.findElement(By.linkText("Logout")).click();
	  driver.findElement(By.partialLinkText("Log")).click();
	  
  }

  @DataProvider
  public Object[][] dp() throws Exception
    {
		
		   	Object data[][]=new Object[4][2];
		   	Excel excel= new Excel("D:\\abc.xlsx");
		   	for (int i=0;i<=excel.rowCount("Sheet1");i++)
		   	{
		   		data [i][0]=excel.Read("Sheet1",i,0);
		   		data [i][1]=excel.Read("Sheet1",i,1);;
		   	}
		
		   	return data;
		
    }
     
  @org.testng.annotations.AfterMethod
  public void AfterMethod(ITestResult result)
  {
	  System.out.println(ITestResult.FAILURE);
	  System.out.println(ITestResult.SUCCESS);
	  System.out.println(ITestResult.SKIP);
	  if (result.getStatus()==ITestResult.FAILURE)
	  {
		  System.out.println("Taking Screenshots");
		  StartBrowser.getScreenShot(result.getName());
	  }
  }
  
  @BeforeTest
  public void beforeTest() {
  driver= StartBrowser.startBrowser("chrome");
  }

  @AfterTest
  public void afterTest() {
  }

}
