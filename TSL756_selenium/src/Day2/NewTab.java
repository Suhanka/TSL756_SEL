package Day2;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import util.StartBrowser;

public class NewTab{

	public static void main(String[] args) 
	{

		WebDriver driver=StartBrowser. startBrowser("chrome","https://www.seleniumhq.org/");
		String ParentID = driver.getWindowHandle();
		/*Actions action=new Actions(driver);
      WebElement search=driver.findElement(By.linkText("Download"));
      WebElement search1=driver.findElement(By.linkText("Projects"));

     Action a= action.moveToElement(search).keyDown(Keys.CONTROL).click(search).keyUp(Keys.CONTROL).build();
     Action a1= action.moveToElement(search1).keyDown(Keys.CONTROL).click(search1).keyUp(Keys.CONTROL).build();
	a.perform();
	a1.perform();*/
		List <WebElement> allWeb = driver.findElements(By.xpath("/html/body/div[3]/div[1]/ul/li"));
		System.out.println(allWeb.size());
		/*for (WebElement E: allWeb) {
		new Actions(driver).keyDown(Keys.CONTROL).click(E).keyUp(Keys.CONTROL).perform();
		}
		 */
		Iterator<WebElement> list = allWeb.iterator();
		while (list.hasNext()) 
		{
			WebElement web = list.next();
			new Actions(driver).keyDown(Keys.CONTROL).click(web).keyUp(Keys.CONTROL).perform();
		}

		Set<String> all = driver.getWindowHandles();
		Iterator<String> itr = all.iterator();

		while (itr.hasNext()) 
		{
			String ID = itr.next();
			System.out.println(ID);
			if(!(ID.equals(ParentID)))
			{
				driver.switchTo().window(ID);
				System.out.println(driver.getTitle());
				driver.close();
			}
			driver.switchTo().window(ParentID);
		}
	}
}
