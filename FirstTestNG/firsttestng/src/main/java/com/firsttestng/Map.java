package com.firsttestng;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Set;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class Map {
    public static void main(String[] args) {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Sheet1");
        HashMap<String, Object[]> data = new LinkedHashMap<String, Object[]>();  
        HashMap<String,String[]> exceldata = new LinkedHashMap<String, String[] >();
        
        exceldata.put("1", new String[]{"pair","coin"});
        exceldata.put("2", new String[]{"pair1","coin2"});
      
//        data.put("1", new Object[]{"Year", "WinnerCountryName", "LosserCountryName","By"});
//        data.put("2", new Object[]{"1975", "WestInddies", "Australia","17 Run"});
//        data.put("3", new Object[]{"1979", "WestInddies", "England","92 Run"});
//        data.put("4", new Object[]{"1983", "India", "WestIndies","43 Run"});
//        data.put("5", new Object[]{"1987", "Australia", "England","7 Run"});
//        data.put("6", new Object[]{"1992", "Pakistan", "England","22 Run"});
//        data.put("7", new Object[]{"1996", "Sri Lanka", "Australia","7 Wicket"});
//        data.put("8", new Object[]{"1999", "Australia", "Pakistan","8 Wicket"});
//        data.put("9", new Object[]{"2003", "Australia", "India","125 Run"});
//        data.put("10", new Object[]{"2007", "Australia", "Srilanka","53 Run"});
//        data.put("11", new Object[]{"2011", "India", "Srilanka","6 Wicket"});
//        data.put("12", new Object[]{"2015", "Australia", "New Zeland","7 Wicket"});        
//		Set<String> keyset = data.keySet();
//		
//		System.out.println(keyset);
//		int rownum = 0;
//		for (String key : keyset) {
//			Row row = sheet.createRow(rownum++);
//			Object[] objArr = data.get(key);
//			int cellnum = 0;
//			for (Object obj : objArr) {
//				Cell cell = row.createCell(cellnum++);
//				cell.setCellValue((String) obj);
//				System.out.println((String) obj);
//
//			}
//		}
        
		Set<String> keySet = exceldata.keySet();
		int rownum = 0;
		for (String key : keySet) {
			System.out.println(key);
			Row row = sheet.createRow(rownum++);
			String[] strarr = exceldata.get(key);
			int cellnum = 0;
			for (String str : strarr) {
				System.out.println(str);
				Cell cell = row.createCell(cellnum++);
				cell.setCellValue(str);

			}
		}        
       
		try {
			FileOutputStream out = new FileOutputStream(new File("/home/thrymr/Desktop/Bitcoin/test1.xlsx"));
			workbook.write(out);
			out.close();
			System.out.println("Excel written successfully..");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}