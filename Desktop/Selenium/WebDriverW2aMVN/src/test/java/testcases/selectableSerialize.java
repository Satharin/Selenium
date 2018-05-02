package testcases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class selectableSerialize {

public static void selectableSer(String browser, String user, String password, int number){
		
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
	
		WebElement block = driver.findElement(By.xpath(".//*[@id='wrapper']/div[2]/div[2]/div[1]/ul/li[4]"));
		
		block.click();
		
		
		letsWait(3);
		
		//--------------------DRAG AND DROP-----------------------------
		
		WebElement serialize = driver.findElement(By.xpath(".//*[@id='wrapper']/div/div[1]/div[1]/ul/li[3]"));
		serialize.click();
		
		Actions builder = new Actions(driver);
		WebElement iframe = driver.findElement(By.xpath(".//*[@id='example-1-tab-3']/div/iframe"));
		driver.switchTo().frame(iframe);
		
		WebElement select = driver.findElement(By.xpath(".//*[@id='selectable']"));
		List<WebElement> list6 = select.findElements(By.tagName("li"));
		letsWait(3);

		list6.get(number-1).click();
		
		String check = driver.findElement(By.xpath("//*[@id='select-result']")).getText();
		
		driver.switchTo().defaultContent();
		
		
		
		if(check.equals("#" + Integer.toString(number))){
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

