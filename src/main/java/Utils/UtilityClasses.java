package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hpsf.Date;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
class UtilityClasses{

public static void captureScreen(WebDriver driver, String testId ) throws IOException
{
	Date currentDate=new Date();
	String date=currentDate.toString().replace(" ", "-").replace(":", " ");
	
	File source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	File Dest=new File("test-output\\Screenshot\\Test-"+testId+" "+date+".jpeg");
	FileHandler.copy(source,Dest);
	//("test-output\\Screenshot\\Test-"+testId+" "+date+".jpeg");
	
}
public static String getDatafromExcle(String SheetName,int cellNumber,int rowNumber) throws EncryptedDocumentException, IOException
{

	String data;
     String  path = "/test.org/src/test/resources/ExcleSheet/Book1.xlsx";
	
	FileInputStream  file = new FileInputStream( path);
	 
	Workbook book = WorkbookFactory.create(file);
	
	try
	{
		data=book.getSheet("Sheet1").getRow(rowNumber).getCell(cellNumber).getStringCellValue();
	}
	catch(Exception e)
	{
		double d= book.getSheet("Sheet1").getRow(rowNumber).getCell(cellNumber).getNumericCellValue();
		data=String.valueOf(d);
	}
	return data;		 
}
}