package draftGoral;

import java.util.ArrayList;
import java.util.Collections;

public class TestAllGoralRoundIO {

	public static void main(String[] args) {
		
		GoralRoundInput goral = new GoralRoundInput();
		goral.addNumbers("range");
		goral.addNumbers("singles");
		goral.removeNumbers("range");
		goral.removeNumbers("singles");
		goral.finish();
		
/*		
		GoralRoundInput2 goral2 = new GoralRoundInput2();
		goral2.addNumbers("range");
		goral2.addNumbers("singles");
		goral2.removeNumbers("range");
		goral2.removeNumbers("singles");
		goral2.finish();
		*/
	}

}
