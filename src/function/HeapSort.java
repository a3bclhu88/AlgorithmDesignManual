package function;

public class HeapSort {
	int[] array;
	int maxPointer;
	
	public HeapSort(){
		array = new int[32];
		for(int i = 0; i< 32;i++){
			array[i] = -1;
		}
		maxPointer = 1;
	}
	public void insert(int number){
		if(maxPointer<32){
			array[maxPointer]=number;
			popup(maxPointer);
			maxPointer++;
		}
		else{
			System.out.println("[ERROR]: the array is running out of space!");
		}
	}
	public void popMin(int number){
		System.out.println("[minimum pop]: minimum value is: [" + array[1]+ " ]");
		swap(1,--maxPointer);
		display();
		popdown(1);
		display();
	}
	public void popup(int index){
		if(index == 1){
			System.out.println("[Popup]: reaching begining of the list");
		}
		else{
			if(array[index] < array[index/2]){
				swap(index,index/2);
				System.out.println("[Popup]: swapping list [ " +index +" ] and [ " + index/2 + " ]");
				popup(index/2);
			}
			
			return;
		}
	}
	public void popdown(int index){
		
		if(index < this.maxPointer){
			if(index == 0){
				if(array[index+1] < array[index]){
					swap(index+1,index);
					System.out.println("[Popdown]: swapping list [ " +index +" ] and [ " + index+1 + " ]");
					popdown(index+1);
				}
			}	
			else{
				
				if(array[index*2] < array[index]){
					if(index*2 < maxPointer){
						swap(index*2,index);
						System.out.println("[Popdown]: swapping list [ " +index +" ] and [ " + index*2 + " ]");
						popdown(index*2);
					}
				}
				else if(array[index*2+1] < array[index]){
					if(index*2+1 < maxPointer){
						swap(index*2+1,index);
						System.out.println("[Popdown]: swapping list [ " +index +" ] and [ " + index*2+1 + " ]");
						popup(index*2+1);
					}
				}
			}
			return;
		}
		else{
			System.out.println("[Popdown]: reaching end of the list");
		}
	}
	void swap(int i,int j){
		int tmp = array[i];
		array[i]=array[j];
		array[j]=tmp;
	}
	public void display(){
		System.out.println("array content: ");
		for(int i = 1; i< 32; i++){
			System.out.print(array[i]+", ");
		}
		System.out.println("");
	}
}
