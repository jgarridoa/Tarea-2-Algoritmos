import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class ExperimentBuildKdTree {
	
	public void doRandomMeanExperiment() throws IOException{
		long time_start;
		long time_stop;
		ArrayList<Double> times = new ArrayList<Double>();
		ArrayList<Integer> heights = new ArrayList<Integer>();
		ArrayList<Integer> size = new ArrayList<Integer>();
		for(int j = 0; j < 10; j++){
			times.clear();
			heights.clear();
			size.clear();
			for (int i = 10; i < 21; i++) {
				Points P = new Points((int)Math.pow(2,i));
				P.generateRandomPoints();
				time_start = System.nanoTime();
				KdTree tree = MeanKdTree.construirKdTree(P, Splitaxis.getSplitX());
				time_stop = System.nanoTime();
				times.add ((time_stop - time_start) * Math.pow(10, -9));
				heights.add(tree.getHeight());
				size.add(tree.getSize());
			}
			String name = "MeanRandom" + (j+1);
			saveResults(name,times,heights,size);
		}
	}
	
	public void doLowDiscrepancyMeanExperiment() throws IOException{
		long time_start;
		long time_stop;
		ArrayList<Double> times = new ArrayList<Double>();
		ArrayList<Integer> heights = new ArrayList<Integer>();
		ArrayList<Integer> size = new ArrayList<Integer>();
		for(int j=0;j<10;j++){
			times.clear();
			heights.clear();
			size.clear();
			for (int i = 10; i < 21; i++) {
				Points P = new Points((int)Math.pow(2,i));
				P.generateLowDiscrepancyPoints();
				time_start = System.nanoTime();
				KdTree tree = MeanKdTree.construirKdTree(P, Splitaxis.getSplitX());
				time_stop = System.nanoTime();
				times.add ((time_stop - time_start) * Math.pow(10, -9));
				heights.add(tree.getHeight());
				size.add(tree.getSize());
			}
			String name = "MeanLowDiscrepancy" + (j+1);
			saveResults(name,times,heights,size);
		}
	}
	
	public void doMeanExperimentPrincipalMem() throws IOException{
		doLowDiscrepancyMeanExperiment();
		doRandomMeanExperiment();
	}
	
	public void doRandomMedianExperiment() throws IOException{
		long time_start;
		long time_stop;
		ArrayList<Double> times = new ArrayList<Double>();
		ArrayList<Integer> heights = new ArrayList<Integer>();
		ArrayList<Integer> size = new ArrayList<Integer>();
		for(int j = 0; j < 10; j++){
			times.clear();
			heights.clear();
			size.clear();
			for (int i = 10; i < 21; i++) {
				Points P = new Points((int)Math.pow(2,i));
				P.generateRandomPoints();
				time_start = System.nanoTime();
				KdTree tree = MedianKdTree.construirKdTree(P, Splitaxis.getSplitX());
				time_stop = System.nanoTime();
				times.add ((time_stop - time_start) * Math.pow(10, -9));
				heights.add(tree.getHeight());
				size.add(tree.getSize());
			}
			String name = "MedianRandom" + (j+1);
			saveResults(name,times,heights,size);
		}
	}
	
	public void doLowDiscrepancyMedianExperiment() throws IOException{
		long time_start;
		long time_stop;
		ArrayList<Double> times = new ArrayList<Double>();
		ArrayList<Integer> heights = new ArrayList<Integer>();
		ArrayList<Integer> size = new ArrayList<Integer>();
		for(int j=0;j<10;j++){
			times.clear();
			heights.clear();
			size.clear();
			for (int i = 10; i < 21; i++) {
				Points P = new Points((int)Math.pow(2,i));
				P.generateLowDiscrepancyPoints();
				time_start = System.nanoTime();
				KdTree tree = MedianKdTree.construirKdTree(P, Splitaxis.getSplitX());
				time_stop = System.nanoTime();
				times.add ((time_stop - time_start) * Math.pow(10, -9));
				heights.add(tree.getHeight());
				size.add(tree.getSize());
			}
			String name = "MedianLowDiscrepancy" + (j+1);
			saveResults(name,times,heights,size);
		}
	}
	
	public void doMedianExperimentPrincipalMem() throws IOException{
		doLowDiscrepancyMedianExperiment();
		doRandomMedianExperiment();
	}
	
	public void saveResults(String name,ArrayList<Double> times, ArrayList<Integer> heights,ArrayList<Integer> size) throws IOException {
		String filename = name + "Experiment.txt";
		try {
			FileWriter file = new FileWriter(filename);
			PrintWriter prt = new PrintWriter(file);
			prt.write("Resultados del experimento con " + name + "\r\n");

			for (int i = 10; i < 21; i++) {
				int height = heights.get(i - 10);
				int ssize = size.get(i - 10);
				double time = times.get(i - 10);
				prt.write("Arbol de tamaño: 2^" + i + " Altura: "+ height + " Size: "+ ssize + " Tiempo: "+ time + "\r\n");
			}
			prt.close();
		} catch (IOException e) {
			System.out.println("Hubo un error");
		}
	}

}
