package goralGUIDraft;
import java.awt.*;
import java.awt.event.*;
public class GoralGUIExecution extends Frame

{
	
	//fields:
	
	ScreenV1 welcome ;
	ScreenV1 screen2;
	
	TextField userInput;
	
	Integer startRange,endRange;//for assign values to goral constructor
	//creating instance of goral round
	GoralRoundGUI round ;
	
	public GoralGUIExecution (){
		
		
		
		
		
		//creating (constructing the) Screen for welcome screen
		//first we need to create String for the changed texts
		
		String displayTextContent = "Welcome to \"Goral\" Program!!!\n"
				+"Goral meaning at hebrew is lottey,but we don't courage gambling at any side.\n"
				+"Using at lottery can be useful for put peace and justice amongst the people.";
		String action1Label = "Continue";
		
		//below the main create listner
		//now assign value to the welcome:
		welcome = new ScreenV1(displayTextContent, action1Label, new WelcomeListener(), null);
		
		
		//add welcome
		add(welcome);
		
		displayTextContent = "All the numbers are \ninclude in the action(not exclude) \n"
				+"Please choose a range for creating the primary list:";
		
		action1Label = "send and go";
		screen2 = new ScreenV1(displayTextContent, action1Label, null, null);
		screen2.add(new Label("Type the start of the range :"));
		userInput = new TextField("start range ",10);
		screen2.add(userInput);//for get the value
		
		
		
		
		
		//U HERE:
		//U need to assign values to screen 2 now and create methods, and listners Respectively
		
		
		
		
		//before runnig defining the basic setting of the fram:
		setLayout(new FlowLayout());//layout
		setSize(800, 600);
		setLocation(300,50);
		setTitle("GORAL PROGRAM");
		setBackground(Color.ORANGE);
		//add(new TextField("check"));
		//display it
		setVisible(true);
		
		
		
		
		
		
		
	}
	
	public static void main(String[] args) {
		//just create instance the rest is made on the constructor:
		
		new GoralGUIExecution();
	}
	
	
	
	
	
	public class WelcomeListener implements ActionListener{
		//for action event to welcome screen
		@Override
		public void actionPerformed(ActionEvent evt) {
			
			
			//just go to the next screen
			welcome.setVisible(false);
			//add(new Label("hi"));
			
			add(screen2);
			revalidate();
			repaint();
			
		}
	}
}
