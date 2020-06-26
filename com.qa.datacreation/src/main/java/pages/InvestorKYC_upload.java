package pages;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.TestBase;
import utils.TestUtil;




public class InvestorKYC_upload extends TestBase{

	

	//Web elements	

	@FindBy(xpath="//button[contains(text(),\"VERIFY\")]") 
	WebElement VerifyMobNo;
	
	@FindBy(xpath="//input[@placeholder='Enter OTP']") 
	WebElement OTP;
	
	@FindBy(xpath="//button[text()='Verify']") 
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
	
	@FindBy(xpath="//button[text()='Save & Continue']")
	WebElement Savebutton;
	
	@FindBy(xpath="//span[@class='text-blue']")
	WebElement InvestorEmail;
	
	
	//Functions	
		
public InvestorKYC_upload(){
		
	PageFactory.initElements(driver, this);
		
	}
	
	
public String GetInvestorEmailAddress()
{
	String InvestorEmailAddess=InvestorEmail.getText();
	System.out.print("link:---"+InvestorEmailAddess);
	return InvestorEmailAddess;
	

}

public String verifyFinancierEmailAndMobile(String investorEmailAddress) throws ClassNotFoundException, SQLException {


	
	driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	JavascriptExecutor executor = (JavascriptExecutor)driver;
	executor.executeScript("arguments[0].click()",VerifyMobNo);
	
	OTP.sendKeys("000000");
	
	driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	OTPVerifyBtn.click();
	String env=prop.getProperty("environment");

	driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	String investorEmailVerifyURLFront="https://"+env+".kredx.com/verify-email?uid=";
	System.out.print("\ninvestorEmailVerifyURLFront:---"+investorEmailVerifyURLFront);
	String investorUid=TestUtil.getFinancierFrmDb(investorEmailAddress);
	
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	String investorToken=TestUtil.getTokenFrmDb(investorEmailAddress);
	String investorUrlBack="&type=USER_REGISTRATION&usertype=financier";
	String emailVerificationLink=investorEmailVerifyURLFront+investorUid+"&at="+investorToken+investorUrlBack;
	
	System.out.print("\nlink:---"+emailVerificationLink);
       
    Set<String> windows = driver.getWindowHandles();
    String investorWindow = driver.getWindowHandle();
    ((JavascriptExecutor)driver).executeScript("window.open();");
   
    Set<String> customerWindow = driver.getWindowHandles();
    customerWindow.removeAll(windows);
    String customerSiteHandle = ((String)customerWindow.toArray()[0]);
    driver.switchTo().window(customerSiteHandle);
    driver.get(emailVerificationLink);
    driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
    driver.switchTo().window(investorWindow);
 
	
	
	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    
    JavascriptExecutor ec = (JavascriptExecutor)driver;
  //  ec.executeScript("arguments[0].scrollIntoView(true);", Savebutton);
	ec.executeScript("arguments[0].click();", Savebutton);
    
	
	
	Savebutton.click();
	return investorUid;
	}
		
public void EnterOTP(){
		// Click on Verify button
	
			IVerify.click();
			IOTP.sendKeys(prop.getProperty("OTP"));
			IVerifyOTP.click();
		 }
		 


public void UploadPANCardKYCDetails(String dtOfBirth,String PanCard) throws IOException, InterruptedException
{
			 
		      JavascriptExecutor ec = (JavascriptExecutor)driver;
		      ec.executeScript("arguments[0].scrollIntoView(true);", PANCardUploadBtn);
		      ec.executeScript("arguments[0].click();", PANCardUploadBtn);
	    
			//PANCardUploadBtn.click();
			
			 driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);	
			 Runtime.getRuntime().exec("C:\\Users\\DELL\\Desktop\\Auto_Data creation\\uploadaddress\\fileup.exe");
			 
			 InvestorDOB.sendKeys(dtOfBirth);
			 PANCard.sendKeys(PanCard);
		//	 Savebutton.click();
			
}
public void UploadAddressKYCDetails(String StreetAdd,String City,String State,String Pincode) throws IOException, InterruptedException{
			
	
		//IStreetAdd.sendKeys(StreetAdd);
	    TestUtil.waitForElement(IStreetAdd);	
		IStreetAdd.sendKeys(StreetAdd);
		ICity.sendKeys(City);
		IState.sendKeys(State);
		IPincode.sendKeys(Pincode);
			//Ibutton.click();
		  //  TestUtil.scrollToElement(AddressProofUploadBtn);
		AddressProofUploadBtn.click();
		Runtime.getRuntime().exec("C:\\Users\\DELL\\Desktop\\Auto_Data creation\\uploadaddress\\fileup.exe");
		Thread.sleep(2000);
}
	

		
	
}
