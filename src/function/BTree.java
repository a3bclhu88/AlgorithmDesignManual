package function;

public class BTree {
	KBalanceTree node;
	boolean initialized;
	int counter;
	int complexity;
	
	public int getcomplexity(){
		return this.complexity;
	}
	public void insertTree(int number){

			node.insert(node, number, null,0);
	}
	public void traverse(){
		this.node.traverse(node);
	}
	public BTree(int number){
		node = new KBalanceTree(number);
		counter=0;
		complexity=0;
	}
	public void check(int number){
		if(node==null){
			System.out.println("element " + number + " not found");
		}
		else{
			if(node.check(node, number)){
				System.out.println("element " + number + " exist");
			}
			else
				System.out.println("element " + number + " not found");
		}
	}
	
	public void deleteN(int index){
		if(node==null){
			System.out.println("The tree is empty");
		}
		else{
			node.deleteN(node,index,this);
		}
	}
}
