import static org.junit.Assert.*;

import org.junit.Test;

public class ExactChangeTester {
	double[][] changeForRegister = {{.01, 1.01},{.05, 2.05},{.1, 3.1},{.25, 4.25},
			{1.0, 90.0},{5.0, 55.0},{10.0, 20.0},{20.0, 60.0},{100.0, 100.0}};
	CashRegister register = new CashRegister();
	

	@Test
	public void canCreateCashRegister() {
		CashRegister c = new CashRegister();
		assertNotNull(c);
	}
	
	/*
	@Test
	public void canGetChangeInRegister() {
		assertEquals(register.getChangeInRegister(), changeForRegister);
	}
	*/
	
	/*
	@Test
	public void canReturnChangeInRegister() {
		double oneHundred = 100;
		double quarter = .25;
		double penny = .01;
		assertEquals(register.returnChangeArray(0, oneHundred), new double[][]{{.01, 0},{.05, 0},
			{.1, 0},{.25, 0},{1.0, 0},{5.0, 0},{10.0, 0},{20.0, 0},{100.0, 100.0}});
		assertEquals(register.returnChangeArray(0, quarter), new double[][]{{.01, 0},{.05, 0},
			{.1, 0},{.25, .25},{1.0, 0},{5.0, 0},{10.0, 0},{20.0, 0},{100.0, 0}});
		assertEquals(register.returnChangeArray(0, penny), new double[][]{{.01, .01},{.05, 0},
			{.1, 0},{.25, 0},{1.0, 0},{5.0, 0},{10.0, 0},{20.0, 0},{100.0, 0}});
	}
	*/
	
	/*
	@Test
	public void canGetStringRepresentationOfDenominations() {
		double oneHundred = 100.0;
		double quarter = .25;
		double penny = .01;
		assertEquals(register.stringDenomination(oneHundred), "ONE HUNDRED");
		assertEquals(register.stringDenomination(quarter), "QUARTER");
		assertEquals(register.stringDenomination(penny), "PENNY");
	}
	*/
	
	@Test
	public void canReturnStringRepresentationOfChangeDue() {
		assertEquals(register.checkCashRegister(100, 200, changeForRegister), "[[ONE HUNDRED, 100.0]]");
		assertEquals(register.checkCashRegister(15.50, 16, changeForRegister), "[[QUARTER, 0.5]]");
		assertEquals(register.checkCashRegister(9.99, 10, changeForRegister), "[[PENNY, 0.01]]");
		assertEquals(register.checkCashRegister(0, 96.74, changeForRegister), "[[TWENTY, 60.0][TEN, 20.0]"
				+ "[FIVE, 15.0][ONE, 1.0][QUARTER, 0.5][DIME, 0.2][PENNY, 0.04]]");
	}
	
	@Test
	public void notEnoughInRegister() {
		assertEquals(register.checkCashRegister(0, 1000, changeForRegister), "Insufficient Funds");
	}
	
	@Test
	public void insufficientDenominations() {
		double[][] onlyTwentiesInRegister = new double[][]{{.01, 0},{.05, 0},
			{.1, 0},{.25, 0},{1.0, 0},{5.0, 0},{10.0, 0},{20.0, 40.0},{100.0, 0}};
		assertEquals(register.checkCashRegister(5, 10, onlyTwentiesInRegister),"Insufficient Funds");
	}
	
	@Test
	public void emptyRegister() {
		double[][] emptyRegister = new double[][]{{.01, 0},{.05, 0},
			{.1, 0},{.25, 0},{1.0, 0},{5.0, 0},{10.0, 0},{20.0, 0},{100.0, 0}};
		assertEquals(register.checkCashRegister(5, 10, emptyRegister),"Insufficient Funds");
	}
	
	@Test
	public void exactChangeInRegister() {
		double[][] registerWithOneHundred = new double[][]{{.01, 0},{.05, 0},
			{.1, 0},{.25, 0},{1.0, 0},{5.0, 0},{10.0, 0},{20.0, 0},{100.0, 100.0}};
		assertEquals(register.checkCashRegister(0, 100, registerWithOneHundred), "Closed");
	}
	
	@Test
	public void exactChangeEmptyRegister() {
		double[][] emptyRegister = new double[][]{{.01, 0},{.05, 0},
			{.1, 0},{.25, 0},{1.0, 0},{5.0, 0},{10.0, 0},{20.0, 0},{100.0, 0}};
		assertEquals(register.checkCashRegister(100, 100, emptyRegister), "Closed");
	}
	
	@Test
	public void noChangeNeeded() {
		assertEquals(register.checkCashRegister(100, 100, changeForRegister), "[]");
	}
	
	@Test
	public void freeCodeCampTestOne() {
		double testPrice = 19.50;
		double testCash = 20.00;
		assertEquals(register.checkCashRegister(testPrice, testCash, changeForRegister), "[[QUARTER, 0.5]]");
	}
	
	@Test
	public void freeCodeCampTestTwo() {
		double testPrice = 3.26;
		double testCash = 100.00;
		assertEquals(register.checkCashRegister(testPrice, testCash, changeForRegister), "[[TWENTY, 60.0][TEN, 20.0]"
						+ "[FIVE, 15.0][ONE, 1.0][QUARTER, 0.5][DIME, 0.2][PENNY, 0.04]]");
	}
	
	@Test
	public void freeCodeCampTestThree() {
		double[][] registerWithOnePenny = new double[][]{{.01, .01},{.05, 0},
			{.1, 0},{.25, 0},{1.0, 0},{5.0, 0},{10.0, 0},{20.0, 0},{100.0, 0}};
		double testPrice = 19.50;
		double testCash = 20.00;
		assertEquals(register.checkCashRegister(testPrice, testCash, registerWithOnePenny), "Insufficient Funds");
	}
	
	@Test
	public void freeCodeCampTestFour() {
		double[][] registerWithOnePenny = new double[][]{{.01, .01},{.05, 0},
			{.1, 0},{.25, 0},{1.0, 0},{5.0, 0},{10.0, 0},{20.0, 0},{100.0, 0}};
		double testPrice = 19.50;
		double testCash = 20.00;
		assertEquals(register.checkCashRegister(testPrice, testCash, registerWithOnePenny), "Insufficient Funds");
	}
	
	@Test
	public void freeCodeCampTestFive() {
		double[][] registerWithFiftyCents = new double[][]{{.01, .50},{.05, 0},
			{.1, 0},{.25, 0},{1.0, 0},{5.0, 0},{10.0, 0},{20.0, 0},{100.0, 0}};
		double testPrice = 19.50;
		double testCash = 20.00;
		assertEquals(register.checkCashRegister(testPrice, testCash, registerWithFiftyCents), "Closed");
	}
}