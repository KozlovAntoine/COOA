package tp1;

import java.util.Arrays;

public class Sort {

	private static boolean counter = false;

	public static void main(String[] args) {
		long now = System.currentTimeMillis();
		Counter.reset();
		int size = 1000000;
		int[] tab = generateRdmIntArray(size, 0, 10000);
		//printArray(tab);
		quickSort(tab, 0 , size-1);
		//printArray(tab);
		Counter.affichage();

		int a = (int) (size * Math.log(size));
		//System.out.println(a);

		System.out.println("Time execution:" + (System.currentTimeMillis() - now) + "ms");
		/*System.out.println("Bubble sort : ");
		tab = generateRdmIntArray(100, 0, 100);
		bubbleSort(tab, true);

		System.out.println("\nInsert sort : ");
		tab = generateRdmIntArray(100, 0, 100);
		insertSort(tab, true);

		System.out.println("\nSelect sort : ");
		tab = generateRdmIntArray(100, 0, 100);
		selectSort(tab, true);*/
	}

	public static int[] generateRdmIntArray(int n, int min, int max) {
		if (n < 1) {
			System.err.println("n est nul ou negatif");
			return null;
		}

		int[] tab = new int[n];
		for (int i = 0; i < n; i++) {
			tab[i] = (int) (Math.random() * ((max - min) + 1)) + min;
		}
		return tab;
	}

	public static void insertSort(int[] tab) {
		Counter.reset();
		int n = tab.length;
		for (int i = 1; i < n; ++i) {
			int key = tab[i];
			int j = i - 1;
			while (j >= 0 && tab[j] > key) {
				tab[j + 1] = tab[j];
				j = j - 1;
				Counter.incComp();
			}
			tab[j + 1] = key;
			Counter.incPerm();
		}
		if(counter) Counter.affichage();
	}

	public static void selectSort(int[] tab) {
		Counter.reset();
		for (int i = 0; i < tab.length; i++) {
			int min = tab[i], idx = i;
			for (int j = (i + 1); j < tab.length; j++) {
				Counter.incComp();
				if (tab[j] < min) {
					min = tab[j];
					idx = j;
				}
			}
			swap(tab, i, idx);
		}
		if(counter) Counter.affichage();
	}

	public static void printArray(int[] tab) {
		System.out.print("[");
		for (int i = 0; i < tab.length; i++) {
			System.out.print(tab[i] + ", ");
		}
		System.out.println("]");
	}

	public static void swap(int[] tab, int idx, int idx2) {
		int temp = tab[idx];
		tab[idx] = tab[idx2];
		tab[idx2] = temp;
		Counter.incPerm();
	}

	public static void bubbleSort(int[] tab) {
		Counter.reset();
		for (int i = 0; i < tab.length - 1; i++){
			for (int j = 0; j < tab.length-i-1; j++) {
				Counter.incComp();
				if (tab[j] > tab[j + 1]) {
					swap(tab, j, j + 1);
				}
			}
		}
		if(counter) Counter.affichage();
	}

	/*public static int partition(int[] tab, int d, int f, int idxP){
		if(d < f){
			int pivot = tab[idxP];
			int idx = f - 1;
			int i = d;
			swap(tab, idxP, f);
			while(idx > i){
				Counter.incComp();
				if(tab[i] > pivot){
					swap(tab, i, idx);
					idx--;
				} else i++;
				//printArray(tab);
			}
			swap(tab, f, idx);
			//printArray(tab);
			if(counter) Counter.affichage();
			//System.out.println("return:" + idx);
			return idx;
		}
		return -1;
	}*/

	public static void quickSort(int[] tab, int debut, int fin){
		if(debut < fin){
			int pivot = partition(tab, debut, fin, (int) (Math.random() * ((fin - debut) + 1)) + debut);
			//System.out.println("Pivot = " + pivot);
			quickSort(tab, debut, pivot - 1);
			quickSort(tab, pivot + 1, fin);
		}
	}

	public static int partition(int[] tab, int d, int f, int idxP){
		swap(tab, idxP, f);
		int j = d;
		for(int i = d ; i < f ; i++){
			Counter.incComp();
			if(tab[i] <= tab[f]){
				swap(tab, i, j);
				j++;
			}
		}
		swap(tab, f, j);
		return j;
	}
}