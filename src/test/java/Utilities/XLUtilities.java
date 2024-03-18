package Utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtilities {
	
	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook wb;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static CellStyle cs;

public static int getRowcount(String xlfile,String xlsheet) throws IOException {
		 fi=new FileInputStream(xlfile);
		 wb=new XSSFWorkbook(fi);
		 sheet=wb.getSheet("Sheet1");
		 int rowcount=sheet.getLastRowNum();
		wb.close();
		fi.close();
		return rowcount;
			
		 
	}
public static int getCellcount(String xlfile,String xlsheet,int rownum) throws IOException {
		fi=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fi);
		sheet=wb.getSheet("Sheet1");
		row=sheet.getRow(rownum);
		int cellcount=row.getLastCellNum();
		wb.close();
		fi.close();
		return cellcount;
	}
public static String getcelldata(String xlfile,String xlsheet,int rownum,int colnum) throws IOException {
		fi=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fi);
		sheet=wb.getSheet("Sheet1");
		row=sheet.getRow(rownum);
		cell=row.getCell(colnum);
		String data;
		
		try {
			DataFormatter formatter=new DataFormatter();
			String celldata=formatter.formatCellValue(cell);
			return celldata;
		}catch(Exception e) {
			data="";
		}
		wb.close();
		fi.close();
		return data;
	}
public static void setCellData(String xlfile,String xlsheet,int rownum,int colnum,String data) throws IOException {
		fi=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fi);
		sheet=wb.getSheet("Sheet1");
		row=sheet.getRow(rownum);
		cell=row.createCell(colnum);
		cell.setCellValue(data);
		fo=new FileOutputStream(xlfile);
		wb.write(fo);
		wb.close();
		fo.close();
		fi.close();

}
public static void fillGreenColor(String xlfile,String xlsheet, int rownum,int cellnum) throws IOException {
	fi=new FileInputStream(xlfile);
	wb=new XSSFWorkbook(fi);
	sheet=wb.getSheet(xlsheet);
	row=sheet.getRow(rownum);
	cell=row.getCell(cellnum);
	cs=wb.createCellStyle();
	cs.setFillForegroundColor(IndexedColors.GREEN.getIndex());//fill the color green
	cs.setFillPattern(FillPatternType.SOLID_FOREGROUND);
	cell.setCellStyle(cs);
	fo=new FileOutputStream(xlfile);
	wb.write(fo);
	wb.close();
	fi.close();
	fo.close();
	
}
public static void fillRedColor(String xlfile,String xlsheet, int rownum,int cellnum) throws IOException {
	fi=new FileInputStream(xlfile);
	wb=new XSSFWorkbook(fi);
	sheet=wb.getSheet(xlsheet);
	row=sheet.getRow(rownum);
	cell=row.getCell(cellnum);
	cs=wb.createCellStyle();
	cs.setFillForegroundColor(IndexedColors.RED.getIndex());//fill the color green
	cs.setFillPattern(FillPatternType.SOLID_FOREGROUND);
	cell.setCellStyle(cs);
	fo=new FileOutputStream(xlfile);
	wb.write(fo);
	wb.close();
	fi.close();
	fo.close();
	

}
}
