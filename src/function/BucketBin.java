package function;

import java.util.Random;

public class BucketBin {
	int[] itemList;
	BTreeLight ocupy; 
	int binCount;
	int complexity;
	
	public BucketBin(){
		itemList = new int[20];
		binCount = 0;
		complexity=0;
		
		Random rand = new Random();
		ocupy=new BTreeLight();
		
		for(int i = 0;i<20;i++){
			itemList[i] = rand.nextInt(20);
		}
		
	}
	public void display(){
		System.out.println("item List:  " );
		for(int i = 0;i < 20; i++){
			System.out.print(itemList[i] + " , ");
		}
		System.out.println(" ");
		ocupy.traverse();
		System.out.println(" ");
	}
	
	public void fitsIn(){
		BTreeNodeLight BinIn = null;
		int BinInNewValue;
		for(int i = 0;i< 20; i++){
			BinIn = ocupy.checkBin(itemList[i]);
			System.out.println("next item in the queue: " + itemList[i]);
			if(BinIn==null){
				ocupy.insert(20-itemList[i]);
				this.binCount++;
				System.out.println("new bean created for item: " + itemList[i]);
			}
			else{
				System.out.print("bin :[ " + BinIn.value + " ] deleted and replaced");
				BinInNewValue =BinIn.value - itemList[i];
				System.out.println(" by [ " + BinInNewValue + " ] ");
				ocupy.delete(BinIn);
				ocupy.insert(BinInNewValue);
			}
			ocupy.traverse();
			System.out.println(" ");
		}
	}
	
	public int getBinCount(){
		return this.binCount;
	}
}
