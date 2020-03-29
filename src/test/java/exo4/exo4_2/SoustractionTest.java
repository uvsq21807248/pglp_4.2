package exo4.exo4_2;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class SoustractionTest {
	@Test
	public void test() throws Exception {
		Soustraction a = new Soustraction();
		assertTrue(a.apply(5.0, 2.0) == 3.0);
	}
}
