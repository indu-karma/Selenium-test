package base;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.codehaus.plexus.util.FileUtils;
//import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.*;




public class MyListener implements ITestListener {
 public static WebDriver driver;
 public static ExtentReports reports;
 public static ExtentTest test;
 
 
 public void onTestStart(ITestResult result) {
  System.out.println("on test start");
  test = reports.createTest(result.getMethod().getMethodName());
  test.log(Status.INFO, result.getMethod().getMethodName() + "test is started");
 }
 
 public void onTestSuccess(ITestResult result) {
  System.out.println("on test success");
  test.log(Status.PASS, result.getMethod().getMethodName() + "test is passed");
 }
 
 public void onTestFailure(ITestResult result) {
  System.out.println("on test failure");
  test.log(Status.FAIL, result.getMethod().getMethodName() + "test is failed");
  TakesScreenshot ts = (TakesScreenshot) driver;
  File src = ts.getScreenshotAs(OutputType.FILE);
  try {
   FileUtils.copyFile(src, new File("C:\\images\\" + result.getMethod().getMethodName() + ".png"));
  // String file = test.addScreenCaptureFromPath("C:\\images\\" + result.getMethod().getMethodName() + ".png");
   test.log(Status.FAIL, result.getMethod().getMethodName() + "test is failed");
   test.log(Status.FAIL, result.getMethod().getMethodName() + "test is failed");
  } catch (IOException e) {
   e.printStackTrace();
  }
 }
 public void onTestSkipped(ITestResult result) {
  System.out.println("on test skipped");
  test.log(Status.SKIP, result.getMethod().getMethodName() + "test is skipped");
 }
 public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
  System.out.println("on test sucess within percentage");
 }
 public void onStart(ITestContext context) {
  System.out.println("on start");
  driver = new ChromeDriver(); // Set the drivers path in environment variables to avoid code(System.setProperty())
  reports = new ExtentReports();
 }
 public void onFinish(ITestContext context) {
  System.out.println("on finish");
  driver.close();
//  reports.saveTest(test);
  reports.flush();
 }
}