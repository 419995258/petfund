var huijuAppmodule = angular.module('huijuApp', []);

huijuAppmodule.controller('huijuController', function($scope, $http, $rootScope, $stateParams, $state) {
	
	$scope.pageSize = 10;// 每页多少条
	$scope.pages = 1;// 总页数
	$scope.maxSize = 10; // 一次可现实多少分页标签，超过maxSize后则以...代替
	$scope.totalItems = 1; // 总共多少条记录
	$scope.currentPage = 1; // 当前页码
	$scope.bigTotalItems = 180;
	$scope.bigCurrentPage = 1;
	$scope.type = 2; //类型为汇聚
	var delIdTemp = '';
	var XIdTemp = '';
	var resultVo = {};
	$scope.jkdIndex = ''; // 点击索引
	$scope.xqItems = {}; // 详情弹出框填入的数组
	
	$scope.projectChildItems = {};
	$scope.projectChildItemsMini = {};
	
	$scope.selectItems = [];
	$scope.queryText = '';
	$scope.person = {};
	
	$scope.pictures = {};
	
	var txt1 = '';
	
	var file = false;
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
		if ($state.current.name == 'huiju') {
			$('.menu_btn').removeClass('active');
			$('#huiju').addClass('active');
		};	
		var queryTemp = [{'type':0,'name':'显示全部'},{'type':2,'name':'搜病名'},{'type':3,'name':'搜发起人'}];
		$scope.selectItems = queryTemp;
		$scope.qureyType = queryTemp[0];
		queryHuiJu();
		queryPersions();
	};
	$scope.init();
	
	
	// 查询所有信息
	function queryHuiJu() {
		resultVo.pageSize = $scope.pageSize;
		resultVo.currentpage = $scope.currentPage;
		resultVo.type = $scope.type;
		resultVo.queryType = $scope.qureyType.type;
		resultVo.queryText = $scope.queryText;
		
		// 查询所有信息
		$http({
			method : "POST",
			url : "../helpmanageC/showHuiJuOrChuanDi",
			data : resultVo
		}).success(function(data, status) {
			$scope.projectChildItemsMini = data.rows;
			$scope.currentPage = data.pageNum; // 当前页码
			$scope.pageSize = data.pageSize;// 每页多少条
			$scope.pages = data.pages;// 总页数
			$scope.totalItems = data.total;// 总共多少条记录
			
		}).error(function(data, status) {
		});
	};
	
	$scope.pageChanged = function() {
		queryHuiJu();
	};
	
	
	//置顶
	$scope.openTopPage = function(index) {
		XIdTemp = index;
		$scope.jkdIndex = XIdTemp;
		$scope.projectChildItemsMini.type=2;
		$http({
			method : "PUT",
			url : "../helpmanageC/topHuiJuOrChuanDi",
			data : $scope.projectChildItemsMini[$scope.jkdIndex]
		}).success(function(data, status) {
			XIdTemp = '';
		}).error(function(data, status) {
		});
	};
	
	function queryPersions() {
		var type = 2;
		
		$http({
			method : "POST",
			url : "../baseBizDataC/queryPersons",
			data : type
		}).success(function(data, status) {
			$scope.personInfs = data;
			
			var flag = false;

			for (var i=0; i<data.length; i++) {
				if ($scope.projectChildItems.personId == data[i].id) {
					$scope.person = data[i];
					flag = true;
					break;
				}
			}
			
			if (!flag) {
				$scope.person = data[0];
			}
		}).error(function(data, status) {
		});
	}
	
	//删除确认
	$scope.openDelPage = function(index) {
		delIdTemp = index;
		$('#deleteModal').modal('show');
	};


	$scope.delPic = function (id,path,index) {
		var file = {};
		file.id = id;
		file.fileurl = path;
		
		$http({
			method : "PUT",
			url : "../helpmanageC/delPayFiles",
			data : file,
		}).success(function(data, status) {
			$scope.pictures.splice(index, 1);
		}).error(function(data, status) {
			alert('操作失败');
		});
	};
	
	//	确认删除
	$scope.choseD = function() { // 点击按钮
		$scope.jkdIndex = delIdTemp; // 设置选中行索引

		$http({
			method : "PUT",
			url : "../helpmanageC/deleteHuiJuOrChuanDi",
			data : $scope.projectChildItemsMini[$scope.jkdIndex]
		}).success(function(data, status) {
			$scope.projectChildItemsMini.splice(delIdTemp, 1);
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
			url : "../helpmanageC/showHuiJuOrChuanDiData",
			data : $scope.projectChildItemsMini[$scope.jkdIndex]
		}).success(function(data, status) {
			$scope.projectChildItems = data;
			hjum.setContent($scope.projectChildItems.content);
			XIdTemp = '';
			/*$scope.pictures = $scope.projectChildItems.helpFilesUrl[0];*/
			$scope.pictures = $scope.projectChildItems.helpFilesUrl;
			$('#addModal').modal('show');
		}).error(function(data, status) {
		});
	};
	
	//获取上传数据
	var fileids = [];
	$('#file-5').on('fileuploaded', function(event, data, previewId, index) {
        var response = data.response;
        if (response.success) {
        	file = true;
        	fileids.push(response.fileId);
        	var fileTemp = {};
        	fileTemp.id = response.fileId;
        	fileTemp.fileurl = response.fileUrl;
        	
        	var appElement = document.querySelector("[ng-controller=ordinaryPaymentController]");
        	var $scope = angular.element(appElement).scope(); 
        	$scope.pictures.push(fileTemp);
        	$scope.$apply();
        }
    });
	
	//////////////////////////////////////////////////////////实例化编辑器   
    var hjum = UM.getEditor('hjEditor');  
  
	//切换页面后重新初始化
    $scope.$on('$destroy', function() {
    	hjum.destroy();       
    });
    
  //初始化数据
    $scope.openAddNewsPage = function() {
    	$("#file-5").fileinput('clear');
    	$scope.pictures = {};
    	$scope.projectChildItems={};
    	hjum.ready(function() {
			/*
			 * //设置编辑器的内容 ckum1.setContent('hello'); //获取html内容，返回: <p>hello</p>
			 * var html = ue.getContent();
			 */
			// 获取纯文本内容，返回: hello
    		hjum.setContent('');
		});
    	$('#addModal').modal('show'); 
    	$('#xiugai').hide();
    };
    
    //添加紧急汇聚
	
	$scope.subNew = function() {
		if(sub == true){
		hjum.ready(function() {
			/*
			 * //设置编辑器的内容 ckum1.setContent('hello'); //获取html内容，返回: <p>hello</p>
			 * var html = ue.getContent();
			 */
			// 获取纯文本内容，返回: hello
			txt1 = hjum.getContent();
			$scope.projectChildItems.content = txt1;
		});
		

		$scope.projectChildItems.fileIds = fileids;
		$scope.projectChildItems.type = 2;
		
		if (!verifyIsNull($scope.person.id)) {
			$scope.projectChildItems.personName = $scope.person.realname;
			$scope.projectChildItems.personId = $scope.person.id;
		}
		
		
		if (verifyIsNull($scope.projectChildItems.title)) {
			alert("请填写标题");
			return;
		};
		
		if (verifyIsNull($scope.projectChildItems.childName)) {
			$scope.projectChildItems.childName = "";
		};
		
		if (verifyIsNull($scope.projectChildItems.money)) {
			$scope.projectChildItems.money = 0;
		};
		
		if (verifyIsNull($scope.projectChildItems.moneyOff)) {
			$scope.projectChildItems.moneyOff = 0;
		};
		
	
		if (file!=true) {
			alert("请上传文件");
			return;
		};
		
		
		sub = false;
		$http({
			method : "PUT",
			url : "../helpmanageC/addHuiJuOrChuanDi",
			data : $scope.projectChildItems,
		}).success(function(data, status) {
			if (data.success) {
				$("#file-5").fileinput('clear');
				$scope.pictures = {};
				fileids = [];
				file = false;
				$('#addModal').modal('hide');
				queryHuiJu();
			} else {
				$('#addModal').modal('hide');
			}
			sub = true;
		}).error(function(data, status) {
		});
		}
	};
	
	//更新紧急汇聚
	
	$scope.alter = function() {
		if(sub == true){
		hjum.ready(function() {
			/*
			 * //设置编辑器的内容 ckum1.setContent('hello'); //获取html内容，返回: <p>hello</p>
			 * var html = ue.getContent();
			 */
			// 获取纯文本内容，返回: hello
			txt1 = hjum.getContent();
			$scope.projectChildItems.content = txt1;
		});
		
		
		if(fileids.length!=0){
			$scope.projectChildItems.fileIds = fileids;
			
			if($scope.pictures[0]!=null){
				$scope.projectChildItems.oldFileIds = $scope.pictures[0].id;
			}
		}

	
		
		
		
		
		if (!verifyIsNull($scope.person.id)) {
			$scope.projectChildItems.personName = $scope.person.realname;
			$scope.projectChildItems.personId = $scope.person.id;
		}
		
		if (verifyIsNull($scope.projectChildItems.title)) {
			alert("请填写标题");
			return;
		};
		
		if (verifyIsNull($scope.projectChildItems.childName)) {
			alert("请填写病名");
			return;
		};
		
		if (verifyIsNull($scope.projectChildItems.money)) {
			alert("请填写目标金额");
			return;
		};
		
		if (verifyIsNull($scope.projectChildItems.moneyOff)) {
			alert("请填写完成金额");
			return;
		};
		
	
		
		sub = false;
		$http({
			method : "PUT",
			url : "../helpmanageC/updateHuiJuOrChuanDi",
			data : $scope.projectChildItems,
		}).success(function(data, status) {
			if (data.success) {
				fileids = [];
				$("#file-5").fileinput('clear');
				$scope.pictures = {};
				$scope.projectChildItems = {};
				$('#addModal').modal('hide');
				queryHuiJu();
			} else {
				$('#addModal').modal('hide');
			}
		}).error(function(data, status) {
			alert('保存失败');
		});
		sub = true;
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