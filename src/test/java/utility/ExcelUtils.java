/**Summary--
 *  * This Class contains the methods to read data from the testData excel data bank for implementing Data Driver component in the test automation framework.
  */
package utility;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import config.ConfigProperties;

public  class ExcelUtils {
	private static XSSFSheet ExcelWSheet;

	private static XSSFWorkbook ExcelWBook;

	private static XSSFCell Cell;
	ConfigProperties getUtility = new ConfigProperties();
	String testDataFilePath = getUtility.getProperty("C://work/SeleniumWorkspaces/WS3/DemoStoreQA/src/test/java/testData/TestData.xlsx");

	// This method is to set the File path and to open the Excel file, Pass
	// Excel Path and Sheetname as Arguments to this method

	public  String getTestData(int RowNum, int ColNum) {
		try {
           
			System.out.println(testDataFilePath);
			// Open the Excel file

			FileInputStream ExcelFile = new FileInputStream("C://work/SeleniumWorkspaces/WS3/DemoStoreQA/src/test/java/testData/TestData.xlsx");

			// Access the required test data sheet

			ExcelWBook = new XSSFWorkbook(ExcelFile);

			ExcelWSheet = ExcelWBook.getSheet("ContactDtls");

		} catch (Exception e) {

			e.printStackTrace();

		}

		Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);

		String CellData = Cell.getStringCellValue();

		return CellData;

	}



	public String getCellValue(int r, int c)

	{

		try

		{
			FileInputStream ExcelFile = new FileInputStream("C://work/SeleniumWorkspaces/WS3/DemoStoreQA/src/test/java/testData/TestData.xlsx");

			// Access the required test data sheet

			ExcelWBook = new XSSFWorkbook(ExcelFile);

			ExcelWSheet = ExcelWBook.getSheet("ContactDtls");

		} catch (Exception e) {

			e.printStackTrace();

		}

		// Cell cell = wb.getSheet(Sheet).getRow(r).getCell(c);
		Cell = ExcelWSheet.getRow(r).getCell(c);
		return Cell.getStringCellValue();

	}

	public  int getRowCount()

	{

		try

		{
			FileInputStream fis = new FileInputStream("C://work/SeleniumWorkspaces/WS3/DemoStoreQA/src/test/java/testData/TestData.xlsx");
			ExcelWBook = new XSSFWorkbook(fis);
			ExcelWSheet = ExcelWBook.getSheet("ContactDtls");
			return ExcelWSheet.getLastRowNum();

		}

		catch (Exception e)

		{

			return 0;

		}

	}

}
