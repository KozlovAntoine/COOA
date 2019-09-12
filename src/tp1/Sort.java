package tp1;

import java.util.Arrays;

public class Sort {

	public static void main(String[] args) {
		int[] tab = generateRdmIntArray(1000, 0, 2000);
		printArray(tab);
		partition(tab, 0, 20, 1);
		int a = (int) (tab.length * Math.log(tab.length));
		System.out.println(a);
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

	public static void insertSort(int[] tab, boolean counter) {
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

	public static void selectSort(int[] tab, boolean counter) {
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

	public static void bubbleSort(int[] tab, boolean counter) {
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

	public static int partition(int[] tab, int d, int f, int idxP){
		if(d < f){
			Counter.reset();
			int pivot = tab[idxP];
			System.out.println("Pivot:"+pivot);
			int idx = tab.length-2;
			int i = 0;
			swap(tab, idxP, tab.length-1);
			Counter.incPerm();
			while(idx > i){
				Counter.incComp();
				if(tab[i] > pivot){
					swap(tab, i, idx);
					Counter.incPerm();
					idx--;
				} else i++;
				//printArray(tab);
			}
			swap(tab, tab.length-1, idx);
			Counter.incPerm();
			printArray(tab);
			Counter.affichage();
		}
		return 0;
	}
}