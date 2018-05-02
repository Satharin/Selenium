package testcases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class droppableShopping {
	

	public static void droppableShop(String browser, String user, String password, String category, String item){
		
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
		
		
		letsWait(3);
		
		//--------------------DRAG AND DROP-----------------------------
		
		WebElement accept = driver.findElement(By.xpath(".//*[@id='wrapper']/div/div[1]/div[1]/ul/li[5]"));
		accept.click();
			
			
			WebElement iframe = driver.findElement(By.xpath(".//*[@id='example-1-tab-5']/div/iframe"));
			driver.switchTo().frame(iframe);
			
			String categoryTshirt = driver.findElement(By.xpath(".//*[@id='ui-id-1']/a")).getText();
			String categoryBags = driver.findElement(By.xpath(".//*[@id='ui-id-3']/a")).getText();
			
			
					
			if(category.equals(categoryTshirt)){
				
				WebElement catTshirt = driver.findElement(By.xpath(".//*[@id='ui-id-1']/a"));
				catTshirt.click();
				
				letsWait(3);
				
				WebElement listTshirt = driver.findElement(By.xpath(".//*[@id='ui-id-2']"));
				List<WebElement> listTshirt2 = listTshirt.findElements(By.tagName("li"));
				driver.switchTo().defaultContent();
				
				
				if(item.equals("Lolcat Shirt")){
					
					WebElement tests = listTshirt2.get(0);
					
					Actions builderTshirt = new Actions(driver);
					//WebElement iframe2 = driver.findElement(By.xpath(".//*[@id='example-1-tab-5']/div/iframe"));
					//driver.switchTo().frame(iframe);
					
					WebElement drag = driver.findElement(By.xpath(".//*[@id='ui-id-2']/ul/li[1]"));
					WebElement drop = driver.findElement(By.xpath(".//*[@id='cart']/div/ol/li"));
					letsWait(3);
					Action dragAndDrop = builderTshirt.clickAndHold(tests)
							.moveToElement(drop)
							.release(drop)
							.build();
					
					dragAndDrop.perform();
					
					//driver.switchTo().defaultContent();
					
				}else if(item.equals("Cheezeburger Shirt")){
					
					listTshirt2.get(1).click();
					
				}else if(item.equals("Buckit Shirt")){
					
					WebElement tests = listTshirt2.get(2);
					
					Actions builderTshirt = new Actions(driver);
					WebElement iframe2 = driver.findElement(By.xpath(".//*[@id='example-1-tab-5']/div/iframe"));
					driver.switchTo().frame(iframe2);
					WebElement f = driver.findElement(By.xpath(".//*[@id='ui-id-2']"));
					f.sendKeys(Keys.ARROW_DOWN);
					f.sendKeys(Keys.ARROW_DOWN);
					WebElement drag = driver.findElement(By.xpath(".//*[@id='ui-id-2']/ul/li[3]"));
					WebElement drop = driver.findElement(By.xpath("//*[@id='cart']"));
					Point location = drop.getLocation();
					int locX = location.getX();
					int locY = location.getY();
					
					System.out.println(locX + " " + locY);
					
					letsWait(3);
					
					builderTshirt.dragAndDropBy(drag, 540, 10).build().perform();
					
					/*Action dragAndDrop = builderTshirt.clickAndHold(drag)
							.moveToElement(drop)
							.release(drop)
							.build();
					
					dragAndDrop.perform();*/
					
				}
				
				for(int i=0;i<listTshirt2.size();i++){
					System.out.println(listTshirt2.get(i).getText());
				}
				
			}else if(category.equals(categoryBags)){
				
				WebElement catBags = driver.findElement(By.xpath(".//*[@id='ui-id-3']/a"));
				catBags.click();
				
			}else{
				
				WebElement catGadgets = driver.findElement(By.xpath(".//*[@id='ui-id-5']/a"));
				catGadgets.click();
				
			}
			
			
			
			
			WebElement listCart = driver.findElement(By.xpath(".//*[@id='cart']"));
			List<WebElement> listCart2 = listCart.findElements(By.tagName("li"));
			
			for(int i=0;i<listCart2.size();i++){
				System.out.println(listCart2.get(i).getText());
			}
			
			
			if(listCart2.get(0).getText().equals("Buckit Shirt")){
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

