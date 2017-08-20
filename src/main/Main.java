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
		/*Array O1 delete and insert*/
		/*
		O1ArrayManip ArrayPair = new O1ArrayManip();
		ArrayPair.insert(20);
		ArrayPair.insert(11);
		ArrayPair.insert(3);
		ArrayPair.insert(7);
		ArrayPair.insert(16);
		ArrayPair.insert(23);
		ArrayPair.delete(11);
		ArrayPair.delete(3);*/
		
		/* Tree to link list*/
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
		newtree.setMin();
		TreeToLinkList TK = new TreeToLinkList(newtree);
		TK.toList(newtree.getRoot());
		newtree.traverseFromMin();*/
		
		/*hash key word count*/
		/*HashDictionary Hash = new HashDictionary( "Harbingers now drop fewer stacks of currency shards, but these shards have reliably higher stack counts. This results in a higher total number of currency shards than before. Certain currency shards (like Transmutation Shards) now have higher stack sizes, but appear less frequently. Harbingers now appear more frequently in Map areas. More powerful Harbingers now appear more frequently. The volume of shards they drop has been increased, and they are also better dressed. You now need to complete 50 Harbinger End-game maps to complete the End Game Grind challenge (down from 100). Minions spawned by Harbingers were granted a resistance to all damage types that decayed over time. This is now multiplicative with other forms of damage taken. This change means they that can't be trivialised by Wither, Shock and other modifiers to damage taken. Harbingers are now less likely to enter a state where they don't summon new monsters. The Harbinger Flame Dash ability now Flame Dashes its minions to your location. The Harbinger Storm Call-like ability now attaches to the minions, moving with them. The Harbinger Flameblast ability is now stronger but used less often. The Harbinger Storm Cascade ability no longer stops at the Harbinger's minion's location. Instead, it will pass through, making it much more deadly for characters at a distance. Added several new abilities for the Harbingers to use. Be careful! The Harbingers from Act 6 onwards now have a chance to spawn an Obelisk when they summon monsters. These obelisks have a variety of skills. " );
		Hash.mapToDictionary();
		Hash.display();*/
		/*heap sort basic*/
		HeapSort sort= new HeapSort();
		sort.insert(7);
		sort.insert(9);
		sort.insert(2);sort.insert(4);
		sort.insert(10);sort.insert(1);
		sort.insert(3);sort.insert(6);
		sort.insert(5);
		sort.display();
		sort.popMin(0);
		sort.popMin(0);sort.popMin(0);sort.popMin(0);sort.popMin(0);sort.popMin(0);
	}

}
