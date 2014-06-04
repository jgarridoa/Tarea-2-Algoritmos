import java.util.ArrayList;


public abstract class KdTree {
	
	protected Point p;
	protected Boolean isLine;
	protected KdTree izq;
	protected KdTree der;
	
	public KdTree(Point p){
		this.p = p;
		this.isLine = false;
		izq = null;
		der = null;
	}
	
	public KdTree(Point p, Boolean line){
		this.p = p;
		this.isLine = line;
	}
	
	public KdTree(Point p, Boolean line, KdTree izq, KdTree der){
		this.p = p;
		this.isLine = line;
		this.izq = izq;
		this.der = der;
	}
	
	public boolean isLine(){
		return this.isLine;
	}
	
	public abstract KdTree construirKdtree(ArrayList<Point> P, splitaxis a);
	
	public Point getPoint(){
		return this.p;
	}

}
