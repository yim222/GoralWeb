package goralGUIDraft;

import java.awt.*;
import java.awt.event.*;
public class ScreenV1 extends Panel {//This class is sub of Panel
	
	
	//The Basic fields that should be at every Screen of Goral:
	//(All public because it's just for using inside GUI execution
	
	//TEXT FIELDS/AREAS
	public TextArea displayText,listArea;
		
	//BUTTONS
	public Button action1;
	
	
	//Ctor. 
	//buttonLabel, Output text, ActionListner
	
	public ScreenV1( String displayTextContent,String action1Label,
			ActionListener listener ,GoralRoundGUI round){
		
		
		//Give values to all copoments
		displayText = new TextArea(displayTextContent);
		displayText.setEditable(false);
		action1 = new Button(action1Label);
		action1.addActionListener(listener);
		listArea = new TextArea();
		listArea.setEditable(false);
		if (round != null){
		round.displayList(listArea);
		}
		//add all compoments to the screen:
		
		add(displayText);add(action1); add(listArea);
		
		
		

	}
	
	
	public static  void testMe(){
		
		ScreenV1 scr = new ScreenV1("text", "button", null, new GoralRoundGUI(0, 50));
		Frame f = new Frame();
		f.setLayout(new FlowLayout());
		f.setSize(500, 500);
		f.setLocation(300, 50);
		f.setTitle("GORAL PROGRAM");
		f.setBackground(Color.ORANGE);
		
		//add the screen
		f.add(scr);
		f.setVisible(true);
	}
	
		
	public static void main(String[] args) {
		
		testMe();
	}
	

}
