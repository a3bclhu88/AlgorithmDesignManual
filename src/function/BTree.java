package function;

public class BTree {
	KBalanceTree node;
	KBalanceTree min;
	boolean initialized;
	int counter;
	int complexity;
	
	public KBalanceTree getRoot(){
		return node;
	}
	
	public void setMin(){
		min = findMin(node);
	}
	
	public KBalanceTree findMin(KBalanceTree node){
		System.out.println("looking into left tree min of [ " + node.value + " ]");
		if(node.leftchild == null){
			return node;
		}
		else{
			return findMin(node.leftchild);
		}
	}
	
	public void traverseFromMin(){
		min.traverseMin();
	}
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
	
	public BTree(KBalanceTree t){
		node = t;
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
	
	public void deleteK(int index){
		if(node==null){
			System.out.println("The tree is empty");
		}
		else{
			node.deleteK(node,index,this);
		}
	}
	public static BTree concatenateTree(BTree tree1, BTree tree2){
		if(tree1==null ){
			if(tree2==null){
				System.out.println("merged tree is empty");
				return null;
			}
			else{
				return tree2;
			}
		}
		if(tree2==null){
			return tree1;
		}
		int newRootValue = tree2.node.findMin(tree2.node).value;
		tree2.deleteK(1);
		KBalanceTree newRoot= new KBalanceTree(newRootValue);
		newRoot.leftchild=tree1.node;
		newRoot.rightchild=tree2.node;
		BTree returnTree = new BTree(newRoot);
		return returnTree;
	}
}
