(function(){
	
	
	angular.module("goralRound.module")
	.service("goralRoundService",['$http', '$q', goralRoundService]);
	
	
	function goralRoundService($http, $q){
		
		
		console.log("goralRoundService Here");
		
		
		//Objects
		
		//id od this window
		this.id = {};
		var defer = $q.defer();
		
		
		
		//Functions definition
		init = function(){//http://localhost:8080/Goral_Web/goral/test3/tryJson
			
			$http({
	    		method : "GET",
	    		url:'http://localhost:8080/Goral_Web/goral/mainws/init'
	    		
	    		
			
	    		
	    		
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
	     
	     
	    //Ajax call for create round and get the right id 
	    this.createRound = function(from, to){//http://localhost:8080/Goral_Web/goral/test3/tryJson
			
	    	 
	    	roundData = {from:from, to : to};
	    	///todo - handle vice versa range
	    	return $http({
		    		method : "POST",
		    		url:'http://localhost:8080/Goral_Web/goral/test5/createNewRound',
	    			data: angular.toJson(roundData),
		    		headers : {
	                    'Content-Type' : 'application/json'
	                   ,'accept': 'application/json'
	                }
	    		
				
		    		
		    		
		    	}).then(
	 				function(response){
						console.log(response.data.id);
		    			console.log ("create round method executed");
		    			console.log(response.from + "status = " + response.status);
		    			/*
		    			defer.resolve(response.data);
		    			this.id = response.data.id;
		    			console.log("this.roundData.id = " + this.id);
		    			//return response.data.id;
		    			 this.id = defer.promise.id;
		    			 console.log("this.roundData.id = " + this.id);
		    			 */
		    			this.id = response.data.id;
		    			console.log("this.id (from the function) = " + this.id);
		    			return response.data.id;
		    			
					},function myError(response) {
					     console.log ("create round method error");
					     console.log("status = " + response.status);
					  }
		    	);
	    	
	    		
		     };//end of this function
		     this.check = function(){
		    	 
		    	 
		    	 console.log("check service");
		     };
		     
		     c = this.createRound; a= this.id;
		     this.createRound2 = function(from, to){
		    	 
		    	 
		    	 c(from, to ).then(function(data){
		    		a = data;
		    	 });
		    	 
		    	 
		    	 
		     };
		     
		     
		     
			/********************* FUNCTION INVOCATON*************************/
			//init invocation
			init();
	}//end of the service
	
	angular.module("goralRound.module")
 	.factory("factoryTest1", function($http, $q){
 		return new function(){
 			var id5 = {};
	 		 this.createRound= function(from, to){//http://localhost:8080/Goral_Web/goral/test3/tryJson
	 			var defer = $q.defer();
	 			this.id =10; 
		    	
	 	    	roundData = {from:from, to : to};
	 	    	///todo - handle vice versa range
	 	    	return $http({
	 		    		method : "POST",
	 		    		url:'http://localhost:8080/Goral_Web/goral/test5/createNewRound',
	 	    			data: angular.toJson(roundData),
	 		    		headers : {
	 	                    'Content-Type' : 'application/json'
	 	                   ,'accept': 'application/json'
	 	                }
	 	    		
	 				
	 		    		
	 		    		
	 		    	}).then(
	 	 				function(response){
	 						console.log(response.data.id);
	 		    			console.log ("create round method executed");
	 		    			console.log(response.from + "status = " + response.status);
	 		    			/*
	 		    			defer.resolve(response.data);
	 		    			this.id = response.data.id;
	 		    			console.log("this.roundData.id = " + this.id);
	 		    			//return response.data.id;
	 		    			 this.id = defer.promise.id;
	 		    			 console.log("this.roundData.id = " + this.id);
	 		    			 */
	 		    			defer.resolve(response.data);
	 		    			
	 		    			var data1 = defer.resolve(response.data);
	 		    			
	 		    			this.id = response.data.id;
	 		    			id5 = response.data.id;
	 		    			console.log("this.id (from the function) = " + this.id);
	 		    			return id5;
	 		    			
	 		    			
	 					},function myError(response) {
	 					     console.log ("create round method error");
	 					     console.log("status = " + response.status);
	 					  }
	 					
	 					
	 		    	);
	 	    	
	 	    	
	 	    	
	 	    	//return defer.promise;
	 	    	
	 		     };//end of this function
	 		     
	 		     
	 		     this.id3 ;
	 		     this.myNumber = 0; 
	 		    //Ajax for create round and get the right id 
			     this.createRound4 = function(from, to ){
			    	 roundData = {from:from, to : to};
						return $http({
				    		method : "POST",
				    		url:'http://localhost:8080/Goral_Web/goral/test5/createNewRound',
			    			data: angular.toJson(roundData),
				    		headers : {
			                    'Content-Type' : 'application/json'
			                   ,'accept': 'application/json'
			                }
			    		
						
				    		
				    		
				    	}).then(
							function(response){
								console.log(response.data.id);
				    			console.log ("create round method executed");
				    			console.log(response.from + "status = " + response.status);
				    			roundData.id = response.data.id;
				    			console.log(" response.data.id = " +  response.data.id);
				    			this.id3 = response.data.id;
				    			return roundData.id;
				    			
				    			
				    			
							},function myError(response) {
							     console.log ("create round method error");
							     console.log("status = " + response.status);
							  }
				    	);
				    	 
				     };//end of this function
				     
				     this.add2 = function(){
				    	 
				    	 this.myNumber +=2;
				    	 console.log(this.myNumber);
				     };
				     
 		}//end of factory function
 	});
	
	angular.module("goralRound.module")
 	.factory("goralRoundFactory", function($http, $q){
 		return new function(){
 			var id5 = {};
	 		 this.createRound= function(from, to){//http://localhost:8080/Goral_Web/goral/test3/tryJson
	 			var defer = $q.defer();
	 			this.id =10; 
		    	
	 	    	roundData = {from:from, to : to};
	 	    	///todo - handle vice versa range
	 	    	return $http({
	 		    		method : "POST",
	 		    		url:'http://localhost:8080/Goral_Web/goral/test5/createNewRound',
	 	    			data: angular.toJson(roundData),
	 		    		headers : {
	 	                    'Content-Type' : 'application/json'
	 	                   ,'accept': 'application/json'
	 	                }
	 	    		
	 				
	 		    		
	 		    		
	 		    	}).then(
	 	 				function(response){
	 						console.log(response.data.id);
	 		    			console.log ("create round method executed");
	 		    			console.log(response.from + "status = " + response.status);
	 		    			/*
	 		    			defer.resolve(response.data);
	 		    			this.id = response.data.id;
	 		    			console.log("this.roundData.id = " + this.id);
	 		    			//return response.data.id;
	 		    			 this.id = defer.promise.id;
	 		    			 console.log("this.roundData.id = " + this.id);
	 		    			 */
	 		    			defer.resolve(response.data);
	 		    			
	 		    			var data1 = defer.resolve(response.data);
	 		    			
	 		    			this.id = response.data.id;
	 		    			id5 = response.data.id;
	 		    			console.log("this.id (from the function) = " + this.id);
	 		    			return id5;
	 		    			
	 		    			
	 					},function myError(response) {
	 					     console.log ("create round method error");
	 					     console.log("status = " + response.status);
	 					  }
	 					
	 					
	 		    	);
	 	    	
	 	    	
	 	    	
	 	    	//return defer.promise;
	 	    	
	 		     };//end of this function
	 		     
	 		     
	 		     this.id3 ;
	 		     this.myNumber = 0; 
	 		    //Ajax for create round and get the right id 
			     this.createRound4 = function(from, to ){
			    	 roundData = {from:from, to : to};
						return $http({
				    		method : "POST",
				    		url:'http://localhost:8080/Goral_Web/goral/test5/createNewRound',
			    			data: angular.toJson(roundData),
				    		headers : {
			                    'Content-Type' : 'application/json'
			                   ,'accept': 'application/json'
			                }
			    		
						
				    		
				    		
				    	}).then(
							function(response){
								console.log(response.data.id);
				    			console.log ("create round method executed");
				    			console.log(response.from + "status = " + response.status);
				    			roundData.id = response.data.id;
				    			console.log(" response.data.id = " +  response.data.id);
				    			this.id3 = response.data.id;
				    			return roundData.id;
				    			
				    			
				    			
							},function myError(response) {
							     console.log ("create round method error");
							     console.log("status = " + response.status);
							  }
				    	);
				    	 
				     };//end of this function
				     
				     this.add2 = function(){
				    	 
				    	 this.myNumber +=2;
				    	 console.log(this.myNumber);
				     };
				     
 		}//end of factory function
 	});
}());