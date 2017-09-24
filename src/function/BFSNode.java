package function;

import java.util.ArrayList;

public class BFSNode {
	int value;
	int Vcount;
	int depth;
	BFSNode reachableLimit;
	ArrayList<Integer> edges;
	boolean discovered;
	boolean processed;
	BFSNode parent;
	boolean fp;
	
	public BFSNode(int v){
		value = v;
		discovered=false;
		processed = false;
		depth = 0;
		reachableLimit = this;
		edges = new ArrayList<Integer>();
		fp = true;
	}
	void addEdge(int v){
		edges.add(v);
		System.out.println("    edge [ "+ v+" ] is added to node [ "+value+" ]");
	}
	void processEdge(int v){
		System.out.print("->[ " + v + " ]");
	}
	void preProcessNode(){
		
	}
	void postProcessNode(){
		if(this.value == 0){
			System.out.println("root node");
			if(this.edges.size()>1){
				System.out.println("this is a cut node");
			}
		}
		else{
			if(this.edges.size()<=1){
				System.out.println("["+ value+"] not a cut node");
			}
			else{
				if(this.reachableLimit == this || this.reachableLimit == this.parent){
					System.out.println("["+ value+"] this is a cut node");
				}
			}
		}
	}
}
