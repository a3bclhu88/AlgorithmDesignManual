package main;

import function.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*k balance tree*/
		
		KBalanceTree newtree = new KBalanceTree();
		newtree.insert(newtree, 6, null);
		newtree.insert(newtree, 1, null);
		newtree.insert(newtree, 3, null);
		
		newtree.traverse(newtree);
	}

}
