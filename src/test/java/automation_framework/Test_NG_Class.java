/**Summary--
 *  * This Class is the main driver TestNG class for this test automation project and also configured in the testng.xml file . 
 *  *@BeforeTest method openBrowser - instantiates driver and opens a new browser
 *  *@Test method purchaseMagicMouse - performs all the steps to buy the product Magic Mouse as specified in the Test Case.
 *   *@AfterTest method closeBrowser - quits the driver instance on which the test case ran.
  */
package automation_framework;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import scripts.PurchaseMagicMouse;

public class Test_NG_Class {
	
	PurchaseMagicMouse buyMagicMouse=new PurchaseMagicMouse();
	
	@BeforeTest
	public void openBrowser() {
		buyMagicMouse.openBrowser();

	}
	
	@Test
	public void purchaseMagicMouse() {
		buyMagicMouse.placeOrderMagicMouse();
	 
	}
	
	@AfterTest
	public void closeBrowser() {
		buyMagicMouse.closeBrowser();
	}
}
