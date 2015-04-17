package test_classes;

import polyfun.Polynomial;
import riemann_sum.PolyPractice;

public class EvalTest {

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		PolyPractice popeye = new PolyPractice(); 
		Polynomial poly = new Polynomial(new double[] {-6, -1}); 
		System.out.println(popeye.eval(poly,2.5)); //popeye evaluates poly at 2.5
	}
}