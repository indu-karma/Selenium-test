package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class InvestorRegisterPage extends TestBase{
	
//Web elements	
	//url=https://harry.kredx.com/financier/register
	
	//Investor name
	@FindBy(id="input")
	WebElement investorName;
	
	//Investor Mobile Number
	@FindBy(xpath="//input[@type='tel']")
	WebElement investorMobileNo;
	
	//Investor Email address
	@FindBy(id="email")
	WebElement investorEmailId;
	
	//Investor Password
	@FindBy(id="password")
	WebElement investorPassword;
	
	//referralcode==//input[@id='referral']-- Not Mandatory for Investor On boarding
	
	//Terms and Condition Checkbox 
	@FindBy(xpath="//input[@id='checkbox-accept']")
	WebElement termNcondition;
	
	//Sign Up button
	@FindBy(xpath="//button[@type='submit']")
	WebElement signUpBtn;
	
	
//Functions	

	public InvestorRegisterPage()
	{
		PageFactory.initElements(driver, this);
		
	}
	
	
	public void AddInvestorMainDetails(String Name,String MobNo,String Email,String Pwd,String referralCd)
	{
		
		investorName.sendKeys(Name);
		investorMobileNo.sendKeys(MobNo);
		investorEmailId.sendKeys(Email);
		investorPassword.sendKeys(Pwd);
		termNcondition.click();
		signUpBtn.click();
		
	
		
	}	
		


}
	


