package com.yimprogramming.dao;

import java.util.ArrayList;
import java.util.Arrays;

public class TestDao {
	
	
	public static void main(String[] args) {
		
		SingleDao obj1 = new SingleDao(3,10);
		
		System.out.println(obj1.obj1.getUserList());
		obj1.obj1.addNumbers(60, 70);

		System.out.println(obj1.obj1.getUserList());
		
		Integer[] someNumbers = {103, 42,  108};
		System.out.println("Adding the following single to the list : \n" + Arrays.toString(someNumbers));
		//List<Integer> l = Arrays.asList(someNumbers);
		ArrayList<Integer> someNumbers2 = new ArrayList<Integer>(Arrays.asList(someNumbers));
		obj1.obj1.addNumbers(someNumbers2);  
		System.out.println(obj1.obj1.getUserList());
		
		
	}
}
