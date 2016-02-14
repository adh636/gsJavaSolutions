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
		// testing if any side is <= 0
		if (sideOne <= 0 || sideTwo <= 0 || sideThree <= 0) {
			return "Illegal";
		}
		
		// testing the Triangle Equality Theorem
		// (no side can be larger than the sum of the other 2 sides)
		else if (sideOne >= sideTwo + sideThree || 
				sideTwo >= sideOne + sideThree || 
				sideThree >= sideOne + sideTwo) {
			return "Illegal";
		}
		
		// testing if all sides are equal
		else if (sideOne == sideTwo && sideTwo == sideThree) {
			return "Equilateral";
		}
		
		// testing if only 2 sides are equal
		else if (sideOne == sideTwo || sideOne == sideThree || 
				sideTwo == sideThree) {
			return "Isosceles";
		}
		
		// if all other tests fail the triangle must be scalene
		else {
			return "Scalene";
		}
	}
}
