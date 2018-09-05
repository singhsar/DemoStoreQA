package scripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import config.ConfigProperties;

public class OpenAndCloseBrowser {
	public static WebDriver driver;
	ConfigProperties getConfig=new ConfigProperties();
	String appURL=getConfig.getProperty("appURL");
	String getDriverName=getConfig.getProperty("driverName");
	
	public static WebDriver openBrowser(String getDriverName) {
		try {		
			if (getDriverName.equals("FireFox")) {
				driver = new FirefoxDriver();
				System.out.println("beforeTest - " + "Loading Driver-" + getDriverName);
			} else if (getDriverName.equals("Chrome")) {
				driver = new ChromeDriver();
			}
		} catch (Exception e) {
	         e.printStackTrace();
		}	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	public void closeBrowser() {
		driver.quit();
	}
}
