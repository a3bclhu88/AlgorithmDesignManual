package function;

import java.util.HashMap;

public class HashDictionary {
	
	HashMap<String,Integer> wordDic;
	
	String text;
	
	public HashDictionary(String s){
		wordDic = new HashMap<String,Integer>();
		text = s;
	}
	
	public void display(){
		wordDic.forEach((k,v) -> System.out.println("word " + k + " appeared for [" + v + " ] times"));
	}
	
	public void mapToDictionary(){
		String previousWord="";
		String currentWord="";
		while(text.length()>0){
			currentWord = findWord();
			System.out.println("   previous word ["+previousWord +"]" );
			System.out.println("   current word ["+currentWord +"]" );
			if(wordDic.containsKey(previousWord + " " + currentWord)){
				
				int currentCount = wordDic.get(previousWord + " " + currentWord);
				wordDic.remove(previousWord + " " + currentWord);
				wordDic.put(previousWord + " " + currentWord, currentCount+1);
			}
			else{
				wordDic.put(previousWord + " " + currentWord, 1);
			}
			previousWord = currentWord;
		}
	}
	public String findWord(){
		if(this.text.contains(" ")){
			String returnValue = this.text.substring(0,text.indexOf(' ')+1);
			System.out.println("       text index of space ["+text.indexOf(' ') +"]" );
			this.text= this.text.substring(text.indexOf(" ")+1,text.length());
			System.out.println("       word retrival: " + returnValue);
			return returnValue;
		}
		else
			return text;
	}
}
