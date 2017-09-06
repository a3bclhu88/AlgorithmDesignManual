package function;

import java.util.Random;

public class TournamentHeap {
	int[] list;
	int first;
	int second;
	int third;
	
	public TournamentHeap(){
		list = new int[20];
		Random rdm = new Random();
		for(int i =0; i< 20; i++){
			list[i] = rdm.nextInt(20);
		}
		this.display();
		this.heapify(list);
	}
	public void heapify(int[] AList){
		if(AList.length == 1){
			System.out.println("Maximum item found!: [" + AList[0] + " ] ");
			return;
		}
		int[] BList;
		if(AList.length%2 == 0){
			BList = new int[AList.length/2];
		}
		else{
			BList = new int[AList.length/2+1];
		}
		int k = 0;
		for(int i = 0, j = AList.length-1;i<=j;i++,j--){
			if(AList[i] <= AList[j]){
				BList[k] = AList[j];
			}
			else{
				BList[k] = AList[i];
			}
			k++;
		}
		heapify(BList);
	}
	void display(){
		System.out.println("content of list: ");
		for(int i = 0;i<20;i++){
			System.out.print(list[i] + ", ");
		}
		System.out.println("");
	}
}
