package goralGUIDraft;
import java.awt.Component;
import java.awt.TextArea;
import java.util.ArrayList;

import draftGoral.GoralRound;

//just trying to make GUI program. this will upgrade the goralRound for GUI (what who's necessary)
public class GoralRoundGUI extends GoralRound{
	
	
	
	public GoralRoundGUI(int start, int end){
		super(start,end);
		
	}
		
	public void displayList(TextArea compoment){
		
		int counter = 0;
		compoment.setText("the list:\n");
		for(Integer i : getUserList()){
			
			if(counter%15 == 0){
				compoment.append("\n");
			}
			
			compoment.append(i+" , ");
			System.out.println(i);
			counter++;
		}
		
		
	}
	
	
	public static void main(String[] args) {
		GoralRoundGUI goral = new GoralRoundGUI(5,90);
		
		goral.displayList(new TextArea());
		
		
	}

}
