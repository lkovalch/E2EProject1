package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	
	public WebDriver driver;   //Encapsulation is used: private variables + public related methods
	
	public By email=By.cssSelector("[id='user_email']");
	public By password=By.cssSelector("[type='password']");
	public By login=By.cssSelector("[value='Log In']");
	public By alertInvalidLogin= By.cssSelector(".alert.alert-danger");
	
	
	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		
	}

	public WebElement getEmail()
	{
		return driver.findElement(email);
	}
	

	public WebElement getPassword()
	{
		return driver.findElement(password);
	}
	
	public WebElement getLogin()
	{
		return driver.findElement(login);
	}
	public WebElement getAlert()
	{
		return driver.findElement(alertInvalidLogin);
	}
	
	
}
