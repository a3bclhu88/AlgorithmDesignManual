package function;

public class RangeTree {
	int minValue;
	RangeTree leftNode;
	RangeTree rightNode;
	RangeTree leftParent;
	RangeTree rightParent;
	RangeTree lastNeighbor;
	RangeTree nextNeighbor;
	RangeTree parent;
	int lowRange;
	int highRange;
	
	RangeStaticArray segementTree;
	
	RangeTree(int num){
		minValue = num;
	}
	RangeTree(){
		;
	}
	
	void insert(RangeTree newLeaf, int currentIndex){
		RangeTree currentLastLeaf;
		newLeaf.highRange= currentIndex;
		newLeaf.lowRange = currentIndex;
		
		currentLastLeaf = this.findLastLeaf();
		
		currentLastLeaf.nextNeighbor = newLeaf;
		
		RangeTree currentThis = currentLastLeaf;
		RangeTree currentNewLeaf = newLeaf;
		
		for(int i =  0;i<currentIndex;i++){
			int adcentValue;
			
			if(currentThis.minValue < currentNewLeaf.minValue){
				adcentValue = currentThis.minValue;
				System.out.println(" -- value of adcent node is decided as : " + adcentValue);
			}
			else{
				adcentValue = currentNewLeaf.minValue;
				System.out.println(" -- value of adcent node is decided as : " + adcentValue);
			}
			RangeTree newAdcent = new RangeTree(adcentValue);
			System.out.println("new adcent node is created as : " + adcentValue);
			newAdcent.leftNode=currentThis;
			System.out.println("  --- left link of the adcent is defined as : " + currentThis.minValue);
			newAdcent.rightNode=currentNewLeaf;
			System.out.println("  --- right link of the adcent is defined as : " + currentNewLeaf.minValue);
			currentThis.rightParent=newAdcent;
			System.out.println("  --- right link of the new leaf node is defined as : " + adcentValue);
			currentNewLeaf.leftParent=newAdcent;
			System.out.println("  --- left link of the adcent is defined as : " + adcentValue);
			newAdcent.highRange=currentNewLeaf.highRange;
			System.out.println("  --- high range of adcent is defined as : " + newAdcent.highRange);
			newAdcent.lowRange=currentThis.lowRange;
			System.out.println("  --- low range of adcent is defined as : " + newAdcent.lowRange);
			
			if(currentThis.leftParent == null){
				System.out.println("reaching top of the tree");
				break;
			}
			else{
				System.out.println("shifting current temp variable up level");
				currentThis=null;
				currentThis=currentThis.leftParent;
				currentNewLeaf = newAdcent;
			}
		}
	}
	void delete(){
		
	}
	void traverse(){
		
	}
	void traverseLeafs(){
		System.out.print(this.minValue + " , ");
		if(this.nextNeighbor!=null){
			this.nextNeighbor.traverseLeafs();
		}
	}
	RangeTree findLastLeaf(){
		if(this.nextNeighbor==null){
			return this;
		}
		else{
			return this.nextNeighbor;
		}
	}
}
