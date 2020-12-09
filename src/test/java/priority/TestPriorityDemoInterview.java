package priority;

import org.testng.annotations.Test;

public class TestPriorityDemoInterview {
	
	int i = 10 ;
	
	@Test(priority = -1)
	public void Test3() {
		// int i = 5 ;
		System.out.println("I am in Test 3");
		// System.out.println("Inside i : " + this.i);
		
	}
	
	@Test
	public void Test5() {
		System.out.println("I am in Test 5");
	}
	
	@Test
	public void Test1() {
		System.out.println("I am in Test 1");
	}
	
	@Test
	public void Test2() {
		System.out.println("I am in Test 2");
	}
	
	@Test
	public void Test4() {
		System.out.println("I am in Test 4");
	}
}
