package com.yimprogramming.testing;
import java.util.Map;

import com.yimprogramming.core.GoralRound;
import com.yimprogramming.dao.GoralRoundGenerator;
public class TestGoralRoundGenerator {
	
	
	public static void main(String[] args) {
		Integer id = GoralRoundGenerator.getId();
		GoralRoundGenerator.generateObject(2, 500);
		Map<Integer, GoralRound> map = GoralRoundGenerator.getInstances();
		GoralRound goralRound1 = map.get(id);
		System.out.println("test = "  + goralRound1.getUserList());
		System.out.println(goralRound1.getUserList());
		
		id = GoralRoundGenerator.getId();
		GoralRoundGenerator.generateObject(100, 115);
		map = GoralRoundGenerator.getInstances();
		goralRound1 = map.get(id);
		
		System.out.println(goralRound1.getUserList());
		goralRound1 = map.get(0);
		System.out.println(goralRound1.getUserList());
		
		GoralRoundGenerator.removeObject(1);
		System.out.println(GoralRoundGenerator.getId());
		GoralRoundGenerator.generateObject(100, 115);
		System.out.println(GoralRoundGenerator.getId());
		
	}
}
