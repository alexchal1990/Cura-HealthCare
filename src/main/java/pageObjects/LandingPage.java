package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage  {

	WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}

		//PageFactory
		@FindBy(id="btn-make-appointment")
		WebElement btnapp;
		@FindBy(name="username")
		WebElement username;
		@FindBy(name="password")
		WebElement password;
		@FindBy(id="btn-login")
		WebElement loginbtn;

		public void GoTo()
		{
			driver.get("https://katalon-demo-cura.herokuapp.com/");
		}
		
		public void clickMakeAppointment() {
			btnapp.click();
		}

		public void enterUsername(String user) {
			username.sendKeys(user);
		}
		
		public void enterPassword(String pass) {
			password.sendKeys(pass);
		}
		
		public void clickLogin() {
			loginbtn.click();
		}
		
		public boolean isLoginSuccesfull() {
			return driver.getCurrentUrl().contains("appointment");
		}
		
}	

