package base;
/* 
   This package contains the base classes which are specific for the automation testing
   using Selenium. Base classes are the classes where we store all the common 
   functionalities which requires the driver reference. These functionalities are 
   repeatedly uses inside many of the test cases.
	 	
	 	-> selenium WebDriver
	 	 
*/



/*  ---Project Structure and Dependencies----
 
 
	PROJECT STRUCTURE--(frame work)----
	---(test/src/main)---            ---(test/src/resource)---
			Base					   		ConfigFiles
			Utilities				   		TestData
			Test Cases				   		Logs
							   				Reports
		
	
				DEPENDENCIES----(jars for the library)----
				Selenium WebDriver
				Test NG
				Report NG
				Logs-Log4j
				Apache POI APIs
				WebDriver Manager
	       
	
*/