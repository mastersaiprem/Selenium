package thrymr.bitcoin;

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

	public class Exceldata {
		public static XSSFWorkbook book;
		public static XSSFSheet sht;
		//Check the file exists or not
		public static void checkfile(File path, String sheetName) {
			File file = path;
			try {
				if (!file.exists()) {
					createexcel(path,sheetName);
				} else {
					System.out.println("fileexists");
					file.delete();
					createexcel(path,sheetName);
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}

		//Creating Excel if not exists
		public static void createexcel(File path, String sheetName) throws IOException {

			book = new XSSFWorkbook();
			sht = book.createSheet(sheetName);
			XSSFRow ROW = sht.createRow(0);
			ROW.createCell(1).setCellValue("Last Price");
			ROW.createCell(0).setCellValue("Pair");
			FileOutputStream fileOut = new FileOutputStream(path);
			book.write(fileOut);
			fileOut.close();
			book.close();
			System.out.println("Your excel file has been generated!");

		}
		//Write Data in to ExcellSheet
		public static void writeXLSXFile(String Pair, String lastPrice, String path, String sheetName) throws IOException {
			FileInputStream file2 = new FileInputStream(new File(path));
			book = new XSSFWorkbook(file2);
			
			if (book.getNumberOfSheets() != 0) {
		        for (int i = 0; i < book.getNumberOfSheets(); i++) {
		           if (book.getSheetName(i).equalsIgnoreCase(sheetName)) {
		                sht = book.getSheet(sheetName);
		            }
		           else {
		        	   
		        	   try {
		        		sht = book.createSheet(sheetName);
		        	    XSSFRow ROW = sht.createRow(0);
		   				ROW.createCell(1).setCellValue("Last Price");
		   				ROW.createCell(0).setCellValue("Pair");
		        	   }
		        	   
		        	   catch(Exception e){
		        		   sht = book.getSheet(sheetName);
		        	   }
		           }
		        }
		    }
		    else {
		        // Create new sheet to the workbook if empty
		        sht = book.createSheet(sheetName);
		        XSSFRow ROW = sht.createRow(0);
   				ROW.createCell(1).setCellValue("Last Price");
   				ROW.createCell(0).setCellValue("Pair");
		    }
			int rownumber = sht.getLastRowNum();
			System.out.println(rownumber);
			rownumber = rownumber + 1;
			XSSFRow ROW = sht.createRow(rownumber);
			ROW.createCell(0).setCellValue(Pair);
			//ROW.createCell(1).setCellValue(Coin);
			ROW.createCell(1).setCellValue(lastPrice);
			FileOutputStream outFile = new FileOutputStream(new File(path));
			book.write(outFile);
			outFile.close();
			book.close();
			System.out.println("row added sucessfully");

		}

	}
	
	
	
	
	
	
	

