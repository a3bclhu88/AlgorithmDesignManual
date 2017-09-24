package function;

import java.util.Arrays;
import java.util.Comparator;

public class stringfriend {
	
		public stringfriend(){
			String[] wordList = {"teacher","lift","reses","reess","fill","cheater","opes","frtyi","lils"};
			String[] results = friendlyWords(wordList);
			for(String item: results){
				System.out.println(item);
			}
		}
	   static String[] friendlyWords(String[] wordList) {
	        int currentHash = 0;
	        int currentIndex = 0;
	        int[][] hashTable = new int[wordList.length][2];
	        for(int i = 0;i<wordList.length;i++){
	            hashTable[i][1] = hash(wordList[i]);
	            hashTable[i][0] = i;
	        }
	        
	        for(int i = 0;i<wordList.length;i++){
	        	System.out.println(i + "],[" + hashTable[i][1]);
	        }
	       
	       Arrays.sort(hashTable, Comparator.comparing((int[] arr) -> arr[1]));
	       
	       for(int i = 0;i<wordList.length;i++){
	        	System.out.println(hashTable[i][0] + "],[" + hashTable[i][1]);
	        }
	       
	       
	        String[] hashtable2 = new String[wordList.length];
	        hashtable2[0] = wordList[hashTable[0][0]];
	        currentHash = hashTable[0][1];
	        for(int i = 1;i<wordList.length;i++){
	            if(currentHash == hashTable[i][1]){
	            	hashtable2[currentIndex] += wordList[hashTable[i][0]] + " ";
	            }
	            else{
	            	currentIndex++;
	            	currentHash = hashTable[i][1];
	            	hashtable2[currentIndex] = wordList[hashTable[i][0]] + " ";
	            }
	        }     
	        return hashtable2;
	    }

	    static int hash(String input){
	        input = input.toLowerCase();
	        char[] arr = input.toCharArray();
	        int hashValue = 0;
	        for(char character: arr){
	            hashValue += (int)(character-'a');
	        }
	        hashValue *= input.length();
	        return hashValue;
	    }
}
