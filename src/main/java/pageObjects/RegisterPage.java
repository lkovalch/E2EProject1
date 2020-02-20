package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPage {

	
	public WebDriver driver;   //Encapsulation is used: private variables + public related methods
	
	public By fullName=By.cssSelector("[id='user_name']");
	public By email=By.cssSelector("[id='user_email']");
	public By password=By.cssSelector("[id='user_password']");
	public By confirmPassword=By.cssSelector("[id='user_password_confirmation']");
	//public By captchu=By.xpath("//div[@class='recaptcha-checkbox-border']");
	public By captchu=By.cssSelector(".by.rc-anchor-center-item.rc-anchor-checkbox-holder");
	
	public By termsAgreeCheckbox=By.xpath("//input[@id='user_agreed_to_terms']");
	private By signUp=By.cssSelector("a[href*='sign_up']");
	public By alertInvalidLogin= By.cssSelector(".alert.alert-danger");
	
	
	public RegisterPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		
	}

	public WebElement getFullName()
	{
		return driver.findElement(fullName);
	}
	public WebElement getEmail()
	{
		return driver.findElement(email);
	}
	
	public WebElement getPassword()
	{
		return driver.findElement(password);
	}	
	
	public WebElement confirmPassword()
	{
		return driver.findElement(confirmPassword);
	}
	public WebElement getCaptcha()
	{
		return driver.findElement(captchu);
	}
	public WebElement termsAgreementCheckbox()
	{
		return driver.findElement(termsAgreeCheckbox);
	}
	
	public WebElement getSignUp()
	{
		return driver.findElement(signUp);
	}
	public WebElement getAlert()
	{
		return driver.findElement(alertInvalidLogin);
	}
	
	
}
