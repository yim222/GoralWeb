package draftGoral;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
//Class that contain the basic methods for the action of GORAL
public class GoralReadyMethods {
	
	
	
	
	
	/**
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
				System.out.print(numbers[i] +" ");
			}
			return numbers;
		}
		
		
		/** method that's retrun "n" (specific amount) randoms from list
		 * no repitition
		//use with that : choosedNumbers(int amount, int bound)
		 * TO FIX:
		 * 1 -chooseNumbers output values. it's not nessecay. So remove it/ 
		 * 
		 * */
		public static ArrayList chooseNRandoms(ArrayList<Integer> list, int n){
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
		
		
		
		/**Good Mehtod :-) 
		//
		//return all the number that at the range.
		// incldue start and end
		 * End must be > start - if not - it's return null.
		  
		
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
		 * Good Method :) and very simple //isn't it un required ? maybe if there is more simple way
		 * or predefined method for this/ it's just convert int[] to ArrayList<Integer>

		Method for generate list from some numbers 
		 * @param someNumbers
		 * @return
		 * 
		 * TO FIX: 
		 * 1- maybe if there is duplicate values to drop them. Consideration is needed.
		 */
		public static ArrayList<Integer> someNumbersToList(int... someNumbers ){
			ArrayList<Integer> list = new ArrayList<Integer>();
			for (int i : someNumbers){
				list.add(i);
				
			}
			
			
			return list;
		}
		
		/**
		 * Good method :)
		 * 
		 * @param list
		 * @param from
		 * @param to
		 * @return
		 */
	
		//Method that exclude from list all numbers at the range, include them 
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
		
		//Good Method - exclude single numbers :-)
		public static ArrayList<Integer> excludeNumbers(ArrayList<Integer> list,
			
				Integer... singleNumbers){
			
			//case for problem:
			if (singleNumbers.length >= list.size()){
				System.out.println("singleNumbers.length >= list.size()");
				return null;
				
			}
			
			ArrayList<Integer> singleNumbers2 = new ArrayList<>(Arrays.asList(singleNumbers));
			Collections.sort(singleNumbers2);
			
			int index = 0;
			for(Integer i : singleNumbers2){
				
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
		
		//for add list to list just ust addAll newList.addAll(listTwo);
		
		/**
		 * Good Method - first execution to the program - by hardcode. Obvious that a lot of improving is needed
		 */
		public static void programExecutionDraft(){
			ArrayList<Integer> rnd = new ArrayList<Integer>();
			
			
			rnd = rangeNumbersToList(25, 50);
			System.out.println("Primary list:\n" + rnd);
			rnd.addAll(someNumbersToList(93,14 ,101, 26, 45 ,99));
			System.out.println("List after adding some numbers : \n" + rnd);
			rnd = excludeNumbers(rnd, 38,43);
			System.out.println("List after exculding specific range: \n" + rnd);
			rnd = excludeNumbers(rnd, 27,29,31);
			System.out.println("List after excluding some numbers:\n" + rnd);
			rnd = chooseNRandoms(rnd, 3);
			System.out.println(); 
			System.out.println("This is the generated Randoms: \n" +rnd);
			
		}
		
		public static void main(String[] args) {
			
			
			Integer[] list = {22,55,150,325,34,235,12,346};
			ArrayList<Integer> list2 = new ArrayList<Integer>(Arrays.asList(list));
			ArrayList<Integer> list3 = new ArrayList<Integer>();
			
			//Test for - int[] chooseNumbers(int amount, int bound)
			//that choose specific amount of randoms to the bound
			chooseNumbers(6,42);
			System.out.println();
			
			//Test for - chooseNRandoms(ArrayList<Integer> list, int n)
			//that choose "n" numbers from specific list
			System.out.println(chooseNRandoms(list2, 2));
			
			//Test for - ArrayList<Integer> rangeNumbersToList(int startRange, int endRange )
			//that generate a list from the range
			list3 = rangeNumbersToList(90, 99);
			System.out.println(list3);
			
			//Test for - ArrayList<Integer> someNumbersToList(int... someNumbers )
			//that generate some numbers to list 
			
			System.out.println(someNumbersToList(66,88,69,13,743,76));
			
			//Test for - ArrayList<Integer> excludeNumbers(ArrayList<Integer> list,
			//int from, int to) that exclude the range (include) from the list. 
			System.out.println("This is the first list - " + list3);
			list3 = excludeNumbers(list3, 120, 135);
			System.out.println("This is after the exclude - "+list3);
			
			//Test for - ArrayList<Integer> excludeNumbers(ArrayList<Integer> list,
			//Integer... singleNumbers), that exclude single numbers from the list.
			
			System.out.println(" This is the list " + list2);
			System.out.println("This is after the exclude " + excludeNumbers(list2, 235 , 88 ,4,22, 21));
			list3 = excludeNumbers(list3, 93, 117);
			System.out.println("\nThis is list 1 - " + list2 +"\nThis is list 2 - "+ list3);
			list2.addAll(list3);
			System.out.println("They togther - " + list2);
			
			System.out.println("\n"
					+ "test for execution of the program: ");
			programExecutionDraft();
			
			
		}
		
}
















