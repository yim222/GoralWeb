package draftGoral;
/*
 * 27/7/2016 
 * This is the primitive Methods that I did, I use it as service to other clears and organize classe
 * because it's not so organize and smart.
 * 
 * 
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class GoralPrimitive {
	//Try to debug and sharp what we have.
	
	
	private ArrayList<Integer> userList = new ArrayList<Integer >();
	
	//Ctor. - The Object get the values from out by other ArrayList.
	public GoralPrimitive(ArrayList<Integer> userList){
		
		
		this.userList = userList;
		
	}
	
	
	public ArrayList<Integer> getUserList() {
		return userList;
	}


	public void setUserList(ArrayList<Integer> userList) {
		this.userList = userList;
	}


	/**Good Mehtod :-) - Helper not affect on the fields
	//
	//return all the number that at the range.
	// incldue start and end
	 * End must be > start - if not - it's return null.
	  
	
	 * 
	 * @param startRange
	 * @param endRange
	 * @return
	 */
	 
	/**
	 * Good Method :) and very simple //isn't it un required ? maybe if there is more simple way
	 * or predefined method for this/ it's just convert int[] to ArrayList<Integer>

	Method for generate list from some numbers 
	 * @param someNumbers
	 * @return
	 * 
	 * TO FIX: 
	 * 1- maybe if there is duplicate values to drop them. Consideration is needed.
	 * 2- Maybe to do other parameters. U need something that is easy to pass, and if u gonna do it one by one so 
	 * why is needed arbitrary parameter? 
	 * 
	 * -Izhar: I change it to int[] we see if it do problem
	 */
	public static ArrayList<Integer> someNumbersToList(int[] someNumbers ){
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i : someNumbers){
			list.add(i);
			
		}
		
		
		return list;
	}
	
	
	
	/**
	 * /**Good Mehtod :-) - Helper not affect on the fields
	//
	//return all the number that at the range.
	// incldue start and end
	 * End must be > start - if not - it's return null.
	  
	 * 
	 * 
	 * @param startRange
	 * @param endRange
	 * @return
	 */
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
	
	/**
	 * Good method :)
	 * instance method - because it affects on the object
	 * @param list
	 * @param from
	 * @param to
	 * @return
	 */

	//Method that exclude from list all numbers at the range, include them - It's return value and don't affect on the field drectly.
	public static ArrayList<Integer> excludeNumbers(ArrayList<Integer> list,
			int from, int to){
		//case for wrong values
		if(!(from < to)){
			System.out.println("The end values must be larger than the start. please enter proper values");
			return null;
			
		}
		
		ArrayList<Integer> newList = new ArrayList<Integer>();
		for(Integer check : list){
			if(check < from || check > to){
				newList.add(check);
			}
			
		}
		return newList;
		
		
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
				
				//if(list.get(index)==i) {//XX
				if(list.get(index).equals(i)){// don't use == 
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

	
	
	
	
	
	
	
	/** method that's retrun "n" (specific amount) randoms from list
	 * no repitition
	//use with that : choosedNumbers(int amount, int bound), It use with chooseNumbers method
	 * TO FIX:
	 * 1 -chooseNumbers output values. it's not nessecay. So remove it/ 
	 * 
	 * */
	public static  ArrayList chooseNRandoms(ArrayList<Integer> list, int n){
		if (n > list.size()){
			System.out.println("There is "+list.size()+" elements at the list\n"
					+ "you trying to choose "+n+" values from it...\n"
					+ "You can't choose more values than list's elements.\n"
					+ "Please enter proper values..");
			return null;
		}
		
		//ArrayList for contain the new randoms that generated
		ArrayList<Integer> newRandoms = new ArrayList<Integer>();
		
		//array for contain all the randoms values
		int listIndexes[] = chooseNumbers(n, list.size());
		for(int i = 0; i< n;i++){
			newRandoms.add(list.get(listIndexes[i]));
			
		}
		
		
		
		return newRandoms;
	}
	
	
	
	
		
	

	/**
	 * THIS is Helper method so it static ? 
	 * 
	 * method for return and output specific amount of Randoms 
	//The values is always differnts.//There is output at this method//
	//0 include and bound not include
	 * 
	 */	
		// !!** Good method not change!!:-)
	public static int[] chooseNumbers(int amount, int bound){
			Random random = new Random();
			//case for entering bound that less from amount
			if(bound < amount){
				System.out.println("Impossible that the bound will be bigger than the amount \n"
						+ "pleas enter proper values...");
				return null;
			}
			
			int[] numbers = new int[amount];
			boolean wasZero = false;                  
			for(int i =0; i< numbers.length;i++){
				
				int randomValue = 0;
				
				boolean dontStop = false;
				while(!dontStop){
					//System.out.println("check");
					boolean alreadyTaken = false;
					randomValue =  random.nextInt(bound);
					//System.out.println(randomValue);
					for(int j = 0; j<=i; j++){
						if(numbers[j]==randomValue && randomValue != 0){
							alreadyTaken = true;
							break;
						}
						//case for 0
						else if(randomValue == 0 && wasZero ){
							alreadyTaken = true;
						}
						
						
					}
					if(alreadyTaken == false){
						dontStop = true;
					}
					
				
				}
				numbers[i] =randomValue;
				if(randomValue == 0){
					wasZero = true;
				}
				//case for identify number is needed here!!!- 7/6/16 - what I ment ? 
				// for out put - System.out.print(numbers[i] +" ");
			}
			return numbers;
		}
    		
	
	
	public static void main(String[] args) {
		
		System.out.println("Test:\n");
		
		//1-User choose the start / end values for initializing  list 
		int start = 5 ;
		int end   = 69;
		
		//2-Create ArrayList<Integr> for using to pass values to the Object
		ArrayList<Integer> myList = new ArrayList<Integer>();
		
		//3-Assign the primary list to myList by rangeNumbersToList(int startRange, int endRange )
		myList = rangeNumbersToList(start, end);
		ArrayList<Integer> myList2 = myList;
		//4-Creating Goral object.(u must wait until u have primary list to pass
		GoralPrimitive goralTest = new GoralPrimitive(myList);
		
		//Output
		System.out.println("Primary List - choosen by rang from "+ start +" to " + end
		+"\n"+goralTest.getUserList());
		
		//5-Creating list of single numbers(can be one too) by someNumbersToList(int[] someNumbers )
		int[] someNumbers = { 3, 302, 409, 543,3,55};
		
		//6-assign it to the list
		myList = someNumbersToList(someNumbers);
		
		//7-Adding the values to the Goral Object:
		//for add list to list just ust addAll newList.addAll(listTwo);
		goralTest.getUserList().addAll(myList);
		
		
		
		//output
		System.out.println("User want to add some more singles values that aren't at range as following:\n"
				+ myList + "\nList after adding the values: \n"+ goralTest.getUserList());
		
		System.out.println("\nBUG #1 - U need to remove duplicates , \nand reordered(fot the good order) the list...\n");
		
		//8-User choose the start/end values for initializing   list of range for excluding from the list
		start = 44; end = 52; 
		
		//9-Assign the above list to myList, again with rangeNumbersToList(int startRange, int endRange )
		 myList = rangeNumbersToList(start, end);
		
		 //10-exclude the list from the Object of Goral. by excludeNumbers(ArrayList<Integer> list,	int from, int to)
		 //unlike the include methods that work with outer list, here
		 //u define that range also inside the parameters. Maybe it's not so right to do - Lack of uniformity
		 
		 goralTest.excludeNumbers(goralTest.getUserList(), start, end);
		 
		
		 System.out.println("User want to exclude list of choosen by rang from "+  start+ " to " + end +" as following:\n "
		 		+ myList
		 		+"\nList after excluding the values: \n " + goralTest.getUserList() );
		 
		 //System.out.println(myList);
		 System.out.println("\nBUG #2 - This method don't work,\n"
		 		+ "also It doesn't need to get the list parameter from outside.");
		 
		 goralTest.userList = goralTest.excludeNumbers(goralTest.getUserList(), start, end);
		 
		System.out.println("Now it's work because that method is returning specific value and they are not change the field. "
				+ " U need to assign the value to the correct field.");
		
		
		//11-Here The user write the singles numbers that he want to exclude from the list:
		 int someNumbers2[] = {34 , 41, 47 };
		 myList = someNumbersToList(someNumbers2);
		 System.out.println("\nUser want to exclude list of choosen singles numbers as following:\n "
				 +myList);
		 goralTest.excludeNumbers(goralTest.getUserList(),myList);
		 System.out.println(goralTest.getUserList());
		 System.out.println("now it's not work because it's the same problem as above at excludeRange");
		 
		 goralTest.setUserList( goralTest.excludeNumbers(goralTest.getUserList(), myList) );
		 
		 System.out.println("now it's  work because I assign it the field:\n " + goralTest.getUserList());
		 
		 
		 
		 //12 -At last we do the lottery of specific amount of numbers for generatine randoms
		 //consideration at exceptions conditions is recommended
		 //13- choose amount of specific randoms
		 int randomsAmount = 5;
		 
		 System.out.println("\n Now after prepering the wanted list the user want to generate " + randomsAmount +" randoms"
		 		+ "numbers \ncheck 10 time that it's not generate numbers aren't in the list. "
		 		+ "\nFull testing is almost impossible and large testing is can be done by a lot of statics");
		 
		 System.out.println(goralTest.chooseNRandoms(goralTest.getUserList(), randomsAmount));
		 
		 
		 
		//***- for assign array[] to ArrayList:
		//ArrayList<Integer> myList = new ArrayList<Integer> (Arrays.asList(userList));
		 //or your method - myList = someNumbersToList(someNumbers);
		
		
		
		
		
		
		
		
		
		
		
		//System.out.println(goralTest.userList);
		
		
		
	}
	
}
