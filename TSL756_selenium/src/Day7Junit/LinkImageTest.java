package Day7Junit;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import util.StartBrowser;

public class LinkImageTest 
{
	static  WebDriver driver;
	@SuppressWarnings("unused")
	private String url;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception
	{
		driver=StartBrowser.startBrowser("chrome");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception
	{
		driver.quit();
	}

	@Test
	public void test()
	{
		driver.get("http://seleniumhq.org");
		List<WebElement> link=driver.findElements(By.xpath("//a"));
		link.addAll(driver.findElements(By.tagName("img")));
		for(WebElement E:link)
		{
			url = E.getAttribute("href");
		}
	}

	public void urlTest(String url ) throws Exception
	{
		URL u= new URL(url);
		URLConnection c=u.openConnection();
		HttpURLConnection hc =(HttpURLConnection)c;
		hc.connect();

		int code= hc.getResponseCode();
		if (code==200)
		{
			System.out.println(url+"Working");
		}
		else
		{
			System.out.println(url+"Not Working");
		}
	}
}
