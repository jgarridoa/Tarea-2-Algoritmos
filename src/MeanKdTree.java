import java.util.ArrayList;


public class MeanKdTree extends KdTree {

	public MeanKdTree(Point p) {
		super(p);
	}
	
	public MeanKdTree(Point p, Boolean line){
		super(p,line);
	}

	public MeanKdTree(Point p, Boolean line, KdTree izq, KdTree der) {
		super(p, line, izq, der);
	}

	@Override
	public KdTree construirKdtree(ArrayList<Point> P, splitaxis a) {
		
		if(P.size() == 1){
			return new MeanKdTree(P.get(0));
		}
		else{
			//cosas
			return null;
		}
	}

}
