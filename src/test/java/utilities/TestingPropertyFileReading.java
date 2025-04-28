package utilities;

import java.io.FileNotFoundException; //not required when 'IOException' is used.
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class TestingPropertyFileReading {

	public static void main(String[] args) throws IOException {
		
		System.out.println("The current user directory is: " + System.getProperty("user.dir"));		
		
		// object of file reader from the disk location
		FileReader fr = new FileReader("F:\\eclipse workspaces\\Automation Frameworks Tutorial Maven\\2.automationFrameworkMavenBasicWithExtraPackages\\src\\test\\resources\\configfiles\\config.properties");
		
		// object of property list to posses the values from the file located in obj-'fr'
		Properties props = new Properties();
		props.load(fr); //loading the values from 'fr' using the property obj 'props'
		
		String valueFrombrowserName = props.getProperty("browserName");
		String valueFromurlName = props.getProperty("urlName");
		
		System.out.println(valueFrombrowserName +", url: " +valueFromurlName);	

	}

	
	
	
	
	//Browser Window Popup (New Tab or Window) :  Handled by switching between window handles:
	//Useful when clicking something opens a new tab or window, and you want to close it.

	/*-----------------------------------
	// Store the main window handle
	String mainWindow = driver.getWindowHandle();

	// Get all window handles
	Set<String> allWindows = driver.getWindowHandles();

	for (String window : allWindows) {
	    if (!window.equals(mainWindow)) {
	        // Switch to the popup window
	        driver.switchTo().window(window);

	        // Optionally, close it
	        driver.close();
	    }
	}

	// Switch back to the main window
	driver.switchTo().window(mainWindow);

	---------------------------------------------*/
	
	
	/* ---🔍 Tip: Want to know what kind of popup you're dealing with?
	Right-click the popup → Inspect.

	If browser blocks actions = might be alert (type 1)
	If a new window or tab opens = (type 2) browser based popup window, use above script
	If it's inside HTML = (type3) is HTML based popup window, can handle with locators  ---*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
