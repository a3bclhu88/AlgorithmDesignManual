package function;

public class KBalanceTree {
	int value;
	KBalanceTree leftchild;
	KBalanceTree rightchild;
	KBalanceTree parent;
	
	public KBalanceTree(int number){
		value=number;
	}
	
	public void insert(KBalanceTree root, int number,KBalanceTree ancestor){
		if(root==null){
			System.out.println("creating new node with value "+number );
			root = new KBalanceTree(number);
			root.parent = ancestor;
			System.out.println("created new node with value "+number + " as child of node value " + root.parent.value );
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
			
		}
		else{
			traverse(root.leftchild);
			System.out.println("value : " + root.value);
			traverse(root.rightchild);
		}
		
	}
}
