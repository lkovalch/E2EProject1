package resources;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class base {

	public static WebDriver driver;
	public Properties prop;
	
public WebDriver initializeDriver() throws IOException
{
prop= new Properties();
//Remove hard coded file location "/Users/admin/Workspace/E2EProject/src/main/java/resources/data.properties" 
//by using System.getProperty ("user.dir") and concantinate with the rest of path

//FileInputStream fis=new FileInputStream("/Users/admin/Workspace/E2EProject/src/main/java/resources/data.properties");
FileInputStream fis=new FileInputStream ("/Users/admin/Workspace/E2EProject1/src/main/java/resources/data.properties");

prop.load(fis);

//mvn test -Dbrowser=chrome
String browserName = prop.getProperty("browser");
System.out.println(browserName);

if(browserName.contains("chrome"))	//if browser is CHROME
{
System.setProperty("webdriver.chrome.driver", "/Users/admin/Documents/Selenium/chromedriver"); //usr/local/bin
driver = new ChromeDriver();
}
//Remove hard coded part
	//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir"));

	 
//To run headless Chrome: create option object and add argument "headless. add two lines
//ChromeOptions option = new ChtomeOptions();
//option.addArguments("headless"); and pass "option" object into driver= new ChromeDriver(option);	 
else if (browserName.contains("headless")) {    //HEADLESS CHROME
	ChromeOptions option = new ChromeOptions();
	option.addArguments("headless"); 	
	driver= new ChromeDriver(option);}
	
else if (browserName.equals("firefox")) 													//if browser is FIREFOX
{
	System.setProperty("webdriver.gecko.driver", "/Users/admin/Documents/Selenium/geckodriver");
	driver= new FirefoxDriver();
	//DesiredCapabilities capabilities = DesiredCapabilities.firefox();
	//capabilities.setCapability("marionette",true);
	//driver= new FirefoxDriver(capabilities);
	 
	}
else if (browserName.equals("IE")) //if browser is IE
{
	System.setProperty("webdriver.IEDriverServer.driver", System.getProperty("user.dir"));
	driver = new InternetExplorerDriver();
}
driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); //wait 10 seconds to load
return driver;
}


public void getScreenshots(String result) throws IOException {
	// TODO Auto-generated method stub
	File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(src, new File("/Users/admin/Workspace/E2EProject1/Screenshots"+result+"screenshot.png"));
	
}


}
