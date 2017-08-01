package function;

public class KBalanceTree {
	int value;
	KBalanceTree leftchild;
	KBalanceTree rightchild;
	KBalanceTree parent;
	
	public KBalanceTree(){
		;
	}
	
	public void insert(KBalanceTree root, int number,KBalanceTree ancestor){
		if(root == null){
			root = new KBalanceTree();
			root.value = number;
			root.parent = ancestor;
		}
		else{
			if(number > root.value){
				insert(root.rightchild,number,root);
			}
			else{
				insert(root.leftchild,number,root);
			}
		}
	}
	
	public void traverse(KBalanceTree root){
		if(root == null){
			;
		}
		else{
			System.out.println("value : " + root.value);
			traverse(root.leftchild);
			traverse(root.rightchild);
		}
		return;
	}
}
