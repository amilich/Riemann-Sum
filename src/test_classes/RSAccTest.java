package test_classes;

import riemann_sum.*;
import polyfun.Polynomial;
import org.opensourcephysics.frames.*;

public class RSAccTest 
{
	public static void main(String[] args) 
	{
		LeftHandRule LHR = new LeftHandRule();  //LeftHandRule extends Riemann
		RightHandRule RHR = new RightHandRule();  //RightHandRule extends Riemann
		TrapezoidRule TR= new TrapezoidRule(); //TrapezoidRule extends Riemann
			
		Polynomial p = new Polynomial(new double[] {0,1,1}); // p=x^2+x
	
		PlotFrame f = new PlotFrame("x","y","Left Hand Rule Accumulation Function Graph");
		f.setPreferredMinMaxX(-3, 3);
		f.setDefaultCloseOperation(3);
		f.setVisible(true);
			
		PlotFrame g = new PlotFrame("x","y","Right Hand Rule Accumulation Function Graph");
		g.setPreferredMinMaxX(-3, 3);
		g.setDefaultCloseOperation(3);
		g.setVisible(true);
			
		PlotFrame i = new PlotFrame("x","y","Trapezoid Rule Accumulation Function Graph");
		i.setPreferredMinMaxX(-3, 3);
		i.setDefaultCloseOperation(3);			
		i.setVisible(true);
			
		LHR.rsAcc(f, p, 2, .01, -1.0); //plots the left hand rule acccumulation function of x^2+x, with base x=-1;
			
		RHR.rsAcc(g, p, 2, .01, -1.0); //plots the right hand rule acccumulation function of x^2+x, with base x=-1;
			
		TR.rsAcc(i, p, 2, .01, -1.0); //plots the trapezoid rule acccumulation function of x^2+x, with base x=-1;	
	}
}	