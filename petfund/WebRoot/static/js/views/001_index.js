angular.module('phonecatFilters', ['ngCookies'])
.filter('sexFilter', function() {
  return function(input) {
	  var val = '';
	  
	  switch (input) {
		case 1:
			val = '男';
			break;
		case 2:
			val = '女';
			break;
		default:
			break;
		}
    return val;
  };
});

var indexApp=angular.module('indexApp', ['ui.router','phonecatFilters','ui.bootstrap','tm.pagination','ngCookies','pascalprecht.translate',
'homeApp','offerApp','seekApp','seek2App','seek3App','newsApp','newsContentApp','aboutApp','openApp','userCenterInfoApp','userCenterOfferListApp','userCenterSeekListApp','registerApp','loginApp','passwordRecoveryApp','passwordRecovery2App','projectApp','contributeApp','customServiceApp','customServiceContentApp','volunteerRegistrationApp']).config(
		function($stateProvider, $urlRouterProvider) {
			$urlRouterProvider.otherwise('/home');
			$stateProvider.state('home', {//首页
				url : '/home',
				templateUrl : '002_home.html',
				cache:'false',
				controller: 'homeController'				
			}).state('offer', {//我要奉先				
				url : '/offer/:flag',/*/{childData}*/
				templateUrl : '003_offer.html',
				cache:'false',
				controller : 'offerController'
			}).state('seek', {//在线求助1			
				url : '/seek',
				templateUrl : '004_seek.html',
				cache:'false',
				controller : 'seekController'
			}).state('seek2', {//在线求助第二步			
				url : '/seek2',
				templateUrl : '004_seek2.html',
				cache:'false',
				controller : 'seek2Controller'
			}).state('seek3', {//在线求助第三步		
				url : '/seek3',
				templateUrl : '004_seek3.html',
				cache:'false',
				controller : 'seek3Controller'
			}).state('news', {//新闻	
				url : '/news',
				templateUrl : '005_news.html',
				cache:'false',
				controller : 'newsController'
			}).state('newsContent', {//新闻内容
				url : '/newsContent/:id',
				templateUrl : '005_newsContent.html',
				cache:'false',
				controller : 'newsContentController'
			}).state('about', {//关于
				url : '/about',
				templateUrl : '006_about.html',
				cache:'false',
				controller : 'aboutController'
			}).state('open', {//公开透明
				url : '/open',
				templateUrl : '007_open.html',
				cache:'false',
				controller : 'openController'
			}).state('userCenterInfo', {//会员中心-用户信息
				url : '/userCenterInfo',
				templateUrl : '008_userCenterInfo.html',
				cache:'false',
				controller : 'userCenterInfoController'
			}).state('userCenterOfferList', {//会员中心-捐款记录
				url : '/userCenterOfferList',
				templateUrl : '008_userCenterOfferList.html',
				cache:'false',
				controller : 'userCenterOfferListController'
			}).state('userCenterSeekList', {//会员中心-求助记录
				url : '/userCenterSeekList',
				templateUrl : '008_userCenterSeekList.html',
				cache:'false',
				controller : 'userCenterSeekListController'
			}).state('register', {//注册
				url : '/register',
				templateUrl : '009_register.html',
				cache:'false',
				controller : 'registerController'
			}).state('login1', {//登录
				url : '/login/{pageName}',
				templateUrl : '010_login.html',
				cache:'false',
				controller : 'loginController'
			}).state('passwordRecovery', {//密码找回1
				url : '/passwordRecovery',
				templateUrl : '011_passwordRecovery.html',
				cache:'false',
				controller : 'passwordRecoveryController'
			}).state('passwordRecovery2', {//密码找回2
				url : '/passwordRecovery2',
				templateUrl : '011_passwordRecovery2.html',
				cache:'false',
				controller : 'passwordRecovery2Controller'
			}).state('project1', {//进入一个项目
				url : '/project/{id}',
				templateUrl : '012_project.html',
				cache:'false',
				controller : 'projectController'
			}).state('contribute1', {//捐款
				url : '/contribute/:helpId/:contributionType',
				templateUrl : '013_contribute.html',
				cache:'false',
				controller : 'contributeController'
			}).state('customService', {//客服中心
				url : '/customService',
				templateUrl : '014_customService.html',
				cache:'false',
				controller : 'customServiceController'
			}).state('customServiceContent', {//客服中心-问题内容
				url : '/customServiceContent/:id',
				templateUrl : '014_customServiceContent.html',
				cache:'false',
				controller : 'customServiceContentController'
			}).state('volunteerRegistration', {//申请成为志愿者
				url : '/volunteerRegistration',
				templateUrl : '015_volunteerRegistration.html',
				cache:'false',
				controller : 'volunteerRegistrationController'
			});
		})

	.factory('DataInfo', function() {
	return {
		name: "1"
	};
});


