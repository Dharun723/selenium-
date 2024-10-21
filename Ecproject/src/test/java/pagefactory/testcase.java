package pagefactory;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
public class testcase {
	WebDriver driver;
	@BeforeClass
	void setup() 
	{
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(80));
		driver.get("https://devapp-systemone.azurewebsites.net/");
		driver.manage().window().maximize();
	}
	
	@Test
	void Testlogin() 
	{
		usingpagefactory lp=new usingpagefactory(driver);
		lp.setupsign();
		lp.setupusername("dharun@qa.com");
		lp.setpassword("Ecgroup2#");
		lp.setlog ();
		
		//Assert.assertEquals(driver.getTexted());
		}
	 @AfterClass
	 void tearDown() {
		driver.quit();
	}

}
