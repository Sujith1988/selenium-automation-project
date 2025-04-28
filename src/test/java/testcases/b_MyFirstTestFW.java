package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.baseTests;


public class b_MyFirstTestFW extends baseTests {	
	@Test(dataProvider = "userCredentialsFromInternalArray")
	public static void LoginTest(String usrN, String passW) throws NumberFormatException, InterruptedException {
		
		// The actual login fuction testing
		WebElement username = driver.findElement(By.id(locs.getProperty("usr_name")));
		username.sendKeys(usrN);
		driver.findElement(By.id(locs.getProperty("pas_word"))).sendKeys(passW);
		Thread.sleep(Integer.parseInt(locs.getProperty("sleep_2")));
		driver.findElement(By.className(locs.getProperty("login_button"))).click();
		Thread.sleep(Integer.parseInt(locs.getProperty("sleep_1")));
			
		//handling the alert window popup 💡
		int alert_active = alertHandler();
		
		//printing the test status
		if(alert_active==0) {
			String LogoutText = driver.findElement(By.xpath("//a[@href='../../index.jsp']")).getText();
			System.out.println(LogoutText);
			driver.findElement(By.xpath("//a[@href='../../index.jsp']")).click();	
			String actual = "LOGOUT";
			if(LogoutText.equals(actual)) {
			System.out.println("*******Login test-positive success and clicked on button :"+LogoutText +"*****");
			}
		}else if(alert_active==1) {
			System.out.println("******Login test-negative success(Login failed!!)*******");
			//driver.findElement(By.xpath("//a[@href='../../index.jsp']")); --> if u want to fail the test case.
		}
     
    }

	

	//data driven testing using the testNG annotation
	@DataProvider(name = "userCredentialsFromInternalArray")
	public Object[][] createData1() {
		return new Object[][] {
			{ "admin", "useradmin1"},
			{ "admin1", "useradmin"},
			{ "admin", "useradmin"}  
		};
	}


};