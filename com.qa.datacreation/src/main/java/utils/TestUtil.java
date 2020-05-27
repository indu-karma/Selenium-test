package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import base.TestBase;


public class TestUtil extends TestBase{

	public static long PAGE_LOAD_TIMEOUT=20;
	public static long IMPLICIT_LOAD=10;
    protected static WebDriver driver;
    protected String parentWindow;
    protected Set<String> handles;
   // protected TestData data;
  //  protected Config config;
    private final static int timeout = 20;

public String generateInvoiceID() {
	
	Random rand = new Random();
	
	String InvoiceID= "INV"+rand.nextInt();
		
	return InvoiceID;
}	
	
public String currentDate()
{
	String Cdate=null;
	
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/YYYY"); 
	Cdate=formatter.format(LocalDate.now()); 
	
	return Cdate;
	

}
	



public static void WebElementClick(WebElement we)
{
   // wait.forElementClickable(we);
    we.click();
}





public void UploadDocument(WebDriver driver, WebElement ele) throws IOException{
	
	
	JavascriptExecutor executor = (JavascriptExecutor)driver;
	executor.executeScript("arguments[0].click()",ele);
	System.out.print("\ninside upload "); 
	//ele.click();
	 driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);	
	 Runtime.getRuntime().exec("C:\\Users\\DELL\\Desktop\\Auto_Data creation\\uploadaddress\\fileup.exe");
}

public void scrollToElement(WebElement e) {
	 int y = e.getLocation().getY();
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,"+y+")");
}

public static int randomno(){
	
	Random objGenerator = new Random();
	int randomNumber = 0;
    for (int iCount = 0; iCount< 10; iCount++)
    {
      randomNumber = objGenerator.nextInt(100);
     
    }
	return randomNumber;
}

public static void selectCompanyID(WebElement CompanyIDXpath,String CompanyID) {
	
	Actions builder = new Actions(driver);
    Action mouseOverHome = builder
   		 .moveToElement(CompanyIDXpath)
   		 .clickAndHold()
   		 .sendKeys(CompanyID)
   		 .sendKeys(Keys.ARROW_DOWN)
   		 .sendKeys(Keys.ENTER)
   		 .build();
    
    mouseOverHome.perform();
}	


public static String getTokenFrmDb(String investorEmailAddress) throws SQLException, ClassNotFoundException
{
	String token="";
	String Url = "jdbc:postgresql://dev-staging-rds.culhoehta5zf.ap-south-1.rds.amazonaws.com:5432/ecs_kredx_"+prop.getProperty("environment");
	String user="qa_user";
    String password="Qa@Kredx";	
   	String query = "select verification->'email_verification'->>'token' \r\n" + 
   			"from kredx.financiers \r\n" + 
   			"where verification->'email_verification'->>'email'='"+investorEmailAddress+"'";	//Query to Execute	
   	Connection con =null;
   	
 	try {
        Class.forName("org.postgresql.Driver");
    }
    catch (java.lang.ClassNotFoundException e) {
        System.out.println(e.getMessage());
    }	 	

	    try {
	    con = DriverManager.getConnection(Url,user,password); //Create Connection to DB	
	    System.out.println("Connected to the PostgreSQL server successfully.");
	}
    catch (SQLException e){
	    System.out.println(e.getMessage());
	}

Statement stmt= con.createStatement();   //Create Statement Object					
ResultSet rs= stmt.executeQuery(query);	// Execute the SQL Query. Store results in ResultSet						

if (rs.next()) {
token=rs.getString(1);
}
	
rs.close();
stmt.close();
con.close();  // closing DB Connection
	
	return token;
	
}

public static String getFinancierFrmDb(String investorEmailAddress) throws SQLException, ClassNotFoundException
{
	String uid="";
   	String Url = "jdbc:postgresql://dev-staging-rds.culhoehta5zf.ap-south-1.rds.amazonaws.com:5432/ecs_kredx_"+prop.getProperty("environment");
    String user="qa_user";
    String password="Qa@Kredx";	
   	String query = "select uid from kredx.financiers where verification->'email_verification'->>'email'='"+investorEmailAddress+"'";	//Query to Execute	
   	Connection con =null;
   	
   	try {
            Class.forName("org.postgresql.Driver");
        }
    catch (java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }	 	

   	try {
		con = DriverManager.getConnection(Url,user,password); //Create Connection to DB	
		System.out.println("Connected to the PostgreSQL server successfully.");
		}
	catch (SQLException e){
		System.out.println(e.getMessage());
		}
   
   Statement stmt= con.createStatement();   //Create Statement Object					
   ResultSet rs= stmt.executeQuery(query);	// Execute the SQL Query. Store results in ResultSet						

   if (rs.next()) {
    uid=rs.getString(1);
   }
		
   rs.close();
   stmt.close();
   con.close();  // closing DB Connection

		return uid;
			
}

