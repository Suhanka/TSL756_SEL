package in.lnt.day1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDown {
  public static void main(String [] args)
  {
	  System.setProperty("webdriver.chrome.driver",".\\Drivers\\chromedriver.exe");
      WebDriver driver= new ChromeDriver();
      driver.get("http://www.blazedemo.com/");
  
      Select select= new Select(driver.findElement(By.name("fromPort")));
      //select.selectByVisibleText("Portland");
    //  select.selectByValue("Boston");
      //System.out.println(driver.findElement(By.name("fromPort")).getText());      // same as below code 
      
     List<WebElement> ls  = select.getOptions();
     for (int i = 0 ; i<ls.size();i++)
     {
    	 System.out.println(ls.get(i).getText());
     }
     		new Select (driver.findElement(By.name("toPort"))).selectByVisibleText("Rome");
     		driver.findElement(By.cssSelector("input[value='Find Flights']")).click();
       		driver.findElement(By.cssSelector("input[value='Choose This Flight']")).click();
       		driver.findElement(By.id("inputName")).sendKeys("jai");
    		driver.findElement(By.id("address")).sendKeys("Newuser123");
    		driver.findElement(By.id("city")).sendKeys("Indore");
    		driver.findElement(By.id("state")).sendKeys("Madhya Pradesh");
    		driver.findElement(By.id("zipCode")).sendKeys("452010");
    	    new Select(driver.findElement(By.name("cardType"))).selectByVisibleText("American Express");
    	    
    		//driver.findElement(By.id("cardType")).sendKeys("American Express");
    		driver.findElement(By.id("creditCardNumber")).sendKeys("857867");
    		driver.findElement(By.id("creditCardMonth")).clear();
    		driver.findElement(By.id("creditCardMonth")).sendKeys("January");
    		driver.findElement(By.id("creditCardYear")).clear();
    		driver.findElement(By.id("creditCardYear")).sendKeys("2019");
    		driver.findElement(By.id("nameOnCard")).sendKeys("Jai");
    		driver.findElement(By.id("rememberMe")).click();
    		driver.findElement(By.cssSelector("input[value='Purchase Flight']")).click();
    		
    		
    		
    		
    		
    		
    		
    		
     //hold any kind of information --web element	from selenium to store any kind of web object ,hold the web objects 
  }

}
