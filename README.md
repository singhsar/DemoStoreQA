# DemoStoreQA

Summary
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

