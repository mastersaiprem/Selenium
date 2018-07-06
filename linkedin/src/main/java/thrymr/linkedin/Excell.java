//package thrymr.linkedin;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.Map;
//import java.util.Set;
//import java.util.TreeMap;
//
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.CellStyle;
//import org.apache.poi.xssf.usermodel.XSSFRow;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//public class Excell {
//	public static XSSFWorkbook book1;
//	public static XSSFSheet sht2;
//	public static String path="/home/thrymr/Desktop/linkedin_resumes/pul.xlsx";
//	
////	
////	List<List<String>> masterlist = new ArrayList<List<String>>();
////	List<String> newapp = new ArrayList<String>(
////			Arrays.asList("applicant_name", "mob", "email", "experince", "Linkedin_link"));
//////	masterlist.add(newapp);
////	
////	private static File generateExcelSheet(final List<List<String>> list, final String name, final String[] columnNames)
////			throws Exception {
////		System.out.println("wwtydddddddddddddddda");
////		final File tempFile = File.createTempFile("/home/thrymr/Desktop/" + name, ".xlsx");
////
////		final XSSFWorkbook workbook = new XSSFWorkbook();
////		final XSSFSheet sheet = workbook.createSheet(name);
////		XSSFRow row;
////		final Map<Integer, Object[]> reportData = new TreeMap<Integer, Object[]>();
////		// generateExcelSheet(masterlist,"mastersaiprem" ,
////					// Arrays.asList("1","2","3","4","5").toArray(new String[5]));
////
////		reportData.put(1, columnNames);
////
////		int rowNum = 2;
////		for (int i = 0; i < list.size(); i++) {
////			reportData.put(rowNum, list.get(i).toArray(new String[list.size()]));
////			rowNum++;
////		}
////		// -------------------------------------------------------------------
////		// Iterate over data and write to sheet
////		// --------------------------------------------------------------------
////		final Set<Integer> keyid = reportData.keySet();
////		int rowid = 0;
////		String testscId = new String();
////		String testsc = new String();
////		for (final Integer key : keyid) {
////			row = sheet.createRow(rowid++);
////			final Object[] objectArr = reportData.get(key);
////			int cellid = 0;
////
////			for (final Object obj : objectArr) {
////				final Cell cell = row.createCell(cellid++);
////
////				final CellStyle style = workbook.createCellStyle(); // Create new
////				// style
////				style.setWrapText(true);
////				String cellValue = (String) obj;
////				row.setRowStyle(style);
////				cell.setCellStyle(style);
////
////				cell.setCellValue(cellValue);
////			}
////		}
////		for (int i = 1; i <= columnNames.length; i++) {
////			sheet.autoSizeColumn(i);
////		}
////		final FileOutputStream out = new FileOutputStream(tempFile);
////		workbook.write(out);
////		out.close();
////
////		return tempFile;
////	}
////	
//	public static void checkfile(String path) {
//		File file = new File(path);
//		try {
//		if(!file.exists()) {
//			createexcel(path);
//			}
//		else {
//			System.out.println("fileexists");
//		}
//		}
//		catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//	}
//	
//public static void createexcel(String path) throws IOException{
//		
//		book1 = new XSSFWorkbook();
//        sht2 = book1.createSheet("Sheet1");  
//        FileOutputStream fileOut = new FileOutputStream(path);
//        book1.write(fileOut);
//        fileOut.close();
//        book1.close();
//        System.out.println("Your excel file has been generated!");
//		
//	}
//public static void namecheck(String path) throws IOException {
//	String name="NO.";
//	System.out.println(Excellsample.rowcount(name));
//	if(Excellsample.rowcount(name)){
//		System.out.println("in for loop");
//	}
//	
//	else {
//		System.out.println("in else");
//		addToexcell(path);
//	}
//}
//
//public static void addToexcell(String path) throws IOException {
//	FileInputStream file2 = new FileInputStream(new File(path));
//	
//	
//	 book1 = new XSSFWorkbook(file2);
//	 sht2 = book1.getSheet("Sheet1");
//	 int rownumber=sht2.getLastRowNum();
//	 System.out.println(rownumber);
//	 rownumber = rownumber+1;
//	 XSSFRow ROW = sht2.createRow(rownumber);
//     ROW.createCell(0).setCellValue("No.");
//     ROW.createCell(1).setCellValue("Name");
//     ROW.createCell(2).setCellValue("Address");
//     ROW.createCell(3).setCellValue("Email");
//     ROW.createCell(4).setCellValue("Email");
//     FileOutputStream outFile = new FileOutputStream(new File(path));
//     book1.write(outFile);
//		outFile.close();
//		book1.close();
//     
//     System.out.println("row added sucessfully");
//	
//}
//
//	
//public static void main(String[] args) throws Exception {
//	checkfile(path);
//	namecheck(path);
//}
//	
//}
