package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import utils.TestUtil;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase() {
		
		try {
			
			prop = new Properties();
			FileInputStream ip=new FileInputStream("C:\\Users\\DELL\\Desktop\\Auto_Data creation\\"
					+ "com.qa.datacreation\\src\\main\\java\\config\\config.properties");
			prop.load(ip);
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
			
			
}
	
	public static void initilaization() {
		
		
		String browserName=prop.getProperty("browser");
		
	
		if (browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Desktop\\Auto_Data creation\\ChromeDriver\\chromedriver.exe");	
			
			driver= new ChromeDriver();
			System.out.println("1"+browserName);
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_LOAD, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		
		System.out.println("2"+browserName);
	}
}
	

