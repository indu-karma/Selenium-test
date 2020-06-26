package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class DealPurchaseFrmFianacierPage extends TestBase{
	
	//Add Funds
	//DealBuy
	//
	
	@FindBy(xpath="(//button[contains(text(),'Buy Now')])[4]")
	WebElement BuyNowBtn;
	
	@FindBy(xpath="(//input[@placeholder='Enter Amount'])[3]")
	WebElement EnterAmount;
	
	@FindBy(xpath="//button[contains(text(),'Proceed')]")
	WebElement ProceedBtn;
	
	@FindBy(xpath="//input[@id='risk-accept']")
	WebElement riskCheckBx;
	
	@FindBy(xpath="//input[@id='checkbox-accept']")
	WebElement riskAccept;
	
	@FindBy(xpath="//button[contains(text(),'Sign To Purchase')]")
	WebElement SignToPurchaseBtn;
	
	@FindBy(xpath="//button[contains(text(),'Accept and Send OTP')]")
	WebElement AcceptBtn;
	
	@FindBy(xpath="//label[contains(text(),'Enter OTP')]")
	WebElement EnterOTP;
	
	@FindBy(xpath="//button[contains(text(),'Verify')]")
	WebElement Verify;
	
	@FindBy(xpath="//span[contains(text(),'Start Tracking')]")
	WebElement StartTracking;
	
	@FindBy(xpath="//span[contains(text(),'Continue Investing')]")
	WebElement ContinueInvesting;
	

	
	/*functions of page*/
public DealPurchaseFrmFianacierPage(){
				
				PageFactory.initElements(driver, this);
}

public void AddFunds() {
		
		
	}
	
	public void DealBuy(String DealID,String Amount) {
		
		String url="https://"+prop.getProperty("environment")+
				".kredx.com/financier/dashboard/deals/"+DealID;
		
		driver.get(url);
		BuyNowBtn.click();
		EnterAmount.sendKeys(Amount);
		ProceedBtn.click();
		riskCheckBx.click();
		riskAccept.click();
		SignToPurchaseBtn.click();
		AcceptBtn.click();
		EnterOTP.sendKeys("000000");
		Verify.click();
		StartTracking.click();
	}
	

}
