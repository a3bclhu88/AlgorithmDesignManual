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
	
	RangeTree insert(RangeTree newLeaf, int currentIndex){
		RangeTree currentLastLeaf;
		newLeaf.highRange= currentIndex;
		newLeaf.lowRange = currentIndex;
		
		currentLastLeaf = this.findLastLeaf();
		System.out.println(" -- value of current last leaf is : " + currentLastLeaf.minValue);
		
		currentLastLeaf.nextNeighbor = newLeaf;
		
		RangeTree currentThis = currentLastLeaf;
		RangeTree currentNewLeaf = newLeaf;
		
		return RangeTreeBuildup(currentThis,currentNewLeaf);
	}
	void delete(){
		
	}
	void traverse(){
		
	}
	void searchMinRange(int j, int k){
		if(this.leftNode==null && this.rightNode==null){
			System.out.println("minimum value found : [ " + this.minValue + " ]");
			return;
		}
		else{
			if(j == this.lowRange && k == this.highRange){
				System.out.println("minimum value found : [ " + this.minValue + " ]");
				return;
			}
			else{
				if(j >= this.lowRange){
					if(k > this.highRange)
						this.rightNode.searchMinRange(j, k);
					else
						this.leftNode.searchMinRange(j, k);
				}
				else{
					if( k <= this.highRange)
						this.leftNode.searchMinRange(j, k);
					else{
						System.out.println("minimum value found : [ " + this.minValue + " ]");
					}
				}
			}
		}
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
			return this.nextNeighbor.findLastLeaf();
		}
	}
	RangeTree RangeTreeBuildup(RangeTree leaf1, RangeTree leaf2){
		int adcentValue;
		
		if(leaf1.minValue < leaf2.minValue){
			adcentValue = leaf1.minValue;
			System.out.println(" -- value of adcent node is decided as : " + adcentValue);
		}
		else{
			adcentValue = leaf2.minValue;
			System.out.println(" -- value of adcent node is decided as : " + adcentValue);
		}
		RangeTree newAdcent = new RangeTree(adcentValue);
		System.out.println("new adcent node is created as : " + adcentValue);
		newAdcent.leftNode=leaf1;
		System.out.println("  --- left link of the adcent is defined as : " + leaf1.minValue);
		newAdcent.rightNode=leaf2;
		System.out.println("  --- right link of the adcent is defined as : " + leaf2.minValue);
		leaf1.rightParent=newAdcent;
		System.out.println("  --- right link of the new leaf node is defined as : " + adcentValue);
		leaf2.leftParent=newAdcent;
		System.out.println("  --- left link of the adcent is defined as : " + adcentValue);
		newAdcent.highRange=leaf2.highRange;
		System.out.println("  --- high range of adcent is defined as : " + newAdcent.highRange);
		newAdcent.lowRange=leaf1.lowRange;
		System.out.println("  --- low range of adcent is defined as : " + newAdcent.lowRange);
		
		if(leaf1.leftParent == null){
			System.out.println("reaching top of the tree");
			return newAdcent;
		}
		else{
			System.out.println("shifting current temp variable up level");
			return RangeTreeBuildup(leaf1.leftParent,newAdcent);
		}
		
	}
}
