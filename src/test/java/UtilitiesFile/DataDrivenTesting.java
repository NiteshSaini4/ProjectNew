package UtilitiesFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.*;

public class DataDrivenTesting {
	public static XSSFWorkbook WB;
	public static XSSFSheet WS;
	public static XSSFRow Rw;
	public static XSSFCell CL;
	public static FileInputStream fn;
	public static String getCellvalue(String filename,String shetname,int row, int coll) throws Exception
	{
		 fn=new FileInputStream(filename);
		 WB=new XSSFWorkbook(fn);
		WS= WB.getSheet(shetname);
		CL=WB.getSheet(shetname).getRow(row).getCell(coll);//student,Password
		WB.close();
		return CL.getStringCellValue();	
	}
	public static int getRowCount(String filename,String shetname ) throws Exception
	{
		fn=new FileInputStream(filename);
		 WB=new XSSFWorkbook(fn);
		WS= WB.getSheet(shetname);
		int toRow=WS.getLastRowNum()+1;
		WB.close();
		return toRow;
		
	}
	public static int getCellCount(String filename,String shetname ) throws Exception
	{
		fn=new FileInputStream(filename);
		 WB=new XSSFWorkbook(fn);
		WS= WB.getSheet(shetname);
		int toCell=WS.getRow(0).getLastCellNum();
		WB.close();
		return toCell;
	}

}
