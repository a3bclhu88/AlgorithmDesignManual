package function;

import java.util.Random;

public class N2Jobs {
	int[] list;
	
	public N2Jobs(){
		list = new int[20];
		Random rdm = new Random();
		for(int i = 0; i<20 ; i++){
			list[i] = rdm.nextInt(25);
		}
	}
	
	public void sort(int low, int high){
		System.out.println("sort with low: [ " + low + " ] high : [ " + high + " ]");
		if(low >= high){
			this.display();
			return;
		}
		else{
			int mid = partition(low, high);
			sort(low,mid-1);
			sort(mid+1,high);
		}
	}
	int partition(int low, int high){
		int i = low;
		int j = low;
		int tmp;
		while(i < high && j < high){
			System.out.println("comparing item { "+ i+" } value [ " + list[i] + " ] with item { "+ high + " } value [ "+ list[high]+ " ]");
			if(list[i]>= list[high]){
				System.out.println("swapping item { "+ i + " } value [ "+ list[i] + " ] and item { " + j + " } value [ "+ list[j] + " ] ");
				tmp = list[j];
				list[j] = list[i];
				list[i] = tmp;
				j++;
				i++;
				System.out.println("j incremented by 1 to "+ j);
				continue;
			}
			System.out.println("swapping item { "+ i + " } value [ "+ list[i] + " ] and item { " + j + " } value [ "+ list[j] + " ] ");
			tmp = list[j];
			list[j] = list[i];
			list[i] = tmp;
			i++;
		}
		int tmp1 = list[high];
		list[high] = list[j];
		list[j] = tmp1;
		return j;
	}
	public void display(){
		System.out.println("array value:");
		for(int i = 0; i< 20; i++){
			System.out.print( list[i]+",");
		}
		System.out.println("");
	}
}
