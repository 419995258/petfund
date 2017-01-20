var customServiceContentAppmodule = angular.module('customServiceContentApp', []);

customServiceContentAppmodule.controller('customServiceContentController', function($scope, $http, $rootScope, $stateParams, $state,$sce) {
	var id = $stateParams.id;
	
	////////////////////////////////////////////////////////判断当前页	
	$scope.newsC = {};
	$scope.init = function() {		
		if ($state.current.name == 'customServiceContent') {
			$('.qz_content > a').removeClass('active');
			$('#btn_about').addClass('active');
		};	
		queryMessage();
	};
	$scope.init();
	

	
	 function queryMessage() {
	        $http({
	            url: '../customC/showCustomServiceData',
	            method: "POST",
	            data: id,
	        }).success(function (data) {
	        	if (!verifyIsNull(data.content)) {
					data.content = $sce.trustAsHtml(data.content);
				}
	              $scope.newsC = data;
	    });
	 };
	
	

	

});