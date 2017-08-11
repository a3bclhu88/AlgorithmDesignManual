package main;

import function.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*k balance tree*/
		/*
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
		newtree.deleteK(4);
		System.out.println("complexity is :  " + newtree.getcomplexity());
		newtree.traverse();
		
		BTree newtree2 = new BTree(16);
		newtree2.insertTree(17);
		newtree2.insertTree(12);
		newtree2.insertTree(15);
		newtree2.insertTree(18);
		newtree2.insertTree(20);
		newtree2.insertTree(19);
		newtree2.insertTree(11);
		newtree2.insertTree(14);
		newtree2.insertTree(10);
		
		BTree Merged = BTree.concatenateTree(newtree, newtree2);
		Merged.traverse();*/
		/*find the smallest amout of buckets for a list of items	
		BucketBin newBB = new BucketBin();
		newBB.display();
		newBB.fitsIn();
		newBB.display();
		System.out.println(newBB.getBinCount());*/
		/*array range search on integers
		RangeStaticArray newArray = new RangeStaticArray();
		newArray.displayArray();
		newArray.buildRangeTree();
		newArray.searchMinRange(3, 3);*/
		
		O1ArrayManip ArrayPair = new O1ArrayManip();
		ArrayPair.insert(20);
		ArrayPair.insert(11);
		ArrayPair.insert(3);
		ArrayPair.insert(7);
		ArrayPair.insert(16);
		ArrayPair.insert(23);
		ArrayPair.delete(11);
		ArrayPair.delete(3);
	}

}
