package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Booking {

	WebDriver driver;
	public Booking(WebDriver driver) {
	
	this.driver=driver;
	
	//Initialization
	
	PageFactory.initElements(driver, this);
	}
	//Page Factory
	
	@FindBy(xpath="//option[@value=\"Hongkong CURA Healthcare Center\"]")
	WebElement Facility;
	
	@FindBy(css="input[type='checkbox']")
	WebElement checkbox;
	
	@FindBy(id="radio_program_medicaid")
	WebElement Radiobtn;
	
	@FindBy(name="visit_date")
	WebElement date;
	
	@FindBy(id="txt_comment")
	WebElement comment;
	
	@FindBy(id="btn-book-appointment")
	WebElement book_btn;
	@FindBy(css ="p a:nth-child(1)")
	WebElement rtn_btn;
	
	public void BookAppointment(String Date,String Comment) 
	{
		Facility.click();
		checkbox.click();
		Radiobtn.click();
		date.sendKeys(Date);
		comment.sendKeys(Comment);
		book_btn.click();
		
	}
}
