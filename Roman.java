import java.util.TreeMap;

// contains methods and variables for converting integers to Roman Numeral
public class Roman {
	
	// numbers and letters indexed so that the position in each array match up
	private static int[] numbers = {1000, 900, 500, 400, 100, 90, 50,
			40, 10, 9, 5, 4, 1}; 
    private static String[] letters = {"M", "CM", "D", "CD", "C", "XC",
    		"L","XL", "X", "IX", "V", "IV", "I"};
    
    // main method to test output and speed
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		System.out.println(toRoman(3944)); // should print MMMCMXLIV
		System.out.println(toRoman(2179)); // should print MMCLXXIX
		long finishTime = System.currentTimeMillis();
		System.out.println("First method took " + (finishTime - startTime) + " ms");
		
		long startTime2 = System.currentTimeMillis();
		System.out.println(intToRoman(3944)); // should print MMMCMXLIV
		System.out.println(intToRoman(2179)); // should print MMCLXXIX
		long finishTime2 = System.currentTimeMillis();
		System.out.println("Second method took " + (finishTime2 - startTime2) + " ms");
	}

	// converts an integer to a Roman Numeral
    public static String toRoman(int num) {
    	StringBuilder romanNumeral = new StringBuilder();
    	int remaining = num;
    	for (int i = 0; i < numbers.length; i++) {
    		while (remaining >= numbers[i]) {
    			romanNumeral.append(letters[i]);
    			remaining -= numbers[i];
    		}
    	}
    	return romanNumeral.toString();
    }

	// recursive method returning the Roman Numeral representation of an integer
	public static String toRoman2(int num) {
	    TreeMap<Integer, String> intToRomanMap = romanTreeMap();
	    int l = intToRomanMap.floorKey(num);
	    if (num == l) {
	        return intToRomanMap.get(num);
	    }
	    return intToRomanMap.get(l) + intToRoman(num - l);
	}
	
	// returns a TreeMap of Integer keys and Roman Numeral values
	public static TreeMap<Integer, String> romanTreeMap() {
		TreeMap<Integer, String> intToRoman = new TreeMap<Integer, String>();
		intToRoman.put(1000, "M");
	    intToRoman.put(900, "CM");
	    intToRoman.put(500, "D");
	    intToRoman.put(400, "CD");
	    intToRoman.put(100, "C");
	    intToRoman.put(90, "XC");
	    intToRoman.put(50, "L");
	    intToRoman.put(40, "XL");
	    intToRoman.put(10, "X");
	    intToRoman.put(9, "IX");
	    intToRoman.put(5, "V");
	    intToRoman.put(4, "IV");
	    intToRoman.put(1, "I");
		return intToRoman;
	}
}
