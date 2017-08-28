package function;

import java.util.Random;

public class KSUMList {
	int[] list;
	int k;
	
	public KSUMList(){
		list = new int[20];
		k = 5;
		Random rdm = new Random();
		for(int i = 0; i< 20;i++){
			list[i] = rdm.nextInt(25);
		}
		this.display();
	}
	
	public void display(){
		System.out.println("list content: ");
		for(int i = 0; i< 20;i++){
			System.out.print(list[i] + " , ");
		}
		System.out.println("");
	}
	
	public boolean checksum(){
		
		
	}
	void pop
}
