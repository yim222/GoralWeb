package com.yimprogramming.web.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.yimprogramming.core.GoralRound;
import com.yimprogramming.dao.GoralRoundGenerator;
import com.yimprogramming.dao.GoralRoundGenerator2;
import com.yimprogramming.dao.SingleDao;
import com.yimprogramming.testing.JsonTestObj;
import com.yimprogramming.web.services.utils.GoralRoundJson;

//import org.glassfish.jersey.process.internal.RequestScope.Instance;


/*
 http://localhost:8080/Goral_Web/goral/test4
  
 */
//@Path("/draft")

@Path("/test5")
public class Test5 {
	
	
	//Assign special GoralRoundGenerator - to this session
	//http://localhost:8080/Goral_Web/goral/test4/init
	@Path("/init")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String assignToSession(@Context HttpServletRequest request){//send request to this method
		//public String StudyingSession(@Context HttpServletRequest request){
		
		
		
		
		//Get the current session
		HttpSession session = request.getSession();
		if(session.getAttribute("GoralRoundGenerator") == null){
			System.out.println("new session");
			//Assign the GoralRoundGenerator to this session
			session.setAttribute("GoralRoundGenerator", new GoralRoundGenerator2());
			return "Assign the GoralRoundGenerator to this session";
			
		}
		else{
			
			System.out.println("old session");
			return "NOT Assign the GoralRoundGenerator to this session - OLD SESSION";
		}
		
		
		
	}
	
