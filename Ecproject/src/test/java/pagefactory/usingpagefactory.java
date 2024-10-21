package pagefactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class usingpagefactory {
 WebDriver driver;
usingpagefactory(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver,this);
} 
 @FindBy(css =".btn.btn-xl.btn-primary.px-4") WebElement sign;
 @FindBy(xpath= "//input[@id='Username']")WebElement username;
 @FindBy(xpath="//input[@id='Password']")WebElement password;
 @FindBy(xpath="//button[normalize-space()='Sign In']")WebElement login;

 public void setupsign()
 {
	 sign.click();
 }
 public void setupusername (String user)
 {
	 username.sendKeys(user);
 }
 public void setpassword(String password1)
 {
	 password.sendKeys(password1);
 }
 public void setlog()
 {
	 login.click();
 }
}

