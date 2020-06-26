package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import utils.TestUtil;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase() {
		FileInputStream ip=null;
		try {
			
			prop = new Properties();
			ip=new FileInputStream("C:\\Users\\DELL\\git\\Selenium-test\\com.qa.datacreation\\src\\main\\java\\config\\config.properties");
			prop.load(ip);
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
			
			
}
	
public static void initilaization(String user) {
		
		String browserName=prop.getProperty("browser");
		String url;
		String env=prop.getProperty("environment");
		
		
		if (browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Jenkins\\chromedriver.exe");	
			//mention the below chrome option to solve timeout exception issue
		//	ChromeOptions options = new ChromeOptions();
		//	options.setPageLoadStrategy(PageLoadStrategy.NONE);
			driver= new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
//		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	//	driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_LOAD, TimeUnit.SECONDS);
		
					
		if (user=="Admin" ||user=="Userlogin") {
			url="https://"+env+".kredx.com/login";
			driver.get(url);
		}else if(user=="Vendor"){
			url="https://"+env+".kredx.com/vendor/register";	
			driver.get(url);
		}else if(user=="Investor"){
			url="https://"+env+".kredx.com/financier/register";
			driver.get(url);
		
		} else {
			
			System.out.print("you have not selected user");
		}
			
	}


	
	

    
    
 
 
 public String takeScreenshot(WebDriver driver) throws IOException {		
		TakesScreenshot ts = (TakesScreenshot)driver;		
		//Taking screenshot
		File Screenshot = ts.getScreenshotAs(OutputType.FILE);
		//Creating the path to save the file
		String destinationPath = System.getProperty("user.dir")+"\\Screenshots\\img_name.png";		
		//creating destination file to save the screenshot
		File destinationFile = new File(destinationPath);
		//copying Screenshot to destination file
		FileUtils.copyFile(Screenshot, destinationFile);
		
		return destinationPath;		
	}


}
	

