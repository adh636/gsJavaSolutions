public class ExactChange {
	
	public static void main(String[] args) {
		double price = .01;
        double cash = .02;
        double[][] cid = {{.01, 0.10}, {.05, 0.0}, {.10, 0.0},
                {.25, 0.0}, {1.200, 0.0}, {5.00, 0.00}, {10.00, 0.0},
                {20.00, 0.0}, {100.00, 0.00}};
		double[][] change = calculateChange(price, cash, cid);
		printArray(price, cash, change, cid);
	}
	
	// returns a 2d array of change due
	public static double[][] calculateChange(double price, double cash, double[][] cid) {
		double[][] change = new double[cid.length][2];
		double amountBack = cash - price;
		
		int counter = 0;
		while (amountBack >= 0.01 && counter < cid.length) {
			for (int i = cid.length - 1; i >= 0; i--) {
				if (cid[i][0] <= amountBack) {
					change[i][0] = cid[i][0];
					change[i][1] = Math.min(cid[i][1], ((int) (amountBack/cid[i][0])) * cid[i][0]);
					amountBack -= change[i][1];
				}
				else {
					change[i][0] = cid[i][0];
					change[i][1] = 0.00;
				}
				counter++;
			}
		}
		return change;
	}
	
	// prints the change returned from highest to lowest
	public static void printArray(double price, double cash, double[][] finalChange, double[][] cid) {
		if (drawerClosed(finalChange, cid)) {
			System.out.println("Closed");
		}
		else if (enoughChange(price, cash, finalChange)) {
			for (int i = finalChange.length - 1; i >= 0; i--) {
				if (finalChange[i][1] > 0) {
					System.out.println("[" + denomition(finalChange[i][0]) + ", " + finalChange[i][1] + "]");
				}
			}
		}
		else {
			System.out.println("Insufficient Funds");
		}
	}
	
	// returns true if cash-in-drawer is equal to change due
	public static boolean drawerClosed(double[][] finalChange, double[][] cid) {
		for (int i = finalChange.length - 1; i >= 0; i--) {
			if (finalChange[i][1] != cid[i][1]) {
				return false;
			}
		}
		return true;
	}
	
	// returns true if there is enough change
	public static boolean enoughChange(double price, double cash, double[][] finalChange) {
		double totalChange = 0;
		for (double[] amount: finalChange) {
			totalChange += amount[1];
		}
		if (totalChange < (cash - price)) {
			return false;
		}
		return true;
	}
	
	// convert double amount to String representation of amount
	public static String denomition(double amount) {
		String s = "";
		switch (Double.toString(amount)) {
			case "100.0": 
				s = "ONE HUNDRED";
				break;
			case "20.0": 
				s = "TWENTY";
				break;
			case "10.0": 
				s = "TEN";
				break;
			case "5.0":
				s = "FIVE";
				break;
			case "1.0": 
				s = "ONE";
				break;
			case "0.25": 
				s = "QUARTER";
				break;
			case "0.1": 
				s = "DIME";
				break;
			case "0.05": 
				s = "NICKEL";
				break;
			case "0.01": 
				s = "PENNY";
				break;
		}
		return s;
	}
}