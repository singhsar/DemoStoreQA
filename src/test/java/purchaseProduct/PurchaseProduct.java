/** Summary----
 * Purpose : Class returns run results for automation test case to buy product on ToolsQA demo web site . 
 * Utility Class is imported from config package to extract values for variables from testConfig.properties file.
 * variable 'appURL' will contain the URL for toolQA demo web site as mentioned in the properties file. 
 * Likewise, variable 'getDriverName' will contain driver information on which the test case will run.
 * 'getUtility' object of Utility class will be used to get values of variables from the properties file throughout the class as and when needed.
 * Method beforeTest -Runs before any method of the class.It Initializes driver and creates browser instance.
 * Method openURL - Opens the toolsQA web site with URL as specified in the properties file
 * Method selectProductCategory - selects the given product in the product category on toolsQA page as specified in the properties file.
 * Method purchaseAnyProduct - purchase the product selected in selectProductCategory method and verifies till transaction details page.
 * All the values mentioned in testonCfig.properties file
 * Class PurchaseProduct designed to handle any product category and any product.
 * Method afterTest - closes browser and quits the driver instance.
 */
package purchaseProduct;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import config.Utility;

public class PurchaseProduct {
	private WebDriver driver;
	Utility getUtility = new Utility();		
	String appURL=getUtility.getProperty("appURL");
	String getDriverName=getUtility.getProperty("driverName");
	String status;
	String testStep;
	
	@BeforeTest
	public void beforeTest(){
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
	
	@AfterTest
	public void afterTest() {
		driver.quit();
	}
	
	@Test(priority = 0)
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
		getUtility.reportLog(testStep, appURL, getSiteURL, status); 	
		
	}
	@Test(priority = 1)
	public void selectProductCategory() {
		testStep="Step #2 - Go to Product category and select Accessories";
			
	    WebElement productCategory = driver.findElement(By.linkText("Product Category"));	    	    
        Actions action = new Actions(driver);
        action.moveToElement(productCategory).build().perform();
		String productSubCategory=getUtility.getProperty("productSubCategory");	
        driver.findElement(By.linkText(productSubCategory)).click();      
        if (driver.getCurrentUrl().contains("product-category")){
        	status="Passed";
        }
		System.out.println(testStep);
		getUtility.reportLog(testStep, "Navigated to product page", driver.getCurrentUrl(), status);        
        
	}
	
	@Test(priority = 2)
	public void purchaseAnyProduct()throws Exception {
	    					
		testStep="Step #3 - Click on “Add to Cart” for just Magic Mouse"; 
        String verifyProductText=driver.findElement(By.xpath(getUtility.getProperty("verifyProductText"))).getText();
        String producttoBuy=getUtility.getProperty("producttoBuy");	
        try {
			if (verifyProductText.equals(producttoBuy)){
				System.out.println(producttoBuy+ "product is present");
			}else{
				Assert.assertEquals(producttoBuy, verifyProductText,producttoBuy+ "  not present in accessories -Test Case stopped");	
			}
		} catch (Exception e) {			
			e.printStackTrace();
		}
        
        String addToCart=getUtility.getProperty("addToCart");
        WebElement addToCartForProduct=driver.findElement(By.xpath(addToCart));
        
        addToCartForProduct.click();
        if(addToCartForProduct.isDisplayed()==true){
        	status="Passed";
        }       
        try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(testStep);
		getUtility.reportLog(testStep, "Clicking Add to Cart for  "+ producttoBuy, "Done", status); 
        
		
		testStep="Step#4 - Click on “Checkout” and confirm you have 1 product in your Check-Out Page";
		WebElement checkOutButton=driver.findElement(By.xpath(getUtility.getProperty("checkOutButton")));
		Assert.assertTrue(checkOutButton.isDisplayed(),"No CheckOut Button visible -Test Case stopped");
		checkOutButton.click();  
		System.out.println("Checkout clicked");
		
        if(driver.getCurrentUrl().contains("checkout")){
        	System.out.println("Successfully navigated to checkout page");
        }
        
        /*Thread.sleep applied to wait for updating of cart once Add to cart is done */
        try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}  
        String productOnCheckOutPage=getUtility.getProperty("productOnCheckOutPage");
        String verfyProduct=driver.findElement(By.xpath(productOnCheckOutPage)).getText();
        
       if (verfyProduct.equals(producttoBuy)){
        	System.out.println(producttoBuy + " product is present on the checkout page");
	        }
       
        String productQuantityOnCheckOut=getUtility.getProperty("productQuantityOnCheckOut");
        WebElement verfyQuantityOnChkOut=driver.findElement(By.xpath(productQuantityOnCheckOut));
               
