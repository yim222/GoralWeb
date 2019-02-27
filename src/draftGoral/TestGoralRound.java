package draftGoral;

import java.util.ArrayList;
import java.util.Collections;
//here is the output of the program.
public class TestGoralRound {

	public static void main(String[] args) {
		System.out.println("check creating object with range");
		GoralRound goralRound = new GoralRound(206, 217);
		
		System.out.println(goralRound.getUserList());
		System.out.println("check addNumbers(int,int) with range (shaking is built-in)");
		goralRound.addNumbers(1000	, 1050);
		System.out.println(goralRound.getUserList());
		
		goralRound.shakeList();
		System.out.println("List after shake:(It's tested and was good , now it's already inside the methods...)\n" + goralRound.getUserList());
		
		//if u want your list...
		int[] someNumbers = { 3, 2, 409, 543,3,55};
		//take the array to arraylist
		ArrayList<Integer> arrayList = GoralPrimitive.someNumbersToList(someNumbers);
		
		System.out.println("\n\nchecking adding to the list the following number : " + arrayList);
		
		goralRound.addNumbers(arrayList);
		
		System.out.println("The list now : \n "+goralRound.getUserList());
		int[] someNumbers2 = {38 , 49, 5,58,64,1030,1049};
		
		arrayList = GoralPrimitive.someNumbersToList(someNumbers2);
		int from = 39 , to = 47;
		goralRound.removeNumbers(from, to);goralRound.removeNumbers(arrayList);
		
		System.out.println("\nChecking remove numbers by range from "+from+"to " + to+": \n "
				+ "\n Checking removing singles numbers as following: " + arrayList + "\n the list now :\n" +goralRound.getUserList()  );
		int randomsAmount = 6 ;
		
		goralRound.chooseNRandoms(randomsAmount);
		System.out.println("User want from the list " + randomsAmount + " randoms numbers: \n"
				+ goralRound.getRandomNumbers());
		
		System.out.println("\nTHis is work good !!! : ))");
		
		

	}

}
