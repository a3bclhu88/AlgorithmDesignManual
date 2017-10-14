package function;

import java.util.ArrayList;

public class GenericTree {
	TreeNode root;
	int radius;
	int depth;
	ArrayList<ArrayList<Integer>> matrix;
	
	public GenericTree(){
		
		matrix = new ArrayList<ArrayList<Integer>>();
		radius = 0;
		depth = 0;
		for(int i = 0; i< 15;i++){
			matrix.add(new ArrayList<Integer>());
		}
		matrix.get(0).add(2);
		matrix.get(2).add(3);
		matrix.get(2).add(4);
		matrix.get(3).add(5);
		matrix.get(4).add(1);
		matrix.get(4).add(6);
		matrix.get(4).add(7);
		matrix.get(6).add(8);
		matrix.get(6).add(9);
		matrix.get(8).add(13);
		matrix.get(8).add(14);
		matrix.get(9).add(10);
		matrix.get(10).add(11);
		matrix.get(10).add(12);
		
		root = build(0);
		
		search(root);
	}
	TreeNode build(int r){
		TreeNode N = new TreeNode(r);
		System.out.println("node [ " + r + " ] created");
		for(int n:matrix.get(r)){
			N.nodes.add(build(n));
			System.out.println("node [ " + n + " ] added as child of ["+N.value+"]");
		}
		return N;
	}
	
	void search(TreeNode r){
		if(r.nodes.size() == 1){
			search(r.nodes.get(0));
			r.depth = r.nodes.get(0).depth+1;
			r.radius = r.depth;
			System.out.println("depth of node [" + r.value + "] = " + r.depth + ", radius of node = " + r.radius);
			
		}
		else if(r.nodes.size() == 0){
			return;
		}
		else{
			int tmp1 = 0;
			int tmp2 = 0;
			for(TreeNode n: r.nodes){
				System.out.println("searching node [" + n.value + "]");
				search(n);
				if(n.depth >= tmp1){
					tmp2 = tmp1;
					tmp1 = n.depth;
				}
			}
			r.depth = tmp1+1;
			r.radius = tmp1+tmp2+2;
			System.out.println("depth of node [" + r.value + "] = " + r.depth + ", radius of node = " + r.radius);
		}
	}
	
	class TreeNode{
		int parent;
		int value;
		ArrayList<TreeNode> nodes;
		int depth;
		int radius;
		public TreeNode(int r){
			value=r;
			depth=0;
			radius=0;
			nodes = new ArrayList<TreeNode>();
		}
	}
}
