package testCases;

import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @author Developer
 * Class to read data from excel
 */
public class ExcelApiTest {
	public FileInputStream fis = null;
    public XSSFWorkbook workbook = null;
    public XSSFSheet sheet = null;
    public XSSFRow row = null;
    public XSSFCell cell = null;
    String xlFilePath; 
 
    public ExcelApiTest(String xlFilePath) throws Exception
    {
    	this.xlFilePath=xlFilePath;
        fis = new FileInputStream(xlFilePath);
        workbook = new XSSFWorkbook(fis);
        fis.close();
    }
 
    public String getCellDataColName(String sheetName, String j, int rowNum)
    {
        try
        {
            int col_Num = -1;
            sheet = workbook.getSheet(sheetName);
            row = sheet.getRow(0);
            for(int i = 0; i < row.getLastCellNum(); i++)
            {
                if(row.getCell(i).getStringCellValue().trim().equals(j))
                    col_Num = i;
            }

            row = sheet.getRow(rowNum - 1);
            cell = row.getCell(col_Num);
 
            if(cell.getCellType() == Cell.CELL_TYPE_STRING)
                return cell.getStringCellValue();
            else if(cell.getCellType() == Cell.CELL_TYPE_NUMERIC || cell.getCellType() == Cell.CELL_TYPE_FORMULA)
            {
                String cellValue = String.valueOf(cell.getNumericCellValue());
                if(HSSFDateUtil.isCellDateFormatted(cell))
                {
                    DateFormat df = new SimpleDateFormat("dd/MM/yy");
                    Date date = cell.getDateCellValue();
                    cellValue = df.format(date);
                }
                return cellValue;
            }else if(cell.getCellType() == Cell.CELL_TYPE_BLANK)
                return "";
            else
                return String.valueOf(cell.getBooleanCellValue());
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return "row"+rowNum+" or column"+ j +" does not exist  in Excel";
        }
    }
    public int getRowCount (String sheetName) {
    	sheet = workbook.getSheet(sheetName);
    	int rowCount = sheet.getLastRowNum() + 1;
    	return rowCount;
    }
    
    public int getColCount(String sheetName)
    {
    	sheet = workbook.getSheet(sheetName);
    	row = sheet.getRow(0);
    	int colCount = row.getLastCellNum();
    	return colCount;
    }
    public String getCellDataColNum(String sheetName , int colNum , int rowNum) {
    	try {
    		sheet = workbook.getSheet(sheetName);
    		row = sheet.getRow(rowNum);
    		cell = row.getCell(colNum);
    		if(cell.getCellType() == Cell.CELL_TYPE_STRING )
    			return cell.getStringCellValue();
    		else if (cell.getCellType()== Cell.CELL_TYPE_NUMERIC ||cell.getCellType()== Cell.CELL_TYPE_FORMULA) {
    			String cellValue = String.valueOf(cell.getNumericCellValue());
    			if(HSSFDateUtil.isCellDateFormatted(cell)) {
    				DateFormat df = new SimpleDateFormat("dd/mm/yy");
    				Date date = cell.getDateCellValue();
    				cellValue = df.format(date);
    				
    			}
    			return cellValue;
    		}else if(cell.getCellType()==cell.CELL_TYPE_BLANK)
    		return "";
    		else
    			return String.valueOf(cell.getBooleanCellValue());
    		
    	}
    	catch (Exception e) {
    		e.printStackTrace();
    		return "No Matched Value";
    	}
    }
    }

