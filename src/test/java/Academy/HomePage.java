package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class HomePage extends base{
	
	 public static Logger log =LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void initialize() throws IOException
	{
	
		 driver =initializeDriver();

	}
	@Test(dataProvider="getData")
	
	public void basePageNavigation(String Username,String Password,String text) throws IOException
	{
		//one is inheritance
		// creating object to that class and invoke methods of it
		driver.get(prop.getProperty("url"));
		
		LandingPage l=new LandingPage(driver);
		LoginPage lp=new LoginPage(driver);
		
		//l.alertHandling();
		
		l.getLogin().click(); //driver.findElement(By.css()
		
		lp.getEmail().sendKeys(Username);
		lp.getPassword().sendKeys(Password);

		log.info(text);
		
		lp.getLogin().click();
		System.out.println(text);
	
		
		String errorMessage=lp.getAlert().getText();
		Assert.assertEquals("Invalid email or password.", errorMessage);
		System.out.println(errorMessage);

		}


	@AfterTest
	public void teardown()
	{
		
		driver.quit();
		driver=null;
		
	}

	
	@DataProvider
	public Object[][] getData()
	{
		// Row stands for how many different data types test should run
		//coloumn stands for how many values per each test
		
		// Array size is 2
		// 0,1
		Object[][] data=new Object[2][3];
		//0th row
		data[0][0]="restricteduser@qw.com";
		data[0][1]="123456";
		data[0][2]="Restrcited User";
		//1st row
		data[1][0]="lkovalch@yahoo.com";
		data[1][1]="Likalika1";
		data[1][2]= "Registered user";
		
		return data;
		
	
		
	}
	
}
