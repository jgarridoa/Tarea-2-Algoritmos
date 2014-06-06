
import java.util.Random;
import static org.junit.Assert.*;
import org.junit.Test;

public class Tests {

	private static double distancia(Point p, Point q) {
		return Math.sqrt(Math.pow((q.getX() - p.getX()), 2)
				+ Math.pow((q.getY() - p.getY()), 2));
	}
	
	public static Point buscarVecinoSimple(Points points, Point q){
		double mejorDistancia = Double.MAX_VALUE;
		Point mejorPunto = null;
		for (int i = 0; i < points.size(); i++){
			Point p = points.getPoint(i);
			double dist = distancia(p ,q);
			if ( dist < mejorDistancia){
				mejorDistancia = dist;
				mejorPunto = p;
			}
		}
		return mejorPunto;
	}
	
	public static Points generarPuntos(int n){
		Points points  = new Points(n);
		Random rdm = new Random();
		for(int i = 0; i < n; i++){
			points.addPoint(i, rdm.nextInt(101), rdm.nextInt(101));		
		}
		return points;		
	}
	
	
//	@Test
//	public void testPlas(){
//		int[] listX = new int[] {29, 93, 53, 6, 50, 97, 61, 6, 85, 50};
//		int[] listY = new int[] {28, 21, 75, 59, 21, 28, 18, 59, 3, 68};
//		Points points = new Points(listX, listY);
//		KdTree tree = MeanKdTree.construirKdTree(points, Splitaxis.getSplitX());
//	}
	
//	@Test
//	public void testMean(){		 
//		Random rdm = new Random();
//		for (int i= 1; i< 100; i++){
//			System.out.println(i);
//			Points points = generarPuntos(10*i);
//			//System.out.println(points);
//			Point p = new Point(rdm.nextInt(100),rdm.nextInt(100));
//			System.out.println("Search: " + p.toString());
//			KdTree tree = MeanKdTree.construirKdTree(points, Splitaxis.getSplitX());
//			Vecino vecino = new Vecino();
//			Point expected = buscarVecinoSimple(points, p);
//			Point actual = vecino.masCercano(tree, p);
//			System.out.println("Expected: " + expected.toString());
//			System.out.println("Actual: " + actual.toString());
//			assertEquals(distancia(expected, p), distancia(actual, p), 0.03);
//		}
//	}
	
	@Test
	public void testMedian(){		 
		Random rdm = new Random();
		for (int i= 1; i< 100; i++){
			System.out.println(i);
			Points points = generarPuntos(10*i);
			//System.out.println(points);
			Point p = new Point(rdm.nextInt(100),rdm.nextInt(100));
			System.out.println("Search: " + p.toString());
			KdTree tree = MedianKdTree.construirKdTree(points, Splitaxis.getSplitX());
			Vecino vecino = new Vecino();
			Point expected = buscarVecinoSimple(points, p);
			Point actual = vecino.masCercano(tree, p);
			System.out.println("Expected: " + expected.toString());
			System.out.println("Actual: " + actual.toString());
			assertEquals(distancia(expected, p), distancia(actual, p), 0.03);
		}
	}
}
