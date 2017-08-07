package function;

public class KBalanceTree {
	int value;
	KBalanceTree leftchild;
	KBalanceTree rightchild;
	KBalanceTree parent;
	int leftChildDepth;
	
	public KBalanceTree(int number){
		value=number;
		leftChildDepth=1;
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
				root.leftChildDepth++;
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
		tree.complexity++;
		if(root == null){
			return;
		}
		else{
			deleteN(root.leftchild,index,tree);
			System.out.println("item at position " + tree.counter + " is " + root.value);
			tree.counter++;
			if(index == tree.counter){
				deleteSingle(root);
				tree.complexity++;
			}
			if(tree.counter>=index)
				return;
			deleteN(root.rightchild,index,tree);
		}
	}
	
	public void deleteK(KBalanceTree root, int k, BTree tree){
		if(root==null){
			return;
		}
		if(root.leftChildDepth == k){
			tree.complexity++;
			deleteSingle(root);
		}
		else if(root.leftChildDepth > k){
			tree.complexity++;
			deleteK(root.leftchild,k,tree);
		}
		else {
			tree.complexity++;
			deleteK(root.rightchild,k-root.leftChildDepth,tree);
		}
	}
	
	public void deleteSingle(KBalanceTree root){
		int deletedValue;
		if(root==null){
			System.out.println("the node to be deleted does not exist" );
		}
		else{
			if(root.leftchild==null && root.rightchild==null){
				if(root.parent==null){
					deletedValue=root.value;
					root=null;
					System.out.println("item " + deletedValue + " deleted scenario 1" );
				}
				else{
					if(root.parent.leftchild==root){
						root.parent.leftChildDepth--;
						root.parent.leftchild=null;
					}
					if(root.parent.rightchild==root){
						root.parent.rightchild=null;
					}
					deletedValue=root.value;
					root=null;
					System.out.println("item " + deletedValue + " deleted scenario 1");
				}
			}
			else if(root.leftchild==null && root.rightchild!=null){
				KBalanceTree tmp = root.parent;
				if(tmp.leftchild!=null && tmp.leftchild==root){
					deletedValue=root.value;
					root.parent.leftchild=root.rightchild;
					root.rightchild.parent=root.parent;
					System.out.println("item " + deletedValue + " deleted scenario 2" );
					return;
				}
				else if(tmp.rightchild==root && tmp.rightchild!=null){
					deletedValue=root.value;
					root.parent.rightchild=root.rightchild;
					root.rightchild.parent=root.parent;
					System.out.println("item " + deletedValue + " deleted scenario 2" );
					return;
				}
				else{
					return;
				}
			}
			else if(root.leftchild!=null && root.rightchild==null){
				KBalanceTree tmp = root.parent;
				if(tmp.leftchild!=null && tmp.leftchild==root){
					deletedValue=root.value;
					root.parent.leftChildDepth--;
					root.parent.leftchild=root.leftchild;
					root.leftchild.parent=root.parent;
					System.out.println("item " + deletedValue + " deleted scenario 3" );
					return;
				}
				else if(tmp.rightchild==root && tmp.rightchild!=null){
					deletedValue=root.value;
					root.parent.rightchild=root.leftchild;
					root.leftchild.parent=root.parent;
					System.out.println("item " + deletedValue + " deleted  scenario 3" );
					return;
				}
				else{
					return;
				}
			}
			else{
				KBalanceTree tmp = root.parent;
				if(tmp.leftchild!=null && tmp.leftchild==root){
				
					if(root.leftchild.rightchild ==null){
						if(root.rightchild.leftchild==null){
							deletedValue=root.value;
							root=root.leftchild;
							root.parent=tmp;
							tmp.leftchild=root;
							root.parent.leftChildDepth--;
							System.out.println("item " + deletedValue + " deleted  scenario 4" );
							return;
						}
						else{
							deletedValue=root.value;
							root=root.rightchild.leftchild;
							root.parent=tmp;
							tmp.leftchild=root;
							System.out.println("item " + deletedValue + " deleted scenario 4" );
							return;
						}
					}
					else{
						deletedValue=root.value;
						root=root.leftchild.rightchild;
						root.parent=tmp;
						tmp.leftchild=root;
						System.out.println("item " + deletedValue + " deleted scenario 4" );
						return;
					}
				}
				else if(tmp.rightchild==root && tmp.rightchild!=null){
					if(root.leftchild.rightchild ==null){
						if(root.rightchild.leftchild==null){
							deletedValue=root.value;
							root=root.leftchild;
							root.parent=tmp;
							tmp.rightchild=root;
							System.out.println("item " + deletedValue + " deleted scenario 5" );
							return;
						}
						else{
							deletedValue=root.value;
							root=root.rightchild.leftchild;
							root.parent=tmp;
							tmp.rightchild=root;
							System.out.println("item " + deletedValue + " deleted scenario 5" );
							return;
						}
					}
					else{
						deletedValue=root.value;
						root=root.leftchild.rightchild;
						root.parent=tmp;
						tmp.rightchild=root;
						System.out.println("item " + deletedValue + " deleted scenario 5" );
						return;
					}
				}
				else{
					return;
				}
			}
		}
	}
	
	public KBalanceTree findMin(KBalanceTree root){
		if(root==null){
			System.out.println("element not found");
			return null;
		}
		else{
			if(root.leftchild==null){
				return root;
			}
			else{
				return findMin(root.leftchild);
			}
		}
	}
}
