package test_classes;

import java.awt.Color;
import javax.swing.JFrame;

import riemann_sum.*;
import polyfun.Polynomial;

import org.opensourcephysics.frames.*;

public class RSPlotTest {
	
	//Plots all Riemann sums 
	
	public static void main(String[] args) {
		LeftHandRule LHR = new LeftHandRule();  //LeftHandRule extends Riemann
		RightHandRule RHR = new RightHandRule();  //RightHandRule extends Riemann
		SimpsonsRule SR = new SimpsonsRule(); //Simpsons Rule approximates area using parabolas over each interval
		TrapezoidRule TR = new TrapezoidRule(); //TrapezoidRule extends Riemann
		MidpointRule MR = new MidpointRule(); //Midpoint Rule extends Riemann
		RandomRule RR = new RandomRule(); //Random Rule - random float chosen for rule - 5/7, 3/4, etc. 
		MinimumRule MinR = new MinimumRule(); //Maximum value in each subinterval 
		MaximumRule MaxR = new MaximumRule(); //Minimum value in each subinterval 

		Polynomial p = new Polynomial(new double[] {0, 0, 3}); //f(x) = x^2  

		int min = -1; //minimum value of the Riemann sum
		int max = 5; //maximum value of the Riemann sum
		int xStart = 100; //starting x position for windows
		int yStart = 50; //starting y position for windows

		//these calculate the Riemann sums
		double leftRule = LHR.rs(p, min, max, 2000); //the approximate area under 3x^2, from 0 to 1, using the left hand rule
		double rightRule = RHR.rs(p, min, max, 2000); //the approximate area under 3x^2, from 0 to 1, using the right hand rule
		double trapRule = TR.rs(p, min, max, 2000); //the approximate area under 3x^2, from 0 to 1, using the trapezoid rule
		double midRule = MR.rs(p, min, max, 2000); //approximate area of function using midpoint rule
		double simpRule = SR.rs(p, min, max, 2000); //approximate area using simpson's rule
		double randRule = RR.rs(p, min, max, 2000); //approximate using random rule and 90,000 rectangles 
		double minRule = MinR.rs(p, min, max, 2000); ///approximate using min rule and 90,000 rectangles 
		double maxRule = MaxR.rs(p, min, max, 2000); //approximate using max rule with 90,000 rectangles 

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

		//plots Riemann sums 
		int rectNum = 80; 
		LHR.rsPlot(f, p, 1, 0.001, min, max, rectNum); 
		RHR.rsPlot(g, p, 1, 0.001, min, max, rectNum); 
		SR.rsPlot(r, p, 1, 0.001, min, max, 2); 
		MR.rsPlot(m, p, 1, 0.001, min, max, rectNum); 
		TR.rsPlot(t, p, 1, 0.001, min, max, 10); 
		RR.rsPlot(rand, p, 1, 0.001, min, max, rectNum); 
		MinR.rsPlot(minR, p, 1, 0.001, min, max, rectNum);
		MaxR.rsPlot(maxR, p, 1, 0.001, min, max, rectNum);
		//practice.graphPoly(m, p, min, max, 0.01, 0); 

		System.out.println(minRule);
	}

}	