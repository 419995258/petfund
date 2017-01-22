var customServiceAppmodule = angular.module('customServiceApp', []);

customServiceAppmodule.controller('customServiceController', function($scope, $http, $rootScope, $stateParams, $state) {
	
	var resultVo = {};
	$scope.newsShow = {};
	$scope.pageSize = 10;// 每页多少条
	$scope.pages = 1;// 总页数
	$scope.maxSize = 10; // 一次可现实多少分页标签，超过maxSize后则以...代替
	$scope.totalItems = 1; // 总共多少条记录
	$scope.currentPage = 1; // 当前页码
	var IdTemp = '';
	////////////////////////////////////////////////////////判断当前页	
	$scope.init = function() {		
		if ($state.current.name == 'customService') {
			$('.qz_content > a').removeClass('active');
			$('#btn_customService').addClass('active');
			
		};	
		queryCustomService();
	};
	$scope.init();
	
	function queryCustomService() {
		resultVo.pageSize = $scope.pageSize;
		resultVo.currentpage = $scope.currentPage;
		resultVo.type = 5;
		

		// 查询报销单信息
		$http({
			method : "POST",
			url : "../newsmanageC/showNews",
			data : resultVo
		}).success(function(data, status) {
			$scope.newsShow = data.rows;
			$scope.currentPage = data.pageNum; // 当前页码
			$scope.pageSize = data.pageSize;// 每页多少条
			$scope.pages = data.pages;// 总页数
			$scope.totalItems = data.total;// 总共多少条记录
		}).error(function(data, status) {
		});
	}
	;
	
	$scope.pageChanged = function() {
		queryCustomService();
	};
	

	$scope.dt = function(id){
		$state.go("customServiceContent", {id:id}, { reload: true });
	};
	

});