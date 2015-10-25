angular.module('app', ['ngAnimate', 'ui.bootstrap']);
angular.module('app').controller('ctrl', function ($scope, $http) {
    $scope.messages = 'Hello World!!!';
    $scope.log = {
        logDate : new Date(),
        logType: 'Register1',
        atr1 : 'atr1',
        atr2:'atr2',
        atr3:'atr3'
    };


    $scope.send = function(){
        $http.post("/ZST/rest/log", $scope.log)
            .success(function (response) {
                $scope.messages = response;
            }).error(function (response) {
                console.log( response );
                $scope.messages = response;
            });
    };

});