var contributeAppmodule = angular.module('contributeApp', []);

contributeAppmodule.controller('contributeController', function($scope, $http, $rootScope, $stateParams, $state) {
	$scope.help = {};
	var helpId = $stateParams.helpId;
	$scope.items = '';
	var contributionType = parseInt($stateParams.contributionType);
	
	////////////////////////////////////////////////////////判断当前页
	$scope.init = function() {		
		if ($state.current.name == 'contribute') {
			$('.qz_content > a').removeClass('active');
			$('#btn_offer').addClass('active');	
		};	
		
		queryHelp();
	};
	

	function queryHelp() {
		$http({
            url: '../helpC/queryHelpById',
            method: 'POST',
            data: helpId
        }).success(function (data) {
        	$scope.help = data;
        }).error(function (response) {
        });
	}
	
	$scope.init();
	
	///////////////////////////////////////////////////后台读数据
	/*
	$scope.hxskr = {};
	var queryParam = {};
	queryParam.orgId = '';
	
    $http({
			url : '../questionC/getNewReplyNumber',
			method : 'POST'
		}).success(function(data) {
			$scope.hxskr = data.rows;
		}).error(function(response) {
			// 处理响应失败
		});
	};
	
	$scope.filter = function(flag){ 
		queryParam.flag = flag;
		
		$http({
				url : '../questionC/getNewReplyNumber',
				method : 'POST'
			}).success(function(data) {
				$scope.hxskr = data.rows;
			}).error(function(response) {
				// 处理响应失败
			});
		};
	};
	*/	
	
	////////////////////////////////////////////////////////测试数据
	
	//$scope.help={'img':'../static/img/06.jpg','title':'家中贫困求帮助a','name':'赵某某a','sex':'男','age':'3','place':'天津','targetMoney':'100000','needMoney':'72030.54','peopleNum':'502','organiser':'斯蒂芬','initiateNum':'10'};	
	
	////////////////////////////////////////////////////////支付提
	$scope.paymentType = 1; 
	$scope.onChange = function(e){
		$scope.paymentType = e;
	};
	
	$scope.items = {'price':20};
	
	$scope.subZf = function(){
		var contributionVo = {};
		contributionVo.infoId = $scope.help.id;
		contributionVo.infoName = $scope.help.childName;
		contributionVo.money = $scope.items.price;
		contributionVo.name = $scope.items.name;
		contributionVo.tel = parseInt($scope.items.tel);
		contributionVo.payType = $scope.paymentType;
		contributionVo.contributionType = contributionType;
		
		$http({
			method : "PUT",
			url : "../helpC/addContribution",
			data : contributionVo
		}).success(function(data, status) {
			if (data.success) {	
				$state.go("home", {}, { reload: true });
			}
		}).error(function(data, status) {
		});
	};
	
});