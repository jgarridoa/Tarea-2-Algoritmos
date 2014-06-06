import java.util.ArrayList;

public class MedianKdTree {

	public static KdTree construirKdTree(Points P, Splitaxis a){
		return construirKdTree(P, a, 0, P.size() - 1);
	}
	
	private static KdTree construirKdTree(Points P, Splitaxis a, int minA,
			int maxA) {
		if (minA > maxA)
			return null;
		else if (minA == maxA)
			return new KdTree(P.getPoint(minA));

		else {
			int[] keyArray, dependantArray;
			int median;
			Point eje;
			if (a.isX()) {
				keyArray = P.getListX();
				dependantArray = P.getListY();
				median = QuickSelect(keyArray, dependantArray, minA, maxA, (maxA - minA) /2);
				eje = new EjeY(median);
			} else {
				keyArray = P.getListY();
				dependantArray = P.getListX();
				median = QuickSelect(keyArray, dependantArray, minA, maxA, (maxA - minA) /2);
				eje = new EjeX(median);
			}

			
			if (median > maxA)
				median = maxA;
			Splitaxis alterAxis = Splitaxis.changeAxis(a);
			return new KdTree(eje, construirKdTree(P, alterAxis, minA,
					median - 1), construirKdTree(P, alterAxis, median, maxA));
		}
	}


	private static int partition(int[] keyArray, int[] dependantArray,
			int minA, int maxA, double pivotValue) {
		int smaller = minA;
		int greater = maxA;
		while (smaller <= greater) {
			if (keyArray[smaller] <= pivotValue)
				smaller++;
			else {
				// swap keyArray
				int aux = keyArray[greater];
				keyArray[greater] = keyArray[smaller];
				keyArray[smaller] = aux;
				if (dependantArray != null) {
					// swap dependantArray
					aux = dependantArray[greater];
					dependantArray[greater] = dependantArray[smaller];
					dependantArray[smaller] = aux;
					greater--;
				}
			}
		}
		// al finalizar el ciclo, la variable smaller indicará la posición
		// del primero de los números más grandes que el pivote
		return smaller;
	}

	public static int QuickSelect(int[] keyArray, int[] dependantArray,
			int first, int last, int n) {
		if (first >= last)
			return last;
		int pivotValue = medianOfMedians(keyArray, first, last);
		int pivotIndex = partition(keyArray, dependantArray, first, last,
				pivotValue);

		if (pivotIndex == n)
			return keyArray[n];
		else if (pivotIndex > n)
			return QuickSelect(keyArray, dependantArray, first, pivotIndex - 1,
					n);
		else
			return QuickSelect(keyArray, dependantArray, pivotIndex + 1, last,
					n);

	}

	// Selección de la Mediana de las medianas
	private static int medianOfMedians(int[] keyArray, int first, int last) {
		int numMedians = (int) Math.ceil((last - first) / 5d);
		if (numMedians == 1){
			insertionSort(keyArray, first, last);
			return keyArray[(first + last)/2 ];
		}
			
		int[] medians = new int[numMedians];
		for (int i = 0; i < numMedians; i++) {
			int subLeft = first + i * 5;
			int subRight = subLeft + 4;
			if (subRight > last)
				subRight = last;
			insertionSort(keyArray, subLeft, subRight);
			medians[i] = keyArray[(subRight + subLeft) / 2];
		}
		return QuickSelect(medians, null, 0, numMedians - 1, numMedians /2 );

	}

	private static void insertionSort(int[] array, int min, int max) {
		for (int i = min; i <= max; i++)
			insert(array, i, min);
	}

	private static void insert(int[] array, int position, int min) {
		int aux = array[position];
		int j;
		for (j = position - 1; j >= min; j--) {
			if (array[j] > aux)
				array[j + 1] = array[j];
			else
				break;
		}
		array[j + 1] = aux;
	}

}
