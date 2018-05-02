package testcases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class droppableRevert {
	

	public static void droppableRev(String browser, String user, String password, String isDropped){
		
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
	
		WebElement block = driver.findElement(By.xpath(".//*[@id='wrapper']/div[2]/div[2]/div[1]/ul/li[2]"));
	
		block.click();
		
		
		letsWait(2);
		
		//--------------------DRAG AND DROP-----------------------------
		
		WebElement revert = driver.findElement(By.xpath(".//*[@id='wrapper']/div/div[1]/div[1]/ul/li[4]"));
		revert.click();
		
		if(isDropped.equals("yes")){
			
			Actions builder = new Actions(driver);
			WebElement iframe = driver.findElement(By.xpath(".//*[@id='example-1-tab-4']/div/iframe"));
			driver.switchTo().frame(iframe);
			
			WebElement drag = driver.findElement(By.xpath(".//*[@id='draggable']"));
			WebElement drop = driver.findElement(By.xpath(".//*[@id='droppable']"));
			
			Point location = drag.getLocation();
			
			Action dragAndDrop = builder.clickAndHold(drag)
					.moveToElement(drop)
					.release(drop)
					.build();
			
			dragAndDrop.perform();
			
			letsWait(3);
			
			Point location2 = drag.getLocation();

			String ifDraggable = driver.findElement(By.xpath(".//*[@id='droppable']/p")).getText();
			
			driver.switchTo().defaultContent();
			
			if(ifDraggable.equals("Dropped!") && location.equals(location2)){
				System.out.println("PASS");
				System.out.println(location + " " + location2);
			}else{
				System.out.println("FAIL");
				System.out.println(location + " " + location2);
			}
			
		}else{
			
			Actions builder = new Actions(driver);
			WebElement iframe = driver.findElement(By.xpath(".//*[@id='example-1-tab-4']/div/iframe"));
			driver.switchTo().frame(iframe);
			
			WebElement drag = driver.findElement(By.xpath(".//*[@id='draggable2']"));
			WebElement drop = driver.findElement(By.xpath(".//*[@id='droppable']"));
			
			Point location = drag.getLocation();
			
			Action dragAndDrop = builder.clickAndHold(drag)
					.moveToElement(drop)
					.release(drop)
					.build();
			
			dragAndDrop.perform();
			
			letsWait(3);
			
			Point location2 = drag.getLocation();

			String ifDraggable = driver.findElement(By.xpath(".//*[@id='droppable']/p")).getText();
			
			driver.switchTo().defaultContent();
			
			if(ifDraggable.equals("Dropped!") && !location.equals(location2)){
				System.out.println("PASS");
				System.out.println(location + " " + location2);
			}else{
				System.out.println("FAIL");
				System.out.println(location + " " + location2);
			}
			
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
