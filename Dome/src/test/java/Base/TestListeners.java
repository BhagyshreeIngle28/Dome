package Base;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import Testcases.TestcasesDome;

public class TestListeners implements ITestListener{
	
	//method from Extent manager file
	private static ExtentReports extent = ExtentManager.createInstance();
	//Need to add this if we want to run Multiple Test classes in parallel 
	private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
		ExtentTest test = extent.createTest(result.getTestClass().getName()	 + "::" 
												+ result.getMethod().getMethodName());
		extentTest.set(test);
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		String logText = "<b> Test Method"   + result.getMethod().getMethodName() + "Successful </b>";
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
		extentTest.get().log(Status.PASS, m);
		
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
		String methodName = result.getMethod().getMethodName();
		String exceptionMessage = Arrays.toString(result.getThrowable().getStackTrace());
		extentTest.get().fail("<details><summary><b><font color=red>Exception Occured , Click to see DETAILS:</font></b></summary>"+ exceptionMessage.replaceAll(",","<br>") + "</details> \n");
		
		//Instance for driver
		WebDriver driver = ((TestcasesDome)result.getInstance()).driver;
		
		String path = takesScreenshot(driver,result.getMethod().getMethodName());
		try {
			extentTest.get().fail("<b><font color=red>" + "Screenshot of Failure" + "</font></b>", 
					MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		}catch (IOException e) {
			// TODO: handle exception
			extentTest.get().fail("Test Failed , cannot Attch Screenshot");
		}
		
		String logText = "<b> Test Method"   + methodName + "Failed </b>";
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.RED);
		extentTest.get().log(Status.FAIL, m);

		
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
		String logText = "<b> Test Method"   + result.getMethod().getMethodName() + "Skipped </b>";
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.AMBER);
		extentTest.get().log(Status.SKIP, m);
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
		if(extent != null)
		{
			extent.flush();
		}
		
	}
	
	//To save screenshot path directory code 
		public String takesScreenshot(WebDriver driver,String methodname) {
			
			String fileName = getScreenshotName(methodname);
			String directory = System.getProperty("user.dir") + "/screenshots/";
			//It makes new directory in Project structure
			new File(directory).mkdirs();
			String path = directory + fileName;
			
			try {
				File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(screenshot, new File(path));
				
				System.out.println("*************************");
				System.out.println("Screen shot saved at :" + path);
				System.out.println("*************************");
				
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return path;
		}
		
		//format for saving the screenshot
		public static String getScreenshotName(String methodname) {
			
			Date d = new Date();
			String fileName = methodname + "_" + d.toString().replace(":", "_").replace(" ", "_") + ".png";
			return fileName;
			
			
			
		}
	
	

}
