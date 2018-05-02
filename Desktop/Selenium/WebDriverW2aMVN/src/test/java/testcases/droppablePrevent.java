package testcases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class droppablePrevent {
	

	public static void droppablePrev(String browser, String user, String password, String place){
		
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
		
		WebElement prevent = driver.findElement(By.xpath(".//*[@id='wrapper']/div/div[1]/div[1]/ul/li[3]/a"));
		prevent.click();
		
		if(place.equals("leftOut")){
			
			Actions builder = new Actions(driver);
			WebElement iframe = driver.findElement(By.xpath(".//*[@id='example-1-tab-3']/div/iframe"));
			driver.switchTo().frame(iframe);
			
			WebElement drag = driver.findElement(By.xpath(".//*[@id='draggable']"));
			WebElement drop = driver.findElement(By.xpath(".//*[@id='droppable']"));
			
			builder.dragAndDropBy(drag, 140, 0).build().perform();
			
			String ifDraggable = driver.findElement(By.xpath(".//*[@id='droppable']/p")).getText();
			String ifDraggableIn = driver.findElement(By.xpath(".//*[@id='droppable-inner']/p")).getText();
			
			driver.switchTo().defaultContent();
			
			if(ifDraggable.equals("Dropped!") && ifDraggableIn.equals("Inner droppable (not greedy)")){
				System.out.println("PASS");
			}else{
				System.out.println("FAIL");
			}
			
		}else if(place.equals("rightOut")){
			
			Actions builder = new Actions(driver);
			WebElement iframe = driver.findElement(By.xpath(".//*[@id='example-1-tab-3']/div/iframe"));
			driver.switchTo().frame(iframe);
			
			WebElement drag = driver.findElement(By.xpath(".//*[@id='draggable']"));
			WebElement drop = driver.findElement(By.xpath(".//*[@id='droppable2']"));
			
			builder.dragAndDropBy(drag, 380, 0).build().perform();
			
			String ifDraggable = driver.findElement(By.xpath(".//*[@id='droppable2']/p")).getText();
			String ifDraggableIn = driver.findElement(By.xpath(".//*[@id='droppable2-inner']/p")).getText();
			
			driver.switchTo().defaultContent();
			
			if(ifDraggable.equals("Dropped!") && ifDraggableIn.equals("Inner droppable (greedy)")){
				System.out.println("PASS");
			}else{
				System.out.println("FAIL");
			}
			
		}else if(place.equals("leftIn")){
			
			Actions builder = new Actions(driver);
			WebElement iframe = driver.findElement(By.xpath(".//*[@id='example-1-tab-3']/div/iframe"));
			driver.switchTo().frame(iframe);
			
			WebElement drag = driver.findElement(By.xpath(".//*[@id='draggable']"));
			WebElement drop = driver.findElement(By.xpath(".//*[@id='droppable-inner']"));
			Action dragAndDrop = builder.clickAndHold(drag)
					.moveToElement(drop)
					.release(drop)
					.build();
			
			dragAndDrop.perform();
			
			String ifDraggable = driver.findElement(By.xpath(".//*[@id='droppable-inner']/p")).getText();
			String ifDraggableOut = driver.findElement(By.xpath(".//*[@id='droppable']/p")).getText();
			
			driver.switchTo().defaultContent();
			
			if(ifDraggable.equals("Dropped!") && ifDraggableOut.equals("Dropped!")){
				System.out.println("PASS");
			}else{
				System.out.println("FAIL");
			}
			
		}else{
			
			Actions builder = new Actions(driver);
			WebElement iframe = driver.findElement(By.xpath(".//*[@id='example-1-tab-3']/div/iframe"));
			driver.switchTo().frame(iframe);
			
			WebElement drag = driver.findElement(By.xpath(".//*[@id='draggable']"));
			WebElement drop = driver.findElement(By.xpath(".//*[@id='droppable2-inner']"));
			Action dragAndDrop = builder.clickAndHold(drag)
					.moveToElement(drop)
					.release(drop)
					.build();
			
			dragAndDrop.perform();
			
			String ifDraggable = driver.findElement(By.xpath(".//*[@id='droppable2-inner']/p")).getText();
			String ifDraggableOut = driver.findElement(By.xpath(".//*[@id='droppable2']/p")).getText();
			
			driver.switchTo().defaultContent();
			
			if(ifDraggable.equals("Dropped!") && ifDraggableOut.equals("Outer droppable")){
				System.out.println("PASS");
			}else{
				System.out.println("FAIL");
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
