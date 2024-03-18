package PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Trademart_Login {
	public static WebDriver driver;
	//Constructor creating
	public Trademart_Login(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[text()=' Log in ']")
	WebElement Login;
	@FindBy(xpath="(//input[@type='email'])[2]")
	WebElement email;
	@FindBy(xpath="(//input[@type='password'])[1]")
	WebElement password;
	@FindBy(xpath="//button[@id='submitLogin']")
	WebElement submit;
	
	public void login() {
		Login.click();
	}
	public void Email(String EmailId) {
		email.sendKeys(EmailId);
		
	}
	public void Password(String Password) {
		password.sendKeys(Password);
		
	

	}
	public void SubmitButton() {
		submit.click();
	}
	

}
