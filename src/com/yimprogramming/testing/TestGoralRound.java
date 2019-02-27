package com.yimprogramming.testing;
import java.util.ArrayList;
import java.util.Arrays;

import com.yimprogramming.core.*;
public class TestGoralRound {
	
	public static void main(String[] args) {
		
		int from, to;
		from = 5; to = 40;
		System.out.println("Creating list from " + from + " to " + to);
		GoralRound obj1 = new GoralRound(from	,to);
		
		
		
		System.out.println("current list = \n" + obj1.getUserList());
		from = 50; to = 100;
		System.out.println();
		System.out.println("adding new range to  list from " + from + " to " + to);
		obj1.addNumbers(from, to);
		System.out.println("current list = \n" + obj1.getUserList());
		
		System.out.println();
		Integer[] someNumbers = {103, 42,  108};
		System.out.println("Adding the following single to the list : \n" + Arrays.toString(someNumbers));
		//List<Integer> l = Arrays.asList(someNumbers);
		ArrayList<Integer> someNumbers2 = new ArrayList<Integer>(Arrays.asList(someNumbers));
		obj1.addNumbers(someNumbers2);  
		System.out.println("current list = \n" + obj1.getUserList());
		
		System.out.println();
		
		from = 31; to =35;
		System.out.println("removing  range from the   list from " + from + " to " + to);
		obj1.removeNumbers(from, to);
		System.out.println("current list = \n" + obj1.getUserList());
		
		someNumbers = new Integer[] {7, 75,  16};
		System.out.println("removing the following singles from the list : \n" + Arrays.toString(someNumbers));
		//List<Integer> l = Arrays.asList(someNumbers);
		someNumbers2 = new ArrayList<Integer>(Arrays.asList(someNumbers));
		obj1.removeNumbers(someNumbers2);  
		System.out.println("current list = \n" + obj1.getUserList());
		
		System.out.println();
		
		int drawnsAmnt = 5;
		System.out.println("Amount of drawns number = " + drawnsAmnt);
		ArrayList<Integer> drawnsNumbers = 
		obj1.chooseNRandoms(drawnsAmnt);
		System.out.println("The drawn numbers is : \n" + drawnsNumbers);
		
		System.out.println();
		System.out.println("Draw again : ");
		drawnsNumbers = obj1.chooseNRandoms(drawnsAmnt);
		System.out.println("The drawn numbers is : \n" + drawnsNumbers);
		
		System.out.println();
		System.out.println("Draw again : ");
		drawnsNumbers = obj1.chooseNRandoms(drawnsAmnt);
		System.out.println("The drawn numbers is : \n" + drawnsNumbers);
		
		System.out.println();
		System.out.println("Draw again : ");
		drawnsNumbers = obj1.chooseNRandoms(drawnsAmnt);
		System.out.println("The drawn numbers is : \n" + drawnsNumbers);
				
		
		
	}
}
