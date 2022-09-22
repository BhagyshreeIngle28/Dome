package Base;

import java.io.File;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;



public class ExtentManager {

	private static ExtentReports extent;
	
	public static ExtentReports createInstance() {
		
		String fileName = getReportName();
		String directory = System.getProperty("user.dir") + "/reports/";
		//Create New folder 
		new File(directory).mkdirs();
		String path = directory + fileName;
		
		
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(path);
		//htmlReporter = new ExtentHtmlReporter("./reports/extent.html");
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setDocumentTitle("Automation Reports");
		htmlReporter.config().setReportName("Automation Test Results");
		htmlReporter.config().setTheme(Theme.STANDARD);
		
		//set the dashboard Environment name & values
		extent = new ExtentReports();
		extent.setSystemInfo("Bhagyshree", "Extent Report DEMO");
		extent.setSystemInfo("Browser", "Chrome");
		extent.attachReporter(htmlReporter);
		
		return extent;
		
		
	}

	public static String getReportName() {
		
		// TODO Auto-generated method stub
		Date d = new Date();
		String fileName = "AutomationReport_" + d.toString().replace(":", "_") + ".html";
		return fileName;
	}


}
