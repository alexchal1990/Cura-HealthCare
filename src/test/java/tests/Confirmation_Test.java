package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseT;
import pageObjects.Booking;
import pageObjects.ConfirmationPage;
import pageObjects.LandingPage;

public class Confirmation_Test extends BaseT {

    // must be public  so listener can access it
	public WebDriver driver;

	@Test(groups = {"smoke", "regression"})
	public void verifyAppointmentConfirmation() {
		driver = super.driver;
		LandingPage landingPage= new LandingPage(driver);
		
		
		
		landingPage.GoTo();
		landingPage.clickMakeAppointment();
		landingPage.enterUsername("John Doe");
		landingPage.enterPassword("ThisIsNotAPassword");
		landingPage.clickLogin();
		
		Booking  book =new Booking(driver);
		book.BookAppointment("25/5/2025", "High Fever");
		
		
		ConfirmationPage conf= new ConfirmationPage(driver);

        Assert.assertTrue(
                conf.isAppointmentConfirmed(),"Appointment");
        conf.ReturnBtn();	 
	}
	
	
	
}
