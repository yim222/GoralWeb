package draftGoral;

import java.util.ArrayList;

public class Problem1 {
/*
 * GoralPrimitive.someNumbersToList(int[] someNumbers ) - For making list from array
 * excludeNumbers(ArrayList<Integer> list,ArrayList<Integer>  singleNumbers) - For showing the new list
 * ArrayList<Integer> rangeNumbersToList(int startRange, int endRange ) - for do list from range
 * 
 * To check 
 * 1- It's make out of bound in some condtion
 * 2- It's not remove numbers from any number...?v- From 128
 */
	public static void main(String[] args) {
		ArrayList<Integer> myList = GoralPrimitive.rangeNumbersToList(4	, 10);
		System.out.println("1- "+myList);
		int[] someNumbers = {6};
		ArrayList<Integer> removeList = GoralPrimitive.someNumbersToList(someNumbers);
		ArrayList<Integer> myList2 = GoralPrimitive.excludeNumbers(myList, removeList);
		System.out.println("2- "+myList2);
		myList.removeAll(removeList);
		System.out.println("3- "+myList);
		
	}
	
	
	
	
	
}
