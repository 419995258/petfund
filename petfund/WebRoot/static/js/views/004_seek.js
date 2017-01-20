var seekAppmodule = angular.module('seekApp', []);

seekAppmodule.controller('seekController', function($scope, $http, $rootScope, $stateParams, $state) {

	////////////////////////////////////////////////////////判断当前页	
	$scope.init = function() {		
		if ($state.current.name == 'seek') {
			$('.qz_content > a').removeClass('active');
			$('#btn_seek').addClass('active');
		};	

	};
	$scope.init();

	$scope.gotoHelp = function() {
		$scope.checkLoginReturn("seek2", {}, "seek2");
	};

	$scope.gotopage='seek'
	$scope.checkLogin = function() {
		/*		$('.qz_content > a').removeClass('active');
		 angular.element(document.querySelector(this)).addClass("active");*/
		/*var par = document.getElementsByTagName('a')[3];
		 angular.element(par).addClass('active');*/
		/*		$(e).addClass('active');*/

		$http({
			method : "POST",
			url : "../userC/checkLogin"
		}).success(function(data, status) {
			if (data.success) {
				$scope.showUserState=true;
				$state.go("seek2", {}, { reload: true });
			} else {
				$scope.showUserState=false;
				$state.go("login", {}, { reload: true });
			}
		}).error(function(data, status) {
		});
	};
});