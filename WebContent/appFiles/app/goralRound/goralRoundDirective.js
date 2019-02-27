(function(){
	
	angular.module("goralRound.module")
	.directive("goralRoundDirective", goralRoundDirective);
	
	
	function goralRoundDirective(){
		
		var directive = {
				
				 templateUrl: "appFiles/app/goralRound/goralRound.html",
		         restrict: "E",
	            controller: "GoralRoundController"
				
		}
		return directive;
		
	}
	
}());