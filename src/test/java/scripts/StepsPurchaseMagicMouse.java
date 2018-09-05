/**Summary--
 *  * This Class contains the methods with codes for implementing steps to purchase magic mouse as specified in the test case. 
  */
package scripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import pageObjects.Accessories_Page;
import pageObjects.Checkout_Page;
import pageObjects.ToolsQA_Home_Page;
import pageObjects.Transaction_Results_Page;
import utility.ExcelUtils;
import config.ConfigProperties;


public class StepsPurchaseMagicMouse{


private WebDriver driver;
ConfigProperties getConfig=new ConfigProperties();
ExcelUtils getTestData=new ExcelUtils();
String appURL=getConfig.getProperty("appURL");
String getDriverName=getConfig.getProperty("driverName");
String status;
String testStep;

public void openBrowser() {
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

}

public void openURL() {
	System.out.println("Start of Test Case"); 
	Reporter.log("Start of Test Case"); 
	
	testStep="Step #1 - Go to ToolsQA demo online store >";
	driver.get(appURL);
	String getSiteURL=driver.getCurrentUrl();
	Assert.assertTrue(appURL.equals(getSiteURL),"Not navigated to ToolsQA website-Test Case stopped");		
	if (appURL.equals(getSiteURL)){
		status="Passed";
	}
	System.out.println(testStep);
	getConfig.reportLog(testStep, appURL, getSiteURL, status); 	
	
}


public void selectProductCategory() {
	testStep="Step #2 - Go to Product category and select Accessories";

    WebElement productCategory= ToolsQA_Home_Page.ToolsQA_Page.Product_Category(driver);
    Actions action = new Actions(driver);
    action.moveToElement(productCategory).build().perform();
	    
    WebElement accessories= ToolsQA_Home_Page.ToolsQA_Page.Accesories(driver);
    accessories.click();
    
    if (driver.getCurrentUrl().contains("product-category")){
    	status="Passed";
    }
	System.out.println(testStep);
	getConfig.reportLog(testStep, "Navigated to product page", driver.getCurrentUrl(), status);        
    
}


public void addToCartMagicMouse(){
    					
	testStep="Step #3 - Click on “Add to Cart” for just Magic Mouse"; 
    WebElement productName= Accessories_Page.Magic_Mouse.Product_Name(driver);       
  
    try {
		if (productName.equals("Magic Mouse")){
			System.out.println("Magic Mouse product is present");
		}
	} catch (Exception e) {			
		e.printStackTrace();
	}

    WebElement addToCart= Accessories_Page.Magic_Mouse.Add_To_Cart(driver);        
    addToCart.click();
    try {
		WebDriverWait waitAfterClickingAddToCart = new WebDriverWait(driver, 60);
		WebElement One_Product_Added_To_Cart=Accessories_Page.Magic_Mouse.One_Product_Added_To_Cart(driver); 
		waitAfterClickingAddToCart.until(ExpectedConditions.visibilityOf(One_Product_Added_To_Cart));
		status="Passed";
    }

    catch (Exception e1) {
		status="Failed";
		e1.printStackTrace();
		
	}

    	


	System.out.println(testStep);
	getConfig.reportLog(testStep, "Clicking Add to Cart for  "+ "Magic Mouse", "Done", status); 
} 


public void checkOutProduct(){
		
	testStep="Step#4 - Click on “Checkout” and confirm you have 1 product in your Check-Out Page";
	WebElement checkOut=Accessories_Page.Magic_Mouse.Checkout(driver);
	Assert.assertTrue(checkOut.isDisplayed(),"No CheckOut Button visible -Test Case stopped");
	checkOut.click();  
	System.out.println("Checkout clicked");
	
    if(driver.getCurrentUrl().contains("checkout")){
    	System.out.println("Successfully navigated to checkout page");
    }

    try {
    	WebElement Check_Out_Title=Checkout_Page.Check_Out.Check_Out_Title(driver);
		WebDriverWait waitForCheckOutPage = new WebDriverWait(driver, 60);			
		waitForCheckOutPage.until(ExpectedConditions.visibilityOf(Check_Out_Title));
		status="Passed";
    } catch (Exception e1) {
		status="Failed";
		e1.printStackTrace();
	}

    WebElement productMagicMouse=Checkout_Page.Check_Out.Product_Magic_Mouse(driver);
    String verfyProduct=productMagicMouse.getText();
    
   if (verfyProduct.equals("Magic Mouse")){
    	System.out.println("Magic Mouse" + " product is present on the checkout page");
        }

    WebElement productQuantity=Checkout_Page.Check_Out.Product_Quantity(driver);
          
    Assert.assertTrue(productQuantity.isDisplayed(),"No "+ "Magic Mouse" +" quantity for Magic Mouse visible -Test Case stopped");
    String verfyQuantValue=productQuantity.getAttribute("value");
    if (verfyQuantValue.contains(getConfig.getProperty("productQuantityValue"))){
    	status="Passed";
    	System.out.println(verfyQuantValue);
        }
	System.out.println(testStep);
	getConfig.reportLog(testStep,"One "+ "Magic Mouse" +" Magic Mouse product present" , "One Magic Mouse is present", status); 
    
	}
	

public void continueAfterCheckout(){
		

	testStep="Step#5 - After confirming, click on Continue";
	WebElement continueButton=Checkout_Page.Check_Out.Click_Continue(driver);
	Assert.assertTrue(continueButton.isDisplayed(),"No continue button on checkout page present -Test Case stopped");
	continueButton.click();
	if(driver.getCurrentUrl().contains("checkout")){
		status="Passed";
    } 		
    try {
    	WebElement billingForm=Checkout_Page.Check_Out.Billing_Form(driver);
		WebDriverWait billing_Contact_Page = new WebDriverWait(driver, 60);			
		billing_Contact_Page.until(ExpectedConditions.visibilityOf(billingForm));
		status="Passed";
    } catch (Exception e1) {
		status="Failed";
		e1.printStackTrace();
	}	
	
	System.out.println(testStep);
	getConfig.reportLog(testStep,"Clicked on continue" , " Done", status);
		
	}
	

public void enterContactBillingDtls(String countryCode,String provinceCode,String emailID,String firstName,String lastName,String address,String city,String province,String postalCode,String phoneNo){
		
	testStep="Step#6 - Enter test (dummy) data needed for email, billing/contact details and click Purchase";
    try{
	WebDriverWait wait = new WebDriverWait(driver, 60);
    WebElement email=Checkout_Page.Check_Out.Enter_Email(driver);
    wait.until(ExpectedConditions.visibilityOf(email));

    Checkout_Page.Check_Out.Select_Shipping_Country(driver,countryCode);
    
    WebElement shippingstate=Checkout_Page.Check_Out.Shipping_State(driver);
    shippingstate.sendKeys(provinceCode);
    
    WebElement calculateShippingButton=Checkout_Page.Check_Out.Calculate_Shipping_Button(driver);
    calculateShippingButton.click();
    
    Reporter.log("Filling Contact/Billing details :"); 
    WebElement entereEmail=Checkout_Page.Check_Out.Enter_Email(driver);
    entereEmail.sendKeys(emailID);   
    Reporter.log(emailID); 

    WebElement firstNameObj=Checkout_Page.Check_Out.Enter_First_Name(driver);
    firstNameObj.sendKeys(firstName); 
    Reporter.log(firstName); 

    WebElement lastNameObj=Checkout_Page.Check_Out.Enter_Last_Name(driver);
    lastNameObj.sendKeys(lastName); 
    Reporter.log(lastName); 

    WebElement addressObj=Checkout_Page.Check_Out.Enter_Address(driver);
    addressObj.sendKeys(address); 
    Reporter.log(address); 

    WebElement cityObj=Checkout_Page.Check_Out.Enter_City(driver);
    cityObj.sendKeys(city); 
    Reporter.log(city); 
    
    WebElement provinceObj=Checkout_Page.Check_Out.Enter_Province(driver);
    provinceObj.sendKeys(province); 
    Reporter.log(province); 
    
    Checkout_Page.Check_Out.Select_Country(driver, countryCode);

    WebElement postalCodeObj=Checkout_Page.Check_Out.Enter_Postal_Code(driver);
    postalCodeObj.sendKeys(postalCode); 
    Reporter.log(postalCode); 
    
    WebElement phoneNoObj=Checkout_Page.Check_Out.Enter_Phone_No(driver);
    phoneNoObj.sendKeys(phoneNo); 
    Reporter.log(phoneNo); 
    
    WebElement shippingSameAddress=Checkout_Page.Check_Out.Same_As_Billing_Address(driver);
    shippingSameAddress.click();
       
    }catch (Exception  e) {       	
    	Assert.assertEquals(e,e,"Could not fill billing/contact details properly - Test Case Stopped");       	      	
	}

    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("window.scrollBy(0,1000)");

    try {
    	WebElement purchaseButton=Checkout_Page.Check_Out.PurchaseButton(driver);			
		WebDriverWait waitNew = new WebDriverWait(driver, 60);
		waitNew.until(ExpectedConditions.visibilityOf(purchaseButton));
		Assert.assertTrue(purchaseButton.isDisplayed(),"No Purchase button visible - Test Case stopped");
		purchaseButton.click();
		status="Passed";
	} catch (Exception e) {
		e.printStackTrace();
	}
	System.out.println(testStep);
	getConfig.reportLog(testStep,"Details filled and clicked on Purchase" , "Done", status); 
	}


public void viewTransactionDtls(){
	
    testStep="Step#7 - Confirm that you have placed the Order in ‘Transaction Results’ page";
    try {
		WebDriverWait waitForTransPage = new WebDriverWait(driver, 60);
		waitForTransPage.until(ExpectedConditions.urlContains("transaction-results"));			
		
		WebElement transactionTitle=Transaction_Results_Page.Transaction_Results.Transaction_Dtls_Title(driver);
		WebDriverWait waitForTxnTitle= new WebDriverWait(driver, 60);
		waitForTxnTitle.until(ExpectedConditions.visibilityOf(transactionTitle));
		
		WebElement transactionContent=Transaction_Results_Page.Transaction_Results.Transaction_Dtls_Content(driver);
		String getPlacedProductDtls=transactionContent.getText();
        if (getPlacedProductDtls.contains("Magic Mouse")){
        	status="Passed";
            System.out.println(getPlacedProductDtls);
	        }
    } catch (Exception e) {
		e.printStackTrace();
	}
    driver.manage().deleteAllCookies();
    System.out.println(testStep);
	getConfig.reportLog(testStep,"One " +"Magic Mouse"+ " order present on the Transaction page" , "Done", status); 
    System.out.println("End of Test Case");
    Reporter.log("End of Test Case");
   
    
}
public void closeBrowser() {
	driver.quit();
}
}
