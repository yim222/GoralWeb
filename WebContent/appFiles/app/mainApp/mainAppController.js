(function(){
	
	
	'use strict';
	
	angular.module('mainApp.module')
	.controller('MainAppController',['$scope', 'mainAppService',MainAppController]);
	
	function MainAppController($scope, mainAppService){
		
		$scope.test1 = "I am scope.test1";
		$scope.testDirective = "I am test variable in mainApp controller";
		
	}
	
}());