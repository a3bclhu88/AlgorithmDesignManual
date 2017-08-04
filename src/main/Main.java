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
		newtree.insertTree(10);
		newtree.insertTree(9);
		newtree.insertTree(1);
		newtree.insertTree(4);
		newtree.insertTree(0);
		newtree.traverse();
		newtree.check(3);
		newtree.check(8);
		newtree.deleteN(3);
		System.out.println("complexity is :  " + newtree.getcomplexity());
		newtree.traverse();
	}

}
