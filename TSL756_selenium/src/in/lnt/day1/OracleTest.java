package in.lnt.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OracleTest {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",".\\Drivers\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("http://127.0.0.1:8080/htmldb/f?p=4550:11:11002924531900158622::NO:::");
		driver.findElement(By.id("P11_USERNAME")).sendKeys("sys");
		driver.findElement(By.id("P11_PASSWORD")).sendKeys("Newuser123");
		driver.findElement(By.xpath("//*[@id=\"wwvFlowForm\"]/div[6]/table/tbody/tr/td[3]/table[2]/tbody/tr/td/input[1]")).click();
		driver.findElement(By.linkText("Logout")).click();
		driver.quit();
	}

}
