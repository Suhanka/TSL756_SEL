package Day2;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Read {
	public static void main(String[] args) throws Exception
	{
		FileInputStream inFile=new FileInputStream("D:\\abc.xlsx");
		@SuppressWarnings("resource")
		XSSFWorkbook book=new XSSFWorkbook(inFile);
		XSSFSheet sheet=book.getSheet("Sheet1");
	
		for(int i=0;i<=sheet.getLastRowNum();i++)
		{
			String data=sheet.getRow(i).getCell(0).toString();
			System.out.print(data);
			String data2=sheet.getRow(i).getCell(1).toString();
			System.out.println(" " +data2);
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\vshadmin\\Desktop\\geckodriver.exe");
			WebDriver driver= new FirefoxDriver();
			driver.get("http://127.0.0.1:8080/htmldb/");
			driver.findElement(By.id("P11_USERNAME")).sendKeys(data);
			driver.findElement(By.id("P11_PASSWORD")).sendKeys(data2);
			driver.findElement(By.xpath("//*[@id=\"wwvFlowForm\"]/div[6]/table/tbody/tr/td[3]/table[2]/tbody/tr/td/input[1]")).click();
			
			if(driver.getTitle().equals("Oracle")) {
				System.out.println("successful for row="+i);
			sheet.getRow(i).getCell(1).setCellValue("sucessful");
			}
			else {
				System.out.println("unsuccessful for row="+i);
				sheet.getRow(i).getCell(1).setCellValue("unsucessful");
				FileOutputStream op= new FileOutputStream("D:\\Book1.xlsx");
				book.write(op);
			}
			driver.quit();
		}
	}

}
