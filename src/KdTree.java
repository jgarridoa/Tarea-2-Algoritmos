
public class KdTree {
	
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
	
	public boolean isLine(){
		return p.isLine();
	}
	
	public Point getPoint(){
		return this.p;
	}

	public int getSize(){
		if(p.isLine){
			return 1 + this.izq.getSize() + this.der.getSize();
		}
		else{
			return 1;
		}
	}
	
	public int getHeight(){
		if(p.isLine){
			return 1 + Math.max(this.izq.getHeight(),this.der.getHeight()); 
		}
		else{
			return 1;
		}
	}
}
