package thrymr.linkedin;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVFile {
	
	
	//CSV file header
		
		
	//Delimiter used in CSV file
	private static final String COMMA_DELIMITER = ",";
	private static final String NEW_LINE_SEPARATOR = "\n";
	
	public static void writeCsvFile(String fullname,String mobilenumber, String email, String Experience, String Linkedin_link, File file, String FILE_HEADER ) {
	
		FileWriter fileWriter = null;
				
		try {
			fileWriter = new FileWriter(file);

			//Write the CSV file header
			fileWriter.append(FILE_HEADER.toString());
			
			//Add a new line separator after the header
			fileWriter.append(NEW_LINE_SEPARATOR);
			
			//Write a new student object list to the CSV file
			
				fileWriter.append(fullname);
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(mobilenumber);
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(email);
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(Experience);
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(Linkedin_link);
				System.out.println("CSV file was created successfully !!!");
			
		} catch (Exception e) {
			System.out.println("Error in CsvFileWriter !!!");
			e.printStackTrace();
		} finally {
			
			try {
				fileWriter.flush();
				fileWriter.close();
			} catch (IOException e) {
				System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
			}
			
		}
	}
}


