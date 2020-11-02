package Utilities;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ResultExcel {

	public static String resultExcel(String detail) throws IOException
	{
		String fileName=DateUtil.getTimeStamp()+".xlsx";
		XSSFWorkbook workbook=new XSSFWorkbook();
		XSSFSheet sheet=workbook.createSheet("carEMIResult");
		sheet.setColumnWidth(0, 80*256);
		Row row;
		Cell cell;
		int rowNum=1;
		for(int i=0;i<rowNum;i++)
		{
			row=sheet.createRow(i);
			for(int j=0;j<1;j++)
			{
				cell = row.createCell(j);
				cell.setCellValue("Result");
        		if (detail instanceof String) {
                    cell.setCellValue((String) detail);
                } 
			}
			rowNum++;
		}
		FileOutputStream fileout = new FileOutputStream(System.getProperty("user.dir")+"/test-output/"+fileName);
		workbook.write(fileout);
			
		return fileName;
	}
}
