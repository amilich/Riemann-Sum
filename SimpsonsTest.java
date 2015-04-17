package test_classes;

import java.awt.Color;

import org.opensourcephysics.frames.PlotFrame;

import polyfun.Polynomial;
import riemann_sum.*;

public class SimpsonsTest {

	/**
	 * This tests Simpsons rule graphing. 
	 * 
	 * @author Andrew
	 */
	public static void main(String[] args) {
		PlotFrame pframe = new PlotFrame("x", "y", "Poly graph"); 

		Polynomial p = new Polynomial(new double[] {0,-10, 0, 1}); //poly used to test
		SimpsonsRule SR = new SimpsonsRule(); //creates simpsons rule
		
		double min = -5; 
		double max = 5; 

		SR.rsPlot(pframe, p, 0, 0.1, min, max, 2); //plots simpsons rule
		pframe.setMarkerColor(2, Color.blue);
		pframe.setAutoscaleX(true); 
		pframe.setAutoscaleY(true); 
		pframe.setVisible(true); 
	}

}
