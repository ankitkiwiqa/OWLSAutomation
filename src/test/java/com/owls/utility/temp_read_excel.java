package com.owls.utility;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class temp_read_excel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int count = getExcelSheet(0).getLastRowNum();
		
		for (int i = 0; i < count; i++) {
			String value ="";
			try {
				//System.out.println(getExcelSheet(0).getRow(i).getCell(1).getStringCellValue());
				 value =  String.valueOf(getExcelSheet(0).getRow(i).getCell(1).getStringCellValue());
			} catch (Exception e) {
				//System.out.println(getExcelSheet(0).getRow(i).getCell(1).getNumericCellValue());
				
				 value = String.valueOf(getExcelSheet(0).getRow(i).getCell(1).getNumericCellValue());
			}
			
			
			System.out.println("<JSONPostProcessor guiclass=\"JSONPostProcessorGui\" testclass=\"JSONPostProcessor\" testname=\"getID"+(i+3)+"\" enabled=\"true\">");
			System.out.println("<stringProp name=\"JSONPostProcessor.referenceNames\">getID"+(i+3)+"</stringProp>");
			System.out.println("<stringProp name=\"JSONPostProcessor.jsonPathExprs\">$..[?(@.name == &apos;"+value+"&apos;)].id</stringProp>");
			System.out.println("<stringProp name=\"JSONPostProcessor.match_numbers\">1</stringProp>");
			System.out.println("</JSONPostProcessor>");
			System.out.println("<hashTree/>");
			/*for (int j = 0; j < count; j++) {
				
				
			}*/
		}
	
		
	}
	
	
	public static Sheet getExcelSheet(int sheetIndex) {
		String dataFilePath = "E:\\Projects\\Genix\\WGEA\\read.xlsx";
		File datafile = new File(dataFilePath);
		String fullpath = datafile.getAbsolutePath();
		Sheet firstSheet = null;
		try {

			//System.out.println("full path " + datafile.getAbsolutePath() + " con " + datafile.getCanonicalPath());

			FileInputStream inputStream = new FileInputStream(new File(fullpath));

			Workbook workbook = new XSSFWorkbook(inputStream);
			firstSheet = workbook.getSheetAt(sheetIndex);

			workbook.close();
			inputStream.close();

		} catch (Exception e) {

		}
		return firstSheet;
	}

}
