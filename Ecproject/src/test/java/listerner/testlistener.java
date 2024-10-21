package listerner;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
//@Listeners(listerner.list.class)
public class testlistener {
	public class newtestng {
		  
		 WebDriver driver1;
		 @BeforeTest
		 public void setup(){
		 {
			 driver1  =new ChromeDriver();
			 driver1.manage().timeouts().implicitlyWait(Duration.ofSeconds(80));
			 driver1.get("https://devapp-systemone.azurewebsites.net/");
			 driver1.manage().window().maximize();
		} 
		}
		 
		
		 @Test (priority=0)
		 void logo () {
			 boolean logos1= driver1.findElement(By.cssSelector(".text-center.mb-4")).isDisplayed();
		     System.out.println("logo displayed"+logos1);
		     driver1.findElement(By.cssSelector(".btn.btn-xl.btn-primary.px-4")).click();
			 }  
		 
		 @Test(priority=1)
		 void sigin() throws InterruptedException {
		   Thread.sleep(400);
	        driver1.findElement(By.xpath("//input[@id='Username']")).sendKeys("dharun@qa.com");
	        driver1.findElement(By.xpath("//input[@id='Password']")).sendKeys("Ecgroup2#");
	        driver1.findElement(By.xpath("//button[normalize-space()='Sign In']")).click();
		 }
		  @Test (priority=2)
	      void accountverification() throws InterruptedException {
			 Thread.sleep(300);
	    	 String account= driver1.findElement(By.cssSelector(".s1-dashboard.h-viewport")).getText();
	    	  System.out.println("sucessfully displayed :"+account);
	      }
		        
		  @Test  (priority=3) 
	     void smoke_testing() throws InterruptedException
	     {
			  Thread.sleep(300);
			 // Locate the element that contains the build version
	      String versionText = driver1.findElement(By.cssSelector("div[class=\"col-sm-auto\"]")).getText();
	      System.out.println("build version:"+versionText);
	      }
	}
}
