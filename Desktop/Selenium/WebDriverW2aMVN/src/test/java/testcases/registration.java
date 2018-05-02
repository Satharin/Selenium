package testcases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class registration {
	
	public static void register(String browser, String name, String phone, String email, String city,
			String country, String user, String password){
	
	WebDriver driver = changeDriver.changeBrowser(browser);
	driver.get("http://www.way2automation.com/demo.html");
	
	
	try {
		TimeUnit.SECONDS.sleep(3);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	String winHandleBefore = driver.getWindowHandle();
	WebElement login = driver.findElement(By.xpath(".//*[@id='wrapper']/div[2]/div[2]/div[1]/ul/li[1]/a/figure"));
	login.click();	
	
	try {
		TimeUnit.SECONDS.sleep(5);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	for(String winHandle : driver.getWindowHandles()){
		driver.switchTo().window(winHandle);
	}
	
	WebElement test = driver.findElement(By.xpath(".//*[@id='load_box']"));
	List<WebElement> list = test.findElements(By.tagName("input"));
	
	
	/*for(int i=0;i<list.size();i++){
		
		System.out.println(list.get(i).getAttribute("name"));
		
	}*/
	
	list.get(1).sendKeys(name);
	list.get(2).sendKeys(phone);
	list.get(3).sendKeys(email);
	list.get(4).sendKeys(city);
	list.get(5).sendKeys(user);
	list.get(6).sendKeys(password);
	
	Select select = new Select(driver.findElement(By.xpath(".//*[@id='load_form']/fieldset[4]/select")));
	select.selectByValue(country);
	
	WebElement sub = driver.findElement(By.xpath(".//*[@id='load_box']"));
	List<WebElement> list2 = sub.findElements(By.className("button"));

	list2.get(0).click();
	
	
	
	}

}
