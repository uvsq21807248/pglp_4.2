package exo4.exo4_2;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class DivisionTest {
	@Test
	public void test() throws Exception {
		Division a = new Division();
		assertTrue(a.apply(9.0, 3.0) == 3.0);
	}
	
	@Test (expected = Exception.class)
	public void testEchec() throws Exception {
		Division a = new Division();
		a.apply(6.0, 0.0);
	}
}
