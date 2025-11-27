package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseT;
import pageObjects.Booking;
import pageObjects.ConfirmationPage;
import pageObjects.LandingPage;

public class e2e_Test extends BaseT{
	
	public WebDriver driver;

    // must be public so listener can access it
	@Test(groups = { "regression"})
	public void e2e() {
		// TODO Auto-generated method stub	public WebDriver driver;
		driver = super.driver;
		LandingPage landingPage = new LandingPage(driver);
		landingPage.GoTo();
		landingPage.clickMakeAppointment();
		landingPage.enterUsername("John Doe");
		landingPage.enterPassword("ThisIsNotAPassword");
		landingPage.clickLogin();
		Booking  book =new Booking(driver);
		book.BookAppointment("13/1/1990", "high fever");	
		ConfirmationPage conf= new ConfirmationPage(driver);
		  Assert.assertTrue(conf.isAppointmentConfirmed(),
		            "ERROR: Appointment confirmation message not displayed!");
		  conf.ReturnBtn();	 
	}

	
}
