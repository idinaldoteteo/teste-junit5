package io.javabrains;

public class MathUtils {
	
	public int add(int a , int b) {
		return a + b;
	}
	
	public double calculateRadiusArea(double radius) {
		return Math.PI * Math.pow(radius, 2);
	}

	public int subtract(int a, int b) {
		return a - b;
	}

	public int divide(int a, int b) {
		if( b == 0 )
			throw new IllegalArgumentException();
		return a / b;
	}

}
