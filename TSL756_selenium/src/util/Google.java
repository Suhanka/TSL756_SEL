package util;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Google 
{
	public static void main(String[] args) 
	{
		WebDriver driver=StartBrowser.startBrowser("chrome","https://www.google.com");
		
		Actions act= new Actions(driver);

		WebElement search=driver.findElement(By.name("q"));
		
		   act.moveToElement(search)
				.keyDown(Keys.SHIFT)
				.sendKeys(search,"minion")
				.keyUp(Keys.SHIFT)
				.sendKeys(search,Keys.ENTER)
				.perform();
		   act.click(driver.findElement(By.linkText("Images"))).perform();
	}
}
