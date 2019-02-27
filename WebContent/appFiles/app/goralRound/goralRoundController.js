(function(){
	
	
	'use strict';
	
	angular.module('goralRound.module')
	.controller('GoralRoundController',['$scope','goralRoundFactory',
	                                    GoralRoundController]);
	
	function GoralRoundController($scope, goralRoundFactory){
			
		
		/**
		 * Function that
		 * create new Goral round by the factory
		 */
		$scope.createRound = function(from, to){
			
			goralRoundFactory.createRound(from, to).then(function(data ){
				
				$scope.roundData.id = data.id;
				$scope.sysMsg = data.sysMsg;
				
				
				$scope.getList(data.id);
				console.log("The List: " + $scope.roundData.list );
				
			});
			
			
		} ;
		
		//validateSingleInput
		/**
		 * Function GetList
		 * that get the list and can display it
		 * 
		 */
		
		$scope.getList3 = function(){
			
			alert("hi");
			
		};
		
		$scope.test3 = function(from, to){
			
			$scope.getList(from, to).then(function(){
				
				$scope.getList($scope.roundData.id);
				
			});
			
			
			
		};
			
		/**
		 * Function for get list
		 */
		$scope.getList = function(id){
			
			goralRoundFactory.getList(id).then(function(data){
				
				$scope.roundData.list = data ;
				return data;
			});
			
			
		};
		
		/**
		 * Function for add range
		 */
		$scope.addRange = function(from, to){
			
			//call the http request and then other actions by callback
			goralRoundFactory.addRange(from, to, $scope.roundData.id).then(function(data){
				
				$scope.getList($scope.roundData.id);
				$scope.sysMsg = data.sysMsg;
				
				
			});
			
			
			
		};
		
		/**
		 * Function for push single to the array propely with validation
		 */
		
		$scope.pushSingles = function(value, arr){
			// U HERE
			//validateSingleInput
			/*
			if(!value){
				
				alert("undefined");
				
				return;
			}
			*/
			console.log("pushsingles start");
			/*
			
			if (!goralRoundFactory.validateSingleInput(value) ||( value != 0 && !(value) ) ){
				
				//$scope.sysMsg = goralRoundFactory.validateSingleInput(value); 
				$scope.sysMsg = "One of the input is not a number! U must insert numerical values...";
				//value = null;
				
				
			}
			else{
				arr.push(value);
			}
			
			*/

			///
			if (isNaN(value) ||( value != 0 && !(value) ) ){
				
				//$scope.sysMsg = goralRoundFactory.validateSingleInput(value); 
				console.log("One of the input is not a number! U must insert numerical values..." ) ;
				//value = null;
				
				
			}
			else{
				arr.push(value);
			}
			$scope.addSingleVal = null;
			console.log("pushsingles end");
		};
		
		/**
		 * Function for add singles
		 */
		
		$scope.addSingles = function(someNumbers){
			
			goralRoundFactory.addSingles(someNumbers, $scope.roundData.id).then(function(data){
				
				$scope.getList($scope.roundData.id);
				$scope.sysMsg = data.sysMsg;
				
			});
			
			
		}
		
		/**
		 * Function for add range
		 */
		$scope.removeRange = function(from, to){
			
			//call the http request and then other actions by callback
			goralRoundFactory.removeRange(from, to, $scope.roundData.id).then(function(data){
				
				$scope.getList($scope.roundData.id);
				$scope.sysMsg = data.sysMsg;
				
				
			});
			
			
			
		};
		
		/**
		 * Function for remove singles
		 */
		
		$scope.removeSingles = function(someNumbers){
			
			goralRoundFactory.removeSingles(someNumbers, $scope.roundData.id).then(function(data){
				
				$scope.getList($scope.roundData.id);
				$scope.sysMsg = data.sysMsg;
				
			});
			
			
		}
		
		/**
		 * Function for make the drawn and get the drawned numbers
		 */
		
		$scope.getNRandoms = function(drawnedAmt){ 		
			
			goralRoundFactory.getNRandoms(drawnedAmt, $scope.roundData.id).then(function(data){
				
				if (data.drawnedNumbers){
					$scope.roundData.drawnedNumbers = data.drawnedNumbers;
				}
				$scope.sysMsg = data.sysMsg;
				
				
			});
			
		}
		
		
		//function for testing things
		$scope.log = function(){
			
			console.log("$scope.roundData.id:");
			console.log($scope.roundData.id);
			//list = goralRoundFactory.getList($scope.roundData.id);
			//console.log ("list = " + list);
			//$scope.roundData.list = [1,2,3];
			console.log($scope.roundData.list);
			//console.log("var1 = " + var1);
			//roundData = {from : 150, to: 165};
			goralRoundFactory.addRange(150, 165, $scope.roundData.id).then(function(data){
				
				$scope.getList($scope.roundData.id);
				$scope.sysMsg = data.sysMsg;
			});//then(function(data )
			
		};
		$scope.test1 = function(){
			
			return 2;
		}
		
		
		
		/**
		 * Variables
		 */
		
		$scope.roundData = {
				id:null,
				list: null,
				drawnedAmt: null,
				drawnedNumbers: null
				
		};
		
		$scope.addSingleVal = null;
		
		
	}	
}());