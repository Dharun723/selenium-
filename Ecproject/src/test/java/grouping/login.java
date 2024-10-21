package grouping;

import org.testng.annotations.Test;

public class login {
	

@Test (priority= 1,groups={"case1"})
public void name () {
	 System.out.println("dharun enter");
 }
@Test(priority= 2,groups={"case1"})
public void passwrord() {
	 System.out.println("xjnxnx");
}
}
