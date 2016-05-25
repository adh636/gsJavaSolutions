public class CashRegister {

	public static void main(String[] args) {
		CashRegister c = new CashRegister();
		double price = 95;
		double cash = 100;
		double[][] changeForRegister = {{.01, 1.01},{.05, 2.05},{.1, 3.1},{.25, 4.25},
				{1.0, 90.0},{5.0, 55.0},{10.0, 20.0},{20.0, 60.0},{100.0, 100.0}};
		String changeForCustomer = c.checkCashRegister(price, cash, changeForRegister);
		System.out.println(changeForCustomer);
	}
	
	public String checkCashRegister(double price, double cash, double[][] changeInRegister) {
		double amountBack = (double)Math.round((cash - price) * 100) / 100;
		double[][] arrayOfChangeToReturn = returnChangeArray(amountBack, changeInRegister);
		String stringOfChangeToReturn = "[";
		
		if (!registerHasEnoughChange(amountBack, arrayOfChangeToReturn)) {
			return "Insufficient Funds";
		}
		
		if (isRegisterClosed(arrayOfChangeToReturn, changeInRegister)) {
			return "Closed";
		}
		
		for (int i = arrayOfChangeToReturn.length - 1; i >= 0; i--) {
			if (arrayOfChangeToReturn[i][1] > 0) {
				stringOfChangeToReturn += changeArrayToString(arrayOfChangeToReturn[i]);
			}
		}
		return stringOfChangeToReturn + "]";
	}
	
	private String changeArrayToString(double[] denominationAndValue) {
		String denominationToAdd = stringDenomination(denominationAndValue[0]);
		double amountOfDenominationToAdd = denominationAndValue[1];
		return "[" + denominationToAdd + ", " + amountOfDenominationToAdd + "]";
	}
	
	
	private double[][] returnChangeArray(double amountBack, double[][] changeInRegister) {
		double[][] changeToReturn = new double[9][2];
		double amountStillOwed = amountBack;
		
		int denominationCounter = 0;
		while (amountStillOwed > 0 && denominationCounter < 9) {
			for (int i = changeToReturn.length-1; i >= 0; i--) {
				double denominationToAdd = changeInRegister[i][0];
				double amountOfDenominationToAdd = amountToReturnFromDenomination(amountStillOwed, changeInRegister[i]);
				changeToReturn[i][0] = denominationToAdd;
				changeToReturn[i][1] = amountOfDenominationToAdd;
				amountStillOwed = (double)Math.round((amountStillOwed - amountOfDenominationToAdd) * 100) / 100;
				denominationCounter++;
			}
		}
		return changeToReturn;
	}
	
	private double amountToReturnFromDenomination(double amountStillOwed, double[] denominationInRegister) {
		double valueOfDenominationInRegister = denominationInRegister[1];
		double maxOfDenominationNeeded = ((int) (amountStillOwed/denominationInRegister[0])) * denominationInRegister[0];
		return Math.min(valueOfDenominationInRegister, maxOfDenominationNeeded); 
	}
	
	private boolean registerHasEnoughChange(double amountExpected, double[][] finalChange) {
		double totalChangeInRegister = 0;
		for (double[] denomination: finalChange) {
			double amountOfDenomination = denomination[1];
			totalChangeInRegister += amountOfDenomination;
		}
		return totalChangeInRegister >= amountExpected;
	}
	
	private boolean isRegisterClosed(double[][] finalChange, double[][] changeInRegister) {
		for (int i = 0; i < finalChange.length; i++) {
			if (finalChange[i][1] != changeInRegister[i][1]) {
				return false;
			}
		}
		return true;
	}
	
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