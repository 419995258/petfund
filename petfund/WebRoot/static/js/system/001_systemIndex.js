angular.module('phonecatFilters', ['ngCookies', 'pascalprecht.translate']);

var systemIndexApp=angular.module('systemIndexApp', ['ui.router','ui.bootstrap','phonecatFilters','tm.pagination','ngCookies','pascalprecht.translate','systemUserApp','friendLinkApp','thanksApp','publicApp','serviceApp','aboutApp','fengcaiApp','exampleApp','mediaApp','newsApp','passApp','choukuanApp','helpApp','volunteerApp','huijuApp','administratorLogApp'
]).config(
		function($stateProvider, $urlRouterProvider) {
			$urlRouterProvider.otherwise('/systemUser');
			$stateProvider.state('systemUser', {//用户管理
				url : '/systemUser',
				templateUrl : '003_systemUser.html',
				cache:'false',
				controller: 'systemUserController'	
			})
			.state('volunteer',{//志愿者管理
				url:'/volunteer',
				templateUrl:'004_volunteer.html',
				cache:'false',
				controller:'volunteerController'
			})
			
			//求助管理
			.state('help',{//收到的求助
				url:'/help',
				templateUrl:'005_help.html',
				cache:'false',
				controller:'helpController'
			})


			//信息发布
			.state('choukuan',{//紧急筹款
				url:'/choukuan',
				templateUrl:'006_choukuan.html',
				cache:'false',
				controller:'choukuanController'
			})
			.state('huiju',{//将爱汇聚
				url:'/huiju',
				templateUrl:'007_huiju.html',
				cache:'false',
				controller:'huijuController'
			})
			.state('pass',{//让爱传递
				url:'/pass',
				templateUrl:'008_pass.html',
				cache:'false',
				controller:'passController'
			})


			//新闻管理
			.state('news',{//新闻资讯
				url:'/news',
				templateUrl:'009_news.html',
				cache:'false',
				controller:'newsController'
			})
			.state('media',{//媒体报道
				url:'/media',
				templateUrl:'010_media.html',
				cache:'false',
				controller:'mediaController'
			})
			.state('example',{//典型案例
				url:'/example',
				templateUrl:'011_example.html',
				cache:'false',
				controller:'exampleController'
			})
			.state('fengcai',{//志愿风采
				url:'/fengcai',
				templateUrl:'012_fengcai.html',
				cache:'false',
				controller:'fengcaiController'
			})


			//其他信息管理
			.state('about',{//关于心雨基金
				url:'/about',
				templateUrl:'013_about.html',
				cache:'false',
				controller:'aboutController'
			})
			.state('service',{//客服中心
				url:'/service',
				templateUrl:'014_service.html',
				cache:'false',
				controller:'serviceController'
			})
			.state('public',{//公开透明
				url:'/public',
				templateUrl:'015_public.html',
				cache:'false',
				controller:'publicController'
			})
			.state('thanks',{//感恩有你
				url:'/thanks',
				templateUrl:'016_thanks.html',
				cache:'false',
				controller:'thanksController'
			})
			.state('friendLink',{//友情链接
				url:'/friendLink',
				templateUrl:'017_friendLink.html',
				cache:'false',
				controller:'friendLinkController'
			})
			.state('administratorLog',{//管理员登录日志
				url:'/administratorLog',
				templateUrl:'018_administratorLog.html',
				cache:'false',
				controller:'administratorLogController'
			});
		})

	.factory('DataInfo', function() {
	return {
		name: "1"
	};
});


systemIndexApp.controller('systemIndexController', function($scope, $http,$cookies, $rootScope,$state,$stateParams) {
	
});





