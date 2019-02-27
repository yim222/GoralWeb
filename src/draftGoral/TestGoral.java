package draftGoral;

import java.util.ArrayList;

public class TestGoral {
	
	public static void main(String[] args){
		
		System.out.println("For changing The values please apply the hard code of this file");
		
		//Here U change the RANGE
		int start = 200,end = 229;
		ArrayList<Integer> rnd = new ArrayList<Integer>();
		//first showing the values that choosed by range and see it's work good
		System.out.println("The User pick all the number at range incldue start and end :  \n"
								+ "from " + start + " to " + end);
		rnd = GoralReadyMethods.rangeNumbersToList(start , end);
		System.out.println("It's generate the Primary list:\n" + rnd + "\n");
		
		//Here u write more values that U want to add that aren't at the range
		int[] someNumbers = { 5 , 88 , 33 , 44 ,197 ,222};
		
		//showing the values that wanted to add
		System.out.println("The user want to add to the list some numbers that are'nt at the range as following: ");
		for (int i : someNumbers){
			
			System.out.print(i + " , ");
			
		}
		System.out.println("\n\nNow we want to add it to the above list of the user:");
		
		rnd.addAll(GoralReadyMethods.someNumbersToList(someNumbers));
		System.out.println("List after adding some numbers : \n" + rnd);
		System.out.println("There is here a problem of duplicated values!");
		
		//Here U write the range of numbers that u want to exclude : 
		start = 203; end = 208;
		
		
		System.out.println("\nUser also want to exclude from the list a range of number, include the start & end values \nas following: \n"
								+ "from " + start + " to " + end);
		
		//do the work
		rnd = GoralReadyMethods.excludeNumbers(rnd, start ,end);
		
		//Showing the list 
		System.out.println("\nList after exculding specific range: \n" + rnd);
		
		//Here u write the specific values that U want to exclude
		
		//U Here there is problems... how to pass the args to this function
		//Answer - Yeah it's problem so for now we declared them manually, and think. 
		
		int a,b,c;
		a = 201;b=223;c = 217;
		int[] someNumbers2 = {201, 223 , 217}; 
		
		System.out.println("User also want to exclude some specific single numbers"
				+ "from the list as following: " + a +" , " + b + " , "+c);
		
		
		
		System.out.println("U here");
		rnd = GoralReadyMethods.excludeNumbers(rnd, 201);
		System.out.println("\nList after excluding some numbers:\n" + rnd + "\n NOT WORK");
		rnd = GoralReadyMethods.chooseNRandoms(rnd, 3);
		System.out.println(); 
		System.out.println("This is the generated Randoms: \n" +rnd);
		
	}

}
