package Day2;

import org.openqa.selenium.*;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import util.StartBrowser;

public class OrangeHRM_Action 
{
	public static void main(String[] args) 
	{

/*		System.setProperty("webdriver.chrome.driver", "C:\\Users\\vshadmin\\Desktop\\chromedriver.exe");
 *		WebDriver driver=new ChromeDriver();
 *		driver.get("https://opensource-demo.orangehrmlive.com/");
 */
		WebDriver driver=StartBrowser.startBrowser("chrome","https://opensource-demo.orangehrmlive.com/");

		Actions action= new Actions(driver);

		driver.findElement(By.name("txtUsername")).sendKeys("admin");
		driver.findElement(By.name("txtPassword")).sendKeys("admin123");
		driver.findElement(By.name("Submit")).click();

		action.moveToElement(driver.findElement(By.id("menu_admin_viewAdminModule"))).perform();
		action.moveToElement(driver.findElement(By.linkText("Organization"))).perform();
		action.click(driver.findElement(By.linkText("General Information"))).perform();
	}
}
