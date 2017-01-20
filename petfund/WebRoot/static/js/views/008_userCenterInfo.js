var userCenterInfoAppmodule = angular.module('userCenterInfoApp', []);

userCenterInfoAppmodule.controller('userCenterInfoController', function($scope, $http, $rootScope, $stateParams, $state) {	
	////////////////////////////////////////////////////////判断当前页
	$scope.init = function() {		
		if ($state.current.name == 'userCenterInfo') {
			$('.qz_content > a').removeClass('active');
			$('#btn_userCenter').addClass('active');			
		};	
	};
	$scope.init();
	
	/*
	//从后台查数据/分页
	
	$scope.messsageList = {};
    
    $scope.pageSize = 10;//每页多少条
    $scope.pages = 0;//总页数
    $scope.maxSize = 10; //一次可现实多少分页标签，超过maxSize后则以...代替
    $scope.totalItems = 180;//总共多少条纪录
    $scope.currentPage = 1;//当前页码

    $scope.pageChanged = function () {
        $scope.queryMessage();
    }
   
    $scope.queryMessage = function () {
        $http({
            url: '../messageC/queryMessageByPage',
            method: 'POST',
            params: {pagesize: $scope.pageSize, currentpage: $scope.currentPage},
        }).success(function (data) {
            if (data.success == true) {
                $scope.messsageList = data.result.resultVo.rows;
                $scope.currentPage = data.result.resultVo.pageNum;//当前页码
                $scope.pageSize = data.result.resultVo.pageSize;//每页多少条
                $scope.pages = data.result.resultVo.pages;//总页数
                $scope.totalItems = data.result.resultVo.total;//总条数

            }
            console.log($scope.messsageList);
        }).error(function (response) {
            //处理响应失败
        });
    };
	*/	
	
	////////////////////////////////////////////////////////测试数据
	$scope.userInfo = {};
	//$scope.userInfo = {'head':'../static/img/head_shot.jpg','ID':'keji@126.com','realName':'张三','phoneNum':'13602158458'};

	//查询用户信息
	$scope.queryCurrentUserInfo = function() {
		$http({
			method : "POST",
			url : "../userC/queryUserInfo"
		}).success(function(data, status) {
			$scope.userInfo = data;
		}).error(function(data, status) {
		});
	}

	//修改用户信息
	$scope.saveUserInfo = function () {
/*		delIdTemp = index;*/
		$('#deleteModal').modal('show');
		if(verifyIsNull($("#upload").val())){
			$http({
	            url: '../userC/updateUserInfo',
	            method: 'PUT',
	            data: $scope.userInfo
	        }).success(function (data) {
	            if (data.success == true) {
	            	if (data.success == true) {
	                	$scope.$parent.user = data.result.user;
	                	$scope.$parent.saveCookie();
	                	angular.extend($scope.userInfo, data.result.user);
	                	//$scope.$apply();
	                }
	            }
	        }).error(function (response) {
	            //处理响应失败
	        });
		} else {
			var formData = new FormData($( "#uploadForm" )[0]);
			$.ajax({  
		          url: '../userC/updateUserInfoAndHard' ,  
		          type: 'POST',  
		          data: formData,  
		          contentType: false,  
		          processData: false,  
		          success: function (data) {  
		        	  if (data.success == true) {
		                	$scope.$parent.user = data.result.user;
		                	$scope.$parent.saveCookie();
		                	angular.extend($scope.userInfo, data.result.user);
		                	$scope.$apply();
		                	//$state.go("userCenterInfo", {}, {reload: true});
		                } 
		          },  
		          error: function (returndata) {  
		          }  
		     });
		}
			
		/*$.ajax({  
	          url: '../userC/updateUserInfo' ,  
	          type: 'POST',  
	          data: formData,  
	          contentType: false,  
	          processData: false,  
	          success: function (data) {  
	        	  if (data.success == true) {
	                	$scope.$parent.user = data.result.user;
	                	$scope.$parent.saveCookie();
	                	angular.extend($scope.userInfo, data.result.user);
	                	$scope.$apply();
	                	//$state.go("userCenterInfo", {}, {reload: true});
	                } 
	          },  
	          error: function (returndata) {  
	          }  
	     });*/
        /*if($("#upload").val()){//如果选择了文件，则进行异步文件上传
            $("#uploadForm").ajaxSubmit({
                type:'post',
                url:'../userc/updateUserInfo',
                success:function(data){
                    if (data.success == true) {
                    	$scope.$parent.user = data.result.user;
                    	$state.go("userCenterInfo", {}, {reload: true});
                    } else if(data.message == 'errorimgType'){
                        $('#alertBody').html(TranslateScript.translate('UPLOAD_ICON_MUST_IMAGE'));
                        $('#alertModal').modal('show');
                    }
                },
                error:function(XmlHttpRequest,textStatus,errorThrown){
                }
            });
        } else {                              //如果没有选择文件，则只异步提交表单数据
            $http({
                url: '../userc/updateUserInfo',
                method: 'post',
                params: $scope.userInfo,
            }).success(function (data) {
                if (data.success == true) {
                	$scope.$parent.user = data.result.user;
                	$state.go("userCenterInfo", {}, {reload: true});
                }
            }).error(function (response) {
                $('#alertBody').html(TranslateScript.translate('SAVE_ERROR'));
                $('#alertModal').modal('show');
            });
        }*/
    }
	
	$scope.queryCurrentUserInfo();
});