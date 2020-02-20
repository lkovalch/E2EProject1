package Academy;

import java.io.IOException;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.base;

public class validateTitle extends base{
	
	 public static Logger log =LogManager.getLogger(base.class.getName());
	 
		LandingPage l;
	 
	@BeforeTest
	public void initialize() throws IOException
	{
	
		 driver =initializeDriver();
		 log.info("Driver is initialized");
			
		driver.get(prop.getProperty("url"));
		 log.info("Navigated to Home page");
	}
	@Test
	public void validateAppTitle() throws IOException
	{
		l=new LandingPage(driver);
		//one is inheritance
		// creating object to that class and invoke methods of it
		//compare the text from the browser with actual text.- Error..
		Assert.assertEquals(l.getTitle().getText(), "FEATURED COURSES");
		 log.info("Successfully validated Title");
	}
	@Test
	public void validateHeader() throws IOException
	{
		
		//one is inheritance
		// creating object to that class and invoke methods of it
		//compare the text from the browser with actual text.- Error..
		
		Assert.assertEquals(l.getHeader().getText().toUpperCase(), "AN ACADEMY TO LEARN EVERYTHING ABOUT TESTING");
		 log.info("Successfully validated Header message");
	}
	
	@AfterTest
	public void teardown()
	{
		
		driver.close();
		driver=null;
		
	}

	

	
}
