package function;

import java.util.ArrayList;
import java.util.LinkedList;

public class GrapghList {
	int[][] matrix = {{0,0,1,0,0,1},{0,0,0,0,1,0},{1,0,0,0,0,0},{0,0,0,0,0,1},{0,1,0,0,0,1},{1,0,0,1,1,0}};
	LinkedList<LinkedList<Integer>> adjacentList;
	int[][] matrix2;
	LinkedList<LinkedList<Integer>> adjacentList2;
	ArrayList<ArrayList<Integer>> middleCounter;
	
	public GrapghList(){
		
		matrix2 = new int[6][6];
		for(int i = 0; i< 6; i++){
			for(int j = 0; j< 6; j++){
				matrix2[i][j] = 0;
			}
		}
		middleCounter = new ArrayList<ArrayList<Integer>>();
		int count= 0;
		for(int i = 0; i< 6; i++){
			for(int j = 0; j< 6; j++){
				if(matrix[i][j] ==1){
					count++;
				}
			}
			middleCounter.add(new ArrayList<Integer>());
			if(count>=2){
				count=0;
				for(int j = 0; j< 6; j++){
					if(matrix[i][j] ==1){
						middleCounter.get(i).add(j);
					}
				}
				for(int item1: middleCounter.get(i)){
					for(int item2: middleCounter.get(i)){
						if(item1 != item2){
							matrix2[item1][item2] = 1;
						}
					}
				}
			}
		}
		
		display(matrix);
		display(matrix2);
		
		
	}
	
	void display(int[][] m){
		System.out.println("content of matrix:");
		for(int[] n: m){
			for(int v:n){
				System.out.print(v+",");
			}
			System.out.println("");
		}
	}
}
