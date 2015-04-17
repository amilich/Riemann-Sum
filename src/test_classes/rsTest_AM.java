package test_classes;

import java.awt.Color;
import javax.swing.JFrame;

import riemann_sum.*;
import polyfun.Polynomial;

import org.opensourcephysics.frames.*;

/**
 * My test class - graphs accumulation functions, functions, and Riemann sums 
 * Accumulation functions are plotted in blue
 * 
 * @author Andrew
 */

public class rsTest_AM {
	public static void main(String[] args) {
		LeftHandRule LHR = new LeftHandRule();  //LeftHandRule extends Riemann
		RightHandRule RHR = new RightHandRule();  //RightHandRule extends Riemann
		SimpsonsRule SR = new SimpsonsRule(); //Simpsons Rule approximates area using parabolas over each interval
		TrapezoidRule TR = new TrapezoidRule(); //TrapezoidRule extends Riemann
		MidpointRule MR = new MidpointRule(); //Midpoint Rule extends Riemann
		RandomRule RR = new RandomRule(); //Random Rule - random float chosen for rule - 5/7, 3/4, etc. 
		MinimumRule MinR = new MinimumRule(); //Maximum value in each subinterval 
		MaximumRule MaxR = new MaximumRule(); //Minimum value in each subinterval 

		Polynomial p = new Polynomial(new double[] {0, 0, -10, 1}); //makes polynomial to use for riemann sum

		double min = -10; //minimum value of the Riemann sum, 
		double max = 15; //maximum value of the Riemann sum
		int xStart = 100; //starting x position for windows
		int yStart = 50; //starting y position for windows

		int calcRects = 500; //number of rectangles to count with (different from # used to plot)

		//these calculate the Riemann sums
		double leftRule = LHR.rs(p, min, max, calcRects); //the approximate area using the left hand rule
		double rightRule = RHR.rs(p, min, max, calcRects); //the approximate area using the right hand rule
		double trapRule = TR.rs(p, min, max, calcRects); //the approximate area using the trapezoid rule
		double midRule = MR.rs(p, min, max, calcRects); //approximate area of function using midpoint rule
		double simpRule = SR.rs(p, min, max, calcRects); //approximate area using simpson's rule
		double randRule = RR.rs(p, min, max, calcRects); //approximate using random rule 
		double minRule = MinR.rs(p, min, max, calcRects); ///approximate using min rule  
		double maxRule = MaxR.rs(p, min, max, calcRects); //approximate using max rule  

		//each plotframe contains an individual Riemann sum 
		PlotFrame f = new PlotFrame("x","y","Left Hand Riemann Sum Graph"); //LHR sum 
		f.setLocation(xStart, yStart); //position window 
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //makes the program exit when a window is closed 
		f.setVisible(true); //sets it to visible
		f.setMarkerColor(0, Color.black); //sets marker colors to black to plot the ploy
		f.setAutoscaleX(true); //autoscales the graph on the x axis 
		f.setAutoscaleY(true); //autoscales the y axis 
		f.setXLabel("Integral value: " + leftRule); //shows the value of the Riemann sum on the graph as a label

		PlotFrame g = new PlotFrame("x","y","Right Hand Riemann Sum Graph"); //see above; uses LHR
		g.setLocation(xStart + 300, yStart); 
		g.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 	
		g.setVisible(true);
		g.setMarkerColor(0, Color.black);
		g.setAutoscaleX(true);
		g.setAutoscaleY(true);
		g.setXLabel("Integral value: " + rightRule); 

		PlotFrame r = new PlotFrame("x","y","Simpsons Rule Riemann Sum Graph"); //see above, uses Simpsons Rule
		r.setLocation(xStart + 600, yStart); 
		r.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 	
		r.setMarkerColor(0, Color.black);
		r.setVisible(true);
		r.setAutoscaleX(true);
		r.setAutoscaleY(true);
		r.setXLabel("Integral value: " + simpRule); 

		PlotFrame m = new PlotFrame("x","y","Midpoint Rule Riemann Sum Graph"); //see above, Midpoint rule
		m.setLocation(xStart + 900, yStart); 
		m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 	
		m.setMarkerColor(0, Color.black);
		m.setVisible(true);
		m.setAutoscaleX(true);
		m.setAutoscaleY(true);
		m.setXLabel("Integral value: " + midRule); 

		PlotFrame t = new PlotFrame("x", "y", "Trapezoid Rule Riemann Sum Graph"); //see above, Trapezoid rule
		t.setLocation(xStart, yStart + 350); 
		t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 	
		t.setMarkerColor(0, Color.black); 
		t.setVisible(true); 
		t.setAutoscaleX(true);
		t.setAutoscaleY(true);
		t.setXLabel("Integral value: " + trapRule); 

		PlotFrame rand = new PlotFrame("x", "y", "Random Rule Riemann Sum Graph"); //see above, Random rule
		rand.setLocation(xStart + 300, yStart + 350); 
		rand.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 	
		rand.setMarkerColor(0, Color.black); 
		rand.setVisible(true); 
		rand.setAutoscaleX(true);
		rand.setAutoscaleY(true);
		rand.setXLabel("Integral value: " + randRule); 

		PlotFrame minR = new PlotFrame("x", "y", "Minimum Rule Riemann Sum Graph"); //see above, Minimum rule
		minR.setLocation(xStart + 600, yStart + 350); 
		minR.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 	
		minR.setMarkerColor(0, Color.black); 
		minR.setVisible(true); 
		minR.setAutoscaleX(true);
		minR.setAutoscaleY(true);
		minR.setXLabel("Integral value: " + minRule); 

		PlotFrame maxR = new PlotFrame("x", "y", "Maximum Rule Riemann Sum Graph"); //see above, Maximum rule
		maxR.setLocation(xStart + 900, yStart + 350); 
		maxR.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 	
		maxR.setMarkerColor(0, Color.black); 
		maxR.setVisible(true); 
		maxR.setAutoscaleX(true);
		maxR.setAutoscaleY(true);
		maxR.setXLabel("Integral value: " + maxRule); 

		//plots Riemann sum accumulation functions
		//BASE of Accumulation function defined as average of min and max, but this can be changed 
		LHR.rsAcc(f, p, 1, 0.1, (min+max)/2); //base is the last parameter of this function
		RHR.rsAcc(g, p, 1, 0.1, (min+max)/2); 
		SR.rsAcc(r, p, 1, 0.1, (min+max)/2); 
		MR.rsAcc(m, p, 1, 0.1, (min+max)/2); 
		TR.rsAcc(t, p, 1, 0.1, (min+max)/2); 
		RR.rsAcc(rand, p, 1, 0.1, (min+max)/2); 
		MinR.rsAcc(minR, p, 1, 0.1, (min+max)/2); 
		MaxR.rsAcc(maxR, p, 1, 0.1, (min+max)/2); 

		//plots Riemann sums
		int rectNum = 50; //this is the # of rectangles used to plot - should not be same as # used to calculate because when you plot too many rectangles
		//the window slows down (and the rectangles are too small to see) 
		LHR.rsPlot(f, p, 55, 0.01, min, max, rectNum); 
		RHR.rsPlot(g, p, 55, 0.01, min, max, rectNum); 
		SR.rsPlot(r, p, 55, 0.01, min, max, 5); 
		MR.rsPlot(m, p, 55, 0.01, min, max, rectNum); 
		TR.rsPlot(t, p, 55, 0.01, min, max, 10); 
		RR.rsPlot(rand, p, 55, 0.01, min, max, rectNum); 
		MinR.rsPlot(minR, p, 55, 0.01, min, max, rectNum);
		MaxR.rsPlot(maxR, p, 55, 0.01, min, max, rectNum);
	}
}	