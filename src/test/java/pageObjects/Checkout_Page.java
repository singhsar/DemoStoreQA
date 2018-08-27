/**Summary--
 *  * This Class contains required web element objects and methods to find them for Checkout page of TOOLSQA web site. 
  */
package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Checkout_Page {
	
	public static class Check_Out{
	public static WebElement Check_Out_Title(WebDriver driver){
		
		WebElement checkOutTitle = driver.findElement(By.xpath("//h1[@class='entry-title' and text()='Checkout']"));
		return checkOutTitle;		
	}
	public static WebElement Product_Magic_Mouse(WebDriver driver){
		
		WebElement productMagicMouse = driver.findElement(By.xpath("//a[@href='http://store.demoqa.com/products-page/product-category/accessories/magic-mouse/']"));
		return productMagicMouse;	
	}
	public static WebElement Product_Quantity(WebDriver driver){
		
		WebElement productQuantity = driver.findElement(By.xpath("//input[@name='quantity']"));
		return productQuantity;		
	}
	public static WebElement Click_Continue(WebDriver driver){
		
		WebElement continueButton = driver.findElement(By.xpath("//span[text()='Continue']"));
		return continueButton;		
	}
	public static WebElement Billing_Form(WebDriver driver){
		
		WebElement billingForm = driver.findElement(By.xpath("//td[@class='wpsc_billing_forms ']"));
		return billingForm;		
	}
	
	public static  void Select_Shipping_Country(WebDriver driver,String countryCode){
		
		Select drpcountry= new Select(driver.findElement(By.xpath("//select[@name='country']")));
		drpcountry.selectByValue(countryCode);
	
	}
	
	public static WebElement Shipping_State(WebDriver driver){
		
		WebElement shippingstate = driver.findElement(By.xpath("//input[@title='shippingstate']"));
		return shippingstate;		
	}
	public static WebElement Calculate_Shipping_Button(WebDriver driver){
		
		WebElement calculateShippingButton = driver.findElement(By.xpath("//input[@type='submit' and @value='Calculate']"));
		return calculateShippingButton;		
	}
	public static WebElement Enter_Email(WebDriver driver){
		
		WebElement email = driver.findElement(By.xpath("//input[@id='wpsc_checkout_form_9']"));
		return email;		
	}
	public static WebElement Enter_First_Name(WebDriver driver){
		
		WebElement firstName = driver.findElement(By.xpath("//input[@id='wpsc_checkout_form_2']"));
		return firstName;		
	}
	public static WebElement Enter_Last_Name(WebDriver driver){
		
		WebElement lastName = driver.findElement(By.xpath("//*[@id='wpsc_checkout_form_3']"));
		return lastName;		
	}
	public static WebElement Enter_Address(WebDriver driver){
		
		WebElement address = driver.findElement(By.xpath("//*[@id='wpsc_checkout_form_4']"));
		return address;		
	}
	public static WebElement Enter_City(WebDriver driver){
		
		WebElement city = driver.findElement(By.xpath("//*[@id='wpsc_checkout_form_5']"));
		return city;		
	}
	public static WebElement Enter_Province(WebDriver driver){
		
		WebElement province = driver.findElement(By.xpath("//*[@id='wpsc_checkout_form_6']"));
		return province;		
	}
	public static void Select_Country(WebDriver driver,String countryCode){
		
		Select selectCountry= new Select(driver.findElement(By.xpath("//*[@id='wpsc_checkout_form_7']")));
		selectCountry.selectByValue(countryCode);
	}
	public static WebElement Enter_Postal_Code(WebDriver driver){
		
		WebElement postalCode = driver.findElement(By.xpath("//*[@id='wpsc_checkout_form_8']"));
		return postalCode;
	}
	public static WebElement Enter_Phone_No(WebDriver driver){
		
		WebElement phoneNumber = driver.findElement(By.xpath("//*[@id='wpsc_checkout_form_18']"));
		return phoneNumber;
	}
	public static WebElement Same_As_Billing_Address(WebDriver driver){
		
		WebElement shippingSameAddress = driver.findElement(By.xpath("//*[@id='shippingSameBilling']"));
		return shippingSameAddress;
	}
	public static WebElement PurchaseButton(WebDriver driver){
		
		WebElement purchaseButton = driver.findElement(By.xpath("//input[@type='submit' and @value='Purchase']"));
		return purchaseButton;
	}
}
}
