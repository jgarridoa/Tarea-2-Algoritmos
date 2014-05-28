import java.util.ArrayList;


public abstract class KdTree {
	
	protected Point p;
	protected KdTree izq;
	protected KdTree der;
	
	public KdTree(Point p){
		this.p = p;
		izq = null;
		der = null;
	}
	
	public KdTree(Point p, KdTree izq, KdTree der){
		this.p = p;
		this.izq = izq;
		this.der = der;
	}
	
	public abstract KdTree construirKdtree(ArrayList<Point> P, splitaxis a);

}
