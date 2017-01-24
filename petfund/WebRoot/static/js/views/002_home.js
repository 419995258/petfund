var homeAppmodule = angular.module('homeApp', ['offerApp']);

homeAppmodule.controller('homeController', function($scope, $http, $rootScope, $stateParams, $state) {
	$scope.choukuanShow = []
	$scope.huijuShow = []
	$scope.chuandiShow = []
	$scope.helpTop1=[]
	$scope.helpTop2=[]
	$scope.helpTop3=[]

	////////////////////////////////////////////////////////判断当前页
	function init() {
		if ($state.current.name == 'home') {
			$('.qz_content > a').removeClass('active');
			$('#btn_home').addClass('active');
		}

		queryNews()
		querystatistics()//统计数字
		//置顶
		querySponsor();//合作企业
		queryNewest();
		queryVolunteer();
		queryHelped();//以获得的捐助

		queryHelp(1, $scope.choukuanShow);
		queryHelp(2, $scope.huijuShow);
		queryHelp(3, $scope.chuandiShow);

		queryHelpTop(1, $scope.helpTop1);
		queryHelpTop(2, $scope.helpTop2);
		queryHelpTop(3, $scope.helpTop3);
		//

	/*	query(types);*/

	}
	$scope.newsContent = function(index) {
		$state.go("newsContent", {id:$scope.newsShow[index].id}, { reload: true });
	};
//////////////////////////////////////////////////////
	$scope.newsShow = [];
	var type = 1;


	$scope.changeNews = function(index){
		type=index
		queryNews()
	};
	/*--------------------------------------------------新闻资讯--------------------------------------------------*/
	var queryParamNews = {};//查新闻内四个的
	function queryNews() {
		queryParamNews.type = type;

		$http({
			url: '../newsC/queryNewsIndex',
			method: 'POST',
			data: queryParamNews
		}).success(function (data) {
			$scope.newsShow = data.rows
			$scope.fengmianUrl=data.url
		}).error(function (response) {
		})
	}
/*	function chafengmian(){
		$http({
			url: '../newsC/queryNewsIndex',
			method: 'POST',
			data: queryParamNews
		}).success(function (data) {
			$scope.newsShow = data.rows
			$scope.fengmianUrl=data.message
		}).error(function (response) {
		})
	}*/
	function queryHelp(type) {
		$http({
			url: '../helpC/queryHelpIndex',
			method: 'POST',
			data: type
		}).success(function (data) {
			switch(type) {
				case 1:$scope.choukuanShow = data;
					break;
				case 2:$scope.huijuShow = data;
					break;
				case 3:$scope.chuandiShow = data;
					break;
			}
		}).error(function (response) {
		});
	}

	$scope.detail = function(type, index) {
		var helpid = ''
		switch (type){
			case 1:helpid = $scope.choukuanShow[index].id;
				break;
			case 2:helpid = $scope.huijuShow[index].id;
				break;
			case 3:helpid = $scope.chuandiShow[index].id;
				break;
		}

		if (helpid != '') {
			$state.go("project", {id:helpid}, { reload: true });
		}

	};
///更多
	$scope.clickOffer = function(offer){
		$state.go("offer", {flag:1,offer:offer}, { reload: true });
	};
	/*----------------------------------------------3个置顶---------------------------------------*/
	function queryHelpTop(type) {
		$http({
			url: '../helpC/queryHelpIsTop',
			method: 'POST',
			data: type
		}).success(function (data) {
			switch(type) {
				case 1:$scope.helpTop1 = data;
					break;
				case 2:$scope.helpTop2 = data;
					break;
				case 3:$scope.helpTop3 = data;
					break;
			}
		}).error(function (response) {
		});
	}

	$scope.detailTop = function(type) {
		var id = '';
		switch (type){
			case 1:id = $scope.helpTop1.id;
				break;
			case 2:id = $scope.helpTop2.id;
				break;
			case 3:id = $scope.helpTop3.id;
				break;
		}
		if (id != '') {
			$state.go("project", {id:id}, { reload: true });
		}

	}


	/*-------------------------------------------统计数字---------------------------------*/
	$scope.Items = {};
	$scope.statistics={};
	function querystatistics() {
		$http({
			url: '../helpC/queryMessageIndex',
			method: 'POST',
			data: $scope.Items
		}).success(function (data) {
			$scope.statistics = data;
		}).error(function (response) {
		});
	}

	/*---------------------------------------感恩有你---------------------------------*/

	$scope.partner={}; //感恩有你(合作企业)
	function querySponsor() {
		var type=1;
		$http({
			url: '../helpC/queryThanks',////
			method: 'POST',
			data: type
		}).success(function (data) {
			$scope.partner = data.rows
		}).error(function (response) {
		});
	}
	/*---------------------------------------右边栏志愿者-------------------------------*/
	$scope.volunteer=[]//志愿者
	function queryVolunteer() {
		$http({
			url: '../helpC/queryVol',////
			method: 'POST'
			//data: $scope.Items
		}).success(function (data) {
			if (data.rows!=null) {
				$scope.volunteer = data.rows
			}

		}).error(function (response) {
		});
	}
	/*------------------------------------右边栏最新捐款------------------*/
	$scope.newHelp=[]; //最新捐款
	function queryNewest() {
		$http({
			url: '../helpC/queryLatest',////
			method: 'POST'
			//data: $scope.Items
		}).success(function (data) {
			if (data.rows!=null) {
				$scope.newHelp = data.rows;
			}
		}).error(function (response) {
		});
	}


	/*----------------------------------------右边栏以获得救助的孩子-------------------------------*/
	$scope.helped=[]; //已获得捐助的
	function queryHelped() {
		$http({
			url: '../helpC/queryHelped',////
			method: 'POST'
			//data: $scope.Items
		}).success(function (data) {
			if (data.rows!=null) {
				$scope.helped = data.rows
			}
		}).error(function (response) {
		});
	}
//我要成为志工
	$scope.bevolunteer=function(){
		$scope.isPostulant = $scope.$parent.user.isPostulant;
		if($scope.isPostulant == true){
			alert("您已经是志愿者了！");
		}else{
			$scope.$parent.checkLoginReturn("volunteerRegistration",{},"volunteerRegistration");
		}
	};
	//检查用户是否登录
	$scope.checkLogin = function() {
		$http({
			method : "POST",
			url : "../userC/checkLogin"
		}).success(function(data) {
			if (data.success) {
				$state.go("userCenterInfo", {}, { reload: true });
			} else {
				$state.go("login", {}, { reload: true });
			}
		}).error(function(data, status) {
		});
	};

	$scope.jk = function (id) {
		var param = {};
		param.helpId = id;
		param.contributionType= 1;
		$scope.$parent.checkLoginReturn("contribute1", param,"contribute1")
    };

	$scope.cc = function (id) {
		var param = {};
		param.helpId = id;
		param.contributionType = 2

		$scope.$parent.checkLoginReturn("contribute1", param,"contribute1")
	};

	$scope.dt = function (id) {
		$state.go("project1", {id:id}, { reload: true })
	};

	////////////////////////////////////////////////////////测试数据
	$scope.bannerImgs=[];


	$scope.bannerImgs=['../static/img/banner4.jpg','../static/img/banner5.jpg'];

	$scope.newsImgs=[];//首页四种新闻图片
	$scope.newsImgs=['../static/img/news.jpg','../static/img/01.jpg','../static/img/02.jpg','../static/img/03.jpg'];


	init();
	
	/*$scope.toUrl = function(url) {
		url = "http://"+url;
		window.location.href=url;
	};*/
});