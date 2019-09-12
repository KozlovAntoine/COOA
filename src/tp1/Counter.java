package tp1;

public class Counter {

	private static int comp = 0, perm = 0;

	public static void incComp(){
		comp++;
	}

	public static void incComp(int n){
		comp += n;
	}

	public static void incPerm(){
		perm++;
	}

	public static void incPerm(int n){
		perm += n;
	}

	public static void reset(){
		comp = 0;
		perm = 0;
	}

	public static void affichage(){
		System.out.println("Comparaison : " + comp + ", Permutation : " + perm + ".");
	}
}
