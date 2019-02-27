package com.yimprogramming.client.test;

import java.net.URI;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.client.ClientConfig;

import com.yimprogramming.testing.JsonTestObj;

/**
 * 
 * @author lingar
 *A class for testing the web services
 */
public class TestWS {
	private static URI getBaseURI() {
	    return UriBuilder.fromUri("http://localhost:8080/Goral_Web").build();
	  }
	
	
	public static void main(String[] args) {
		ClientConfig config = new ClientConfig();
	    Client client = ClientBuilder.newClient(config);//creating client
	    
	    
	    WebTarget service = client.target(getBaseURI());
	    
	    //goral/test2
	    Response response = service.path("goral").path("test2").request().accept(MediaType.TEXT_PLAIN).get();
	    System.out.println(response.getStatus());
	    
	    
	    response = service.path("goral").path("test2").request().accept(MediaType.TEXT_PLAIN).get();
	    System.out.println(response.getStatus());
	    
	    //Entity.entity(form,MediaType.APPLICATION_FORM_URLENCODED)
	    
	    
	    JsonTestObj j = new JsonTestObj("xxx", "yyy");
	    response = service.path("goral").path("test3").path("tryJson")
	    		.request(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
	    		.post(Entity.entity(j,MediaType.APPLICATION_JSON),Response.class); 
	    System.out.println(response.getStatus());
	}
	 
	
     
     
     
	

}
