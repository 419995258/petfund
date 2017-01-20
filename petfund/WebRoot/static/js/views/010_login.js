var loginAppmodule = angular.module('loginApp', []);

loginAppmodule.controller('loginController', function($scope, $http, $rootScope, $stateParams, $state) {
	var page = $stateParams.pageName;
	////////////////////////////////////////////////////////判断当前页
	$scope.init = function() {

		if ($state.current.name == 'login') {
			$('.qz_content > a').removeClass('active');
			$('#btn_userCenter').addClass('active');
		};
	};
	$scope.init();

	///////////////////////////////////////////////////////////////////提交页面
	$scope.items = '';
	$scope.tsText = '';

	$scope.gotopage='seek2';
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
				$state.go("login1", {}, { reload: true });
			}
		}).error(function(data, status) {
		});
	};

	$scope.subNew = function() {
		$scope.tsText = '';

		//校验孩子信息
		if (verifyIsNull($scope.items.username)) {
			$scope.tsText = '请填写用户名';
			return;
		};
		if (verifyIsNull($scope.items.password)) {
			$scope.tsText = '请填写密码';
			return;
		};


		//$scope.items;      //提交的表单
		$http({
			method : "PUT",
			url : "../userC/userLogin",
			data : $scope.items,
		}).success(function(data, status) {
			if (data.success) {
				$scope.$parent.user = data.result.user;
				$scope.$parent.saveCookie();
				$state.go(page, $scope.$parent.paramTemp, { reload: true });
				
			}else{
				$scope.tsText = '账号或密码错误';
			}
		}).error(function(data, status) {
			alert('保存失败');
		});

	};

});