package org.Utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.Base.BaseTest;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_Reader {

	public static final String PATH = BaseTest.xlProperties.getProperty("module1");
	public static final String SHEET = BaseTest.xlProperties.getProperty("module1sheet");
	public static FileInputStream fis = null;
	public FileOutputStream fos = null;
	// static Workbook workbook = null;

	private static Workbook getworkbook() {
		Workbook workbook = null;
		try {
			fis = new FileInputStream("C:\\Users\\mege\\Desktop\\Selenium\\Casinova\\src\\xlData");
			workbook = WorkbookFactory.create(fis);

		} catch (Exception e) {
			e.getMessage();

		}
		return workbook;
	}

	private static Sheet getSheet() {
		return getworkbook().getSheet(SHEET);
	}

	public static int getRowCount() {
		return getSheet().getPhysicalNumberOfRows();
	}

	public static String getCellData(String colName, int rowNum) {
		String cellData = null;
		int collNum = getColNumByName(colName);
		if (collNum != -1) {
			cellData = getSheet().getRow(rowNum).getCell(collNum).getStringCellValue();
		}

		return cellData;
	}

	public static void setCellData(String colName, int rowNum, String data) {
		int collNum = getColNumByName(colName);
		if (collNum != -1) {
			getSheet().getRow(rowNum).getCell(collNum).setCellValue(data);
		}
	}

	public static int getCellRowNum(String colName, String testcaseName) {
		int collNum = getColNumByName(colName);
		return getRowNumByName(collNum, testcaseName);
	}

	private static int getRowNumByName(int collNum, String testCaseName) {
		int rowNum = -1;
		for (int row = 0; row < getRowCount(); row++) {
			if (getSheet().getRow(row).getCell(collNum).getStringCellValue().equals(testCaseName)) {
				rowNum = row;
			}
		}
		return rowNum;
	}

	private static int getColNumByName(String colName) {
		Row row = getSheet().getRow(0);
		int collNum = -1;
		for (int col = 0; col < getRowCount(); col++) {
			if (row.getCell(col).getStringCellValue().equals(colName)) {
				collNum = col;
			}
		}
		return collNum;
	}

}
