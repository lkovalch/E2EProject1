package pageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class LandingPage {

	public WebDriver driver;			//Encapsulation is used: private variables + public related methods
	
	private By signin=By.cssSelector("a[href*='sign_in']");
	private By title=By.cssSelector(".text-center>h2");
	private By NavBar=By.cssSelector(".nav.navbar-nav.navbar-right>li>a");
	private By register=By.cssSelector("a[href*='sign_up']");
	private By header = By.cssSelector("div[class*='video-banner'] h3");

	private By NewsletterPopup = By.xpath("//button[contains(text(),'NO THANKS')]");
	
	public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
		}

	public WebElement getLogin()
	{
		return driver.findElement(signin);
		}
	public WebElement getNavigationBar()
	{
		return driver.findElement(NavBar);
	}
	public WebElement getTitle()
	{
		return driver.findElement(title);
	}
	
	public WebElement getRegister()
	{
		return driver.findElement(register);
	}
	
	public WebElement alertHandle()
	{
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

		return driver.findElement(NewsletterPopup);

		}
	public WebElement getHeader()
	{
		return driver.findElement(header);
	}
}
