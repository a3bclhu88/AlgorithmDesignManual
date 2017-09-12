package function;

import java.util.Random;

public class ArrayShift {
	int[] List;
	int shift;
	
	public ArrayShift(){
		List = new int[20];
		shift=3;
		Random rdm = new Random();
		for(int i = 0; i<20;i++){
			List[i] = i%15 + 10- i/2;
		}
		this.display();
		sort(0,19);
	}
	void sort(int start, int end){
		System.out.println("sorting on [ " + start + " ] and [ " + end + " ]");
		if(List[start] > List[end]){
			if((end-start) == 1 || (end-start) == 0){
				System.out.println("shift location is { " + end + " }");
				return;
			}
			else{
				if(end-start >=3){
					int t = (end-start)/3;
					start += t;
					end -= t;
				}
				else{
					start++;
					if((end-start) > 1){
						end--;
					}	
				}
				sort(start,end);
			}
		}
		else{
			if(end-start >=3){
				int t = (end-start)/3;
				start += t;
				end += t;
			}
			else{
				start++;
				end++;
			}
			sort(start,end);
		}
	}
	void display(){
		System.out.println("List content:");
		for(int i = 0; i<20;i++){
			System.out.print(List[i] + ", ");
		}
		System.out.println("");
	}
}
