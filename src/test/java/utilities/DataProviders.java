package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	// DataProvider 1

	@DataProvider(name = "LoginData")
	public String[][] getData() throws IOException {

		String path = ".\\testData\\Opencart_LoginData.xlsx";// taking xl file from testData

		ExcelUtility excelUtil = new ExcelUtility(path); // creating an object for XLUtility

		int totalRows = excelUtil.getRowCount("Sheet1");
		int totalCells = excelUtil.getCellCount("Sheet1", 1);

		String loginData[][] = new String[totalRows][totalCells]; // created for two dimension array which can store the
																	// data user and password

		for (int r = 1; r <= totalRows; r++) // 1 //read the data from xl storing in two deminsional array
		{

			for (int c = 0; c < totalCells; c++) // 0 i is rows j is col

			{
				loginData[r - 1][c] = excelUtil.getCellData("Sheet1", r, c); // 1,0
			}
		}

		return loginData;// returning two dimension array

	}

	// DataProvider 2

	// DataProvider 3

	// DataProvider 4

}
