package com.firsttestng;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Test {

	public static XSSFWorkbook book;
	public static XSSFSheet sht;

	// Write Data in to ExcellSheet
	public static void writeXLSXFile() throws Exception {
		FileInputStream file2 = new FileInputStream(
				new File("/home/thrymr/Desktop/Bitcoin/Results_Sample_3_4_5_v.01.xlsx"));
		book = new XSSFWorkbook(file2);
		sht = book.getSheet("Results_Sample_4");
		String sheetname = "";
		XSSFRow ROW = sht.getRow(2);
		String[] str = { "N1", "N2", "N3", "N4", "N5", "N6", "N7", "N8", "N9", "N10", "N12", "N13", "N14", "N15", "N16",
				"N17", "N18", "NX" };
		List<String> li = new ArrayList<String>();
		for (int c = 0; c < str.length; c++) {
			li.add(str[c]);
		}

		int rownumber = sht.getLastRowNum();
		int columnumber = ROW.getLastCellNum() - 1;

		for (int i = 1; i < rownumber; i++) {

			for (int counter = 0; counter < li.size(); counter++) {
				if (sht.getRow(i).getCell(columnumber) != null) {
					if (li.get(counter).contains(sht.getRow(i).getCell(columnumber).getStringCellValue())) {

						sheetname = li.get(counter);
						String filename = sht.getRow(i).getCell(1).getStringCellValue();
						String correct_prediction = sht.getRow(i).getCell(9).getStringCellValue();
						System.out.println(filename + "," + correct_prediction + "," + sheetname);
						writedata(sheetname, filename, correct_prediction);
						file2 = new FileInputStream(
								new File("/home/thrymr/Desktop/Bitcoin/Results_Sample_3_4_5_v.01.xlsx"));
						book = new XSSFWorkbook(file2);
						sht = book.getSheet("Results_Sample_4");
					}

				}

				else {
					sheetname = "NX";
					String filename = sht.getRow(i).getCell(1).getStringCellValue();
					String correct_prediction = "NX";
					System.out.println(filename + "," + correct_prediction + "," + sheetname);
					writedata(sheetname, filename, correct_prediction);
					file2 = new FileInputStream(
							new File("/home/thrymr/Desktop/Bitcoin/Results_Sample_3_4_5_v.01.xlsx"));
					book = new XSSFWorkbook(file2);
					sht = book.getSheet("Results_Sample_4");
				}

			}
		}

	}

	public static void writedata(String sheetname1, String filename, String correct_prediction) throws Exception {
		FileInputStream file2 = new FileInputStream(new File("/home/thrymr/Desktop/dup1.xlsx"));
		book = new XSSFWorkbook(file2);
		sht = book.getSheet(sheetname1);
		System.out.println("stata" + sheetname1);
		int rownumber = sht.getLastRowNum();
		System.out.println(rownumber);
		rownumber = rownumber + 1;
		XSSFRow ROW = sht.createRow(rownumber);

		ROW.createCell(1).setCellValue(filename);
		ROW.createCell(2).setCellValue(correct_prediction);
		FileOutputStream outFile = new FileOutputStream(new File("/home/thrymr/Desktop/dup1.xlsx"));
		book.write(outFile);
		outFile.close();
		book.close();
		System.out.println("row added sucessfully");

	}

	public static void main(String[] args) throws Exception {
		writeXLSXFile();

	}

}
