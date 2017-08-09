package function;

import java.util.Random;

public class RangeStaticArray {
	int[] List;
	RangeTree minTree; 
	int treeCount;
	int complexity;
	
	public RangeStaticArray(){
		complexity = 0;
		List = new int[20];
		treeCount = 0;
		RangeTree minTree = new RangeTree();
		Random rand = new Random();
		for(int i = 0;i<20;i++){
			List[i] = rand.nextInt(20);
		}
	}
	
	public void buildRangeTree(){
		for(int i = 0;i<20;i++){
			RangeTree newLeaf = new RangeTree(List[i]);
			System.out.println( " [ " + i + " ] th " + " leaf node created with value " + " [ " + List[i] + " ]");
			if(treeCount!=0){
				minTree.insert(newLeaf, i);
				minTree.traverseLeafs();
			}
			else{
				this.minTree=newLeaf;
				treeCount++;
				System.out.println("first node created in the tree");
			}
		}
	}
	public void displayArray(){
		System.out.println("List of number in action: ");
		for(int i = 0;i<20;i++){
			System.out.print(List[i]+" , ");
		}
		System.out.println();
	}
}
