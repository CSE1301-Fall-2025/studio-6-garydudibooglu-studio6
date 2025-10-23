package studio6;

import edu.princeton.cs.introcs.StdDraw;

public class RecursiveMethods {
	public static void main(String[] args) {
		System.out.println(geometricSum(5));
		int[] testArray = {1,2,3,4,5,6};
		for(int x: toReversed(testArray)){
		System.out.println(x); 
		} 
		System.out.println(gcd(18, 24));
	}
	/**
	 * Computes the geometric sum for the first n terms in the series
	 * 
	 * @param n the number of terms to include in the sum
	 * @return the sum of the first n terms of the geometric series (1/2 + 1/4 + 1/8
	 *         ...)
	 */
	static double sum = 0;
	public static double geometricSum(int n) {
		if(n>0){
			sum += (1.0/Math.pow(2, n));
			return geometricSum(n-1);
		} else {
			return sum;
	}
	}
	
	/**
	 * @param xCenter                       x-coordinate of the center of the circle
	 *                                      at the current depth
	 * @param yCenter                       y-coordinate of the center of the circle
	 *                                      at the current depth
	 * @param radius                        radius of the circle at the current
	 *                                      depth
	 * @param radiusMinimumDrawingThreshold radius above which drawing should occur
	 */
	public static void circlesUponCircles(double xCenter, double yCenter, double radius, double radiusMinimumDrawingThreshold) {
		double scalar = 1.0/3.0;
		StdDraw.circle(xCenter, yCenter, radius);
		if (radius - radius*scalar > radiusMinimumDrawingThreshold){
			circlesUponCircles(xCenter + radius, yCenter, radius*scalar, radiusMinimumDrawingThreshold);
			circlesUponCircles(xCenter - radius, yCenter, radius*scalar, radiusMinimumDrawingThreshold);
			circlesUponCircles(xCenter, yCenter + radius, radius*scalar, radiusMinimumDrawingThreshold);
			circlesUponCircles(xCenter, yCenter - radius, radius*scalar, radiusMinimumDrawingThreshold);
		}
		// FIXME complete the recursive drawing
	}

	/**
	 * This method uses recursion to create a reverse of the given array
	 * 
	 * @param array the array to create a reverse of, not to be mutated
	 * @return an array with the same data as the input but it reverse order
	 */
	/*public static int[] getReversedArray(int[] arr, int cnt){
		if(cnt < arr.length/2) {
			int temp = arr[cnt];
			arr[cnt] = arr[arr.length - cnt - 1];
			arr[arr.length - cnt - 1] = temp;
			return getReversedArray(arr, cnt+1);
		} else {
			return arr;
		}
	}
	*/
	public static int[] getReversedArray(int[] arr1, int[] arr2, int cnt){
		if(cnt < arr1.length){
			arr1[cnt] = arr2[arr2.length - cnt - 1];
			return getReversedArray(arr1, arr2, cnt+1);
		} else {
			return arr1;
		}
	}
	public static int[] toReversed(int[] array) {
		// note to friends, make sure you intialize a new array instead of setting int[] newArray = array; I spent three hours mulling over my logic
		int[] modifiedArray = new int[array.length];
		int cnt = 0;
		getReversedArray(modifiedArray, array, cnt);
			// FIXME create a helper method that can recursively reverse the given array
			return modifiedArray;
	}

	/**
	 * This method uses recursion to compute the greatest common divisor
	 * for the two input values
	 * 
	 * @param p first operand
	 * @param q second operand
	 * @return greatest common divisor of p and q
	 */
	public static int gcd(int p, int q) {
			//copied the while loop, while loops and recursion are very similar
			if (q != 0){ 
				int temp = q;
				q = p % q;
				p = temp;
				return gcd(p, q);
			} else {
				return p;
			}
			// FIXME compute the gcd of p and q using recursion
		
	}


}