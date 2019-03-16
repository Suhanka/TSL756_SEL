package in.lnt.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckPoints {
	public static void main(String args[]) {
		System.setProperty("webdriver.chrome.driver",".\\Drivers\\chromedriver.exe");
	      WebDriver driver= new ChromeDriver();
	      driver.get("http://127.0.0.1:8080/htmldb/");
	      WebElement E =driver.findElement(By.id("P11_USERNAME"));
	      boolean isDisplay=E.isDisplayed();
	      boolean isEnable=E.isEnabled();
	      
	      String sz=E.getAttribute("size");
	      String typ=E.getAttribute("type");
	      
	      if(isDisplay==true && isEnable==true && sz.equals("30") && typ.equals("text"))
	    	  System.out.println("Test for UserName is Pass");
	      else
	    	  System.out.println("Test for UserName is Failed");
	}

}
