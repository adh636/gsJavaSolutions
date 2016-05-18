public class CashRegister {
	
	// example usage of class
	public static void main(String[] args) {
		CashRegister c = new CashRegister();
		double price = 95;
		double cash = 100;
		double[][] changeForRegister = {{.01, 1.01},{.05, 2.05},{.1, 3.1},{.25, 4.25},
				{1.0, 90.0},{5.0, 55.0},{10.0, 20.0},{20.0, 60.0},{100.0, 100.0}};
		String changeForCustomer = c.checkCashRegister(price, cash, changeForRegister);
		System.out.println(changeForCustomer); // will print [[FIVE, 5.0]] to console
	}
	
	// calculates change owed and returns a string representation of that amount
	public String checkCashRegister(double price, double cash, double[][] changeInRegister) {
		double amountBack = (double)Math.round((cash - price) * 100) / 100;
		double[][] changeToReturn = returnChangeArray(amountBack, changeInRegister);
		
		if (!registerHasEnoughChange(amountBack, changeToReturn)) {
			return "Insufficient Funds";
		}
		if (isRegisterClosed(changeToReturn, changeInRegister)) {
			return "Closed";
		}
		String changeString = "[";
		for (int i = changeToReturn.length - 1; i >= 0; i--) {
			if (changeToReturn[i][1] > 0) {
				changeString += "[" + stringDenomination(changeToReturn[i][0]) + ", " + changeToReturn[i][1] + "]"; // add string representation of change owed to changeString
			}
		}
		return changeString + "]";
	}
	
	// calculates change owed and returns a 2d array representation of that amount
	private double[][] returnChangeArray(double amountBack, double[][] changeInRegister) {
		double[][] change = new double[9][2]; // 2d array of key/value pairs for the 9 denominations
		double amountStillOwed = amountBack;
		
		int counter = 0; // counter to end while loop if register has insufficient change
		while (amountStillOwed > 0 && counter < 9) {
			for (int i = change.length-1; i >= 0; i--) { // start with largest denomination and work towards smallest
				if (changeInRegister[i][0] <= amountStillOwed) {
					change[i][0] = changeInRegister[i][0]; // adds denomination to the new change array
					change[i][1] = amountToReturnFromDenomination(amountStillOwed, changeInRegister[i]); // adds value for denomination
					amountStillOwed = (double)Math.round((amountStillOwed - change[i][1]) * 100) / 100;
				}	
				else { // adds denomination and 0 value to change array
					change[i][0] = changeInRegister[i][0];
					change[i][1] = 0;
				}
				counter++;
			}
		}
		return change;
	}
	
	// how much change to return for a specific denomination 
	private double amountToReturnFromDenomination(double amountStillOwed, double[] denominationInRegister) {
		double valueOfDenominationInRegister = denominationInRegister[1];
		double maxOfDenominationNeeded = ((int) (amountStillOwed/denominationInRegister[0])) * denominationInRegister[0];
		return Math.min(valueOfDenominationInRegister, maxOfDenominationNeeded); 
	}
	
	// returns true if there is enough change in register
	private boolean registerHasEnoughChange(double amountExpected, double[][] finalChange) {
		double totalChangeInRegister = 0;
		for (double[] denomination: finalChange) {
			totalChangeInRegister += denomination[1]; // adds the amount for each denomination to totalChangeInRegister
		}
		if (totalChangeInRegister < amountExpected) {
			return false;
		}
		return true;
	}
	
	// returns true if cash in register is equal to change due
	private boolean isRegisterClosed(double[][] finalChange, double[][] changeInRegister) {
		for (int i = finalChange.length - 1; i >= 0; i--) {
			if (finalChange[i][1] != changeInRegister[i][1]) {
				return false;
			}
		}
		return true;
	}
	
	// converts double amount to String representation of denomination
	private String stringDenomination(double amount) {
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