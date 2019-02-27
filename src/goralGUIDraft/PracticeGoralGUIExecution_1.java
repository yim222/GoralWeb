package goralGUIDraft;
//This is just for some practice



	
	import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
	public class PracticeGoralGUIExecution_1 extends Frame

	{
		
		//fields:
		
		ScreenV1 welcome ;
		ScreenV1 screen2 , screen3, screen4;
		
		TextField userInput;
		
		Integer startRange,endRange;//for assign values to goral constructor
		//creating instance of goral round
		GoralRoundGUI round ;
		
		//fields for parameter to pass to the events and  screens
		String displayTextContent , action1Label;
		public PracticeGoralGUIExecution_1 (){
			
			System.out.println("hi");
			
			
			
			//creating (constructing the) Screen for welcome screen
			//first we need to create String for the changed texts
			
			displayTextContent = "Welcome to \"Goral\" Program!!!\n"
					+"Goral meaning at hebrew is lottey,but we don't courage gambling at any side.\n"
					+"Using at lottery can be useful for put peace and justice amongst the people.";
			action1Label = "Welcome Screen - Continue";
			
			//below the main create listner
			//now assign value to the welcome:
			welcome = new ScreenV1(displayTextContent, action1Label, new WelcomeListener(), null);
			
			
			//add welcome
			add(welcome);
			
			
			//set Screen3
			displayTextContent = "";
			
			action1Label = "send and go";
			screen3 = new ScreenV1(displayTextContent, action1Label, null, null);
			screen3.add(new Label("Type the end of the range –"));
			userInput = new TextField(10);
			screen3.add(userInput);//for get the value
					
			
			//set Screen4
			displayTextContent = "This is the list : ";
			
			action1Label = "NA";
			screen4 = new ScreenV1(displayTextContent, action1Label, null, null);
			
					
			
			
			
			
			
			
			//before runnig defining the basic setting of the fram:
			setLayout(new FlowLayout());//layout
			setSize(400	, 500);
			setLocation(300,50);
			setTitle("GORAL PROGRAM");
			setBackground(Color.ORANGE);
			//add(new TextField("check"));
			//display it
			setVisible(true);
			System.out.println("panel = " + welcome.getLayout());
			System.out.println("frame = " + getLayout());
			
			
			
			
		}
		
		public static void main(String[] args) {
			//just create instance the rest is made on the constructor:
			PracticeGoralGUIExecution_1 demo =  new PracticeGoralGUIExecution_1();
			/*
			//test screens:
			
			Frame f = new Frame ();
			f.setLayout(new FlowLayout());
			f.setSize(800, 600);
			f.add(demo.screen4);
			f.setVisible(true);
			*/
			//new GoralGUIExecution2();
			
		}
		
		
		
		
		//Listenr 1 & 2
		public class WelcomeListener implements ActionListener{
			//for action event to welcome screen
			@Override
			public void actionPerformed(ActionEvent evt) {
				
				//for get the label of the evt src - // String btnLabel = evt.getActionCommand();
				
				String sourceLabel = evt.getActionCommand();
				//condition for event of screen1(welcome)
				if (sourceLabel.equals("Welcome Screen - Continue")){
					
					//just go to the next screen
					welcome.setVisible(false);
					//add(new Label("hi"));
					//set Screen2
					displayTextContent = "All the numbers are \ninclude in the action(not exclude) \n"
							+"Please choose a range for creating the primary list:";
					
					action1Label = "Screen 2 - send and go";
					screen2 = new ScreenV1(displayTextContent, action1Label, new WelcomeListener(), null);//the same listenr determine by value
					screen2.setLayout(new GridLayout(4, 3));
					screen2.add(new Label("Type the start of the range :"));
					userInput = new TextField(10);
					screen2.add(userInput);//for get the value
					
					add(screen2);
					
					//refresh
					revalidate();
					repaint();
				}
				
				//Listener for screen 2:
				
				
				else{
					/*
					 * 1-give the input's value to startRange
					 * 2-Go to screen 3
					 */
					
					// 1-give the input's value to startRange
					//How to make the input into Integer ? /// int numberIn = Integer.parseInt(tfInput.getText());
					startRange = Integer.parseInt(userInput.getText());
					System.out.println(startRange);
					
					
					//remove screen 2 
					screen2.setVisible(false);
					
					//2-Go to screen 3...
					
					//set Screen3
					displayTextContent = "";
					
					action1Label = "Screen 3 - send and go";
					screen3 = new ScreenV1(displayTextContent, action1Label,
							//defining annonimous listener
							new ActionListener(){
						//Listener for Screen 3
						/*
						 * 1-give the input's value to endtRange
						 * 2-Create the GoralRound Object
						 * 3-turn off screen 3
						 * 4-Go to screen 4 
						 */
						@Override
						public void actionPerformed(ActionEvent evt){
							
							//1-give the input's value to endtRange
							endRange = Integer.parseInt(userInput.getText());
							
							
							//2-Create the GoralRound Object
							round = new GoralRoundGUI(startRange, endRange);
							
							//3-turn off screen 3
							screen3.setVisible(false);
							
							//4-Go to screen 4
							//set Screen4
							displayTextContent = "This is the list : ";
							
							action1Label = "NA";
							screen4 = new ScreenV1(displayTextContent, action1Label, null, round);
							add(screen4);
							//refresh
							revalidate();
							repaint();
						
							
						}
							
					},
							
							null);
					screen3.add(new Label("Type the end of the range –"));
					userInput = new TextField(10);
					screen3.add(userInput);//for get the value

					add(screen3);
					
					//refresh
					revalidate();
					repaint();
					
					
				}
				
			}
		}
	}

