
public class TriangleTest {

	public static void main(String[] args) {
		Triangle one = new Triangle(2,2,2);
		Triangle two = new Triangle(1,2,3);
		Triangle three = new Triangle(.50, .75, .25);
		Triangle four = new Triangle(100, 200, 400);
		
		System.out.println(one.testTriangle());
		System.out.println(two.testTriangle());
		System.out.println(three.testTriangle());
		System.out.println(four.testTriangle());
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
		if (sideOne > sideTwo + sideThree || 
				sideTwo > sideOne + sideThree || 
				sideThree > sideOne + sideTwo) {
			return "Illegal";
		}
		else if (sideOne == sideTwo && sideTwo == sideThree) {
			return "Equilateral";
		}
		else if (sideOne == sideTwo || sideOne == sideThree || 
				sideTwo == sideThree) {
			return "Isosceles";
		}
		else {
			return "Scalene";
		}
	}
}
