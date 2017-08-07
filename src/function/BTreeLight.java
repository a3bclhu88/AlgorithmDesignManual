package function;

public class BTreeLight {
	BTreeNodeLight root;
	int nodeCount;
	
	void insert(int value){
		if(root==null){
			root = new BTreeNodeLight(value,null);
		}
		else{
			root.insert(root, value);
		}
	}
	
	void delete(BTreeNodeLight node){
		if(root==null){
			System.out.println("the tree is empty");
		}
		else{
			if(root.leftNode==null && root.rightNode==null){
				root=null;
			}
			else{
				root.delete2(node);
			}
		}
	}
	BTreeNodeLight checkBin(int number){
		if(root==null){
			System.out.println("there's no current item in the bin list");
			return null;
		}
		else{
			return root.searchBestFit(number);
		}
	}
	void traverse(){
		if(root==null){
			System.out.println("tree is empty");
		}
		else{
			System.out.println("values of tree nodes: ");
			root.traverse();
		}
	}
}
