package TestCaseFile;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import UtilitiesFile.ReadConfigClass;

public class BaseClass {
	public static Logger log1;
	public static WebDriver driver;
	ReadConfigClass Rc=new ReadConfigClass();
	String url=Rc.geturl();
	String browser=Rc.getbro();
	@BeforeMethod
	public void browserlaunch()
	{
		switch(browser.toLowerCase())
		{
		case "chrome":
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			break;
		case "msedge":
			driver=new EdgeDriver();
			driver.manage().window().maximize();
			break;
		case "firefox":
			driver=new FirefoxDriver();
			driver.manage().window().maximize();
			break;
		default:
			driver=null;
			break;
		}	
		log1=LogManager.getLogger("FirstProject");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	public  void  ScreenShot() throws IOException
	{
			
		File Source=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File Destination=new File("C:\\Users\\user\\Documents\\ExecuteDDF\\SereenShots\\h1.png"
				+ "");
		FileUtils.copyFile(Source, Destination);
			
			
	}
	@AfterClass
	public void closeUp()
	{
		driver.close();
		driver.quit();
	}
	
	

}
