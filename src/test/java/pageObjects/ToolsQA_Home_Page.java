/**Summary--
 *  * This Class contains required web element objects and methods to find them for Home page of TOOLSQA web site. 
  */
package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class ToolsQA_Home_Page {

	public static class ToolsQA_Page{
		
		public static WebElement Product_Category(WebDriver driver){
			
			WebElement productCategory = driver.findElement(By.linkText("Product Category"));
			return productCategory;
			
		}
		public static WebElement Accesories(WebDriver driver){
			
			WebElement accessories = driver.findElement(By.linkText("Accessories"));
			return accessories;
			
		}
		public static WebElement All_Product(WebDriver driver){
			WebElement allProduct = driver.findElement(By.linkText("All Product"));
			return allProduct;
			
		}
	}
}
