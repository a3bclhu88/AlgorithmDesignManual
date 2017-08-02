package function;

public class KBalanceTree {
	int value;
	KBalanceTree leftchild;
	KBalanceTree rightchild;
	KBalanceTree parent;
	
	public KBalanceTree(int number){
		value=number;
	}
	
	public void insert(KBalanceTree root, int number,KBalanceTree ancestor, int direction){
		if(root==null){
			System.out.println("creating new node with value "+number );
			root = new KBalanceTree(number);
			root.parent = ancestor;
			if(direction==-1){
				ancestor.leftchild=root;
			}
			else if(direction==1){
				ancestor.rightchild=root;
			}
			else{
				
			}
			System.out.println("created new node with value "+number + " as child of node value " + root.parent.value );
		}
		else{
			if(number > root.value){
				
				insert(root.rightchild,number,root,1);
			}
			else{
				insert(root.leftchild,number,root, -1);
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
	
	public boolean check(KBalanceTree root, int number){
		if(root==null){
			return false;
		}
		else if(root.value>number){
			return check(root.leftchild,number);
		}
		else if(root.value<number){
			return check(root.rightchild,number);
		}
		else
			return true;
	}
	
	public void deleteN(KBalanceTree root, int index, BTree tree){
		if(tree.counter>=index)
			return;
		if(root == null){
			;
		}
		else{
			deleteN(root.leftchild,index,tree);
			System.out.println("item at position " + tree.counter + " is " + root.value);
			tree.counter++;
			deleteN(root.rightchild,index,tree);
		}
	}
}
