package com.yimprogramming.web.services;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.yimprogramming.core.GoralRound;

//import org.glassfish.jersey.process.internal.RequestScope.Instance;


/*
 http://localhost:8080/Goral_Web/goral/test/test1
  http://localhost:8080/com.persons_details/persons_details/draftWS/createInitialPersonDAO
  http://localhost:8080/com.persons_details/persons_details/draftWS/multiUsers
 */
//@Path("/draft")

@Path("/test")
public class Test {
	
	GoralRound g1 = new GoralRound(3, 20);
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String check2222(){
		
		return "Just class";

	}
	@Path("/test1")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String check222(@Context HttpServletRequest request){
		HttpSession session = request.getSession();  
		return "Test1";

	}
	@Path("/createObj")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public int createObj(){
		g1 = new GoralRound(3, 20);  
		return 0;
	}

	

	//http://localhost:8080/Goral_Web/goral/test/showList
	@Path("/showList")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String showList(){
		//g1 = new GoralRound(3, 300);
		String str = g1.getUserList().toString();
		return str;
		  
	}
	
	@Path("/addRange")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String addRange(){
		g1.addNumbers(400, 500);
		String str = g1.getUserList().toString();
		return str;
		
	}
}
