/**Summary--
 * Purpose: Class gets and returns the values from the testConfig.properties file.Also contains method for reporting in testNG. 
 * Constructor method Utility -gets the testConfig.properties file and loads it into 'configFile' object. 
 * Method getProperty - get @param key as the key to fetch value from the properties file and returns the same value. 
 * Method reportLog - for parameterized reporting in testNG . @param step , @param expected , @param actual and @param status parameters for reporting steps in testNG log files.
 */
package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.Reporter;

public class Utility {

	Properties configFile = new Properties();

	public Utility(){
		try {

			configFile
					.load(new FileInputStream(
							"C://work/SeleniumWorkspaces/WS3/DemoStoreQA/src/test/java/config/testConfig.Properties"));
			System.out.println("file got");
		} catch (IOException e1) {

			e1.printStackTrace();
		}
	}
	public String getProperty(String key) {
				
		String value = this.configFile.getProperty(key);
		System.out.println(value);
		return value;
	}
	
	public void reportLog(String step, String expected,String actual, String status){
		Reporter.log(step+ " .Expected = "+expected +" and Actual = "+actual +" .Status- "+status);
	}
}
