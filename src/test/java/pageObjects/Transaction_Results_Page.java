/**Summary--
 *  * This Class contains required web element objects and methods to find them for Transaction results page of TOOLSQA web site. 
  */
package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Transaction_Results_Page {

	public static class Transaction_Results{
	
		public static WebElement Transaction_Dtls_Title(WebDriver driver){
			
			WebElement transactionTitle = driver.findElement(By.xpath("//*[@id='post-30']/header/h1"));
			return transactionTitle;
		}
		public static WebElement Transaction_Dtls_Content(WebDriver driver){
			
			WebElement transactionContent = driver.findElement(By.xpath("//*[@id='post-30']"));
			return transactionContent;
		}
	}
}
