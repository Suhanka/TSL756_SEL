package Day2;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;

import util.StartBrowser;

public class Google {

	public static void main(String[] args) 
	{

		WebDriver driver=StartBrowser. startBrowser("chrome","https://nseindia.com");
		Actions act= new Actions(driver);
		driver.findElement(By.id("keyword")).sendKeys("Reliance Industries Limited");

		WebElement E=driver.findElement(By.xpath("//*[text()='Reliance Industries Limited']"));
		act.moveToElement(E).click(E).perform();

		TakesScreenshot screen=( TakesScreenshot)driver;
		File src= screen.getScreenshotAs(OutputType.FILE);

		try 
		{
			FileHandler.copy(src,new File(".\\screen.png"));
		} 
		catch (IOException e)
		{	
			e.printStackTrace();
		}

		String value1= driver.findElement(By.id("faceValue")).getText();
		System.out.println("faceValue:"+value1);
		String value2= driver.findElement(By.id("high52")).getText();
		System.out.println("52 week high:"+value2);
		String value3= driver.findElement(By.id("low52")).getText();
		System.out.println("52 week low:"+value3);
	}
}
