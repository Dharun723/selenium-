package listerner;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGListener;
import org.testng.ITestResult;

public class list implements ITestListener 
{
	public interface ITestListener extends ITestNGListener {
	}
	
	public void onTestStart(ITestResult result) {
			   System.out.println("test started...");
			  }	
	
	public void onTestSuccess(ITestResult result) {
		 System.out.println("test passed...");
	  }
     
	public void onTestFailure(ITestResult result) {
		 System.out.println("test failure...");
	  }
	
	public void onTestSkipped(ITestResult result) {
		System.out.println("test skipped...");
	  }
	public void onFinish(ITestContext context) {
		System.out.println("test finished...");
		      }



}

