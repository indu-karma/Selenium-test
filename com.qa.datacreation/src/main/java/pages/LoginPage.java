package pages;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import base.TestBase;

public class LoginPage extends TestBase{


	@FindBy(id="email")
	WebElement adminLogin;
	
	//Password
	@FindBy(id="password")
	WebElement adminPwd;
	
	//Sign up button
	@FindBy(xpath="//button[@type='submit']")
	WebElement signInBtn;
	
	//EnterOTP
	@FindBy(id="otp")
	WebElement EnterOTP;
	//VerifyBtn
	@FindBy(xpath="//button[@class='kx-btn kx-btn__primary']")
	WebElement VerifyBtn;
	
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
		
	}
	
	public void adminLogin(String email, String Pwd) {
		
		
        adminLogin.sendKeys(email);
		adminPwd.sendKeys(Pwd);
		signInBtn.click();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
	    //EnterOTP.sendKeys(prop.getProperty("OTP"));
		//VerifyBtn.click();
	//	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		//return new AdminDashboardPage();
	}
	
 /*public void vendorLogin(String email, String Pwd) {
		
	    initilaization_Vendor();
        adminLogin.sendKeys(email);
		adminPwd.sendKeys(Pwd);
		signInBtn.click();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		EnterOTP.sendKeys(prop.getProperty("OTP"));
		VerifyBtn.click();

		
	}*/
	

}
