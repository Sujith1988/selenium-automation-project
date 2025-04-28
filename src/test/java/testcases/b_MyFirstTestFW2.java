package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.baseTests;
import utilities.b_ReadXLSData2;
import utilities.popupWindowHandlers;


public class b_MyFirstTestFW2 extends popupWindowHandlers {	//popupWindowHandler already inherited baseTests class
	@Test(dataProviderClass = b_ReadXLSData2.class, dataProvider = "userCredentialFromExternalFile")
	public static void LoginTest(String usrN, String passW) throws NumberFormatException, InterruptedException {
		
		
		 //alternate for line 24 to 29
		 //driver.findElement(By.xpath(locs.getProperty("usr_name"))).sendKeys(usrN);		
		 //driver.findElement(By.xpath(locs.getProperty("pas_word"))).sendKeys(passW);
		 //driver.findElement(By.xpath(locs.getProperty("login_button"))).click();
		
		// The actual login fuction testing 
		WebElement username = driver.findElement(By.id(locs.getProperty("usr_name")));
		username.sendKeys(usrN);		
		driver.findElement(By.id(locs.getProperty("pas_word"))).sendKeys(passW);	
		Thread.sleep(Integer.parseInt(locs.getProperty("sleep_1")));
		driver.findElement(By.className(locs.getProperty("login_button"))).click();		
		Thread.sleep(Integer.parseInt(locs.getProperty("sleep_2")));
			
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


};