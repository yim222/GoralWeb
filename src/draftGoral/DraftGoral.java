package draftGoral;

import java.util.ArrayList;
import java.util.Collections;

public class DraftGoral {
	
	
	public static void main(String[] args) {
		
		//do method that remove dupicate , assumed that the list is already sorted ( for not sorted it's differente)
		
		//if u want your list...
		int[] someNumbers = { 3, 302, 4097,7,7,7,7 ,8,8,8, 543,3,55,302,6,7,6,88,409};
		//take the array to arraylist
		ArrayList<Integer> arrayList = GoralPrimitive.someNumbersToList(someNumbers);
		Collections.sort(arrayList);
		System.out.println(arrayList);
		ArrayList<Integer> arrayList2 = arrayList;
		for(int i = 0; i <=100; i ++){
			
			
			
			
			//logic code : 
			/*
			 *if original index == checked index > remove checked index and check again 
			 *else (if not) original index = checked index and check it.
			 */
			
			
			//this is the condition for continue checking, and it's not last
			for (int original = 0; original < arrayList.size()-1; original++){
				int checkedIndex = original+1;
				for(  ;; ){
					if (arrayList.get(original).equals(arrayList.get(checkedIndex))){
						
						arrayList.remove(checkedIndex);
					}
					
					else{
						break;
					}
				
				}
				
				
				
				
			}
			System.out.println("hi\n "+arrayList);
			
			removeDuplicatesOL();
			
		}
		
	}
	//remove duplicates from Ordered list
	public static void removeDuplicatesOL(){
	
		//logic code : 
		/*
		 *if original index == checked index > remove checked index and check again 
		 *else (if not) original index = checked index and check it.
		 */
		
		
		//this is the condition for continue checking, and it's not last
	

		int[] someNumbers = { 3, 302, 4097,7,7,7,7 ,8,8,8, 543,3,55,302,6,7,6,88,409};
		//take the array to arraylist
		ArrayList<Integer> arrayList = GoralPrimitive.someNumbersToList(someNumbers);
		Collections.sort(arrayList);
		System.out.println(arrayList);		
	
	
		for (int original = 0; original < arrayList.size()-1; original++){
			int checkedIndex = original+1;
			for(  ;; ){
				if (arrayList.get(original).equals(arrayList.get(checkedIndex))){
					
					arrayList.remove(checkedIndex);
				}
				
				else{
					break;
				}
			
			}
			
			
			
			
		}
		System.out.println("hi\n "+arrayList);
		
		
		
	}
	
	
}
