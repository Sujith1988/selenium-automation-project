package base;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class baseTests {
			
	public static WebDriver driver;
	public static Properties props = new Properties();
	public static Properties locs  = new Properties();
	public static FileReader fr;
	public static FileReader fr1;

//@BeforeTest ->for non datadriven testing only
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {

		String user_dir = System.getProperty("user.dir");

		if (driver == null) {
			fr = new FileReader(user_dir + "\\src\\test\\resources\\configfiles\\config.properties");
			props.load(fr);
			fr1 = new FileReader(System.getProperty("user.dir") + "\\src\\test\\resources\\configfiles\\locators.properties");
			locs.load(fr1);

			//chromedriver system property setting and new driver obj instantiation
			if (props.getProperty("browserName").equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();				
				driver.get(props.getProperty("urlName"));	//url invoking		 
				System.out.println("Chrome browser setUP successful, loaded the URL");					
			}

			//firefoxdriver system property setting and new driver obj instantiation
			else if (props.getProperty("browserName").equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				driver.get(props.getProperty("urlName"));
				driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Integer.parseInt(locs.getProperty("windo_timeout"))));
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(locs.getProperty("pag_load_wait"))));
				System.out.println("Firefox browser setUP successful, loaded the URL");
				driver.manage().window().minimize();
			}

		}

	}
	
	

//@AfterTest ->for non datadriven testing only
	@AfterMethod
	public void tearDown() throws InterruptedException {
		driver.quit();
		driver=null;  
		System.out.println("Tear down successful");		
	}
	

	
	//It is used in b_MyFirstTestFW class for now, and to be moved to utilities folder and  
	//import the utility folder in to the package(test case)-> class(b_MyFirstTestFW2)
	// JavaScript Alert Popup (e.g. alert(), confirm()) : Handled using Alert interface:
	public static int alertHandler() {	
		// 🔔 Alert Handling Block 🔔🔔🔔
		 int alert_active=1;
	    try {
	        Alert alert = driver.switchTo().alert();
	        System.out.println("Login failed, Alert found: " + alert.getText());
	        alert.accept();
	        System.out.println("Alert accepted successfully.");
	    } catch (org.openqa.selenium.NoAlertPresentException e) {
	        System.out.println("No alert present, Clean login.");
	        alert_active =0;      
	    }
	    return alert_active;
	}

	

	
}
