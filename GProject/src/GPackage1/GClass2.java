package GPackage1;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GClass2 {
	
WebDriver driver;
	
	@BeforeTest
  public void beforeTest() {

		ChromeOptions options = new ChromeOptions();
		Map<String,Object>prefs = new HashMap<String,Object>();
		prefs.put("credentioals_enable_service", false);
		prefs.put("profile.password_manager_enable", false);
		prefs.put("profile.password_manager_leak_detection", false);
		options.setExperimentalOption("prefs", prefs);
	
		driver = new ChromeDriver(options);
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//String username = "standard_user";
		//String password = "secret_sauce";
	
  }

  @Test(priority=0)
  public void Login() {
	  
	driver.findElement(By.xpath("//*[@id='user-name']")).sendKeys("standard_user");
	driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
	driver.findElement(By.xpath("//input[@id='login-button']")).click();
	
  }
  
  @Test(priority=1)
  public void productpage() {
	  
	 String actual =  driver.findElement(By.xpath("//span[text()='Products']")).getText();
	 String expected = "Products";
	 Assert.assertEquals(actual, expected);
	 
	 String actual2 =   driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']")).getText();
	 String expected2 = "Sauce Labs Backpack";
	 Assert.assertEquals(actual2, expected2);
	 
	 driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).click();
	 driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
	 
	 }

  @Test(priority=2)
  public void youcartpage() {	
	  
	 String actual = driver.findElement(By.xpath("//*[text()='Your Cart']")).getText();
	 String expected = "Your Cart";
	 Assert.assertEquals(actual, expected);
	 
	 String actual2 =   driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']")).getText();
	 String expected2 = "Sauce Labs Backpack";
	 Assert.assertEquals(actual2, expected2);
	 
	 driver.findElement(By.xpath("//button[@id='checkout']")).click();
  }
  @Test(enabled = false)
  public void yourInformation() {	
	  
	/*
	 boolean youIn = driver.findElement(By.xpath("//*[@class='title']")).getText();
	
	 youIn.equals("Adding for fail cases");
	 
		  if(youIn=true) {
			  System.out.println("Succesfully verified = Checkout: Your Information");
		  }
		  else {
			  System.out.println("Case is fail");
		  }
	*/	  
		  boolean youInf = driver.findElement(By.xpath("//*[@class='title']")).getText().equals("Checkout: Your Information");
		  if(youInf=true) {
			  System.out.println("Succesfully verified = Checkout: Your Information");
		  }
		  else {
			  System.out.println("Case is fail");
		  }
	 }
		  
		  
  	@Test(priority=3)
	  public void yourInformatio() {	
  		driver.findElement(By.xpath("//*[@id='first-name']")).sendKeys("Bhushan");
  		driver.findElement(By.xpath("//*[@id='last-name']")).sendKeys("Tapre");
  		driver.findElement(By.xpath("//*[@id='postal-code']")).sendKeys("101010");
  		
  		driver.findElement(By.xpath("//*[@id='continue']")).click();
		  
  }
	
  	@Test(priority=4)
	  public void Overview() {	
		String actual = driver.findElement(By.xpath("//*[text()='Checkout: Overview']")).getText();
		String expected = "Checkout: Overview";
		 Assert.assertEquals(actual, expected);
		 
		 String actual2 =   driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']")).getText();
		 String expected2 = "Sauce Labs Backpack";
		 Assert.assertEquals(actual2, expected2);
		 
		 driver.findElement(By.xpath("//*[@id='finish']")).click();
		   
}

  	@Test(priority=5)
	  public void Complete() {	
		String actual = driver.findElement(By.xpath("//*[text()='Checkout: Complete!']")).getText();
		String expected = "Checkout: Complete!";
		 Assert.assertEquals(actual, expected);
		 
		 String actual2 =   driver.findElement(By.xpath("//*[text()='Thank you for your order!']")).getText();
		 String expected2 = "Thank you for your order!";
		 Assert.assertEquals(actual2, expected2);
		 
		 driver.findElement(By.xpath("//*[text()='Back Home']")).click();
		   
}
  
  @AfterTest
  public void afterTest() {
  }

}

