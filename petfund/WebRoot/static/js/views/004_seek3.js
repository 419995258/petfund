var seek3Appmodule = angular.module('seek3App', []);

seek3Appmodule.controller('seek3Controller', function($scope, $http, $rootScope, $stateParams, $state) {
	
	////////////////////////////////////////////////////////判断当前页	
	$scope.init = function() {		
		if ($state.current.name == 'seek3') {
			$('.qz_content > a').removeClass('active');
			$('#btn_seek').addClass('active');
		};	
	};
	$scope.init();
	
	
	$scope.move = function() {
		$state.go("home", {}, { reload: true });
	};
});