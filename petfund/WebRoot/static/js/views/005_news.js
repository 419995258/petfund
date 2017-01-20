var newsAppmodule = angular.module('newsApp', []);

newsAppmodule.controller('newsController', function($scope, $http, $rootScope, $stateParams, $state) {
	////////////////////////////////////////////////////////判断当前页
	function init(){		
		if ($state.current.name == 'news') {
			$('.qz_content > a').removeClass('active');
			$('#btn_news').addClass('active');
		};	
		
		queryNews();
	};
	$scope.pageSize = 15;// 每页多少条
	$scope.maxSize = 15; //一次可现实多少分页标签，超过maxSize后则以...代替
    $scope.totalItems = 15; //总共多少条记录
    $scope.currentPage = 1; //当前页码
    $scope.pages = 1;//总页数
    
    var queryParam = {};
    queryParam.pageSize = $scope.maxSize;
    queryParam.currentpage = $scope.currentPage;
	
	////////////////////////////////////////////////////////设置当前显示的新闻
	$scope.newsShow = [];
	var type = 1;
	
	$scope.changeNews = function(index){
		if(index == 1){
			type = 1;
		}else if(index == 2){
			type = 2;
		}else if(index == 3){
			type = 3;
		}else if(index == 4){
			type = 4;
		};
		
		queryNews();
	};

	$scope.pageChanged = function () {
    	queryNews();
    };
	
	//查询新闻
    function queryNews() {
    	queryParam.currentpage = $scope.currentPage;
    	queryParam.pageSize = $scope.pageSize;
    	queryParam.type = type;
    	
        $http({
            url: '../newsC/queryNews',
            method: 'POST',
            data: queryParam
        }).success(function (data) {
        	$scope.totalItems = data.total; //总共多少条记录
    	    $scope.currentPage = data.pageNum; //当前页码
    	    $scope.pages = data.pages;
    	    $scope.newsShow = data.rows;
        }).error(function (response) {
        });
    };
    
    $scope.newsContent = function(index) {
    	$state.go("newsContent", {id:$scope.newsShow[index].id}, { reload: true });
    };
    
	init();
});