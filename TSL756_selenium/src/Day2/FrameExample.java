package Day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import util.StartBrowser;

public class FrameExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = StartBrowser.startBrowser("chrome", "C:\\Users\\vshadmin\\Desktop\\frame.html");
		Actions act = new Actions(driver);
		driver.switchTo().frame(0);
		driver.findElement(By.name("q")).sendKeys("lnt");
		driver.switchTo().defaultContent();           //or  driver.switchTo().parentFrame();    //or  driver.switchTo().frame("new");   
		driver.switchTo().frame(1);
		driver.findElement(By.name("userName")).sendKeys("lnt");
		driver.switchTo().parentFrame();
		driver.switchTo().frame(2);
		driver.findElement(By.name("p_t01")).sendKeys("sys");
		driver.findElement(By.name("p_t02")).sendKeys("Newuser123");
		act.click(driver.findElement(By.cssSelector("input[value='Login']"))).perform();
		}

}
