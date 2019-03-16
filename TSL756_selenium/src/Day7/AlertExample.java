package Day7;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import util.Base;

public class AlertExample extends Base {
  @Test
  public void alertTest() throws InterruptedException 
  {
	  driver.get("https://www.magneticautomation.in/2019/01/alert-example.html");
	  driver.findElement(By.xpath("//button[@onclick='myFunction1()']")).click();
	  Alert A= driver.switchTo().alert();
	  String txt = A.getText();
	  System.out.println(txt);
	  Thread.sleep(3000);
	  A.accept();
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("//button[@onclick='myFunction()']")).click();
	  Alert A2=driver.switchTo().alert();
	  System.out.println(A2.getText());
	  Thread.sleep(2000);
	  A2.sendKeys("Kukuji");
	  Thread.sleep(2000);
	  A2.accept();
	  Thread.sleep(2000);
	  
	  driver.findElement(By.xpath("//button[@onclick='myFunction2()']")).click();
	  Alert A3=driver.switchTo().alert();
	  String txt1 = A3.getText();
	  System.out.println(txt1);
	  Thread.sleep(2000);
	  A3.accept();
	
  }
}
