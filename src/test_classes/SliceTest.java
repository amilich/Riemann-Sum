package test_classes;

import polyfun.Polynomial;
import riemann_sum.*;

public class SliceTest 
{
	public static void main(String[] args) 
	{
		LeftHandRule LHR = new LeftHandRule();  //LeftHandRule extends Riemann
		RightHandRule RHR = new RightHandRule();  //RightHandRule extends Riemann
		TrapezoidRule TR= new TrapezoidRule(); //TrapezoidRule extends Riemann
	
		Polynomial p = new Polynomial(new double[] {0,4,0,3}); // p=3x^3+4x
		
		System.out.println(LHR.slice(p,1,1.1)+"\n"); //the area of a left hand rule slice of 3x^3+4x, from x=1 to x=1.1
		
		System.out.println(RHR.slice(p,1,1.1)+"\n"); //the area of a right hand rule slice of 3x^3+4x, from x=1 to x=1.1
		
		System.out.println(TR.slice(p,1,1.1)+"\n"); //the area of a trapezoid rule slice of 3x^3+4x, from x=1 to x=1.1
	}
}