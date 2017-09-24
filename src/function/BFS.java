package function;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.zip.Inflater;

public class BFS {
	int degree;
	BFSNode[] nodes;
	int Vcount;
	int Dcount;
	int Pcount;
	LinkedList<BFSNode> discovered;
	LinkedList<BFSNode> processed;
	LinkedList<BFSNode> Topological;
	
	public BFS(String s){
		nodes = new BFSNode[10];
		discovered = new LinkedList<BFSNode>();
		processed = new LinkedList<BFSNode>();
		Topological = new LinkedList<BFSNode>();
		String[] arr = s.split("\n",-1);
		for(int i = 0; i < arr.length; i++){
			String[] content = arr[i].split(";",-1);
			BFSNode BNode = new BFSNode(i);
			for(int j = 0; j< content.length;j++){
				BNode.addEdge(Integer.parseInt(content[j]));
			}
			this.add(BNode);
		}
		//this.display();
		discovered.addLast(nodes[0]);
		topologicalSearch(nodes[0]);
	}
	
	void add(BFSNode n){
		nodes[Vcount] = n;
		Vcount++;
		System.out.println("node [ " + n.value + " ] is added to the graph");
	}
	void BFSearch(BFSNode n){
		n.discovered = true;
	
		for(int edg: n.edges){
			n.processEdge(edg);
			if(!nodes[edg].discovered){
				discovered.addLast(nodes[edg]);
				nodes[edg].discovered = true;
				System.out.println("node ["+nodes[edg].value+"] added to the queue");
			}
			else{
				;
			}		
		}
		n.processed = true;
		processed.addLast(n);
		discovered.removeFirst();
		System.out.println("node ["+n.value+"] removed from the queue, remaining item {"+discovered.size() + "}");
		System.out.println("node ["+n.value+"] processed");
		for(BFSNode node:discovered){
			BFSearch(node);
		}
	}
	void DFSearch(BFSNode n){
		//System.out.println("processig node [ " + n.value + " ]");
		n.discovered=true;
		System.out.print(" discovered");
		n.preProcessNode();
		for( Integer edg: n.edges){
			n.processEdge(edg);
			if(!nodes[edg].discovered){
				nodes[edg].parent = n; 
				nodes[edg].depth = n.depth +1;
				
				System.out.print("{new track with parent ["+ nodes[edg].parent.value+"] }");
				DFSearch(nodes[edg]);
			}
			else{
				if(nodes[edg] != n.parent){
					System.out.print("{LOOP}");
					if(nodes[edg].depth < n.reachableLimit.depth){
						n.reachableLimit = nodes[edg];
					}
				}
				else{
					System.out.print("{second visit}");
				}
			}
		}
		System.out.println("back from node [ "+n.value +" ]");
		n.postProcessNode();
		n.processed = true;
		
	}
	void twoColor(BFSNode n){
		n.discovered = true;
		for(int edg: n.edges){
			if(!nodes[edg].discovered){
				discovered.addLast(nodes[edg]);
				nodes[edg].discovered = true;
				nodes[edg].fp = !n.fp;
			}
			else{
				if(n.fp == nodes[edg].fp){
					System.out.println("conflict found [" + n.value + "] and [" + nodes[edg].value + "]");
					
				}
				else{
					n.processEdge(edg);
				}
			}
		}
		n.processed = true;
		discovered.removeFirst();
		for(BFSNode node:discovered){
			twoColor(node);
		}
	}
	void display(){
		for(BFSNode n : nodes){
			System.out.println(" node [" + n.value + " ] have [ "+ n.edges.size() +" ] edgs");
		}
	}
	
	void topologicalSearch(BFSNode n){
		n.discovered = true;
		for(int edg: n.edges){
			if(!nodes[edg].discovered){
				topologicalSearch(nodes[edg]);
			}
		}
		n.processed = true;
		Topological.addFirst(n);
		System.out.println("topological sort: ");
		for(BFSNode no: Topological){
			System.out.print(no.value +" -> ");
		}
	}
}
