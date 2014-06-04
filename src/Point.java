public class Point {
	protected double x;
	protected double y;
	protected boolean isLine;
	

	public Point (double x, double y) {
		this.x = x;
		this.y = y;
		this.isLine = false;
	}
	
	public Point (double x, double y, boolean isLine){
		this.x = x;
		this.y = y;
		this.isLine = isLine;	
	}
	
	public void moverHorizontal(double distance){
		x = x + distance;
	}
	
	
	public double getX(){
		return x;
	}
	public double getY(){
		return y;
	}
	
	public boolean isLine(){
		return isLine;
	}
	
	public String toString() {
	 	return "Point(" + this.x + "," + this.y + ")";
	}

}
