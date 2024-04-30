package genericLib;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class UtilityClass {
	
	/**
	 * 
	 * @param path pass the path of the properties file
	 * @param key pass the url key from prop file
	 * @return string
	 * @throws Throwable
	 */
	public String readDataFromPropFile(String path, String key) throws Throwable
	{
		File file = new File(path);
		FileInputStream fis = new FileInputStream(file);
		Properties pro = new Properties();
		pro.load(fis);
		String value = pro.getProperty(key);
		return value;
	}
	
	//single cell value
	public String readDataFromExcelSingleValue(String path,String sheetName, int RowNo, int CellNo) throws Exception
	{
		File file = new File(path);
		FileInputStream fis = new FileInputStream(file);
		Workbook book = WorkbookFactory.create(fis);
		String data = book.getSheet(sheetName).getRow(RowNo).getCell(CellNo).toString();
		return data;
				
	}
	
	//all values of one row
	public String[] readDataFromExcelRowValues(String path,String sheetName, int RowNo) throws Exception
	{
		File file = new File(path);
		FileInputStream fis = new FileInputStream(file);
		Workbook book = WorkbookFactory.create(fis);
		int cellNum = book.getSheet(sheetName).getRow(RowNo).getPhysicalNumberOfCells();
		String[] data = new String[cellNum];
		for(int i=0;i<cellNum;i++)
		{
			data[i] = book.getSheet(sheetName).getRow(RowNo).getCell(i).toString();
		}
		return data;
		
	}
	
	//all values of one column
	public String[] readDataFromExcelOneColumn(String path,String sheetName, int columnNo) throws Throwable
	{
		File file = new File(path);
		FileInputStream fis = new FileInputStream(file);
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet(sheetName);
		int RowNo = sheet.getPhysicalNumberOfRows();
		String[] data = new String[RowNo];
		for(int i=0;i<RowNo;i++)
		{
			data[i] = sheet.getRow(i).getCell(columnNo).toString();
		}
		return data;
	}
	
	
	//all values of the sheet
		public String[][] readDataFromExcelFullSheet(String path,String sheetName) throws Exception
		{
			File file = new File(path);
			FileInputStream fis = new FileInputStream(file);
			Workbook book = WorkbookFactory.create(fis);
			int numRows = book.getSheet(sheetName).getPhysicalNumberOfRows();
			int numCells = book.getSheet(sheetName).getRow(0).getPhysicalNumberOfCells();
			String[][] data = new String[numRows][numCells];
			for(int i=0;i<numRows;i++)
			{
				for(int j=0;j<numCells;j++)
				{
					data[i][j] = book.getSheet(sheetName).getRow(i).getCell(j).toString();
				}
			}
			
			return data;
		}
		
		public void writeDataInExcelOneCell(String path,String sheetName,int RowNo, int CellNo,String value) throws IOException
		{
			File file = new File(path);
			FileInputStream fis = new FileInputStream(file);
			Workbook book = WorkbookFactory.create(fis);
			Sheet she = book.getSheet(sheetName);
			Row row = she.getRow(RowNo);
			Cell cell = row.createCell(CellNo);
			cell.setCellValue(value);
			FileOutputStream fos = new FileOutputStream(path);
			book.write(fos);
			book.close();
		}
	
}
