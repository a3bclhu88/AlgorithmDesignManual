package main;

import function.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*k balance tree*/
		
		BTree newtree = new BTree(6);
		newtree.insertTree(7);
		newtree.insertTree(2);
		newtree.insertTree(5);
		newtree.insertTree(8);
		newtree.traverse();
	}

}
