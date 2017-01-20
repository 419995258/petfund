var systemUserAppmodule = angular.module('systemUserApp', []);

systemUserAppmodule.controller('systemUserController', function($scope, $http,
		$rootScope, $stateParams, $state) {

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
	

	
	// //////////////////////////////////////////////////////判断当前页
	$scope.pageSize = 10;// 每页多少条
	$scope.pages = 1;// 总页数
	$scope.maxSize = 10; // 一次可现实多少分页标签，超过maxSize后则以...代替
	$scope.totalItems = 1; // 总共多少条记录
	$scope.currentPage = 1; // 当前页码
	var delIdTemp = '';
	

	$scope.selectItems = [];
	$scope.queryText = '';

	var resultVo = {};

	$scope.init = function() {
		if ($state.current.name == 'systemUser') {
			$('.menu_btn').removeClass('active');
			$('#systemUser').addClass('active');
		};
		var queryTemp = [{'type':0,'name':'显示全部'},{'type':2,'name':'搜姓名'},{'type':3,'name':'搜账号'},{'type':4,'name':'搜电话'}];
		$scope.selectItems = queryTemp;
		$scope.qureyType = queryTemp[0];

		querySystemUser();
	};

	$scope.init();

	

	function querySystemUser() {
		resultVo.pageSize = $scope.pageSize;
		resultVo.currentpage = $scope.currentPage;
		
		
		resultVo.queryType = $scope.qureyType.type;
		resultVo.queryText = $scope.queryText;

		// 查询报销单信息
		$http({
			method : "POST",
			url : "../usermanageC/showUser",
			data : resultVo
		}).success(function(data, status) {
			$scope.userItems = data.rows;
			$scope.currentPage = data.pageNum; // 当前页码
			$scope.pageSize = data.pageSize;// 每页多少条
			$scope.pages = data.pages;// 总页数
			$scope.totalItems = data.total;// 总共多少条记录
		}).error(function(data, status) {
		});
	}
	;

	$scope.pageChanged = function() {
		querySystemUser();
	};

	$scope.openDelPage = function(index) {
		delIdTemp = index;
		$('#deleteModal').modal('show');
	};

	
	$scope.userItems = [];
	
	$scope.jkdIndex = ''; // 点击索引

	$scope.xqItems = {}; // 详情弹出框填入的数组

	$scope.choseD = function() { // 点击按钮
		$scope.jkdIndex = delIdTemp; // 设置选中行索引

		$http({
			method : "PUT",
			url : "../usermanageC/deleteUser",
			data : $scope.userItems[$scope.jkdIndex]
		}).success(function(data, status) {
			$scope.userItems.splice(delIdTemp, 1);
			delIdTemp = '';
			$('#deleteModal').modal('hide');
		}).error(function(data, status) {
		});

	};

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