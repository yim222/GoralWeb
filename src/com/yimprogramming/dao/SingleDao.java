package com.yimprogramming.dao;

import com.yimprogramming.core.GoralRound;

public class SingleDao {
	
	
	public static GoralRound obj1;
	public SingleDao(){};
	public  SingleDao(int from, int to){
		
		obj1 = new GoralRound(from, to);
		
	}

}
