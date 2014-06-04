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
			Point Mid = mean(P,a);
			ArrayList<Point> P1 = new ArrayList<Point>();
			ArrayList<Point> P2 = new ArrayList<Point>();
			
			for(Point point : P){
				if(a.getAxis().equals("x")){
					if(point.getX() > Mid.getX()){
						P2.add(point);
					}
					else{
						P1.add(point);
					}
				}
				else{
					if(point.getY() > Mid.getY()){
						P2.add(point);
					}
					else{
						P1.add(point);
					}
				}
			}
			a.changeAxis();
			return new MeanKdTree(Mid, Mid.isLine(), construirKdtree(P1,a), construirKdtree(P2,a));
		}
	}
	
	public Point mean(ArrayList<Point> P, splitaxis a){
		double x;
		double y;
		Point[] points = new Point[P.size()];
		P.toArray(points);
		Point max = new Point(Double.MIN_VALUE,Double.MIN_VALUE);
		Point min = new Point(Double.MAX_VALUE,Double.MAX_VALUE);
		if(a.getAxis().equals("x")){
			for(Point point : points){
				if(point.getX() > max.getX()){
					max = point;
				}
				else if(point.getX() < min.getX()){
					min = point;
				}
			}
			x = (max.getX() + min.getX()) /2;
			y = 0;
			return new Point(x,y,true);
			
		}
		else{
			for(Point point : points){
				if(point.getY() > max.getY()){
					max = point;
				}
				else if(point.getY() < min.getY()){
					min = point;
				}
			}
			x = 0;
			y = (max.getY() + min.getY()) /2;
			return new Point(x,y,true);
		}		
	}

}
