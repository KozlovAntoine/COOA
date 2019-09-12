package tp1;

import java.util.Arrays;

public class Friend implements Comparable<Friend> {

	String nom;
	int age;

	public Friend(String nom, int age){
		this.nom = nom;
		this.age = age;
	}

	@Override
	public int compareTo(Friend f) {
		if(age == f.age) return 0;
		return (age - f.age < 0) ? -1 : 1;
	}

	public String toString(){
		return nom + " " + age;
	}


	public static void main(String[] args){
		Friend[] friends = new Friend[20];
		for(int i = 0 ; i < friends.length ; i++){
			friends[i] = new Friend("A"+i, randInt(15,55));
		}
		System.out.println(Arrays.toString(friends));
		Arrays.sort(friends);
		System.out.println(Arrays.toString(friends));
	}

	private static int randInt(int min, int max){
		return (int) (Math.random() * ((max - min) + 1)) + min;
	}
}
