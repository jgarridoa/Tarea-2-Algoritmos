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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (isLine ? 1231 : 1237);
		long temp;
		temp = Double.doubleToLongBits(x);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(y);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Point other = (Point) obj;
		if (isLine != other.isLine)
			return false;
		if (Double.doubleToLongBits(x) != Double.doubleToLongBits(other.x))
			return false;
		if (Double.doubleToLongBits(y) != Double.doubleToLongBits(other.y))
			return false;
		return true;
	}

	public String toString() {
	 	return "Point(" + this.x + "," + this.y + ")";
	}

}
