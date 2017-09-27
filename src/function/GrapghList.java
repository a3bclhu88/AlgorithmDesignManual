package function;

import java.util.ArrayList;
import java.util.LinkedList;

public class GrapghList {
	int[][] matrix = {{0,0,1,0,0,1},{0,0,0,0,1,0},{1,0,0,0,0,0},{0,0,0,0,0,1},{0,1,0,0,0,1},{1,0,0,1,1,0}};
	LinkedList<LinkedList<Integer>> adjacentList;
	int[][] matrix2;
	int[][] matrix3;
	LinkedList<LinkedList<Integer>> adjacentList2;
	ArrayList<ArrayList<Integer>> middleCounter;
	//ArrayList<ArrayList<Integer>> middleCounter2;
	public GrapghList(){
		
		matrix2 = new int[6][6];
		matrix3 = new int[6][6];
		for(int i = 0; i< 6; i++){
			for(int j = 0; j< 6; j++){
				matrix2[i][j] = 0;
				matrix3[i][j] = 0;
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
		
		
		
		adjacentList = new LinkedList<LinkedList<Integer>>();
		matrixToList(matrix,adjacentList);
		//middleCounter2= new ArrayList<ArrayList<Integer>>();
		for(int i = 0;i<adjacentList.size();i++){
			LinkedList<Integer> L1 = adjacentList.get(i);
			for(int v: L1){
				for(int u:L1){
					if(u!=v){
						matrix3[v][u] = 1;
					}
				}
			}
		}
		display(matrix3);
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
	void matrixToList(int[][] m, LinkedList<LinkedList<Integer>> l){
		for(int i = 0; i< 6;i++){
			l.add(new LinkedList<Integer>());
			for(int j = 0; j< 6;j++){
				if(m[i][j] == 1){
					l.get(i).add(j);
				}
			}
			System.out.println("size:" + l.get(i).size());
		}
		System.out.println("size:" + l.size());
	}
}
