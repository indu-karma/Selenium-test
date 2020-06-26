package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddUsersPage_Admin {

	//Web Element
	@FindBy(xpath="(//a[contains(text(),'Users')])[1]")
	WebElement SelectUsers;
	
	@FindBy(xpath="(//a[contains(text(),'Add User')])")
	WebElement ClickOnAddUser;
	
	
}
