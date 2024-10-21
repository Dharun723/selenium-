package testng;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

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
		 @Test(dataProvider="dp")
		 void sigin(String Username , String Password) throws InterruptedException {
		   Thread.sleep(400);
	        driver1.findElement(By.xpath("//input[@id='Username']")).sendKeys(Username);
	        driver1.findElement(By.xpath("//input[@id='Password']")).sendKeys(Password);
	        driver1.findElement(By.xpath("//button[normalize-space()='Sign In']")).click();
		 }
		 @Test (priority=1)
	      void accountverification() throws InterruptedException {
			 Thread.sleep(300);
	    	 String account= driver1.findElement(By.cssSelector(".s1-dashboard.h-viewport")).getText();
	    	  System.out.println("sucessfully displayed :"+account);
	      }
		        
		  @Test  (priority=2)
	     void smoke_testing() throws InterruptedException
	     {
			  Thread.sleep(300);
			 // Locate the element that contains the build version
	      String versionText = driver1.findElement(By.cssSelector("div[class=\"col-sm-auto\"]")).getText();
	      System.out.println("build version:"+versionText);
	      }
		
		 void logout() {
			 boolean dropdown = driver1.findElement(By.cssSelector("#__BVID__54")).isDisplayed();
	         System.out.println("verify"); 
	         {
	         driver1.findElement(By.xpath("//a[@class='navbar-user-profile gray-600']")).click();
	         }
		 }
		  @AfterTest
		     void closeapp() 
		   {
		 	 if(driver1 != null)
		     driver1.quit();
		   }
	 
		 
		 @DataProvider(name="dp")
		 Object [][]logindata ()
		  {
			  Object data[][]={ 
				  {"dharun@qa.com","Ecgroup2#"},
				  {"wind@test.com","Ecgroup2#"},
				  {"dharunqa@test.com","the2398423"},
				  {"rjefkfl@gmail.com","23980gn"},
			  };
	     return data;
		  }
	 }
		   
	 
		 
		            
