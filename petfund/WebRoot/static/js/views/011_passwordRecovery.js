var passwordRecoveryAppmodule = angular.module('passwordRecoveryApp', []);

passwordRecoveryAppmodule.controller('passwordRecoveryController', function($scope, $http, $rootScope, $stateParams, $state) {		
	
	////////////////////////////////////////////////////////判断当前页
	$scope.init = function() {		
		if ($state.current.name == 'passwordRecoveryApp') {
			$('.qz_content > a').removeClass('active');
			$('#btn_userCenter').addClass('active');			
		};	
	};
	$scope.init();
	
	///////////////////////////////////////////////////////////////////提交页面
	$scope.items = '';
	$scope.tsText = '';
	
	$scope.subNew = function() {
		$scope.tsText = '';
		var username = $scope.items.username;
		//校验
		if (verifyIsNull($scope.items.username)) {		
			$scope.tsText = '请填写邮箱';	
			return;
		};	
		
		
		
		
		
		$http({
			method : "PUT",
			url : "../userC/recoveryPass",
			data : username,
		}).success(function(data, status) {
			if (data.success) {	
				$state.go("passwordRecovery2", {}, { reload: true });
			}else{
				$scope.tsText = data.message;
			}
		}).error(function(data, status) {
			alert('保存失败');
		});
		
	};
	
});