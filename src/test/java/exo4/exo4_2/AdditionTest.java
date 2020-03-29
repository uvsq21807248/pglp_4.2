package exo4.exo4_2;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class AdditionTest {
	@Test
	public void test() throws Exception {
		Addition a = new Addition();
		assertTrue(a.apply(5.0, 3.0) == 8.0);
	}
}
