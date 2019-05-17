package retry_fail_cases;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGRetryFailDemo {

	@Test
	public void test1() {
		System.out.println("I am in test 1");
	}
	
	@Test
	public void test2() {
		System.out.println("I am in test 2");
		//int i = 1/0 ;
	}
	
	@Test(retryAnalyzer = MyRetry.class)
	public void test3() {
		System.out.println("I am in test 3");
		Assert.assertTrue(0 > 1);
	}
}
