app.controller('indexController', function ($scope, $controller, loginService) {
   // $controller('baseController', {$scope: $scope});//继承

    //显示当前用户名
    $scope.showLoginName = function () {
        loginService.loginName().success(
            function (response) {
                if(response==null){
                    $scope.loginName="";
                    return;
                }
                $scope.loginName = response.loginName;
            }
        );
    }

});