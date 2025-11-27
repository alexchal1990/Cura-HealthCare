package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import base.BaseT;
import pageObjects.Booking;
import pageObjects.LandingPage;

public class BookApp extends BaseT {

    // must be public  so listener can access it
	public WebDriver driver;

	@Test(groups = {"smoke", "regression"})
	public  void bookingTest() throws IOException{
		driver = super.driver;
		LandingPage landingPage= new LandingPage(driver);
		
		landingPage.GoTo();
		landingPage.clickMakeAppointment();
		landingPage.enterUsername("John Doe");
		landingPage.enterPassword("ThisIsNotAPassword");
		landingPage.clickLogin();
		
		Booking  book =new Booking(driver);
		
		book.BookAppointment("13/1/1990", "high fever");
		
		System.out.println("Booking completed successfully.");
	}
		

}
