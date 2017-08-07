package function;

public class BTreeNodeLight {
	int value;
	BTreeNodeLight leftNode;
	BTreeNodeLight rightNode;
	BTreeNodeLight parent;
	int direction;
	
	public BTreeNodeLight(int value, BTreeNodeLight parent){
		this.value=value;
		this.parent=parent;
	}
	
	void insert(BTreeNodeLight node,int value){
		if(node==null){
			node = new BTreeNodeLight(value,null);
		}
		else{
			if(value>node.value){
				if(node.rightNode!=null)
					insert(node.rightNode,value);
				else{
					node.rightNode = new BTreeNodeLight(value,node);
				}
			}
			else{
				if(node.leftNode!=null)
					insert(node.leftNode,value);
				else{
					node.leftNode = new BTreeNodeLight(value,node);
				}
			}
		}
	}
	

	void delete2(BTreeNodeLight node){
		if(node.leftNode==null){
			if(node.rightNode==null){
				System.out.println("--------SCN 0");
				if(node.parent!=null){
					if(node.parent.leftNode==node){
						node.parent.leftNode=null;
					}
					else{
						node.parent.rightNode=null;
					}
				}
				node=null;
			}
			else{
				if(node.parent==null){
					node=node.rightNode;
					System.out.println("--------SCN 1");
				}
				else{
					if(node.parent.leftNode==node){
						System.out.println("--------SCN 2");
						node.parent.leftNode=node.rightNode;
						node.rightNode.parent=node.parent;
						node=null;
					}
					else{
						System.out.println("--------SCN 3");
						node.parent.rightNode=node.rightNode;
						node.rightNode.parent=node.parent;
						node=null;
					}
				}
			}
		}
		else{
			if(node.rightNode==null){
				if(node.parent==null){
					System.out.println("--------SCN 4");
					node=node.rightNode;
				}
				else{
					if(node.parent.leftNode==node){
						System.out.println("--------SCN 5");
						node.parent.leftNode=node.leftNode;
						node.leftNode.parent=node.parent;
						node=null;
					}
					else{
						System.out.println("--------SCN 6");
						node.parent.rightNode=node.leftNode;
						node.leftNode.parent=node.parent;
						node=null;
					}
				}
			}
			else{
				System.out.println("--------SCN 7");
				BTreeNodeLight minRight=node.rightNode.searchMin();
				node.value=minRight.value;
				node.delete2(minRight);
			}
		}
	}
	
	BTreeNodeLight searchBestFit(int number){
		if(this.value<number){
			if(this.rightNode==null){
				return null;
			}
			return this.rightNode.searchBestFit(number);
		}
		else {
			
			if(this.leftNode!=null){
				if(this.leftNode.value < number){
					return this;
				}
				else{
					return this.leftNode.searchBestFit(number);
				}
			}
			else{
				return this;
			}
		}
		
	}
	
	BTreeNodeLight searchMin(){
		if(this.leftNode==null){
			return this;
		}
		else{
			return this.leftNode.searchMin();
		}
	}
	
	BTreeNodeLight searchMax(){
		if(this.rightNode==null){
			return this;
		}
		else{
			return this.rightNode.searchMax();
		}
	}
	
	void traverse(){
		if(this.leftNode!=null)
			this.leftNode.traverse();
		System.out.print(this.value + " , ");
		if(this.rightNode!=null)
			this.rightNode.traverse();
		
	}
}
