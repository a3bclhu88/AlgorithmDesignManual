package function;

import java.util.Random;

public class MaxMinDiff {
	int[][] list;
	int pos1;
	int eps1;
	int pos2;
	int eps2;
	int pos0;
	int eps0;
	public MaxMinDiff(){
		Random rdm = new Random();
		list = new int[20][2];
		for(int i = 0;i<20;i++){
			list[i][1] = rdm.nextInt(3);
			list[i][0] = rdm.nextInt(20);
		}
		
		pos1=-1;
		pos2=-1;
		pos0=-1;
		eps0=-1;
		eps2=-1;
		eps1=-1;
	} 
	
	public void display(){
		System.out.println("array content: ");
		for(int i = 0;i<20;i++){
			System.out.print(list[i][0]+",");
		}
		System.out.println("");
		for(int i = 0;i<20;i++){
			System.out.print(list[i][1]+",");
		}
		System.out.println("");
		System.out.println("pos0 : { " + pos0 + " } pos1 : { " + pos1 + " } pos2: {" + pos2 + " }");
		System.out.println("eps0 : { " + eps0 + " } eps1 : { " + eps1 + " } eps2: {" + eps2 + " }");
	}
	
	public void sort(){
		
		for(int i = 0;i<20;i++){
			this.display();
			System.out.println("itertion: [ " + i + " ]");
			if(list[i][1]==0){
				if(pos1<=i && pos1 >= 0){
					if(pos2 <=i && pos2 >=pos1){
						if(pos0<0){
							pos0 = 0;
						}
						swap(i,pos1);
						swap(pos2,i);
						pos2++;
						pos1++;
						eps0++;
						eps1++;
						eps2++;
						continue;
					}
					if(pos2<0){
						if(pos0<0){
							pos0 = 0;
						}
						swap(i,pos1);
						pos1++;
						eps0++;
						eps1++;
						continue;
					}
				}
				else{
					if(pos2<=i && pos2 >=0){
						if(pos0<0){
							pos0 = 0;
						}
						swap(i,pos2);
						pos2++;
						eps0++;
						eps2++;
						continue;
					}
					if(pos0<0){
						pos0 = 0;
					}
					eps0++;
				}
				
			}
			else if(list[i][1] == 1){
				
				if(pos2 >=0 && pos2 <= i){
					if(pos1 < 0){
						pos1 = eps0+1;
					}
					swap(i,pos2);
					pos2++;
					eps2++;
					eps1++;
					continue;
				}
				else{
					if(pos1<0){
						pos1 = eps0+1;
						eps1=pos1;
						continue;
					}
					eps1++;
				}
				
				continue;
			}
			else{
				if(pos2<0){
					if(pos1>=0){
						pos2 = eps1+1;
					}
					else{
						pos2 = eps0+1;
					}
				}
				eps2++;
			}
		}
	}
	
	public void swap(int i, int j){
		int tmp1 = list[j][0];
		int tmp2 = list[j][1];
		
		list[j][0] = list[i][0];
		list[j][1] = list[i][1];
		
		list[i][0] = tmp1;
		list[i][1] = tmp2;
	}
}
