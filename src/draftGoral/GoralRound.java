package draftGoral;
//Class is good - 3/Aug/2016 - now we need to create from it I/O class.
import java.util.ArrayList;
import java.util.Collections;

//at this class I implement the program as documented at the files. 
//The aim is to create simple program that give "GoralRound" all the wanted abilites
//It's import and us at "GoralPrimitive"

/**
 * 
 * @author lingar
 * ToDo 
 * 
 * GoralRound
- list : ArrayList<Integer>
- randomNumbers : int[]

ctor.
+GoralRound:(int startRange , int endRange )(create primary list ) -V 

VOID!!!if not necessary value
+AddNumbers(int start, int end ):Void -range (include too for uniformity) -V 

+shakeList – for removing duplicates and reorder from low to big.- - V
+addnumber – singles, - V*** very simple but need arrayList parameter.-V
+ removeNumbers (range/ -V 

+ removeNumberssingles ) all on goralRound  - V 
+get list/randomNumbers
+chooseNRandoms-for the choosing

rules - 
all ranges action with include...

Comment: 
- To the input you will have to do function that create ArrayList for pass it to the function that get it.
 *
 */
public class GoralRound {
	
	//Fields
	protected ArrayList<Integer> userList = new ArrayList<Integer >();
	protected ArrayList<Integer> randomNumbers;
	
	//Ctor. - Creating primary list include the start and end 
	public GoralRound(int startRange , int endRange ){
			userList = GoralPrimitive.rangeNumbersToList( startRange,  endRange );
			
			
			
	}
	
	
	public GoralRound(){
		//empty constructor for the subclass can use it's,
		
	}
	
	
	//Methods 
	
	//Setters And Getters (no setRandomNumbers)
	public ArrayList<Integer> getUserList() {
		return userList;
	}
	public void setUserList(ArrayList<Integer> userList) {
		this.userList = userList;
	}
	public ArrayList<Integer> getRandomNumbers() {
		return randomNumbers;
	}
	
	
	//Instance Methods
	
	
	//inner method for do shake the list always
	//Collections.sort(listofcountries); delete
	public void shakeList(){
		
		//sorting
		Collections.sort(userList);
		
		//remove duplicates
		removeDuplicatesOL(userList);
		
		
		
	}
	public static void removeDuplicatesOL(ArrayList<Integer> userList){
		
		//logic code : 
		/*
		 *if original index == checked index > remove checked index and check again 
		 *else (if not) original index = checked index and check it.
		 */
		
		
		//this is the condition for continue checking, if it's not last
		for (int original = 0; original < userList.size()-1; original++){
			int checkedIndex = original+1;
			for(  ;; ){
				if (userList.get(original).equals(userList.get(checkedIndex))){
					
					userList.remove(checkedIndex);
				}
				
				else{
					break;
				}
			
			}
			
			
			
			
		}
		
		
		
		
	}
	
	
	//add more range to the list :  * u need to add to here "shakeList".
	public void addNumbers(int startRange, int endRange ){
		
		userList.addAll(GoralPrimitive.rangeNumbersToList(startRange, endRange));
		shakeList();
		
	}
	
	//add single numbers to the list/ It's passes as ArrayList
	public void addNumbers(ArrayList<Integer> singleNumbers ){
		
		
		userList.addAll(singleNumbers);
		shakeList();
		
		
		
	}
	
	//Removing range of numbers include them
	public void removeNumbers(int from, int to){
		
		userList = GoralPrimitive.excludeNumbers(userList, from, to);
		shakeList();
		
	}
	
	//Removing singles numbers - passed as ArrayList 
	//19/8/2016 - Update: I fix it, it unnecessary there is built-in method-better. 
	
	public void removeNumbers(ArrayList< Integer> someNumbers){
		
		
		 /*removing it - userList = GoralPrimitive.excludeNumbers(userList, someNumbers);*/
		//by that:
		userList.removeAll(someNumbers);
		
		shakeList();
		
	}
	
	public void chooseNRandoms(int randomsAmount){
		randomNumbers = GoralPrimitive.chooseNRandoms(userList, randomsAmount);
		
	}
	
	
	//Static Methods

}
