var aboutAppmodule = angular.module('aboutApp', []);

aboutAppmodule.controller('aboutController', function($scope, $http, $rootScope, $stateParams, $state,$sce) {
	////////////////////////////////////////////////////////判断当前页	
	function init() {		
		if ($state.current.name == 'about') {
			$('.qz_content > a').removeClass('active');
			$('#btn_about').addClass('active');
		};
		
		queryNewsById();
	};
	
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

	//$scope.aboutC = {'title':'关于心羽基金','texts':'在国务院新闻办29日举行的发布会上，水利部副部长、国家防汛抗旱总指挥部秘书长刘宁指出，今年全国有222条河流发生超警洪水，为近5年同期最多，有26条河流发生超保洪水，6条河流发生超历史洪水，主要江河共出现23次洪水过程，洪水总量较常年偏多34%。今年南方地区先后出现20多次强降雨过程，为近5年同期最多，全国降水量比多年同期多23%，列建国以来第2位，最大点日雨量达493毫米。截至6月28日统计，今年以来全国已有23省（区、市）不同程度遭受洪涝灾害。水利基础设施、防洪工程体系和非工程体系的有效运用，以及各部门及时有效的防汛抗洪工作，使得目前整体受灾情况较轻。截至6月28日统计，受灾人口、死亡人口、受灾面积和倒塌房屋分别比2000年以来同期均值偏少43%、45%、23%和77%。受灾区域主要集中在南方地区。但今年的防汛形势仍然十分严峻。刘宁表示，受超强厄尔尼诺事件影响，气候水文形势复杂多变，江淮、松辽、太湖等流域有发生较大洪水的可能，中小河流洪水、山洪灾害、城市内涝可能多发，登陆台风强度偏强，可能深入内陆，防汛形势严峻。在国务院新闻办29日举行的发布会上，水利部副部长、国家防汛抗旱总指挥部秘书长刘宁指出，今年全国有222条河流发生超警洪水，为近5年同期最多，有26条河流发生超保洪水，6条河流发生超历史洪水，主要江河共出现23次洪水过程，洪水总量较常年偏多34%。今年南方地区先后出现20多次强降雨过程，为近5年同期最多，全国降水量比多年同期多23%，列建国以来第2位，最大点日雨量达493毫米。截至6月28日统计，今年以来全国已有23省（区、市）不同程度遭受洪涝灾害。水利基础设施、防洪工程体系和非工程体系的有效运用，以及各部门及时有效的防汛抗洪工作，使得目前整体受灾情况较轻。截至6月28日统计，受灾人口、死亡人口、受灾面积和倒塌房屋分别比2000年以来同期均值偏少43%、45%、23%和77%。受灾区域主要集中在南方地区。但今年的防汛形势仍然十分严峻。刘宁表示，受超强厄尔尼诺事件影响，气候水文形势复杂多变，江淮、松辽、太湖等流域有发生较大洪水的可能，中小河流洪水、山洪灾害、城市内涝可能多发，登陆台风强度偏强，可能深入内陆，防汛形势严峻。在国务院新闻办29日举行的发布会上，水利部副部长、国家防汛抗旱总指挥部秘书长刘宁指出，今年全国有222条河流发生超警洪水，为近5年同期最多，有26条河流发生超保洪水，6条河流发生超历史洪水，主要江河共出现23次洪水过程，洪水总量较常年偏多34%。今年南方地区先后出现20多次强降雨过程，为近5年同期最多，全国降水量比多年同期多23%，列建国以来第2位，最大点日雨量达493毫米。截至6月28日统计，今年以来全国已有23省（区、市）不同程度遭受洪涝灾害。水利基础设施、防洪工程体系和非工程体系的有效运用，以及各部门及时有效的防汛抗洪工作，使得目前整体受灾情况较轻。截至6月28日统计，受灾人口、死亡人口、受灾面积和倒塌房屋分别比2000年以来同期均值偏少43%、45%、23%和77%。受灾区域主要集中在南方地区。但今年的防汛形势仍然十分严峻。刘宁表示，受超强厄尔尼诺事件影响，气候水文形势复杂多变，江淮、松辽、太湖等流域有发生较大洪水的可能，中小河流洪水、山洪灾害、城市内涝可能多发，登陆台风强度偏强，可能深入内陆，防汛形势严峻。今年以来全国已有23省（区、市）不同程度遭受洪涝灾害。水利基础设施、防洪工程体系和非工程体系的有效运用，以及各部门及时有效的防汛抗洪工作，使得目前整体受灾情况较轻。截至6月28日统计，受灾人口、死亡人口、受灾面积和倒塌房屋分别比2000年以来同期均值偏少43%、45%、23%和77%。受灾区域主要集中在南方地区。但今年的防汛形势仍然十分严峻。刘宁表示，受超强厄尔尼诺事件影响，气候水文形势复杂多变，江淮、松辽、太湖等流域有发生较大洪水的可能，中小河流洪水、山洪灾害、城市内涝可能多发，登陆台风强度偏强，可能深入内陆，防汛形势严峻。在国务院新闻办29日举行的发布会上，水利部副部长、国家防汛抗旱总指挥部秘书长刘宁指出，今年全国有222条河流发生超警洪水，为近5年同期最多，有26条河流发生超保洪水，6条河流发生超历史洪水，主要江河共出现23次洪水过程，洪水总量较常年偏多34%。今年南方地区先后出现20多次强降雨过程，为近5年同期最多，全国降水量比多年同期多23%，列建国以来第2位，最大点日雨量达493毫米。截至6月28日统计，今年以来全国已有23省（区、市）不同程度遭受洪涝灾害。水利基础设施、防洪工程体系和非工程体系的有效运用，以及各部门及时有效的防汛抗洪工作，使得目前整体受灾情况较轻。截至6月28日统计，受灾人口、死亡人口、受灾面积和倒塌房屋分别比2000年以来同期均值偏少43%、45%、23%和77%。受灾区域主要集中在南方地区。但今年的防汛形势仍然十分严峻。刘宁表示，受超强厄尔尼诺事件影响，气候水文形势复杂多变，江淮、松辽、太湖等流域有发生较大洪水的可能，中小河流洪水、山洪灾害、城市内涝可能多发，登陆台风强度偏强，可能深入内陆，防汛形势严峻。'};
	$scope.aboutC = {};
	function queryNewsById() {
		var param = {};
        $http({
            url: '../othermanageC/showAboutData',
            method: 'POST',
            data: param
        }).success(function (data) {
			if (!verifyIsNull(data.content)) {
				data.content = $sce.trustAsHtml(data.content);
			}
        	$scope.aboutC = data;
        }).error(function (response) {
        });
    };


/*
	$scope.newsC = {};
	var newsId = $stateParams.id;
	function queryNewsById() {
		$http({
			url: '../newsC/queryInfo',
			method: 'POST',
			data: newsId
		}).success(function (data) {
			if (!verifyIsNull(data.content)) {
				data.content = $sce.trustAsHtml(data.content);
			}

			$scope.newsC = data;
		}).error(function (response) {
		});
	};*/


	init();
});