package beforeafterconcept;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestClass2 {

	@BeforeClass
	public void testClass2() {
		System.out.println("I am in test class 2");
	}
	
	@Test
	public void testMethod2() {
		System.out.println("I am in test method 2");
	}
}
