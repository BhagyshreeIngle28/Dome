package Utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass {

	public WebDriver driver;
	
	
	@Test 
	public void setup()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://dome-technologies.com/?selling_plan=3090972926");
	}
	
	
	// Highlight the element or message
		public static void highLightElement(WebDriver driver, WebElement element) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].setAttribute('style','background: LightBlue  ; border: 1px solid black;');",
					element);
		}
}
