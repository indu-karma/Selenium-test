package pages;

import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import base.TestBase;

public class InvestorSLASigning extends TestBase{
	
	public static Properties prop;
	
	@FindBy(id="checkbox-accept")
	WebElement TnCcheckbox;
	
	
	@FindBy(xpath="//button[@class='btn btn-kredx-special']")
	WebElement SubmitSLA;
	

	@FindBy(xpath="//btn btn-kredx-primary btn-lg accept-send-otp-button")
	WebElement AcceptAndSendOTPBtn;
	
	@FindBy(id="otp")
	WebElement otp;
	
	@FindBy(xpath="kx-btn kx-btn__primary")
	WebElement VerifyBtn;

	public InvestorSLASigning(){
		
		PageFactory.initElements(driver, this);
			
		}
	
	public void SignSLA(){
		
		TnCcheckbox.click();
		SubmitSLA.click();
		AcceptAndSendOTPBtn.click();
		otp.sendKeys(prop.getProperty("OTP"));
		VerifyBtn.click();
		
		
		
	}
	
	

}