        Assert.assertTrue(verfyQuantityOnChkOut.isDisplayed(),"No "+ producttoBuy +" quantity for Magic Mouse visible -Test Case stopped");
        String verfyQuantValue=verfyQuantityOnChkOut.getAttribute("value");
        if (verfyQuantValue.contains(getUtility.getProperty("productQuantityValue"))){
        	status="Passed";
        	System.out.println(verfyQuantValue);
	        }
		System.out.println(testStep);
		getUtility.reportLog(testStep,"One "+ producttoBuy +" Magic Mouse product present" , "One Magic Mouse is present", status); 
        
		
   		/*-------------------------------------- Test Step --------------------------------------- */
		testStep="Step#5 - After confirming, click on Continue";
		String continueButtonOnChkOut=getUtility.getProperty("continueButtonOnChkOut");
		WebElement continueAfterCheckOut=driver.findElement(By.xpath(continueButtonOnChkOut));
		Assert.assertTrue(continueAfterCheckOut.isDisplayed(),"No continue button on checkout page present -Test Case stopped");
		continueAfterCheckOut.click();
		if(driver.getCurrentUrl().contains("checkout")){
			status="Passed";
	    } 		
		System.out.println(testStep);
		getUtility.reportLog(testStep,"Clicked on continue" , " Done", status);
   		
		/*-------------------------------------- Test Step --------------------------------------- */
		testStep="Step#6 - Enter test (dummy) data needed for email, billing/contact details and click Purchase";
        try{
		WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(getUtility.getProperty("email")))));
        driver.findElement(By.xpath(getUtility.getProperty("calculate"))).click();
        System.out.println("Calculator clicked"); 
        driver.findElement(By.xpath(getUtility.getProperty("email"))).sendKeys(getUtility.getProperty("emailData"));
        driver.findElement(By.xpath(getUtility.getProperty("firstName"))).sendKeys(getUtility.getProperty("firstNameData"));
        driver.findElement(By.xpath(getUtility.getProperty("lastName"))).sendKeys(getUtility.getProperty("lastNameData"));
        driver.findElement(By.xpath(getUtility.getProperty("addresss"))).sendKeys(getUtility.getProperty("addresssData"));
        driver.findElement(By.xpath(getUtility.getProperty("city"))).sendKeys(getUtility.getProperty("cityData"));
        driver.findElement(By.xpath(getUtility.getProperty("province"))).sendKeys(getUtility.getProperty("provinceData"));
        driver.findElement(By.xpath(getUtility.getProperty("postalCode"))).sendKeys(getUtility.getProperty("postalCodeData"));
        driver.findElement(By.xpath(getUtility.getProperty("phoneNo"))).sendKeys(getUtility.getProperty("phoneNoData")); 
        driver.findElement(By.xpath(getUtility.getProperty("shippingSameAddress"))).click();
        Select selectCountry= new Select(driver.findElement(By.xpath(getUtility.getProperty("selectCountry"))));
        selectCountry.selectByValue(getUtility.getProperty("countryData"));    
        }catch (Exception  e) {       	
        	Assert.assertEquals(e,e,"Could not fill billing/contact details properly - Test Case Stopped");
        	throw(e);
        	
		}

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");
        
        try {
			WebDriverWait waitNew = new WebDriverWait(driver, 30);
			WebElement purchaseButton=driver.findElement(By.xpath(getUtility.getProperty("purchaseButton")));
			waitNew.until(ExpectedConditions.visibilityOf(purchaseButton));
			Assert.assertTrue(purchaseButton.isDisplayed(),"No Purchase button visible - Test Case stopped");
			purchaseButton.click();
			status="Passed";
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(testStep);
		getUtility.reportLog(testStep,"Details filled and clicked on Purchase" , "Done", status); 
 
		/*-------------------------------------- Test Step --------------------------------------- */
        testStep="Step#7 - Confirm that you have placed the Order in ‘Transaction Results’ page";
        try {
			WebDriverWait waitForTransPage = new WebDriverWait(driver, 30);
			waitForTransPage.until(ExpectedConditions.urlContains("transaction-results"));			
			WebDriverWait waitForElement= new WebDriverWait(driver, 30);
			waitForElement.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(getUtility.getProperty("productOnTransDtlsPage")))));
			String getPlacedProductDtls=driver.findElement(By.xpath("//*[@id='post-30']")).getText();
	        if (getPlacedProductDtls.contains(producttoBuy)){
	        	status="Passed";
	            System.out.println(getPlacedProductDtls);
		        }
        } catch (Exception e) {
			e.printStackTrace();
		}
        /*Thread.sleep applied to wait for staying on Transaction Details page for 2 seconds */
        try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
       
        System.out.println(testStep);
		getUtility.reportLog(testStep,"One " +producttoBuy+ " order present on the Transaction page" , "Done", status); 
        System.out.println("End of Test Case");
        Reporter.log("End of Test Case");  
	}
}
