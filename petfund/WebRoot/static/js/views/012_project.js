var projectAppmodule = angular.module('projectApp', ['ngSanitize']);

projectAppmodule.controller('projectController', function($scope,$http,$rootScope,$stateParams,$state,$sce) {
	var tempId =1;
	tempId=$stateParams.id;
	var helpId=tempId
	$scope.type=1

	////////////////////////////////////////////////////////判断当前页
	$scope.init = function() {		
		if ($state.current.name == 'project') {
			$('.qz_content > a').removeClass('active');
			$('#btn_offer').addClass('active');			
		};

		queryDetail();
/*		$scope.checktype=1*/
	};


	function queryDetail() {
		$http({
			url: '../helpC/queryHelpById',
			method: 'POST',
			data: helpId

		}).success(function (data) {
			if (!verifyIsNull(data.id)) {
				data.content = $sce.trustAsHtml(data.content);
				data.caseInfo = $sce.trustAsHtml(data.caseInfo);
				data.thanks = $sce.trustAsHtml(data.thanks);
				$scope.type=data.type
			}
			$scope.projectChildItems = data;
		}).error(function (response) {
		});
	}

	$scope.jk = function (id) {
		var param = {};
		param.helpId = id;
		param.contributionType = 1;

		$scope.$parent.checkLoginReturn("contribute1", param);
	};


	$scope.init();

	/*$scope.toUrl = function(url) {
		url = "http://"+url;
		window.location.href=url;
	};*/
});