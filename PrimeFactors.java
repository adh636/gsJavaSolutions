import java.util.ArrayList;

public class PrimeFactors {

	public static void main(String[] args) {
		
	}
	
	public static ArrayList<Integer> returnPrimeFactors(int input) {
		
		ArrayList<Integer> primeFactors = new ArrayList<Integer>();
		ArrayList<Integer> factors = returnFactors(input);
		
		for (int num: factors) {
			
			boolean isPrime = true;
			for (int i = 2; i < num; i++) {
				if (num % i == 0) {
					isPrime = false;
				}
			}
			
			if (isPrime && num > 1) {
				primeFactors.add(num);
			}
		}
		
		return primeFactors;
	}
	
	public static ArrayList<Integer> returnFactors(int input) {
		ArrayList<Integer> factors = new ArrayList<Integer>();
		for (int i = 1; i <= input; i++) {
			if (input % i == 0) {
				factors.add(i);
			}
		}
		return factors;
	}
}
