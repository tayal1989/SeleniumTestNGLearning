package utils;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	static String projectPath ;
	static XSSFWorkbook workbook ;
	static XSSFSheet sheet ;
	
	public ExcelUtils(String excelPath, String sheetName) {
		try {
			workbook = new XSSFWorkbook(excelPath) ;
			sheet = workbook.getSheet(sheetName) ;
		} catch(Exception exp) {
			System.out.println(exp.getMessage()) ;
			System.out.println(exp.getCause()) ;
			exp.printStackTrace() ;
		}
	}

	public static int getRowCount() {
		int rowCount = 0 ;
		rowCount = sheet.getPhysicalNumberOfRows() ;
		System.out.println("No of rows : " + rowCount) ;
		return rowCount ;
	}
	
	public static int getColCount(int rowNo) {	
		int colCount = 0 ;
		colCount = sheet.getRow(rowNo).getPhysicalNumberOfCells() ;
		System.out.println("No of cols : " + colCount) ;	
		return colCount ;
	}
	
	public static String getCellDataString(int rowNum, int colNum) {
		String cellData = "" ;
		try {
			cellData = sheet.getRow(rowNum).getCell(colNum).getStringCellValue() ;
			//System.out.println(cellData);
		} catch(Exception exp) {
			System.out.println(exp.getMessage()) ;
			System.out.println(exp.getCause()) ;
			exp.printStackTrace() ;
		}
		return cellData ;
	}
	
	public static void getCellDataNumeric(int rowNum, int colNum) {
		try {
			double cellData = sheet.getRow(rowNum).getCell(colNum).getNumericCellValue() ;
			System.out.println(cellData);
		} catch(Exception exp) {
			System.out.println(exp.getMessage()) ;
			System.out.println(exp.getCause()) ;
			exp.printStackTrace() ;
		}
	}
	
	public static void main(String[] args) {
		getRowCount();
		getCellDataString(0, 0);
		getCellDataNumeric(1, 1);
	}
}
