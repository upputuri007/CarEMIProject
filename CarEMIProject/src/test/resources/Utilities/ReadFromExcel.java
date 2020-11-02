package Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadFromExcel {
	public static String[] data = new String[12]; 

	/************************************ Giving input to text box from excel***********************************************/
	public static String[] readExcelData() throws IOException {

		String Path = System.getProperty("user.dir") + "\\Excel\\CarEMICalculator.xlsx";
		FileInputStream readfile = new FileInputStream(Path);
		XSSFWorkbook workbook = new XSSFWorkbook(readfile);
		XSSFSheet sheet = workbook.getSheetAt(0);
		 Row row;
		 Cell cell;
		 int i=0;
		 Iterator<Row>rowIterator=sheet.iterator();
		 while(rowIterator.hasNext()) {
			 row=rowIterator.next();
			 Iterator<Cell>cellIterator=row.iterator();
			 while(cellIterator.hasNext())
			 {
				 cell=cellIterator.next();
				 DataFormatter formatter=new DataFormatter();
				 data[i]=formatter.formatCellValue(cell);
				 System.out.println(data[i]);
				 i++;
			 }
		 }
		   workbook.close();
		   return data;
	}
}
