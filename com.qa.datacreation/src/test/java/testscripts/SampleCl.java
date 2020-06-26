package testscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import base.TestBase;

public class SampleCl extends TestBase {

public SampleCl(){
		
		PageFactory.initElements(driver, this);
			
		}
@Test	
public void test() {
	
	String dealid=driver.findElement(By.xpath("//div[@class='breadcrumb']/span[3]/a")).getAttribute("href");
	System.out.print(dealid);
	
	
}
}

/*
 
  I came across this issue building a test suite for our own application which uses the Angular JS Framework.

Using the following helper functions:

private IWebElement FindElementWithWait(By id, int timeout)
   {
       bool found = false;
       int loop = 0;
       IWebElement element = null;
       var i = timeout * 10;
       while (!found && loop < i)
       {
           try
           {
               element = Driver.FindElement(id);
               found = true;
           }
           catch (Exception e)
           {
               found = false;
           }
           finally
           {
               loop++;

               Thread.Sleep(100);
           }
       }

       return element;
   }

private void JavascriptClick(IWebElement element)
   {
       Js.ExecuteScript("arguments[0].click();", element);
   }
It's possible to overcome the issue where elements using ng-click cause an "element not interactable" exception when calling the standard IWebElement .Click() method.

e.g. JavascriptClick(FindElementWithWait(By.XPath("//button[text()='My_ng-click_Button']"), 2));
  
  
 */
