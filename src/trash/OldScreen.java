package trash;
import java.awt.Button;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class OldScreen extends Panel {
	
	TextField tf1;
	Button action;
	TextArea displayedText;
	
	public OldScreen(int number){
		
		
		
		//implements for screen 1
		if (number == 1){
			
			displayedText = new TextArea("Welcome to \"Goral\" Program!!!\n"
					+"Goral meaning at hebrew is lottey,but we don't courage gambling at any side.\n"
					+"Using at lottery can be useful for put peace and justice amongst the people.");
			action = new Button("Start");
			action.addActionListener(new ScreenListner());
			add(displayedText);
			add(action);			
		}
		
	}
	
	//inner class for implement action handler : 
	
	public class ScreenListner implements ActionListener{
		
		//if by getSource
		
		@Override
	      public void actionPerformed(ActionEvent evt) {
			Button source = (Button)evt.getSource();
	         
			//implements by if/else
			
			if(source == action){
				
				displayedText.add("appyjlj");
				{
					
					
					
				}
			}
				
			}
		
	}
	
	
	

}
