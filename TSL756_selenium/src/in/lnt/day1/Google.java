package in.lnt.day1;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;

import util.StartBrowser;

public class Google 
{
	private static XSSFWorkbook book;

	public static void main(String[] args) throws Exception 
	{	    
		FileInputStream inFile=new FileInputStream("D:\\List.xlsx");
		book = new XSSFWorkbook(inFile);
		XSSFSheet sheet=book.getSheet("Sheet1");

		for(int i=0;i<=sheet.getLastRowNum();i++)
		{
			String data=sheet.getRow(i).getCell(0).toString();
			System.out.print(data);
			WebDriver driver=StartBrowser. startBrowser("chrome","https://nseindia.com");
			Actions act= new Actions(driver);
			driver.findElement(By.id("keyword")).sendKeys(data);

			WebElement E=driver.findElement(By.xpath("//b[contains(text(),'"+data+"')]"));
			act.moveToElement(E).click(E).perform();

			String value1= driver.findElement(By.id("faceValue")).getText();
			System.out.println("faceValue:"+value1);
			String value2= driver.findElement(By.id("high52")).getText();
			System.out.println("52 week high:"+value2);
			String value3= driver.findElement(By.id("low52")).getText();
			System.out.println("52 week low:"+value3);

			TakesScreenshot screen=( TakesScreenshot)driver;
			File src= screen.getScreenshotAs(OutputType.FILE);

			try 
			{
				FileHandler.copy(src,new File(".\\screen"+i+".png"));
			} 
			catch (IOException e)
			{	
				e.printStackTrace();
			}
		}
	}
}
