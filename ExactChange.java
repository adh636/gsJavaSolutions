public class ExactChange {
	
	public static void main(String[] args) {
		double price = .01;
        double cash = .02;
        double[][] cid = {{.01, 0.10}, {.05, 0.0}, {.10, 0.0},
                {.25, 0.0}, {1.00, 0.0}, {5.00, 0.00}, {10.00, 0.0},
                {20.00, 0.0}, {100.00, 0.00}};
		double[][] change = calculateChange(price, cash, cid);
		printArray(price, cash, change, cid);
		System.out.println();
		
		double price2 = 19.50;
		double cash2 = 20.00;
		double[][] cid2 = {{.01, 1.01}, {.05, 2.05}, {.10, 3.10},
				{.25, 4.25}, {1.00, 90.00}, {5.00, 55.00}, {10.00, 20.00},
				{20.00, 60.00}, {100.00, 100.00}};
		double[][] change2 = calculateChange(price2, cash2, cid2);
		printArray(price2, cash2, change2, cid2);
		System.out.println();
		
		double price3 = 3.26;
		double cash3 = 100.00;
		double[][] cid3 = {{.01, 1.01}, {.05, 2.05}, {.10, 3.10},
				{.25, 4.25}, {1.00, 90.00}, {5.00, 55.00}, {10.00, 20.00},
				{20.00, 60.00}, {100.00, 100.00}};
		double[][] change3 = calculateChange(price3, cash3, cid3);
		printArray(price3, cash3, change3, cid3);
		System.out.println();
		
		double price4 = 19.50;
		double cash4 = 20.00;
		double[][] cid4 = {{.01, .01}, {.05, 0.00}, {.10, 0.00},
				{.25, 0.00}, {1.00, 0.00}, {5.00, 0.00}, {10.00, 0.00},
				{20.00, 0.00}, {100.00, 0.00}};
		double[][] change4 = calculateChange(price4, cash4, cid4);
		printArray(price4, cash4, change4, cid4);
		System.out.println();
		
		double price5 = 19.50;
		double cash5 = 20.00;
		double[][] cid5 = {{.01, .01}, {.05, 0.00}, {.10, 0.00},
				{.25, 0.00}, {1.00, 1.00}, {5.00, 0.00}, {10.00, 0.00},
				{20.00, 0.00}, {100.00, 0.00}};
		double[][] change5 = calculateChange(price5, cash5, cid5);
		printArray(price5, cash5, change5, cid5);
		System.out.println();
		
		double price6 = 19.50;
		double cash6 = 20.00;
		double[][] cid6 = {{.01, .50}, {.05, 0.00}, {.10, 0.00},
				{.25, 0.00}, {1.00, 0.00}, {5.00, 0.00}, {10.00, 0.00},
				{20.00, 0.00}, {100.00, 0.00}};
		double[][] change6 = calculateChange(price6, cash6, cid6);
		printArray(price6, cash6, change6, cid6);
		System.out.println();
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
		if (!enoughChange(price, cash, finalChange)) {
			System.out.println("Insufficient Funds");
		}
		else if (drawerClosed(finalChange, cid)) {
			System.out.println("Closed");
		}
		else {
			for (int i = finalChange.length - 1; i >= 0; i--) {
				if (finalChange[i][1] > 0) {
					System.out.println("[" + denomition(finalChange[i][0]) + ", " + finalChange[i][1] + "]");
				}
			}
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