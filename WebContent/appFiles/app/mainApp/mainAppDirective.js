(function(){
	
	angular.module("mainApp.module")
	.directive("mainAppDirective", mainAppDirective);
	
	
	function mainAppDirective(){
		
		var directive = {
				
				 templateUrl: "appFiles/app/mainApp/mainApp.html",
		         restrict: "E",
	            controller: "MainAppController"
				
		}
		return directive;
		
	}
	 
}());