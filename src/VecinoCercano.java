
public class VecinoCercano {
	
	Point mejorActual;
	double distActual;
	KdTree father;
	
	public VecinoCercano(){
		mejorActual = new Point(0,0);
		distActual = Double.MAX_VALUE;
	}
	
	public Point VecinoMasCercano(KdTree T, Point q){
		father = T;
		T = lookKdTree(T,q);
		return bestSolution(T,q);
	}

	private KdTree lookKdTree(KdTree T, Point q){
		if(T.isLine){
			father = T;
			if(T.getPoint().getX() == 0){
				if(q.getY()>T.getPoint().getY()){
					return lookKdTree(T.der,q);
				}
				else{  return lookKdTree(T.izq,q);}
			}
			else{
				if(q.getX()>T.getPoint().getX()){
					return lookKdTree(T.der,q);
				}
				else{ return lookKdTree(T.izq,q);}
			}
		}
		else{			
			mejorActual = T.getPoint();
			distActual = distancia(mejorActual,q);
			return T;
		}
	}
	
	private Point bestSolution(KdTree T, Point q) {
		if(!T.isLine()){
			double dist = distancia(T.getPoint(),q);
			if(dist<distActual){
				distActual = dist;
				mejorActual=T.getPoint();
				return mejorActual;
			}
			else{
				bestSolution
			}
			
		}
		
	}

	private double distancia(Point p, Point q) {
		return Math.sqrt(Math.pow((q.getX()-p.getX()),2) + Math.pow((q.getY()-p.getY()),2));
	}

}
