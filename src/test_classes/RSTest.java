package test_classes;

import polyfun.Polynomial;
import riemann_sum.*;

public class RSTest 
{
	public static void main(String[] args) 
	{
		//Evaluates each Riemann Sum
		
		LeftHandRule LHR = new LeftHandRule();  //LeftHandRule extends Riemann
		RightHandRule RHR = new RightHandRule();  //RightHandRule extends Riemann
		SimpsonsRule SR = new SimpsonsRule(); //Simpsons Rule approximates area using parabolas over each interval
		TrapezoidRule TR = new TrapezoidRule(); //TrapezoidRule extends Riemann
		MidpointRule MR = new MidpointRule(); //Midpoint Rule extends Riemann
		RandomRule RR = new RandomRule(); //Random Rule - random float chosen for rule - 5/7, 3/4, etc. 
		MinimumRule MinR = new MinimumRule(); //Maximum value in each subinterval 
		MaximumRule MaxR = new MaximumRule(); //Minimum value in each subinterval 

		Polynomial p = new Polynomial(new double[] {0, 0, 3}); //makes polynomial to use for riemann sum (right now 3x^2) 
		double min = -10; //minimum value of the Riemann sum - left endpoint
		double max = 15; //maximum value of the Riemann sum - right endpoint 
		int calcRects = 200; //number of rectangles to count with (different from # used to plot)
		
		//these calculate the Riemann sums
		double leftRule = LHR.rs(p, min, max, calcRects); //the approximate area using the left hand rule
		double rightRule = RHR.rs(p, min, max, calcRects); //the approximate area using the right hand rule
		double trapRule = TR.rs(p, min, max, calcRects); //the approximate area using the trapezoid rule
		double midRule = MR.rs(p, min, max, calcRects); //approximate area of function using midpoint rule
		double simpRule = SR.rs(p, min, max, calcRects); //approximate area using simpson's rule
		double randRule = RR.rs(p, min, max, calcRects); //approximate using random rule 
		double minRule = MinR.rs(p, min, max, calcRects); ///approximate using min rule  
		double maxRule = MaxR.rs(p, min, max, calcRects); //approximate using max rule 
		
		System.out.println("LHR Value: " + leftRule);
		System.out.println("RHR Value: " + rightRule);
		System.out.println("Trapezoid Value: " + trapRule);
		System.out.println("Midpoint Value: " + midRule);
		System.out.println("Simpsons Value: " + simpRule);
		System.out.println("Random Value: " + randRule);
		System.out.println("Minimum Value: " + minRule);
		System.out.println("Maximum Value: " + maxRule);
	}
}
