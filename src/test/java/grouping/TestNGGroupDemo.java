package grouping;

import org.testng.Assert;
import org.testng.annotations.Test;

/*@Test  (groups= {"alltestclasses"}) */
public class TestNGGroupDemo {

	@Test(groups = { "sanity" }, enabled = true)
	public void test1() {
		System.out.println("This is test 1");
	}

	@Test(groups = { "sanity", "smoke" }, enabled = true)
	public void test2() {
		//System.out.println("This is test 2");
		Assert.assertTrue(false);
	}

	@Test(groups = { "sanity", "regression" }, enabled = true)
	public void test3() {
		System.out.println("This is test 3");
	}

	@Test
	public void test4() {
		System.out.println("This is test 4");
		// Assert.assertTrue(false);
	}

	@Test(dependsOnMethods = { "test4", "test2" }, enabled = true)
	public void test5() {
		System.out.println("This is test 5");
	}
}
