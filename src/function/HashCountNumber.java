package function;

import java.util.HashMap;
import java.util.Random;

public class HashCountNumber {
	HashMap<Integer,Integer> hash;
	int[] list;
	int threshold;
	
	public HashCountNumber(int t){
		hash = new HashMap<Integer,Integer>();
		Random rdm = new Random();
		list = new int[30];
		for(int i = 0;i<30;i++){
			list[i] = rdm.nextInt(10);
		}
		threshold = t;
		this.display();
	}
	
	public void calculate(){
		int count;
		for(int i = 0;i<30;i++){
			if(hash.containsKey(list[i])){
				count = hash.get(list[i]);
				hash.remove(list[i]);
				hash.put(list[i], ++count);
				if(count>= threshold){
					System.out.println("list item { " + list[i] + " } appeared more thean [ " + threshold + " ] times");
				}
			}
			else{
				hash.put(list[i], 1);
			}
		}
		this.displayHash();
	}
	
	public void display(){
		System.out.println("list content : ");
		for(int i = 0;i< 30;i++){
			System.out.print(list[i] + ", ");
		}
		System.out.println("");
	}
	
	public void displayHash(){
		hash.forEach((k,v) -> System.out.println("number { "+ k + "  } appeared [ " + v + " ] times"));
	}
}
