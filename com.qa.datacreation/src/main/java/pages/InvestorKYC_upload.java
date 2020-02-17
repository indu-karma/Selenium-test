package pages;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;
import utils.TestUtil;




public class InvestorKYC_upload extends TestBase{

	public static Properties prop;
	//Web elements	

	@FindBy(xpath="//button[contains(text(),\"VERIFY\")]") 
	WebElement VerifyMobNo;
	
	@FindBy(xpath="") 
	WebElement OTP;
	
	@FindBy(xpath="") 
	WebElement OTPVerifyBtn;
	
	
	@FindBy(xpath="(//span[@class='upload-icon'])[1]") 
	WebElement PANCardUploadBtn;
	
	@FindBy(xpath="//input[@id='dob']") 
	WebElement InvestorDOB;
	
	@FindBy(xpath="//input[@id='panNumber']") 
	WebElement PANCard;

	
	@FindBy(xpath="(//span[@class='upload-icon'])[2]") 
	WebElement AddressProofUploadBtn;
	
	
	@FindBy(xpath="//input[@name='street_address']") 
	WebElement IStreetAdd;
	
	@FindBy(xpath="//input[@name='city']") 
	WebElement ICity;
	
	@FindBy(xpath="//select[@name='state']") 
	WebElement IState;
	
	@FindBy(xpath="//input[@name='pincode']") 
	WebElement IPincode;
	
	@FindBy(xpath="//button[@type='submit'][@class='btn btn-kredx-primary btn-lg btn-block']") 
	WebElement Ibutton;

	@FindBy(xpath="//button[@class='btn btn-link action-btn']")
	WebElement IVerify;
	
	@FindBy(xpath="//input[@type='text'][@placeholder='Enter OTP']")
	WebElement IOTP;
	
	@FindBy(xpath="//button[@class='btn btn-kredx-primary center-block']")
	WebElement IVerifyOTP;
	
	
	//Functions	
		
public InvestorKYC_upload(){
		
	PageFactory.initElements(driver, this);
		
	}
	
	
		 
public static void verifyFinancierEmail(String investorEmailAddress) throws ClassNotFoundException, SQLException {

	System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Desktop\\Auto_Data creation\\ChromeDriver\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	
	String investorEmailVerifyURLFront="https://harry.kredx.com/verify-email?uid=";
	String investorUid=TestUtil.getFinancierFrmDb(investorEmailAddress);
	String investorToken=TestUtil.getTokenFrmDb(investorEmailAddress);
	String investorUrlBack="&type=USER_REGISTRATION&usertype=financier";
	String emailVerificationLink=investorEmailVerifyURLFront+investorUid+"&at="+investorToken+investorUrlBack;
    System.out.print("link:---"+emailVerificationLink);

	driver.get(emailVerificationLink);
	driver.close();
	}
		
public void EnterOTP(){
		// Click on Verify button
	
			IVerify.click();
			IOTP.sendKeys(prop.getProperty("OTP"));
			IVerifyOTP.click();
		 }
		 


public void UploadPANCardKYCDetails(String dtOfBirth,String PanCard) throws IOException, InterruptedException
{
			 
			 JavascriptExecutor executor = (JavascriptExecutor)driver;
			 executor.executeScript("arguments[0].click();", PANCardUploadBtn);
			 driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);	
			 Runtime.getRuntime().exec("C:\\Users\\DELL\\Desktop\\Auto_Data creation\\uploadaddress\\fileup.exe");
			 
			 InvestorDOB.sendKeys(dtOfBirth);
			 PANCard.sendKeys(PanCard);
			
			
}
public void UploadAddressKYCDetails(String StreetAdd,String City,String State,String Pincode) throws IOException, InterruptedException{
			
			IStreetAdd.sendKeys(StreetAdd);
			ICity.sendKeys(City);
			IState.sendKeys(State);
			IPincode.sendKeys(Pincode);
			//Ibutton.click();
			AddressProofUploadBtn.click();
			Runtime.getRuntime().exec("C:\\Users\\DELL\\Desktop\\Auto_Data creation\\uploadaddress\\fileup.exe");
			Thread.sleep(2000);
}
	
		
	
}
