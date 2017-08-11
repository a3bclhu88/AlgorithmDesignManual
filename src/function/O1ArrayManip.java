package function;

import java.util.Random;

public class O1ArrayManip {
	int[] keymap;
	int[] valuemap;
	int maxIndex;
	int complexity;
	
	public O1ArrayManip(){
		keymap = new int[15];
		valuemap = new int[30];
		maxIndex = 0;
		complexity = 0;
		
		Random newRandom = new Random();
		
		for(int i = 0; i<15;i++){
			keymap[i] = newRandom.nextInt(30);
		}
		for(int i = 0; i<30;i++){
			valuemap[i] = newRandom.nextInt(50);
		}
		this.display();
	}
	
	public void insert(int value){
		if(this.search(value) == -1){
			complexity ++;
			keymap[maxIndex] = value;
			valuemap[value] = maxIndex;
			System.out.println("value [ " + value + " ] inserted in as [ " + maxIndex + " ] location");
			maxIndex++;
			this.display();
		}
	}
	public int search(int value){
		if(valuemap[value] <= maxIndex){
				if(value == keymap[valuemap[value]]){
				System.out.println("value [ " + value + " ] found in keymap array");
				complexity ++;
				return valuemap[value];
			}
				else{
					System.out.println("value [ " + value + " ] NOT found in keymap array");
					return -1;
				}
		}
		else{
			System.out.println("value [ " + value + " ] NOT found in keymap array");
			return -1;
		}
	}
	public void delete(int value){
		swapKey(maxIndex-1,valuemap[value]);
		swapValue(keymap[maxIndex-1],value);
		maxIndex--;
		complexity ++;
		System.out.println("value [ " + value + " ] deleted");
		this.display();
	}
	
	public void display(){
		System.out.println("value of the key map");
		for(int i = 0; i< 15; i++){
			System.out.print(keymap[i]+" , ");
		}
		System.out.println("value of the value map");
		for(int i = 0; i< 30; i++){
			System.out.print(valuemap[i]+" , ");
		}
	}
	
	void swapKey(int j, int k){
		int tmp;
		tmp = keymap[j];
		keymap[j] = keymap[k];
		keymap[k] = tmp;
	}
	
	void swapValue(int j,int k){
		int tmp;
		tmp = valuemap[j];
		valuemap[j] = valuemap[k];
		valuemap[k] = tmp;
	}
}
