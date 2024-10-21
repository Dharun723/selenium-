package pagefactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class pagefact {
	WebDriver driver;
	 pagefact(WebDriver driver)
	{

       this.driver=driver; 
	}
	 By s1 =By.cssSelector(".btn.btn-xl.btn-primary.px-4");
	 By username=By.xpath("//input[@id='Username']");
	 By password1=By.xpath("//input[@id='Password']");
     By signbutton=By.xpath("//button[normalize-space()='Sign In']");
     public void setusign()
     {
    	 driver.findElement(s1).click();
    	 
     }
     public void setusername(String user)
     {
    	 driver.findElement(username).sendKeys(user);
    	 
     }
     public void setpassword (String password)
     {
    	 driver.findElement(password1).sendKeys(password);
    	 
     }
     public void clickLogin ()
     {
    	 driver.findElement(signbutton).click();
     }
     
}