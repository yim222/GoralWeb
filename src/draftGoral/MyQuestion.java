package draftGoral;

import java.util.ArrayList;
import java.util.Collections;

import javax.security.auth.callback.ChoiceCallback;

public class MyQuestion {
	
	public static ArrayList<Integer> someNumbersToList(int[] someNumbers ){
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i : someNumbers){
			list.add(i);
			
		}
		
		
		return list;
	}
	
	public static ArrayList<Integer> rangeNumbersToList(int startRange, int endRange ){
		//case for end not bigger than start 
		if(!(startRange < endRange) ){
			System.out.println("The end range must to be larger than start range,\n"
					+ "please enter proper values");
			return null;
		}
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i = startRange; i <= endRange; i++){
			list.add(i);
		}
		
		
		
		
		
		return list;
	}
	
	public static ArrayList<Integer> excludeNumbers(ArrayList<Integer> list,
				
				ArrayList<Integer>  singleNumbers){
			
			//case for problem:
			if (singleNumbers.size()>= list.size()){
				System.out.println("singleNumbers.length >= list.size()");
				return null;
				
			}
			
			
			Collections.sort(singleNumbers);
			
			int index = 0;
			for(Integer i : singleNumbers){
				
				while(true){
					
					if(list.get(index)==i) {
						list.remove(index);
						break;
						
					}
					else if(list.get(index) > i && index != 0){
						index -= 1;
						break;
					}
					else{
						index++;
					}
				}
				
				
				
			}
			
			
			
			return list;
		}

	public static void checkProblem(int from , int to, int[] someNumbers) {
		ArrayList<Integer> myList = GoralPrimitive.rangeNumbersToList(from, to);
		System.out.println("1-Primary List  "+myList);
		//int[] someNumbers = {6,7,8};
		
		ArrayList<Integer> removeList = someNumbersToList(someNumbers);
		
		System.out.println("trying to remove : " + removeList);
		ArrayList<Integer> myList2 = excludeNumbers(myList, removeList);
		System.out.println("2- New List"+myList2);
		
	}
	
	public static void main(String[] args) {
		
		int[] someNumbers1 = {5,7,8, 12};
		checkProblem(4, 20, someNumbers1);
		
		
		System.out.println("\nThis worked well, but the following not work :\n");
		int[] someNumbers2 = {125,200,305,128,446,127,128};
		checkProblem(120, 500, someNumbers2);
		
		
		
	}
	
}