indexApp.controller('indexController', function($scope, $http,$cookies, $rootScope,$state,$stateParams) {
	////////////////////////////////////////////////测试数据
	$scope.user = {};
	$scope.gotopage='index';
	$scope.queryText = '';
	$scope.paramTemp = {};


	$scope.saveCookie = function() {
		var expireDate = new Date();
		expireDate.setDate(expireDate.getDate() + 7);
		// Setting a cookie
		$cookies.put("username",$scope.user.username,{'expires': expireDate.toUTCString()});
		//$cookies.put("password",$scope.user.password,{'expires': expireDate.toUTCString()});
		$cookies.put("userid",$scope.user.id,{'expires': expireDate.toUTCString()});
		//$cookies.put("isAutoLogin",$scope.isNextAutoLogin,{'expires': expireDate.toUTCString()});
	};
	//退出
	$scope.loginOut = function() {
		$http({
			method : "PUT",
			async: false,
			url : "../userC/logOut"
		}).success(function(data, status) {
			if (data.success) {
				$scope.$parent.user = {};
				$scope.user = {};
				$cookies.remove("userid");
				$cookies.remove("username");
				$state.go("home", {}, { reload: true });
			}
		}).error(function(data, status) {
			alert('保存失败');
		});
	};
	//判断是否登录
	function checkIsLogin() {

		$http({
			method : "POST",
			url : "../userC/checkLogin"
		}).success(function(data, status) {
			if (data.success) {
				$scope.user = data.result;
			}
		}).error(function(data, status) {
		});
	};

	//检查用户是否登录
	$scope.checkLogin = function() {

		$http({
			method : "POST",
			url : "../userC/checkLogin"
		}).success(function(data, status) {
			if (data.success) {
				$state.go("userCenterInfo", {}, { reload: true });
			} else {
				$state.go("login1", {pageName:"userCenterInfo"}, { reload: true });
			}
		}).error(function(data, status) {
		});
	};

	$scope.checkLoginReturn = function(gotoName, param, page) {
		$http({
			method : "POST",
			async: false,
			url : "../userC/checkLogin"
		}).success(function(data, status) {
			if (data.success) {
				$state.go(gotoName, param, { reload: true });
				$state.go(gotoName, param, { reload: true });
			} else {
				$scope.paramTemp = param;
				$state.go("login1", {pageName:page}, { reload: true });
			}
		}).error(function(data, status) {
		});
	};

	/*$scope.gotoFx = function() {
		$scope.checkLoginReturn("offer", {});
	};*/

	$scope.gotoHelp = function() {

		$scope.checkLoginReturn("seek",{},"seek");
	};




	function init() {
		checkIsLogin();
		var userid   = $cookies.get("userid");
		if (userid) {
			$scope.user.username = $cookies.get("username");
		}
		$scope.show=false;
	}

	//$scope.friends={}; //友情链接
	$scope.friends=[];
	$scope.friends=[{'friendName':'淘宝','href':'http://www.taobao.com/'},{'friendName':'京东','href':'http://www.jd.com/'},{'friendName':'唯品会','href':'http://www.vip.com/'},{'friendName':'百度','href':'http://www.baidu.com/'}];
	/*function queryFriend() {
		var type=2;
		$http({
			url: '../helpC/queryThanks',////
			method: 'POST',
			data: type
		}).success(function (data) {
			$scope.friends = data.rows;
		}).error(function (response) {
		});
	}*/
	///小黑块
	$scope.helpTop1 = {};
	function queryChoukuanTop() {
		var type=1;
		$http({
			url: '../helpC/queryHelpIsTop',
			method: 'POST',
			data: type
		}).success(function (data) {
			$scope.helpTop1 = data;
		}).error(function (response) {
		});
	}

	init();
	//queryFriend();


	//查询孩子
	$scope.querttest = '';
	$scope.showChild = {};
	$scope.queryChild = function(){
		//var queryText = $scope.queryText;
		$scope.querttest = $scope.queryText;
		$state.go("offer", {flag:2}, { reload: true });
		/*$http({
			url: '../helpC/showChild',
			method: 'POST',
			data: queryText
		}).success(function (data) {
			$scope.showChild = data.result.childList;
			
		});*/
	};
	
	
	//跳转offer
	$scope.clickOffer = function(){
		$state.go("offer", {flag:1}, { reload: true });
	};
});





