package function;

public class BSTR {
	BSTNode root;
	String inorderS = "0123456789";
	String preorderS = "6432105879";
	
	public BSTR(){
		/*char[] charset= s.toCharArray();
		root = new BSTNode();
		this.root.value = charset[0]-'0';
		for(int i = 1; i< charset.length; i++){
			BSTNode newnode = new BSTNode();
			newnode.value = charset[i]-'0';
			insert(newnode,root);
		}*/
		char[] preorderAr= preorderS.toCharArray();
		char[] inorderAr= inorderS.toCharArray();
		BSTNode newnode = new BSTNode();
		newnode.value = inorderAr[0]-'0';
		root = newnode;
	}
	
	 
	
	void insert(BSTNode n, BSTNode m){
		if(n.value >= m.value){
			if(m.right == null){
				m.right = n;
			}
			else{
				insert(n, m.right);
			}
		}
		else{
			if(m.left == null){
				m.left = n;
			}
			else{
				insert(n, m.left);
			}
		}
		
	}
	
	void inorder(BSTNode n){
		if(n.right!= null){
			inorder(n.right);
		}
		else if(n.parent != null){
			if(n.parent.value > n.value){
				inorder(n.parent);
			}
		}
		else{
			System.out.println("no more nodes in order");
		}
	}
	void inorder2(BSTNode n){
		preorder(n.left);
		System.out.println(n.value);
		preorder(n.right);
	}
	
	void preorder(BSTNode n){
		System.out.println(n.value);
		preorder(n.left);
		preorder(n.right);
	}
}

class BSTNode{
	int value;
	BSTNode left;
	BSTNode right;
	BSTNode parent;
}