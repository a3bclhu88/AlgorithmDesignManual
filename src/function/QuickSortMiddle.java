package function;

import java.util.Random;

public class QuickSortMiddle {
	int[] list;
	
	int k;
	
	public QuickSortMiddle(){
		list = new int[12];
		Random rdm = new Random();
		for(int i = 0; i< list.length; i++){
			list[i] = rdm.nextInt(10);
		}
	}
	
	public void quick(int[] AList, int from, int to){
		int high = 0;
		int partition = AList[AList.length/2];
		for(int i = 0;i< AList.length;i++){
			if(AList[i] > partition){
				swap(AList,i,high);
			}
			else{
				high++;
				swap(AList,i,high);
			}
		}
		if(high > AList.length/2-1){
			
		}
		else if(high < AList.length/2-1){
			
		}
		else{
			System.out.println("found the mid value item : " + AList[high]);
		}
	}
	public int partition(int[] AList, int value){
		return 0;
	}
	public void swap(int[] arr, int i, int j){
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
}
