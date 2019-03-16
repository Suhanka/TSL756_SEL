package Day4NG;

import org.testng.annotations.Test;

import util.StartBrowser;

import org.testng.annotations.BeforeTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;

public class FirstNG
{
	WebDriver driver;
  @Test(priority=1)
  public void titleTest()
  {
	  driver.get("http://google.com");
	  String title=driver.getTitle();
			  Assert.assertEquals(title,"Google");
 }
  
  
  @Test(priority=2,description="Search Box Detail Testing")
  public void searchBoxTest()
  {
	  			WebElement E=driver.findElement(By.name("q"));
			  Assert.assertEquals(E.isDisplayed(),true);
			  Assert.assertEquals(E.isEnabled(),true);
			  Assert.assertEquals(E.getAttribute("maxlength"),"2048");
  }
  @BeforeTest
  public void beforeTest()
  {
	  driver=StartBrowser.startBrowser("chrome");  
  }

  @AfterTest
  public void afterTest() 
  {
	  
  }

}
