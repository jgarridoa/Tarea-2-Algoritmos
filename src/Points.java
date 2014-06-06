import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.apache.commons.math3.random.SobolSequenceGenerator;


public class Points {	
	private double[] listX;
	private double[] listY;
	private int n;
	
	public Points(double[] listX, double[] listY){
		this.listX = listX;
		this.listY = listY;
		this.n = listX.length;
	}
	
	public Points(int n){
		this.listX = new double[n];
		this.listY = new double[n];
		this.n=n;
	}
	
	public Point getPoint(int n){
		return new Point(listX[n], listY[n]);
	}

	public double[] getListX(){
		return listX;
	}
	
	public double[]getListY(){
		return listY;
	}
	
	public int size(){
		return listX.length;
	}
	
	public void addPoint(int index, int x, int y){
		listX[index] = x;
		listY[index] = y;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(listX);
		result = prime * result + Arrays.hashCode(listY);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Points other = (Points) obj;
		if (!Arrays.equals(listX, other.listX))
			return false;
		if (!Arrays.equals(listY, other.listY))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Points [listX=" + Arrays.toString(listX) + ", listY="
				+ Arrays.toString(listY) + "]";
	}
	
		public void generateRandomPoints(){
			Random r = new Random();
			double c = 0.7;
			for (int i = 0; i < this.n; i++) {
				listX[i] =(c*Math.sqrt(n)) * r.nextDouble();
				listY[i] =(c*Math.sqrt(n)) * r.nextDouble();
			}
		}
		
		public void generateLowDiscrepancyPoints(){
			SobolSequenceGenerator gen = new SobolSequenceGenerator(2);
			for(int i=0; i< this.n; i++){
				double[] aux = gen.nextVector();
				listX[i]=aux[0];
				listY[i]=aux[1];
			}
		}
}
