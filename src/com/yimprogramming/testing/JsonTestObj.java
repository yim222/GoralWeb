package com.yimprogramming.testing;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class JsonTestObj{

	
	
	private String x = "I am X";
	private String y = "I am Y";
	
	public JsonTestObj(){
		
	}

	public JsonTestObj(String x, String y) {
		super();
		this.x = x;
		this.y = y;
	}

	public String getX() {
		return x;
	}

	public void setX(String x) {
		this.x = x;
	}

	public String getY() {
		return y;
	}

	public void setY(String y) {
		this.y = y;
	}
	@Override
	public String toString(){
		
		return "hey";
		
	}
	
	
	
}
