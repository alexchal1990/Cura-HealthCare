package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseT;
import pageObjects.LandingPage;

public class LoginTests extends BaseT{

    // must be public so listener can access it
	public WebDriver driver;

	@DataProvider(name = "loginData")
		public Object[][] getLoginData(){
			return new Object[][] {
				{"John Doe","ThisIsNotAPassword", true}, //Valid LoginloginTest
				{"wronguser","wrongpass", false}, //invalid login
		};
	}
		
	@Test(dataProvider = "loginData",groups = {"smoke", "regression"})
	public void loginTest(String username,String password,boolean expectedResult) {
		driver = super.driver;
		LandingPage landingPage= new LandingPage(driver);
		landingPage.GoTo();
		landingPage.clickMakeAppointment();
		landingPage.enterUsername(username);
		landingPage.enterPassword(password);
		landingPage.clickLogin();
		
		boolean actualResult = landingPage.isLoginSuccesfull();
		Assert.assertEquals(actualResult, expectedResult,"Login result mismatch");
	}
	
	
	
}
