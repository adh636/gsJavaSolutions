// contains methods and variables for converting integers to Roman Numeral
public class Roman {
	// numbers and letters indexed so that the position in each array match up
	private static int[] numbers = {1000, 900, 500, 400, 100, 90, 50,
			40, 10, 9, 5, 4, 1}; 
    private static String[] letters = {"M", "CM", "D", "CD", "C", "XC",
    		"L","XL", "X", "IX", "V", "IV", "I"};
    
	public static void main(String[] args) {
		System.out.println(toRoman(3944)); // should print MMMCMXLIV
		System.out.println(toRoman(2179)); // should print MMCLXXIX
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
}
