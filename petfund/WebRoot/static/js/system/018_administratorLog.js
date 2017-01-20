var administratorLogAppmodule = angular.module('administratorLogApp', []);

administratorLogAppmodule.controller('administratorLogController', function($scope, $http, $rootScope, $stateParams, $state) {
	
	$scope.logItems = {};
	$scope.pageSize = 15;// 每页多少条
	$scope.pages = 1;// 总页数
	$scope.maxSize = 15; // 一次可现实多少分页标签，超过maxSize后则以...代替
	$scope.totalItems = 1; // 总共多少条记录
	$scope.currentPage = 1; // 当前页码
	var resultVo = {};
	////////////////////////////////////////////////////////判断当前页	
	$scope.init = function() {
		if ($state.current.name == 'administratorLog') {
			$('.menu_btn').removeClass('active');
			$('#administratorLog').addClass('active');		
			queryAdminLog();
		};	
	};

	$scope.init();
	
	
	//验证登录
	$http({
		method : "POST",
		url : "../adminC/ckLogined",
		//data : loginItems,
	}).success(function(data, status) {
		if (!data.success) {	
			location.href="002_systemLogin.html";
			}
	}).error(function(data, status) {
		$scope.tsText = "遭遇错误";
	});
	
	////////////////////////////////////////////////////////测试数据
	function queryAdminLog() {
		resultVo.pageSize = $scope.pageSize;
		resultVo.currentpage = $scope.currentPage;
		
		
	

		// 查询报销单信息
		$http({
			method : "POST",
			url : "../adminC/showLoginLog",
			data : resultVo
		}).success(function(data, status) {
			$scope.logItems = data.rows;
			$scope.currentPage = data.pageNum; // 当前页码
			$scope.pageSize = data.pageSize;// 每页多少条
			$scope.pages = data.pages;// 总页数
			$scope.totalItems = data.total;// 总共多少条记录
		}).error(function(data, status) {
		});
	}
	;
	
	
	$rootScope.logout = function() {
		$http({
			method : "POST",
			url : "../adminC/logout",
		}).success(function(data, status) {
			if (data.success) {	
				location.href="002_systemLogin.html";
			}
		}).error(function(data, status) {
		});
	};

});