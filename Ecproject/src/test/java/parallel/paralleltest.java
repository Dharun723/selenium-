package parallel;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class paralleltest {
	WebDriver driver1;

	 @BeforeClass
	 @Parameters({"browser"})
	 public void setup(String br) throws InterruptedException{
	 {
		 switch(br.toLowerCase())
		 {
		 case "chrome":driver1=new ChromeDriver();break;
		 case "edge":driver1=new EdgeDriver();break;
		 case "firefox":driver1=new FirefoxDriver();break;
		 default:System.out.println("invalid browser");return;
		 }
		 driver1.manage().timeouts().implicitlyWait(Duration.ofSeconds(80));
		 driver1.get("https://devapp-systemone.azurewebsites.net/");
		 driver1.manage().window().maximize();
		 Thread.sleep(5000);
	} 
	} 
	 
	 @Test (priority=0)
	 void logo () {
		 boolean logos1= driver1.findElement(By.cssSelector(".text-center.mb-4")).isDisplayed();
	     Assert.assertEquals(logos1,true);
	     driver1.findElement(By.cssSelector(".btn.btn-xl.btn-primary.px-4")).click();
		 }  
	 @Test (priority=1)
	 void testurl() 
	 {
		 Assert.assertEquals(driver1.getCurrentUrl(),"https://devapp-systemone.azurewebsites.net/");
	 }
	 @Test (priority=2)
	 void login() throws InterruptedException 
	 {
		driver1.findElement(By.xpath("//input[@id='Username']")).sendKeys("dharun@qa.com");
		driver1.findElement(By.xpath("//input[@id='Password']")).sendKeys("Ecgroup2#");
		driver1.findElement(By.xpath("//button[normalize-space()='Sign In']")).click();
		WebElement welocme=driver1.findElement(By.cssSelector(".p-sm-2.p-lg-5.m-lg-5.dashboard-bg"));
		String Systemone=welocme.getText();
		System.out.println("Welcome text verified"+Systemone);
				
		 WebElement dropdownElement = driver1.findElement(By.cssSelector("#__BVID__54"));
		    dropdownElement.click();
		    System.out.println("Dropdown clicked and displayed ");
		    // Locate and verify the logout icon (or any verification element)
		    WebElement verifyElement = driver1.findElement(By.xpath("//i[contains(@class,'align-middle me-1 text-danger')]"));
		    String verifyText = verifyElement.getText();
		    System.out.println("Logout icon verified " + verifyText);
	        // Click on the profile link to log out
		    WebElement logout = driver1.findElement(By.xpath("//a[@class=\"navbar-user-profile gray-600\"]"));
		    Thread.sleep(300);	  
		    
		    if (logout.isDisplayed()) {
		    	logout.click();
		        System.out.println("logout clicked");
		        Assert.assertTrue(true, "Logout successful");
		    } 
		    else 
		    {
		        Assert.fail("logout is not visible");
		    }
	 }
	 
	 @AfterClass
	 void closeapp() {
		 driver1.quit();
	 }
}                                     
