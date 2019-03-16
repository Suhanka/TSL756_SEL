package Day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import util.StartBrowser;

public class ScreenShot 
{
	public static void main(String[] args) 
	{		
		WebDriver driver = StartBrowser.startBrowser("firefox", "https://jqueryui.com/droppable/");
		Actions act = new Actions(driver);

		driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
		WebElement srElement = driver.findElement(By.id("draggable"));
		WebElement desElement = driver.findElement(By.id("droppable"));
		act.dragAndDrop(srElement, desElement).perform();
		
		StartBrowser.getScreenShot("akash1");
	}
}
