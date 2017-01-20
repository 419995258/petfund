var offerAppmodule = angular.module('offerApp', []);

offerAppmodule.controller('offerController', function($scope, $http,
		$rootScope, $stateParams, $state) {
	var flag = $stateParams.flag;
	$scope.offer = $stateParams.offer;
	$scope.querttest = '';
	$scope.querttest = $scope.$parent.querttest;


	
	// //////////////////////////////////////////////////////判断当前页
	function init() {
		if ($state.current.name == 'offer') {
			$('.qz_content > a').removeClass('active');
			$('#btn_offer').addClass('active');
		}
		;

		queryHelp();
	}
	;

	// //////////////////////////////////////////////////////测试数据
	$scope.maxSize = 10; // 一次可现实多少分页标签，超过maxSize后则以...代替
	$scope.totalItems = 20; // 总共多少条记录
	$scope.currentPage = 1; // 当前页码
	$scope.pageSize = 8;// 每页多少条
	$scope.pages = 0;// 总页数
	var type = 1;
	var queryParam = {};
	queryParam.pageSize = $scope.pageSize;
	queryParam.currentpage = $scope.currentPage;
	$scope.ifChoukuan = true;// 是否显示孩子的年龄等字段

	$scope.changeNav = function(i) {
		if (i == 'h1') {
			type = 1;
			$('.offer_nav > li').removeClass('active');
			$('#offerNavBtn1').addClass('active');
			$scope.ifChoukuan = true;
		} else if (i == 'h2') {
			type = 2;
			$('.offer_nav > li').removeClass('active');
			$('#offerNavBtn2').addClass('active');
			$scope.ifChoukuan = false;
		} else if (i == 'h3') {
			type = 3;
			$('.offer_nav > li').removeClass('active');
			$('#offerNavBtn3').addClass('active');
			$scope.ifChoukuan = false;
		}
		;

		queryHelp();
	};

	$scope.pageChanged = function() {
		queryHelp();
	};

	$scope.detail = function(index) {
		var helpid = '';
		helpid = $scope.helps[index].id;
		if (helpid != '') {
			$state.go("project", {
				id : helpid
			}, {
				reload : true
			});
		}

	};

	function queryHelp() {
		if (flag == 1) {
			if ($scope.currentPage == undefined) {
				$scope.currentPage = 1;
			}

			queryParam.currentpage = $scope.currentPage;
			queryParam.queryType = type;

			$http({
				url : '../helpC/queryHelp',
				method : 'POST',
				data : queryParam
			}).success(function(data) {
				$scope.totalItems = data.total; // 总共多少条记录
				$scope.currentPage = data.pageNum; // 当前页码
				$scope.pageSize = data.pageSize;// 每页多少条
				$scope.pages = data.pages;// 总页数
				$scope.helps = data.rows;
			});

		} else if(flag==2){
			if ($scope.currentPage == undefined) {
				$scope.currentPage = 1;
			}
			queryParam.currentpage = $scope.currentPage;
			
			queryParam.queryText = $scope.querttest;
			

			$http({
				url : '../helpC/showChild',
				method : 'POST',
				data : queryParam
			}).success(function(data) {
				$scope.totalItems = data.total; // 总共多少条记录
				$scope.currentPage = data.pageNum; // 当前页码
				$scope.pageSize = data.pageSize;// 每页多少条
				$scope.pages = data.pages;// 总页数
				$scope.helps = data.rows;
			});
			
			
			
			//$scope.helps = $scope.$parent.showChild;
		};
	}

	$scope.jk = function(id) {
		$state.go("contribute1", {
			helpId : id,
			contributionType : 1
		}, {
			reload : true
		});
	};
	$scope.dt = function(id) {
		$state.go("project1", {
			id : id
		}, {
			reload : true
		});
	};

	init();
	
	/*$scope.toUrl = function(url) {
		url="http://"+url;
		window.location.href=url;
	};*/
});