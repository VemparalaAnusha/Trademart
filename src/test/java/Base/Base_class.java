package Base;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import Utilities.Trademart_ReadConfig;

public class Base_class {
	public WebDriver driver;
	public static Logger log;
	Trademart_ReadConfig tr= new Trademart_ReadConfig();
	
	public String url=tr.ApplicationURL();
	public String email=tr.Email();
	public String pwd=tr.Password();
	
	@BeforeClass()
	public void OpenApplication() {
		driver=new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get(url);
		driver.manage().window().maximize();
		log=Logger.getLogger(this.getClass());
		PropertyConfigurator.configure(System.getProperty("user.dir")+"\\src\\test\\resources\\Log4j.properties");
		
		}

		@AfterClass()
		public void CloseApplication(){
			driver.close();

}
		public void CaptureScreen(WebDriver driver,String name) throws IOException
		{
			TakesScreenshot ts=(TakesScreenshot)driver;
			File src=ts.getScreenshotAs(OutputType.FILE);
			File target=new File(System.getProperty("user.dir")+"\\Screenshots\\"+name+".png");
			FileUtils.copyFile(src,target);
		}
	
		}
	


