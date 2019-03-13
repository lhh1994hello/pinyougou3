app.controller('baseController',function($scope){
	$scope.selectIds=[];//用户勾选记录的ID集合
	//分页插件配置
	$scope.paginationConf={
		currentPage:1,//当前页码
		totalItems:10,//总记录数
		itemsPerPage:10,//每页记录数
		perPageOptions:[10,20,30,40,50],//分页选项
		//当页码变更后，自动触发的方法
		onChange:function(){
			$scope.reloadList();
            //asdfsdjk
		}
	}
	$scope.reloadList=function(){
		$scope.search($scope.paginationConf.currentPage,$scope.paginationConf.itemsPerPage);
	}
	//在用户勾选复选框的时候调用,获得要删除记录的id
	$scope.updateSelection=function($event,id){
		 if($event.target.checked){				 
			$scope.selectIds.push(id);
		 }else{
			 var index=$scope.selectIds.indexOf(id);//获得元素的索引，
			 $scope.selectIds.splice(index,1);//参数1:移除的位置，参数2:移除的个数
		 }
	}
	
	//
    $scope.jsonToString=function(jsonString,key) {
	    if(jsonString==null||jsonString==""||jsonString==undefined){
	        return "";
        }
        var json = JSON.parse(jsonString);
        var value="";
        for(var i=0;i<json.length;i++){
            if(i>0){
                value=value+",";
            }
            value =value+json[i][key];
        }
        return value;
    }
	
});