package test_classes;

import polyfun.Polynomial;
import org.opensourcephysics.frames.*;
import riemann_sum.*;

//default slice plot test

public class SlicePlotTest 
{
	public static void main(String[] args) 
	{
		LeftHandRule LHR = new LeftHandRule();  //LeftHandRule extends Riemann
		RightHandRule RHR = new RightHandRule();  //RightHandRule extends Riemann

		Polynomial p = new Polynomial(new double[] {0,4,0,3}); // p=3x^3+4x

		PlotFrame f = new PlotFrame("x","y","Left Hand Slice");
		f.setPreferredMinMaxX(.5, 1.5);
		f.setDefaultCloseOperation(3);			
		f.setVisible(true);

		PlotFrame g = new PlotFrame("x","y","Right Hand Rule Slice");			
		g.setPreferredMinMaxX(.5,1.5);
		g.setDefaultCloseOperation(3);
		g.setVisible(true);

		LHR.slicePlot(f, p, 1, 1.1); //a left hand rule slice of 3x^3+4x, from x=1 to x=1.1

		RHR.slicePlot(g, p, 1, 1.1); //a right hand rule slice of 3x^3+4x, from x=1 to x=1.1*/
	}
}