package testcases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class accordionDefault {
	

	public static void accordionDef(String browser, String user, String password, int section){
		
        WebDriver driver = changeDriver.changeBrowser(browser);
		
		String winHandleBefore = driver.getWindowHandle();
		driver.get("http://www.way2automation.com/demo.html");
		
		letsWait(3);
		
		WebElement login = driver.findElement(By.xpath(".//*[@id='wrapper']/div[2]/div[2]/div[1]/ul/li[1]/a/figure"));
		login.click();
		
		for(String winHandle : driver.getWindowHandles()){
			
			driver.switchTo().window(winHandle);
			
		}
		
		letsWait(5);
		
		WebElement signin = driver.findElement(By.xpath(".//*[@id='load_box']"));
		List<WebElement> list = signin.findElements(By.tagName("a"));
		letsWait(3);

		list.get(0).click();
		
		WebElement logginin = driver.findElement(By.xpath(".//*[@id='login']"));
		List<WebElement> list2 = logginin.findElements(By.tagName("input"));
		
		list2.get(1).sendKeys(user);
		list2.get(2).sendKeys(password);
		
		WebElement submit = driver.findElement(By.xpath(".//*[@id='load_form']/div/div[2]/input"));
		List<WebElement> list3 = logginin.findElements(By.tagName("input"));	
		
		list3.get(3).click();
		
		letsWait(3);
	
		WebElement block = driver.findElement(By.xpath(".//*[@id='wrapper']/div[2]/div[2]/div[2]/ul/li[1]"));
		
		block.click();
		
		
		letsWait(3);
		
		//--------------------DRAG AND DROP-----------------------------
		
		WebElement defaultSel = driver.findElement(By.xpath(".//*[@id='wrapper']/div/div[1]/div[1]/ul/li[1]"));
		defaultSel.click();
		
		Actions builder = new Actions(driver);
		WebElement iframe = driver.findElement(By.xpath(".//*[@id='example-1-tab-1']/div/iframe"));
		driver.switchTo().frame(iframe);
		
		WebElement select = driver.findElement(By.xpath(".//*[@id='accordion']"));
		List<WebElement> list6 = select.findElements(By.tagName("h3"));
		letsWait(3);
	
		for(int i=0;i<list6.size();i++){
			System.out.println(list6.get(i).getText());
		}
		
		list6.get(section).click();
		String check = list6.get(section).getAttribute("aria-expanded");
		System.out.println(check);
		
		driver.switchTo().defaultContent();
		
		
		
		if(check.equals("true")){
			System.out.println("PASS");
		}else{
			System.out.println("FAIL");
		}

		
		
		
	}
	
	public static void letsWait(int seconds){
	
		try {
			TimeUnit.SECONDS.sleep(seconds);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
