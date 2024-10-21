package dataprovider;
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

public class dataprovider {
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
	 void sigin(String Username , String Password) throws InterruptedException {//throws InterruptedException {
	 
        driver1.findElement(By.xpath("//input[@id='Username']")).sendKeys(Username);
        driver1.findElement(By.xpath("//input[@id='Password']")).sendKeys(Password);
        driver1.findElement(By.xpath("//button[normalize-space()='Sign In']")).click();
        
        Thread.sleep(200);
	 
	  WebElement dropdownElement = driver1.findElement(By.cssSelector("#__BVID__54"));
	    dropdownElement.click();
	    System.out.println("Dropdown clicked and displayed ");
	    // Locate and verify the logout icon (or any verification element)
	    WebElement verifyElement = driver1.findElement(By.xpath("//i[contains(@class,'align-middle me-1 text-danger')]"));
	    String verifyText = verifyElement.getText();
	    System.out.println("Logout icon text: " + verifyText);
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
	    driver1.findElement(By.cssSelector(".btn.btn-xl.btn-primary.px-4")).click();
	 }  
	 
	 
	 
	@DataProvider(name="dp")
    Object [][]logindata ()
         { 
	      Object data[][]={ 
	    		   {"dharun@qa.com","Ecgroup2#"},
	    		   {"dharunermw","rgeg"}
		           
	            };
             return data;
             
 }
	
     @Test (priority=1)
     void smoke_testing() throws InterruptedException
     {
		  Thread.sleep(30);
		 // Locate the element that contains the build version
      String versionText = driver1.findElement(By.cssSelector("div[class=\"col-sm-auto\"]")).getText();
      System.out.println("build version:"+versionText);
      }
    
			 
		        
	@AfterTest
     void closeapp() 
   {
 	 
     driver1.quit();
   }

}


  
