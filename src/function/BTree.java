package function;

public class BTree {
	KBalanceTree node;
	boolean initialized;
	
	public void insertTree(int number){

			node.insert(node, number, null);
	}
	public void traverse(){
		this.node.traverse(node);
	}
	public BTree(int number){
		node = new KBalanceTree(number);
	}
}
