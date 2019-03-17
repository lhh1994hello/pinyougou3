app.service('uploadService', function ($http) {
    //上传图片
    this.uploadFile = function () {
        var formData = new FormData();
        formData.append('file', file.files[0]);//file代表文件上传框的name，
        return $http({
            url:'../upload/upload.do',
            method:'post',
            data:formData,
            headers:{'Content-Type':undefined},//默认是json类型
            transformRequest:angular.identifier,//表单二级制序列化
        });
    }
});