package in.lnt.day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OrangeHrm {
	public static void main(String args[]) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		driver.findElement(By.id("txtUsername")).sendKeys("admin");	
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		driver.findElement(By.id("welcome")).click();
		//Thread.sleep(3000);
		driver.findElement(By.linkText("Logout")).click();
		}
}
