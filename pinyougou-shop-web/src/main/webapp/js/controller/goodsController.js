 //控制层 
app.controller('goodsController' ,function($scope,$controller   ,goodsService, uploadService,itemCatService,typeTemplateService){
	
	$controller('baseController',{$scope:$scope});//继承
	
    //读取列表数据绑定到表单中  
	$scope.findAll=function(){
		goodsService.findAll().success(
			function(response){
				$scope.list=response;
			}			
		);
	}    
	
	//分页
	$scope.findPage=function(page,rows){			
		goodsService.findPage(page,rows).success(
			function(response){
				$scope.list=response.rows;	
				$scope.paginationConf.totalItems=response.total;//更新总记录数
			}			
		);
	}
	
	//查询实体 
	$scope.findOne=function(id){				
		goodsService.findOne(id).success(
			function(response){
				$scope.entity= response;					
			}
		);				
	}
	
	//保存
    $scope.save=function(){
        var serviceObject;//服务层对象
        if($scope.entity.id!=null){//如果有ID
            serviceObject=goodsService.update( $scope.entity ); //修改
        }else{
            serviceObject=goodsService.add( $scope.entity  );//增加
        }
        serviceObject.success(
            function(response){
                if(response.success){
                    //重新查询
                    $scope.reloadList();//重新加载
                }else{
                    alert(response.message);
                }
            }
        );
    }

    //增加
    $scope.add=function(){
	    debugger;
	    $scope.entity.goodsDesc.introduction=editor.html();
        goodsService.add($scope.entity).success(
            function(response){
                if(response.success){
                     alert("新增成功");
                     $scope.entity={};//清空表单区域
                }else{
                    alert(response.message);
                }
            }
        );
    }
	
	 
	//批量删除 
	$scope.dele=function(){			
		//获取选中的复选框			
		goodsService.dele( $scope.selectIds ).success(
			function(response){
				if(response.success){
					$scope.reloadList();//刷新列表
					$scope.selectIds=[];
				}						
			}		
		);				
	}
	
	$scope.searchEntity={};//定义搜索对象 
	
	//搜索
	$scope.search=function(page,rows){			
		goodsService.search(page,rows,$scope.searchEntity).success(
			function(response){
				$scope.list=response.rows;	
				$scope.paginationConf.totalItems=response.total;//更新总记录数
			}			
		);
	}

    //上传图片
	$scope.uploadFile=function () {
        uploadService.uploadFile().success(
            function (response) {
                //设置url
                //alert(response.message);
                if(response.success){
                	console.log("图片路径:"+response.message);
                    $scope.image_entity.url=response.message;
                }else{
                    alert(response.message);
                }
            }
        );
    }
	//定义entity的数据结构
    $scope.entity={goods:{},goodsDesc:{itemImages:[]}};
    //将当前上传的图片实体存入图片实体
    $scope.add_image_entity=function () {
		$scope.entity.goodsDesc.itemImages.push($scope.image_entity);
	}
	//移除图片
	$scope.remove_image_entity=function (index) {
		$scope.entity.goodsDesc.itemImages.splice(index,1);
	}
	//查询一级商品分类列表
	$scope.selectItemCat1List=function () {
		itemCatService.findByParentId(0).success(
			function (response) {
				$scope.itemCat1List=response;
			}
		)
	}
	//当变量改变后触发事件,查询二级商品分类列表列表
	$scope.$watch('entity.goods.category1Id',function (newValue,oldValue) {
		if (newValue==undefined||newValue==''){
			console.log("newValue为空1");
			return;
		}
		itemCatService.findByParentId(newValue).success(
			function (response) {
				$scope.itemCat2List=response;
			}
		)
	})
	//当变量改变后触发事件,查询三级商品分类列表列表
	$scope.$watch('entity.goods.category2Id',function (newValue,oldValue) {
		if (newValue==undefined||newValue==''){
			console.log("newValue为空2");
			return;
		}
		itemCatService.findByParentId(newValue).success(
			function (response) {
				$scope.itemCat3List=response;
			}
		)
	})
	//读取模板ID
	$scope.$watch('entity.goods.category3Id',function (newValue,oldValue) {
		if (newValue==undefined||newValue==''){
			console.log("newValue为空3");
			return;
		}
		 itemCatService.findOne(newValue).success(
		 	function (response) {
		 		$scope.entity.goods.typeTemplateId=response.typeId;
			}
		 )
	})

	//监控模板ID
	$scope.$watch('entity.goods.typeTemplateId',function (newValue,oldValue) {
		if (newValue==undefined||newValue==''){
			console.log("newValue为空4");
			return;
		}
		typeTemplateService.findOne(newValue).success(
			function (response) {
				$scope.typeTemplate=response;//模板对象
				console.log($scope.typeTemplate.brandIds);
				debugger;
				$scope.typeTemplate.brandIds=JSON.parse($scope.typeTemplate.brandIds);//品牌列表字符串转JSON对象
			}
		)
	})
});	
