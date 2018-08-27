/**Summary--
 *  * This Class contains the methods to implement data driver testing with iterations for different data sets present in the data bank.
 *  * method openBrowser - instantiates driver and opens a new browser
 *  * method purchaseMagicMouse - for different set of data- performs all the steps to buy the product Magic Mouse as specified in the Test Case.
 *  * method closeBrowser - quits the driver instance on which the test case ran.
 *  
  */
package scripts;
import java.io.IOException;
import utility.ExcelUtils;
import utility.TestNG_Reports;
import config.ConfigProperties;

public class PurchaseMagicMouse {

	ConfigProperties getConfig=new ConfigProperties();
	ExcelUtils getTestData=new ExcelUtils();
	String appURL=getConfig.getProperty("appURL");
	String getDriverName=getConfig.getProperty("driverName");
	StepsPurchaseMagicMouse purchase = new StepsPurchaseMagicMouse();
	TestNG_Reports tgReport = new TestNG_Reports();
	int getRowCount = getTestData.getRowCount();
	String countryCode;
	String provinceCode;
	String emailID;
	String firstName;
	String lastName;
	String address;
	String city;
	String province;
	String postalCode;
	String phoneNo;

	public  void openBrowser() {
		purchase.openBrowser();

	}

	public void placeOrderMagicMouse() {

		for (int i = 1; i <= getRowCount; i++) {

			System.out.println(i);
			System.out.println(getRowCount);
			countryCode = getTestData.getCellValue(i, 1);
			provinceCode = getTestData.getCellValue(i, 2);
			emailID = getTestData.getCellValue(i, 3);
			firstName = getTestData.getCellValue(i, 4);
			lastName = getTestData.getCellValue(i, 5);
			address = getTestData.getCellValue(i, 6);
			city = getTestData.getCellValue(i, 7);
			province = getTestData.getCellValue(i, 8);
			postalCode = getTestData.getCellValue(i, 9);
			phoneNo = getTestData.getCellValue(i, 10);

			System.out.println(countryCode + provinceCode + emailID + firstName
					+ lastName + address + city + province + postalCode
					+ phoneNo);
			purchase.openURL();
			purchase.selectProductCategory();
			purchase.addToCartMagicMouse();
			purchase.checkOutProduct();
			purchase.continueAfterCheckout();
			purchase.enterContactBillingDtls(countryCode, provinceCode,
					emailID, firstName, lastName, address, city, province,
					postalCode, phoneNo);
			purchase.viewTransactionDtls();
			try {
				tgReport.Take_TestOutput_Backup();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}


	public void closeBrowser() {
		purchase.closeBrowser();
	}

}
