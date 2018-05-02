package testcases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class sortableConnect {

public static void sortableCon(String browser, String user, String password, int itemToChange, int itemToChangeWith){
		
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
	
		WebElement block = driver.findElement(By.xpath(".//*[@id='wrapper']/div[2]/div[2]/div[1]/ul/li[5]"));

		block.click();
		
		
		letsWait(3);
		
		//--------------------DRAG AND DROP-----------------------------
		
		WebElement display = driver.findElement(By.xpath(".//*[@id='wrapper']/div/div[1]/div[1]/ul/li[2]"));
		display.click();
		
		Actions builder = new Actions(driver);
		WebElement iframe = driver.findElement(By.xpath(".//*[@id='example-1-tab-2']/div/iframe"));
		driver.switchTo().frame(iframe);

		WebElement select1 = driver.findElement(By.xpath(".//*[@id='sortable1']"));
		List<WebElement> selectList1 = select1.findElements(By.tagName("li"));
		WebElement select2 = driver.findElement(By.xpath(".//*[@id='sortable2']"));
		List<WebElement> selectList2 = select2.findElements(By.tagName("li"));
		letsWait(3);
		
		String checkBefore = selectList1.get(itemToChange-1).getText();
		
		Actions builderSort = new Actions(driver);
		WebElement drag = selectList1.get(itemToChange-1);
		WebElement drop = selectList2.get(itemToChangeWith-1);

		letsWait(3);
		
		builderSort.dragAndDrop(drag, drop).build().perform();
		
		List<WebElement> selectListAfter = select2.findElements(By.tagName("li"));
		
		String check = selectListAfter.get(itemToChangeWith-1).getText();
		
		driver.switchTo().defaultContent();
		
		System.out.println(check + " " + checkBefore);
		
		if(check.equals(checkBefore)){
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
