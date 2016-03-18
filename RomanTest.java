import static org.junit.Assert.*;
import org.junit.*;

public class RomanTest {

	@Test
	public void test() {
		assertEquals(Roman.intToRoman(2), "II");
		assertEquals(Roman.intToRoman(3), "III");
		assertEquals(Roman.intToRoman(4), "IV");
		assertEquals(Roman.intToRoman(5), "V");
		assertEquals(Roman.intToRoman(9), "IX");
		assertEquals(Roman.intToRoman(12), "XII");
		assertEquals(Roman.intToRoman(16), "XVI");
		assertEquals(Roman.intToRoman(29), "XXIX");
		assertEquals(Roman.intToRoman(44), "XLIV");
		assertEquals(Roman.intToRoman(45), "XLV");
		assertEquals(Roman.intToRoman(68), "LXVIII");
		assertEquals(Roman.intToRoman(83), "LXXXIII");
		assertEquals(Roman.intToRoman(97), "XCVII");
		assertEquals(Roman.intToRoman(99), "XCIX");
		assertEquals(Roman.intToRoman(500), "D");
		assertEquals(Roman.intToRoman(501), "DI");
		assertEquals(Roman.intToRoman(649), "DCXLIX");
		assertEquals(Roman.intToRoman(798), "DCCXCVIII");
		assertEquals(Roman.intToRoman(891), "DCCCXCI");
		assertEquals(Roman.intToRoman(1000), "M");
		assertEquals(Roman.intToRoman(1004), "MIV");
		assertEquals(Roman.intToRoman(1006), "MVI");
		assertEquals(Roman.intToRoman(1023), "MXXIII");
		assertEquals(Roman.intToRoman(2014), "MMXIV");
		assertEquals(Roman.intToRoman(3999), "MMMCMXCIX");
	}
}