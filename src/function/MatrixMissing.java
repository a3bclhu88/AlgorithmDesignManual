package function;

import java.util.Random;

public class MatrixMissing {
	int[][] List;
	int target;
	int[] rowList;
	int[] colList;
	
	public MatrixMissing(){
		List = new int[8][8];
		target = 11;
		rowList = new int[8];
		colList = new int[8];
		Random rdm = new Random();
		for(int i = 0; i< 8; i++){
			List[i][0] = -1 - i*2;
			for(int j = 1; j< 8; j++){
				List[i][j] = List[i][j-1] + i*2;
			}
			rowList[i] = -1;
			colList[i] = -1;
		}
		
		this.display();
		this.search(target);
	}
	
	void search(int value){
		for(int i = 0; i< 8; i++){
			if(List[i][0] <= 11 && List[i][7] >=11){
				rowList[i] = 1;
			}
			if(List[0][i] <= 11 && List[7][i] >=11){
				colList[i] = 1;
			}
		}
		for(int i = 0; i< 8;i++){
			if(rowList[i] == 1){
				for(int j = 0; j< 8; j++){
					if(colList[j] == 1){
						if(List[i][j] == target){
							System.out.println("position [" + i + " ],[ " + j+ " ] is " + target +".");
						}
					}
				}
			}
		}
	}
	
	void display(){
		System.out.println("List content: ");
		for(int i = 0; i< 8; i++){
			for(int j = 0; j< 8; j++){
				System.out.print(List[i][j]+",");
			}
			System.out.println("");
		}
	}
}
