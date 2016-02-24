var application = angular.module('loto', []);

application.controller('MainController', function($scope, $http, $window) {   
	
	$scope.submit = function() {     
		
		var fromDate = $window.document.getElementById("fromDate").value; 
		var toDate   = $window.document.getElementById('toDate')  .value;    //alert(fromDate + " " + toDate);
		//$window.alert(fromDate + " " + toDate);
		
		var keyValue = JSON.stringify({from: fromDate, to: toDate}); 
		
		$http.post('Report', keyValue, {headers: {'Content-Type': 'application/json'} }).success( function(array) {						
			
			$scope.items = array;
		});	
	
	};
	
});