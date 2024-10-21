package grouping;

import org.testng.annotations.Test;

public class loginsign {
	@Test (priority= 1,groups={"case1","case2","case3"})
	public void welocme() {
		 System.out.println("welcome text displayed");
	}
	@Test (priority= 1,groups={"case1","case2","case3"})
	public void true1() {
		
		 System.out.println("system one");
}
}