	//http://localhost:8080/Goral_Web/goral/test3/displayList/#
	//display list by ID
	@Path("/displayList2/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	
	public List showList2(@Context HttpServletRequest request,
			@PathParam  ("id" )Integer id){
		//g1 = new GoralRound(3, 300);
		
		//Get the current session
		HttpSession session = request.getSession();
		GoralRoundGenerator2 g = (GoralRoundGenerator2)session.getAttribute("GoralRoundGenerator");
		
		
		
		GoralRound goralRound = g.getInstances().get(id);
		//String str = SingleDao.obj1.getUserList().toString();
		System.out.println(goralRound.getUserList().toString());
		return goralRound.getUserList();
		
	}
	//create Object and return the id for each session 
	//http://localhost:8080/Goral_Web/goral/test4/createObj2
	@Path("/createObj2")
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String createObj2(@Context HttpServletRequest request,
			@FormParam("from") int from,@FormParam("to") int to ){
		//Get the current session
		HttpSession session = request.getSession();
		GoralRoundGenerator2 g = (GoralRoundGenerator2)session.getAttribute("GoralRoundGenerator");
		
		Integer id = g.getId();
		g.generateObject(from, to);
		
		return "created new goral round from " +from + " to " + to +" with id " + id ;

	}
	/**
	 * 
	 * 
	 * @param request
	 * @param id
	 * @return
	 * 
	 * 
	 * TODO : 
	 * 
	 * Function that accept 2 json parameters , and create from them list. 
	 * It's return the id of this list 
	 */
	//create Object and return the id for each session 
		//http://localhost:8080/Goral_Web/goral/test4/createObj2
		@Path("/createNewRound")
		@POST
		//@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.APPLICATION_JSON)
		public GoralRoundJson createObj3(@Context HttpServletRequest request,
				GoralRoundJson data ){
			//Get the current session
			HttpSession session = request.getSession();
			GoralRoundGenerator2 g = (GoralRoundGenerator2)session.getAttribute("GoralRoundGenerator");
			
			
			//The current id is the next id that will be assigned to the new object
			Integer id = g.getId();
			
			//Give it to the json object for sending to the client side			
			data.setId(id);
			g.generateObject(data.getFrom(), data.getTo());
			System.out.println("created new goral round from " + data.getFrom() + " to " + data.getTo() +" with id " 
					+ data.getId() );
			GoralRoundJson data2 = new GoralRoundJson(data.getFrom(), data.getTo(), data.getId(),null);
			return data2 ;

		}
		
		@Path("/addRange3")
		@POST
		//@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.APPLICATION_JSON)
		public GoralRoundJson addRange3(@Context HttpServletRequest request,
				GoralRoundJson data ){
			//Get the current session
			HttpSession session = request.getSession();
			GoralRoundGenerator2 g = (GoralRoundGenerator2)session.getAttribute("GoralRoundGenerator");
			
			Integer id = data.getId();
			
			GoralRound goralRound = g.getInstances().get(id);
			
			goralRound.addNumbers(data.getFrom(), data.getTo());
			//System.out.println("created new goral round from " + data.getFrom() + " to " + data.getTo() +" with id " 
				//	+ data.getId() );
			GoralRoundJson data2 = new GoralRoundJson(data.getFrom(), data.getTo(), data.getId(),null);
			return data2 ;

		}
		
		@Path("/addSingles2")
		@POST
		@Produces(MediaType.APPLICATION_JSON)
		public void addSingles2(@Context HttpServletRequest request,
				GoralRoundJson data ){
			
			Integer[] someNumbers = data.getSomeNumbers();
			//Get the current session
			HttpSession session = request.getSession();
			
			//get the right Map of this session 
			GoralRoundGenerator2 g = (GoralRoundGenerator2)session.getAttribute("GoralRoundGenerator");
			
			//convert the array to ArrayList
			ArrayList<Integer> someNumbers2 = new ArrayList<Integer>(Arrays.asList(someNumbers));
			
			//get the right round object
			Integer id = data.getId();
			
			GoralRound goralRound = g.getInstances().get(id);
			goralRound.addNumbers(someNumbers2);
			
			System.out.println("adding to id " + data.getId() + " those numbers :" + someNumbers2 );
			
			
		}

		@Path("/removeRange")
		@POST
		@Produces(MediaType.APPLICATION_JSON)
		public void removeRange(@Context HttpServletRequest request,
				GoralRoundJson data ){
			
			//Integer[] someNumbers = data.getSomeNumbers();
			//Get the current session
			HttpSession session = request.getSession();
			
			//get the right Map of this session 
			GoralRoundGenerator2 g = (GoralRoundGenerator2)session.getAttribute("GoralRoundGenerator");
			
			
			
			//get the right round object
			Integer id = data.getId();
			
			GoralRound goralRound = g.getInstances().get(id);
			goralRound.removeNumbers(data.getFrom(), data.getTo());

			System.out.println("removing range from  " + data.getFrom() + " to " + data.getTo() +" with id " 
					+ data.getId() );		
			
		}
		
		/**
		 * Method for drawing and get the lottery nmbers
		 * 
		 */
		//http://localhost:8080/Goral_Web/goral/test3/displayList/#
		//display list by ID
		@Path("/drawNumbers")
		@POST
		@Produces(MediaType.APPLICATION_JSON)
		
		public ArrayList draw(@Context HttpServletRequest request,
				GoralRoundJson data){
			//g1 = new GoralRound(3, 300);
			
			//Get the current session
			HttpSession session = request.getSession();
			GoralRoundGenerator2 g = (GoralRoundGenerator2)session.getAttribute("GoralRoundGenerator");
			
			
			Integer id = data.getId();
			GoralRound goralRound = g.getInstances().get(id);
			ArrayList<Integer> resultList = goralRound.chooseNRandoms(data.getDrawnedAmt());
			System.out.println("this is the drawned list : " + resultList);
			
			return resultList;
			
		}
		
		
		/************************old functions********************************/
		/*
		 * @Path("/son")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public JsonTestObj son(JsonTestObj j ){
		
		JsonTestObj j2 = new JsonTestObj(j.getX(), j.getY());
		//j2.x = j.x; j2.y = j.y;
		return j2;
		 */
	//http://localhost:8080/Goral_Web/goral/test4/addRange1/{id}
	//add range to specific list
	@Path("/addRange1/{id}")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String addRange(@Context HttpServletRequest request,
			@PathParam  ("id" )Integer id){
		// SingleDao.obj1.addNumbers(400, 500);
		//String str =  SingleDao.obj1.getUserList().toString();
		//Get the current session
		HttpSession session = request.getSession();
		GoralRoundGenerator2 g = (GoralRoundGenerator2)session.getAttribute("GoralRoundGenerator");
		
		GoralRound goralRound = g.getInstances().get(id);
		goralRound.addNumbers(90, 120);
		
		
		return "add range 90 - 120";
		
	}
	//http://localhost:8080/Goral_Web/goral/test3/displayList/#
	//display list by ID
	@Path("/displayList/{id}")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	
	public String showList(@Context HttpServletRequest request,
			@PathParam  ("id" )Integer id){
		//g1 = new GoralRound(3, 300);
		
		//Get the current session
		HttpSession session = request.getSession();
		GoralRoundGenerator2 g = (GoralRoundGenerator2)session.getAttribute("GoralRoundGenerator");
		
		
		
		GoralRound goralRound = g.getInstances().get(id);
		//String str = SingleDao.obj1.getUserList().toString();
		System.out.println(goralRound.getUserList().toString());
		return goralRound.getUserList().toString();
		
	}
	@Path("/removeSingles")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public void removeRange2(@Context HttpServletRequest request,
			GoralRoundJson data ){
		
		Integer[] someNumbers = data.getSomeNumbers();
		//Get the current session
		HttpSession session = request.getSession();
		
		//get the right Map of this session 
		GoralRoundGenerator2 g = (GoralRoundGenerator2)session.getAttribute("GoralRoundGenerator");
		
		//convert the array to ArrayList
		ArrayList<Integer> someNumbers2 = new ArrayList<Integer>(Arrays.asList(someNumbers));
		
		//get the right round object
		Integer id = data.getId();
		
		GoralRound goralRound = g.getInstances().get(id);
		goralRound.removeNumbers(someNumbers2);
		
		System.out.println("removing from id " + data.getId() + " those numbers :" + someNumbers2 );
		
		
	}
	
	
	
	//*********************************
	
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
	
	
	
	
	
	//here u need to create another ws with parameter of the id that do all  the work with the ID.
		
	
	
	
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
	
	@Path("/removeRange2")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String removeRange(){
		
		
		
		 SingleDao.obj1.removeNumbers(5, 10);
		
		return "remove range" ;
		
	}
	@Path("/removeSingles2")
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
	@Path("/son")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public JsonTestObj son(JsonTestObj j ){
		
		JsonTestObj j2 = new JsonTestObj(j.getX(), j.getY());
		//j2.x = j.x; j2.y = j.y;
		return j2;
		
		 
		
	}
	@Path("/son2")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public GoralRoundJson son2(GoralRoundJson j ){
		
		//GoralRoundJson j2 = new JsonTestObj(j.getX(), j.getY());
		//j2.x = j.x; j2.y = j.y;
		return j;
		
		 
		
	}
	@Path("/jsonList")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String jsonToList(GoralRoundJson j ){
		Integer[] someNumbers = j.getSomeNumbers();
		//Integer[] someNumbers = j;
		ArrayList<Integer> someNumbers3 = new ArrayList<Integer>(Arrays.asList(someNumbers)); 
		System.out.println(someNumbers3);
		ArrayList<Integer> someNumbers2 = new ArrayList<Integer>(Arrays.asList(j.getSomeNumbers()));
		System.out.println(someNumbers2);
		//GoralRoundJson j2 = new JsonTestObj(j.getX(), j.getY());
		//j2.x = j.x; j2.y = j.y;
		return "";
		
		 
		 
	}
}
