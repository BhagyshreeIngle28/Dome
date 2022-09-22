package Testcases;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import Pageclass.Dome.Locators;
import Utilities.Baseclass;



public class TestcasesDome extends Baseclass{
	
	@Test(priority = 1)
	public void Signupcheck() throws IOException, InterruptedException {

		Locators Sign_page = PageFactory.initElements(driver, Locators.class);
		Sign_page.signpage();

	}

}
