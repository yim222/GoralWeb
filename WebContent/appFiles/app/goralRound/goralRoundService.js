(function(){
	
	
	angular.module("goralRound.module")
 	.factory("goralRoundFactory", ["$http", "$q", goralRoundFactory]);
 	
	function goralRoundFactory($http, $q){
 		return new function(){
 			 
 			
 			
 			/**     Functions Definitons ******************/

 			/**
 			 * Function that 
 			 * Make initial reuire process to the page.
 			 * It's check if the session is new and assign it a new Map 
 			 * of rounds if does. 
 			 * see the server side for further info.
 			 */
 			init = function(){
 				
 				$http({
 		    		method : "GET",
 		    		//url:'../Goral-Lottery-Program/goral/mainws/init'
 		    		url:'../Goral-Lottery-Program/goral/mainws/init'
 		    		
 				
 		    		
 		    		
 		    	}).then(
 					function(response){	
 		    			console.log ("init method executed");
 		    			console.log("status = " + response.status);

 		    			
 		    			
 					},function myError(response) {
 					     console.log ("init method error");
 			    		console.log("status = " + response.status);

 					  }
 					
 					
 		    	);
 		    	 
 		     };//end of this function
 			/**
 			 * Function that 
 			 * Create new round and return its id
 			 */
	 		 this.createRound = function(from, to){//../Goral-Lottery-Program/goral/test3/tryJson
	 			
	 			console.log("goralRoundFactory Here44");
	 			
	 			
	 	    	roundData = {from:from, to : to};
	 	    	
	 	    	//VALIDATION
	 	    	console.log("the value of the validation: " + this.validateFromToInput(roundData));
	 	    	if (!this.validateFromToInput(roundData)){
	 	    		console.log("one of the input not a number!");
	 	    		//assign message to the sysMsg
	    			data = {sysMsg: "One of the input is not a number! U must insert numerical values...\n" +
	    					"or \"from value\" isn't low from \"to value\"" };
	    			 return $q.when(data);

	 	    		
	 	    		
	 	    	}
	 	    	
	 	    	
	 	    	
	 	    	//this method return all the http request.
	 	    	//It's must because the asynchronous issues
	 	    	return $http({
	 		    		method : "POST",// u here
	 		    		url:'../Goral-Lottery-Program/goral/mainws/createNewRound',
	 	    			data: angular.toJson(roundData),
	 		    		headers : {
	 	                    'Content-Type' : 'application/json'
	 	                   ,'accept': 'application/json'
	 	                }
	 	    		
	 				
	 		    		
	 		    	//If all good... 
	 		    	}).then(
	 	 				function(response){
	 	 					
	 						//Log data about the details
	 		    			console.log ("create round method executed");
	 		    			console.log( "status = " + response.status);
	 		    			
	 		    			console.log("created new round. \n" +
	 		    					"From " + response.data.from + " To " + response.data.to
	 		    					+" id = " + response.data.id);
	 		    			//assign message to the sysMsg
	 		    			data = {id: response.data.id, sysMsg: "New Round Created From " + response.data.from
	 		    					+ " To " + response.data.to};
	 		    			return data;
	 		    			
	 		    		//If fail...
	 					},function myError(response) {
	 					     console.log ("create round method error");
	 					     console.log("status = " + response.status);
	 					     data.sysMsg = "There is a problem. New round not created";
	 					     return data; 
	 					  }
	 					
	 		    	);//end of the http request
	 	    	
	 	    	
	 		 };//end of this function
	 		 
	 		 
	 		this.getList = function(id){//../Goral-Lottery-Program/goral/test3/tryJson
				//list = null;
				return $http({
				
		    		method : "GET",
		    		//url:'../Goral-Lottery-Program/goral/test4/displayList2/'+id,
		    			    		url:'../Goral-Lottery-Program/goral/mainws/getList/' + id,
		    		headers : {
	                   
	                }
				
		    		
		    		
			    	}).then(
						function(response){	
			    			console.log("Get list id " + id );
			    			console.log(""+response.data);
			    			//returning from the function the current list/ 
			    			return response.data;
						},
						//if error
						function myError(response){
							
							console.log ("Get list id " + id + "NOT work");
							console.log ("Status = " + response.status);
						}
						
		    	);
				
		     };//end of this function
 	    	
		     this.addRange = function(from, to, id){
		    	 
		    	roundData = {from: from, to: to, id: id};
		    	
		    	//VALIDATION
	 	    	console.log("the value of the validation: " + this.validateFromToInput(roundData));
	 	    	if (!this.validateFromToInput(roundData)){
	 	    		console.log("one of the input not a number!");
	 	    		//assign message to the sysMsg
	    			data = {sysMsg: "One of the input is not a number! U must insert numerical values...\n" +
	    					"or \"from value\" isn't low from \"to value\"" };
	    			 return $q.when(data);

	 	    		
	 	    		
	 	    	}
	 	    	
				return	$http({
			    		method : "POST",
			    		//url:'../Goral-Lottery-Program/goral/test5/addRange3',
			    		url:'../Goral-Lottery-Program/goral/mainws/addRange',
		    			data: angular.toJson(roundData),
			    		headers : {
		                    'Content-Type' : 'application/json'
		                   ,'accept': 'application/json'
		                }
		    		
					
			    		
			    		
			    	}).then(
						function(response){
							//Log data about the details
	 		    			console.log ("add range  method executed");// from " + roundData.from
	 		    					//+" to " + roundData.to);
	 		    			console.log( "status = " + response.status);
	 		    			
	 		    			console.log("Adding New Range. \n" +
	 		    					"From " + response.data.from + " To " + response.data.to
	 		    					+" id = " + response.data.id);
	 		    			//assign message to the sysMsg
	 		    			data = {sysMsg: "Range Added From " + response.data.from 
	 		    					+ " To " + response.data.to };
	 		    			return data;
			    			
			    			
			    			
						},function myError(response) {
						     console.log ("Add Range method error");
						     console.log("status = " + response.status);
						     data = {sysMsg: "There is a problem. New range didn't added to " +
						     		"the list. Maybe u haven't created new list? " };
		 		    			return data;
						  }
			    	);
			    	 
			     };//end of this function
			     
			     //function for add singles numbers
			 	this.addSingles =function(someNumbers, id){
			    	 roundData = {someNumbers: someNumbers, id: id};
			    	 
			    	
			 		return $http({
			    		method : "POST",
			    		//url:'../Goral-Lottery-Program/goral/test5/addSingles2',
			    		url:'../Goral-Lottery-Program/goral/mainws/addSingles',
		    			data: angular.toJson(roundData),
			    		headers : {
		                    'Content-Type' : 'application/json'
		                   ,'accept': 'application/json'
		                }
		    		
					
			    		
			    		
			    	}).then(
						function(response){
							
			    			console.log ("add Singles - \n " + someNumbers + "\nmethod executed");
			    			
			    			
			    			data.sysMsg = "Singles " + someNumbers + " have added to the list";
			    			
			    			return data;
			    			
			    			
						},function myError(response) {
						     console.log ("Add singles method error");
						     console.log("status = " + response.status);
						     data = {sysMsg: "There is a problem. The singles didn't added to " +
					     		"the list. Maybe u haven't created new list? " };
	 		    			return data;
						  }
			    	);
			    	 
			     };//end of function
			     
			     //Function for remove range from the list
			     this.removeRange = function(from, to, id){
			    	 
				    	roundData = {from: from, to: to, id: id};
				    	
				    	//VALIDATION
			 	    	console.log("the value of the validation: " + this.validateFromToInput(roundData));
			 	    	if (!this.validateFromToInput(roundData)){
			 	    		console.log("one of the input not a number!");
			 	    		//assign message to the sysMsg
			    			data = {sysMsg: "One of the input is not a number! U must insert numerical values...\n" +
			    					"or \"from value\" isn't low from \"to value\"" };
			    			 return $q.when(data);

			 	    		
			 	    		
			 	    	}
						return	$http({
					    		method : "POST",
					    		url:'../Goral-Lottery-Program/goral/mainws/removeRange',
				    			data: angular.toJson(roundData),
					    		headers : {
				                    'Content-Type' : 'application/json'
				                   ,'accept': 'application/json'
				                }
				    		
							
					    		
					    		
					    	}).then(
								function(response){
									//Log data about the details
			 		    			console.log ("remove range  method executed");// from " + roundData.from
			 		    					//+" to " + roundData.to);
			 		    			console.log( "status = " + response.status);
			 		    			
			 		    			console.log("Removing Range. \n" +
			 		    					"From " + roundData.from + " To " + roundData.to
			 		    					+" id = " + roundData.id);
			 		    			//assign message to the sysMsg
			 		    			data = {sysMsg: "Range Removed From " + roundData.from 
			 		    					+ " To " + roundData.to };
			 		    			return data;
					    			
					    			
					    			
								},function myError(response) {
								     console.log ("Remove Range method error");
								     console.log("status = " + response.status);
								     data = {sysMsg: "There is a problem. range didn't removed from " +
								     		"the list. Maybe u haven't created new list? " };
				 		    			return data;
								  }
					    	);
					    	 
				};//end of this function
			    
				
				 //function for remove singles numbers
			 	this.removeSingles =function(someNumbers, id){
			    	 roundData = {someNumbers: someNumbers, id: id};
			    	 
			 		return $http({
			    		method : "POST",
			    		//url:'../Goral-Lottery-Program/goral/test5/removeSingles2',
			    		url:'../Goral-Lottery-Program/goral/mainws/removeSingles',
		    			data: angular.toJson(roundData),
			    		headers : {
		                    'Content-Type' : 'application/json'
		                   ,'accept': 'application/json'
		                }
		    		
					
			    		
			    		
			    	}).then(
						function(response){
							
			    			console.log ("remove Singles - \n " + someNumbers + "\nmethod executed");
			    			
			    			
			    			data.sysMsg = "Singles " + someNumbers + " have removed from the list";
			    			
			    			return data;
			    			
			    			
						},function myError(response) {
						     console.log ("remove singles method error");
						     console.log("status = " + response.status);
						     data = {sysMsg: "There is a problem. The singles didn't removed from " +
					     		"the list. Maybe u haven't created new list? " };
	 		    			return data;
						  }
			    	);
			    	 
			     };//end of function
			     
			     
			     //the drawing
			     this.getNRandoms = function(drawnedAmt, id){
			    	 
			    	 roundData = {drawnedAmt : drawnedAmt, id: id};
						return $http({
				    		method : "POST",
				    		url:'../Goral-Lottery-Program/goral/test5/drawNumbers',
			    			data: angular.toJson(roundData),
				    		headers : {
			                    'Content-Type' : 'application/json'
			                   ,'accept': 'application/json'
			                }
			    		
						
				    		
				    		
				    	}).then(
							function(response){
								
				    			data.drawnedNumbers = response.data;
				    			data.sysMsg = drawnedAmt + " numbers Drawned";
				    			console.log("The Drawned Numbers: \n" + response.data);
				    			return data; 
				    			
				    			
				    			
							},function myError(response) {
							     console.log ("getNNumbers  method error");
							     console.log("status = " + response.status);
							     
							     data.sysMsg = "getNNumbers  method error";
							     return data; 
							  }
				    	);
				    	 
				     };//end of this function
				     
				     
				     
				     /**
				      * Validate the input if number and if the range correct,
				      * at 2 ranges functions
				      */
				     this.validateFromToInput = function(values){
				    	 //if it's not numbers
				    	 console.log(values.from + "-from")
				    	 if(isNaN(values.from) || isNaN(values.to) ){
				    		 
				    		 console.log ("NAN3333");
				    		 return false;
				    	 }
				    		 
				    		 
				    		 
				    	 //if the ranges is not correct...
				    	 //...U hre 
				    	 if(values.from >= values.to){
				    		 
				    		 console.log ("from is not low then to");
				    		 return false;
				    	 }
				    	
				    	 return true;
				    					    	 
				     }
				     
				     /**
				      * Validate the input if number at single value functiion
				      * 
				      */
				     this.validateSingleInput = function(value){
				    	 
				    	 //if it's not numbers(NaN)
				    	 console.log(value  + " = value ")
				    	 if(isNaN(value) ){
				    		 
				    		 console.log ("NAN - singles");
				    		 return false;
				    	 }
				    		 
				    	return true;
				    	
				    	 
				    	 
				    	 
				    	 
				    	 
				     }
			     
	 		/********************* FUNCTION INVOCATON*************************/
			//init invocation
			init();
	 		 		    
 		}//end of factory function
 	};
}());