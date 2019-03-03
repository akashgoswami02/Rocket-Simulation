/* Akash Goswami
 * CMSC 455
 * HW 1
 * Rocket Science
 */

import java.util.*;
import java.io.*;

public class Akash_Goswami_HW1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		//rocket values
		double length = 0.311;
		double diameter = 0.0241;
		double bodyArea = 0.000506;
		double cdBody = 0.45;
		double finsArea = 0.00496;
		double cdFins = 0.01;
		double massWithoutEngine = 0.0340;
		double initialEngineMass = 0.0242;
		double finalEngineMass = 0.0094;
		
		double[] thrustValues = {6.0, 12.5, 5.5, 5.1, 5, 5, 5, 5, 4.8, 4.9, 4.7, 4.8, 4.8, 4.8, 4.6, 4.7, 4.8, 5};
		
		int thrust = 0;
		double rho = 1.293;
		double g = 9.80665;
		double dt = 0.1;
		
		//initial conditions
		double t = 0;
		double s = 0;
		double v = 0;
		double a = 0;
		double F = 0;
		double m = 0.0340 + 0.0242;
		
		//file io
		PrintWriter writer = new PrintWriter("output.txt");
		
		double Ft = 0;
		
		
		//loop until v is negative
		while (v >= 0) {
			
			//coded up equations
			double FdBody = (cdBody * rho * bodyArea * v * v) / 2.00;
			double FdFins = (cdFins * rho * finsArea * v * v) / 2.00;
			
			double Fg = m*g;
			
			Ft = 0;
			if (thrust < 18)
				Ft = thrustValues[thrust];
			thrust++;
			
			F = Ft - (FdBody + FdFins + Fg);
			
			a = F/m;
			
			double dv = a*dt;
			
			v = v+dv;
			
			double ds = v*dt;
			
			s = s+ds;
			
			m = m - 0.0001644 * Ft;
			
			t = t + dt;
			
			//prints out time, height, velocity, acceleration, force, and mass
			
			writer.println(t + " " + s + " " + v + " " + a + " " + F + " " + m);
			
		}
		
		writer.println("Time: "+ t +" Max Height: " + s);
		writer.close();
	}

}
