package Academy;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;

import pageObjects.RegisterPage;
import resources.base;

public class RegistrationValidation extends base{
	
	 public static Logger log =LogManager.getLogger(base.class.getName());
	
	 @BeforeTest
	public void initialize() throws IOException
	{
	
		 driver =initializeDriver();

	}
	@Test(dataProvider="getValidData")
	
	public void validRegistration(String FullName,String Email, String Password,String ConfirmPassword,String text) throws IOException, InterruptedException
	{
		RegisterPage rp = new RegisterPage(driver);
		LandingPage lp= new LandingPage(driver);

	driver.get(prop.getProperty("url"));
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
	
	lp.alertHandle().click();
	
		
		rp.getSignUp().click();
		rp.getFullName().sendKeys(FullName);
		rp.getEmail().sendKeys(Email);
		rp.confirmPassword().sendKeys(Password);
		rp.confirmPassword().sendKeys(ConfirmPassword);
	
		rp.termsAgreementCheckbox().click();
		rp.getCaptcha().click();
		rp.getSignUp().click();
		System.out.println(text);
		

		log.info(text);
		
		
		}

@Test(dataProvider="getInvalidData")
	
	public void InvalidRegistration(String FullName,String Email, String Password,String ConfirmPassword,String text) throws IOException
	{
		RegisterPage rp = new RegisterPage(driver);
		LandingPage lp = new LandingPage(driver);

	driver.get(prop.getProperty("url"));
	driver.manage().window().maximize();
	
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
	//lp.alertHandleSimple();
		
		rp.getSignUp().click();
		rp.getFullName().sendKeys(FullName);
		rp.getEmail().sendKeys(Email);
		rp.confirmPassword().sendKeys(Password);
		rp.confirmPassword().sendKeys(ConfirmPassword);
		rp.getCaptcha().click();
		rp.termsAgreementCheckbox().click();
		rp.getSignUp().click();
		System.out.println(text);
		

		log.info(text);
		
		
		}

	@AfterTest
	public void teardown()
	{
		
		driver.close();
		driver=null;
		
	}
	
	@DataProvider
	public Object[][] getValidData()
	{
		// Row stands for how many different data types test should run
		//coloumn stands for how many values per each test
		
		// Array size is 2
		// 0,1
		Object[][] data=new Object[1][5];
		//0th row
		data[0][0]="Lyailya Kovalchuk";
		data[0][1]="lkovalch@yahoo.com";
		data[0][2]="Likalika";
		data[0][3]="Likalika";
		data[0][3]="Valid User";
		//1st row
		return data;
		
	}
	@DataProvider
	public Object[][] getInvalidData()
	{
		// Row stands for how many different data types test should run
		//coloumn stands for how many values per each test
		
		// Array size is 2
		// 0,1
		Object[][] data=new Object[1][5];
		//0th row
		data[0][0]="Vasya Pupkin";
		data[0][1]="lkovalch@yahoo.com";
		data[0][2]="Likalika";
		data[0][3]="Likalika";
		data[0][3]="Invalid User";
		
		
		return data;
		
	
		
	}
}
