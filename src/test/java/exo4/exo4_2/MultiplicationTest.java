package exo4.exo4_2;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class MultiplicationTest {
	@Test
	public void test() throws Exception {
		Multiplication a = new Multiplication();
		assertTrue(a.apply(3.0, 2.0) == 6.0);
	}
}
