package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.TestUtil;

public class PreSanctionData {
	
	
	/*KYC details elements */
	
	@FindBy(xpath="//input[@name='tan']")
	WebElement TanNumber;
	
	/*Company Contact details*/
	
	@FindBy(xpath="//input[@name='primary_email']")
	WebElement CompanyEmail;
	
	@FindBy(xpath="//input[@name='primary_phone']")
	WebElement CompanyPhone;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement Submitbtn;
	
	/*Company KYC
	 * */
	
	@FindBy(xpath="//input[@name='gstn']")
	WebElement GSTIN;
	
	@FindBy(xpath="//input[@id='9cc47c96-44e1-4b9a-ba42-3861c8f3f961']")
	WebElement GSTINAddCheckBox;
	
	@FindBy(xpath="(//button[@type='button'])[1]")
	WebElement GSTCertificateUpload;
	
	@FindBy(xpath="(//button[@type='button'])[2]")
	WebElement GSTReturnsUpload;
	
	/*Add Key User details*/
	
	
	@FindBy(xpath="//input[@id='date_of_birth']")
	WebElement DOB;
	
	@FindBy(xpath="//input[@name='person_info.designation']")
	WebElement Designation;
	
	@FindBy(xpath="//span[@class='_-kredx-web-ui-dist-v2-FieldCheckbox-style__input-checkmark--qEg_z']")
	WebElement Gender;
	
	@FindBy(xpath="//input[@name='person_info.pan_number']")
    WebElement PanNumber;	
	
	

	
	
	public void AddCompanyKYC() {
		
		TanNumber.sendKeys("BLRT198"+TestUtil.randomno()+"A");
		CompanyEmail.sendKeys("indu+ven@kredx.com");
		CompanyPhone.sendKeys("9886765251");
		Submitbtn.click();
	}
	
}
