(function () {
	
	'use strict';
	angular.module('mainApp.module').config(['$routeProvider','$locationProvider', organizeMenu]);
	
	function organizeMenu($routeProvider, $locationProvider){
		$locationProvider.hashPrefix('');
		
		 $routeProvider.
         
    
		
		   
         when('/homepage', {//define to each URL template and controller properly.
            templateUrl:  'appFiles/app/mainApp/homepageView.html',
            controller: 'MainAppController'
         }).
         
         when('/aa', {//define to each URL template and controller properly.
             templateUrl:  'aa.html',
             controller: 'GoralRoundController'
          });/*
         otherwise({
             redirectTo: '/homepage'
          });
		*/
		
		/*
		 $routeProvider.
         
         when('/addStudent', {//define to each URL template and controller properly.
            templateUrl: 'addStudent.htm',
            controller: 'AddStudentController'
         }).
         
         when('/viewStudents', {
            templateUrl: 'viewStudents.htm',
            controller: 'ViewStudentsController'
         }).
         
         when('/check1', {
             templateUrl: 'check1.html',
             controller: 'check1Controller'
          }).
         
         otherwise({
            redirectTo: '/addStudent'
         });
		*/
	};
	
	// mainApp.config(['$routeProvider', function($routeProvider) {
     //       $routeProvider.
	
	
	
	
}());