import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class PrimeTests {

	@Test
	public void testReturnsArray() {
		ArrayList<Integer> testIsArray = new ArrayList<Integer>();
		testIsArray.add(2);
		assertEquals(PrimeFactors.returnPrimeFactors(2), testIsArray);
	}
	
	@Test
	public void testReturnFactors() {
		ArrayList<Integer> factorsOf6 = new ArrayList<Integer>();
		factorsOf6.add(1);
		factorsOf6.add(2);
		factorsOf6.add(3);
		factorsOf6.add(6);
		assertEquals(PrimeFactors.returnFactors(6), factorsOf6);
	}
	
	@Test
	public void testReturnsPrime() {
		ArrayList<Integer> primeFactorsOf8 = new ArrayList<Integer>();
		primeFactorsOf8.add(2);
		assertEquals(PrimeFactors.returnPrimeFactors(8), primeFactorsOf8);
	}
}
