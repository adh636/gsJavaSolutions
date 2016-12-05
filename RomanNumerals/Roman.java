public class Roman {

	public static void main(String[] args) {
		System.out.println(intToRoman(3944)); // should print MMMCMXLIV
		System.out.println(intToRoman(2179)); // should print MMCLXXIX
	}

	private static int[] numbers = {1000, 900, 500, 400, 100, 90, 50,
			40, 10, 9, 5, 4, 1}; 
	private static String[] letters = {"M", "CM", "D", "CD", "C", "XC",
	    	"L","XL", "X", "IX", "V", "IV", "I"};
	
    public static String intToRoman(int num) {
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
