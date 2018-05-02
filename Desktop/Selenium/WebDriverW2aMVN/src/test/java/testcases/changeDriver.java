package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class changeDriver {

	public static WebDriver changeBrowser(String browser){
		
	WebDriver driver;
	
	if(browser.equals("Chrome")){
		driver = new ChromeDriver();
	}else if(browser.equals("Firefox")){
		driver = new FirefoxDriver();
	}else{
		driver = new InternetExplorerDriver();
	}
	
	return driver;
	
	}
	
}
