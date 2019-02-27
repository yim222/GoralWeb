package com.yimprogramming.web.services.utils;

public class GoralRoundJson {
	
	
	private int from, to, id, drawnedAmt;
	
	private  Integer[] someNumbers ;
	
	
	



	public GoralRoundJson() {
		super();
	}




	public GoralRoundJson(int from, int to, int id, Integer[] someNumbers) {
		super();
		this.from = from;
		this.to = to;
		this.id = id;
		this.someNumbers = someNumbers;
		this.drawnedAmt = drawnedAmt;
	}


	public GoralRoundJson(int from, int to, int id,int drawnedAmt, Integer[] someNumbers) {
		super();
		this.from = from;
		this.to = to;
		this.id = id;
		this.someNumbers = someNumbers;
		this.drawnedAmt = drawnedAmt;
	}

	public int getFrom() {
		return from;
	}




	public void setFrom(int from) {
		this.from = from;
	}




	public int getTo() {
		return to;
	}




	public void setTo(int to) {
		this.to = to;
	}




	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}
	public Integer[] getSomeNumbers() {
		return someNumbers;
	}




	public void setSomeNumbers(Integer[] someNumbers) {
		this.someNumbers = someNumbers;
	}




	public int getDrawnedAmt() {
		return drawnedAmt;
	}




	public void setDrawnedAmt(int drawnedAmt) {
		this.drawnedAmt = drawnedAmt;
	}

	
	
	
}
