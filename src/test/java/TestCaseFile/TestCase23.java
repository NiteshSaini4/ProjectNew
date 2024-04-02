package TestCaseFile;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjectFile.LogOutClass;
import PageObjectFile.LoginClass;
import UtilitiesFile.DataDrivenTesting;

public class TestCase23 extends BaseClass {
	@Test(dataProvider = "Datapro")
	public void loginPage(String user,String pass)
	{	
		driver.get(url);
		log1.info("login url open");
		LoginClass lc=new LoginClass(driver);
		lc.user_Name(user);
		log1.info("Enter username value");
		lc.user_Pass(pass);
		log1.info("Enter password value");
		lc.user_Sub();
		log1.info("Click Submit button");
	}
	@DataProvider(name="Datapro")
	public String [][] searchData() throws Exception
	{
		String filename="C:\\Users\\user\\Desktop\\hello.xlsx";
		int r=DataDrivenTesting.getRowCount(filename,"Sheet1");
		int c=DataDrivenTesting.getCellCount(filename, "Sheet1");
		String s1[][]=new String[r-1][c];
		for(int i=1;i<r;i++)
		{
			for(int j=0;j<c;j++)
			{
				s1[i-1][j]=DataDrivenTesting.getCellvalue(filename,"Sheet1",i,j);
			}
		}
		return s1;	
	}
	
}
