package Day7;


import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import util.Base;

public class CookieAssignment extends Base {
	@Test()
	  public void Login() throws InterruptedException
	{
		  driver.get("http://127.0.0.1:8080/htmldb");
		  driver.findElement(By.xpath("//*[@type='text']")).sendKeys("sys");
		  driver.findElement(By.xpath("//*[@type='password']")).sendKeys("Newuser123");	  
		  driver.findElement(By.xpath("//*[@value='Login']")).click();
		  /*driver.findElement(By.linkText("Logout")).click();
		  driver.findElement(By.partialLinkText("Log")).click();
		  Set<Cookie> allCookies =driver.manage().getCookies();
		  for(Cookie C:allCookies) {
			  System.out.println("Cookie Name is"+C.getName());
			  System.out.println("Cookie Expiry is"+C.getExpiry());
		  }*/
		  
		  System.out.println("Deleting Cookies");
		  driver.manage().deleteAllCookies();
		  driver.navigate().refresh();
		  Assert.assertTrue(driver.findElement(By.name("p_t01")).isDisplayed());
		  Thread.sleep(4000);
	  }
}
