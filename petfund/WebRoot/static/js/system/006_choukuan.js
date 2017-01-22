var choukuanAppmodule = angular.module('choukuanApp', []);

choukuanAppmodule.controller('choukuanController', function($scope, $http,
		$rootScope, $stateParams, $state) {

	
	var file = false;
	var sub = true;
	
	$scope.pageSize = 10;// 每页多少条
	$scope.pages = 1;// 总页数
	$scope.maxSize = 10; // 一次可现实多少分页标签，超过maxSize后则以...代替
	$scope.totalItems = 1; // 总共多少条记录
	$scope.currentPage = 1; // 当前页码
	$scope.bigTotalItems = 180;
	$scope.bigCurrentPage = 1;
	var delIdTemp = '';
	var XIdTemp = '';
	var resultVo = {};
	$scope.jkdIndex = ''; // 点击索引
	$scope.xqItems = {}; // 详情弹出框填入的数组
	
	$scope.projectChildItems = {};
	$scope.projectChildItemsMini = {};
	
	$scope.pictures = {};
	
	$scope.selectItems = [];
	$scope.queryText = '';
	$scope.person = {};
	
	var txt1 = '';
	var txt2 = '';
	var txt3 = '';
	
	
	
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
	// //////////////////////////////////////////////////////判断当前页
	$scope.init = function() {
		if ($state.current.name == 'choukuan') {
			$('.menu_btn').removeClass('active');
			$('#choukuan').addClass('active');
		};
		var queryTemp = [{'type':0,'name':'显示全部'},{'type':2,'name':'搜宠物姓名'},{'type':3,'name':'搜发起人'}];
		$scope.selectItems = queryTemp;
		$scope.qureyType = queryTemp[0];
		queryChouKuan();
		queryPersions();
	};
	$scope.init();

	
	function queryChouKuan() {
		resultVo.pageSize = $scope.pageSize;
		resultVo.currentpage = $scope.currentPage;
		
		resultVo.queryType = $scope.qureyType.type;
		resultVo.queryText = $scope.queryText;
		// 查询所有信息
		$http({
			method : "POST",
			url : "../helpmanageC/showChouKuan",
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
		queryChouKuan();
	};
	
	$scope.personInfs = [];
	
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


	
	//	确认删除
	$scope.choseD = function() { // 点击按钮
		$scope.jkdIndex = delIdTemp; // 设置选中行索引

		$http({
			method : "PUT",
			url : "../helpmanageC/deleteChouKuan",
			data : $scope.projectChildItemsMini[$scope.jkdIndex]
		}).success(function(data, status) {
			$scope.projectChildItemsMini.splice(delIdTemp, 1);
			delIdTemp = '';
			$('#deleteModal').modal('hide');
		}).error(function(data, status) {
		});

	};
	
	
	//置顶
	$scope.openTopPage = function(index) {
		XIdTemp = index;
		$scope.jkdIndex = XIdTemp;
		$http({
			method : "PUT",
			url : "../helpmanageC/topChouKuan",
			data : $scope.projectChildItemsMini[$scope.jkdIndex]
		}).success(function(data, status) {
			XIdTemp = '';
		}).error(function(data, status) {
		});
	};
	
	//查看详情
	$scope.openXPage = function(index) {
		XIdTemp = index;
		$scope.jkdIndex = XIdTemp;
		$http({
			method : "POST",
			url : "../helpmanageC/showChouKuanData",
			data : $scope.projectChildItemsMini[$scope.jkdIndex]
		}).success(function(data, status) {
			$scope.projectChildItems = data;
			ckum1.setContent($scope.projectChildItems.content);
			ckum2.setContent($scope.projectChildItems.caseInfo);
			ckum3.setContent($scope.projectChildItems.thanks);
			XIdTemp = '';
			/*$scope.pictures = $scope.projectChildItems.helpFilesUrl[0];*/
			$scope.pictures = $scope.projectChildItems.helpFilesUrl;
			queryPersions();
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
        	
        	/*var fileTemp = {};
        	fileTemp.id = response.fileId;
        	fileTemp.fileurl = response.fileUrl;
        	
        	var appElement = document.querySelector("[ng-controller=ordinaryPaymentController]");
        	var $scope = angular.element(appElement).scope(); 
        	$scope.pictures.push(fileTemp);
        	$scope.$apply();*/
        }
    });
	
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
	
	// //////////////////////////////////////////////////////测试数据

	/* $scope.projectChildItems=[{'date':'2016-10-02','img':'../static/img/06.jpg','title':'家中贫困求帮助a','name':'赵某某a','sex':'男','age':'3','place':'天津','targetMoney':'100000','needMoney':'72030.54','peopleNum':'502','organiser':'斯蒂芬','initiateNum':'10'}]; */

	// ////////////////////////////////////////////////////////实例化编辑器
	var ckum1 = UM.getEditor('ckEditor1');
	var ckum2 = UM.getEditor('ckEditor2');
	var ckum3 = UM.getEditor('ckEditor3');

	// 切换页面后重新初始化
	$scope.$on('$destroy', function() {
		ckum1.destroy();
		ckum2.destroy();
		ckum3.destroy();
	});
	
	
    
    $scope.openAddNewsPage = function() {
    	$("#file-5").fileinput('clear');
    	$scope.pictures = {};
    	$scope.projectChildItems={};
    	ckum1.ready(function() {
			/*
			 * //设置编辑器的内容 ckum1.setContent('hello'); //获取html内容，返回: <p>hello</p>
			 * var html = ue.getContent();
			 */
			// 获取纯文本内容，返回: hello
    		ckum1.setContent('');
		});
    	ckum2.ready(function() {
			/*
			 * //设置编辑器的内容 ckum1.setContent('hello'); //获取html内容，返回: <p>hello</p>
			 * var html = ue.getContent();
			 */
			// 获取纯文本内容，返回: hello
    		ckum2.setContent('');
		});
    	ckum3.ready(function() {
			/*
			 * //设置编辑器的内容 ckum1.setContent('hello'); //获取html内容，返回: <p>hello</p>
			 * var html = ue.getContent();
			 */
			// 获取纯文本内容，返回: hello
    		ckum3.setContent('');
		});
    	$('#addModal').modal('show'); 
    	$('#xiugai').hide();
    };
    
    
	//添加紧急汇聚
	
	$scope.subNew = function() {
		if(sub == true){
			
		ckum1.ready(function() {
			/*
			 * //设置编辑器的内容 ckum1.setContent('hello'); //获取html内容，返回: <p>hello</p>
			 * var html = ue.getContent();
			 */
			// 获取纯文本内容，返回: hello
			txt1 = ckum1.getContent();
			$scope.projectChildItems.content = txt1;
		});
		ckum2.ready(function() {
			txt2 = ckum1.getContent();
			$scope.projectChildItems.caseInfo = txt2;
		});
		ckum3.ready(function() {
			txt3 = ckum1.getContent();
			$scope.projectChildItems.thanks = txt3;
		});

		
		if (!verifyIsNull($scope.person.id)) {
			$scope.projectChildItems.personName = $scope.person.realname;
			$scope.projectChildItems.personId = $scope.person.id;
		}
		
		$scope.projectChildItems.fileIds = fileids;
		
		
		
		if (verifyIsNull($scope.projectChildItems.title)) {
			alert("请填写标题");
			return;
		};
		
		if (verifyIsNull($scope.projectChildItems.childName)) {
			alert("请填写孩子姓名");
			return;
		};
		if (verifyIsNull($scope.projectChildItems.age)) {
			alert("请填写年龄");
			return;
		};
		
		if (verifyIsNull($scope.projectChildItems.cityNum)) {
			alert("请填写城市");
			return;
		};

		if (verifyIsNull($scope.projectChildItems.money) && $scope.projectChildItems.money < 0) {
			alert("请填写目标金额");
			return;
		};

		if (verifyIsNull($scope.projectChildItems.moneyOff) && $scope.projectChildItems.moneyOff < 0) {
			alert("请填写完成金额");
			return;
		};
		
		
		
		if (file!=true) {
			alert("请上传文件");
			return;
		};
		
		if($scope.projectChildItems.sex !=1 && $scope.projectChildItems.sex !=2){
			alert("请选择性别");
			return;
		}
		sub = false;
		$http({
			method : "PUT",
			url : "../helpmanageC/addChouKuan",
			data : $scope.projectChildItems,
		}).success(function(data, status) {
			if (data.success) {
				$("#file-5").fileinput('clear');
				$scope.pictures = {};
				fileids = [];
				$('#addModal').modal('hide');
				queryChouKuan();
				sub=true;
			} else {
				$('#addModal').modal('hide');
				sub=true;
			}
			file = false;
		}).error(function(data, status) {
			alert('保存失败');
		});
		}
	};
	
	//更新紧急汇聚
	
	$scope.alter = function() {
		if(sub == true){
		/*if (verifyIsNull($scope.projectChildItems.registerFile)) {
			alert("请选择图片");
			return;
		};*/

		ckum1.ready(function() {
			/*
			 * //设置编辑器的内容 ckum1.setContent('hello'); //获取html内容，返回: <p>hello</p>
			 * var html = ue.getContent();
			 */
			// 获取纯文本内容，返回: hello
			txt1 = ckum1.getContent();
			$scope.projectChildItems.content = txt1;
		});
		ckum2.ready(function() {
			txt2 = ckum2.getContent();
			$scope.projectChildItems.caseInfo = txt2;
		});
		ckum3.ready(function() {
			txt3 = ckum3.getContent();
			$scope.projectChildItems.thanks = txt3;
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

		//判断
		if (verifyIsNull($scope.projectChildItems.title)) {
			alert("请填写标题");
			return;
		};
		
		if (verifyIsNull($scope.projectChildItems.childName)) {
			alert("请填写孩子姓名");
			return;
		};
		if (verifyIsNull($scope.projectChildItems.age)) {
			alert("请填写年龄");
			return;
		};
		
		if (verifyIsNull($scope.projectChildItems.cityNum)) {
			alert("请填写城市");
			return;
		};

		if (verifyIsNull($scope.projectChildItems.money)  && $scope.projectChildItems.money < 0) {
			alert("请填写目标金额");
			return;
		};

		if (verifyIsNull($scope.projectChildItems.moneyOff)  && $scope.projectChildItems.moneyOff < 0) {
			alert("请填写完成金额");
			return;
		};
		
	


		if($scope.projectChildItems.sex !=1 && $scope.projectChildItems.sex !=2){
			alert("请选择性别");
			return;
		}
		
		sub = false;
		$http({
			method : "PUT",
			url : "../helpmanageC/updateChouKuan",
			data : $scope.projectChildItems,
		}).success(function(data, status) {
			if (data.success) {
				fileids = [];
				file = false;
				$("#file-5").fileinput('clear');
				$scope.pictures = {};
				$scope.projectChildItems = {};
				$('#addModal').modal('hide');
				queryChouKuan();
			} else {
				$('#addModal').modal('hide');
			}
			sub = true;
		}).error(function(data, status) {
		});
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
	}
});