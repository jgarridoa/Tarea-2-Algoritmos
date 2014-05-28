public class Point {
	protected double x;
	protected double y;
	

	public Point (double x, double y) {
			this.x = x;
			this.y = y;
	}
	
	public void moverHorizontal(double distance){
		x = x+ distance;
	}
	
	
	public double getX(){
		return x;
	}
	public double getY(){
		return y;
	}
	
	public String toString() {
	 	return "Point(" + this.x + "," + this.y + ")";
	}

}
