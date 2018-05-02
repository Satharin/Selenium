package testcases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class resizableAnimate {
	

	public static void resizableAni(String browser, String user, String password){
		
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
	
		WebElement block = driver.findElement(By.xpath(".//*[@id='wrapper']/div[2]/div[2]/div[1]/ul/li[3]"));
		
		block.click();
		
		
		letsWait(3);
		
		//--------------------DRAG AND DROP-----------------------------
		
		WebElement defaultSel = driver.findElement(By.xpath(".//*[@id='wrapper']/div/div[1]/div[1]/ul/li[2]"));
		defaultSel.click();
		
		Actions builder = new Actions(driver);
		WebElement iframe = driver.findElement(By.xpath(".//*[@id='example-1-tab-2']/div/iframe"));
		driver.switchTo().frame(iframe);
		
		WebElement select = driver.findElement(By.xpath(".//*[@id='resizable']"));
	
		letsWait(2);
		
		WebElement resize = driver.findElement(By.xpath("/html/body/div/div[3]"));
		
		
		
		Actions action = new Actions(driver);
		String check = "overflow: hidden; width: 167.333px; height: 167.333px;";
	 
		action.clickAndHold(resize).moveByOffset(50, 50).release().build().perform();
		letsWait(2);
		String checkAfter = select.getAttribute("style");
		
		driver.switchTo().defaultContent();
		
		System.out.println("Check: " + check + " a checkAfter: " + checkAfter);
		
		if(check.equals(checkAfter)){
			System.out.println("FAIL");
		}else{
			System.out.println("PASS");
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
