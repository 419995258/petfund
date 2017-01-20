var systemLoginAppmodule = angular.module('systemLoginApp', []);

systemLoginAppmodule.controller('systemLoginController', function($scope, $http, $rootScope) {
	///////////////////////////////////////////////////////////////////提交页面
	$scope.loginItems = '';
	$scope.tsText = '';
	
	$scope.subLogin = function() {
		$scope.tsText = '';
		
		//校验孩子信息
		if (verifyIsNull($scope.loginItems.username)) {		
			$scope.tsText = '请填写用户名';				
			return;
		};	
		if (verifyIsNull($scope.loginItems.password)) {		
			$scope.tsText = '请填写密码';				
			return;
		};
		
		
		//$scope.items;      //提交的表单	
		/*
		$http({
			method : "PUT",
			url : "../organizationC/addNewOrg",
			data : newOrgVo,
		}).success(function(data, status) {
			if (data.success) {	
				$state.go("seek3", {}, { reload: true });
			}
		}).error(function(data, status) {
			alert('保存失败');
		});
		*/
		
		$http({
			method : "POST",
			url : "../adminC/login",
			data : $scope.loginItems,
		}).success(function(data, status) {
			if (data.success) {	
					location.href = "001_systemIndex.html";
			} else {
				$scope.tsText = "登录失败，用户名或密码错误";
			}
		}).error(function(data, status) {
			$scope.tsText = "遭遇错误";
		});
	};
});