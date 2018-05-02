package testcases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class accordionFillSpace {
	

	public static void accordionFill(String browser, String user, String password, int section, int x, int y){
		
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
		
		WebElement defaultSel = driver.findElement(By.xpath(".//*[@id='wrapper']/div/div[1]/div[1]/ul/li[3]"));
		defaultSel.click();
		
		Actions builder = new Actions(driver);
		WebElement iframe = driver.findElement(By.xpath(".//*[@id='example-1-tab-3']/div/iframe"));
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
		
		
		Actions action = new Actions(driver);
		
		WebElement resize = driver.findElement(By.xpath("/html/body/div/div[4]"));
		
		int resWidth = select.getSize().getWidth();
		int resHeight = select.getSize().getHeight();
	 
		action.clickAndHold(resize).moveByOffset(x, y).release().build().perform();
		letsWait(2);
		
		
		int resWidthAfter = select.getSize().getWidth();
		int resHeightAfter = select.getSize().getHeight();	
		
		System.out.println("Before: "+resWidth+","+resHeight+" After: "+resWidthAfter+","+resHeightAfter);
		
		driver.switchTo().defaultContent();
		
		
		
		if(check.equals("true") && resWidthAfter == (resWidth + x) && resHeightAfter == (resHeight + y)){
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
