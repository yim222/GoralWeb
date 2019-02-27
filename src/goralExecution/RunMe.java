package goralExecution;
import java.util.Scanner;

import draftGoral.*;

public class RunMe {
	
	public RunMe(){
		
		GoralRoundInput goral = new GoralRoundInput();
		Scanner input = new Scanner(System.in);String userInput ="";
		System.out.println("If you want add another RANGE to list please type y. \n"
				+ "For continue type any other char ");
		userInput = input.nextLine();
		if(userInput.equals("y")){
			goral.addNumbers("range");
		}
		
		
		System.out.println("If you want add some SINGLE numbers to list please type y. \n"
				+ "For continue type any other char ");
		userInput = input.nextLine();
		if(userInput.equals("y")){
			goral.addNumbers("singles");
		}
		
		System.out.println("If you want remove specific RANGE  numbers from the  list please type y. \n"
				+ "For continue type any other char ");
		userInput = input.nextLine();
		if(userInput.equals("y")){
			goral.removeNumbers("range");
		}
		
		System.out.println("If you want remove specific SINGLE  numbers from the  list please type y. \n"
				+ "For continue type any other char ");
		userInput = input.nextLine();
		if(userInput.equals("y")){
			goral.removeNumbers("singles");
		}
		
		goral.finish();
	}
	
	public static void main(String[] args) {
		new RunMe();
	}
}
