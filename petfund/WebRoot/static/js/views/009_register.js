var registerAppmodule = angular.module('registerApp', []);

registerAppmodule.controller('registerController', function($scope, $http,$cookies,
		$rootScope, $stateParams, $state) {
	
	// //////////////////////////////////////////////////////判断当前页
	$scope.init = function() {
		if ($state.current.name == 'register') {
			$('.qz_content > a').removeClass('active');
			$('#btn_userCenter').addClass('active');
		}
		;
	};
	$scope.init();

	// /////////////////////////////////////////////////////////////////提交页面
	$scope.items = '';
	$scope.tsText = '';

	$scope.subNew = function() {
		$scope.tsText = '';
		var tel = $scope.items.tel;
		var email = $scope.items.username;

		// 校验孩子信息
		if (verifyIsNull($scope.items.username)) {
			$scope.tsText = '请填写邮箱';
			return;
		}
		;
		
		if (!/^(\w-*\.*)+@(\w-?)+(\.\w{2,})+$/g.test(email)) {
			$scope.tsText = '邮箱格式错误,请确认';
			return false;
		};
		if (verifyIsNull($scope.items.password)) {
			$scope.tsText = '请填写密码';
			return;
		}
		;
		if (verifyIsNull($scope.items.passwordAgain)) {
			$scope.tsText = '请再次填写密码';
			return;
		}
		;
		if ($scope.items.password != $scope.items.passwordAgain) {
			$scope.tsText = '两次输入的密码不一致';
			return;
		}
		;
		if (verifyIsNull($scope.items.tel)) {
			$scope.tsText = '请填写手机号';
			return;
		};
		if (!/^1\d{10}$/g.test(tel)) {
			$scope.tsText = '手机号格式错误,请确认';
			return ;
		};
		
		

		$http({
			method : "PUT",
			url : "../userC/registerController",
			data : $scope.items,
		}).success(function(data, status) {
			if (data.success) {
				$scope.$parent.user = data.result.user;
				$scope.$parent.saveCookie();
				$state.go("home", {}, {reload : true});
			} else {
				$scope.tsText = '用户名或手机号重复';
				return;
			}
		}).error(function(data, status) {
			alert('保存失败');
		});
	};

	/*$scope.checkTel = function() {
		$scope.tsText = '';
		var tel = document.all("tel").value;

		if (/^1\d{10}$/g.test(tel)) {
			// $scope.tsText ='手机号正确';
		} else {
			$scope.tsText = '手机号格式错误,请确认';
			document.all("tel").focus();
			return false;
		}

	};

	$scope.checkEmail = function() {
		$scope.tsText = '';
		var email = document.all("email").value;

		if (/^(\w-*\.*)+@(\w-?)+(\.\w{2,})+$/g.test(email)) {
			// $scope.tsText ='邮箱正确';
		} else {
			$scope.tsText = '邮箱格式错误,请确认';
			document.all("email").focus();
			return false;
		}

	};*/
});