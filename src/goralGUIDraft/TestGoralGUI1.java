package goralGUIDraft;

import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestGoralGUI1 
	
	extends Frame
	implements ActionListener
	{
		
		
		
		//creating instance of goral round
				GoralRoundGUI round = new GoralRoundGUI(5,20);
		
		public TestGoralGUI1 (){
			
			
			
			
			
			
			
			
			//before runnig defining the basic setting of the fram:
			setLayout(new FlowLayout());//layout
			setSize(800, 600);
			setLocation(300,50);
			setTitle("GORAL PROGRAM");
			setBackground(Color.BLUE);
			//add(new TextField("check"));
			//display it
			setVisible(true);
			
			
			
			
			
			
			
		}
		
		public static void main(String[] args) {
			//just create instance the rest is made on the constructor:
			
			new PracticeGoralGUIExecution_1();
		}
		
		//for action event. still don't know go to define it outside.
		@Override
		public void actionPerformed(ActionEvent evt) {
			// TODO Auto-generated method stub
			//GoralRoundGUI goral = new GoralRoundGUI(10, 20);
			round.displayList(listArea);
			
		}
		
		public void createAndGoToScreen2(){
			
			Panel screen2 = new Panel();
			screenHead.setText("SCREEN 2");
			screen2.add(screenHead);
			screen1.setVisible(false);
			add(screen2);
			setVisible(true);
			
			
		}

}
