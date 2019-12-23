package testCases;

import org.testng.annotations.DataProvider;

/**
 * @author Developer
 *
Class to get the data from excel through data provider annotation */
public class ExcelToDataProvider {
	ExcelApiTest eat = null;
	String xlFilePath = "C:\\Users\\Developer\\eclipse-workspace\\entryPoint\\excel data\\Visitors data.xlsx";
	String sheetName = "Sheet1";

@DataProvider(name= "userData")
public Object[][] userFormData() throws Exception{
	Object[][] data = testData(xlFilePath,sheetName );
			return data;
}

	public Object[][] testData(String xlFilePath, String sheetName) throws Exception {
		Object[][] excelData = null;
		eat = new ExcelApiTest(xlFilePath);
		int rows = eat.getRowCount(sheetName);
		int coloums = eat.getColCount(sheetName);
		excelData = new Object[rows - 1][coloums];
		for (int i = 1; i < rows; i++) {
			for (int j = 0; j < coloums; j++) {
				excelData[i - 1][j] = eat.getCellDataColNum(sheetName, j, i);
			}
		}
		return excelData;
	}
}
