package JMeter;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class jmeterTest {

	private static JMeter jmeter= new JMeter();
	@Before
	public void setUp() throws Exception{
		jmeter.setName("Nobody");
		jmeter.setFriend("None");
	}
	@Test
	public void testsetName() {
		jmeter.setName("Timmy");
		assertEquals("Timmy",jmeter.getName());
	}
	@Test
	public void testsetFriend() {
		jmeter.setFriend("GirlFriend");
		assertEquals("GirlFriend",jmeter.getFriend());
	}

}
