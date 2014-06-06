import java.util.Arrays;
import java.util.List;


public class Points {	
	private int[] listX;
	private int[] listY;
	
	public Points(int[] listX, int[] listY){
		this.listX = listX;
		this.listY = listY;
	}
	
	public Points(int n){
		this.listX = new int[n];
		this.listY = new int[n];
	}
	
	public Point getPoint(int n){
		return new Point(listX[n], listY[n]);
	}

	public int[] getListX(){
		return listX;
	}
	
	public int[]getListY(){
		return listY;
	}
	
	public int size(){
		return listX.length;
	}
	
	public void addPoint(int index, int x, int y){
		listX[index] = x;
		listY[index] = y;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(listX);
		result = prime * result + Arrays.hashCode(listY);
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
		Points other = (Points) obj;
		if (!Arrays.equals(listX, other.listX))
			return false;
		if (!Arrays.equals(listY, other.listY))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Points [listX=" + Arrays.toString(listX) + ", listY="
				+ Arrays.toString(listY) + "]";
	}
}
