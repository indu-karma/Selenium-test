package pages;

import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import base.TestBase;

public class InvestorSLASigning extends TestBase{
	
	public static Properties prop;
	
	@FindBy(id="checkbox-accept")
	WebElement TnCcheckbox;
	
	
	@FindBy(xpath="//button[text()='Click here to sign']")
	WebElement SubmitSLA;
	

	@FindBy(xpath="//button[text()='Accept And Send OTP']")
	WebElement AcceptAndSendOTPBtn;
	
	@FindBy(id="otp")	
	WebElement otp;
	
	@FindBy(xpath="//button[text()='Verify']")
	WebElement VerifyBtn;

	public InvestorSLASigning(){
		
		PageFactory.initElements(driver, this);
			
		}
	
	public void SignSLA(){
		
		
		
		TnCcheckbox.click();
		SubmitSLA.click();
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click()",AcceptAndSendOTPBtn);
	
		otp.sendKeys("000000");
		VerifyBtn.click();
		
		
		
	}
	
	

}
