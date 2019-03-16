package util;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;

public class StartBrowser 
{
	static WebDriver driver=null;
	public static WebDriver startBrowser(String browser) 
	{
		
		if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\vshadmin\\Desktop\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\vshadmin\\Desktop\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		return driver;
	}

	public static WebDriver startBrowser(String browser, String url) 
	{
		WebDriver driver=startBrowser(browser);
		driver.get(url);
		return driver;
	}
	
	
	public static void getScreenShot(String pic) { 
	TakesScreenshot screen=( TakesScreenshot)driver;
	File src= screen.getScreenshotAs(OutputType.FILE);

	Date d=new Date();
	String date=d.toString().replaceAll(" ","_").replaceAll(":","_");
	
	
	
	try {
		FileHandler.copy(src,new File(".\\"+pic+date+".png"));
	} 
	catch (IOException e)
	{	
		e.printStackTrace();
	}
	}
}
