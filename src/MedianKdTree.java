import java.util.ArrayList;


public class MedianKdTree extends KdTree {

	public MedianKdTree(Point p) {
		super(p);
	}

	public MedianKdTree(Point p, KdTree izq, KdTree der) {
		super(p, izq, der);
	}

	@Override
	public KdTree construirKdtree(ArrayList<Point> P, splitaxis a) {
		if(P.size() == 1){
			return new MedianKdTree(P.get(0));
		}
		else{
			//cosas
			return null;
		}
	}

}
