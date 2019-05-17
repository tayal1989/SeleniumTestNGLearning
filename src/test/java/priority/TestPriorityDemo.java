package priority;

import org.testng.annotations.Test;

public class TestPriorityDemo {
	
	/*
	 * When two test have same priority, then alphabetically test
	 * will get executed. Example - if test1 and test2 methods got
	 * same priority then first test1 will get executed and then
	 * test2
	 */

	@Test
	public void test1() {
		System.out.println("I am inside test 1");
	}
	
	@Test(priority = 1)
	public void test2() {
		System.out.println("I am inside test 2");
	}
	
	@Test(priority = 2)
	public void test3() {
		System.out.println("I am inside test 3");
	}
}
