package com.yimprogramming.web.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

import com.yimprogramming.core.GoralRound;
import com.yimprogramming.dao.SingleDao;

//import org.glassfish.jersey.process.internal.RequestScope.Instance;


/*
 http://localhost:8080/Goral_Web/goral/test2
  
 */
//@Path("/draft")

	@Path("/test2")
public class Test2 {
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String check(){
		
		return "test2 - web service";
	}

	@Path("/test1")
		@GET
		@Produces(MediaType.TEXT_PLAIN)
		public String check222(){
			
			return "Test1";

	}
	@Path("/createObj")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String createObj(){
		
		SingleDao.obj1 = new GoralRound(4, 30);
		return "created";

	}
		
		
		//http://localhost:8080/Goral_Web/goral/test/showList
	@Path("/displayList")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String showList(){
		//g1 = new GoralRound(3, 300);
		String str = SingleDao.obj1.getUserList().toString();
		return str;
		
	}
	
	@Path("/addRange")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String addRange(){
		 SingleDao.obj1.addNumbers(400, 500);
		//String str =  SingleDao.obj1.getUserList().toString();
		return "add range";
		
	}
	@Path("/addSingles")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String addSingles(){
		Integer[] someNumbers = {103, 42,  108};
		ArrayList<Integer> someNumbers2 = new ArrayList<Integer>(Arrays.asList(someNumbers));
		
		 SingleDao.obj1.addNumbers(someNumbers2);
		//String str =  SingleDao.obj1.getUserList().toString();
		return "add " + someNumbers2;
		
	}
	
	@Path("/removeRange")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String removeRange(){
		
		
		
		 SingleDao.obj1.removeNumbers(5, 10);
		
		return "remove range" ;
		
	}
	@Path("/removeSingles")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String removeSingles(){
		Integer[] someNumbers = {420, 426,  28};
		ArrayList<Integer> someNumbers2 = new ArrayList<Integer>(Arrays.asList(someNumbers));
		
		 SingleDao.obj1.removeNumbers(someNumbers2);
		//String str =  SingleDao.obj1.getUserList().toString();
		return "remove " + someNumbers2;
		
	}
	@Path("/draw")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String draw(){
		
		
		//String drawing =  SingleDao.obj1.chooseNRandoms(6);
		//String str =  SingleDao.obj1.getUserList().toString();
		return "draw result =  \n" + SingleDao.obj1.chooseNRandoms(6);
		
	}
}
