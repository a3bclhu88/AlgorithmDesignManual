package function;

import java.util.Random;

public class MergeNList {

	int[] list1;
	int[] list2;
	int[] list3;
	int[] list4;
	int[] list5;
	int[] list6;
	int[] list7;
	
	int[] buffer;
	int[] result;
	int bufferIndex;
	
	int l1p;
	int l2p;
	int l3p;
	int l4p;
	int l5p;
	int l6p;
	int l7p;
	
	public MergeNList(){
		list1 = new int[11];
		list2 = new int[11];
		list3 = new int[11];
		list4 = new int[11];
		list5 = new int[11];
		list6 = new int[11];
		list7 = new int[11];
		buffer = new int[7];
		result = new int[70];
		
		l1p = 0;
		l2p = 0;
		l3p = 0;
		l4p = 0;
		l5p = 0;
		l6p = 0;
		l7p = 0;
		
		bufferIndex = 6;
		
		Random rdm = new Random();
		list1[0] = 3;
		list2[0] = 1;
		list3[0] = 4;
		list4[0] = 2;
		list5[0] = 6;
		list6[0] = 0;
		list7[0] = 3;
		list1[10] = 999;
		list2[10] = 999;
		list3[10] = 999;
		list4[10] = 999;
		list5[10] = 999;
		list6[10] = 999;
		list7[10] = 999;
		for(int i = 1;i<10;i++){
			list1[i] = list1[i-1] + rdm.nextInt(6);
			list2[i] = list2[i-1] + rdm.nextInt(5);
			list3[i] = list3[i-1] + rdm.nextInt(7);
			list4[i] = list4[i-1] + rdm.nextInt(5);
			list5[i] = list5[i-1] + rdm.nextInt(8);
			list6[i] = list6[i-1] + rdm.nextInt(9);
			list7[i] = list7[i-1] + rdm.nextInt(6);
		}
		for(int i = 0; i < 7; i++){
			buffer[i] = -1;
		}
		this.display();
	}
	
	public void sort(){
		int index;
		for(int i = 0;i<7;i++){
			 push( i+1);
		}
		this.displayBuffer();
		for(int i = 0; i<70;i++){
			index = pop();
			result[i] = arr(index)[arp(index)];
			this.displayBuffer();
			System.out.println("new value added as [ " + (index+1) + " ] list item [ " + arp(index) +  " ] position");
			if(arp(index) < 10){
				arpPlus(index);
				push(index);
			}
		}
	}
	public void push(int n){
		buffer[6] = n;
		bubbleup(6);
	}
	public int pop(){
		int popValue = buffer[0];
		buffer[0] = buffer[6];
		bubbledown(0);
		return popValue;
	}
	public int[] arr(int i){
		switch(i){
		case 1:return list1;
		case 2:return list2;
		case 3:return list3;
		case 4:return list4;
		case 5:return list5;
		case 6:return list6;
		case 7:return list7;
		}
		return buffer;
	}
	void bubbleup(int n){
		System.out.print("Bubble up position : [ " + n+ " ] ");
		this.displayBuffer();
		if(n<=0){
				return;
		}
		else{
			if(buffer[(n+1)/2-1] ==-1){
				System.out.println("Scenario 0");
				swap(buffer,n,(n+1)/2-1);
				bubbleup((n+1)/2-1);
			}
			else{
				if(arr(buffer[n])[arp(n)]< arr(buffer[(n+1)/2-1])[arp((n+1)/2-1)]){
					System.out.println("Scenario 1");
					swap(buffer,n,(n+1)/2-1);
					bubbleup((n+1)/2-1);
				}
				if(n<3 && arr(buffer[n])[arp(n)] > arr(buffer[n*2+1])[arp(n*2+1)]){
					System.out.println("Scenario 2");
					bubbledown(n);
				}
				if(n<3 && arr(buffer[n])[arp(n)] > arr(buffer[n*2+2])[arp(n*2+2)]){
					System.out.println("Scenario 3");
					bubbledown(n);
				}
				else{
					System.out.println("Scenario Match");
					return;
				}
			}
			
		}
	}
	void bubbledown(int n){
		System.out.print("Bubble down position : [ " + n+ " ] ");
		this.displayBuffer();
		if(n>6){
			return;
		}
		if(buffer[n*2+1] ==-1 || buffer[n*2+2] == -1){
			return;
		}
		if(n>0){
			if(arr(buffer[n])[arp(n)]< arr(buffer[(n+1)/2-1])[arp((n+1)/2-1)]){
				System.out.println("Scenario -0");
				bubbleup(n);
			}
		}
		if(n<3 && arr(buffer[n])[arp(n)] > arr(buffer[n*2+1])[arp(n*2+1)]){
			System.out.println("Scenario -1");
			swap(buffer,n,n*2+1);
			bubbledown(n*2+1);
		}
		if(n<3 && arr(buffer[n])[arp(n)] > arr(buffer[n*2+2])[arp(n*2+2)]){
			System.out.println("Scenario -2");
			swap(buffer,n,n*2+2);
			bubbledown(n*2+2);
		}
		else{
			System.out.println("Scenario -3");
			return;
		}
	}
	void swap(int[] array, int i , int j){
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}
	public void display(){
		for(int j = 0;j<7;j++){
			System.out.println("content of list " + (j+1)+ " : ");
			for(int i = 0;i<11;i++){
				System.out.print(arr(j+1)[i]+" , ");
			}
			System.out.println("");
		}
	}
	
	public void displayBuffer(){
		System.out.println("content of buffer: ");
		for(int i = 0;i< 7; i++){
			System.out.print(buffer[i]+ " , ");
		}
		System.out.println("");
	}
	
	int arp(int n){
		switch(n){
		case 1:return l1p;
		case 2:return l2p;
		case 3:return l3p;
		case 4:return l4p;
		case 5:return l5p;
		case 6:return l6p;
		case 7:return l7p;
		}
		return 0;
	}
	void arpPlus(int n){
		switch(n){
		case 1:l1p++;
		case 2:l2p++;
		case 3:l3p++;
		case 4:l4p++;
		case 5:l5p++;
		case 6:l6p++;
		case 7:l7p++;
		}
	}
}
