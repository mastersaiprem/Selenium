package thrymr.linkedin;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.gargoylesoftware.htmlunit.javascript.host.Set;
import com.microsoft.schemas.office.office.BorderleftcolorAttribute;

public class Excellsample {
	public static XSSFWorkbook book;
	public static XSSFSheet sht;
	//Check the applicant name exists or not
	public static boolean checkName(String fullName, String path) throws IOException {
		boolean isExists = false;
		FileInputStream file1 = new FileInputStream(new File(path));
		book = new XSSFWorkbook(file1);
		sht = book.getSheet("Sheet1");
		int rownumber = sht.getLastRowNum();
		for (int i = 0; i < rownumber; i++) {
			if (sht.getRow(i) != null && sht.getRow(i).getCell(0) != null
					&& sht.getRow(i).getCell(0).getStringCellValue() != null) {

				if (fullName.equalsIgnoreCase(sht.getRow(i).getCell(0).getStringCellValue())) {
					System.out.println("true");
					XSSFCell r = sht.getRow(i).getCell(i);
					isExists = true;
				}
			}
		}
		return isExists;
	}
	//Check the file exists or not
	public static void checkfile(File path) {
		File file = path;
		try {
			if (!file.exists()) {
				createexcel(path);
			} else {
				System.out.println("fileexists");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	//Creating Excel if not exists
	public static void createexcel(File path) throws IOException {

		book = new XSSFWorkbook();
		sht = book.createSheet("Sheet1");
		FileOutputStream fileOut = new FileOutputStream(path);
		book.write(fileOut);
		fileOut.close();
		book.close();
		System.out.println("Your excel file has been generated!");

	}
	//Write Data in to ExcellSheet
	public static void writeXLSXFile(String Fullname, String mobilenumber, String email, String Experience,
			String Linkedinlin, String fileStatus, String path) throws IOException {
		FileInputStream file2 = new FileInputStream(new File(path));
		book = new XSSFWorkbook(file2);
		sht = book.getSheet("Sheet1");
		int rownumber = sht.getLastRowNum();
		System.out.println(rownumber);
		rownumber = rownumber + 1;
		XSSFRow ROW = sht.createRow(rownumber);
		ROW.createCell(0).setCellValue(Fullname);
		ROW.createCell(1).setCellValue(mobilenumber);
		ROW.createCell(2).setCellValue(email);
		ROW.createCell(3).setCellValue(Experience);
		ROW.createCell(4).setCellValue(Linkedinlin);
		ROW.createCell(5).setCellValue(fileStatus);
		FileOutputStream outFile = new FileOutputStream(new File(path));
		book.write(outFile);
		outFile.close();
		book.close();
		System.out.println("row added sucessfully");

	}

}