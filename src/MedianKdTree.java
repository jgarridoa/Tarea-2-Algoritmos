import java.util.ArrayList;

public class MedianKdTree extends KdTree {

	public MedianKdTree(Point p) {
		super(p);
	}

	public MedianKdTree(Point p, Boolean line) {
		super(p, line);
	}

	public MedianKdTree(Point p, Boolean line, KdTree izq, KdTree der) {
		super(p, line, izq, der);
	}

	@Override
	public KdTree construirKdtree(ArrayList<Point> P, splitaxis a) {
		if (P.size() == 1) {
			return new MedianKdTree(P.get(0));
		} else {
			// cosas
			return null;
		}
	}

	public static int QuickSelect(ArrayList<Point> P, int k, int first, int last) {
		if (first <= last) {
			int pivot = Select(P, first, last);
			if (pivot == k) {
				return k;
			}
			if (pivot > k) {
				return QuickSelect(P, first, pivot - 1, k);
			}
			return QuickSelect(P, pivot + 1, last, k);
		}
		return Integer.MIN_VALUE;

	}

	// Selección de la Mediana de las medianas.
	private static int Select(ArrayList<Point> P, int first, int last) {
		double dif = (double) (last - first);
		int numMedians = (int)Math.ceil(dif / 5);
		for (int i = 0; i < numMedians; i++) {
			int subLeft = first + i * 5;
			int subRight = first + (i+1)*5 -1;
			if (subRight > last)
				subRight = last;
			dif = (double) (subRight - subLeft);
			System.out.println((int)Math.ceil(dif / 2));
			int medianIx = QuickSelect(P, (int)Math.ceil(dif / 2), subLeft,
					subRight);
			
			Point aux = P.get(medianIx);
			P.set(medianIx, P.get(first + i));
			P.set(first + i, aux);
		}
		return QuickSelect(P, numMedians / 2, first, first + numMedians - 1);

	}
	
	public static void main(String[] args) {
		ArrayList<Point> P = new ArrayList<Point>(10);
		for(int i=0;i<10;i++){
			P.add(i,new Point(i+1,i+1));
		}
		/*P.set(4,new Point(7,7));
		P.set(3,new Point(2,2));
		P.set(6,new Point(4,4));
		P.set(7, new Point(9,9));
		P.set()*/
		System.out.println(P);
		int median = QuickSelect(P,5,0,9);
		
	}

}
