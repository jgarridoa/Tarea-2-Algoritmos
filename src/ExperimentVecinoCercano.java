import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;


public class ExperimentVecinoCercano {
	
	public void doMeanExperiment() throws IOException{
		long time_start = 0;
		long time_stop = 0;
		Point aux;
		Random r = new Random();
		ArrayList<Double> times = new ArrayList<Double>();
		ArrayList<Point[]> pointsres = new ArrayList<Point[]>();
		ArrayList<Point[]> pointsaux = new ArrayList<Point[]>();
		for(int j = 0; j < 10; j++){
			times.clear();
			for (int i = 10; i < 21; i++) {
				Points P = new Points((int)Math.pow(2,i));
				P.generateRandomPoints();
				KdTree Meantree = MeanKdTree.construirKdTree(P, Splitaxis.getSplitX());
				Vecino vecino = new Vecino();
				Point[] res = new Point[20];
				Point[] auxres = new Point[20];
				for(int k = 0; k < 20; k++){	
					aux = new Point( 0.7*Math.sqrt(Math.pow(2,i))*r.nextDouble() , 0.7*Math.sqrt(Math.pow(2,i))*r.nextDouble());
					time_start += System.nanoTime();
					res[k]=vecino.masCercano(Meantree,aux);
					time_stop += System.nanoTime();
					auxres[k]=aux;
				}
				pointsres.add(res);
				pointsaux.add(auxres);
				times.add (((time_stop)/20 - (time_start)/20) * Math.pow(10, -9));

			}
			String name = "MeanVecino" + (j+1);
			saveResults(name,times,pointsres,pointsaux);
		}
	}
	
	public void saveResults(String name,ArrayList<Double> times, ArrayList<Point[]> pointsres, ArrayList<Point[]> pointsaux) throws IOException {
		String filename = name + "Experiment.txt";
		try {
			FileWriter file = new FileWriter(filename);
			PrintWriter prt = new PrintWriter(file);
			prt.write("Resultados del experimento con " + name + "\r\n");

			for (int i = 10; i < 21; i++) {
				double time = times.get(i - 10);
				prt.write("Búsqueda en Arbol de tamaño: 2^" + i + " Tiempo: "+ time + "\r\n");
				prt.write("Buscados: ");
				for(int j = 0; j<pointsaux.get(i-10).length;j++){
					prt.write(pointsaux.get(i-10)[j].toString() + ",");
				}
				prt.write("\r\n");
				prt.write("Encontrados: ");
				for(int j = 0; j<pointsres.get(i-10).length;j++){
					prt.write(pointsres.get(i-10)[j].toString() + ",");
				}
				prt.write("\r\n");
			}
			prt.close();
		} catch (IOException e) {
			System.out.println("Hubo un error");
		}
	}

}
