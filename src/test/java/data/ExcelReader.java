package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	public static FileInputStream fis= null;

	public FileInputStream getFileInputStream() {
		String path = System.getProperty("user.dir") + "/src/test/java/data/userData.xlsx";
		File srcFile = new File(path);
		try {
			fis = new FileInputStream(srcFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("Error occurred: " + e.getMessage());
			System.exit(0);
		}

		return fis;
	}

	public Object[][] getExcelData() throws IOException {
		fis = getFileInputStream();
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);

		int totalNumberOfRows = sheet.getLastRowNum() + 1;
		int totalNumberOfCols = 4;
		String[][] stringsExcelData = new String[totalNumberOfRows][totalNumberOfCols];

		for (int i = 0; i < totalNumberOfRows; i++) {
			XSSFRow row = sheet.getRow(i);
			for (int j = 0; j < totalNumberOfCols; j++) {
				stringsExcelData[i][j] = row.getCell(j).toString();
			}
		}
		return stringsExcelData;
	}
}
