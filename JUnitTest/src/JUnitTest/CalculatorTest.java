package JUnitTest;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.BeforeClass;
import org.junit.AfterClass;
import org.junit.Test;
public class CalculatorTest {
	
	private static Calculator calculator=new Calculator();

	@Before   //测试方法执行之前，必须执行的代码 Fixture(固定代码段)           
	public  void setUp() throws Exception {
		calculator.clear();
	}

	@After   //测试方法执行之后，必须执行的代码
	public  void tearDownAfterClass() throws Exception {
	}

	@Test(timeout=1000)      //超过1000ms就会强行终止
	public void testAdd() {
	calculator.add(2);
	 calculator.add(3);
	 assertEquals(5, calculator.getResult());
	}
	@Test
	public void testSubstract() {
	calculator.add(10);
	 calculator.substract(2);
	 assertEquals(8,calculator.getResult());
	}
	@Ignore("Multiply() Not yet implemented")
	@Test
	public void testMultiply() {
	}
	@Test(expected =ArithmeticException.class)
	public void testDivide() {
	calculator.add(8);
	 calculator.divide(0);
	 assertEquals(4,calculator.getResult());
	}
	@Ignore
	@Test
	public void testsquare() {
		calculator.square(2);
		assertEquals(5,calculator.getResult());
	}
	@Test(timeout=1000)
	public void testsquareRoot() {
		calculator.squareRoot(3);
	}

}
