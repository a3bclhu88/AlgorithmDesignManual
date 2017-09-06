package function;

import java.util.Iterator;
import java.util.Random;
import java.util.Stack;


public class KSUMList {
	int[] list;
	int k;
	int sum;
	Stack<Integer> buffer;
	
	
	public KSUMList(){
		list = new int[6];
		k = 3;
		sum = 15;
		buffer = new Stack<Integer>();
		
		Random rdm = new Random();
		for(int i = 0; i< 6;i++){
			list[i] = rdm.nextInt(10);
		}
		this.display();
		checksum(list,k,sum);
	}
	
	public void display(){
		System.out.println("list content: ");
		for(int i = 0; i< 6;i++){
			System.out.print(list[i] + " , ");
		}
		System.out.println("");
	}

	public boolean checksum(int[] AList, int c, int SUM){
		System.out.println("the current c is { " + c + " }");
		System.out.println("currnt sum : "+ SUM);
		if(c==1){
			for(int i = 0; i< AList.length;i++){
				if(AList[i] == SUM){
					System.out.println("Matching Found!");
				}
			}
			System.out.println("Matching failed, return to upper level!");
			return false;
		}
		else{
			for(int i = 0; i< AList.length;i++){
				int r = 0;
				System.out.println("iteration : [ "+i+ " ]");
				int[] BList = new int[AList.length-1];
				for(int j = 0; j<AList.length ; j++){
					if(i!=j){
						BList[r] = AList[j];
						r++;
					}
				}
				System.out.println("Content of BList : ");
				for(int p = 0; p<BList.length; p++){
					System.out.print(BList[p] + " , ");
				}
				System.out.println();
				if(checksum(BList,c-1,SUM-AList[i]))
					return true;
				continue;
			}
		}
		return false;
	}
	void pop(){
		
	}
	boolean search(int n){
		Iterator<Integer> itr = buffer.iterator();
		while(itr.hasNext()){
			if(n==itr.next()){
				return true;
			}
		}
		return false;
	}
	
	int remains(){
		Iterator<Integer> itr = buffer.iterator();
		int currentSum = 0;
		while(itr.hasNext()){
			currentSum += itr.next();
		}
		return sum-currentSum;
	}
}