public static String CompanyUserEmailID(String VendorUID) throws SQLException
{
	
	//select person_info->'email' from kredx.company_user where company_uid='COGL4XPEDMK3'
	

	String VendorEmailID="";
   	String Url = "jdbc:postgresql://dev-staging-rds.culhoehta5zf.ap-south-1.rds.amazonaws.com:5432/ecs_kredx_"+prop.getProperty("environment");
    String user="vinay";
    String password="vinay";	
   	String query = "select person_info->'email' from kredx.company_user where company_uid='"+VendorUID+"'";	//Query to Execute	
   	
   	Connection con =null;
   	
   	try {
            Class.forName("org.postgresql.Driver");
        }
    catch (java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }	 	

   	try {
		con = DriverManager.getConnection(Url,user,password); //Create Connection to DB	
		System.out.println("Connected to the PostgreSQL server successfully.");
		}
	catch (SQLException e){
		System.out.println(e.getMessage());
		}
   
   Statement stmt= con.createStatement();   //Create Statement Object					
   ResultSet rs= stmt.executeQuery(query);	// Execute the SQL Query. Store results in ResultSet						

   if (rs.next()) {
	   VendorEmailID=rs.getString(1);
   }
		
   rs.close();
   stmt.close();
   con.close();  // closing DB Connection

		
	return VendorEmailID;
	

}


public static void UpdatePlatformListingDate(String DealID) throws SQLException {
	
   	String Url = "jdbc:postgresql://dev-staging-rds.culhoehta5zf.ap-south-1.rds.amazonaws.com:5432/ecs_kredx_"+prop.getProperty("environment");
    String user="vinay";
    String password="vinay";	
   	String query = "update kredx.deals set platform_listing_date=now() where uid ='"+DealID+"'";	//Query to Execute	
   	
   	Connection con =null;
   	
   	try {
            Class.forName("org.postgresql.Driver");
        }
    catch (java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }	 	

   	try {
		con = DriverManager.getConnection(Url,user,password); //Create Connection to DB	
		System.out.println("Connected to the PostgreSQL server successfully.");
		}
	catch (SQLException e){
		System.out.println(e.getMessage());
		}
   
   Statement stmt= con.createStatement();   //Create Statement Object					
   ResultSet rs= stmt.executeQuery(query);	// Execute the SQL Query. Store results in ResultSet						

 	
   rs.close();
   stmt.close();
   con.close();  // closing DB Connection
	
	
}

/*-----------------------------------------------------------------------------------------------------------------------------*/

 
/*
public static void copyDealID(String dealID) {
	
	try {
		   File file = new File("dealID.txt");
		   FileReader fr = new FileReader(file);
		   char[] data = new char[(int) file.length()];
		   fr.read(dealID);
		   System.out.println(dealID);
		   fr.close();
		  } catch (IOException e) {
		   e.printStackTrace();
		  }
}

*/
/*-----------------------------------------------------------------------------------------------------------------------------------*/


