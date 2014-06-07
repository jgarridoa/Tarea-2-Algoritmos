import java.io.IOException;


public class Main {

	public static void main(String[] args) throws IOException {
		new ExperimentBuildKdTree().doMeanExperimentPrincipalMem();
		new ExperimentBuildKdTree().doMedianExperimentPrincipalMem();
		new ExperimentVecinoCercano().doMeanExperimentPrincipalMem();
		new ExperimentVecinoCercano().doMedianExperimentPrincipalMem();
	}

}
