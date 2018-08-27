/**Summary--
 *  * This Class contains required web element objects and methods to find them for Accessories page of TOOLSQA web site. 
  */
package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Accessories_Page {

	public static class Magic_Mouse{
		
		public static WebElement Product_Name(WebDriver driver){
			
			WebElement productName = driver.findElement(By.xpath("//a[@class='wpsc_product_title' and text()='Magic Mouse']"));
			return productName;
			
		}
		public static WebElement Add_To_Cart(WebDriver driver){
			
			WebElement addToCart = driver.findElement(By.xpath("//form[@action='http://store.demoqa.com/products-page/product-category/accessories/magic-mouse/']//div[@class='input-button-buy']//input[@type='submit']"));
			return addToCart;
			
		}
		public static WebElement One_Product_Added_To_Cart(WebDriver driver){
			
			WebElement oneProductAddedToCart = driver.findElement(By.xpath("//*[@id='header_cart']/a/em[1]"));
			return oneProductAddedToCart;
		}
		public static WebElement Checkout(WebDriver driver){
			
			WebElement checkOut = driver.findElement(By.xpath("//*[@id='header_cart']/a"));
			return checkOut;
		}
	}
	public static class IMacs{
	}
}
