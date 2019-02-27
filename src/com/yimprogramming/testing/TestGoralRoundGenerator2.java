package com.yimprogramming.testing;
import java.util.Map;

import com.yimprogramming.core.GoralRound;
import com.yimprogramming.dao.*;
public class TestGoralRoundGenerator2 {
	
	
	public static void main(String[] args) {
		GoralRoundGenerator2 g1 = new GoralRoundGenerator2();
		Integer id = g1.getId();
		g1.generateObject(2, 500);
		Map<Integer, GoralRound> map = g1.getInstances();
		GoralRound goralRound1 = map.get(id);
		System.out.println("test = "  + goralRound1.getUserList());
		System.out.println(goralRound1.getUserList());
		
		id = g1.getId();
		g1.generateObject(100, 115);
		//map = g1.getInstances();
		goralRound1 = map.get(id);
		
		System.out.println(goralRound1.getUserList());
		goralRound1 = map.get(0);
		System.out.println(goralRound1.getUserList());
		
		g1.removeObject(1);
		System.out.println(g1.getId());
		g1.generateObject(100, 115);
		System.out.println(g1.getId());
		
	}
}
