package draftGoral;

import java.util.ArrayList;
import java.util.Scanner;


/**
 * 
 * @author Izhar Mashkif 
 * YIMprogramming@gmail.com  
 *
 */
public class GoralRoundInput2 extends GoralRound{
	
	
	
	//Here is the I/O of the program, the excutation will be at this class at seperate method
	/**
	 * TODO
	 *
	 * -Ctor - that get the start and end values and create new list(maybe with method that create it)-V
	 * ++displayList - that display tthe list. just 25 at row. -V
	 * +addNumbers - overrride that do add ranges, and singles, by input. -V 
	 * **seperate it to 2 conditions because at the future maybe we'll need it seperately
	 * ++removeNumbers like above at the adding. - -V - ***remove singles not work in big numbers. like 1000
	 * ++drawGoral - that let the user option to type something and do the draw. U need to let him choose randomsAmount
	 * + execution - the Organize execute of the program from ater the instance created. it's need to be cuild-in at the constructor.
	 * but not all the implentation because maybe u will be want more excutation type.
	 * 
	 * 
	 * 
	 */
	
	//private GoralRoundInput = new GoralRoundInput();
	private static Scanner input1 = new Scanner(System.in);
	private static Scanner input2 = new Scanner(System.in);
	private static Scanner input3 = new Scanner(System.in);
	
	private int randomsAmount ;
	//ctor. - with input
	
	public GoralRoundInput2() {
		// TODO Auto-generated constructor stub
		System.out.println("Welcome to \"Goral\" Program!!!\n\nGoral meaning at hebrew is lottey,but we don't courage gambling at any side "
				+ "\nUsing at lottery can be useful for put peace and justice amongst the people.\n\n"
				+ "\nAfter all typing please press Enter.All the numbers are include in the action(not exclude)"
				+ " \n\nPlease choose a range for creating the primary list:\n "
				+ "Type the start of the range - ");
		int startRange = input1.nextInt();
		System.out.println("Type the end of the range - ");
		int endRange = input2.nextInt();
		userList = GoralPrimitive.rangeNumbersToList( startRange	,endRange );
		
		//condition for trying again
		if (userList == null){
			
			System.out.println("Please try again\n\n");
			new GoralRoundInput();			
		}
		displayList();
		
	}
	
	//for displayList
	
	public void displayList(){
		//25 at row is good
		System.out.println("\n\nThis is the current List : ");
		
		int count = 0;
		for(Integer x: userList){
			
			if(count % 25 == 0){
				
				System.out.println();
				
			}
			
			System.out.print(x +" | ");
			count++;
			
		}
		System.out.println("\n\n");
	}
	
	//to display the random numbers. like list
	public void displayRandoms(){
		
		
		System.out.println("\n\nThose are the randoms numbers that choosed : ");
		
		int count = 0;
		for(Integer x: randomNumbers){
			
			if(count % 25 == 0){
				
				System.out.println();
				
			}
			
			System.out.print(x +" | ");
			count++;
			
		}
		System.out.println("\n\n");
		
		
	}
	/**
	 * Method for adding values to the list with user Input. 
	 * 
	 * @param by 
	 * 
	 * if by= range so it's do the range adding. if singles it's do the single adding. if not this or this does nothng
	 */
	public void addNumbers(String by){
		if (by.equals("range")){
			System.out.println("\nNow please choose a range to ADD to the list. \n\nType the start range :");
			int startRange = input1.nextInt();
			System.out.println("Type the end of the range - ");
			int endRange = input2.nextInt();
			addNumbers( startRange,  endRange );
			System.out.println("Thanx!\n");
			displayList();
			
			
			
			
		}
		if(by.equals("singles")){
			System.out.println("\nNow please choose a singles Numbers to ADD to the list. "
					+ "\nType any time one number  and enter, When U finished please press \"f\"");
			ArrayList<Integer> singleNumbers = new ArrayList<>();
			String userInput =input1.next();
			Integer singleNumber =0;
			
			while(!userInput.equals("f")){
				//convert string to int - int result = Integer.parseInt(number);
				singleNumber = Integer.parseInt(userInput);
				singleNumbers.add(singleNumber);
				System.out.println("For continue choosing add another number - for continue type \"f\"");
				userInput =input1.next();
				
				
			}
			
			System.out.println("Thanx! Those are the number that u choosed to add to the list : \n\n" + singleNumbers);
			addNumbers( singleNumbers );
			displayList();
			
		}
		
	}
	
	public void removeNumbers(String by ){
		
		if (by.equals("range")){
			System.out.println("\nNow please choose a range to REMOVE from the list. \n\nType the start range :");
			int from = input1.nextInt();
			System.out.println("Type the end of the range - ");
			int to = input2.nextInt();
			removeNumbers( from,  to );
			System.out.println("Thanx!\n");
			displayList();
			
			
			
			
		}
		if(by.equals("singles")){
			System.out.println("\nNow please choose a singles Numbers to REMOVE from the list. "
					+ "\nType any time one number  and enter, When U finished please press \"f\"");
			ArrayList<Integer> singleNumbers = new ArrayList<>();
			//=input1.nextInt();
			int singleNumber =1;
			
			while(!(singleNumber ==0)){
				//convert string to int - int result = Integer.parseInt(number);
				singleNumber  = input1.nextInt();
				singleNumbers.add(singleNumber);
				System.out.println("For continue removing type another number - for continue type \"f\"");
				
				
				
			}
			
			System.out.println("Thanx! Those are the number that u choosed to remove from the list : \n\n" + singleNumbers);
			removeNumbers( singleNumbers );
			displayList();
			
		}
		
	}
	
	public void drawGoral(){
		
		System.out.println("\n\nNow that we have the clean wanted list we can do a fair draw.\n"
				+ "\nHow many randoms number U want that Will be drawn in the draw ?");
		randomsAmount = input1.nextInt();
		chooseNRandoms(randomsAmount);
		displayRandoms();
		
		
		
		
	}
	
	public void drawAgain(){
		System.out.println("\nDraw Again ? (y/n)");
		String doIt = input1.next();
		
		if (doIt.equals("y")){
			randomNumbers = null;
			chooseNRandoms(randomsAmount);
			displayRandoms();
			drawAgain();
			
		}
		else if (doIt.equals("n")){
			endMessage();
		}
		else{
			System.out.println("Wrong type. Please try again...");
			drawAgain();
		}
	}
	public static void endMessage(){
		System.out.println("\nThanx for using GORAL \nAll rights reserved to Izhar Mashkif (c) :)");
	}
	
	public void finish(){
		drawGoral();
		drawAgain();
	}
	
	//where to put the execution ? right now it's at testAll main()	
	public void executeExecution1(){
		
	}
	

}
