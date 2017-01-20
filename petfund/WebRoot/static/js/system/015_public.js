var publicAppmodule = angular.module('publicApp', []);

publicAppmodule.controller('publicController', function($scope, $http, $rootScope, $stateParams, $state) {
	
	$scope.openItems={};
	$scope.openItemsMini={};
	
	$scope.pageSize = 10;// 每页多少条
	$scope.pages = 1;// 总页数
	$scope.maxSize = 10; // 一次可现实多少分页标签，超过maxSize后则以...代替
	$scope.totalItems = 1; // 总共多少条记录
	$scope.currentPage = 1; // 当前页码
	$scope.bigTotalItems = 180;
	$scope.bigCurrentPage = 1;
	
	$scope.selectItems = [];
	$scope.queryText = '';
	
	var delIdTemp = '';
	var XIdTemp = '';
	var resultVo = {};
	$scope.jkdIndex = ''; // 点击索引
	$scope.xqItems = {}; // 详情弹出框填入的数组
	
	var sub = true;
	
	
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
	////////////////////////////////////////////////////////判断当前页	
	$scope.init = function() {		
		if ($state.current.name == 'public') {
			$('.menu_btn').removeClass('active');
			$('#public').addClass('active');
		};	
		var queryTemp = [{'type':0,'name':'显示全部'},{'type':2,'name':'受助人'}];
		$scope.selectItems = queryTemp;
		$scope.qureyType = queryTemp[0];
		querypubliclty();
	};
	$scope.init();
	
	function querypubliclty() {
		resultVo.pageSize = $scope.pageSize;
		resultVo.currentpage = $scope.currentPage;
		resultVo.queryType = $scope.qureyType.type;
		resultVo.queryText = $scope.queryText;
		
		// 查询所有信息
		$http({
			method : "POST",
			url : "../othermanageC/showPublictiy",
			data : resultVo
		}).success(function(data, status) {
			$scope.openItemsMini = data.rows;
			$scope.currentPage = data.pageNum; // 当前页码
			$scope.pageSize = data.pageSize;// 每页多少条
			$scope.pages = data.pages;// 总页数
			$scope.totalItems = data.total;// 总共多少条记录
		}).error(function(data, status) {
		});
	};
	
	$scope.pageChanged = function() {
		querypubliclty();
	};
	
	//删除确认
	$scope.openDelPage = function(index) {
		delIdTemp = index;
		$('#deleteModal').modal('show');
	};
	
	
	//初始化数据
    $scope.openAddNewsPage = function() {
    	$scope.openItems={};
    	$('#addModal').modal('show'); 
    	$('#xiugai').hide();
    };

	
	
//添加
	
	$scope.subNew = function() {
		
		if(sub == true){
		
		if (verifyIsNull($scope.openItems.name)) {
			alert("请填写受助人名");
			return;
		};
		if (verifyIsNull($scope.openItems.timeStr)) {
			alert("请填写时间");
			return;
		};
		if (verifyIsNull($scope.openItems.info)) {
			alert("请填写项目");
			return;
		};
		if (verifyIsNull($scope.openItems.receivingParty)) {
			alert("请填写收款方");
			return;
		};
		if (verifyIsNull($scope.openItems.account)) {
			alert("请填写账户");
			return;
		};
		
		if (verifyIsNull($scope.openItems.money)) {
			alert("请填写捐款额");
			return;
		};
		
		sub = false;
		$http({
			method : "PUT",
			url : "../othermanageC/addPublictiy",
			data : $scope.openItems,
		}).success(function(data, status) {
			if (data.success) {
				$('#addModal').modal('hide');
				$scope.openItems = {};
				querypubliclty();
			} else {
				$('#addModal').modal('hide');
			}
			sub = true;
		}).error(function(data, status) {
		});
		}
	};
	

	//	确认删除
	$scope.choseD = function() { // 点击按钮
		$scope.jkdIndex = delIdTemp; // 设置选中行索引

		$http({
			method : "PUT",
			url : "../othermanageC/deletePublictiy",
			data : $scope.openItemsMini [$scope.jkdIndex]
		}).success(function(data, status) {
			$scope.openItemsMini.splice(delIdTemp, 1);
			delIdTemp = '';
			$('#deleteModal').modal('hide');
		}).error(function(data, status) {
		});
	};

	//查看详情
	$scope.openXPage = function(index) {
		XIdTemp = index;
		$scope.jkdIndex = XIdTemp;
		$http({
			method : "POST",
			url : "../othermanageC/showPublictiyData",
			data : $scope.openItemsMini[$scope.jkdIndex]
		}).success(function(data, status) {
			$scope.openItems = data;
			XIdTemp = '';
			$('#addModal').modal('show');
		}).error(function(data, status) {
		});
	};
	
	//更新
	
	$scope.alter = function() {
		
		if(sub == true){
		if (verifyIsNull($scope.openItems.name)) {
			alert("请填写受助人名");
			return;
		};
		if (verifyIsNull($scope.openItems.time)) {
			alert("请填写时间");
			return;
		};
		if (verifyIsNull($scope.openItems.receivingParty)) {
			alert("请填写收款方");
			return;
		};
		if (verifyIsNull($scope.openItems.account)) {
			alert("请填写账户");
			return;
		};
		
		if (verifyIsNull($scope.openItems.money)) {
			alert("请填写捐款额");
			return;
		};
				
		sub = false;
		$http({
			method : "PUT",
			url : "../othermanageC/updatePublictiy",
			data : $scope.openItems,
		}).success(function(data, status) {
			if (data.success) {
				$('#addModal').modal('hide');
				$scope.openItems = {};
				querypubliclty();
			} else {
				$('#addModal').modal('hide');
			}
			sub = true;
		}).error(function(data, status) {
		});
		}
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