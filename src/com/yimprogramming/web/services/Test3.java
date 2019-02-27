package com.yimprogramming.web.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.yimprogramming.core.GoralRound;
import com.yimprogramming.dao.GoralRoundGenerator;
import com.yimprogramming.dao.SingleDao;
import com.yimprogramming.testing.JsonTestObj;
import com.yimprogramming.web.services.utils.GoralRoundJson;

//import org.glassfish.jersey.process.internal.RequestScope.Instance;


/*
 http://localhost:8080/Goral_Web/goral/test3
  
 */
//@Path("/draft")

@Path("/test3")
public class Test3 {
	//the map of all objects
	Map<Integer, GoralRound> map = GoralRoundGenerator.getInstances();
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String check(){
		
		return "test3 - web service";
	}

	@Path("/test1")
		@GET
		@Produces(MediaType.TEXT_PLAIN)
		public String check222(){
			
			return "Test1";

	}
	@Path("/createObj")
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String createObj(@FormParam("from") int from,@FormParam("to") int to ){
		Integer id = GoralRoundGenerator.getId();
		GoralRoundGenerator.generateObject(from, to);
		
		return "created new goral round from " +from + " to " + to +" with id " + id ;

	}
	
	//create Object and return the id 
	@Path("/createObj2")
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String createObj2(@FormParam("from") int from,@FormParam("to") int to ){
		Integer id = GoralRoundGenerator.getId();
		GoralRoundGenerator.generateObject(from, to);
		
		return "created new goral round from " +from + " to " + to +" with id " + id ;

	}
	
	
	
	//here u need to create another ws with parameter of the id that do all  the work with the ID.
		
		//http://localhost:8080/Goral_Web/goral/test3/displayList/#
	@Path("/displayList/{id}")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	
	public String showList(@PathParam  ("id" )Integer id){
		//g1 = new GoralRound(3, 300);
		
		GoralRound goralRound1 = map.get(0);
		System.out.println("test = "  + goralRound1.getUserList());
		GoralRound goralRound = GoralRoundGenerator.getInstances().get(id);
		//String str = SingleDao.obj1.getUserList().toString();
		System.out.println(goralRound.getUserList().toString());
		return goralRound.getUserList().toString();
		
	}
	
	@Path("/addRange1/{id}")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String addRange(@PathParam  ("id" )Integer id){
		// SingleDao.obj1.addNumbers(400, 500);
		//String str =  SingleDao.obj1.getUserList().toString();
		
		GoralRound goralRound = GoralRoundGenerator.getInstances().get(id);
		goralRound.addNumbers(90, 120);
		
		
		return "add range 90 - 120";
		
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
	@Path("/tryJson")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public JsonTestObj tryJson(JsonTestObj j ){
		
		JsonTestObj j2 = new JsonTestObj(j.getX(), j.getY());
		//j2.x = j.x; j2.y = j.y;
		return j2;
		
		 
		
	}
	@Path("/tryJson2")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public GoralRoundJson tryJson2(GoralRoundJson j ){
		
		//GoralRoundJson j2 = new JsonTestObj(j.getX(), j.getY());
		//j2.x = j.x; j2.y = j.y;
		return j;
		
		 
		
	}
}
