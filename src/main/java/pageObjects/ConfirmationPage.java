package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmationPage {

	WebDriver driver;
	
	public   ConfirmationPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
		@FindBy(css =".btn-default")
		WebElement rtn_btn;
		@FindBy(xpath="//h2[text()='Appointment Confirmation']")
		WebElement confirmationMsg;
	
	public String Confirmationmsg() {
		 return confirmationMsg.getText();	
	}
	
	
	public boolean isAppointmentConfirmed() {
        return confirmationMsg.getText()
                .contains("Appointment");
    }


	public void ReturnBtn()
	{
		rtn_btn.click();	
		
	}
	
}