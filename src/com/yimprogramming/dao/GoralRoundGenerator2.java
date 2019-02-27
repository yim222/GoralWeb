package com.yimprogramming.dao;

import java.util.HashMap;
import java.util.Map;

import com.yimprogramming.core.GoralRound;
/**
 * 
 * @author lingar
 *This Class generate new GoralRound with unique id. 
 *It's useful for WS. 
 *Tested and worked well 7/5/17 ..
 *
 */
public class GoralRoundGenerator2 {
	
	 
	private Integer id = 0;
	
	private Map<Integer, GoralRound> instances  = new HashMap<Integer, GoralRound>();
	
	
	//to return the current id value
	public  Integer getId(){
		
		return id;
	}
	
	public  Map<Integer, GoralRound> getInstances(){
		
		return instances;
	}
	
	public  void generateObject(int from, int to){
		
		instances.put(id, new GoralRound(from, to));
		//id++;
		setId();
		
		
		
	}
	
	//to reduce the id ? it should consider
	private void setId(){
		
		
		
		
		for(Integer i =0 ; i < id; i++){
			if(!instances.containsKey(i)){
				
				id = i;
				return;
				
			}
			//check if this value is in the map 
			/*
			 * for ( String key : team1.keySet() ) {
    System.out.println( key );
}
			 */
			
			
		}
		//if all is full just increase id
		id++;
		
	}
	public void removeObject(int id){
		
		instances.remove(id);
	}
	//todo - u need to implement removing too.
}