protected void waitForLoaderToDisappear() {
    WebDriverWait wait = new WebDriverWait(driver, 15);
    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[text('step details are being uploaded')")));
    try {
        Thread.sleep(2000);
    } catch (InterruptedException e) {
    }
}

protected String generateRandomMobileNumber() {
    String num = "99";
    Random random = new Random();
    String endingNum = String.format("%04d", random.nextInt(10000));
    return num + endingNum;
}

protected String randomNumber() {
	int aNumber = (int)((Math.random() * 9000000)+1000000);
	String number="789"+aNumber;
	return number;
}
protected String generateRandomPassword() {
    String alphaNumeric = "test11";
    String password = "";
    for (int i = 0; i < 8; i++) {
        password += alphaNumeric.charAt((int) (Math.random() * alphaNumeric.length()));
    }
    return password;
}

protected String generateRandomPasswordOfSevenCharacters() {
    String alphaNumeric = "test11";
    String password = "";
    for (int i = 0; i < 7; i++) {
        password += alphaNumeric.charAt((int) (Math.random() * alphaNumeric.length()));
    }
    return password;
}

public static String generateRandomName() {
    String alphaNumerics = "test11";
    String password = "";
    for (int i = 0; i < 8; i++) {
        password += alphaNumerics.charAt((int) (Math.random() * alphaNumerics.length()));
    }
    return password;
}

public String generateNumber()
{
    int value = (int)(Math.random()*90000)+10000;
    return String.valueOf( value );
}

public String generateRandomNamePancardNumber() {
	Random rand = new Random(); 
    int panno = rand.nextInt(10000); 
    
    System.out.println("Random Integers: "+panno);

    String alphaNumerics = "APL";
    String password = "";
    for (int i = 0; i < 5; i++) {
        password += alphaNumerics.charAt((int) (Math.random() * alphaNumerics.length()));
    }
    String panCardNumber=password+panno+"M";
    return panCardNumber;
}

public static void waitForElement(WebElement element) {
    try {
		int failureCount = 1;
		int pollingDuration = 500;
		Thread.sleep(1000);
		boolean visible = false;
		for (int i = 0; i < timeout; i++) {
		    try {
		        visible = element.isDisplayed();
		        break;
		    } catch (Exception e) {
		    }
		    waitFor(pollingDuration);
		    failureCount++;
		}
		if (!visible) {
		    System.out.println("************ Unable to find element \"" + element + "\". Retry count: " + (failureCount - 1));
		    throw new NoSuchElementException("Element: \"" + element + "\" not found");
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

protected void waitForElementToBeClickable(WebElement element) {
    int pollingDuration = 500;
    boolean visible = false;
    for (int i = 0; i < timeout; i++) {
        try {
            visible = element.isEnabled();
            break;
        } catch (Exception e) {
        }
        waitFor(pollingDuration);
    }
    if (!visible) {
        throw new NoSuchElementException("Element: " + element + " not clickable");
    }
}

protected static void waitFor(int pollingDuration) {
    try {
        Thread.sleep(pollingDuration);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
}

public void clickOnElement(WebElement element) {
    System.out.println("Clicking on element: " + element);
    waitForElement(element);
    element.click();
}

public void writeTextInField(WebElement webElement, String text) {
    System.out.println("Typing :" + text + ", on element: " + webElement);
    waitForElement(webElement);
    webElement.sendKeys(text);
}

/*protected void explicitlyWaitForElement(WebElement webElement) {
    WebDriverWait wait = new WebDriverWait(driver, config.getTimeout());
    wait.until(ExpectedConditions.elementToBeClickable(webElement));
}*/

protected void waitForElementToDisappear(WebElement element) {
    int pollingDuration = 500;
    boolean visible = true;
    for (int i = 0; i < timeout; i++) {
        try {
            element.isDisplayed();
        } catch (NoSuchElementException e) {
            visible = false;
            break;
        }
        waitFor(pollingDuration);
    }
    if (visible) {
        throw new NoSuchElementException("Element: " + element + " found");
    }
}

protected boolean isNotClickable(WebElement element) {
    int pollingDuration = 300;
    boolean isNotVisible = true;
    for (int i = 0; i < timeout; i++) {
        try {
            if (element.isEnabled() && element.isDisplayed()) {
                isNotVisible = false;
            }
        } catch (Exception e) {
        }
        waitFor(pollingDuration);
    }
    return isNotVisible;
}

/*protected WebElement findElement(String method, String value) {
    int pollingDuration = 300;
    WebElement element = null;
    for (int i = 0; i < timeout; i++) {
        try {
            switch (method) {
                case "id":
                    element = driver.findElement(By.id(value));
                case "name":
                    element = driver.findElement(By.name(value));
                case "linkText":
                    element = driver.findElement(By.linkText(value));
                case "partialLinkText":
                    element = driver.findElement(By.partialLinkText(value));
                case "xpath":
                    element = driver.findElement(By.xpath(value));
                case "tagName":
                    element = driver.findElement(By.tagName(value));
                case "css":
                    element = driver.findElement(By.cssSelector(value));
                case "className":
                    element = driver.findElement(By.className(value));
            }
        } catch (NoSuchElementException e) {
        }
        waitFor(pollingDuration);
    }
    if (element == null) {
        throw new NoSuchElementException("Element: " + value + " by: " + method + " not found");
    }
    return element;
}

protected WebElement findElement(String method, String value, String replacement) {
    int pollingDuration = 300;
    WebElement element = null;
    for (int i = 0; i < timeout; i++) {
        try {
            element = driver.findElement(By.xpath(value.replace("%", replacement)));
        } catch (NoSuchElementException e) {
        }
        waitFor(pollingDuration);
    }
    if (element == null) {
        throw new NoSuchElementException("Element: " + value + " by: " + method + " not found");
    }
    return element;
}
*/
protected boolean isVisible(WebElement element) {
    int pollingDuration = 300;
    boolean visible = false;
    for (int i = 0; i < timeout; i++) {
        try {
            if (element.isDisplayed()) {
                visible = true;
                break;
            }
        } catch (Exception e) {
        }
        waitFor(pollingDuration);
    }
    return visible;
}

}

