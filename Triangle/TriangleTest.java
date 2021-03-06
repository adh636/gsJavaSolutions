public class TriangleTest {

	public static void main(String[] args) {
		Triangle one = new Triangle(2, 2, 2);
		Triangle two = new Triangle(2, 3, 4);
		Triangle three = new Triangle(.50, .75, .50);
		Triangle four = new Triangle(100, 200, 400);
		Triangle five = new Triangle(0, 0, 0);
		Triangle six = new Triangle(-1, 1, 2);
		Triangle seven = new Triangle(2, 4, 2);
		
		System.out.println(one.testTriangle()); // should print "Equilateral"
		System.out.println(two.testTriangle()); // should print "Scalene"
		System.out.println(three.testTriangle()); // should print "Isosceles"
		System.out.println(four.testTriangle()); // should print "Illegal"
		System.out.println(five.testTriangle()); // should print "Illegal"
		System.out.println(six.testTriangle()); // should print "Illegal"
		System.out.println(seven.testTriangle()); // should print "Illegal"
	}
}

class Triangle {
	double sideOne;
	double sideTwo;
	double sideThree;
	
	Triangle(double sideOne, double sideTwo, double sideThree) {
		this.sideOne = sideOne;
		this.sideTwo = sideTwo;
		this.sideThree = sideThree;
	}
	
	public String testTriangle() {
		
		if (!isTriangle()) {
			return "Illegal";
		}
		
		else if (isEquilateral()) {
			return "Equilateral";
		}
		
		else if (isIsosceles()) {
			return "Isosceles";
		}
		
		
		else {
			return "Scalene";
		}
	}
	
	public boolean isTriangle() {	
		// testing if any side is <= 0
		if (sideOne <= 0 || sideTwo <= 0 || sideThree <= 0) {
			return false;
		}		
		// testing the Triangle Equality Theorem 
		else if (sideOne >= sideTwo + sideThree || 
				sideTwo >= sideOne + sideThree || 
				sideThree >= sideOne + sideTwo) {
			return false;
		}
		return true;
	}
	
	public boolean isEquilateral() {
		if (isTriangle()) {
			// testing if all sides are equal
			if (sideOne == sideTwo && sideTwo == sideThree) {
				return true;
			}
		}	
		return false;
	}
	
	public boolean isIsosceles() {
		if (isTriangle()) {
			// testing if only 2 sides are equal
			if (sideOne == sideTwo || sideOne == sideThree || 
					sideTwo == sideThree) {
				return true;
			}
		}
		return false;
	}
	
	public boolean isScalene() {
		if (isTriangle()) {
			// testing if all sides are different lengths
			if (sideOne != sideTwo && sideTwo != sideThree) {
				return true;
			}
		}
		return false;
	}
}