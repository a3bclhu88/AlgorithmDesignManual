package function;

public class TreeToLinkList {
	BTree BTree;
	
	public TreeToLinkList(BTree T){
		BTree =T;
	}
	
	public KBalanceTree findMax(KBalanceTree node){
		System.out.println("looking into right tree max of [ " + node.value + " ]");
		if(node.rightchild == null){
			return node;
		}
		else{
			return findMax(node.rightchild);
		}
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
	
	public void toList(KBalanceTree node){
		if(node==null){
			System.out.println("the tree is reaching to the end");
		}
		else{
			toList(node.leftchild);
			System.out.println("starting to process node [ " + node.value + " ]");
			toList(node.rightchild);
			if(node.leftchild != null){
				System.out.println(" -- Scenario 1 linking left arm of node [ " + node.value + " ]");
				findMax(node.leftchild).rightchild = node;
				System.out.println(" -- Scenario 2 linking left arm of node [ " + node.value + " ] as [" + findMax(node.leftchild).value + " ]");
			}
			//node.leftchild = null;
			
			if(node.rightchild != null){
				System.out.println(" -- Scenario 2 linking right arm of node [ " + node.value + " ]");
				node.rightchild = findMin(node.rightchild);
				System.out.println(" -- Scenario 2 linking right arm of node [ " + node.value + " ] as [" + node.rightchild.value + " ]");
			}
			
		}
	}
}
