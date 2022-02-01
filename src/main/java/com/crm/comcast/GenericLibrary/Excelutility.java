package com.crm.comcast.GenericLibrary;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class will read and write data onto excel sheet
 * @author Nagarjun
 *
 */
public class Excelutility {
	/**
	 * This method will read data from excel sheet and return the cell value
	 * @param sheet
	 * @param row
	 * @param cell
	 * @return
	 * @throws Throwable 
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String getDataFromExcel(String sheet, int row,int cell) throws Throwable {
		FileInputStream fis = new FileInputStream(IpathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheet);
		Row r = sh.getRow(row);
		Cell c = r.getCell(cell);
		String value=c.getStringCellValue();
		return value;
	}
	
	/**
	 * This method will return the total row count
	 * @param sheet
	 * @return
	 * @throws Throwable
	 */
	public int getRowCount(String sheet) throws Throwable {
		FileInputStream fis = new FileInputStream(IpathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheet);
		int rc = sh.getLastRowNum();
		return rc;
		
	}
	/**
	 * This method will write the data onto the excel sheet
	 * @param sheet
	 * @param rowNo
	 * @param cellNo
	 * @param data
	 * @throws Throwable
	 */
	
	public void writeDataToExcel(String sheet,int rowNo,int cellNo,String data) throws Throwable {
		FileInputStream fis = new FileInputStream(IpathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheet);
		Row r = sh.getRow(rowNo);
		Cell c = r.getCell(cellNo);
		c.setCellValue(data);
		
		FileOutputStream fos= new FileOutputStream(IpathConstants.ExcelPath);
		wb.write(fos);
		wb.close();
	}

}
