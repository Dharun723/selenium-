package basicwebapp;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Firstclass {
 public static void main(String []args) {
	WebDriver driver = new ChromeDriver();

        
             // Open the web page
             driver.get("https://devapp-systemone.azurewebsites.net/"); 
             

             // Create WebDriverWait object
             WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Timeout in seconds

             // Wait for the Sign In button to be clickable and then locate it
             WebElement signInButton = wait.until(
                 ExpectedConditions.elementToBeClickable(By.cssSelector(".btn.btn-xl.btn-primary.px-4")));
             signInButton.click(); 

             // Wait for the Username field, enter username
             WebElement user = wait.until(
                 ExpectedConditions.visibilityOfElementLocated(By.id("Username")));
             user.sendKeys("anisha123@qa.com");

             // Wait for the Password field, enter password
             WebElement password1 = wait.until(
                 ExpectedConditions.visibilityOfElementLocated(By.id("Password")) );
            
             password1.sendKeys("Ecgroup2#");

             // Wait for the Login button to be clickable and then locate it
             WebElement loginButton = wait.until(
                 ExpectedConditions.elementToBeClickable(By.className("btn-sign-in")));
         
             loginButton.click();

     
             WebElement menuButton = wait.until(
                 ExpectedConditions.elementToBeClickable(By.id(".vertical-menu-btn[Class='btn btn-sm px-3 font-size-16 header-item']")));
            
             menuButton.click();
             
             // Additional code to interact with elements after the menu is clicked

        
        	 // Close the browser
            
         
     }
 
}

 
