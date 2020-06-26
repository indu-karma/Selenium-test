package pages;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import base.TestBase;
import utils.TestUtil;

public class LoginLogoutPage extends TestBase{


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
	
	@FindBy(xpath = "//div[text()='ADMIN']")
	private WebElement admin;
	
	@FindBy(xpath = "//li[text()='LOG OUT']")
	private WebElement logout;
	

	@FindBy(xpath = "//div[@class='name']/span")
	private WebElement profileDropDown;
	
	public LoginLogoutPage()
	{
		PageFactory.initElements(driver, this);
		
		
	}
	
	public void adminLogin(String email, String Pwd) {
		
		
        adminLogin.sendKeys(email);
		adminPwd.sendKeys(Pwd);
		signInBtn.click();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		/*if (EnterOTP!=null) {	
		EnterOTP.sendKeys(prop.getProperty("OTP"));
		VerifyBtn.click();
	}*/
	//	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		//return new AdminDashboardPage();
	}
	
	public void adminLogout() throws Exception
	{
		TestUtil.waitForElement(admin);
		Actions action = new Actions(driver);
		action.moveToElement(admin).perform();
		admin.click();
		Thread.sleep(2000);
		TestUtil.clickOnElement(logout);
	
	}
	
	public void logout() throws Exception
	{
		TestUtil.waitForElement(profileDropDown);
		Actions action = new Actions(driver);
		action.moveToElement(profileDropDown).perform();
		profileDropDown.click();
		Thread.sleep(2000);
		TestUtil.clickOnElement(logout);
		
	}

}
