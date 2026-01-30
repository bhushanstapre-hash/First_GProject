package GPackage1;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GClass1 {

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
	}

	  @Test(priority=0)
	  public void Login() {
		  
		driver.findElement(By.xpath("//*[@id='user-name']")).sendKeys("standard_user");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
		driver.findElement(By.xpath("//input[@id='login-button']")).click();
  }
	  
	  @Test(priority=1)
	  public void ZtoA(){
		  
		Select select = new Select(driver.findElement(By.xpath("//*[@class='product_sort_container']")));
		select.selectByValue("az");
		String P1 = driver.findElement(By.xpath("//*[text()='Test.allTheThings() T-Shirt (Red)']")).getText();
		String E1 = "Test.allTheThings() T-Shirt (Red)";
		Assert.assertEquals(P1, E1);

	  }
	  
	  
	  @Test(priority=2)
	  public void lohi(){
		  
		Select select2 = new Select(driver.findElement(By.xpath("//*[@class='product_sort_container']")));
		select2.selectByValue("lohi");
		String P2 = driver.findElement(By.xpath("//*[text()='Sauce Labs Onesie']")).getText();
		String E2 = "Sauce Labs Onesie";
		Assert.assertEquals(P2, E2);
		  
	  }
	  
	  @Test(priority=3)
	  public void hilo(){
		  
		Select select2 = new Select(driver.findElement(By.xpath("//*[@class='product_sort_container']")));
		select2.selectByValue("hilo");
		String P2 = driver.findElement(By.xpath("//*[text()='Sauce Labs Fleece Jacket']")).getText();
		String E2 = "Sauce Labs Fleece Jacket";
		Assert.assertEquals(P2, E2);
		  
	  }
	  
	  @Test(priority=4)
	  public void AtoZ(){
		  
		Select select2 = new Select(driver.findElement(By.xpath("//*[@class='product_sort_container']")));
		select2.selectByValue("az");
		String P2 = driver.findElement(By.xpath("//*[text()='Sauce Labs Backpack']")).getText();
		String E2 = "Sauce Labs Backpack";
		Assert.assertEquals(P2, E2);
		  
	  }
	  
	  @Test(priority=5)
	  public void menu(){
		  
		driver.findElement(By.xpath("//*[@id='react-burger-menu-btn']")).click();
		driver.findElement(By.xpath("//*[@id='logout_sidebar_link']")).click();
		  
	  }
	    
  
  @AfterTest
  public void afterTest() {
	  driver.close();
  }

}

