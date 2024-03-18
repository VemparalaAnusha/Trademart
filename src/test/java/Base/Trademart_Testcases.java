package Base;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjectModel.Trademart_Login;
import Utilities.XLUtilities;

public class Trademart_Testcases extends Base_class {
	@Test(dataProvider="Excel")
	public void LoginTest1(String email,String pwd) throws InterruptedException, IOException {
		Trademart_Login tr=new Trademart_Login(driver);
		Thread.sleep(2000);
		tr.login();
		log.info("login button clicked");
		Thread.sleep(2000);
		tr.Email(email);
		log.info("Emailid entered");
		Thread.sleep(2000);
		tr.Password(pwd);
		log.info("Password entered");
		Thread.sleep(2000);
		tr.SubmitButton();
		log.info("Submit button clicked");
		Thread.sleep(2000);
		
		String Exp_Result="User Dashboard Trademart";
		String Act_Result=driver.getTitle();
		
		if(Act_Result.equals(Exp_Result))
		{
			Assert.assertTrue(true);
			log.info("Test case passed");
		}
		else
		{
			log.info("Test case is failed");
			CaptureScreen(driver,"LoginTest1");
			log.info("Screenshot is taken");
			driver.navigate().refresh();
			Assert.assertTrue(false);
	}
	


	}

@DataProvider(name="Excel")
String [][] getData() throws IOException{
	
	String path=System.getProperty("user.dir")+"\\ExcelSheets\\Excel.xlsx";
	int rownum=XLUtilities.getRowcount(path, "Sheet1");
	int colcount=XLUtilities.getCellcount(path, "Sheet1", 1);
	
	String logindata[][]=new String [rownum][colcount];
	 
	for(int i=1;i<=rownum;i++) {//it is represent the rows
		
		for(int j=0;j<colcount;j++) {//it is represent the columns
			logindata[i-1][j]=XLUtilities.getcelldata(path, "Sheet1", i, j);///1 0
		}
	}
	return logindata;

}
}
