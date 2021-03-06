var serviceAppmodule = angular.module('serviceApp', []);

serviceAppmodule.controller('serviceController', function($scope, $http, $rootScope, $stateParams, $state) {
	
	
	$scope.serviceItems = {};
	$scope.serviceItemsMini = [];
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
	
	var txt1 = '';
	
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
		if ($state.current.name == 'news') {
			$('.menu_btn').removeClass('active');
			$('#news').addClass('active');			
		};	
		var queryTemp = [{'type':0,'name':'显示全部'},{'type':2,'name':'搜问题'}];
		$scope.selectItems = queryTemp;
		$scope.qureyType = queryTemp[0];
		querynews();
	};

	$scope.init();
	
	

	function querynews() {
		resultVo.pageSize = $scope.pageSize;
		resultVo.currentpage = $scope.currentPage;
		resultVo.type = 5;
		resultVo.queryType = $scope.qureyType.type;
		resultVo.queryText = $scope.queryText;

		// 查询所有信息
		$http({
			method : "POST",
			url : "../newsmanageC/showNews",
			data : resultVo
		}).success(function(data, status) {
			$scope.serviceItemsMini = data.rows;
			$scope.currentPage = data.pageNum; // 当前页码
			$scope.pageSize = data.pageSize;// 每页多少条
			$scope.pages = data.pages;// 总页数
			$scope.totalItems = data.total;// 总共多少条记录
		}).error(function(data, status) {
		});
	};
	
	$scope.pageChanged = function() {
		querynews();
	};
	
	//删除确认
	$scope.openDelPage = function(index) {
		delIdTemp = index;
		$('#deleteModal').modal('show');
	};

	
	
	//////////////////////////////////////////////////////////实例化编辑器   
	var nwesum = UM.getEditor('nwesEditor');  
	//切换页面后重新初始化
    $scope.$on('$destroy', function() {
        nwesum.destroy();
    });
    
    
    
  //初始化数据
    $scope.openAddNewsPage = function() {
    	$scope.serviceItems={};
    	nwesum.ready(function() {
			/*
			 * //设置编辑器的内容 ckum1.setContent

('hello'); //获取html内容，返回: <p>hello</p>
			 * var html = ue.getContent();
			 */
			// 获取纯文本内容，返回: hello
    		nwesum.setContent('');
		});
    	$('#addModal').modal('show'); 
    	$('#xiugai').hide();
    };
    
    	//添加
	
	$scope.subNew = function() {
		
		if(sub == true){
		
		nwesum.ready(function() {
			/*
			 * //设置编辑器的内容 ckum1.setContent('hello'); //获取html内容，返回: <p>hello</p>
			 * var html = ue.getContent();
			 */
			// 获取纯文本内容，返回: hello
			txt1 = nwesum.getContent();
			$scope.serviceItems.content = txt1;
		});

		if (verifyIsNull($scope.serviceItems.title)) {
			alert("请填写摘要");
			return;
		};
		if (verifyIsNull($scope.serviceItems.content)) {
			alert("请填写内容");
			return;
		};
		
		
		$scope.serviceItems.type = 5;
		
		sub = false;
		$http({
			method : "PUT",
			url : "../newsmanageC/addNews",
			data : $scope.serviceItems,
		}).success(function(data, status) {
			if (data.success) {
				$('#addModal').modal('hide');
				$scope.serviceItems = {};
				querynews();
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
			url : "../newsmanageC/deleteNews",
			data : $scope.serviceItemsMini [$scope.jkdIndex]
		}).success(function(data, status) {
			$scope.serviceItemsMini.splice(delIdTemp, 1);
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
			url : "../newsmanageC/showNewsData",
			data : $scope.serviceItemsMini[$scope.jkdIndex]
		}).success(function(data, status) {
			$scope.serviceItems = data;
			nwesum.setContent($scope.serviceItems.content);
			XIdTemp = '';
			$('#addModal').modal('show');
		}).error(function(data, status) {
		});
	};
	
	//更新
	
	$scope.alter = function() {

		if(sub == true){
		
		if (verifyIsNull($scope.serviceItems.title)) {
			alert("请填写摘要");
			return;
		};
		if (verifyIsNull($scope.serviceItems.content)) {
			alert("请填写内容");
			return;
		};
		
		nwesum.ready(function() {
			/*
			 * //设置编辑器的内容 ckum1.setContent('hello'); //获取html内容，返回: <p>hello</p>
			 * var html = ue.getContent();
			 */
			// 获取纯文本内容，返回: hello
			txt1 = nwesum.getContent();
			$scope.serviceItems.content = txt1;
		});
		
		
		sub = false;
		$http({
			method : "PUT",
			url : "../newsmanageC/updateNews",
			data : $scope.serviceItems,
		}).success(function(data, status) {
			if (data.success) {
				$('#addModal').modal('hide');
				$scope.serviceItems = {};
				querynews();
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