package function;

import java.util.ArrayList;
import java.util.LinkedList;

public class minVertexCoverage {
	ArrayList<ArrayList<Integer>> Tree;
	int[] color;
	int[] discovered;
	int[] processed;
	int[] depth;
	LinkedList<Integer> queue;
	
	public minVertexCoverage(){
		Tree = new ArrayList<ArrayList<Integer>>();
		color = new int[15];
		discovered = new int[15];
		queue = new LinkedList<Integer>();
		processed = new int[15];
		depth = new int[15];
		for(int i: color){
			i=-1;
		}
		for(int i: depth){
			i=0;
		}
		for(int i = 0; i<15;i++){
			Tree.add(new ArrayList<Integer>());
		}
		Tree.get(0).add(2);
		Tree.get(0).add(5);
		Tree.get(0).add(8);
		Tree.get(5).add(3);
		Tree.get(5).add(0);
		Tree.get(3).add(5);
		
		Tree.get(4).add(5);
		Tree.get(1).add(4);
		Tree.get(2).add(13);
		Tree.get(2).add(0);
		Tree.get(6).add(11);
		Tree.get(6).add(12);
		Tree.get(6).add(2);
		Tree.get(11).add(14);
		Tree.get(5).add(4);
		Tree.get(4).add(1);
		Tree.get(2).add(7);
		Tree.get(7).add(4);
		Tree.get(7).add(2);
		Tree.get(2).add(6);
		Tree.get(8).add(9);
		Tree.get(8).add(0);
		Tree.get(8).add(10);
		Tree.get(9).add(8);
		Tree.get(10).add(8);
		Tree.get(13).add(8);
		Tree.get(13).add(2);
		Tree.get(8).add(13);
		Tree.get(11).add(6);
		Tree.get(12).add(6);
		Tree.get(14).add(11);
		Tree.get(12).add(11);
		Tree.get(11).add(12);
		Tree.get(4).add(7);
		
		//coverage(0);
		queue.addLast(0);
		depth[0] = 0;findTriangle(0);
		//independence(0);
		/*for(int i = 0; i< color.length; i++){
			System.out.println(" ["+ i + "] of color ["+ color[i]+"]");
		}*/
		
	}
	
	void findTriangle(int r){
		discovered[r] = 1;
		for(int l:Tree.get(r)){
			if(discovered[l] == 1){
				if(depth[r]-depth[l] == 2){
					System.out.println("triangle found ["+ r + "] and [" + l + "]");
				}
			}
			else{
				depth[l] = depth[r] + 1;
				findTriangle(l);
			}
		}
	}
	
	void independence(int r){
		for(int l: Tree.get(r)){
			if(discovered[l]==0 ){
				if(color[r] == 1){
					color[l] = 2;
				}
				else{
					color[l] = 1;
				}
				discovered[l]=1;
				queue.addLast(l);
			}
			else{
				if(color[l] == color[r]){
					color[r] += 2;
					System.out.println("matching color [" + r + "] and [" + l + "]");
				}
				else{
					System.out.println("non-matching color [" + r + "] and [" + l + "]");
				}
			}
		}
		queue.removeFirst();
		if(queue.size() != 0){
			independence(queue.getFirst());
		}
	}
	
	void coverage(int r){
		discovered[r] = 1;
		System.out.println("item ["+r+"] discovered");
		for(int l: Tree.get(r)){
			if(discovered[l] == 0){
				coverage(l);
			}
		}
		if(Tree.get(r).size()==1){
			System.out.println("item ["+r+"] is leaf nodes, into 0");
			color[r]=0;
		}
		else{
			for(int l: Tree.get(r)){
				if(color[l]==0 && processed[l] ==1){
					System.out.println("item ["+r+"] has 0 child node, force into 1");
					color[r]=1;
					break;
				}
			}
		}
		processed[r]=1;
		System.out.println("item ["+r+"] processed");
	}
	 
	void diameter (int r){

	}
}
